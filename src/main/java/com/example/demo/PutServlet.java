package com.example.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/putServlet")
public class PutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Employee employee = new Employee();

        try {
            response.setContentType("text/html");
            String sid = request.getParameter("id");
            int id = Integer.parseInt(sid);

            String name = request.getParameter("name");
            String email = request.getParameter("email");

            employee.setId(id);
            employee.setName(name);
            employee.setEmail(email);
            employee.setCountry(request.getParameter("country"));
        } catch (Exception e) {
            out.println("Sorry! unable to update record\nIOException");
        }

        int status = EmployeeRepository.update(employee);

        try {
            if (status > 0) {
                response.sendRedirect("viewServlet");
            }
        } catch (Exception e) {
            out.println("Sorry! unable to update record");
        } finally {
            out.close();
        }
    }
}
