package service.login;

import bean.user.User;
import mapper.user.AdministratorMapper;
import mapper.user.PlayerMapper;
import mapper.user.RefereeMapper;
import mapper.user.VolunteerMapper;
import org.apache.ibatis.session.SqlSession;
import util.DBUtil;

import java.io.IOException;

public class RegisterService {
    public void registerAdministrator(User user) throws IOException {
        SqlSession sqlSession = DBUtil.getSqlSession();
        AdministratorMapper mapper = sqlSession.getMapper(AdministratorMapper.class);
        mapper.insert(user);
        sqlSession.commit();
        sqlSession.close();
    }
    public void registerReferee(User user) throws IOException {
        SqlSession sqlSession = DBUtil.getSqlSession();
        RefereeMapper mapper = sqlSession.getMapper(RefereeMapper.class);
        mapper.insert(user);
        sqlSession.commit();
        sqlSession.close();
    }
    public void registerPlayer(User user) throws IOException {
        SqlSession sqlSession = DBUtil.getSqlSession();
        PlayerMapper mapper = sqlSession.getMapper(PlayerMapper.class);
        mapper.insert(user);
        sqlSession.commit();
        sqlSession.close();
    }
    public void registerVolunteer(User user) throws IOException {
        SqlSession sqlSession = DBUtil.getSqlSession();
        VolunteerMapper mapper = sqlSession.getMapper(VolunteerMapper.class);
        mapper.insert(user);
        sqlSession.commit();
        sqlSession.close();
    }
}
