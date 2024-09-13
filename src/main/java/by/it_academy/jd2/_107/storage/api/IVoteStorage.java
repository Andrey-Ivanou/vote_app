package by.it_academy.jd2._107.storage.api;

import by.it_academy.jd2._107.dto.SaveVoteDTO;

public interface IVoteStorage {

    Long create(SaveVoteDTO voteDTO);
}
