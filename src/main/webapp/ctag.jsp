<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/tlds/mytld" prefix="my" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="myTag" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <my:hello>
                John
            </my:hello>
        </h1>
        <myTag:chart work="8" eat="2" commute="2" tv="2" sleep="7" >
            我的標籤
        </myTag:chart>
    </body>
</html>
