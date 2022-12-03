package mapper;

import bean.Marking;
import org.apache.ibatis.annotations.Insert;

public interface MarkingMapper {
    @Insert("insert into marking values (#{id_referee},#{id_event},#{id_player},#{grade})")
    void insert(Marking marking);
}
