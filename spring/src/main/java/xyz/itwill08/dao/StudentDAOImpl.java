package xyz.itwill08.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import lombok.Setter;

//SpringDAO ����� �̿��Ͽ� DAO Ŭ���� �ۼ� - spring-jdbc ���̺귯���� ������Ʈ�� ���� ó��
// => JdbcTemplate ��ü�� �޼ҵ带 ȣ���Ͽ� DAO Ŭ������ �޼ҵ� �ۼ�

public class StudentDAOImpl implements StudentDAO {
	//JdbcTemplate ��ü�� �����ϱ� ���� �ʵ� ���� - DI ����� ����Ͽ� JdbcTemplate�� �ʵ忡 ����  
	// => Spring Bean Configuration File���� DAO Ŭ������ Spring Bean���� ����� �� JdbcTemplate
	//Ŭ������ Spring Bean�� �����޾� ������ ���� - Setter Injection
	@Setter
	private JdbcTemplate jdbcTemplate;

	//�л������� ���޹޾� STUDENT ���̺� �л������� �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	@Override
	public int insertStudent(Student student) {
		String sql="insert into student values(?,?,?,?,?)";
		//JdbcTemplate.update(String sql, Object ... args) : SQL ���(INSERT, UPDATE, DELETE)��
		//DBMS ������ �����Ͽ� �����ϴ� �޼ҵ� - �������� ����(int) ��ȯ
		// => �Ű��������� DBMS ������ �����Ͽ� ������ SQL ��ɰ� InParameter(?) ��� ����
		//���� ���ʴ�� �����Ͽ� ����
		// => SQL ����� InParameter(?) ������ŭ �ݵ�� args �Ű������� ���� ����
		return jdbcTemplate.update(sql, student.getNo(), student.getName()
				, student.getPhone(), student.getAddress(), student.getBirthday());
	}

	//�л������� ���޹޾� STUDENT ���̺� ����� �л������� �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	@Override
	public int updateStudent(Student student) {
		String sql="update student set name=?, phone=?, address=?, birthday=? where no=?";
		return jdbcTemplate.update(sql, student.getName(), student.getPhone()
				, student.getAddress(), student.getBirthday(), student.getNo());
	}

	//�л���ȣ�� ���޹޾� STUDENT ���̺� ����� �л������� �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	@Override
	public int deleteStudent(int no) {
		return jdbcTemplate.update("delete from student where no=?", no);
	}

	//�л���ȣ�� ���޹޾� STUDENT ���̺� ����� �л������� �˻��Ͽ� DTO ��ü�� ��ȯ�ϴ� �޼ҵ�
	@Override
	public Student selectStudent(int no) {
		try {
			String sql="select no, name, phone, address, birthday from student where no=?";
			//JdbcTemplate.queryForObject(String sql, RowMapper<T> rowMapper, Object ... args)
			// => SQL ���(SELECT)�� DBMS ������ �����Ͽ� �����ϴ� �޼ҵ�
			// => �������� �˻������ �ϳ��� Java ��ü�� ��ȯ�ϱ� ���� ���
			// => �Ű��������� DBMS ������ �����Ͽ� ������ SQL ��ɰ� �˻����� Java ��ü�� ��ȯ�ϱ�
			//���� ���������� �����ϴ� RowMapper ��ü�� InParameter(?) ��� ���� ���� ���ʴ�� �����Ͽ� ����
			return jdbcTemplate.queryForObject(sql, new StudentRowMapper(), no);
		} catch (EmptyResultDataAccessException e) {
			//EmptyResultDataAccessException : queryForObject() �޼ҵ�� ���޵� SELECT ��ɿ�
			//���� �˻����� ���� ��� �߻��Ǵ� ����
			return null;
		}
	}

	//STUDENT ���̺� ����� ��� �л������� �˻��Ͽ� List ��ü�� ��ȯ�ϴ� �޼ҵ�
	@Override
	public List<Student> selectStudentList() {
		String sql="select no, name, phone, address, birthday from student order by no";
		//JdbcTemplate.query(String sql, RowMapper<T> rowMapper, Object ... args)
		// => SQL ���(SELECT)�� DBMS ������ �����Ͽ� �����ϴ� �޼ҵ�
		// => �ټ����� �˻������ List ��ü�� ��ȯ�ϱ� ���� ��� - �ϳ��� �˻����� List ��ü�� ��ҷ� ����
		// => �Ű��������� DBMS ������ �����Ͽ� ������ SQL ��ɰ� �˻����� Java ��ü�� ��ȯ�ϱ�
		//���� ���������� �����ϴ� RowMapper ��ü�� InParameter(?) ��� ���� ���� ���ʴ�� �����Ͽ� ����
		return jdbcTemplate.query(sql, new StudentRowMapper());
	}
	
	//RowMapper ��ü�� �����ϱ� ���� ���� Ŭ���� ����
	//RowMapper ��ü : �˻����� Java ��ü�� ��ȯ�Ͽ� �����ϱ� ���� ���������� ����� ��ü
	// => �˻����� �÷����� Java ��ü �ʵ忡 �����ϱ� ���� �������� ����
	// => RowMapper �������̽��� ��ӹ��� �ڽ�Ŭ������ ��ü ���� - �͸��� ����Ŭ������ ��ü ���� ����
	// => RowMapper ��ü�� ������ �� ���Ǵ� ���׸����� �˻����� ��ȯ�� Java ��ü�� �ڷ����� ����
	// => RowMapper �������̽��� ��ӹ��� �ڽ�Ŭ������ mapRow() �߻�޼ҵ带 �������̵� ����
	// => mapRow() �޼ҵ��� �Ű������� ResultSet ��ü�� �����޾� Java ��ü�� ��ȯ�ϴ� ��� �ۼ�
	public class StudentRowMapper implements RowMapper<Student> {
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student=new Student();
			student.setNo(rs.getInt("no"));
			student.setName(rs.getString("name"));
			student.setPhone(rs.getString("phone"));
			student.setAddress(rs.getString("address"));
			student.setBirthday(rs.getString("birthday"));
			return student;
		}
	}
}