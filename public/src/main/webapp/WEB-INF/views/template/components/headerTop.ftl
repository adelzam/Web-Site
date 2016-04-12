<#-- @ftlvariable name="name" type="java.lang.String" -->
<div>
    <a href="/"><img src="../../../../resources/images/logo.png"
                     style="width: 350pt; margin-left: 16pt; margin-top: 16pt"
                     align="left"></a>
    <div align="right" style="margin-right: 60pt;">
        <div style="margin-right: 50pt; display: inline-block; color: papayawhip; font-size: 18pt; vertical-align: top; margin-top: 30pt; text-decoration: none">
        <#if !name??>
            <a href="/not-yet" style="text-decoration: none; color: papayawhip">Войти</a> | <a href="/not-yet"
                                                                                               style="text-decoration: none; color: papayawhip">Зарегестрироваться</a>
        <#else>
            <a href="/not-yet" style="text-decoration: none; color: papayawhip">${name}</a> | <a href="/not-yet"
                                                                                                 style="text-decoration: none; color: papayawhip">Выйти</a>
        </#if>

        </div>
        <a href="/cart"><img src="../../../../resources/images/cart1.png"
                             style="width: 40pt;margin-top: 20pt"></a>
        <div style="display: inline-block; position: relative">
            <img src="../../../../resources/images/cart2.png"
                 style="width: 77pt;margin-top: 20pt; margin-left: -3pt">
            <h3 style="display: block; position: absolute; color: white; margin-top: -32pt; margin-left: 5pt">${goodcount!"0"}
                :${sum!"0.00"}&#8381 </h3></div>

    </div>
</div>
