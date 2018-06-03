import PushMixin from '@/mixins/push'

describe('push.js', () => {
  it('disabled is false', () => {
    expect(PushMixin.data().disabled).to.equal(false)
  })
  it('default shouldSubmit return true', () => {
    expect(PushMixin.methods.shouldSubmit()).to.equal(true)
  })
})
