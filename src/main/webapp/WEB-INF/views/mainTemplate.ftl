<#macro mainTemplate title="" styles=[] scripts=[] >
<!DOCTYPE html>
<html lang="ru">
<head>
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
    <#include "head.ftl" />
    <#include "leftmenu.ftl"/>
</div>
<br>
<div id="container">
    <@m_body />
</div>
</body>
</html>
</#macro>