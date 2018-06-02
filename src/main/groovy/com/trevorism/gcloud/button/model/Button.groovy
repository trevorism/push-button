package com.trevorism.gcloud.button.model

import io.swagger.annotations.ApiModelProperty

/**
 * @author tbrooks
 */
class Button {

    @ApiModelProperty(value = "An id value", dataType = "string", allowableValues = "range[1,2147483647]")
    String id

    @ApiModelProperty(value = "Unique name of the button")
    String name

    @ApiModelProperty(value = "A description of the button")
    String description

    @ApiModelProperty(value = "The topic on which this button will send information")
    String topicName

    @ApiModelProperty(value = "Parameters for the button")
    Map<String,String> parameters = [:]

}
