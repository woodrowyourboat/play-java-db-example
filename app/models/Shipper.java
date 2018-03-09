package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Shipper
{
    @Id
    private int shipperId;
    private String companyName;
    private String phone;
    private BigDecimal costPerPound;
    private int yearFounded;
    private Date firstPackageShipped;

    public int getRegionId()
    {
        return regionId;
    }

    public void setRegionId(int regionId)
    {
        this.regionId = regionId;
    }

    private int regionId;

    public int getShipperId()
    {
        return shipperId;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public BigDecimal getCostPerPound()
    {
        return costPerPound;
    }

    public void setCostPerPound(BigDecimal costPerPound)
    {
        this.costPerPound = costPerPound;
    }

    public int getYearFounded()
    {
        return yearFounded;
    }

    public void setYearFounded(int yearFounded)
    {
        this.yearFounded = yearFounded;
    }

    public Date getFirstPackageShipped()
    {
        return firstPackageShipped;
    }

    public void setFirstPackageShipped(Date firstPackageShipped)
    {
        this.firstPackageShipped = firstPackageShipped;
    }
}
