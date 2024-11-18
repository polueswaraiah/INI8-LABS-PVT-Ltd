package com.sanju.com;


public class Customers {
         private  int Id;
         private   String  Name ;
         private   String email;
         private   String Address; 
         private   String city;
 
		

		public Customers(int Id, String Name, String email, String Address, String city) {
			 this.Id = Id;
			 this.Name = Name;
			 this. email = email;
			 this. Address = Address;
			 this. city = city;
		}

		public int getC_Id() {
			return Id;
		}
		
		public String getC_Name() {
			return Name;
		}
		
		public String getC_email() {
			return email;
		}
		
		public String getC_Address() {
			return Address;
		}
	
		public String getC_city() {
			return city;
		}
	
		public void setC_Name(String Name) {
			this.Name = Name;
		}
	
		public void setC_email(String email) {
			this.email = email;
		}
		
		public void setC_Address(String c_Address) {
			this.Address = c_Address;
		}
		
		public void setC_city(String c_city) {
			this.city = c_city;
		}

}





