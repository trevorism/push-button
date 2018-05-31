<template>
  <div>
    <b-field>
      <button class="button is-primary is-medium" @click="buttonInvocation">
        {{buttonData.name}}
      </button>
    </b-field>
    <b-modal :active.sync="isModalActive">
      <ButtonForm :buttonData="buttonData"></ButtonForm>
    </b-modal>
  </div>
</template>

<script>
import axios from 'axios'
// import {TweenLite, TweenMax} from 'gsap'
import ButtonForm from './ButtonForm.vue'

let buttonInvocation = function (event) {
  if (this.disabled) {
    console.log('The button is currently disabled.')
    return
  }

  let buttonToPost = this.buttonData

  if (Object.keys(buttonToPost.parameters).length !== 0) {
    this.isModalActive = true
    return
  }

  // let myObj = this.$data
  this.disabled = true
  // TweenMax.to(myObj, 1, {xaxis: '90%', repeat: -1, yoyo: true})

  axios.post('api/push/result', buttonToPost)
    .then(() => {
      // TweenLite.to(myObj, 1, {xaxis: '80%'})
      this.disabled = false
    })
    .catch(() => {
      // TweenLite.to(myObj, 1, {xaxis: '80%'})
      this.disabled = false
    })
}

export default {
  name: 'Button',
  components: {ButtonForm},
  props: ['buttonData'],
  data () {
    return {
      name: 'Button',
      disabled: false,
      showModal: false,
      isModalActive: false
    }
  },
  computed: {
    computedX: function () {
      return this.xaxis
    }
  },
  methods: {
    invoke: buttonInvocation
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
    cursor:pointer;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
  }
</style>
