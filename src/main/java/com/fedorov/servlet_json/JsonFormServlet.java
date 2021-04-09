package com.fedorov.servlet_json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fedorov.model_json.JacksonUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Json example:
 * {"id":6,"name":"Fedorov Vision","age":12345}
 */
public class JsonFormServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/view/json_example.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        final String data = req.getParameter("data");
        final JacksonUser user = new ObjectMapper().readValue(data, JacksonUser.class);

        logUser(user);
    }

    private void logUser(final JacksonUser user) {
        System.out.println();
        System.out.println();
        System.out.println("************************************************");
        System.out.println("******* User unmarshalling : " + user +" *******");
        System.out.println("************************************************");
        System.out.println("        Id   : " + user.getId());
        System.out.println("        Name : " + user.getName());
        System.out.println("        Age  : " + user.getAge());
        System.out.println("************************************************");
    }
}
