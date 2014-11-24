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
import java.util.Date;

//`BNO`     INTEGER      NOT NULL COMMENT '게시글번호', -- 게시글번호 1
//`ADDR`    VARCHAR(255) NOT NULL COMMENT '주소', -- 주소 1
//`TEL`     VARCHAR(30)  NOT NULL COMMENT '전화번호', -- 전화번호
//`F_PLACE` VARCHAR(255) NOT NULL COMMENT '발견장소', -- 발견장소 1
 //`F_DATE`  DATE         NOT NULL COMMENT '발견날짜', -- 발견날짜 1
//`GENDER`  VARCHAR(50)  NOT NULL COMMENT '성별', -- 성별 1
//`TITLE`   VARCHAR(255) NOT NULL COMMENT '글제목', -- 글제목 1
//`CONTENT` VARCHAR(255) NOT NULL COMMENT '내용', -- 내용 1
//`PHOTO`   VARCHAR(255) NOT NULL COMMENT '사진', -- 사진 1
//`UID`     VARCHAR(50)  NOT NULL COMMENT '아이디', -- 아이디 1
//`B_DATE`  DATE         NOT NULL COMMENT '등록일시' -- 등록일시 1
//BREED 1

public class Board implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	protected int no;
	protected String breed;
	protected String findPlace;
	protected String findDate;
	protected String gender;
	protected String title;
	protected String content;
	protected String id;
	protected String addr;
	protected String tel;
	protected String photo;
	protected Date bDate;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addr == null) ? 0 : addr.hashCode());
		result = prime * result + ((bDate == null) ? 0 : bDate.hashCode());
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result
				+ ((findDate == null) ? 0 : findDate.hashCode());
		result = prime * result
				+ ((findPlace == null) ? 0 : findPlace.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + no;
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Board other = (Board) obj;
		if (addr == null) {
			if (other.addr != null)
				return false;
		} else if (!addr.equals(other.addr))
			return false;
		if (bDate == null) {
			if (other.bDate != null)
				return false;
		} else if (!bDate.equals(other.bDate))
			return false;
		if (breed == null) {
			if (other.breed != null)
				return false;
		} else if (!breed.equals(other.breed))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (findDate == null) {
			if (other.findDate != null)
				return false;
		} else if (!findDate.equals(other.findDate))
			return false;
		if (findPlace == null) {
			if (other.findPlace != null)
				return false;
		} else if (!findPlace.equals(other.findPlace))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (no != other.no)
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Board [no=" + no + ", breed=" + breed + ", findPlace="
				+ findPlace + ", findDate=" + findDate + ", gender=" + gender
				+ ", title=" + title + ", content=" + content + ", id=" + id
				+ ", addr=" + addr + ", tel=" + tel + ", photo=" + photo
				+ ", bDate=" + bDate + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getFindPlace() {
		return findPlace;
	}

	public void setFindPlace(String findPlace) {
		this.findPlace = findPlace;
	}

	public String getFindDate() {
		return findDate;
	}

	public void setFindDate(String findDate) {
		this.findDate = findDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getbDate() {
		return bDate;
	}

	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}

	public Board() {
	}

	@Override
	public Board clone() throws CloneNotSupportedException {
		return (Board) super.clone();
	}
}
