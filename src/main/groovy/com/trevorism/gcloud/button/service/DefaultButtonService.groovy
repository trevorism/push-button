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
        validateButton(button)
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
        return repository.list().sort {
            it.name
        }
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
        return repository.delete(button?.id)
    }

    private static void validateButton(Button button) {
        if(!button.name)
            throw new RuntimeException("Unable to create button without a name")

        if(button.topicName == null)
            throw new RuntimeException("Topic not specified")

        if(button.topicName.length() < 3)
            throw new RuntimeException("Topic must be at least 3 characters")

        if(button.topicName.length() > 255)
            throw new RuntimeException("Topic must be less than 256 characters")

        if(button.topicName.startsWith("goog"))
            throw new RuntimeException("Topic cannot start with 'goog'")

    }
}
