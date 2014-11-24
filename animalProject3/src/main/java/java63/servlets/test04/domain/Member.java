/* Value Object
 * => Class 문법을 사용하여 사용자 정의 데이터 타입 만들기
 * 
 * 1) Serializable 인터페이스 구현
 *    => SerialVersionUID 스태틱 변수 선언
 * 
 * 2) 인스턴스 변수 선언
 * 
 * 3) setter/getter 생성
 * 
 * 4) 기본 생성자와 파라미터 값을 받는 생성자 선언
 * 
 * 5) equals()/hashCode() 메서드 오버라이딩
 * 
 * 6) toString() 오버라이딩
 */
package java63.servlets.test04.domain;

import java.io.Serializable;

//`ID`    VARCHAR(20)  NOT NULL COMMENT '아이디', -- 아이디
//`UNAME` VARCHAR(50)  NOT NULL COMMENT '글쓴이', -- 글쓴이
//`TEL`   VARCHAR(30)  NOT NULL COMMENT '전화', -- 전화
//`ADDR`  VARCHAR(255) NOT NULL COMMENT '주소', -- 주소
 //`PWD`   VARCHAR(20)  NOT NULL COMMENT '비밀번호' -- 비밀번호

public class Member implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	protected String id;
	protected String name;
	protected String tel;
	protected String addr;
	protected String pwd;

	public Member() {
	}

	

	@Override
	public Member clone() throws CloneNotSupportedException {
		return (Member) super.clone();
	}



	public Member(String id, String name, String tel, String addr, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.addr = addr;
		this.pwd = pwd;
	}



	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", tel=" + tel
				+ ", addr=" + addr + ", pwd=" + pwd + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addr == null) ? 0 : addr.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (addr == null) {
			if (other.addr != null)
				return false;
		} else if (!addr.equals(other.addr))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getAddr() {
		return addr;
	}



	public void setAddr(String addr) {
		this.addr = addr;
	}



	public String getPwd() {
		return pwd;
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
