package by.it_academy.jd2._107.storage.memory.factory;

import by.it_academy.jd2._107.storage.memory.VoteStorage;

public class VoteStorageFactory {

    private final static VoteStorage instance = new VoteStorage();

    public static VoteStorage getInstance(){
        return instance;
    }
}
