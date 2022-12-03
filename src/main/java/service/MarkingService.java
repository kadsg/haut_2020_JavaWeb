package service;

import bean.Marking;
import bean.user.Player;
import mapper.MarkingMapper;
import org.apache.ibatis.session.SqlSession;
import util.DBUtil;

import java.io.IOException;
import java.util.List;

public class MarkingService {
    private SqlSession sqlSession;
    /**
     * 给裁判员id_referee分配将要判分的运动员列表playerList
     */
    public void insert(String id_referee, String id_item, List<Player> playerList) throws IOException {
        sqlSession = DBUtil.getSqlSession();
        MarkingMapper mapper = sqlSession.getMapper(MarkingMapper.class);
        if (playerList!=null)
            for (Player player : playerList) {
                Marking marking = new Marking(id_referee, id_item, player.getAccount(), 0);
                mapper.insert(marking);
            }
        sqlSession.commit();
        sqlSession.close();
    }
}
