package com.trevorism.gcloud.button.service

import com.trevorism.gcloud.button.model.Button

/**
 * @author tbrooks
 */
interface ButtonService {

    Button create(Button button)

    Button getByName(String name)

    List<Button> list()

    Button delete(String name)
}
