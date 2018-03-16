package com.trevorism.gcloud.webapi.controller

import com.trevorism.event.DefaultEventProducer
import com.trevorism.event.EventProducer
import com.trevorism.gcloud.button.model.Button
import io.swagger.annotations.Api

import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.core.MediaType

/**
 * @author tbrooks
 */
@Api("Push Operations")
@Path("/push")
class PushController {

    @POST
    @Path("result")
    @Consumes(MediaType.APPLICATION_JSON)
    void invoke(Button button){
        EventProducer<Map> producer = new DefaultEventProducer<>()
        producer.sendCorrelatedEvent(button.name, button.parameters, UUID.randomUUID().toString())

    }

}
