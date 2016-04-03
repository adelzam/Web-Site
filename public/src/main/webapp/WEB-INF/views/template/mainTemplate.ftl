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
    <#include "components/header.ftl" />
</div>
    <@m_body/>
</body>
</html>
</#macro>