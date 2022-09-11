<template>
  <div class="app">
      <div class="content-body">
          <router-view />
      </div>
  </div>
</template>

<script>
// @ is an alias to /src
export default {
  data(){
    return{

    }
  },
  methods: {
  }
};
</script>

<style>
#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  height: 100%;
  font-family: "Source Sans Pro",-apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif,"Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol";
  line-height: 1.5;
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

</style>
