package service;

import bean.EventPlayer;
import bean.item.Item;
import mapper.item.ItemMapper;
import org.apache.ibatis.session.SqlSession;
import util.DBUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ItemService {
    private SqlSession sqlSession;

    public List<Item> queryAllItem() throws IOException {
        sqlSession = DBUtil.getSqlSession();
        ItemMapper mapper = sqlSession.getMapper(ItemMapper.class);
        List<Item> itemList = mapper.queryAllItem();
        sqlSession.commit();
        sqlSession.close();
        return itemList;
    }

    /**
     * 获取正在进行的项目
     * @return
     */
    public List<Item> queryAllItemOnGoing() throws IOException {
        List<Item> itemList = null;
        List<Item> tempList = queryAllItem();

        if (tempList != null) {
            for (Item item : tempList) {
                if (!item.isIs_over()) {
                    if (itemList == null) {
                        itemList = new ArrayList<>();
                    }
                    itemList.add(item);
                }
            }
        }
        return itemList;
    }

    public Item queryItemById(String id_item) throws IOException {
        sqlSession = DBUtil.getSqlSession();
        ItemMapper mapper = sqlSession.getMapper(ItemMapper.class);
        Item item = mapper.search(id_item);
        sqlSession.commit();
        sqlSession.close();
        return item;
    }

    /**
     * 根据运动员参赛表返回对应的所有赛事
     * @param eventPlayerList
     * @return
     */
    public List<Item> queryAllItemOfEventPlayer(List<EventPlayer> eventPlayerList) throws IOException {
        sqlSession = DBUtil.getSqlSession();
        ItemMapper mapper = sqlSession.getMapper(ItemMapper.class);
        List<Item> itemList = null;

        if(eventPlayerList!=null) {
            itemList = new ArrayList<>();
            for (EventPlayer eventPlayer : eventPlayerList) {
                Item item = mapper.search(eventPlayer.getId_item());
                itemList.add(item);
            }
        }
        return itemList;
    }
}
