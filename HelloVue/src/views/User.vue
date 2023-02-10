<script setup>
import { getAllUsers } from '@/api/user'
import { ref, watchEffect } from 'vue'

let users = ref();

watchEffect(async() => {   
    users.value =  await getAllUsers();
});
</script>

<template>
    <h3>User List:</h3>
    <ul>
        <li v-for="user in users">{{user.realName}}</li>
    </ul>
</template>

<style>
</style>