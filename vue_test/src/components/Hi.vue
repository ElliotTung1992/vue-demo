<template>
  <div class="hi">
    {{msg}}
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'Hi',
  data () {
    return {
      msg: 'Hi Vue'
    }
  }
}
</script>

<style scoped>
</style>
