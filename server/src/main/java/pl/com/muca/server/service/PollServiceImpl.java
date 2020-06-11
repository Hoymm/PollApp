package pl.com.muca.server.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import pl.com.muca.server.dao.PollDao;
import pl.com.muca.server.entity.Poll;

@Component
public class PollServiceImpl implements PollService {
  @Resource
  PollDao pollDao;

  @Override
  public List<Poll> findAll(String token) {
    return pollDao.findAll(token);
  }

  @Override
  public void insertPoll(Poll poll) {
    pollDao.insertPoll(poll);
  }

  @Override
  public void updatePoll(Poll poll) {
    pollDao.updatePoll(poll);
  }

  @Override
  public void executeUpdatePoll(Poll poll) {
    pollDao.executeUpdatePoll(poll);
  }

  @Override
  public void deletePoll(Poll poll) {
    pollDao.deletePoll(poll);
  }
}
