package by.it_academy.jd2._107.storage.db.factory;

import by.it_academy.jd2._107.storage.api.ICandidateStorage;
import by.it_academy.jd2._107.storage.api.IVoteStorage;
import by.it_academy.jd2._107.storage.db.GenreStorageDBBigSerialPrepare;
import by.it_academy.jd2._107.storage.db.VoteStorageDBBigSerialPrepare;

public class VoteStorageDBBigSerialPrepareFactory {

    private static IVoteStorage instance;

    static {
        instance = new VoteStorageDBBigSerialPrepare();
    }

    public static IVoteStorage getInstance() {
        return instance;
    }
}
