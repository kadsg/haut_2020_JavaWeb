package mapper;

import bean.Score;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ScoreMapper {
    @Insert("insert into score (`id_item`,`id_player`,`score`,`rank`) values (#{id_item},#{id_player},#{score},#{rank})")
    void insert(Score score);

    @Select("select * from score where id_item=#{id_item} and id_player=#{id_player}")
    Score search(@Param("id_item") String id_item, @Param("id_player") String id_player);

    @Select("select * from score where id_item=#{0}")
    List<Score> queryAllByIdItem(String id_item);
}
