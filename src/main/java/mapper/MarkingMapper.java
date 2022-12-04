package mapper;

import bean.Marking;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MarkingMapper {
    @Insert("insert into marking values (#{id_referee},#{id_item},#{id_player},#{grade})")
    void insert(Marking marking);

    @Select("select * from marking where id_item=#{id_item} and id_player=#{id_player} and id_referee=#{id_referee}")
    Marking search(@Param("id_item") String id_item, @Param("id_player") String id_player, @Param("id_referee") String id_referee);

    @Select("select * from marking where id_item=#{id_item} and id_player=#{id_player}")
    List<Marking> queryByIdItemAndIDPlayer(@Param("id_item") String id_item, @Param("id_player") String id_player);

    @Select("select * from marking where id_item=#{id_item}")
    List<Marking> queryAllByIdItem(String id_item);

    @Update("update marking set grade=#{grade} where id_referee=#{id_referee} and id_item=#{id_item} and id_player=#{id_player}")
    void update(Marking marking);
}
