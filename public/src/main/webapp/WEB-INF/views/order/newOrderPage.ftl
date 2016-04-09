<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Оформление заказа" styles=["css/style.css"] scripts=["js/script.js"] />
<#macro m_body>
<div align="center" class="feedback_main" style="font-size: 25px;">
    <span style="font-weight: 500; letter-spacing: 25px">Оформление заказа</span>
    <@form.form commandName="orderForm" action="/order" acceptCharset="UTF-8" method="post">
        <div class="order_div">
            <span>Имя<label>*</label></span>
            <@form.input path="name" cssClass="order_input_form"/>
            <@form.errors path="name" cssClass="form_error" /><br><br></div>
        <div class="order_div">
            <span>Email<label>*</label></span>
            <@form.input path="email" cssClass="order_input_form"/>
            <@form.errors path="email" cssClass="form_error" /><br><br>
        </div>
        <div class="order_div">
            <span>Телефон<label>*</label></span>
            <@form.input path="phone" cssClass="order_input_form"/>
            <@form.errors path="phone" cssClass="form_error" /><br><br>
        </div>
        <div class="order_div">
                <span>Адресс<label>*</label></span>
                <@form.input path="address" cssClass="order_input_form"/>
                <@form.errors path="address" cssClass="form_error" /><br><br>
        </div>
        <div class="order_div">
            <span>Комментарий<label>*</label></span>
            <@form.textarea path="message" cssClass="order_input_form" cssStyle="height: 100px;"/>
            <@form.errors path="message" cssClass="form_error" /><br><br>
        </div>
        <div class="order_div">
            <span>Принять условия договора</span><label>*</label><br>
            <i>
                <label>
                    <@form.checkbox path="signIn"/>
                    <i> </i>
                    <@form.errors path="signIn" cssClass="form_error" />
                </label>
            </i>
            <br><br>
        </div>
        <div class="but__center" align="center"><input type="submit" value="Оформить заказ &gt;&gt;"></div>
    </div>
    </@form.form>
</div>
</#macro>