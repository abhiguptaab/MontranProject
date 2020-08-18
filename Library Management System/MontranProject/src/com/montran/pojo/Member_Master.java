package com.montran.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity(name = "member_master")
public class Member_Master {

		@Id
		@Column(name = "member_code")
		private String memberId;
		@Column(name ="member_name")
		private String name;
		@Column(name = "member_type")
		private String memberType;
		@Column(name ="no_of_copies")
		private int no_of_books_issue;
		
		

		public Member_Master(String memberId, String name, String memberType, int no_of_books_issue, String address) {
			super();
			this.memberId = memberId;
			this.name = name;
			this.memberType = memberType;
			this.no_of_books_issue = no_of_books_issue;
		
		}
		
		public String getMemberId() {
			return memberId;
		}
		public void setMemberId(String memberId) {
			this.memberId = memberId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getMemberType() {
			return memberType;
		}
		public void setMemberType(String memberType) {
			this.memberType = memberType;
		}
		public int getNo_of_books_issue() {
			return no_of_books_issue;
		}
		public void setNo_of_books_issue(int no_of_books_issue) {
			this.no_of_books_issue = no_of_books_issue+1;
		}
		
		
		
		public Member_Master() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Member_Master [memberId=" + memberId + ", name=" + name + ", memberType=" + memberType
					+ ", no_of_books_issue=" + no_of_books_issue + ", address="  + "]";
		}
		
		
}
