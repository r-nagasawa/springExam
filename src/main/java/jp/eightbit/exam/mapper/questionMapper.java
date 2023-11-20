package jp.eightbit.exam.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;

import jp.eightbit.exam.entity.Questions;


@Mapper
public interface questionMapper{

	List<Questions> findAll();
	
	Questions findOne(long id);

}