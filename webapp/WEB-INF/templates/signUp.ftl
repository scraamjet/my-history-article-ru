<#ftl encoding="Windows-1251">
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>SignUp</title>
    <style>
        .MyHistoryArticleHeader{
            height: 45px;
            width: 1533px;
            margin-top: -10px;
            color: bisque;
            margin-left: -15px;
            padding-left: 10px;
            font-size: 38px;
            font-family: Harrington,serif;
            background-color:indianred;
        }
        .signUpForm{
            margin-top: 230px;
            margin-left: 550px;
        }
        .logLabel{
            font-size: 24px;
            color:black;
            margin-left: 15px;
            margin-bottom: 7px;
        }
        .logPasInput{
            padding-left: 10px;
            height: 30px;
            width: 370px;
            border-radius: 10px;
        }
        .message{
            background-color: wheat;
            color:indianred;
            font-size: 18px;
            height: 35px;
            width: 1533px;
            margin-top: -10px;
            margin-left: -15px;
            padding-left: 10px;
        }
        .confirmSubmit{
            height: 50px;
            width: 370px;
            text-align: center;
            background-color: indianred;
            color:white;
            font-size: 22px;
            border-radius: 20px;
        }
        .signInLink{
            margin-top: 10px;
            margin-left: 612px;
            font-size: 18px;
        }
        body{
            background-image:url("drawable/background1.jpg");
            background-size: cover;
        }
    </style>
</head>
<body>
<#if message?has_content>
    <div class="message">${message}</div>
</#if>
<div class="MyHistoryArticleHeader">
    MyHistoryArticle.ru
</div>
<form class = "signUpForm" method="post">
    <label class="logLabel">Don't have an account? Sign up now!</label>
    <br>
    <input class="logPasInput" type="text" name="login" placeholder="insert the login"/>
    <br>
    <input class="logPasInput" type="password" name="password" placeholder="insert the password"/>
    <br>
    <br>
    <input class="confirmSubmit" type="submit" value="Sign up"/>
</form>
<a class="signInLink" href="http://localhost:8081/myArticle/signIn">
    Already have an account?Sign in!
</a>
</body>
</html>