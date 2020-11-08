<#ftl encoding="Windows-1251">
<#include "main.ftl"/>
<#include "menu.ftl">
<@main/>
<div style="display: flex">
    <@menu/>
    <div class="optionalFunctionalList">
        <button class="optionalListButton" style="padding-left: 100px">
            Change password
        </button>
        <button class="optionalListButton" style="padding-left: 113px">
            Change login
        </button>
        <a href="http://localhost:8081/myArticle/changeAvatarServlet">
        <button class="optionalListButton" style="padding-left: 110px">
            Change avatar
        </button>
        </a>
    <form method="post">
        <input type="submit" class="optionalListButton" value="Exit" name="exit"/>
    </form>
    </div>
</div>
</body>
</html>