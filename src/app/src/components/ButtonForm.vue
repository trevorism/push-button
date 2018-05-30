<template>
  <div>
    <div v-on:click.prevent="invoke" class="button">
      Submit
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  methods: {
    invoke: function (event) {
      // TODO: Add button here instead of null
      axios.post('api/push/result', null)
        .then(() => {
          window.alert('Success')
        })
        .catch(() => {
          window.alert('Failure')
        })
    }
  }
}

</script>

<style scoped>
  .button {
    border: 1px solid black;
    border-radius: 15px;
    background: #27ad34;
    width: 80px;
    padding: 5px;
    cursor:pointer;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
  }
</style>
