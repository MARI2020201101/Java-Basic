package com.mariworld.sample.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleMapper {
	
	String getTime();

}
