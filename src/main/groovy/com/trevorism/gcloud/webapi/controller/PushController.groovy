package com.trevorism.gcloud.webapi.controller

import com.trevorism.event.EventProducer
import com.trevorism.event.PingingEventProducer
import com.trevorism.gcloud.button.model.Button
import com.trevorism.https.SecureHttpClientBase
import com.trevorism.https.token.ObtainTokenFromBearerValidators
import com.trevorism.secure.Roles
import com.trevorism.secure.Secure
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation

import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.container.ContainerRequestContext
import javax.ws.rs.core.Context
import javax.ws.rs.core.MediaType
import java.util.logging.Logger

/**
 * @author tbrooks
 */
@Api("Push Operations")
@Path("/push")
class PushController {

    private static final Logger log = Logger.getLogger(PushController.class.name)

    private EventProducer<Map> producer

    @Context
    ContainerRequestContext context

    @ApiOperation(value = "Invoke a button **Secure")
    @POST
    @Path("result")
    @Consumes(MediaType.APPLICATION_JSON)
    @Secure(Roles.USER)
    void invoke(Button button){
        String correlationId = UUID.randomUUID().toString()
        log.info("Pushing button ${button.name} with correlationId: ${correlationId} to topic ${button.topicName}")
        if(!producer)
            producer = new PingingEventProducer<>(new SecureHttpClientBase(new ObtainTokenFromBearerValidators(context)))

        producer.sendEvent(button.topicName, button.parameters, correlationId)
    }

}
