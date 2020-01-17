package lyc.java.LSpringBoot.dao_mapper;

import lyc.java.LSpringBoot.DTO_entity.Students;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentsMapper {
    @Select(value = "select * from students where id = #{id}")
    Students selectUser(@Param("id") int id);

    @Insert(value = "insert into students values (#{id}, #{name}, #{gender}, #{grade}, #{score})")
    void insertUser(@Param("id")int id, @Param("name")String name, @Param("gender")int gender, @Param("grade")int grade, @Param("score")double score);

    @Update("update students set name=#{name}, gender=#{gender}, grade=#{grade}, score=#{score} where id=#{id}")
    void updateUser(@Param("id")int id, @Param("name")String name, @Param("gender")int gender, @Param("grade")int grade, @Param("score")double score);

    @Delete("delete from students where id=#{id}")
    void deleteUser(@Param("id")int id);
}
