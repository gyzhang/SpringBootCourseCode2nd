<script setup>
import HelloWorld from './components/HelloWorld.vue'
import TheWelcome from './components/TheWelcome.vue'
import User from './views/User.vue'
</script>

<script>
export default {
  methods: {
    show(index) {
      if(index == 'foo') {
        this.$router.push('/foo')
      }
      if(index == 'bar') {
        this.$router.push('/bar')
      }
    }
  }
}
</script>

<template>
  <header>
    <img alt="Vue logo" class="logo" src="./assets/logo.svg" width="125" height="125" />

    <div class="wrapper">
      <HelloWorld msg="You did it!" />
    </div>
    <div class="wrapper">
      <User />
    </div>
  </header>

  <main>
    <div>
      <button @click="show('foo')">Foo Page</button>
      <button @click="show('bar')">Bar Page</button>
    </div>
    <router-view></router-view>
    <TheWelcome />
  </main>
</template>

<style scoped>
header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}
</style>
