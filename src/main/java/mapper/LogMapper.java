package mapper;

import bean.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LogMapper {
    @Insert("insert into log values (#{id_volunteer},#{id_item},#{id_player},#{message},#{time})")
    void insert(Log log);

    @Select("select * from log where id_volunteer=#{0}")
    List<Log> queryAllLogByIdVolunteer(String id_volunteer);
}
