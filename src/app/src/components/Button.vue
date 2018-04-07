<template>
  <div v-on:click="counter += 1" class="button">
    <h2>{{ name }} {{counter}}</h2>
    <h4>{{ description }}</h4>
  </div>
</template>

<script>
export default {
  name: 'Button',
  data () {
    return {
      name: 'Button',
      description: 'I love laila!!',
      counter: 0
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
