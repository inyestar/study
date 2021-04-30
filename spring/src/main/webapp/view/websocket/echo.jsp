<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Echo</title>
<script type="text/javascript">
	var wsocket;
	function sendMessage() {
		wsocket = new WebSocket("ws://127.0.0.1:8080/echo");
		wsocket.onmessage = onMessage;
		wsocket.onclose = onClose;
		wsocket.onopen = function() {
			wsocket.send(document.getElementById("message").value);
		}
	}
	
	function onMessage(event) {
		var data = event.data;
		var res = document.getElementById("response");
		res.innerHTML = data;
		wsocket.close();
	}
	
	function onClose(event) {
		alert("연결끊김");
	}
</script>
</head>
<body>
	<input type="text" id="message" width="200px"/>
	<input type="button" id="sendBtn" value="전송" onClick="sendMessage();" />
	<div id="response"></div>=
</body>
</html>