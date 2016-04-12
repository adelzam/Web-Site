<#include "../../template/mainTemplate.ftl">
<@mainTemplate title="Авторизация" styles=["css/style.css"] scripts=["js/script.js"] />
<#macro m_body>

<div class="feedback_main" align="center">
    <div>
        <h3>Вход в личный кабинет</h3>
        <div>
            <#if error?has_content>
                <div style="color: red;">Неверный логин или пароль...</div>
            </#if>
            <form name="authForm" id="authForm" action="/j_spring_security_check" method="post">
                <div>
                    <span><img src="../../../../resources/images/user.png" style="width: 43px; vertical-align: top; margin-top: 8pt"></span>
                    <input type="text" name="j_username" class="feedback_input_form"/>
                </div>
                <div>
                    <span class="pass"><img src="../../../../resources/images/pass.png" style="width: 43px; vertical-align: top; margin-top: 8pt"></span>
                    <input type="password" name="j_password" class="feedback_input_form"/>
                </div>
                <div>
                    <input id="remember_me" name="_spring_security_remember_me" type="checkbox"/>
                    <label for="remember_me" class="inline">Запомните меня</label>
                </div>
                <input type="submit" value="Login" style="width: 50pt"/>
                <br>
                <a href="/reg" style="margin-left: 10px; text-decoration: none">Создать аккаунт</a>
            </form>
        </div>
    </div>
</div>
</#macro>