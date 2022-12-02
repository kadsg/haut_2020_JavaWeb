package mapper.user;

import bean.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface PlayerMapper {
    @Insert("insert into player values (#{account},#{password},#{name})")
    void insert(User user);

    @Select("select * from player where account=#{0}")
    User select(String account);
}
