package com.trevorism.gcloud

import com.trevorism.gcloud.button.model.Button

/**
 * @author tbrooks
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

def invalid
def invalidResultJson

ButtonClient buttonClient = new ButtonClient()
Button initialButton
Button createdButton
Button updatedButton
Button deletedButton

Given(~/^a test button is defined$/) { ->
    initialButton = new Button(name: "test", description: "testDesc", topicName: "testPushButton")
}

Given(~/^the button is created$/) { ->
    createdButton = buttonClient.store(initialButton)
}

Then(~/^the button can found by listing all objects$/) { ->
    List<Button> data = buttonClient.list()
    assert data.find{
        it.name == initialButton.name
    }
}

Then(~/^the button can be retrieved by name$/) { ->
    Button result = buttonClient.get(initialButton.name)
    assert result
    assert result.name == initialButton.name
}

When(~/^the button is updated$/) { ->
    Button button = new Button(name: "test", description: "different description")
    updatedButton = buttonClient.update("test", button)
}

Then(~/^the button reflects the update$/) { ->
    assert updatedButton.description == "different description"
    assert updatedButton.topicName == "testPushButton"
}

When(~/^the button is deleted$/) { ->
    deletedButton = buttonClient.delete(initialButton.name)
}

Then(~/^the button cannot be retrieved$/) { ->
    assert deletedButton
    assert deletedButton.name == initialButton.name
    assert !buttonClient.get(initialButton.name)
}

Given(~/^an invalid test button is defined$/) { ->
    invalid = new Button()
}

When(~/^the invalid test button is created$/) { ->
    invalidResultJson = buttonClient.attemptToStoreInvalid(invalid)
}

Then(~/^an error is thrown, indicating the failure$/) { ->
    assert invalidResultJson.contains("Error")
}