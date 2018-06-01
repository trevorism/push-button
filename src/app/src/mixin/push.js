import axios from 'axios'

export default {
  props: ['buttonData'],
  data () {
    return {
      disabled: false
    }
  },
  methods: {
    invokeButton: function () {
      if (this.disabled) {
        console.log('The button is currently disabled.')
        return
      }

      let buttonToPost = this.createPostObject()
      if (!this.shouldSubmit()) {
        return
      }
      this.disabled = true

      axios.post('api/push/result', buttonToPost)
        .then(() => {
          this.disabled = false
          this.onCallback()
        })
        .catch(() => {
          this.disabled = false
          this.onCallback()
        })
    },
    shouldSubmit: function () {
      return true
    },
    createPostObject: function () {
      return this.buttonData
    },
    onCallback: function () {}
  }
}
