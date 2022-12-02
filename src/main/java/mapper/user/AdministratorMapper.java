package mapper.user;

import bean.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface AdministratorMapper {
    @Insert("insert into administrator values (#{account},#{password},#{name})")
    void insert(User user);

    @Select("select * from administrator where account=#{0}")
    User select(String account);
}
