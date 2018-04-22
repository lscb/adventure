<template>
  <div id="app">
    <!-- <h1 v-html="title"></h1>
    <input v-model="newItem" v-on:keyup.enter="addNew">
    <ul>
      <li v-for="item in items" v-bind:class="{finished:item.isFinished}" v-on:click="tog(item)">
        {{item.label}}
      </li>
    </ul>
    <p>child tslls me:{{childWord}}</p>
    <component-a msgfromfather='you die!' 
    v-on:child-tell-to-me='listenToMyBoy'></component-a>
    <p></p>
    <button v-on:click='testfun'>test请求</button> -->

    <b-map-component></b-map-component>

  </div>
</template>

<script>
import Store from './store.js'
import ComponentA from './components/componentA'
import BMapComponent from './components/BMapComponent'

export default {
  data : function(){
    return {
      title: "todolist",
      items:Store.fetch(),
      newItem: '',
      childWord: ''
    }
  },
  components:{ComponentA,BMapComponent},
  methods: {
        tog: function (item) {
        item.isFinished = !item.isFinished
        },
        addNew: function() {
          this.items.push({
            label: this.newItem,
            isFinished: false
          })
          console.log(this.newItem);
          this.newItem = '';
        },
        listenToMyBoy: function(msg) {
          this.childWord = msg;
        },
        testfun: function (params) {
          debugger;
                if (params) {
                    this.$http.get("/api/test")
                        .then((response) => {
                            //this.type_options = response.data;
                            console.log(response.data);
                        }).catch(function (response) {
                        console.log(response)
                    });
                }

            }
      },
  watch: {
    items: {
      handler: function(items){
        Store.save(items);
      },
      deep: true
    }
  }
}


</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

.finished{
  text-decoration: underline;
}
</style>
