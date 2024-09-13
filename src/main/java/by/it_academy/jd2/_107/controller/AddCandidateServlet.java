package by.it_academy.jd2._107.controller;

import by.it_academy.jd2._107.service.CandidateService;
import by.it_academy.jd2._107.service.api.ICandidateService;
import by.it_academy.jd2._107.service.factory.CandidateServiceFactory;
import by.it_academy.jd2._107.storage.db.CandidateStorageDBBigSerialPrepare;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class AddCandidateServlet extends HttpServlet {

    public static final String SET_CHARTER_ENCODING = "UTF-8";

    public static final String SET_CONTENT_TYPE = "text/html; charset=UTF-8";

    private static final ICandidateService candidateService = CandidateServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("candidates", candidateService.get());

        req.getRequestDispatcher("/template/candidateForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(SET_CHARTER_ENCODING);
        resp.setContentType(SET_CONTENT_TYPE);
        PrintWriter writer = resp.getWriter();

        /*CandidateStorageDBBigSerialPrepare csdbp = new CandidateStorageDBBigSerialPrepare();*/
        String candidate = req.getParameter("name");
        /*csdbp.create(candidate);*/

        try {
            candidateService.create(candidate);
        } catch (IllegalArgumentException e) {
            writer.write(e.getMessage());
        }
    }
}


