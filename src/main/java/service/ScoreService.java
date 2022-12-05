package service;

import bean.Score;
import mapper.ScoreMapper;
import org.apache.ibatis.session.SqlSession;
import util.DBUtil;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ScoreService {
    private SqlSession sqlSession;
    // 将成绩单保存到到数据库中
    public void insert(List<Score> scoreList) throws IOException {
        sqlSession = DBUtil.getSqlSession();
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);
        for (Score score : scoreList)
            mapper.insert(score);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 获取赛事的成绩单
     * @param id_item 赛事编号
     * @return
     */
    public List<Score> queryScoreListOfItem(String id_item) throws IOException {
        sqlSession = DBUtil.getSqlSession();
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);
        List<Score> scoreList = mapper.queryAllByIdItem(id_item);
        sqlSession.commit();
        sqlSession.close();
        // 排序
        Collections.sort(scoreList);
        return scoreList;
    }
}
