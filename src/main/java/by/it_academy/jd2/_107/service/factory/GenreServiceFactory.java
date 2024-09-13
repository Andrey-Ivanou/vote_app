package by.it_academy.jd2._107.service.factory;

import by.it_academy.jd2._107.service.CandidateService;
import by.it_academy.jd2._107.service.GenreService;
import by.it_academy.jd2._107.service.api.ICandidateService;

public class GenreServiceFactory {

    private static final ICandidateService instance = new GenreService();

    private GenreServiceFactory() {
    }

    public static ICandidateService getInstance() {
        return instance;
    }
}
