package service.user.referee;

import bean.EventReferee;
import bean.item.Item;
import bean.user.User;
import service.EventRefereeService;
import service.ItemService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RefereeService {
    /**
     * 获取裁判的赛事表
     * @param user 裁判
     * @return List<EventPlayer>
     */
    public List<EventReferee> querySignUpList(User user) throws IOException {
        return new EventRefereeService().getAllEventOfReferee(user);
    }

    /**
     * 获取裁判的项目表
     * @param user
     * @return
     */
    public List<Item> querySignUpItemList(User user) throws IOException {
        List<EventReferee> eventRefereeList = querySignUpList(user);
        ItemService itemService = new ItemService();
        List<Item> itemList = null;
        Item item;
        if (eventRefereeList != null) {
            for (EventReferee eventReferee : eventRefereeList) {
                if (itemList == null)
                    itemList = new ArrayList<>();
                item = itemService.queryItemById(eventReferee.getId_item());
                itemList.add(item);
            }
        }
        return itemList;
    }
}
