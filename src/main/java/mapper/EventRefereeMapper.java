package mapper;

import bean.EventReferee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EventRefereeMapper {
    @Insert("insert into event_referee values (#{id_referee},#{id_item})")
    void insert(EventReferee eventReferee);

    @Select("select * from event_referee where id_referee=#{id_referee} and id_item=#{id_item}")
    EventReferee search(@Param("id_referee") String id_referee, @Param("id_item") String id_item);

    @Select("select * from event_referee where id_referee=#{0}")
    List<EventReferee> queryAllByIdReferee(String id_referee);

    @Select("select * from event_referee where id_item=#{0}")
    List<EventReferee> queryAllByIdItem(String id_item);
}
