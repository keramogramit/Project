package com.javarush.zubakha.project;

import com.javarush.zubakha.project.entity.User;
import com.javarush.zubakha.project.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.Collection;

@WebServlet(value = "/edit-user")
public class EditUserServlet extends HttpServlet {
    private final UserService userService = UserService.USER_SERVICE;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String stringId = request.getParameter("id");
        long id = Long.parseLong(stringId);
        User user = userService.get(id).orElseThrow();
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/edit-user.jsp").forward(request, response);

    }

}