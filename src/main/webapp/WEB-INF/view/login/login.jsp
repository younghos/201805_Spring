<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://bootstrapk.com/favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="/js/ie-emulation-modes-warning.js"></script>
    
    <script src="/js/jquery-3.3.1.min.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
	   	$(document).ready(function(){
	   		// remember 쿠기값이 y 이면 remember-me 체크박스 체크
	   		if(getCookie("remember")=="Y"){
	   			$("#remember").attr("checked", true);
// 	   			$("#remember").prop("checked", true);
		   		// userId input value userId 쿠기 값으로 설정
		   		$("#userId").val(getCookie("userId"));
	   		}
	   	});
    	function getCookie(cookieName){
    		
    		var str = document.cookie;
    		
    		var split_str = str.split("; ");
    		
    		var value = "";
    		for(var i = 0; i<split_str.length; i++){
    			if(split_str[i].indexOf(cookieName + "=") >= 0){
    				value = split_str[i].substring(split_str[i].indexOf("=")+1);
    			}
    		}
    		
    		return value;
    	}
    	var str = getCookie("userId");
	    console.log(str);
	    console.log(getCookie("remember"));
    </script>
  </head>

  <body>

    <div class="container">

      <form class="form-signin" action="/user/loginProcess" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="text" name="userId" id="userId" class="form-control" placeholder="User Id" required autofocus >
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password"  name="pass" class="form-control" placeholder="Password">
        <!-- 
        	사용자 아이디 기억하기
        	1. remember-me input(checkBox) 파라미터를 login 요청 시 전송
        	   userId, pass -> userId, pass, remember-me
        	2. /dditLogin(LoginServlet)
        	   remember-me 파라미터를 확인
        	   2-1) 아이디 기억하기 사용
        	       response 객체에 remember-me cookie 생성
        	   2-2) 아이디 기억하기 사용하지 않기
        	       response 객체에 remember-me cookie 삭제
        	3. cookie 값에 따라 remember-me checkbox 설정하기
        	   login.jsp
         -->
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me" name="remember-me" id="remember"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
