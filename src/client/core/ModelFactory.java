package client.core;

import client.model.LibraryModel;
import client.model.LibraryModelManager;

public class ModelFactory
{
  private static ModelFactory instance = new ModelFactory();
  public static ModelFactory getInstance(){
    return instance;
  }

  private LibraryModel modelManager;

  public ModelFactory() {
  }

  public LibraryModel getLibraryModel()
  {
    if (modelManager == null)
    {
      modelManager = new LibraryModelManager(ClientFactory.getInstance().getClient());
    }
    return modelManager;

  }
}
