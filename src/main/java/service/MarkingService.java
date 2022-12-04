package service;

import bean.Marking;
import bean.user.Player;
import bean.user.Referee;
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
    public void insertToplayerList(String id_referee, String id_item, List<Player> playerList) throws IOException {
        sqlSession = DBUtil.getSqlSession();
        MarkingMapper mapper = sqlSession.getMapper(MarkingMapper.class);
        if (playerList != null)
            for (Player player : playerList) {
                Marking marking = new Marking(id_referee, id_item, player.getAccount(), 0);
                mapper.insert(marking);
            }
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 给运动员分配将要判分的裁判列表refereeList
     *
     * @param id_player
     * @param id_item
     * @param refereeList
     * @throws IOException
     */
    public void insertToRefereeList(String id_player, String id_item, List<Referee> refereeList) throws IOException {
        sqlSession = DBUtil.getSqlSession();
        MarkingMapper mapper = sqlSession.getMapper(MarkingMapper.class);
        if (refereeList != null)
            for (Referee referee : refereeList) {
                Marking marking = new Marking(referee.getAccount(), id_item, id_player, 0);
                mapper.insert(marking);
            }
        sqlSession.commit();
        sqlSession.close();
    }

        /**
         * 获取打分记录
         * @param id_item 项目id
         * @param id_player 运动员id
         */
        public List<Marking> queryByIdItemAndIdPlayer (String id_item, String id_player) throws IOException {
            sqlSession = DBUtil.getSqlSession();
            MarkingMapper mapper = sqlSession.getMapper(MarkingMapper.class);
            List<Marking> markingList = mapper.queryByIdItemAndIDPlayer(id_item, id_player);
            sqlSession.commit();
            sqlSession.close();
            return markingList;
        }

        public Marking search (String id_item, String id_player, String id_referee) throws IOException {
            sqlSession = DBUtil.getSqlSession();
            MarkingMapper mapper = sqlSession.getMapper(MarkingMapper.class);
            Marking marking = mapper.search(id_item, id_player, id_referee);
            sqlSession.commit();
            sqlSession.close();
            return marking;
        }

        public void update (Marking marking) throws IOException {
            sqlSession = DBUtil.getSqlSession();
            MarkingMapper mapper = sqlSession.getMapper(MarkingMapper.class);
            mapper.update(marking);
            sqlSession.commit();
            sqlSession.close();
        }

        /**
         * 获取赛事的所有打分情况
         * @param id_item 赛事编号
         * @return
         */
        public List<Marking> queryAllByIdItem (String id_item) throws IOException {
            sqlSession = DBUtil.getSqlSession();
            MarkingMapper mapper = sqlSession.getMapper(MarkingMapper.class);
            List<Marking> markingList = mapper.queryAllByIdItem(id_item);
            sqlSession.commit();
            sqlSession.close();
            return markingList;
        }
    }
