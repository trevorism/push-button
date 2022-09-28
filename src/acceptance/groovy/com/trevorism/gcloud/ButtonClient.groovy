package com.trevorism.gcloud

import com.trevorism.gcloud.button.model.Button
import com.trevorism.https.DefaultSecureHttpClient
import com.trevorism.https.SecureHttpClient
import gherkin.deps.com.google.gson.Gson
import gherkin.deps.com.google.gson.GsonBuilder
import gherkin.deps.com.google.gson.reflect.TypeToken

/**
 * @author tbrooks
 */
class ButtonClient {

    SecureHttpClient client = new DefaultSecureHttpClient()
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create()

    String invoke(Button button) {
        try{
            String json = gson.toJson(button)
            return client.post("https://click.trevorism.com/api/push/result", json)
        }catch(Exception e){
            return "{}"
        }
    }

    Button store(Button button) {
        String json = gson.toJson(button)
        String responseJson = client.post("https://click.trevorism.com/api/button", json)
        gson.fromJson(responseJson, Button)
    }

    List<Button> list() {
        String listJson = client.get("https://click.trevorism.com/api/button")
        return gson.fromJson(listJson, new TypeToken<List<Button>>() {}.getType())
    }

    Button get(String name) {
        try{
            String json = client.get("https://click.trevorism.com/api/button/${name}")
            return gson.fromJson(json, Button)
        }catch (ignored){
            return null
        }
    }

    Button delete(String name) {
        try{
            String json = client.delete("https://click.trevorism.com/api/button/${name}")
            return gson.fromJson(json, Button)
        }catch (ignored){
            return null
        }
    }

    Button update(String name, Button button) {
        String json = gson.toJson(button)
        String responseJson = client.put("https://click.trevorism.com/api/button/${name}", json)
        return gson.fromJson(responseJson, Button)
    }

    def attemptToStoreInvalid(def invalid){
        String json = gson.toJson(invalid)
        String responseJson = client.post("https://click.trevorism.com/api/button",json)
        return responseJson
    }
}
