<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
        <script language="javascript" type="text/javascript">
            var wsUri = "ws://localhost:8080/REST_Web/hello";
            var websocket;
            
            function init() {
                websocket = new WebSocket(wsUri);
                websocket.onopen = function(evt) {
                    writeToScreen("Connected to Endpoint!");
                    doSend(textID.value);
                };
                websocket.onmessage = function(evt) {
                    writeToScreen("Message Received: " + evt.data);
                };
                websocket.onerror = function(evt) {
                    writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
                };
                websocket.onclose = function(evt) {
                    writeToScreen("Close !");
                };
            }
            
            function doSend() {
                var message = textID.value;
                writeToScreen("Message Sent: " + message);
                websocket.send(message);
            }
            
            function doClose() {
                websocket.close();
            }
 
            function writeToScreen(message) {
                output.insertAdjacentHTML("beforeend", message);
            }
 
        </script>
    </head>
 
    <body onload="init()">
        <meta charset="utf-8">
        <title>Hello Web sockets</title>
        
 
        <h1 style="text-align: center;">Hello World WebSocket Client</h2>
 
        <br>
 
        <div style="text-align: center;">
            <form action="">
                <input id="textID" name="message" value="Hello WebSocket!" type="text"><br>
                <input onclick="doSend()" value="Send" type="button">
                <input onclick="doClose()" value="Close" type="button">
            </form>
        </div>
        <div id="output"></div>
</body>
</html>
