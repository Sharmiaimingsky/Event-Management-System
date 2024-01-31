package com.sunbeam.ems.dtos;

public class CredentialsUser {
	 
		private String email;
		private String password;
		public CredentialsUser() {
			super();
		}
		public CredentialsUser(String email, String password) {
			super();
			this.email = email;
			this.password = password;
		}
		@Override
		public String toString() {
			return "CredentialsUser [email=" + email + ", password=" + password + "]";
		}
		public String getEmail() {
			return email;
		}
		public String getPassword() {
			return password;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public void setPassword(String password) {
			this.password = password;
		}
}
