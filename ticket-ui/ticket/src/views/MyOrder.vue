<template>
    <div class="table">
    <el-tabs type="border-card">
        <el-tab-pane
                label="已支付订单">
            <div class="double">
            <el-table
                    :data="tableData"
                    :header-cell-style="getRowClass"
                    :row-style="tableRowStyle"
                    style="width: 100%;color: #49494a;"
                    ref="multipleTable"
                    border>
                <el-table-column type="index" label="序号" :index="indexMethod" width="90" align="center" >

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
                        prop="seat"
                        label="座位"
                        width="200">
                </el-table-column>
                <el-table-column
                        prop="payTime"
                        label="订单创建时间"
                        width="340">
                </el-table-column>
                <el-table-column
                        prop="amount"
                        label="支付金额(元)"
                        width="200">
                </el-table-column>
                <el-table-column
                        fixed="right"
                        label="友情提醒"
                        width="">
                    <template slot-scope="scope">
                        <span>请在电影开场前入场观影</span>
                    </template>
                </el-table-column>
            </el-table>
            </div>
        </el-tab-pane>
        <el-tab-pane label="已取消订单">
            <div class="double">
                <el-table
                        :data="tableData1"
                        :header-cell-style="getRowClass"
                        :row-style="tableRowStyle"
                        style="width: 100%;color: #49494a;"
                        ref="multipleTable"
                        border>
                    <el-table-column type="index" label="序号" :index="indexMethod" width="90" align="center" >

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
                            prop="seat"
                            label="座位"
                            width="200">
                    </el-table-column>
                    <el-table-column
                            prop="payTime"
                            label="订单创建时间"
                            width="340">
                    </el-table-column>
                    <el-table-column
                            prop="amount"
                            label="支付金额(元)"
                            width="200">
                    </el-table-column>
                    <el-table-column
                            fixed="right"
                            label="状态"
                            width="">
                        <template slot-scope="scope">
                            <span>该订单已被取消</span>
                        </template>
                    </el-table-column>
                </el-table>
            </div>
        </el-tab-pane>
        <el-pagination
                background
                layout="prev, pager, next"
                :total="30">
        </el-pagination>
    </el-tabs>
    </div>
</template>
    <style>
        .el-table-row{
            background: #3d62ac;
        }
    /*更改表格颜色*/
   .table >>> .double{
        background: #f6f6f6;
    }
    .single {
        background: #ccc;
    }
</style>
<script>

    export default {
        data(){
            return{
                tableData:[{}],
                tableData1:[{
            }],
                total: 30, // 默认数据总数
                pagesize:6,//每页的数据条数 - 当前显示数据条数
                currentPage:1,//默认开始页面 - 当前页
            }
        },
        methods:{
            //表头颜色变更
            getRowClass ({ rowIndex }) {
                if (rowIndex == 0) {
                    return 'background: #E6A23C'
                } else {
                    return ''
                }

            },
            //数据序号获取
            indexMethod($index)
            {
                // 表格序号
                // (当前页 - 1) * 当前显示数据条数 + 当前行数据的索引 + 1
                return (this.currentPage - 1) * this.pagesize + $index+1
            },
            tableRowStyle ({ row, rowIndex }) {
                return 'background-color: #ecf5ff'
            }
        },
        mounted() {
            //根据用户id查询已支付账单和未支付账单
            console.log(this.$route.query.userId)
            this.$ax.get("/selectStatus",{params:{userId:this.$route.query.userId}}).then((response)=>{
                console.log(response.data.data)
                for (var i=0;i<response.data.data.length;i++){
                    if (response.data.data[i].status=="PAID"){
                        response.data.data[i].status="已支付"
                        this.tableData.push(response.data.data[i])
                    }else{
                        response.data.data[i].status="未支付"
                        this.tableData1.push(response.data.data[i])
                    }
                }
                console.log(response.data.data.length);
            })
        }
    }
</script>

<style scoped>

</style>