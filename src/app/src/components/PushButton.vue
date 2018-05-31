<template>
  <div>
    <b-field>
      <b-tooltip :label="buttonData.description"
                 type="is-light">
        <button class="button is-info is-large" @click="invoke">
            {{buttonData.name}}
        </button>
        <b-loading :is-full-page="false" :active.sync="disabled" :can-cancel="false"></b-loading>

      </b-tooltip>

    </b-field>
    <b-modal :active.sync="isModalActive">
      <ButtonForm :buttonData="buttonData"></ButtonForm>
    </b-modal>
  </div>
</template>

<script>
import axios from 'axios'
import ButtonForm from './ButtonForm.vue'

let buttonInvocation = function (event) {
  if (this.disabled) {
    console.log('The button is currently disabled.')
    return
  }

  let buttonToPost = this.buttonData
  /*
  if (Object.keys(buttonToPost.parameters).length !== 0) {
    this.isModalActive = true
    return
  }
  */
  this.disabled = true

  axios.post('api/push/result', buttonToPost)
    .then(() => {
      this.disabled = false
    })
    .catch(() => {
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
