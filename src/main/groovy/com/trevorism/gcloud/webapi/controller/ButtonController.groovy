package com.trevorism.gcloud.webapi.controller

import com.google.appengine.repackaged.com.google.gson.Gson
import com.trevorism.gcloud.button.model.Button
import com.trevorism.gcloud.button.model.Mail
import com.trevorism.http.async.AsyncHttpClient
import com.trevorism.http.async.AsyncJsonHttpClient

import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.core.MediaType

/**
 * @author tbrooks
 */
@Path("/button")
class ButtonController {

    @POST
    @Path("result")
    @Consumes(MediaType.APPLICATION_JSON)
    void invoke(Mail button){
        AsyncHttpClient client = new AsyncJsonHttpClient()
        Gson gson = new Gson()
        String json = gson.toJson(button)
        client.post("http://email.datastore.trevorism.com/mail", json )

    }



}
