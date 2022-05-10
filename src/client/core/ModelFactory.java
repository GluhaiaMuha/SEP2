package client.core;

import client.model.Model;
import client.model.ModelManager;

public class ModelFactory
{
    public Model model;

    public Model getModel(){
        if(model==null){
            model = new ModelManager();
        }
        return model;
    }

}
