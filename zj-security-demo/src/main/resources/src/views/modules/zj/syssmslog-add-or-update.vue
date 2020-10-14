<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="操作人ID" prop="userId">
      <el-input v-model="dataForm.userId" placeholder="操作人ID"></el-input>
    </el-form-item>
    <el-form-item label="模板ID" prop="templateId">
      <el-input v-model="dataForm.templateId" placeholder="模板ID"></el-input>
    </el-form-item>
    <el-form-item label="验证码" prop="code">
      <el-input v-model="dataForm.code" placeholder="验证码"></el-input>
    </el-form-item>
    <el-form-item label="发送内容（1-500 个汉字）UTF-8编码" prop="content">
      <el-input v-model="dataForm.content" placeholder="发送内容（1-500 个汉字）UTF-8编码"></el-input>
    </el-form-item>
    <el-form-item label="手机号码。多个以英文逗号隔开" prop="mobile">
      <el-input v-model="dataForm.mobile" placeholder="手机号码。多个以英文逗号隔开"></el-input>
    </el-form-item>
    <el-form-item label="发送时间" prop="stime">
      <el-input v-model="dataForm.stime" placeholder="发送时间"></el-input>
    </el-form-item>
    <el-form-item label="必填参数。用户签名" prop="sign">
      <el-input v-model="dataForm.sign" placeholder="必填参数。用户签名"></el-input>
    </el-form-item>
    <el-form-item label="0成功 1失败" prop="sendStatus">
      <el-input v-model="dataForm.sendStatus" placeholder="0成功 1失败"></el-input>
    </el-form-item>
    <el-form-item label="发送编号" prop="sendId">
      <el-input v-model="dataForm.sendId" placeholder="发送编号"></el-input>
    </el-form-item>
    <el-form-item label="成功提交数" prop="successNum">
      <el-input v-model="dataForm.successNum" placeholder="成功提交数"></el-input>
    </el-form-item>
    <el-form-item label="返回消息" prop="returnMsg">
      <el-input v-model="dataForm.returnMsg" placeholder="返回消息"></el-input>
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
          userId: '',
          templateId: '',
          code: '',
          content: '',
          mobile: '',
          stime: '',
          sign: '',
          sendStatus: '',
          sendId: '',
          successNum: '',
          returnMsg: ''
        },
        dataRule: {
          userId: [
            { required: true, message: '操作人ID不能为空', trigger: 'blur' }
          ],
          templateId: [
            { required: true, message: '模板ID不能为空', trigger: 'blur' }
          ],
          code: [
            { required: true, message: '验证码不能为空', trigger: 'blur' }
          ],
          content: [
            { required: true, message: '发送内容（1-500 个汉字）UTF-8编码不能为空', trigger: 'blur' }
          ],
          mobile: [
            { required: true, message: '手机号码。多个以英文逗号隔开不能为空', trigger: 'blur' }
          ],
          stime: [
            { required: true, message: '发送时间不能为空', trigger: 'blur' }
          ],
          sign: [
            { required: true, message: '必填参数。用户签名不能为空', trigger: 'blur' }
          ],
          sendStatus: [
            { required: true, message: '0成功 1失败不能为空', trigger: 'blur' }
          ],
          sendId: [
            { required: true, message: '发送编号不能为空', trigger: 'blur' }
          ],
          successNum: [
            { required: true, message: '成功提交数不能为空', trigger: 'blur' }
          ],
          returnMsg: [
            { required: true, message: '返回消息不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/zj/syssmslog/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userId = data.syssmslog.userId
                this.dataForm.templateId = data.syssmslog.templateId
                this.dataForm.code = data.syssmslog.code
                this.dataForm.content = data.syssmslog.content
                this.dataForm.mobile = data.syssmslog.mobile
                this.dataForm.stime = data.syssmslog.stime
                this.dataForm.sign = data.syssmslog.sign
                this.dataForm.sendStatus = data.syssmslog.sendStatus
                this.dataForm.sendId = data.syssmslog.sendId
                this.dataForm.successNum = data.syssmslog.successNum
                this.dataForm.returnMsg = data.syssmslog.returnMsg
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
              url: this.$http.adornUrl(`/zj/syssmslog/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'userId': this.dataForm.userId,
                'templateId': this.dataForm.templateId,
                'code': this.dataForm.code,
                'content': this.dataForm.content,
                'mobile': this.dataForm.mobile,
                'stime': this.dataForm.stime,
                'sign': this.dataForm.sign,
                'sendStatus': this.dataForm.sendStatus,
                'sendId': this.dataForm.sendId,
                'successNum': this.dataForm.successNum,
                'returnMsg': this.dataForm.returnMsg
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
