package com.smartFarm.mes.dao.process;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.smartFarm.mes.vo.process.PipVO;

@Repository("pipDAO")
public class PipDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String BOARD_INSERT ="insert into board(pip_no, pip_name, pip_category, pip_period) " 
					+ " values((select nvl(max(seq), 0)+1 from board t1),?,?)";
	private final String BOARD_UPDATE ="update board set pip_name=?, pip_category=? where pip_no=?";
	private final String BOARD_DELETE ="delete form board where pip_no=?";
//	private final String BOARD_GET ="select * from board where pip_no=?";			<< 임시
//	private final String BOARD_LIST ="select * from board order by seq desc";		<< 임시
	
	// 등록
	public void insertBoard(PipVO vo) {
		System.out.println("==> JDBC로 insertBoard() 메서드 호출!!");
		jdbcTemplate.update(BOARD_INSERT, vo.getPip_no(), vo.getPip_name(), vo.getPip_category(), vo.getPip_period());
	}
	
	// 수정
	public void updateBoard(PipVO vo) {
		System.out.println("==> JDBC로 updateBoard() 메서드 호출!!");
		jdbcTemplate.update(BOARD_UPDATE, vo.getPip_no(), vo.getPip_name(), vo.getPip_category(), vo.getPip_period());
	}
	
	// 삭제
	public void deleteBoard(PipVO vo) {
		System.out.println("==> JDBC로 deleteBoard() 메서드 호출!!");
		jdbcTemplate.update(BOARD_DELETE, vo.getPip_no(), vo.getPip_name());
	}
	
	//  상세조회
/*	public pipVO getPip(pipVO vo) {  << 임시
		System.out.println("==> JDBC로 getBoard() 메서드 호출!!");
		Object[] args = { vo.getPip_name() };				
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	} 
*/
	
	// 5. 글목록
/*	public List<pipVO> getPipList(pipVO vo) {  << 임시
		System.out.println("==> JDBC로 getBoardList() 메서드 호출!!");				
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}
*/	
}