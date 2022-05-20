package shared.transferObj;

public class Software extends Product
{
  private String name;
  private String type;
  private double version;
  private String license_type;

  public Software(String hash, String name, String type, double version, String license_type, int amountInStock)
  {
    super(hash, amountInStock);
    this.name = name;
    this.type = type;
    this.version = version;
    this.license_type = license_type;
  }

  public String getName()
  {
    return name;
  }

  public String getType()
  {
    return type;
  }

  public double getVersion()
  {
    return version;
  }

  public String getLicense_type()
  {
    return license_type;
  }
}
