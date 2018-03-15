package com.trevorism.gcloud.webapi.controller

import com.trevorism.gcloud.button.model.Button
import com.trevorism.gcloud.button.service.ButtonService
import com.trevorism.gcloud.button.service.DefaultButtonService
import com.trevorism.secure.Secure
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation

import javax.ws.rs.*
import javax.ws.rs.core.MediaType

/**
 * @author tbrooks
 */
@Api("Button Operations")
@Path("/button")
class ButtonController {

    private final ButtonService buttonService = new DefaultButtonService()


    @ApiOperation(value = "Create a new Button **Secure")
    @POST
    @Secure
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Button create(Button button){
        buttonService.create(button)
    }

    @ApiOperation(value = "View a Button with the {name}")
    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Button getByName(@PathParam("name") String name){
        buttonService.getByName(name)
    }

    @ApiOperation(value = "Get a list of all Buttons")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Button> list(){
        buttonService.list()
    }

    @ApiOperation(value = "Delete a Button with the {name} **Secure")
    @DELETE
    @Secure
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Button delete(@PathParam("name") String name){
        buttonService.delete(name)
    }

}
