<template>
  <div>
    {{msg}} - {{$route.params.id}} - {{$route.params.name}}
  </div>
</template>

<script>
export default {
  name: 'Param',
  data () {
    return {
      msg: 'i am Param'
    }
  },
  beforeRouteEnter:(to,from,next)=>{
    console.log("准备进入Param模板");
    next();
  },
  beforeRouteLeave: (to, from, next) => {
    console.log("准备离开Param模板");
    next();
  }
}
</script>

<style scoped>
</style>
