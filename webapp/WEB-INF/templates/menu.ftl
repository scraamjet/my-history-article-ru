<#macro menu>
    <div class="functionalList">
        <a href="http://localhost:8081/myArticle/profile" aria-hidden="true">
            <button class="functionalListButton" name="myProfile">
                My profile
            </button>
        </a>
        <a href="http://localhost:8081/myArticle/myArticles">
            <button class="functionalListButton" name="myArticles">
                My articles
            </button>
        </a>
        <a href="http://localhost:8081/myArticle/news">
            <button class="functionalListButton" name="news" style="padding-left:75px ">
                News
            </button>
        </a>
        <a href="http://localhost:8081/myArticle/options">
        <button class="functionalListButton" name="options" style="padding-left: 67px">
            Options
        </button>
        </a>
        <a href="http://localhost:8081/myArticle/addArticle">
            <button type="submit" class="functionalListButton" name = "addArticle">
                +add article
            </button>
        </a>
    </div>
</#macro>