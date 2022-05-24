package shared.transferObj;

import java.io.Serializable;

public class CD extends Product implements Serializable
{
  private String name;
  private int capacity;
  private String usage;

  public CD(String hash, String name, int capacity, String usage, int amountInStock)
  {
    super(hash, amountInStock);
    this.name = name;
    this.capacity = capacity;
    this.usage = usage;
  }

  public String getName()
  {
    return name;
  }

  public int getCapacity()
  {
    return capacity;
  }

  public String getUsage()
  {
    return usage;
  }
}
