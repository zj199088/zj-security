<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="部门名称" prop="orgName">
      <el-input v-model="dataForm.orgName" placeholder="部门名称"></el-input>
    </el-form-item>
    <el-form-item label="上级部门ID，一级部门为0" prop="parentNo">
      <el-input v-model="dataForm.parentNo" placeholder="上级部门ID，一级部门为0"></el-input>
    </el-form-item>
    <el-form-item label="级别" prop="orgType">
      <el-input v-model="dataForm.orgType" placeholder="级别"></el-input>
    </el-form-item>
    <el-form-item label="状态  0：无效   1：有效" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态  0：无效   1：有效"></el-input>
    </el-form-item>
    <el-form-item label="排序" prop="sort">
      <el-input v-model="dataForm.sort" placeholder="排序"></el-input>
    </el-form-item>
    <el-form-item label="创建者ID" prop="createUserId">
      <el-input v-model="dataForm.createUserId" placeholder="创建者ID"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
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
          orgNo: 0,
          orgName: '',
          parentNo: '',
          orgType: '',
          status: '',
          sort: '',
          createUserId: '',
          createTime: ''
        },
        dataRule: {
          orgName: [
            { required: true, message: '部门名称不能为空', trigger: 'blur' }
          ],
          parentNo: [
            { required: true, message: '上级部门ID，一级部门为0不能为空', trigger: 'blur' }
          ],
          orgType: [
            { required: true, message: '级别不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态  0：无效   1：有效不能为空', trigger: 'blur' }
          ],
          sort: [
            { required: true, message: '排序不能为空', trigger: 'blur' }
          ],
          createUserId: [
            { required: true, message: '创建者ID不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.orgNo = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.orgNo) {
            this.$http({
              url: this.$http.adornUrl(`/zj/sysorg/info/${this.dataForm.orgNo}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.orgName = data.sysorg.orgName
                this.dataForm.parentNo = data.sysorg.parentNo
                this.dataForm.orgType = data.sysorg.orgType
                this.dataForm.status = data.sysorg.status
                this.dataForm.sort = data.sysorg.sort
                this.dataForm.createUserId = data.sysorg.createUserId
                this.dataForm.createTime = data.sysorg.createTime
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
              url: this.$http.adornUrl(`/zj/sysorg/${!this.dataForm.orgNo ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'orgNo': this.dataForm.orgNo || undefined,
                'orgName': this.dataForm.orgName,
                'parentNo': this.dataForm.parentNo,
                'orgType': this.dataForm.orgType,
                'status': this.dataForm.status,
                'sort': this.dataForm.sort,
                'createUserId': this.dataForm.createUserId,
                'createTime': this.dataForm.createTime
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
