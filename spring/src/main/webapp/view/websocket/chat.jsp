<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Echo</title>
<script type="text/javascript">
	var wsocket;
	function connect() {
		wsocket = new WebSocket("ws://172.30.1.45:8080/chat");
		wsocket.onopen = onOpen;
		wsocket.onmessage = onMessage;
		wsocket.onclose = onClose;
	}
	
	function disconnect() {
	
		if(wsocket != null) {
			wsocket.close();
		}
	}
	
	function onOpen(event) {
		var nickname = document.getElementById("nickname").value;
		appendMessage("[" + nickname + "\" joined, welcome!]");
	}
	
	function onMessage(event) {
		var data = event.data;
		if(data.substring(0,4) == "msg:") {
			appendMessage(data.substring(4));
		}
	}
	
	function onClose(event) {
		appendMessage("[disconnected, bye!]");
	}
	
	function appendMessage(msg) {
		var chatArea = document.getElementById("chatArea");
		var messageArea = document.getElementById("chatMessageArea");
		var temp = document.createElement("div");
		temp.innerHTML = msg;
		messageArea.append(temp);
		var chatHeight = chatArea.offsetHeight;
		var maxScroll = messageArea.offsetHeight - chatHeight;
		window.scrollTo({
			  top: maxScroll,
			  behavior: 'smooth'
			});
	}
	
	function send(event) {
		var type = event.type;
		var keyCode = event.keyCode ? event.keyCode : event.which;
		if(type == 'click' || (type =='keypress' && keyCode == '13')) {
			var nickname = document.getElementById("nickname").value;
			var msg =  document.getElementById("message");
			wsocket.send("msg:"+nickname+": "+msg.value);
			msg.value = "";
		}
		event.stopPropagation(); 
	}
</script>
</head>
<body>
	<h1 style="color:red">KOREAN NOT SUPPORTED</h1>
	<input type="text" id="nickname" placeholder="enter your name" style="width:300px;"/>
	<input type="button" id="enterBtn" value="enter" onClick="connect();" />
	<input type="button" id="exitBtn" value="leave" onClick="disconnect();" />
	<div id="chatArea" style="width: 300px; height: 100px; overflow-y: auto; border: 1px solid black;">
		<div id="chatMessageArea"></div>
	</div><br/>
	<input type="text" id="message" style="width:300px;" onKeypress="send(event);" />
	<input type="button" id="sendBtn" value="send" onClick="send(event);" />
</body>
</html>