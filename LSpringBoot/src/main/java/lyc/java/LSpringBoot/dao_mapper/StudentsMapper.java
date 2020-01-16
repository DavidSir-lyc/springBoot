package lyc.java.LSpringBoot.dao_mapper;

import lyc.java.LSpringBoot.DTO_entity.Students;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentsMapper {
    @Select(value = "select * from students where id = #{id}")
    Students getUserById(@Param("id") int id);

    @Insert(value = "insert into students values (#{id}, #{name}, #{gender}, #{grade}, #{score})")
    void addUser(@Param("id")int id, @Param("name")String name, @Param("gender")int gender, @Param("grade")int grade, @Param("score")int score);
}
