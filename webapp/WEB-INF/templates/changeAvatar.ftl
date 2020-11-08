<#ftl encoding="Windows-1251">
<#include "main.ftl"/>
<#include "menu.ftl">
<@main/>
<div style="display: flex">
    <@menu/>
    <form method="POST" enctype="multipart/form-data" class="changeAvatarForm">
        <br>
        <input type="file" name="file1"/>
        <br>
        <br>
        <input type="submit" value="Upload" class="loadIconButton" name="load"/>
    </form>
    </div>
</div>
</body>
</html>