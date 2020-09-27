package com.trevorism.gcloud.webapi.controller

import com.trevorism.gcloud.button.model.Button
import com.trevorism.gcloud.button.service.ButtonService
import com.trevorism.gcloud.button.service.DefaultButtonService
import com.trevorism.secure.Roles
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

    private ButtonService buttonService = new DefaultButtonService()

    @ApiOperation(value = "Create a new Button **Secure")
    @POST
    @Secure(Roles.SYSTEM)
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
    @Secure(Roles.USER)
    List<Button> list(){
        buttonService.list()
    }

    @ApiOperation(value = "Update a Button **Secure")
    @PUT
    @Path("{name}")
    @Secure(Roles.SYSTEM)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Button update(@PathParam("name") String name, Button button) {
        buttonService.update(name, button)
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
