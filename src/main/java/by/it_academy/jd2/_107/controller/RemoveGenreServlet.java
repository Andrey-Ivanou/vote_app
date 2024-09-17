package by.it_academy.jd2._107.controller;

import by.it_academy.jd2._107.service.api.ICandidateService;
import by.it_academy.jd2._107.service.factory.GenreServiceFactory;
import by.it_academy.jd2._107.service.factory.RemoveGenreServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class RemoveGenreServlet extends HttpServlet {

    public static final String SET_CHARTER_ENCODING = "UTF-8";

    public static final String SET_CONTENT_TYPE = "text/html; charset=UTF-8";

    private static final ICandidateService genreService = GenreServiceFactory.getInstance();

    private static final ICandidateService removeGenreService = RemoveGenreServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("genres", genreService.get());

        req.getRequestDispatcher("/template/removeGenreForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(SET_CHARTER_ENCODING);
        resp.setContentType(SET_CONTENT_TYPE);
        PrintWriter writer = resp.getWriter();


        String genre = req.getParameter("genre");


        try {
            removeGenreService.remove(genre);
        } catch (IllegalArgumentException e) {
            writer.write(e.getMessage());
        }

        writer.write("<fieldset><p><span style= 'color: green;'>Complete: Жанр удален!</span></p></fieldset>");
    }
}


