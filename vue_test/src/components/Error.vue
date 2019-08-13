<template>
  <div class="hi" style="color: darkred">
    {{msg}}
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'Hi',
  data () {
    return {
      msg: '404 页面丢失了！'
    }
  }
}
</script>

<style scoped>
</style>
