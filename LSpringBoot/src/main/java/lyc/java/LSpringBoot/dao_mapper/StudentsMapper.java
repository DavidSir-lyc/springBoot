package lyc.java.LSpringBoot.dao_mapper;

import lyc.java.LSpringBoot.entity_DTO.Students;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentsMapper {
    @Select(value = "select * from students where id = #{id}")
    Students getNameById(@Param("id") int id);

}
