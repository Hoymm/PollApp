package pl.com.muca.server.dao.poll;

import java.sql.SQLException;
import java.util.List;
import pl.com.muca.server.entity.Poll;
import pl.com.muca.server.entity.PollState;

/**
 * API methods for modifying and reading from the 'poll' table.
 */
public interface PollDao {
  List<Poll> findAllPolls(String token) throws Exception;

  PollState getPollState(int pollId, String token) throws Exception;

  List<Poll> findAllMyPolls(String token);

  Poll getPollDetails(int pollId, String token) throws Exception;

  void insertPoll(Poll poll, String token) throws SQLException;

  Integer getLatestPollId();

  void insertPollTableData(Poll poll);

  String getPollName(int pollId);

  int getPollId(int questionId) throws SQLException;
}
