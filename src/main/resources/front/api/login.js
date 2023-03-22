function loginApi(data) {
    return $axios({
      'url': '/user/login',
      'method': 'post',
      data
    })
  }

function loginoutApi() {
  return $axios({
    'url': '/user/loginout',
    'method': 'post',
  })
}
function sendMsgApi(data) {
    return $axios({
        'url': '/user/sendMsg', //请求路径
        'method': 'post',  //请求方式
        data   //请求携带的参数
    })
}


  