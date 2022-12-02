package mapper;

import bean.EventPlayer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface EventPlayerMapper {
    @Insert("insert into event_player values (#{id_sport},#{id_item},#{grade},#{join})")
    void insert(EventPlayer eventPlayer);

    /**
     * 获得运动员的参赛信息
     */
    @Select("select * from event_player where id_sport=#{id_sport}")
    EventPlayer queryAllByIdSport(String id_sport);
}
