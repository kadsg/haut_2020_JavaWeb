package service;

import bean.EventPlayer;
import bean.item.Item;
import bean.user.Player;
import bean.user.User;
import mapper.EventPlayerMapper;
import mapper.user.PlayerMapper;
import org.apache.ibatis.session.SqlSession;
import util.DBUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EventPlayerService {
    private SqlSession sqlSession;

    public void insert(EventPlayer eventPlayer) throws IOException {
        sqlSession = DBUtil.getSqlSession();
        EventPlayerMapper mapper = sqlSession.getMapper(EventPlayerMapper.class);
        mapper.insert(eventPlayer);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 获取运动员的报名列表
     */
    public List<EventPlayer> queryAllEventOfPlayer(User user) throws IOException {
        sqlSession = DBUtil.getSqlSession();
        EventPlayerMapper mapper = sqlSession.getMapper(EventPlayerMapper.class);
        List<EventPlayer> itemList = (List<EventPlayer>) mapper.queryAllByIdPlayer(user.getAccount());
        sqlSession.commit();
        sqlSession.close();
        return itemList;
    }

    /**
     * 获取报名项目的运动员列表
     */
    public List<Player> queryAllPlayerOfItem(Item item) throws IOException {
        sqlSession = DBUtil.getSqlSession();
        EventPlayerMapper eventPlayerMapper = sqlSession.getMapper(EventPlayerMapper.class);
        List<EventPlayer> eventPlayerList = eventPlayerMapper.queryAllByIdItem(item.getId());

        sqlSession.commit();
        sqlSession.close();

        sqlSession = DBUtil.getSqlSession();
        PlayerMapper playerMapper = sqlSession.getMapper(PlayerMapper.class);
        List<Player> playerList = null;

        if(eventPlayerList != null) {
            if (playerList == null)
                playerList = new ArrayList<>();
            for (EventPlayer eventPlayer : eventPlayerList) {
                Player player = playerMapper.select(eventPlayer.getId_sport());
                playerList.add(player);
            }
        }

        return playerList;
    }

    /**
     * 更新参赛/成绩记录
     */
    public void updateJoin(EventPlayer eventPlayer) throws IOException {
        sqlSession = DBUtil.getSqlSession();
        EventPlayerMapper mapper = sqlSession.getMapper(EventPlayerMapper.class);
        eventPlayer.setJoin(true);
        mapper.update(eventPlayer);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 获取报名记录
     */
    public EventPlayer getEventPlayer(String id_player, String id_item) throws IOException {
        sqlSession = DBUtil.getSqlSession();
        EventPlayerMapper mapper = sqlSession.getMapper(EventPlayerMapper.class);
        EventPlayer eventPlayer = mapper.queryByIdPlayerAndIdItem(id_player, id_item);
        sqlSession.commit();
        sqlSession.close();
        return eventPlayer;
    }
}
