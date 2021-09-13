package com.demoweb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.demoweb.vo.BoardVO;

// BoardMapper.xml 파일과 매핑되는 인터페이스 정의
// -> BoardMapper.xml과 경로와 이름이 일치하도록 작성
@Mapper // <bean id="boardMapper" class="...MapperFactoryBean"> ... </bean>
public interface BoardMapper {
	
	// 인터페이스메서드는 BoardMapper.xml 파일의 insert, update, select, ... 의 아이디과 일치하도록 작성
	void insertBoard(BoardVO board);
	
	List<BoardVO> selectAll();

}
