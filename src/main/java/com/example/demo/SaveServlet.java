package com.example.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/saveServlet")
public class SaveServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = new Employee();
        PrintWriter out = response.getWriter();

        try {
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String country = request.getParameter("country");

            employee.setName(name);
            employee.setEmail(email);
            employee.setCountry(country);
        } catch (Exception e) {
            out.println("IOException");
        }

        //out.println(employee.toString());
        //out.println(EmployeeRepository.getConnection());

        int status = EmployeeRepository.save(employee);
        //out.println(status);

        try {
            if (status > 0) {
                out.print("Record saved successfully!");
            }
        } catch (Exception e) {
            out.println("Sorry! unable to save record");
        } finally {
            out.close();
        }
    }
}
