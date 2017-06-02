package org.sevenzero.springbootfirst.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.sevenzero.springbootfirst.entity.Person;

@Mapper
public interface PersonMapper {
	
	@Select("select * from t_person where id = #{id}")  
    Person findById(long id); 
	
	@Select("select * from t_person")
	List<Person> findAll();

}
