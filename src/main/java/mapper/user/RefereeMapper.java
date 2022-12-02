package mapper.user;

import bean.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface RefereeMapper {
    @Insert("insert into referee values (#{account},#{password},#{name})")
    void insert(User user);

    @Select("select * from referee where account=#{0}")
    User select(String account);
}
