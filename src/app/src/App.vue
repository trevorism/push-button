<template>
  <div id="app">
    <header-bar/>
    <section class="section">
      <Layout></Layout>
    </section>

  </div>
</template>

<script>
import Layout from './components/Layout.vue'
import HeaderBar from '@trevorism/headerbar'

export default {
  name: 'App',
  components: {
    Layout,
    HeaderBar
  }
}
</script>

<style>
  body::-webkit-scrollbar {
    display: none;
  }
</style>
