package com.trevorism.gcloud

import com.trevorism.gcloud.button.model.Button
import com.trevorism.http.util.ResponseUtils
import org.apache.http.client.methods.CloseableHttpResponse

/**
 * @author tbrooks
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

ButtonClient buttonClient = new ButtonClient()
String success
String failure

When(~/^a valid button is invoked$/) { ->
    Button button = new Button(name: "acceptanceTest", topicName: "testPushButton", description: "Used just for acceptance tests")
    success = buttonClient.invoke(button)
}

Then(~/^a successful response is returned$/) { ->
    assert success
    assert success.startsWith("{")
}

When(~/^an invalid button is invoked$/) { ->
    Button button = new Button(name: "acceptanceTest", topicName: "", description: "Used just for acceptance tests")
    failure = buttonClient.invoke(button)
}
Then(~/^a failure response is returned$/) { ->
    assert failure
    assert failure.startsWith("<")
}