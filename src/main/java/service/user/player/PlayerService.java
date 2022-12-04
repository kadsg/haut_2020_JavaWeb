package service.user.player;

import bean.EventPlayer;
import bean.user.User;
import service.EventPlayerService;

import java.io.IOException;
import java.util.List;

public class PlayerService {
    /**
     * 获取运动员的赛事表
     * @param user 运动员
     * @return List<EventPlayer>
     */
    public List<EventPlayer> querySignUpList(User user) throws IOException {
        return new EventPlayerService().queryAllEventOfPlayer(user);
    }
}
