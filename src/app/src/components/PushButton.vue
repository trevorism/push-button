<template>
  <div>
    <b-field>
      <b-tooltip :label="buttonData.description"
                 type="is-light">
        <button class="button is-info is-large" @click="invokeButton" :disabled="disabled">
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
import ButtonForm from './ButtonForm.vue'
import mixin from '../mixin/push'

export default {
  name: 'Button',
  components: {ButtonForm},
  props: ['buttonData'],
  mixins: [mixin],
  data () {
    return {
      disabled: false,
      isModalActive: false
    }
  },
  methods: {
    shouldSubmit: function () {
      if (this.buttonData.parameters && Object.keys(this.buttonData.parameters).length !== 0) {
        this.isModalActive = true
        return false
      }
      return true
    }
  }
}
</script>
