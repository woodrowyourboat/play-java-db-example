package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Product
{
    @Id
    private int productId;
    private String productName;
    private Integer supplierId;
    private Integer categoryId;
    private String quantityPerUnit;
    private BigDecimal unitPrice;
    private Integer unitsInStock;
    private Integer unitsOnOrder;
    private Integer reorderLevel;
    private boolean discontinued;

    public int getProductId()
    {
        return productId;
    }

    public String getProductName()
    {
        return productName;
    }

    public Integer getSupplierId()
    {
        return supplierId;
    }

    public Integer getCategoryId()
    {
        return categoryId;
    }

    public String getQuantityPerUnit()
    {
        return quantityPerUnit;
    }

    public BigDecimal getUnitPrice()
    {
        return unitPrice;
    }

    public Integer getUnitsInStock()
    {
        return unitsInStock;
    }

    public Integer getUnitsOnOrder()
    {
        return unitsOnOrder;
    }

    public Integer getReorderLevel()
    {
        return reorderLevel;
    }

    public boolean isDiscontinued()
    {
        return discontinued;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public void setSupplierId(Integer supplierId)
    {
        this.supplierId = supplierId;
    }

    public void setCategoryId(Integer categoryId)
    {
        this.categoryId = categoryId;
    }

    public void setQuantityPerUnit(String quantityPerUnit)
    {
        this.quantityPerUnit = quantityPerUnit;
    }

    public void setUnitPrice(BigDecimal unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    public void setUnitsInStock(Integer unitsInStock)
    {
        this.unitsInStock = unitsInStock;
    }

    public void setUnitsOnOrder(Integer unitsOnOrder)
    {
        this.unitsOnOrder = unitsOnOrder;
    }

    public void setReorderLevel(Integer reorderLevel)
    {
        this.reorderLevel = reorderLevel;
    }
}
