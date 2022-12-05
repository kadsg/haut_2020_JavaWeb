package service;

import bean.Marking;
import bean.Score;
import bean.item.Item;
import bean.user.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventService {
    /**
     * 结束赛事
     * @param id_item 赛事编号
     */
    public void announceItem(String id_item) throws IOException {
        // 结束赛事
        ItemService itemService = new ItemService();
        Item item = itemService.queryItemById(id_item);
        item.setIs_over(true);
        new ItemService().update(item);

        // 获取参赛选手
        List<Player> playerList = new EventPlayerService().queryAllPlayerOfItem(item);
        // 获取选手的打分表并统计
        if (playerList != null) {
            List<Score> scoreList = new ArrayList<>();
            for (Player player : playerList) {
                List<Marking> markingList = new MarkingService().queryByIdItemAndIdPlayer(id_item, player.getAccount());
                // 统计
                int count = 0;
                double sum = 0 , grade;
                for (Marking marking : markingList) {
                    double temp = marking.getGrade();
                    if (temp != 0) {
                        sum += temp;
                        ++count;
                    }
                }
                // 得分
                grade = sum / count;
                Score score = new Score(id_item, player.getAccount(), grade);
                scoreList.add(score);
            }
            // 对scoreList进行排序得出排名
            Collections.sort(scoreList);
            for (int i = 0; i < scoreList.size(); ++i)
                scoreList.get(i).setRank(i + 1);
            // 写入到数据库
            new ScoreService().insert(scoreList);
        }
    }
}
