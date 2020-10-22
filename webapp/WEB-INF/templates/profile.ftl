<#ftl encoding="utf-8">
<!DOCTYPE html>
<html lang="en">
<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <meta charset="UTF-8">
    <title></title>

    <style>
        .MyHistoryArticleHeader{
            height: 45px;
            width: 1534px;
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
            height: 26px;
            width: 80px;
            background-color: wheat;
            color:indianred;
            font-size: 15px;
            border-radius: 20px;
]        }
        .HeaderInput{
            margin-left: 100px;
            height: 27px;
            width: 370px;
            border-radius: 10px;
            background-color: wheat;
            color: red;
            padding-left: 7px;
=        }
        .searchForm{
            margin-top: -7px;
        }
        .myProfileButton{
            display: flex;
            background-color: indianred;
            color: wheat;
            margin-left: 350px;
            margin-top: 10px;
            font-size: 20px;
            border: none;
        }
        #userIcon{
            margin-left: 10px;
        }
        .login{
            margin-left: 90px;
            margin-top: 20px;
            font-size: 28px;
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
    <form class="searchForm">
        <input type="search"  class="HeaderInput" placeholder="Insert the name of title or article">
        <input type="submit" class="searchSubmit" value="Search">
    </form>
    <form>
        <button class="myProfileButton">
            My Profile
            <i class="fa fa-user" id = "userIcon" aria-hidden="true">
            </i>
        </button>
    </form>
    <form action="/signOut">
        <input type="submit" class="ExitButton" value="Exit"/>
    </form>

</div>
</div>
    <div class="login">
        ${login}
    </div>

</body>
</html>