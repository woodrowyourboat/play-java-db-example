package controllers;

import models.Category;
import models.Product;
import models.Supplier;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

public class ProductController extends Controller
{
    private FormFactory formFactory;
    private JPAApi jpaApi;

    @Inject
    public ProductController(FormFactory formFactory, JPAApi jpaApi)
    {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
    }
    @Transactional (readOnly = true)
    public Result getProducts()
    {
        List<Product> products = jpaApi.em().createQuery("SELECT p from Product p").getResultList();

    return ok(views.html.products.render(products));
    }

    @Transactional (readOnly = true)
    public Result getProduct(int productId)
    {
        Product product = jpaApi.em().createQuery("SELECT p FROM Product p WHERE productId =:productId", Product.class)
                .setParameter("productId", productId).getSingleResult();

        List<Category> categories = jpaApi.em().createQuery("Select c FROM Category c ORDER BY CategoryName").getResultList();

        List<Supplier> suppliers = jpaApi.em().createQuery("Select s FROM Supplier s ORDER BY CompanyName").getResultList();

        return ok(views.html.product.render(product, categories, suppliers));
    }

    @Transactional
    public Result postProduct(int productId)
    {
        Product product = jpaApi.em().createQuery("SELECT p FROM Product p WHERE productId =:productId", Product.class)
                .setParameter("productId", productId).getSingleResult();

        DynamicForm form = formFactory.form().bindFromRequest();
        String productName = form.get("productName");
        int supplierId = new Integer (form.get("supplierId"));
        int categoryId = new Integer(form.get("categoryId"));
        String quantityPerUnit = form.get("quantityPerUnit");
        BigDecimal unitPrice = new BigDecimal(form.get("unitPrice"));
        int unitsInStock = new Integer(form.get("unitsInStock"));
        int unitsOnOrder = new Integer (form.get("unitsOnOrder"));
        int reorderLevel = new Integer (form.get("reorderLevel"));

        product.setProductName(productName);
        product.setSupplierId(supplierId);
        product.setCategoryId(categoryId);
        product.setQuantityPerUnit(quantityPerUnit);
        product.setUnitPrice(unitPrice);
        product.setUnitsInStock(unitsInStock);
        product.setUnitsOnOrder(unitsOnOrder);
        product.setReorderLevel(reorderLevel);

        jpaApi.em().persist(product);


        return redirect(routes.ProductController.getProducts());
    }


}



