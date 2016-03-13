<#macro mainTemplate title="" styles=[] scripts=[] >
<!DOCTYPE html>
<html lang="ru">
<head>
    <!-- подключение библиотеки jQuery -->
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
    <meta charset="UTF-8">
    <title>${title}</title>
    <#list styles as css>
        <link rel="stylesheet" href="../../resources/${css}" type="text/css"/>
    </#list>
    <#list scripts as js>
        <script src="../../resources/${js}" type="text/javascript" defer></script>
    </#list>
</head>
<body>
<div align="center">
    <#include "template/components/header.ftl" />
</div>
<div id="container" align="center">
    <@m_body/>
</div>
</body>
</html>
</#macro>