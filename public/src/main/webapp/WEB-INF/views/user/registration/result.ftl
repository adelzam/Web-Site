<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "../../template/mainTemplate.ftl">
<@mainTemplate title="Успешная регистрация" styles=["css/style.css"] scripts=["js/script.js"] />
<#macro m_body>

<div class="feedback_main" align="center">
    <h1>Спасибо за регестрацию! <br>
        Можете теперь приступить к покупкам</h1>

    <a href="/catalog">Перейти к покупкам</a>
</div>
</#macro>