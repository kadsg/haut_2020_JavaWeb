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
