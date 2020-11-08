<#ftl encoding="Windows-1251">
<#include "main.ftl"/>
<#include "menu.ftl">
<@main/>
<div style="display: flex">
        <@menu/>
        <form method="post" class="titleSearchForm">
        <input  name = "title" style="background: white; height:20px;font-size: 20px; margin-top:20px;margin-left: 15px; width: 360px;  color: indianred; border-radius: 10px"
                placeholder="Insert the title of the article">
        <br>
        <br>
        <br>
        <input type="submit" class="formSearchSubmit" name= "search" value="Search">
    </form>
</div>
</body>
</html>