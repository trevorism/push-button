import Vue from 'vue'
import PushButton from '@/components/PushButton'

describe('PushButton.vue', () => {
  it('renders its name', () => {
    const Constructor = Vue.extend(PushButton)
    const button = {name: 'test1'}
    const vm = new Constructor({ propsData: {buttonData: button} }).$mount()
    expect(vm.$el.textContent).to.contains('test1')
    expect(vm.disabled).to.equal(false)
  })

  it('has a data function', () => {
    expect(typeof PushButton.data).to.equal('function')
  })

  it('has an invoke method', () => {
    expect(typeof PushButton.methods.invoke).to.equal('function')
  })

  it('does not have a created hook', () => {
    expect(typeof PushButton.created).to.equal('undefined')
  })
})
