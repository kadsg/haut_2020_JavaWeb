package mapper;

import bean.EventPlayer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EventPlayerMapper {
    @Insert("insert into event_player values (#{id_player},#{id_item},#{grade},#{join})")
    void insert(EventPlayer eventPlayer);

    /**
     * 获得运动员的参赛信息
     */
    @Select("select * from event_player where id_player=#{id_player}")
    List<EventPlayer> queryAllByIdPlayer(String id_player);
}
