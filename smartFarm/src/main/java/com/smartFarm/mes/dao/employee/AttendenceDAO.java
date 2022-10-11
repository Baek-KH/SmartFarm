package com.smartFarm.mes.dao.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.smartFarm.mes.commons.JDBCUtil;
import com.smartFarm.mes.vo.employee.AttendenceVO;
import com.smartFarm.mes.vo.employee.EmployeeVO;


@Repository("AttendenceDAO")
public class AttendenceDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	private final String ATTENDENCE_INSERT ="insert into attendence(emp_id, emp_name, att_work_on, att_work_date, att_dayoff ) values (?,?,?,?,?)";
	private final String ATTENDENCE_GET ="select * from attendence where emp_id like ? and att_work_date = CURDATE() order by att_work_date desc limit 1";
	private final String ATTENDENCE_UPDATE_OFF ="update attendence set att_work_off=? where emp_id = ?";

	private final String ATTENDENCE_LIST ="select * from attendence where emp_id like ? order by att_work_date desc";
	private final String ATTENDENCE_LIST_DY ="select * from attendence where emp_id like ? year(att_work_date) like ? order by att_work_date desc";
	private final String ATTENDENCE_LIST_DM ="select * from attendence where emp_id like ? month(att_work_date) like ? order by att_work_date desc";
	private final String ATTENDENCE_LIST_DD ="select * from attendence where emp_id like ? day(att_work_date) like ? order by att_work_date desc";



	// admin
	private final String ATTENDENCE_LIST_ADMIN ="select * from attendence order by att_work_date desc";
	private final String ATTENDENCE_UPDATE_ADMIN ="update attendence set att_work_on =?, att_work_off=?, att_dayoff = ? where emp_id = ?";
	private final String ATTENDENCE_LIST_DY_ADMIN ="select * from attendence where year(att_work_date) like ? "
	        + "order by att_work_date desc";
	private final String ATTENDENCE_LIST_DM_ADMIN ="select * from attendence where month(att_work_date) like ? "
	        + "order by att_work_date desc";
	private final String ATTENDENCE_LIST_DD_ADMIN ="select * from attendence where day(att_work_date) like ? "
	        + "order by att_work_date desc";


	// 1. insert
	public void insertAttendence(AttendenceVO vo) {

		System.out.println("==> JDBC Attendence insert");

		// sql timestamp 로 형변환
		// java.util.date 값이 필요.
		
		java.sql.Timestamp awo = new java.sql.Timestamp(vo.getAtt_work_on().getTime()); 			
//		java.sql.Timestamp awof = new java.sql.Timestamp(vo.getAtt_work_off().getTime());
		java.sql.Timestamp awd = new java.sql.Timestamp(vo.getAtt_work_date().getTime());

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(ATTENDENCE_INSERT);
			stmt.setString(1, vo.getEmp_id());
			stmt.setString(2, vo.getEmp_name());
			stmt.setTimestamp(3, awo);
//			stmt.setTimestamp(4, awof);
			stmt.setTimestamp(4, awd);
			stmt.setString(5, vo.getAtt_dayoff());

			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, stmt, conn);
		}
	}

	// 2. getAttendence - 오늘
	public AttendenceVO getAttendence(String emp_id) {

		System.out.println("==> JDBC getAttendence");

		AttendenceVO attendenceVO = new AttendenceVO();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(ATTENDENCE_GET);
			stmt.setString(1, emp_id);
			rs = stmt.executeQuery();
			while(rs.next()) {
				attendenceVO.setEmp_id(rs.getString("emp_id"));
				attendenceVO.setEmp_name(rs.getString("emp_name"));
				attendenceVO.setAtt_work_on(rs.getTimestamp("att_work_on"));
				attendenceVO.setAtt_work_off(rs.getTimestamp("att_work_off"));
				attendenceVO.setAtt_work_date(rs.getTimestamp("att_work_date"));
				attendenceVO.setAtt_dayoff(rs.getString("att_dayoff"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return attendenceVO;

	}

	// update
	// off 업데이트 - 퇴근.
        public void updateAttendenceOff(AttendenceVO vo) {

            System.out.println("==> JDBC Attendence Regular update");
            // util.date type to sql.Timestamp
            java.sql.Timestamp awof = new java.sql.Timestamp(vo.getAtt_work_off().getTime());

            try {
                conn = JDBCUtil.getConnection();
                stmt = conn.prepareStatement(ATTENDENCE_UPDATE_OFF);
                stmt.setTimestamp(1, awof);
                stmt.setString(2, vo.getEmp_id());
                stmt.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                JDBCUtil.close(null, stmt, conn);
            }
        }




	// Attendence List - regular
		public List<AttendenceVO> getAttendenceList(EmployeeVO vo) {

			System.out.println("==> JDBC getAttendenceList");


			List<AttendenceVO> attendenceList = new ArrayList<>();

			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(ATTENDENCE_LIST);
				stmt.setString(1, vo.getEmp_id());
				rs = stmt.executeQuery();
				while(rs.next()) {
					AttendenceVO attendenceVO = new AttendenceVO();
					attendenceVO.setEmp_id(rs.getString("emp_id"));
	                attendenceVO.setEmp_name(rs.getString("emp_name"));
	                attendenceVO.setAtt_work_on(rs.getTimestamp("att_work_on"));
	                attendenceVO.setAtt_work_off(rs.getTimestamp("att_work_off"));
	                attendenceVO.setAtt_work_date(rs.getTimestamp("att_work_date"));
	                attendenceVO.setAtt_dayoff(rs.getString("att_dayoff"));
					attendenceList.add(attendenceVO);

				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(rs, stmt, conn);
			}
			return attendenceList;
		}




		// Attendence List Search - regular
		public List<AttendenceVO> getAttendenceListSearch(EmployeeVO vo,  String field, String query) {
			// regular 이용자는 self 검색만 가능
		    // field {year, month, day }


			System.out.println("==> JDBC getAttendenceListSearch");

			List<AttendenceVO> attendenceList = new ArrayList<>();

			try {
				conn = JDBCUtil.getConnection();
				if(field.equals("year")) {
					stmt = conn.prepareStatement(ATTENDENCE_LIST_DY);
				} else if(field.equals("month")) {
					stmt = conn.prepareStatement(ATTENDENCE_LIST_DM);
				} else if(field.equals("day")) {
					stmt = conn.prepareStatement(ATTENDENCE_LIST_DD);
				}


				stmt.setString(1, vo.getEmp_id());
				stmt.setInt(2, Integer.parseInt(query));


				rs = stmt.executeQuery();
				while(rs.next()) {
				    AttendenceVO attendenceVO = new AttendenceVO();
                    attendenceVO.setEmp_id(rs.getString("emp_id"));
                    attendenceVO.setEmp_name(rs.getString("emp_name"));
                    attendenceVO.setAtt_work_on(rs.getTimestamp("att_work_on"));
                    attendenceVO.setAtt_work_off(rs.getTimestamp("att_work_off"));
                    attendenceVO.setAtt_work_date(rs.getTimestamp("att_work_date"));
                    attendenceVO.setAtt_dayoff(rs.getString("att_dayoff"));
                    attendenceList.add(attendenceVO);

				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(rs, stmt, conn);
			}
			return attendenceList;
		}


		// ADMIN 기능
		// update - ADMIN

	        public void updateAttendenceAdmin(AttendenceVO vo) {

	            System.out.println("==> JDBC Attendence Admin update");
	            // util.date type to sql.Timestamp
	            java.sql.Timestamp awo = new java.sql.Timestamp(vo.getAtt_work_on().getTime());
	            java.sql.Timestamp awof = new java.sql.Timestamp(vo.getAtt_work_off().getTime());
	            java.sql.Timestamp awd = new java.sql.Timestamp(vo.getAtt_work_date().getTime());

	            try {
	                conn = JDBCUtil.getConnection();
	                stmt = conn.prepareStatement(ATTENDENCE_UPDATE_ADMIN);
	                stmt.setTimestamp(1, awo);
	                stmt.setTimestamp(2, awof);
	                stmt.setString(3, vo.getAtt_dayoff());
	                stmt.setString(2, vo.getEmp_id());
	                stmt.executeUpdate();
	            } catch (Exception e) {
	                e.printStackTrace();
	            } finally {
	                JDBCUtil.close(null, stmt, conn);
	            }
	        }

	     // Attendence List - admin
			public List<AttendenceVO> getAttendenceListAdmin() {

				System.out.println("==> JDBC getAttendenceListAdmin");


				List<AttendenceVO> attendenceList = new ArrayList<>();

				try {
					conn = JDBCUtil.getConnection();
					stmt = conn.prepareStatement(ATTENDENCE_LIST_ADMIN);
					rs = stmt.executeQuery();
					while(rs.next()) {
						AttendenceVO attendenceVO = new AttendenceVO();
						attendenceVO.setEmp_id(rs.getString("emp_id"));
		                attendenceVO.setEmp_name(rs.getString("emp_name"));
		                attendenceVO.setAtt_work_on(rs.getTimestamp("att_work_on"));
		                attendenceVO.setAtt_work_off(rs.getTimestamp("att_work_off"));
		                attendenceVO.setAtt_work_date(rs.getTimestamp("att_work_date"));
		                attendenceVO.setAtt_dayoff(rs.getString("att_dayoff"));
						attendenceList.add(attendenceVO);

					}

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					JDBCUtil.close(rs, stmt, conn);
				}
				return attendenceList;
			}




	     // Attendence List Search - Admin
	        public List<AttendenceVO> getAttendenceListSearchAdmin(String field, String query) {

	            // 날짜별 근태 조회
	            System.out.println("==> JDBC getAttendenceListAdmin");


	            List<AttendenceVO> attendenceList = new ArrayList<>();

	            try {
	                conn = JDBCUtil.getConnection();
	                if(field.equals("year")) {
	                    stmt = conn.prepareStatement(ATTENDENCE_LIST_DY_ADMIN);
	                } else if(field.equals("month")) {
	                    stmt = conn.prepareStatement(ATTENDENCE_LIST_DM_ADMIN);
	                } else if(field.equals("day")) {
	                    stmt = conn.prepareStatement(ATTENDENCE_LIST_DD_ADMIN);
	                }



	                stmt.setInt(1, Integer.parseInt(query));


	                rs = stmt.executeQuery();
	                while(rs.next()) {
	                    AttendenceVO attendenceVO = new AttendenceVO();
	                    attendenceVO.setEmp_id(rs.getString("emp_id"));
	                    attendenceVO.setEmp_name(rs.getString("emp_name"));
	                    attendenceVO.setAtt_work_on(rs.getTimestamp("att_work_on"));
	                    attendenceVO.setAtt_work_off(rs.getTimestamp("att_work_off"));
	                    attendenceVO.setAtt_work_date(rs.getTimestamp("att_work_date"));
	                    attendenceVO.setAtt_dayoff(rs.getString("att_dayoff"));
	                    attendenceList.add(attendenceVO);

	                }

	            } catch (Exception e) {
	                e.printStackTrace();
	            } finally {
	                JDBCUtil.close(rs, stmt, conn);
	            }
	            return attendenceList;
	        }




}
