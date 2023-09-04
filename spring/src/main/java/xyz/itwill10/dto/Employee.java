package xyz.itwill10.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class Employee {
	//@NotNull : 전달값이 [null]인 경우 에러를 발생하는 어노테이션
	//@NotBlank : 전달값이 [null]이거나 전달값에 공백이 있는 경우 에러를 발생하는 어노테이션
	//@NotEmpty : 전달값이 [null]이거나 [""] 경우 에러를 발생하는 어노테이션
	// => 에러 발생시 기본적인 메세지를 제공받아 뷰에게 전달
	//message 속성 : 뷰에게 전달할 에러 메세지를 속성값으로 설정
	@NotEmpty(message = "아이디를 입력해 주세요.")
	//@Size : 전달값의 크기를 비교하여 에러를 발생하는 어노테이션
	//min 속성 : 전달값의 최소 크기를 속성값으로 설정
	//max 속성 : 전달값의 최대 크기를 속성값으로 설정
	//@Size(min = 6, max = 20, message = "아이디는 최소 6자 이상 최대 20자 이하로만 입력해 주세요.")
	//@Pattern : 정규표현식의 패턴과 같지 않은 경우 에러를 발생하는 어노테이션
	//regexp 속성 : 전달값의 패턴을 비교하기 위한 정규표현식을 속성값으로 설정
	@Pattern(regexp = "^[a-zA-Z]\\w{5,19}$", message = "아이디를 형식에 맞게 입력해 주세요.")
	private String id;
	@NotEmpty(message = "비밀번호를 입력해 주세요.")
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$", message = "비밀번호를 형식에 맞게 입력해 주세요.")
	private String passwd;
	@NotEmpty(message = "이름을 입력해 주세요.")
	private String name;
	@NotEmpty(message = "이메일을 입력해 주세요.")
	//@Email : 이메일 형식이 틀린 경우 에러를 발생하는 어노테이션
	@Email(message = "이메일을 형식에 맞게 입력해 주세요.")
	private String email;
	@NotEmpty(message = "성별을 입력해 주세요.")
	private String gender;
}