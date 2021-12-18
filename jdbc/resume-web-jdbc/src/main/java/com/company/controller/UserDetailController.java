package com.company.controller;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import com.company.Context;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserDetailController", urlPatterns = {"/userdetail"})
public class UserDetailController extends HttpServlet {

    private final UserDaoInter userDao = Context.instanceUserDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        String action = request.getParameter("action");
        System.out.println(action);
        if (action.equals("update")) {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            User user = userDao.getById(id);
            user.setName(name);
            user.setSurname(surname);
            userDao.updateUser(user);
//        response.getOutputStream().print("Done !!!!!!");
//        response.getOutputStream().close();

        } else if (action.equals("delete")) {
            userDao.removeUser(id);
        }
        response.sendRedirect("users");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String userIdStr = request.getParameter("id");
            if (userIdStr == null || userIdStr.trim().isEmpty()) {
                throw new IllegalArgumentException("id is not defined");

            }
            Integer userId = Integer.parseInt(userIdStr);
            UserDaoInter userDao = Context.instanceUserDao();
            User u = userDao.getById(userId);
            if (u == null) {
                throw new IllegalArgumentException("there is no user id");

            }
            request.setAttribute("user", u);
            request.getRequestDispatcher("userdetail.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error?msg=" + e.getMessage());
        }
    }
}
