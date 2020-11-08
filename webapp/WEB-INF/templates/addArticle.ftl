<#ftl encoding="Windows-1251">
<#include "main.ftl"/>
<#include "menu.ftl">
<@main/>
<div style="display: flex">
    <@menu/>
    <form method="post" style="margin-left: 150px; margin-top: 50px;display: block">
        <input type="text" class="titleArea" name="title" placeholder="Insert the title of your article">
        <br>
        <br>
        <textarea class="textArea" name="text" placeholder="Your article...">
        </textarea>
        <br>
        <br>
        <input type="submit" class="addArticleSubmit" value="Publish" name="addArticle">
    </form>
</div>
</body>
</html>