<template>
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
      <PushButton></PushButton>
    </grid-item>
  </grid-layout>
</template>

<script>
  import VueGridLayout from "vue-grid-layout";
  import PushButton from './Button.vue'

  var testLayout = [
    {"x":0,"y":0,"w":2,"h":5,"i":"0"},
    {"x":2,"y":0,"w":2,"h":5,"i":"1"},
    {"x":4,"y":0,"w":2,"h":5,"i":"2"},
    {"x":6,"y":0,"w":2,"h":5,"i":"3"},
    {"x":8,"y":0,"w":2,"h":5,"i":"4"},
    {"x":10,"y":0,"w":2,"h":5,"i":"5"},
    {"x":0,"y":5,"w":2,"h":5,"i":"6"},
    {"x":2,"y":5,"w":2,"h":5,"i":"7"},
    {"x":4,"y":5,"w":2,"h":5,"i":"8"},
    {"x":6,"y":4,"w":2,"h":5,"i":"9"},
    {"x":8,"y":4,"w":2,"h":5,"i":"10"},
    {"x":10,"y":4,"w":2,"h":5,"i":"11"}
  ];

  var GridLayout = VueGridLayout.GridLayout;
  var GridItem = VueGridLayout.GridItem;

export default {
    name: 'Layout',
    components: {
      PushButton,
      GridLayout,
      GridItem
    },
    data () {
      return {
        layout: testLayout
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
