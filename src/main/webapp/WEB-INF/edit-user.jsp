<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp" %>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<form class="form-horizontal" action="edit-user" method="POST">
    <fieldset>

        <!-- Form Name -->
        <legend>Edit User</legend>

        <input type="hidden" value="${requestScope.user.id}" name="id">

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="login">Login</label>
            <div class="col-md-4">
                <input id="login" value="${requestScope.user.login}" name="login" type="text" placeholder="" class="form-control input-md">
                <span class="help-block">login</span>
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="password">Password</label>
            <div class="col-md-4">
                <input id="password" value="${requestScope.user.password}" name="password" type="password" placeholder="2..20 symbols" class="form-control input-md" required="">
                <span class="help-block">enter Password</span>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="role">Role</label>
            <div class="col-md-4">
                <select id="role" name="role" class="form-control">
                    <c:forEach var="role" items="${applicationScope.roles}">
                        <option value="${role}" ${role==requestScope.user.role?"selected":""}>${role}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <!-- Button (Double) -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="update">Operation</label>
            <div class="col-md-8">
                <c:if test="${requestScope.user==null}">
                <button type="submit" id="update" name="update" class="btn btn-success">Update</button>
                </c:if>
                <c:if test="${requestScope.user!=null}">
                <button type="submit" id="create" name="create" class="btn btn-danger">Create</button>
                </c:if>
            </div>
        </div>

    </fieldset>
</form>


</body>

