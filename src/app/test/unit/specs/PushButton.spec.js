import Vue from 'vue'
import Buefy from 'buefy'
import PushButton from '@/components/PushButton'

describe('PushButton.vue', () => {
  Vue.use(Buefy)
  it('renders its name', () => {
    const Constructor = Vue.extend(PushButton)
    const button = {name: 'test1'}
    const pushButton = new Constructor({ propsData: {buttonData: button} }).$mount()
    expect(pushButton.$el.textContent).to.contains('test1')
    expect(pushButton.disabled).to.equal(false)
  })

  it('shouldSubmit returns true when no parameters exist', () => {
    const Constructor = Vue.extend(PushButton)
    const button = {name: 'test1'}
    const pushButton = new Constructor({ propsData: {buttonData: button} }).$mount()
    expect(pushButton.shouldSubmit()).to.equal(true)
    expect(pushButton.isModalActive).to.equal(false)
  })

  it('shouldSubmit returns true with empty parameters', () => {
    const Constructor = Vue.extend(PushButton)
    const button = {name: 'test1', parameters: {}}
    const pushButton = new Constructor({ propsData: {buttonData: button} }).$mount()
    expect(pushButton.shouldSubmit()).to.equal(true)
    expect(pushButton.isModalActive).to.equal(false)
  })

  it('shouldSubmit returns false with a parameters', () => {
    const Constructor = Vue.extend(PushButton)
    const button = {name: 'test1', parameters: {'key': 'value'}}
    const pushButton = new Constructor({ propsData: {buttonData: button} }).$mount()
    expect(pushButton.shouldSubmit()).to.equal(false)
    expect(pushButton.isModalActive).to.equal(true)
  })
})
