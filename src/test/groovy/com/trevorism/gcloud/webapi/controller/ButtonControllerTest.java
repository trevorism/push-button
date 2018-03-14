package com.trevorism.gcloud.webapi.controller;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author tbrooks
 */
public class ButtonControllerTest {

    @Test
    public void testInvoke() {
        ButtonController bc = new ButtonController();
        bc.invoke(null);
    }
}