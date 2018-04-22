<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h1>{{msgfromfather}}</h1>
    <button v-on:click='onClickMe'>open mouse</button>
  </div>
</template>

<script>
export default {
  data: function () {
    return {
      msg: 'hello from component A'
    }
  },
  props: ['msgfromfather'],
  methods: {
    onClickMe: function() {
      console.log(this.msgfromfather)
      this.$emit('child-tell-to-me',this.msg)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1{
  color: #42b983;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
