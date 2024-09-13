package by.it_academy.jd2._107.service;

import by.it_academy.jd2._107.dto.SaveVoteDTO;
import by.it_academy.jd2._107.dto.VoteDTO;
import by.it_academy.jd2._107.service.api.ICandidateService;
import by.it_academy.jd2._107.service.api.IVoteService;
import by.it_academy.jd2._107.storage.api.ICandidateStorage;
import by.it_academy.jd2._107.storage.api.IVoteStorage;
/*import by.it_academy.jd2._107.storage.db.CrossTableDBBigPrepare;*/
import by.it_academy.jd2._107.storage.db.GetVoteResultStorageDB;
import by.it_academy.jd2._107.storage.db.VoteStorageDBBigSerialPrepare;
import by.it_academy.jd2._107.storage.db.factory.CandidateStorageDBBigSerialPrepareFactory;
/*import by.it_academy.jd2._107.storage.db.factory.CrossTableDBBigPrepareFactory;*/
import by.it_academy.jd2._107.storage.db.factory.GenreStorageDBBigSerialPrepareFactory;
import by.it_academy.jd2._107.storage.db.factory.VoteStorageDBBigSerialPrepareFactory;


import java.time.LocalDateTime;

public class VoteService implements IVoteService {

    private final IVoteStorage voteStorage;

    private final ICandidateService candidateService;

    private final ICandidateStorage candidateStorageDB = CandidateStorageDBBigSerialPrepareFactory.getInstance();

    private final IVoteStorage voteStorageDB = VoteStorageDBBigSerialPrepareFactory.getInstance();

    public VoteService(IVoteStorage voteStorage, ICandidateService candidateService) {
        this.voteStorage = voteStorage;
        this.candidateService = candidateService;
    }

    @Override
    public void create(VoteDTO vote) {

        if (vote.getCandidate().equals(candidateStorageDB.get().containsKey(candidateStorageDB)) ||
                vote.getComment().length() < 0 || vote.getComment().length() >= 100 ||
                vote.getGenres().length < 3 || vote.getGenres().length > 5) {
            throw new IllegalArgumentException("Артист не существует");
        }
        if (vote.getCandidate() == null) {
            throw new IllegalArgumentException("Артист пуст");
        } else {
            LocalDateTime now = LocalDateTime.now();
            voteStorageDB.create(new SaveVoteDTO(now, vote));
        }
        throw new IllegalArgumentException("<fieldset><p><span style= 'color: green;'>Форма принята</span></p></fieldset>");
    }
}


