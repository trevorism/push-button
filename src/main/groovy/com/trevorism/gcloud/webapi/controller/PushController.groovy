package com.trevorism.gcloud.webapi.controller

import com.trevorism.event.EventProducer
import com.trevorism.event.PingingEventProducer
import com.trevorism.gcloud.button.model.Button
import io.swagger.annotations.Api

import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.core.MediaType
import java.util.logging.Logger

/**
 * @author tbrooks
 */
@Api("Push Operations")
@Path("/push")
class PushController {

    private static final Logger log = Logger.getLogger(PushController.class.name)

    @POST
    @Path("result")
    @Consumes(MediaType.APPLICATION_JSON)
    void invoke(Button button){
        EventProducer<Map> producer = new PingingEventProducer<>()
        String correlationId = UUID.randomUUID().toString()
        log.info("Pushed Button ${button.name} with correlationId: ${correlationId}")
        producer.sendEvent(button.topicName, button.parameters, correlationId)
    }

}
