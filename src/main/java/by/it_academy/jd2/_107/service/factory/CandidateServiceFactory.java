package by.it_academy.jd2._107.service.factory;

import by.it_academy.jd2._107.service.CandidateService;
import by.it_academy.jd2._107.service.api.ICandidateService;

public class CandidateServiceFactory {

    private static final ICandidateService instance = new CandidateService();

    private CandidateServiceFactory() {
    }

    public static ICandidateService getInstance() {
        return instance;
    }
}
