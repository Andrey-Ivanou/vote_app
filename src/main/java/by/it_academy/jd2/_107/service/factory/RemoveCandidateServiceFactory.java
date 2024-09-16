package by.it_academy.jd2._107.service.factory;

import by.it_academy.jd2._107.service.CandidateService;
import by.it_academy.jd2._107.service.RemoveCandidateService;
import by.it_academy.jd2._107.service.api.ICandidateService;

public class RemoveCandidateServiceFactory {

    private static final ICandidateService instance = new RemoveCandidateService();

    private RemoveCandidateServiceFactory() {
    }

    public static ICandidateService getInstance() {
        return instance;
    }
}
