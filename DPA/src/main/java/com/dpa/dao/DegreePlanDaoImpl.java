package com.dpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dpa.jdbc.CourseRowMapper;
import com.dpa.jdbc.CoursesRowMapper;
import com.dpa.jdbc.DPRowMapper;
import com.dpa.jdbc.DegreePlanRowMapper;
import com.dpa.jdbc.InterestAreaRowMapper;
import com.dpa.jdbc.LoginRowMapper;
import com.dpa.jdbc.MyAdvisorRowMapper;
import com.dpa.jdbc.OptionalCourseRowMapper;
import com.dpa.model.CoreUpdate;
import com.dpa.model.Course;
import com.dpa.model.Courses;
import com.dpa.model.DegreePlan;
import com.dpa.model.GRE;
import com.dpa.model.InterestArea;
import com.dpa.model.Login;
import com.dpa.model.Request;

@Service
public class DegreePlanDaoImpl implements DegreePlanDao {
	@Autowired
	DataSource dataSource;

	// Get the course list from the database
	@Override
	public List<Course> getCoreCourses() {
		List<Course> courseList = new ArrayList<Course>();
		String sql = "select * from mandatorycourses";
		JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
		courseList = jdbctem.query(sql, new CourseRowMapper());
		return courseList;
	}

	// return all CSCE Department courses
	@Override
	public List<String> getOptionalCourses() {
		List<String> optionalCourses = new ArrayList<String>();
		String sql = "select * from courses";
		JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
		optionalCourses = jdbctem.query(sql, new OptionalCourseRowMapper());
		return optionalCourses;
	}

	// inserts the degree plan into database
	@Override
	public int submitDegreePlan(DegreePlan degreePlan, String userName) {
		String sql1 = "INSERT INTO gre "
				+ "(userName, verbal, quantitative, analytical, dateTaken) VALUES (?, ?, ?, ?, ?)";
		JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
		jdbcTemp.update(sql1,
				new Object[] { degreePlan.getName(), degreePlan.getGre().getVerbal(),
						degreePlan.getGre().getQuantitative(), degreePlan.getGre().getAnalytical(),
						degreePlan.getGre().getDateTaken() });
		String sql = "INSERT INTO degreeplan "
				+ "(name, studentId, localAddress, email, degree, major, minor, interestArea, majorProfessor, coMajorProfessor, totalCreditHours, degreePlanStatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int result = jdbcTemplate.update(sql,
				new Object[] {degreePlan.getName(), degreePlan.getStudentId(), degreePlan.getLocalAddress(),
						degreePlan.getEmail(), degreePlan.getDegree(), degreePlan.getMajor(), degreePlan.getMinor(),
						degreePlan.getInterestArea(), degreePlan.getMajorProfessor(), degreePlan.getCoMajorProfessor(),
						degreePlan.getTotalCreditHours(), "submitted" });
		int coreReturn = insertCoreCourses(degreePlan, userName);
		int courseReturn = insertOptionalCourses(degreePlan, userName);
		String sql2 = "update majorprofessor set degreePlanStatus = ? where studentName = ?";
		JdbcTemplate jdbcTemp1 = new JdbcTemplate(dataSource);
		jdbcTemp1.update(sql2, new Object[] { "yes", userName });
		return result;
	}

	// inserts optional courses
	private int insertOptionalCourses(DegreePlan degreePlan, String userName) {
		String sql = "INSERT INTO courses_dp "
				+ "(userName, courseCatergory, courseName, semesterTaken, cHrs, grade) VALUES (?, ?, ?, ?, ?, ?)";
		JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
		String courseCategory = "optional";
		jdbcTemp.update(sql,
				new Object[] { degreePlan.getName(), courseCategory, degreePlan.getOpCourse1().getCourse(),
						degreePlan.getOpCourse1().getSemesterTaken(), degreePlan.getOpCourse1().getcHrs(),
						degreePlan.getOpCourse1().getGrade() });
		jdbcTemp.update(sql,
				new Object[] { degreePlan.getName(), courseCategory, degreePlan.getOpCourse2().getCourse(),
						degreePlan.getOpCourse2().getSemesterTaken(), degreePlan.getOpCourse2().getcHrs(),
						degreePlan.getOpCourse2().getGrade() });
		jdbcTemp.update(sql,
				new Object[] { degreePlan.getName(), courseCategory, degreePlan.getOpCourse3().getCourse(),
						degreePlan.getOpCourse3().getSemesterTaken(), degreePlan.getOpCourse3().getcHrs(),
						degreePlan.getOpCourse3().getGrade() });
		jdbcTemp.update(sql,
				new Object[] { degreePlan.getName(), courseCategory, degreePlan.getOpCourse4().getCourse(),
						degreePlan.getOpCourse4().getSemesterTaken(), degreePlan.getOpCourse4().getcHrs(),
						degreePlan.getOpCourse4().getGrade() });
		jdbcTemp.update(sql,
				new Object[] { degreePlan.getName(), courseCategory, degreePlan.getOpCourse5().getCourse(),
						degreePlan.getOpCourse5().getSemesterTaken(), degreePlan.getOpCourse5().getcHrs(),
						degreePlan.getOpCourse5().getGrade() });
		jdbcTemp.update(sql,
				new Object[] { degreePlan.getName(), courseCategory, degreePlan.getOpCourse6().getCourse(),
						degreePlan.getOpCourse6().getSemesterTaken(), degreePlan.getOpCourse6().getcHrs(),
						degreePlan.getOpCourse6().getGrade() });
		jdbcTemp.update(sql,
				new Object[] { degreePlan.getName(), courseCategory, degreePlan.getOpCourse7().getCourse(),
						degreePlan.getOpCourse7().getSemesterTaken(), degreePlan.getOpCourse7().getcHrs(),
						degreePlan.getOpCourse7().getGrade() });
		int result = jdbcTemp.update(sql,
				new Object[] { userName, courseCategory, degreePlan.getOpCourse8().getCourse(),
						degreePlan.getOpCourse8().getSemesterTaken(), degreePlan.getOpCourse8().getcHrs(),
						degreePlan.getOpCourse8().getGrade() });
		return result;
	}

	// inserts core courses
	private int insertCoreCourses(DegreePlan degreePlan, String userName) {
		// inserts core course A
		String sql = "INSERT INTO courses_dp "
				+ "(userName, courseCatergory, courseName, semesterTaken, cHrs, grade) VALUES (?, ?, ?, ?, ?, ?)";
		JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
		String courseCategory = "courseA";
		jdbcTemp.update(sql,
				new Object[] { degreePlan.getName(), courseCategory, degreePlan.getCourseA().getCourse(),
						degreePlan.getCourseA().getSemesterTaken(), degreePlan.getCourseA().getcHrs(),
						degreePlan.getCourseA().getGrade() });

		// inserts core course B
		courseCategory = "courseB";
		jdbcTemp.update(sql,
				new Object[] { degreePlan.getName(), courseCategory, degreePlan.getCourseB().getCourse(),
						degreePlan.getCourseB().getSemesterTaken(), degreePlan.getCourseB().getcHrs(),
						degreePlan.getCourseB().getGrade() });

		// inserts core course C
		courseCategory = "courseC";
		jdbcTemp.update(sql,
				new Object[] { degreePlan.getName(), courseCategory, degreePlan.getCourseC().getCourse(),
						degreePlan.getCourseC().getSemesterTaken(), degreePlan.getCourseC().getcHrs(),
						degreePlan.getCourseC().getGrade() });

		// inserts core course D
		courseCategory = "courseD";
		int result = jdbcTemp.update(sql,
				new Object[] { degreePlan.getName(), courseCategory, degreePlan.getCourseD().getCourse(),
						degreePlan.getCourseD().getSemesterTaken(), degreePlan.getCourseD().getcHrs(),
						degreePlan.getCourseD().getGrade() });

		return result;
	}

//get the degree plan information of a particular student from the database
	@Override
	public DegreePlan getDegreePlan(String sName, String userName) {
		String sql = "select name from register where userName = '" + userName + "'";
		JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
		String profName = jdbctem.queryForObject(sql, String.class);
		String sql1 = "select * from degreeplan where name= '" + sName + "' and majorProfessor = '" + profName + "'";
		DegreePlan degreePlan = (DegreePlan) jdbctem.queryForObject(sql1, new BeanPropertyRowMapper(DegreePlan.class));
		return degreePlan;
	}

	@Override
	public GRE getGREScores(String sName) {
		String sql = "select * from gre where userName= '" + sName + "'";
		JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
		GRE gre = (GRE) jdbctem.queryForObject(sql, new BeanPropertyRowMapper(GRE.class));
		return gre;
	}

	@Override
	public List<Courses> getCourses(String sName) {
		String sql = "select * from courses_dp where userName= '" + sName + "'";
		JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
		List<Courses> courses = new ArrayList<Courses>();
		courses = jdbctem.query(sql, new CoursesRowMapper());
		return courses;
	}

	@Override
	public int submitDPToAdminSpecialist(String userName, String sName, String sign) {
		// submit degree plan to administrative specialist
		String sql = "select name from register where userName = '" + userName + "'";
		JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
		String profName = jdbctem.queryForObject(sql, String.class);
		String degreePlanStatus = "With Administrative Specialist";
		String sql1 =  "update degreeplan set degreePlanStatus=?, professorSignature = ? where name = ? and majorProfessor=?";
		JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
		int result = jdbcTemp.update(sql1, new Object[] {degreePlanStatus, sign, sName, profName});
		return result;
	}

	@Override
	public int dPProfessorReject(String userName, String studentName, String comments) {
		String sql = "select name from register where userName = '" + userName + "'";
		String sql3 = "select role from register where userName = '" + userName + "'";
		JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
		JdbcTemplate jdbctem3 = new JdbcTemplate(dataSource);
		String profName = jdbctem.queryForObject(sql, String.class);
		String role = jdbctem3.queryForObject(sql3, String.class);
		String degreePlanStatus = "No";
		String sql2 =  "update majorProfessor set degreePlanStatus=? where studentName = ?";
		JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
		jdbcTemp.update(sql2, new Object[] {degreePlanStatus, studentName});
		if(role.equals("professor")) {
			degreePlanStatus = "Professor Rejected";
		}else if(role.equals("adminspecialist")) {
			degreePlanStatus = "AdminSpecialist Rejected";
		}else if(role.equals("associatechair")){
			degreePlanStatus = "AssociateChair Rejected";
		}else if(role.equals("chair")) {
			degreePlanStatus = "Chair Rejected";
		}
		String sql1 =  "update degreeplan set degreePlanStatus=?, rejectComments = ? where name = ?";
		int result = jdbcTemp.update(sql1, new Object[] {degreePlanStatus, comments, studentName});
		return result;
	}

	@Override
	public String getDPStatus(String userName, String majorProfessor) {
		String sql = "select degreePlanStatus from degreeplan where name = '" + userName + "'";
		JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
		String dpStatus = jdbctem.queryForObject(sql, String.class);
		return dpStatus;
	}

//This program will get the reject comments from the database 
	@Override
	public String getComments(String userName, String majorProfessor) {
		String sql = "select rejectComments from degreeplan where name = '" + userName + "'";
		JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
		String comments = jdbctem.queryForObject(sql, String.class);
		return comments;
	}

	@Override
	public DegreePlan getDegreePlanData(String userName) {
		JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
		String sql1 = "select * from degreeplan where name= '" + userName + "'";
		DegreePlan degreePlan = (DegreePlan) jdbctem.queryForObject(sql1, new BeanPropertyRowMapper(DegreePlan.class));
		return degreePlan;
	}

	@Override
	public int updateDegreePlan(DegreePlan degreePlan, String userName) {
		String sql1 = "update gre set userName=?, verbal=?, quantitative=?, analytical=?, dateTaken=? where userName = ?";
		JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
		jdbcTemp.update(sql1,
				new Object[] { degreePlan.getName(), degreePlan.getGre().getVerbal(),
						degreePlan.getGre().getQuantitative(), degreePlan.getGre().getAnalytical(),
						degreePlan.getGre().getDateTaken(), userName });
		String sql = "update degreeplan set name=?, studentId=?, localAddress=?, email=?, degree=?, major=?, minor=?, interestArea=?, majorProfessor=?, coMajorProfessor=?, totalCreditHours=?, degreePlanStatus=? where name = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int result = jdbcTemplate.update(sql,
				new Object[] {degreePlan.getName(), degreePlan.getStudentId(), degreePlan.getLocalAddress(),
						degreePlan.getEmail(), degreePlan.getDegree(), degreePlan.getMajor(), degreePlan.getMinor(),
						degreePlan.getInterestArea(), degreePlan.getMajorProfessor(), degreePlan.getCoMajorProfessor(),
						degreePlan.getTotalCreditHours(), "submitted", userName});
		updateCoreCourses(degreePlan, userName);
		updateOptionalCourses(degreePlan, userName);
		String sql2 = "update majorprofessor set degreePlanStatus = ? where studentName = ?";
		JdbcTemplate jdbcTemp1 = new JdbcTemplate(dataSource);
		jdbcTemp1.update(sql2, new Object[] { "yes", userName });
		return result;
	}
	// inserts optional courses
		private int updateOptionalCourses(DegreePlan degreePlan, String userName) {
			String sql = "update courses_dp set courseCatergory=?, courseName=?, semesterTaken=?, cHrs=?, grade=? where userName=?";
			JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
			String courseCategory = "optional";
			jdbcTemp.update(sql,
					new Object[] { courseCategory, degreePlan.getOpCourse1().getCourse(),
							degreePlan.getOpCourse1().getSemesterTaken(), degreePlan.getOpCourse1().getcHrs(),
							degreePlan.getOpCourse1().getGrade(),userName });
			jdbcTemp.update(sql,
					new Object[] { courseCategory, degreePlan.getOpCourse2().getCourse(),
							degreePlan.getOpCourse2().getSemesterTaken(), degreePlan.getOpCourse2().getcHrs(),
							degreePlan.getOpCourse2().getGrade(), userName });
			jdbcTemp.update(sql,
					new Object[] { courseCategory, degreePlan.getOpCourse3().getCourse(),
							degreePlan.getOpCourse3().getSemesterTaken(), degreePlan.getOpCourse3().getcHrs(),
							degreePlan.getOpCourse3().getGrade(), userName });
			jdbcTemp.update(sql,
					new Object[] { courseCategory, degreePlan.getOpCourse4().getCourse(),
							degreePlan.getOpCourse4().getSemesterTaken(), degreePlan.getOpCourse4().getcHrs(),
							degreePlan.getOpCourse4().getGrade(), userName });
			jdbcTemp.update(sql,
					new Object[] { courseCategory, degreePlan.getOpCourse5().getCourse(),
							degreePlan.getOpCourse5().getSemesterTaken(), degreePlan.getOpCourse5().getcHrs(),
							degreePlan.getOpCourse5().getGrade(), userName });
			jdbcTemp.update(sql,
					new Object[] { courseCategory, degreePlan.getOpCourse6().getCourse(),
							degreePlan.getOpCourse6().getSemesterTaken(), degreePlan.getOpCourse6().getcHrs(),
							degreePlan.getOpCourse6().getGrade(), userName });
			jdbcTemp.update(sql,
					new Object[] { courseCategory, degreePlan.getOpCourse7().getCourse(),
							degreePlan.getOpCourse7().getSemesterTaken(), degreePlan.getOpCourse7().getcHrs(),
							degreePlan.getOpCourse7().getGrade(), userName });
			int result = jdbcTemp.update(sql,
					new Object[] { courseCategory, degreePlan.getOpCourse8().getCourse(),
							degreePlan.getOpCourse8().getSemesterTaken(), degreePlan.getOpCourse8().getcHrs(),
							degreePlan.getOpCourse8().getGrade(), userName });
			return result;
		}

		// inserts core courses
		private int updateCoreCourses(DegreePlan degreePlan, String userName) {
			// inserts core course A
			String sql = "update courses_dp set courseCatergory=?, courseName=?, semesterTaken=?, cHrs=?, grade=? where userName=?";
			JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
			String courseCategory = "courseA";
			jdbcTemp.update(sql,
					new Object[] { courseCategory, degreePlan.getCourseA().getCourse(),
							degreePlan.getCourseA().getSemesterTaken(), degreePlan.getCourseA().getcHrs(),
							degreePlan.getCourseA().getGrade(), userName });

			// inserts core course B
			courseCategory = "courseB";
			jdbcTemp.update(sql,
					new Object[] { courseCategory, degreePlan.getCourseB().getCourse(),
							degreePlan.getCourseB().getSemesterTaken(), degreePlan.getCourseB().getcHrs(),
							degreePlan.getCourseB().getGrade(), userName });

			// inserts core course C
			courseCategory = "courseC";
			jdbcTemp.update(sql,
					new Object[] { courseCategory, degreePlan.getCourseC().getCourse(),
							degreePlan.getCourseC().getSemesterTaken(), degreePlan.getCourseC().getcHrs(),
							degreePlan.getCourseC().getGrade(), userName });

			// inserts core course D
			courseCategory = "courseD";
			int result = jdbcTemp.update(sql,
					new Object[] { courseCategory, degreePlan.getCourseD().getCourse(),
							degreePlan.getCourseD().getSemesterTaken(), degreePlan.getCourseD().getcHrs(),
							degreePlan.getCourseD().getGrade(), userName });

			return result;
		}
//this method will get the degree plans of the students submitted to admin specialist
		@Override
		public List<DegreePlan> getDegreePlans() {
			List<DegreePlan> degreePlans = new ArrayList<DegreePlan>();
			String dPStatus = "With Administrative Specialist";
			String dPStatus1 = "With Associate Chair";
			String dPStatus2 = "With Chair";
			String dPStatus3 = "Associate Chair Approved";
			String dPStatus4 = "Chair Approved";
			String dPStatus5 = "Degree Plan approved in the CSCE Department";
			String sql1 = "select name, studentId, email, degreePlanStatus from degreeplan where degreePlanStatus='" + dPStatus + "' OR degreePlanStatus='" + dPStatus1 + "' OR degreePlanStatus='" + dPStatus2 + "' OR degreePlanStatus='" + dPStatus3 + "' OR degreePlanStatus='" + dPStatus4 + "' OR degreePlanStatus='" + dPStatus5 + "'";
			JdbcTemplate jdbctem1 = new JdbcTemplate(dataSource);
			degreePlans = jdbctem1.query(sql1, new DPRowMapper());
			return degreePlans;
		}

		@Override
		public DegreePlan getReceivedDegreePlan(String sName, String sId) {
			String sql1 = "select * from degreeplan where name= '" + sName + "' and studentId = '" + sId + "'";
			JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
			DegreePlan degreePlan = (DegreePlan) jdbctem.queryForObject(sql1, new BeanPropertyRowMapper(DegreePlan.class));
			return degreePlan;
		}

		@Override
		public int submitDPToAssociateChair(int studentId, String sName) {
			// submit degree plan to associate chair
			JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
			String degreePlanStatus = "With Associate Chair";
			String sql1 =  "update degreeplan set degreePlanStatus=? where name = ? and studentId=?";
			JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
			int result = jdbcTemp.update(sql1, new Object[] {degreePlanStatus, sName, studentId});
			return result;
		}

		@Override
		public List<DegreePlan> receivedDegreePlansLevel2(String userName) {
			List<DegreePlan> degreePlans = new ArrayList<DegreePlan>();
			String dPStatus = "With Associate Chair";
			String sql1 = "select name, studentId, email, degreePlanStatus from degreeplan where degreePlanStatus='" + dPStatus + "'";
			JdbcTemplate jdbctem1 = new JdbcTemplate(dataSource);
			degreePlans = jdbctem1.query(sql1, new DPRowMapper());
			return degreePlans;
		}

		@Override
		public int submitDPToASL2(String userName, String sName, String sign) {
			// submit degree plan to administrative specialist
			String degreePlanStatus = "Associate Chair Approved";
			String sql =  "update degreeplan set degreePlanStatus=? where name = ?";
			JdbcTemplate jdbcTemp1 = new JdbcTemplate(dataSource);
			jdbcTemp1.update(sql, new Object[] {degreePlanStatus, sName});
			String sql1 =  "update degreeplan set associateChairSignature = ? where name = ?";
			JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
			int result = jdbcTemp.update(sql1, new Object[] {sign, sName});
			return result;
		}

		@Override
		public int submitDPToChair(int studentId, String sName) {
			// submit degree plan to associate chair
			JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
			String degreePlanStatus = "With Chair";
			String sql1 =  "update degreeplan set degreePlanStatus=? where name = ? and studentId=?";
			JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
			int result = jdbcTemp.update(sql1, new Object[] {degreePlanStatus, sName, studentId});
			return result;
		}

		@Override
		public List<DegreePlan> receivedDegreePlansLevel3(String userName) {
			List<DegreePlan> degreePlans = new ArrayList<DegreePlan>();
			String dPStatus = "With Chair";
			String sql1 = "select name, studentId, email, degreePlanStatus from degreeplan where degreePlanStatus='" + dPStatus + "'";
			JdbcTemplate jdbctem1 = new JdbcTemplate(dataSource);
			degreePlans = jdbctem1.query(sql1, new DPRowMapper());
			return degreePlans;
		}

		@Override
		public int submitDPToASL3(String userName, String sName, String sign) {
			// submit degree plan to administrative specialist
			String degreePlanStatus = "Chair Approved";
			String sql1 =  "update degreeplan set degreePlanStatus=?, chairSignature = ? where name = ?";
			JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
			int result = jdbcTemp.update(sql1, new Object[] {degreePlanStatus, sign, sName});
			return result;
		}

		@Override
		public int sendApprovaltoStudent(int studentId, String sName) {
			// send degree plan approval to student
			JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
			String degreePlanStatus = "Degree Plan approved in the CSCE Department";
			String sql1 =  "update degreeplan set degreePlanStatus=? where name = ? and studentId=?";
			JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
			int result = jdbcTemp.update(sql1, new Object[] {degreePlanStatus, sName, studentId});
			return result;
		}

		@Override
		public String getDPI() {
			String sql =  "select information from dpi";
			JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
			String result = jdbctem.queryForObject(sql, String.class);
			return result;
		}

		@Override
		public List<InterestArea> getInterestAreas() {
			String sql =  "select * from interestareas";
			JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
			List<InterestArea> interestAreas= jdbctem.query(sql, new InterestAreaRowMapper());
			return interestAreas;
		}
		//This method updates degree plan information
		@Override
		public int updateDPIInfo(String dpi) {
			JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
			String sql1 =  "update dpi set information=?";
			JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
			int result = jdbcTemp.update(sql1, new Object[] {dpi});
			return result;
		}

		@Override
		public int updateDPICC(CoreUpdate coreUpdate) {
			if(!((coreUpdate.getCoreA1()).equals("notChanged"))) {
				String sql1 =  "update mandatorycourses set CourseName=? where groupId = ? and major = ? and seqNum = ?";
				JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
				jdbcTemp.update(sql1, new Object[] {coreUpdate.getCoreA1(), "A", "CS", 1});
				
			}
			if(!((coreUpdate.getCoreA2()).equals("notChanged"))) {
				System.out.println(coreUpdate.getCoreA2());
				String sql1 =  "update mandatorycourses set CourseName=? where groupId = ? and major = ? and seqNum = ?";
				JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
				jdbcTemp.update(sql1, new Object[] {coreUpdate.getCoreA2(), "A", "CS", 2});
				
			}
			if(!((coreUpdate.getCoreA3()).equals("notChanged"))) {
				String sql1 =  "update mandatorycourses set CourseName=? where groupId = ? and major = ? and seqNum = ?";
				JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
				jdbcTemp.update(sql1, new Object[] {coreUpdate.getCoreA3(), "A", "CS", 3});
				
			}
			if(!((coreUpdate.getCoreB1()).equals("notChanged"))) {
				String sql1 =  "update mandatorycourses set CourseName=? where groupId = ? and major = ? and seqNum = ?";
				JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
				jdbcTemp.update(sql1, new Object[] {coreUpdate.getCoreB1(), "B", "CS", 1});
				
			}
			if(!((coreUpdate.getCoreB2()).equals("notChanged"))) {
				String sql1 =  "update mandatorycourses set CourseName=? where groupId = ? and major = ? and seqNum = ?";
				JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
				jdbcTemp.update(sql1, new Object[] {coreUpdate.getCoreB2(), "B", "CSCE", 2});
				
			}
			if(!((coreUpdate.getCoreB3()).equals("notChanged"))) {
				String sql1 =  "update mandatorycourses set CourseName=? where groupId = ? and major = ? and seqNum = ?";
				JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
				jdbcTemp.update(sql1, new Object[] {coreUpdate.getCoreB3(), "B", "CSCE", 3});
				
			}
			if(!((coreUpdate.getCoreC1()).equals("notChanged"))) {
				String sql1 =  "update mandatorycourses set CourseName=? where groupId = ? and major = ? and seqNum = ?";
				JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
				jdbcTemp.update(sql1, new Object[] {coreUpdate.getCoreC1(), "C", "CS", 1});
				
			}
			if(!((coreUpdate.getCoreC2()).equals("notChanged"))) {
				String sql1 =  "update mandatorycourses set CourseName=? where groupId = ? and major = ? and seqNum = ?";
				JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
				jdbcTemp.update(sql1, new Object[] {coreUpdate.getCoreC2(), "C", "CS", 2});
				
			}
			if(!((coreUpdate.getCoreC3()).equals("notChanged"))) {
				String sql1 =  "update mandatorycourses set CourseName=? where groupId = ? and major = ? and seqNum = ?";
				JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
				jdbcTemp.update(sql1, new Object[] {coreUpdate.getCoreC3(), "C", "CS", 3});
				
			}
			if(!((coreUpdate.getCoreD1()).equals("notChanged"))) {
				String sql1 =  "update mandatorycourses set CourseName=? where groupId = ? and major = ? and seqNum = ?";
				JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
				jdbcTemp.update(sql1, new Object[] {coreUpdate.getCoreD1(), "D", "CS", 1});
				
			}
			if(!((coreUpdate.getCoreC1()).equals("notChanged"))) {
				String sql1 =  "update mandatorycourses set CourseName=? where groupId = ? and major = ? and seqNum = ?";
				JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
				jdbcTemp.update(sql1, new Object[] {coreUpdate.getCoreD2(), "D", "CS", 2});
				
			}
			if(!((coreUpdate.getCoreC1()).equals("notChanged"))) {
				String sql1 =  "update mandatorycourses set CourseName=? where groupId = ? and major = ? and seqNum = ?";
				JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
				jdbcTemp.update(sql1, new Object[] {coreUpdate.getCoreD3(), "D", "CS", 3});
				
			}
			
			//FOR CE
			if(!((coreUpdate.getCsCoreA1()).equals("notChanged"))) {
				String sql1 =  "update mandatorycourses set CourseName=? where groupId = ? and major = ? and seqNum = ?";
				JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
				jdbcTemp.update(sql1, new Object[] {coreUpdate.getCsCoreA1(), "A", "CE", 1});
				
			}
			if(!((coreUpdate.getCsCoreA2()).equals("notChanged"))) {
				String sql1 =  "update mandatorycourses set CourseName=? where groupId = ? and major = ? and seqNum = ?";
				JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
				jdbcTemp.update(sql1, new Object[] {coreUpdate.getCsCoreA2(), "A", "CE", 2});
				
			}
			if(!((coreUpdate.getCsCoreA3()).equals("notChanged"))) {
				String sql1 =  "update mandatorycourses set CourseName=? where groupId = ? and major = ? and seqNum = ?";
				JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
				jdbcTemp.update(sql1, new Object[] {coreUpdate.getCsCoreA3(), "A", "CE", 3});
				
			}
			if(!((coreUpdate.getCsCoreB1()).equals("notChanged"))) {
				String sql1 =  "update mandatorycourses set CourseName=? where groupId = ? and major = ? and seqNum = ?";
				JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
				jdbcTemp.update(sql1, new Object[] {coreUpdate.getCsCoreB1(), "B", "CE", 1});
				
			}
			if(!((coreUpdate.getCsCoreB2()).equals("notChanged"))) {
				String sql1 =  "update mandatorycourses set CourseName=? where groupId = ? and major = ? and seqNum = ?";
				JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
				jdbcTemp.update(sql1, new Object[] {coreUpdate.getCsCoreB2(), "B", "CSCE", 2});
				
			}
			if(!((coreUpdate.getCsCoreB3()).equals("notChanged"))) {
				String sql1 =  "update mandatorycourses set CourseName=? where groupId = ? and major = ? and seqNum = ?";
				JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
				jdbcTemp.update(sql1, new Object[] {coreUpdate.getCsCoreB3(), "B", "CSCE", 3});
				
			}
			if(!((coreUpdate.getCsCoreC1()).equals("notChanged"))) {
				String sql1 =  "update mandatorycourses set CourseName=? where groupId = ? and major = ? and seqNum = ?";
				JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
				jdbcTemp.update(sql1, new Object[] {coreUpdate.getCsCoreC1(), "C", "CE", 1});
				
			}
			if(!((coreUpdate.getCsCoreC2()).equals("notChanged"))) {
				String sql1 =  "update mandatorycourses set CourseName=? where groupId = ? and major = ? and seqNum = ?";
				JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
				jdbcTemp.update(sql1, new Object[] {coreUpdate.getCsCoreC2(), "C", "CE", 2});
				
			}
			if(!((coreUpdate.getCsCoreC3()).equals("notChanged"))) {
				String sql1 =  "update mandatorycourses set CourseName=? where groupId = ? and major = ? and seqNum = ?";
				JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
				jdbcTemp.update(sql1, new Object[] {coreUpdate.getCsCoreC3(), "C", "CE", 3});
				
			}
			if(!((coreUpdate.getCsCoreD1()).equals("notChanged"))) {
				String sql1 =  "update mandatorycourses set CourseName=? where groupId = ? and major = ? and seqNum = ?";
				JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
				jdbcTemp.update(sql1, new Object[] {coreUpdate.getCsCoreD1(), "D", "CE", 1});
				
			}
			if(!((coreUpdate.getCsCoreD2()).equals("notChanged"))) {
				String sql1 =  "update mandatorycourses set CourseName=? where groupId = ? and major = ? and seqNum = ?";
				JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
				jdbcTemp.update(sql1, new Object[] {coreUpdate.getCsCoreD2(), "D", "CE", 2});
				
			}
			if(!((coreUpdate.getCsCoreD3()).equals("notChanged"))) {
				String sql1 =  "update mandatorycourses set CourseName=? where groupId = ? and major = ? and seqNum = ?";
				JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
				jdbcTemp.update(sql1, new Object[] {coreUpdate.getCsCoreD3(), "D", "CE", 3});
				
			}
			return 1;
		}

		@Override
		public int addOpCourse(String oPName) {
			String sql1 = "INSERT INTO courses "
					+ "(courseName) VALUES (?)";
			JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
			int result = jdbcTemp.update(sql1, new Object[] {oPName});
			return result;
		}

		@Override
		public int deleteOpCourse(String oPName) {
			String sql = "delete from courses where courseName='" + oPName + "'";  
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
			jdbcTemplate.update(sql);
			return 1;
		}

}
