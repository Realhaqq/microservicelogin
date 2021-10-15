Hello my JSP Regsiter
<div>
    <form action="/set-user" method="post">

        <c:if test="${not empty error}">
            <h5>${error}</h5>
        </c:if>
        <c:if test="${not empty success}">
            <h5>${success}</h5>
        </c:if>
        <div><input type="text" name="username" value="" placeholder="Username"></div>
        <div><input type="password" name="password1" value="" placeholder="Password1"></div>
        <div><input type="password" name="password2" value="" placeholder="Password2"></div>
        <div><input type="submit" name="register" value="Login"></div>
        <div><a href="/login">Login</a></div>
        <div></div>
    </form>



</div>