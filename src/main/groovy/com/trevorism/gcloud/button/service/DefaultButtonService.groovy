package com.trevorism.gcloud.button.service

import com.trevorism.data.PingingDatastoreRepository
import com.trevorism.data.Repository
import com.trevorism.gcloud.button.model.Button

/**
 * @author tbrooks
 */
class DefaultButtonService implements ButtonService{

    private Repository<Button> repository = new PingingDatastoreRepository<>(Button)

    @Override
    Button create(Button button){
        repository.create(button)
    }

    @Override
    Button getByName(String name){
        repository.list().find{
            it.name == name
        }
    }

    @Override
    List<Button> list(){
        return repository.list()
    }

    @Override
    Button update(String name, Button button){
        Button retrieved = getByName(name)
        if(retrieved)
            return repository.update(retrieved.id, button)
        return retrieved
    }

    @Override
    Button delete(String name){
        Button button = getByName(name)
        repository.delete(button?.id)
        return button
    }
}
