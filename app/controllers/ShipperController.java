package controllers;

import models.Region;
import models.Shipper;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ShipperController extends Controller
{

    private FormFactory formFactory;
    private JPAApi jpaApi;

    @Inject
    public ShipperController(FormFactory formFactory, JPAApi jpaApi)
    {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
    }
    @Transactional (readOnly = true)

    public Result getShippers()
    {

        List<Shipper> shippers = jpaApi.em().createQuery("SELECT s FROM Shipper s").getResultList();



       // return ok("shippers count: " + shippers.size());
        return ok(views.html.shippers.render(shippers));
    }

    @Transactional (readOnly = true)
    public Result getShipper(int shipperId)
    {
        Shipper shipper = jpaApi.em().createQuery("SELECT s FROM Shipper s WHERE shipperId =:shipperId", Shipper.class)
                                                  .setParameter("shipperId", shipperId).getSingleResult();


        List<Region> regions = jpaApi.em().createQuery("SELECT r FROM Region r ORDER BY regionDescription").getResultList();

        return ok(views.html.shipper.render(shipper, regions));
    }

    @Transactional
    public Result postShipper(int shipperId)
    {
        Shipper shipper = jpaApi.em().createQuery("SELECT s FROM Shipper s WHERE shipperId =:shipperId", Shipper.class)
                .setParameter("shipperId", shipperId).getSingleResult();

        DynamicForm form = formFactory.form().bindFromRequest();
        String phone = form.get("phone");
        BigDecimal costPerPound = new BigDecimal(form.get("costPerPound"));
        int yearFounded = new Integer (form.get("yearFounded"));
        int regionId = new Integer (form.get("regionId"));



        //Date firstPackageShipped = form.get("firstPackageShipped");

        shipper.setPhone(phone);
        shipper.setCostPerPound(costPerPound);
        shipper.setYearFounded(yearFounded);
        shipper.setRegionId(regionId);




        //shipper.setFirstPackageShipped(firstPackageShipped);

        jpaApi.em().persist(shipper);

        return redirect(routes.ShipperController.getShippers());
    }


}
