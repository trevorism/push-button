<template>
  <div class="container">
    <div v-if="!loaded">
      {{message}}
    </div>
    <div v-else-if="loaded">
      <div v-for="columns in rowCount" :key="data.id">
        <div class="columns">
          <div class="column" v-for="column in numberOfColumns" :key="data.id">
            <div v-if="data.length >= layoutCount(columns, column)">
              <PushButton :buttonData="data[layoutCount(columns, column) - 1]"></PushButton>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import PushButton from './PushButton.vue'
import axios from 'axios'

export default {
  name: 'Layout',
  components: {
    PushButton
  },
  mounted () {
    axios.get('/api/button')
      .then(response => {
        this.data = response.data
        this.loaded = true
      })
      .catch(() => {
        this.message = 'Error loading push buttons. Please refresh.'
      })
  },
  data () {
    return {
      data: [],
      numberOfColumns: 4,
      loaded: false,
      message: 'Loading...'
    }
  },
  computed: {
    rowCount: function () {
      return Math.floor(((this.data.length - 1) / this.numberOfColumns)) + 1
    }
  },
  methods: {
    layoutCount: function (rows, columns) {
      return (rows - 1) * this.numberOfColumns + columns
    }
  }
}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
