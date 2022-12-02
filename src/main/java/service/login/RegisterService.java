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
    private final SqlSession sqlSession = DBUtil.getSqlSession();

    public RegisterService() throws IOException {
    }

    public void registerAdministrator(User user) {
        AdministratorMapper mapper = sqlSession.getMapper(AdministratorMapper.class);
        mapper.insert(user);
        sqlSession.commit();
        sqlSession.close();
    }
    public void registerReferee(User user) {
        RefereeMapper mapper = sqlSession.getMapper(RefereeMapper.class);
        mapper.insert(user);
        sqlSession.commit();
        sqlSession.close();
    }
    public void registerPlayer(User user) {
        PlayerMapper mapper = sqlSession.getMapper(PlayerMapper.class);
        mapper.insert(user);
        sqlSession.commit();
        sqlSession.close();
    }
    public void registerVolunteer(User user) {
        VolunteerMapper mapper = sqlSession.getMapper(VolunteerMapper.class);
        mapper.insert(user);
        sqlSession.commit();
        sqlSession.close();
    }
}
