<script setup>
import { doOrder } from '@/api/order'
import { reactive, ref } from 'vue';

const orderForm = reactive({
  memberId: '10086',
  productId: '6998',
  count: 666
});

let orderInfo = ref('');

function submitForm() {
  doOrder(orderForm).then(res => {
    orderInfo.value = res;
  })
}
</script>

<template>
  <el-form :model="orderForm">
    <h3 class="title">天选购物狂，快快下订单</h3>
    <el-form-item label="会员号码">
      <el-input v-model="orderForm.memberId" placeholder="请输入会员号，5位数字"></el-input>
    </el-form-item>
    <el-form-item label="商品编号">
      <el-input v-model="orderForm.productId" placeholder="请输入商品编号，4位数字"></el-input>
    </el-form-item>
    <el-form-item label="购买数量">
      <el-input v-model="orderForm.count" placeholder="请输入购买的数量，正整数"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" size="large" @click="submitForm">提交</el-button>
    </el-form-item>
  </el-form>

  <el-card>
    <template #header>
      <h3>下单信息</h3>
    </template>
    <p>{{ orderInfo }}</p>
  </el-card>
</template>
  
<style>
  .title {
    margin: 0px auto 30px auto;
    text-align: center;
    color: #707070;
  }
</style>