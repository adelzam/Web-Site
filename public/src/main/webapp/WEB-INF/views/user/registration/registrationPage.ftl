<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "../../template/mainTemplate.ftl">
<@mainTemplate title="Регистрация" styles=["css/style.css"] scripts=["js/script.js"]/>
<#macro m_body>
<div class="feedback_main" align="center">
    <div>
        <@form.form commandName="regForm" action="/reg" acceptCharset="UTF-8" method="post">
            <div>
                <h2>Персональная информация</h2>
            <#--<@form.errors path="*" cssStyle="color: red;" />-->
                <div class= "feedback_div">
                    <span>Имя<label>*</label></span>
                    <@form.input path="firstName" cssClass="feedback_input_form"/>
                    <@form.errors path="firstName" cssClass="form_error"  />
                </div>
                <div class= "feedback_div">
                    <span>Фамилия<label>*</label></span>
                    <@form.input path="lastName"  cssClass="feedback_input_form"/>
                    <@form.errors path="lastName" cssClass="form_error"  />
                </div>
                <div class= "feedback_div">
                    <span>Email Address<label>*</label></span>
                    <@form.input path="email"  cssClass="feedback_input_form"/>
                    <@form.errors path="email" cssClass="form_error"  />
                </div>
                <div class= "feedback_div">
                    <span>Телефон<label>*</label></span>
                    <@form.input path="phone"  cssClass="feedback_input_form"/>
                    <@form.errors path="phone" cssClass="form_error"  />
                </div>
                <div class="clearfix"> </div>
                <i class="news-letter">
                    <label class="">
                        <@form.checkbox path="signIn"/><br>
                        <i></i> Подписаться на обновления<br>
                        <@form.errors path="signIn" cssClass="form_error"  />
                    </label>
                </i>
            </div>
            <div>
                <h2>Информация для входа</h2>
                <div class="feedback_div">
                    <span>Пароль<label>*</label></span><br>
                    <@form.password path="password" cssClass="feedback_input_form" />
                    <@form.errors path="password" cssClass="form_error" />
                </div>
                <div class="feedback_div">
                    <span>Подтвердите пароль<label>*</label></span>
                    <@form.password path="confirmPassword" cssClass="feedback_input_form" />
                    <@form.errors path="confirmPassword" cssClass="form_error" />
                </div>
            </div>
            <div>
                <input type="submit" value="Отправить" class="button_submit">
            </div>
        </@form.form>
    </div>
</div>
</#macro>