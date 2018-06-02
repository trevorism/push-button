package com.trevorism.gcloud.button.service

import com.trevorism.data.Repository
import com.trevorism.gcloud.button.model.Button
import org.junit.Before
import org.junit.Test

/**
 * @author tbrooks
 */
class DefaultButtonServiceTest {

    private ButtonService service

    @Before
    void setup(){
        service = new DefaultButtonService()
        service.repository = createMockRepository()
    }

    @Test
    void testCreate() {
        Button button = new Button(name: "test", id: "15", topicName: "unittest")
        Button created = service.create(button)

        assert created.id == "15"
        assert created.name == "test"
    }

    @Test
    void testGetByName() {
        assert "foo" == service.getByName("foo").name
    }

    @Test
    void testList() {
        def list = service.list()
        assert list
        assert list.size() == 2
    }

    @Test
    void testUpdate() {
        assert "test" == service.update("bar", new Button(name: "test")).name
    }

    @Test
    void testUpdateWithMissingName() {
        assert !service.update("bluegreen", new Button(name: "test"))
    }

    Repository<Button> createMockRepository() {
        return new Repository<Button>() {
            @Override
            List<Button> list() {
                list(null)
            }

            @Override
            List<Button> list(String s) {
                return [new Button(name: "bar"), new Button(name: "foo")]
            }

            @Override
            Button get(String s) {
                get(s, null)
            }

            @Override
            Button get(String name, String s1) {
                return new Button(name: name)
            }

            @Override
            Button create(Button button) {
                create(button, null)
            }

            @Override
            Button create(Button button, String s) {
                return button
            }

            @Override
            Button update(String s, Button button) {
                update(s,button, null)
            }

            @Override
            Button update(String id, Button button, String s1) {
                button.id = id
                return button
            }

            @Override
            Button delete(String s) {
                delete(s, null)
            }

            @Override
            Button delete(String name, String s1) {
                return get(name)
            }

            @Override
            void ping() {

            }
        }
    }
}
