package com.javarush.zubakha.project;

import com.javarush.zubakha.project.entity.Role;
import com.javarush.zubakha.project.entity.User;
import com.javarush.zubakha.project.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.Optional;

@WebServlet(value = "/edit-user")
public class EditUserServlet extends HttpServlet {
    private final UserService userService = Winter.find(UserService.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        config.getServletContext().setAttribute("roles", Role.values());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stringId = req.getParameter("id");
        if (stringId != null) {
            long id = Long.parseLong(stringId);
            Optional<User> optionalUser = userService.get(id);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                req.setAttribute("user", user);
            }
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/edit-user.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = User.builder()
                .login(request.getParameter("login"))
                .password(request.getParameter("password"))
                .role(Role.valueOf(request.getParameter("role")))
                .build();
        if (request.getParameter("create") != null) {
            userService.create(user);
        } else if (request.getParameter("update") != null) {
            user.setId(Long.parseLong(request.getParameter("id")));
            userService.update(user);

        }
        response.sendRedirect("edit-user?id=" + user.getId());
    }

}