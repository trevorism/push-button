<template>
  <div class="modal-card" style="width: auto">
    <header class="modal-card-head">
      <p class="modal-card-title">{{buttonData.name}}</p>
    </header>
    <section class="modal-card-body">
    <small class="container">{{buttonData.description}}</small>
    </section>
    <section class="modal-card-body">
      <div v-for="(value,key) in this.buttonData.parameters" :key="key">
        <b-field :label="key">
          <b-input :value="value" v-model="formElements[key]">
          </b-input>
        </b-field>
      </div>
    </section>
    <footer class="modal-card-foot">
      <button class="button" type="button" @click="$parent.close()">Close</button>
      <button class="button is-primary" :disabled="disabled" @click="invokeButton">
        Submit
        <b-loading :is-full-page="false" :active.sync="disabled" :can-cancel="false"></b-loading>
      </button>

    </footer>
  </div>
</template>

<script>
import mixin from '../mixin/push'

export default {
  props: ['buttonData'],
  mixins: [mixin],
  data () {
    return {
      formElements: this.buttonData.parameters
    }
  },
  methods: {
    onCallback: function () {
      this.$parent.close()
    },
    createPostObject: function () {
      this.buttonData.parameters = this.formElements
      return this.buttonData
    }
  }
}

</script>
