package lyc.java.LSpringBoot.dao;

import lyc.java.LSpringBoot.dto.User;
import lyc.java.LSpringBoot.vo.ReqUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    /*@Select(value = "select * from user where id = #{id}")
    User selectUser(@Param("id")Integer id);

    @Insert(value = "insert into user values (#{id}, #{name}, #{gender}, #{grade}, #{score})")
    void insertUser(@Param("id")Integer id, @Param("name")String name, @Param("age")Integer age, @Param("score")double score);

    @Update("update user set name=#{name}, gender=#{gender}, grade=#{grade}, score=#{score} where id=#{id}")
    void updateUser(@Param("id")Integer id, @Param("name")String name, @Param("age")Integer age, @Param("score")double score);

    @Delete("delete from user where id=#{id}")
    void deleteUser(@Param("id")Integer id);*/

    List<User> selectAll(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);

    User selectUser(@Param("id") String id);

    void insertUser(@Param(value = "name") String name, @Param(value = "age") Integer age, @Param(value = "score") Double score);
    void postInsertUser(ReqUser reqUser);

    void deleteUser(@Param("id") String id);
    void postDeleteUser(ReqUser reqUser);
}
