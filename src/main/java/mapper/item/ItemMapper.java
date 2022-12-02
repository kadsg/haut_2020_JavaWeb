package mapper.item;

import bean.item.Item;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface ItemMapper {
    @Insert("insert into item values (#{id},#{name},#{rule},#{place},#{time},#{is_over})")
    void insert(Item item);
    @Select("select * from item where id=#{0}")
    void search(String id);
}
