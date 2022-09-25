package com.trevorism.gcloud.webapi.controller

import com.trevorism.gcloud.button.model.Button
import com.trevorism.gcloud.button.service.ButtonService
import org.junit.Before
import org.junit.Test

/**
 * @author tbrooks
 */
class ButtonControllerTest {

    private ButtonController controller = new ButtonController()

    @Before
    void setup(){
        controller.buttonService = createMockService()
    }

    @Test
    void testCreate() {
        Button button = new Button(id: 30)
        assert button == controller.create(button)
    }

    @Test
    void testGetByName() {
        assert "foo" == controller.getByName("foo").name
    }

    @Test
    void testList() {
        def list = controller.list()
        assert list
        assert list.size() == 2
    }

    @Test
    void testUpdate() {
        assert "bar" == controller.update("bar", new Button()).name
    }

    @Test
    void testDelete() {
        assert "foo" == controller.delete("foo").name
    }

    private ButtonService createMockService() {
        new ButtonService() {
            @Override
            Button create(Button button) {
                return button
            }

            @Override
            Button getByName(String name) {
                return new Button(name: name)
            }

            @Override
            List<Button> list() {
                return [new Button(), new Button()]
            }

            @Override
            Button update(String name, Button button) {
                button.name = name
                return button
            }

            @Override
            Button delete(String name) {
                return getByName(name)
            }
        }
    }
}
