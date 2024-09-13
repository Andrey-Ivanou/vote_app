package by.it_academy.jd2._107.service.factory;

import by.it_academy.jd2._107.service.VoteService;
import by.it_academy.jd2._107.storage.memory.factory.VoteStorageFactory;

public class VoteServiceFactory {

    private final static VoteService instance = new VoteService(VoteStorageFactory.getInstance(), CandidateServiceFactory.getInstance());

    public static VoteService getInstance(){
        return instance;}
}
