package service.login;

import bean.user.User;
import mapper.user.AdministratorMapper;
import mapper.user.PlayerMapper;
import mapper.user.RefereeMapper;
import mapper.user.VolunteerMapper;
import org.apache.ibatis.session.SqlSession;
import util.DBUtil;

import java.io.IOException;

public class LoginService {
    public User getAdministrator(String account) throws IOException {
        SqlSession sqlSession = DBUtil.getSqlSession();
        AdministratorMapper mapper = sqlSession.getMapper(AdministratorMapper.class);
        User user = mapper.select(account);
        sqlSession.commit();
        sqlSession.close();
        return user;
    }
    public User getReferee(String account) throws IOException {
        SqlSession sqlSession = DBUtil.getSqlSession();
        RefereeMapper mapper = sqlSession.getMapper(RefereeMapper.class);
        User user = mapper.select(account);
        sqlSession.commit();
        sqlSession.close();
        return user;
    }
    public User getPlayer(String account) throws IOException {
        SqlSession sqlSession = DBUtil.getSqlSession();
        PlayerMapper mapper = sqlSession.getMapper(PlayerMapper.class);
        User user = mapper.select(account);
        sqlSession.commit();
        sqlSession.close();
        return user;
    }
    public User getVolunteer(String account) throws IOException {
        SqlSession sqlSession = DBUtil.getSqlSession();
        VolunteerMapper mapper = sqlSession.getMapper(VolunteerMapper.class);
        User user = mapper.select(account);
        sqlSession.commit();
        sqlSession.close();
        return user;
    }
}
