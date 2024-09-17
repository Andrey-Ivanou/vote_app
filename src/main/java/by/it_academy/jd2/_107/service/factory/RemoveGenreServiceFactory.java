package by.it_academy.jd2._107.service.factory;

import by.it_academy.jd2._107.service.RemoveCandidateService;
import by.it_academy.jd2._107.service.RemoveGenreService;
import by.it_academy.jd2._107.service.api.ICandidateService;

public class RemoveGenreServiceFactory {

    private static final ICandidateService instance = new RemoveGenreService();

    private RemoveGenreServiceFactory() {
    }

    public static ICandidateService getInstance() {
        return instance;
    }
}
