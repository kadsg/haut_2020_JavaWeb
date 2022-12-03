package mapper;

import bean.Marking;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface MarkingMapper {
    @Insert("insert into marking values (#{id_referee},#{id_event},#{id_player},#{grade})")
    void insert(Marking marking);

    @Select("select * form marking where id_item=#{id_item} and id_player=#{id_player}}")
    Marking search(@Param("id_item") String id_item, @Param("id_player") String id_player);
}
