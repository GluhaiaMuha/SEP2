package client.core;

import client.model.LibraryModel;
import client.model.LibraryModelManager;

public class ModelFactory
{
  private LibraryModel modelManager;
  private ClientFactory clientFactory;

  public ModelFactory(ClientFactory cf)
  {
    this.clientFactory = cf;
  }

  public LibraryModel getLibraryModel()
  {
    if(modelManager == null){
      modelManager = new LibraryModelManager(clientFactory.getClient());
    }
    return modelManager;

  }
