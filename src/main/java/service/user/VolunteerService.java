package service.user;

import bean.EventVolunteer;
import bean.user.User;
import service.EventVolunteerService;

import java.io.IOException;
import java.util.List;

public class VolunteerService {
    /**
     * 获取志愿者的赛事表
     * @param user
     * @return
     */
    public List<EventVolunteer> querySignUpList(User user) throws IOException {
        return new EventVolunteerService().getAllEventVolunteer(user);
    }
}
