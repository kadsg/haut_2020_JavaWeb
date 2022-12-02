package service;

import bean.item.Item;
import mapper.item.ItemMapper;
import org.apache.ibatis.session.SqlSession;
import util.DBUtil;

import java.io.IOException;
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
}
