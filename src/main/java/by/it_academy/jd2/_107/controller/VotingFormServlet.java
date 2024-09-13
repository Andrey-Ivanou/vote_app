package by.it_academy.jd2._107.controller;

import by.it_academy.jd2._107.dto.VoteDTO;
import by.it_academy.jd2._107.service.CandidateService;
import by.it_academy.jd2._107.service.api.ICandidateService;
import by.it_academy.jd2._107.service.api.IVoteService;
import by.it_academy.jd2._107.service.VoteService;
import by.it_academy.jd2._107.service.factory.CandidateServiceFactory;
import by.it_academy.jd2._107.service.factory.GenreServiceFactory;
import by.it_academy.jd2._107.service.factory.VoteServiceFactory;
import by.it_academy.jd2._107.storage.db.GetVoteResultStorageDB;
import by.it_academy.jd2._107.storage.memory.VoteStorage;
import by.it_academy.jd2._107.storage.memory.factory.VoteStorageFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class VotingFormServlet extends HttpServlet {

    public static final String SET_CHARTER_ENCODING = "UTF-8";
    public static final String SET_CONTENT_TYPE = "text/html; charset=UTF-8";
    private static IVoteService voteService = VoteServiceFactory.getInstance();
    private static ICandidateService genreService = GenreServiceFactory.getInstance();
    private static ICandidateService candidateService = CandidateServiceFactory.getInstance();
    private final static String DB_FILE_PATCH = "JsonDB.json";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setAttribute("candidates", candidateService.get());
        req.setAttribute("genres", genreService.get());

        req.getRequestDispatcher("/template/voteForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(SET_CHARTER_ENCODING);
        resp.setContentType(SET_CONTENT_TYPE);
        PrintWriter writer = resp.getWriter();

        VoteDTO voteDTO = new VoteDTO();

        voteDTO.setCandidate(Long.valueOf(req.getParameter("name")));
        voteDTO.setGenres(req.getParameterValues("genre"));
        voteDTO.setComment(req.getParameter("comment"));

        try {
            voteService.create(new VoteDTO(voteDTO.getCandidate(), voteDTO.getGenres(), voteDTO.getComment()));

        } catch (IllegalArgumentException e) {
            writer.write(e.getMessage());
        }
        GetVoteResultStorageDB getVoteResultStorageDB = new GetVoteResultStorageDB();

        writer.print("<h2>Лутший кандидат</h2>");
        writer.write("<p>" + getVoteResultStorageDB.getArtistResult() + "</p>");

        writer.print("<h2>Лутший жанр</h2>");
        writer.write("<p>" + getVoteResultStorageDB.getGenreResult() + "</p>");

    }




        /*writer.print("<h2>Лутший кандидат</h2>");
        VoteStorageFactory.getInstance().getCandidate().entrySet().stream()
                .sorted(Map.Entry.<Long, Integer>comparingByValue().reversed())
                .forEach(stringIntegerEntry -> {
                    writer.write("<p>" + stringIntegerEntry.getKey() + " - " + stringIntegerEntry.getValue() + "</p>");
                });

        writer.print("<h2>Лутший жанр</h2>");
        VoteStorageFactory.getInstance().getGenres().entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(stringIntegerEntry -> {
                    writer.write("<p>" + stringIntegerEntry.getKey() + " - " + stringIntegerEntry.getValue() + "</p>");
                });

        writer.print("<h2>Комментарии пользователей</h2>");
        System.out.println(VoteStorageFactory.getInstance().getComment());
        }*/ /*else {
        writer.print("<fieldset><p><span style= 'color: red;'>Форма непринята</span></p></fieldset>");
        }*/
    }



