<template>
  <div class="hi1">
    {{msg}} - {{$route.params.username}}
  </div>
</template>

<script>
export default {
  name: 'Hi1',
  data () {
    return {
      msg: 'i am Hi1'
    }
  }
}
</script>

<style scoped>
</style>
