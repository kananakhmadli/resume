package com.company.controller;

import com.company.Context;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UserActionController", urlPatterns = {"/useraction"})
public class UserActionController extends HttpServlet {

    private UserDaoInter userDao = Context.instanceUserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("update")) {
            int id = Integer.valueOf(request.getParameter("id"));
            User user = userDao.getById(id);
            request.setAttribute("user", user);
            request.getRequestDispatcher("updatePage.jsp").forward(request, response);
        } else if (action.equals("info")) {
            int id = Integer.valueOf(request.getParameter("id"));
            User user = userDao.getById(id);
            request.setAttribute("user", user);
            request.getRequestDispatcher("info.jsp").forward(request, response);
        } else if (action.equals("add")) {
            request.getRequestDispatcher("addPage.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("update")) {
            try {
                int id = Integer.valueOf(request.getParameter("id"));
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String birthDate = request.getParameter("birthdate");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = dateFormat.parse(birthDate);

                User user = userDao.getById(id);
                user.setBirthDate(date);
                user.setName(name);
                user.setSurname(surname);
                user.setPhone(phone);
                user.setEmail(email);
                userDao.updateUser(user);
                response.sendRedirect("users");
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        } else if (action.equals("delete")) {
            int id = Integer.valueOf(request.getParameter("id"));
            userDao.removeUser(id);
            response.sendRedirect("users");

        } else if (action.equals("add")) {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String password = request.getParameter("password");

            User u = new User(null, name, surname, email, phone, password);
            userDao.addUser(u);
            response.sendRedirect("users");
        }
    }
}