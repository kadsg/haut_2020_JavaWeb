package service;

import bean.EventPlayer;
import bean.item.Item;
import bean.user.Player;
import bean.user.User;
import mapper.EventPlayerMapper;
import org.apache.ibatis.session.SqlSession;
import util.DBUtil;

import java.io.IOException;
import java.util.List;

public class EventPlayerService {
    private SqlSession sqlSession;
    /**
     * 获取运动员的报名列表
     */
    public List<EventPlayer> queryAllEventOfPlayer(User user) throws IOException {
        sqlSession = DBUtil.getSqlSession();
        EventPlayerMapper mapper = sqlSession.getMapper(EventPlayerMapper.class);
        List<EventPlayer> itemList = (List<EventPlayer>) mapper.queryAllByIdSport(user.getAccount());
        sqlSession.commit();
        sqlSession.close();
        return itemList;
    }
}
