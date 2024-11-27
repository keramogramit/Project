package com.javarush.zubakha.project;

import java.io.*;
import java.util.Collection;

import com.javarush.zubakha.project.entity.User;
import com.javarush.zubakha.project.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(value = "/list-user")
public class ListUserServlet extends HttpServlet {
    private final UserService userService = UserService.USER_SERVICE;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Collection<User> userCollection = userService.getAll();
        request.setAttribute("users", userCollection);
        request.getRequestDispatcher("/WEB-INF/list-user.jsp").forward(request, response);

    }

}