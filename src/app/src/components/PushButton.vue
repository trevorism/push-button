<template>
  <div v-on:click.prevent="invoke" class="button">
    <h4>{{ buttonData.name }}</h4>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'Button',
  props: ['buttonData'],
  data () {
    return {
      name: 'Button',
      disabled: false,
      upHere: false
    }
  },
  methods: {
    invoke: function (event) {
      if (this.disabled) {
        console.log('The button is currently disabled.')
        return
      }
      var buttonToPost = this.buttonData
      this.disabled = true

      axios.post('api/push/result', buttonToPost)
        .then((response) => {
          console.log(response)
          this.disabled = false
        })
        .catch((error) => {
          console.log(error)
          this.disabled = false
        })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .button {
    border: 1px solid black;
    border-radius: 25px;
    background: #69adac;
    padding: 10px;
  }
</style>
