package mapper;

import bean.EventPlayer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface EventPlayerMapper {
    @Insert("insert into event_player values (#{id_player},#{id_item},#{grade},#{join})")
    void insert(EventPlayer eventPlayer);

    /**
     * 获得运动员的参赛信息
     */
    @Select("select * from event_player where id_player=#{id_player}")
    List<EventPlayer> queryAllByIdPlayer(String id_player);

    @Select("select * from event_player where id_player=#{id_player} and id_item=#{id_item}")
    EventPlayer queryByIdPlayerAndIdItem(
            @Param("id_player")
            String id_player,
            @Param("id_item")
            String id_item);

    @Update("update event_player set grade=#{grade}, `join`=#{join} where id_player=#{id_player} and id_item=#{id_item}")
    void update(EventPlayer eventPlayer);
}
