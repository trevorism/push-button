package com.trevorism.gcloud.webapi.controller

import com.trevorism.event.EventProducer
import com.trevorism.gcloud.button.model.Button
import org.junit.Test

/**
 * @author tbrooks
 */
class PushControllerTest {

    @Test
    void testInvoke() {
        PushController controller = new PushController()
        def topic, params, cId
        controller.producer = [sendEvent:{topicName, parameters, correlationId ->
            topic = topicName
            params = parameters
            cId =  correlationId
        }] as EventProducer<Map>

        controller.invoke(new Button(topicName: "testTopic", parameters: ["hello":"world"]))

        assert topic == "testTopic"
        assert params
        assert params["hello"] == "world"
        assert cId


    }
}
