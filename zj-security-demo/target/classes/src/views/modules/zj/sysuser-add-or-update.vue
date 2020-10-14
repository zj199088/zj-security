<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户名" prop="userName">
      <el-input v-model="dataForm.userName" placeholder="用户名"></el-input>
    </el-form-item>
    <el-form-item label="" prop="realName">
      <el-input v-model="dataForm.realName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="sex">
      <el-input v-model="dataForm.sex" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="机构编码" prop="orgNo">
      <el-input v-model="dataForm.orgNo" placeholder="机构编码"></el-input>
    </el-form-item>
    <el-form-item label="盐" prop="salt">
      <el-input v-model="dataForm.salt" placeholder="盐"></el-input>
    </el-form-item>
    <el-form-item label="邮件服务器地址" prop="emailHost">
      <el-input v-model="dataForm.emailHost" placeholder="邮件服务器地址"></el-input>
    </el-form-item>
    <el-form-item label="邮箱" prop="email">
      <el-input v-model="dataForm.email" placeholder="邮箱"></el-input>
    </el-form-item>
    <el-form-item label="用户邮箱密码" prop="emailPw">
      <el-input v-model="dataForm.emailPw" placeholder="用户邮箱密码"></el-input>
    </el-form-item>
    <el-form-item label="手机号" prop="mobile">
      <el-input v-model="dataForm.mobile" placeholder="手机号"></el-input>
    </el-form-item>
    <el-form-item label="状态  0：禁用   1：正常" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态  0：禁用   1：正常"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input v-model="dataForm.password" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item label="创建者ID" prop="createUserId">
      <el-input v-model="dataForm.createUserId" placeholder="创建者ID"></el-input>
    </el-form-item>
    <el-form-item label="创建人所属机构" prop="createUserOrgNo">
      <el-input v-model="dataForm.createUserOrgNo" placeholder="创建人所属机构"></el-input>
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
          userId: 0,
          userName: '',
          realName: '',
          sex: '',
          orgNo: '',
          salt: '',
          emailHost: '',
          email: '',
          emailPw: '',
          mobile: '',
          status: '',
          password: '',
          createUserId: '',
          createUserOrgNo: '',
          createTime: ''
        },
        dataRule: {
          userName: [
            { required: true, message: '用户名不能为空', trigger: 'blur' }
          ],
          realName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          orgNo: [
            { required: true, message: '机构编码不能为空', trigger: 'blur' }
          ],
          salt: [
            { required: true, message: '盐不能为空', trigger: 'blur' }
          ],
          emailHost: [
            { required: true, message: '邮件服务器地址不能为空', trigger: 'blur' }
          ],
          email: [
            { required: true, message: '邮箱不能为空', trigger: 'blur' }
          ],
          emailPw: [
            { required: true, message: '用户邮箱密码不能为空', trigger: 'blur' }
          ],
          mobile: [
            { required: true, message: '手机号不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态  0：禁用   1：正常不能为空', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '密码不能为空', trigger: 'blur' }
          ],
          createUserId: [
            { required: true, message: '创建者ID不能为空', trigger: 'blur' }
          ],
          createUserOrgNo: [
            { required: true, message: '创建人所属机构不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.userId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.userId) {
            this.$http({
              url: this.$http.adornUrl(`/zj/sysuser/info/${this.dataForm.userId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userName = data.sysuser.userName
                this.dataForm.realName = data.sysuser.realName
                this.dataForm.sex = data.sysuser.sex
                this.dataForm.orgNo = data.sysuser.orgNo
                this.dataForm.salt = data.sysuser.salt
                this.dataForm.emailHost = data.sysuser.emailHost
                this.dataForm.email = data.sysuser.email
                this.dataForm.emailPw = data.sysuser.emailPw
                this.dataForm.mobile = data.sysuser.mobile
                this.dataForm.status = data.sysuser.status
                this.dataForm.password = data.sysuser.password
                this.dataForm.createUserId = data.sysuser.createUserId
                this.dataForm.createUserOrgNo = data.sysuser.createUserOrgNo
                this.dataForm.createTime = data.sysuser.createTime
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
              url: this.$http.adornUrl(`/zj/sysuser/${!this.dataForm.userId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'userId': this.dataForm.userId || undefined,
                'userName': this.dataForm.userName,
                'realName': this.dataForm.realName,
                'sex': this.dataForm.sex,
                'orgNo': this.dataForm.orgNo,
                'salt': this.dataForm.salt,
                'emailHost': this.dataForm.emailHost,
                'email': this.dataForm.email,
                'emailPw': this.dataForm.emailPw,
                'mobile': this.dataForm.mobile,
                'status': this.dataForm.status,
                'password': this.dataForm.password,
                'createUserId': this.dataForm.createUserId,
                'createUserOrgNo': this.dataForm.createUserOrgNo,
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
