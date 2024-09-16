package by.it_academy.jd2._107.controller;

import by.it_academy.jd2._107.service.api.ICandidateService;
import by.it_academy.jd2._107.service.factory.CandidateServiceFactory;
import by.it_academy.jd2._107.service.factory.RemoveCandidateServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class RemoveCandidateServlet extends HttpServlet {

    public static final String SET_CHARTER_ENCODING = "UTF-8";

    public static final String SET_CONTENT_TYPE = "text/html; charset=UTF-8";

    private static final ICandidateService candidateService = CandidateServiceFactory.getInstance();

    private static final ICandidateService removeCandidateService = RemoveCandidateServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("candidates", candidateService.get());

        req.getRequestDispatcher("/template/removeCandidateForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(SET_CHARTER_ENCODING);
        resp.setContentType(SET_CONTENT_TYPE);
        PrintWriter writer = resp.getWriter();


        String candidate = req.getParameter("name");


        try {
            removeCandidateService.remove(candidate);
        } catch (IllegalArgumentException e) {
            writer.write(e.getMessage());
        }

        writer.write("<fieldset><p><span style= 'color: green;'>Complete: Артист удален!</span></p></fieldset>");
    }
}


