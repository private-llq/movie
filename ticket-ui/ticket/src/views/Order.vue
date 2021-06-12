<template>
        <el-table
                :data="tableData"
                style="width: 100%"
                border>
            <el-table-column
                    type="selection"
                    width="60">
            </el-table-column>
            <el-table-column
                    prop="orderNo"
                    label="订单号"
                    width="300">
            </el-table-column>
            <el-table-column
                    prop="status"
                    label="支付状态"
                    width="200">
            </el-table-column>
            <el-table-column
                    prop="amount"
                    label="金额"
                     width="200">
            </el-table-column>
            <el-table-column
                    prop="seat"
                    label="座位"
                    width="200">
            </el-table-column>
            <el-table-column
                    prop="createTime"
                    label="订单创建时间"
                    width="340">
            </el-table-column>
            <el-table-column
                    fixed="right"
                    label="操作"
                    width="">
                <template slot-scope="scope">
                    <el-button @click="goPay" type="primary" round size="small">立即支付</el-button>
                    <el-button
                            @click="deleteRow"
                            type="danger" round size="small">
                        取消订单
                    </el-button>
                </template>
            </el-table-column>
        </el-table>

</template>

<script>
    export default {
        data() {
            return {
                tableData:[]

            }
        },
        methods:{
            // this.$ax.get({'/sle'
            //
            // })
            //根据订单id和用户id修改订单状态
            deleteRow(){
                this.$ax.get("/updateOrder",{params:{userId:this.tableData[0].userId,orderId:this.tableData[0].orderId}}).then((response)=>{
                    console.log(response.data)
                    if (response.data.success=true){
                        this.$router.push({path:"/MyOrder",query:{userId:response.data.data}})
                    }
                })
            },
            goPay(){
                this.$ax.post("/alipay?outTradeNo=" +
                    this.tableData[0].orderNo +
                    "&subject=" +
                    this.tableData[0].paymentChannel +
                " &totalAmount=" +
                    this.tableData[0].amount.toString()+
                    "&description=" +
                    this.tableData[0].status) .then((resp) => {
                    // 添加之前先删除一下，如果单页面，页面不刷新，添加进去的内容会一直保留在页面中，二次调用form表单会出错
                    const divForm = document.getElementsByTagName("div");
                    if (divForm.length) {
                        document.body.removeChild(divForm[0]);
                    }
                    const div = document.createElement("div");
                    div.innerHTML = resp.data; // data就是接口返回的form 表单字符串
                    document.body.appendChild(div);
                    document.forms[0].setAttribute("target", "_blank"); // 新开窗口跳转
                    document.forms[0].submit();
                });
            }


        },
        mounted() {
                this.$ax.get("/selectOrder",{params:{orderId:this.$route.query.seatNum}}).then((response)=>{
                    response.data.data.status="待支付";
                    this.tableData.push(response.data.data);
                })





        }
    }
</script>

<style scoped>

</style>