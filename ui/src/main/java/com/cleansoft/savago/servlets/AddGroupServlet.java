package com.cleansoft.savago.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddGroupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);

    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String html = "<html><body>Group " + name + "</body></html>";
        resp.setContentType("text/html");
        try {
            resp.getWriter().write(html);
            resp.getWriter().flush();
        } catch (IOException e) {
            throw new IllegalArgumentException("error", e);
        }
    }
}
