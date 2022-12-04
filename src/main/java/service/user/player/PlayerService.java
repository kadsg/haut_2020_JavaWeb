package service.user.player;

import bean.EventPlayer;
import bean.user.Player;
import bean.user.User;
import mapper.user.PlayerMapper;
import org.apache.ibatis.session.SqlSession;
import service.EventPlayerService;
import util.DBUtil;

import java.io.IOException;
import java.util.List;

public class PlayerService {
    private SqlSession sqlSession;
    /**
     * 获取运动员的赛事表
     * @param user 运动员
     * @return List<EventPlayer>
     */
    public List<EventPlayer> querySignUpList(User user) throws IOException {
        return new EventPlayerService().queryAllEventOfPlayer(user);
    }

    public Player search(String id_player) throws IOException {
        sqlSession = DBUtil.getSqlSession();
        PlayerMapper mapper = sqlSession.getMapper(PlayerMapper.class);
        Player player = mapper.select(id_player);
        sqlSession.commit();
        sqlSession.close();
        return player;
    }
}
