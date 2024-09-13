package by.it_academy.jd2._107.controller;

import by.it_academy.jd2._107.service.GenreService;
import by.it_academy.jd2._107.service.api.ICandidateService;
import by.it_academy.jd2._107.service.factory.CandidateServiceFactory;
import by.it_academy.jd2._107.service.factory.GenreServiceFactory;
import by.it_academy.jd2._107.storage.db.factory.GenreStorageDBBigSerialPrepareFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class AddGenreServlet extends HttpServlet {

    public static final String SET_CHARTER_ENCODING = "UTF-8";

    public static final String SET_CONTENT_TYPE = "text/html; charset=UTF-8";

    private static final ICandidateService genreService = GenreServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("genres", genreService.get());

        req.getRequestDispatcher("/template/genreForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(SET_CHARTER_ENCODING);
        resp.setContentType(SET_CONTENT_TYPE);
        PrintWriter writer = resp.getWriter();

        String genres = req.getParameter("genre");

        try {
            genreService.create(genres);
        } catch (IllegalArgumentException e) {
            writer.write(e.getMessage());
        }
    }
}


