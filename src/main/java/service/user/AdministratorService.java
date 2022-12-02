package service.user;

import bean.item.Item;
import mapper.item.ItemMapper;
import org.apache.ibatis.session.SqlSession;
import util.DBUtil;
import util.RandomUtil;

import java.io.IOException;

public class AdministratorService {
    public void addItem(Item item) throws IOException {
        SqlSession sqlSession = DBUtil.getSqlSession();
        ItemMapper mapper = sqlSession.getMapper(ItemMapper.class);

        item.setId(RandomUtil.getRandom());
        item.setIs_over(false);

        mapper.insert(item);
        sqlSession.commit();
        sqlSession.close();
    }
}
