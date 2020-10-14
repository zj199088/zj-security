<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="发送人" prop="sender">
      <el-input v-model="dataForm.sender" placeholder="发送人"></el-input>
    </el-form-item>
    <el-form-item label="接收人" prop="receiver">
      <el-input v-model="dataForm.receiver" placeholder="接收人"></el-input>
    </el-form-item>
    <el-form-item label="邮件主题" prop="subject">
      <el-input v-model="dataForm.subject" placeholder="邮件主题"></el-input>
    </el-form-item>
    <el-form-item label="发送内容" prop="content">
      <el-input v-model="dataForm.content" placeholder="发送内容"></el-input>
    </el-form-item>
    <el-form-item label="发送时间" prop="sendDate">
      <el-input v-model="dataForm.sendDate" placeholder="发送时间"></el-input>
    </el-form-item>
    <el-form-item label="0：系统发送邮件 1：用户发送邮件" prop="type">
      <el-input v-model="dataForm.type" placeholder="0：系统发送邮件 1：用户发送邮件"></el-input>
    </el-form-item>
    <el-form-item label="发送结果 0:发送成功 1:发送失败" prop="sendResult">
      <el-input v-model="dataForm.sendResult" placeholder="发送结果 0:发送成功 1:发送失败"></el-input>
    </el-form-item>
    <el-form-item label="创建者ID" prop="createUserId">
      <el-input v-model="dataForm.createUserId" placeholder="创建者ID"></el-input>
    </el-form-item>
    <el-form-item label="创建人所属机构" prop="createUserOrgNo">
      <el-input v-model="dataForm.createUserOrgNo" placeholder="创建人所属机构"></el-input>
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
          sender: '',
          receiver: '',
          subject: '',
          content: '',
          sendDate: '',
          type: '',
          sendResult: '',
          createUserId: '',
          createUserOrgNo: ''
        },
        dataRule: {
          sender: [
            { required: true, message: '发送人不能为空', trigger: 'blur' }
          ],
          receiver: [
            { required: true, message: '接收人不能为空', trigger: 'blur' }
          ],
          subject: [
            { required: true, message: '邮件主题不能为空', trigger: 'blur' }
          ],
          content: [
            { required: true, message: '发送内容不能为空', trigger: 'blur' }
          ],
          sendDate: [
            { required: true, message: '发送时间不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '0：系统发送邮件 1：用户发送邮件不能为空', trigger: 'blur' }
          ],
          sendResult: [
            { required: true, message: '发送结果 0:发送成功 1:发送失败不能为空', trigger: 'blur' }
          ],
          createUserId: [
            { required: true, message: '创建者ID不能为空', trigger: 'blur' }
          ],
          createUserOrgNo: [
            { required: true, message: '创建人所属机构不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/zj/sysmaillog/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.sender = data.sysmaillog.sender
                this.dataForm.receiver = data.sysmaillog.receiver
                this.dataForm.subject = data.sysmaillog.subject
                this.dataForm.content = data.sysmaillog.content
                this.dataForm.sendDate = data.sysmaillog.sendDate
                this.dataForm.type = data.sysmaillog.type
                this.dataForm.sendResult = data.sysmaillog.sendResult
                this.dataForm.createUserId = data.sysmaillog.createUserId
                this.dataForm.createUserOrgNo = data.sysmaillog.createUserOrgNo
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
              url: this.$http.adornUrl(`/zj/sysmaillog/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'sender': this.dataForm.sender,
                'receiver': this.dataForm.receiver,
                'subject': this.dataForm.subject,
                'content': this.dataForm.content,
                'sendDate': this.dataForm.sendDate,
                'type': this.dataForm.type,
                'sendResult': this.dataForm.sendResult,
                'createUserId': this.dataForm.createUserId,
                'createUserOrgNo': this.dataForm.createUserOrgNo
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
