<template>

  <div v-if="!loaded">
    Loading...
  </div>
  <div v-else-if="loaded">
    <grid-layout
      :layout="layout"
      :col-num="12"
      :row-height="30"
      :is-draggable="true"
      :is-resizable="false"
      :is-mirrored="false"
      :vertical-compact="true"
      :use-css-transforms="true"
    >

      <grid-item v-for="item in layout"
                 :x="item.x"
                 :y="item.y"
                 :w="item.w"
                 :h="item.h"
                 :i="item.i">

        <PushButton :buttonData="data[item.i]"></PushButton>
      </grid-item>
    </grid-layout>
  </div>
</template>

<script>
import VueGridLayout from 'vue-grid-layout'
import PushButton from './Button.vue'
import axios from 'axios'

var GridLayout = VueGridLayout.GridLayout
var GridItem = VueGridLayout.GridItem
var layout = []

function buildLayoutFromData (data) {
  var layoutSpec = []
  for (var i = 0; i < data.length; i++) {
    var column = {
      'x': i * 2 % 10,
      'y': i / 5 * 5,
      'w': 2,
      'h': 5,
      'i': i.toString()
    }
    layoutSpec.push(column)
  }
  return layoutSpec
}

export default {
  name: 'Layout',
  components: {
    PushButton,
    GridLayout,
    GridItem
  },
  mounted () {
    axios.get('/api/button')
      .then(response => {
        this.data = response.data
        this.layout = buildLayoutFromData(response.data)
        this.loaded = true
      })
  },
  data () {
    return {
      data: [],
      layout: layout,
      loaded: false
    }
  }
}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
