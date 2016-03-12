<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Главная страница каталога</title>
</head>
<body class="body">
<div><#include "template/components/headerTop.ftl"></div>
<div class="mainblock">
    <div class="leftmenu"> <#include "template/components/headerMenu.ftl"></div>
    <div align="left">
    ${message!"Сообщения нет!"}
    </div>
</div>
</body>
</html>