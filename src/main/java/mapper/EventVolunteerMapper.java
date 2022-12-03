package mapper;

import bean.EventVolunteer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EventVolunteerMapper {
    @Insert("insert into event_volunteer values (#{id_item},#{id_volunteer})")
    void insert(EventVolunteer eventVolunteer);

    @Select("select * from event_volunteer values where id_volunteer=#{id_volunteer} and id_item=#{id_item}")
    EventVolunteer search(@Param("id_volunteer") String id_volunteer, @Param("id_item") String id_item);

    @Select("select * from event_volunteer where `id_volunteer`=#{0}")
    List<EventVolunteer> queryAllByIdVolunteer(String id_volunteer);
}
