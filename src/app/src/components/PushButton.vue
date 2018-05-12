<template>
  <div v-on:click.prevent="invoke" v-bind:style="{ width: computedX }" class="button">
    <h4>{{ buttonData.name }}</h4>
  </div>
</template>

<script>
import axios from 'axios'
import {TweenLite, TweenMax} from 'gsap'

export default {
  name: 'Button',
  props: ['buttonData'],
  data () {
    return {
      name: 'Button',
      disabled: false,
      xaxis: '80%'
    }
  },
  computed: {
    computedX: function () {
      return this.xaxis
    }
  },
  methods: {
    invoke: function (event) {
      if (this.disabled) {
        console.log('The button is currently disabled.')
        return
      }

      let buttonToPost = this.buttonData
      let myObj = this.$data
      this.disabled = true
      TweenMax.to(myObj, 1, {xaxis: '90%', repeat: -1, yoyo: true})

      axios.post('api/push/result', buttonToPost)
        .then(() => {
          TweenLite.to(myObj, 1, {xaxis: '80%'})
          this.disabled = false
        })
        .catch(() => {
          TweenLite.to(myObj, 1, {xaxis: '80%'})
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
