package com.trevorism.gcloud.button.service

import com.trevorism.data.PingingDatastoreRepository
import com.trevorism.data.Repository
import com.trevorism.gcloud.button.model.Button

/**
 * @author tbrooks
 */
class DefaultButtonService implements ButtonService{

    private final Repository<Button> repository = new PingingDatastoreRepository<>(Button)

    Button create(Button button){
        repository.create(button)
    }

    Button getByName(String name){
        repository.list().find{
            it.name == name
        }
    }

    List<Button> list(){
        return repository.list()
    }

    Button delete(String name){
        Button button = getByName(name)
        repository.delete(button.id)
        return button
    }
}
