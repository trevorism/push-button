<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <button v-on:click="invoke">Ping</button> <button v-on:click="clear">Clear</button>
    <p>Ping: {{ pong }}</p>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to Trevor\'s Vue.js App',
      counter: 0,
      pong: ''
    }
  },
  mounted () {
    axios.get('/api/button').then(response => {
      this.pong = response.data
    })
  },
  methods: {
    invoke: function (event) {
      axios.get('/api/button')
        .then(response => {
          this.pong = response.data
        })
    },
    clear: function (event) {
      this.pong = ''
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
