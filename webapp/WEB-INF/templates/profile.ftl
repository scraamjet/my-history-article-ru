<#ftl encoding="Windows-1251">
<!DOCTYPE html>
<html lang="en">
<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <meta charset="UTF-8">
    <title></title>

    <style>
        .MyHistoryArticleHeader{
            height: 45px;
            width: 1533px;
            margin-top: -10px;
            color: bisque;
            margin-right: -15px;
            margin-left: -15px;
            padding-left: 10px;
            font-size: 38px;
            font-family: Harrington,serif;
            background-color:indianred;
            display: flex;
        }

        .searchSubmit{
            background-color: wheat;
            color:indianred;
            font-size: 15px;
            border-radius: 20px;
            margin-top:10px;
            margin-left: 870px;
            width: 150px;
            height: 27px
        }
        .HeaderInput{
            margin-left: 100px;
            height: 27px;
            width: 370px;
            border-radius: 10px;
            background-color: wheat;
            color: red;
            padding-left: 7px;
        }
        .searchForm{
            margin-top: -7px;
        }
        .functionalList{
            display: block;
            margin-left: 200px;
            margin-top: 20px;
        }
        .functionalListButton{
            display: flex;
            background-color: indianred;
            color: bisque;
            font-size: 20px;
            height: 30px;
            width: 200px;
            border: none;
            padding-top: 3px;
            padding-left: 55px;
            margin-top: 10px;
        }
        #userIcon{
            margin-left: 10px;
        }

        a{
            text-decoration: none;
        }
    </style>
</head>
<body bgcolor="#ffe4c4">
<#if message?has_content>
    <p>${message}</p>
</#if>
<div style="display: flex">
<div class="MyHistoryArticleHeader">
    MyHistoryArticle.ru
    <a href="http://localhost:8081/myArticle/advancedSearch">
    <button name = "Search" class="searchSubmit">
        Search
    </button>
    </a>
</div>
</div>
<div style="display: flex">
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
        <button class="functionalListButton" name="options" style="padding-left: 67px">
            Options
        </button>
        <form method="post">
            <input type="submit" class="functionalListButton" style="padding-left: 10px" value="Exit" name="exit"/>
        </form>
    </div>
    <img src="WEB-INF/drawable/default_user_icon.jpg" width="200px" height="250px" style="margin-left: 80px;margin-top: 10px">
    <div style="margin-left: 70px;font-size: 30px">
        <br>
        ${login}
        <br>
        <br>
        Number of published article: ${articlesCount}
        <br>
        <br>
        Articles average rate: ${articleRATE}
        <a href="http://localhost:8081/myArticle/addArticle">
            <button type="submit" class="functionalListButton">
                +add article
            </button>
        </a>
    </div>
</div>
</body>
</html>