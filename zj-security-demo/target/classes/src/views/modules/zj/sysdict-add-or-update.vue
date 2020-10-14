<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="所属分组ID" prop="groupId">
      <el-input v-model="dataForm.groupId" placeholder="所属分组ID"></el-input>
    </el-form-item>
    <el-form-item label="字典名称" prop="name">
      <el-input v-model="dataForm.name" placeholder="字典名称"></el-input>
    </el-form-item>
    <el-form-item label="字典值" prop="value">
      <el-input v-model="dataForm.value" placeholder="字典值"></el-input>
    </el-form-item>
    <el-form-item label="排序号" prop="sort">
      <el-input v-model="dataForm.sort" placeholder="排序号"></el-input>
    </el-form-item>
    <el-form-item label="状态码" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态码"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          groupId: '',
          name: '',
          value: '',
          sort: '',
          status: '',
          remark: ''
        },
        dataRule: {
          groupId: [
            { required: true, message: '所属分组ID不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '字典名称不能为空', trigger: 'blur' }
          ],
          value: [
            { required: true, message: '字典值不能为空', trigger: 'blur' }
          ],
          sort: [
            { required: true, message: '排序号不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态码不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/zj/sysdict/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.groupId = data.sysdict.groupId
                this.dataForm.name = data.sysdict.name
                this.dataForm.value = data.sysdict.value
                this.dataForm.sort = data.sysdict.sort
                this.dataForm.status = data.sysdict.status
                this.dataForm.remark = data.sysdict.remark
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/zj/sysdict/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'groupId': this.dataForm.groupId,
                'name': this.dataForm.name,
                'value': this.dataForm.value,
                'sort': this.dataForm.sort,
                'status': this.dataForm.status,
                'remark': this.dataForm.remark
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
