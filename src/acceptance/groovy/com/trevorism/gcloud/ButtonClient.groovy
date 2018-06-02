package com.trevorism.gcloud

import com.trevorism.gcloud.button.model.Button
import com.trevorism.http.headers.HeadersHttpClient
import com.trevorism.http.headers.HeadersJsonHttpClient
import com.trevorism.http.util.ResponseUtils
import com.trevorism.secure.PasswordProvider
import gherkin.deps.com.google.gson.Gson
import gherkin.deps.com.google.gson.GsonBuilder
import gherkin.deps.com.google.gson.reflect.TypeToken

/**
 * @author tbrooks
 */
class ButtonClient {

    HeadersHttpClient client = new HeadersJsonHttpClient()
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create()
    PasswordProvider passwordProvider = new PasswordProvider()

    Button store(Button button) {
        String json = gson.toJson(button)
        String responseJson = ResponseUtils.getEntity client.post("https://click.trevorism.com/api/button", json, ["Authorization": passwordProvider.password])
        gson.fromJson(responseJson, Button)
    }

    List<Button> list() {
        String listJson = ResponseUtils.getEntity client.get("https://click.trevorism.com/api/button", ["Authorization": passwordProvider.password])
        return gson.fromJson(listJson, new TypeToken<List<Button>>() {}.getType())
    }

    Button get(String name) {
        try{
            String json = ResponseUtils.getEntity client.get("https://click.trevorism.com/api/button/${name}", ["Authorization": passwordProvider.password])
            return gson.fromJson(json, Button)
        }catch (ignored){
            return null
        }
    }

    Button delete(String name) {
        try{
            String json = ResponseUtils.getEntity client.delete("https://click.trevorism.com/api/button/${name}", ["Authorization": passwordProvider.password])
            return gson.fromJson(json, Button)
        }catch (ignored){
            return null
        }
    }

    Button update(String name, Button button) {
        String json = gson.toJson(button)
        String responseJson = ResponseUtils.getEntity client.put("https://click.trevorism.com/api/button/${name}", json, ["Authorization": passwordProvider.password])
        return gson.fromJson(responseJson, Button)
    }

    def attemptToStoreInvalid(def invalid){
        String json = gson.toJson(invalid)
        String responseJson = ResponseUtils.getEntity client.post("https://click.trevorism.com/api/button",json, ["Authorization":passwordProvider.password])
        return responseJson
    }
}
