package com.example.demo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/viewByIDServlet")
public class ViewByIDServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        try {
            response.setContentType("text/html");
            String sid = request.getParameter("id");
            int id = Integer.parseInt(sid);
            Employee employee = EmployeeRepository.getEmployeeById(id);

            out.print(employee);
        } catch (Exception e) {
            out.println("Exception");
        } finally {
            out.close();
        }
    }
}
