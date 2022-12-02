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
    private final SqlSession sqlSession = DBUtil.getSqlSession();

    public LoginService() throws IOException {
    }

    public User getAdministrator(String account) {
        AdministratorMapper mapper = sqlSession.getMapper(AdministratorMapper.class);
        User user = mapper.select(account);
        sqlSession.commit();
        sqlSession.close();
        return user;
    }
    public User getReferee(String account) {
        RefereeMapper mapper = sqlSession.getMapper(RefereeMapper.class);
        User user = mapper.select(account);
        sqlSession.commit();
        sqlSession.close();
        return user;
    }
    public User getPlayer(String account) {
        PlayerMapper mapper = sqlSession.getMapper(PlayerMapper.class);
        User user = mapper.select(account);
        sqlSession.commit();
        sqlSession.close();
        return user;
    }
    public User getVolunteer(String account) {
        VolunteerMapper mapper = sqlSession.getMapper(VolunteerMapper.class);
        User user = mapper.select(account);
        sqlSession.commit();
        sqlSession.close();
        return user;
    }
}
