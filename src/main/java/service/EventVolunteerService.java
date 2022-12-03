package service;

import bean.EventReferee;
import bean.EventVolunteer;
import bean.user.User;
import mapper.EventRefereeMapper;
import mapper.EventVolunteerMapper;
import org.apache.ibatis.session.SqlSession;
import util.DBUtil;

import java.io.IOException;
import java.util.List;

public class EventVolunteerService {
    private SqlSession sqlSession;

    public void insert(EventVolunteer eventVolunteer) throws IOException {
        sqlSession = DBUtil.getSqlSession();
        EventVolunteerMapper mapper = sqlSession.getMapper(EventVolunteerMapper.class);
        mapper.insert(eventVolunteer);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 获取志愿者的所有报名记录
     */
    public List<EventVolunteer> getAllEventVolunteer(User user) throws IOException {
        sqlSession = DBUtil.getSqlSession();
        EventVolunteerMapper mapper = sqlSession.getMapper(EventVolunteerMapper.class);
        List<EventVolunteer> eventVolunteerList = mapper.queryAllByIdVolunteer(user.getAccount());
        sqlSession.commit();
        sqlSession.close();
        return eventVolunteerList;
    }
}
