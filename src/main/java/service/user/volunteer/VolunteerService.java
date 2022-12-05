package service.user.volunteer;

import bean.EventVolunteer;
import bean.Log;
import bean.item.Item;
import bean.user.User;
import mapper.LogMapper;
import org.apache.ibatis.session.SqlSession;
import service.EventVolunteerService;
import service.ItemService;
import util.DBUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VolunteerService {
    private SqlSession sqlSession;

    /**
     * 获取志愿者的赛事表
     * @param user
     * @return
     */
    public List<EventVolunteer> querySignUpList(User user) throws IOException {
        return new EventVolunteerService().getAllEventVolunteer(user);
    }

    /**
     * 获取志愿者参加的还在进行的赛事
     * @param user
     * @return
     * @throws IOException
     */
    public List<Item> querySignUpListOnGoing(User user) throws IOException {
        List<EventVolunteer> tempList = querySignUpList(user);
        List<Item> signUpList = null;
        Item item;

        if (tempList != null) {
               for (EventVolunteer eventVolunteer : tempList) {
                   item = new ItemService().queryItemById(eventVolunteer.getId_item());
                   if (!item.isIs_over()) {
                       if (signUpList == null)
                           signUpList = new ArrayList<>();
                        signUpList.add(item);
                   }
               }
        }
        return signUpList;
    }

    /**
     * 填写服务日志
     * @param log
     */
    public void insertLog(Log log) throws IOException {
        sqlSession = DBUtil.getSqlSession();
        LogMapper mapper = sqlSession.getMapper(LogMapper.class);
        mapper.insert(log);
        sqlSession.commit();
        sqlSession.close();
    }

    public List<Log> queryAllLogByIdVolunteer(String id_volunteer) throws IOException {
        sqlSession = DBUtil.getSqlSession();
        LogMapper mapper = sqlSession.getMapper(LogMapper.class);
        List<Log> logList = mapper.queryAllLogByIdVolunteer(id_volunteer);
        sqlSession.commit();
        sqlSession.close();
        return logList;
    }
}
