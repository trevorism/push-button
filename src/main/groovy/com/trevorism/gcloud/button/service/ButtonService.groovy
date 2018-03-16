package com.trevorism.gcloud.button.service

import com.trevorism.gcloud.button.model.Button

/**
 * @author tbrooks
 */
interface ButtonService {

    Button create(Button button)

    Button getByName(String name)

    List<Button> list()

    Button update(String name, Button button)

    Button delete(String name)
}
