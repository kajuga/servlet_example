package com.fedorov.servlet;

import java.util.Enumeration;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/RequestServlet")
public class SimpleRequestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // счётчик подключений к сервлету
    private int count = 0;

    public SimpleRequestServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        performTask(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        performTask(request, response);
    }

    private void performTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        try {
            // установка MIME-типа содержания ответа
            resp.setContentType("text/html; charset=UTF-8");
            // поток для данных ответа
            PrintWriter out = resp.getWriter();
            count = ClickOutput.printClick(out, count);
            // обращение к классу бизнес-логики
            if(count == 1)
                RequestInfo.printToBrowser(out, req);
            // закрытие потока
            out.close();
        } catch (UnsupportedEncodingException e) {
            System.err.print("UnsupportedEncoding");
        } catch (IOException e) {
            System.err.print("IOException");
        }
    }
}

class ClickOutput {
    public static int printClick(PrintWriter out, int count) {
        out.print(++count + " -е обращение." + "<br>");
        return count;
    }
}

class RequestInfo {
    static String br = "<br>";
    public static void printToBrowser(PrintWriter out, HttpServletRequest req) {
        out.println("Method: " + req.getMethod());
        out.print(br + "Request URI: " + req.getRequestURI());
        out.print(br + "Protocol: " + req.getProtocol());
        out.print(br + "PathInfo: " + req.getPathInfo());
        out.print(br + "Remote Address: " + req.getRemoteAddr());
        // Извлечение имен заголовочной информации запроса
        Enumeration<String> e = req.getHeaderNames();
        out.print(br + "Header INFO: ");
        while (e.hasMoreElements()) {
            String name = (String) e.nextElement();
            String value = req.getHeader(name);
            out.print(br + name + " = " + value);
        }
    }
}