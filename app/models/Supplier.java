package models;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Supplier
{
    @Id
    private int supplierId;
    private String companyName;

    public int getSupplierId()
    {
        return supplierId;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

}

/*@Entity
public class Region
{
    @Id
    private int regionId;
    private String regionDescription;

    public int getRegionId()
    {
        return regionId;
    }

    public String getRegionDescription()
    {
        return regionDescription;
    }
}*/