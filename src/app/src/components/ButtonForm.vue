<template>
  <section class="card">
    <div class="content">
      {{buttonData}}
    </div>
  </section>
</template>

<script>
import axios from 'axios'

export default {
  props: ['buttonData'],
  data () {
    return {
      show: false
    }
  },
  methods: {
    invoke: function (event) {
      // TODO: Add button here instead of null
      axios.post('api/push/result', this.buttonData)
        .then(() => {
          window.alert('Success ')
          this.$emit('close')
        })
        .catch(() => {
          window.alert('Failure ')
          this.$emit('close')
        })
    }
  }
}

</script>

