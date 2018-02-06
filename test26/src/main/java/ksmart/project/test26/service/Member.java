package ksmart.project.test26.service;

public class Member {
	private String member_no;
	private String member_id;
	private String member_pw;
	private String member_level;

	public String getMember_no() {
		return member_no;
	}

	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_level() {
		return member_level;
	}

	public void setMember_level(String member_level) {
		this.member_level = member_level;
	}

	@Override
	public String toString() {
		return "Member [member_no=" + member_no + ", member_id=" + member_id + ", member_pw=" + member_pw
				+ ", member_level=" + member_level + ", getMember_no()=" + getMember_no() + ", getMember_id()="
				+ getMember_id() + ", getMember_pw()=" + getMember_pw() + ", getMember_level()=" + getMember_level()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
