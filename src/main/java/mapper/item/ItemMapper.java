package mapper.item;

import bean.item.Item;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ItemMapper {
    @Insert("insert into item values (#{id},#{name},#{rule},#{place},#{time},#{is_over})")
    void insert(Item item);
    @Select("select * from item where id=#{0}")
    Item search(String id);
    @Select("select * from item")
    List<Item> queryAllItem();

    @Update("update item set is_over=#{is_over} where id=#{id}")
    void update(Item item);
}
