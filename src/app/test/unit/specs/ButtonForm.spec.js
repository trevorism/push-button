import Vue from 'vue'
import Buefy from 'buefy'
import ButtonForm from '@/components/ButtonForm'

describe('ButtonForm.vue', () => {
  Vue.use(Buefy)

  it('renders its name and description', () => {
    const Constructor = Vue.extend(ButtonForm)
    const button = {name: 'test1', description: 'a description', parameters: {'key': 'value'}}
    const buttonForm = new Constructor({propsData: {buttonData: button}}).$mount()
    expect(buttonForm.$el.textContent).to.contains('test1')
    expect(buttonForm.$el.textContent).to.contains('a description')
  })

  it('has a formElements data item that matches the input parameters', () => {
    const Constructor = Vue.extend(ButtonForm)
    const button = {name: 'test1', description: 'a description', parameters: {'key': 'value'}}
    const buttonForm = new Constructor({propsData: {buttonData: button}}).$mount()
    expect(buttonForm.formElements).to.equal(button.parameters)
  })

  it('createPostObject returns buttonData', () => {
    const Constructor = Vue.extend(ButtonForm)
    const button = {name: 'test1', parameters: {key: 'value'}}
    const buttonForm = new Constructor({ propsData: {buttonData: button} }).$mount()
    expect(buttonForm.createPostObject()).to.equal(button)
  })
})
