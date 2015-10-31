<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Авторизация</title>
    <link rel="stylesheet" type="text/css" href="../../resources/css/login.css"/>
</head>
<body onload='document.loginForm.username.focus();'>

<section class="container">
    <div class="login">
        <h1>Добро пожаловать в Brooklyn!</h1>
        <c:if test="${not empty error}">
            <div>${error}</div>
        </c:if>
        <form name='loginForm' method="post" action="/j_spring_security_check">
            <p><input type="text" name="username" value="" placeholder="логин" required></p>
            <p><input type="password" name="password" value="" placeholder="пароль" required></p>
            <p class="remember_me">
                <label>
                    <input type="checkbox" name="remember_me" id="remember_me">
                    Запомни меня
                </label>
            </p>
            <p class="submit"><input type="submit" name="commit" value="Войти"></p>
        </form>
    </div>
</section>

</body>
</html>