package com.fedorov.servlet_json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fedorov.model_json.JacksonUser;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsonHandlerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        final JacksonUser user = new JacksonUser(1, "Fedorov Aleksandr", 77);
        final String json = new ObjectMapper().writeValueAsString(user);
        resp.getWriter().write(json);
    }
}
