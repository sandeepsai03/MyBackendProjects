package com.excelr.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Setter
//@Getter
public class User {

    @NotNull(message = "Username is required")
    @Size(min = 3, max = 8, message = "Username must be between 3 to 8 characters")
    private String uname;

    @NotNull(message = "Password is required")
    @Size(min = 6, max = 15, message = "Password should be between 6 to 15 characters")
    private String pwd;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Phone number is required")
    @Size(min = 10, max = 10, message = "Phone number must be 10 digits")
    private String phno;

    @NotNull(message = "Age is required")
    @Min(value = 21, message = "Age should be at least 21")
    @Max(value = 60, message = "Age must not be greater than 60")
    private Integer age;
    
//    public User() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public User(
//			@NotNull(message = "Username is required") @Size(min = 3, max = 8, message = "Username must be between 3 to 8 characters") String uname,
//			@NotNull(message = "Password is required") @Size(min = 6, max = 15, message = "Password should be between 6 to 15 characters") String pwd,
//			@NotBlank(message = "Email is required") @Email(message = "Invalid email format") String email,
//			@NotNull(message = "Phone number is required") @Size(min = 10, max = 10, message = "Phone number must be 10 digits") String phno,
//			@NotNull(message = "Age is required") @Min(value = 21, message = "Age should be at least 21") @Max(value = 60, message = "Age must not be greater than 60") Integer age) {
//		super();
//		this.uname = uname;
//		this.pwd = pwd;
//		this.email = email;
//		this.phno = phno;
//		this.age = age;
//	}
//
//	public String getUname() {
//		return uname;
//	}
//
//	public void setUname(String uname) {
//		this.uname = uname;
//	}
//
//	public String getPwd() {
//		return pwd;
//	}
//
//	public void setPwd(String pwd) {
//		this.pwd = pwd;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPhno() {
//		return phno;
//	}
//
//	public void setPhno(String phno) {
//		this.phno = phno;
//	}
//
//	public Integer getAge() {
//		return age;
//	}
//
//	public void setAge(Integer age) {
//		this.age = age;
//	}
//
//	@Override
//	public String toString() {
//		return "User [uname=" + uname + ", pwd=" + pwd + ", email=" + email + ", phno=" + phno + ", age=" + age
//				+ ", getUname()=" + getUname() + ", getPwd()=" + getPwd() + ", getEmail()=" + getEmail()
//				+ ", getPhno()=" + getPhno() + ", getAge()=" + getAge() + ", getClass()=" + getClass() + ", hashCode()="
//				+ hashCode() + ", toString()=" + super.toString() + "]";
//	}
//    
    
}
