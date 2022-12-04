package service;

import bean.EventReferee;
import bean.user.User;
import mapper.EventRefereeMapper;
import org.apache.ibatis.session.SqlSession;
import util.DBUtil;

import java.io.IOException;
import java.util.List;

public class EventRefereeService {
    private SqlSession sqlSession;

    public void insert(EventReferee eventReferee) throws IOException {
        sqlSession = DBUtil.getSqlSession();
        EventRefereeMapper mapper = sqlSession.getMapper(EventRefereeMapper.class);
        mapper.insert(eventReferee);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 获取裁判的所有报名记录
     */
    public List<EventReferee> getAllEventOfReferee(User user) throws IOException {
        sqlSession = DBUtil.getSqlSession();
        EventRefereeMapper mapper = sqlSession.getMapper(EventRefereeMapper.class);
        List<EventReferee> eventRefereeList = mapper.queryAllByIdReferee(user.getAccount());
        sqlSession.commit();
        sqlSession.close();
        return eventRefereeList;
    }
}
