<template>
  <div id="app">
    <section class="hero is-primary">
      <div class="hero-body">
        <h1 class="title">Trevorism Push Buttons</h1>
      </div>
    </section>
    <section class="section">
      <Layout></Layout>
    </section>

  </div>
</template>

<script>
import Layout from './components/Layout.vue'

export default {
  name: 'App',
  components: {
    Layout
  }
}
</script>

<style>
  body::-webkit-scrollbar {
    display: none;
  }
</style>
