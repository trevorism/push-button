<template>
  <div v-on:click="greet" class="button">
    <h2>{{ buttonData.name }} {{counter}}</h2>
    <h4>{{ buttonData.description }}</h4>
  </div>
</template>

<script>
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
    greet: function (event) {
      // `this` inside methods points to the Vue instance
      alert('Hello ' + this.name + '!')
      // `event` is the native DOM event
      if (event) {
        alert(event.target.tagName)
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
