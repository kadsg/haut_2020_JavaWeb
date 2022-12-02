package mapper.user;

import bean.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface VolunteerMapper {
    @Insert("insert into volunteer values (#{account},#{password},#{name})")
    void insert(User user);

    @Select("select * from volunteer where account=#{0}")
    User select(String account);
}
