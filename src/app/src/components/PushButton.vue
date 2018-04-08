<template>
  <div v-on:click="invoke" class="button">
    <h2>{{ buttonData.name }} {{counter}}</h2>
    <h4>{{ buttonData.description }}</h4>
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
      description: 'I love laila!!',
      counter: 0
    }
  },
  methods: {
    invoke: function (event) {
      var buttonToPost = {}
      buttonToPost.name = this.buttonData.name
      buttonToPost.parameters = {'red': 'green'}
      buttonToPost.topicName = 'test'

      axios.post('api/push/result', buttonToPost)
        .then(function (response) {
          console.log(response)
        })
        .catch(function (error) {
          console.log(error)
        })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .button {
    border: 1px solid black;
  }
</style>
