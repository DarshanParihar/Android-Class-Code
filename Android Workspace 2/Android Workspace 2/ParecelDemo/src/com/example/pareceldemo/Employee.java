package com.example.pareceldemo;

import android.os.Parcel;
import android.os.Parcelable;

public class Employee implements Parcelable {
	private String empName;
	private int empAge;
	private String empCompany;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	public String getEmpCompany() {
		return empCompany;
	}

	public void setEmpCompany(String empCompany) {
		this.empCompany = empCompany;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(getEmpName());
		dest.writeInt(getEmpAge());
		dest.writeString(getEmpCompany());
	}

	public static final Parcelable.Creator<Employee> CREATOR = new Creator<Employee>() {

		@Override
		public Employee[] newArray(int size) {
			return new Employee[size];
		}

		@Override
		public Employee createFromParcel(Parcel source) {
			Employee employee = new Employee();
			employee.setEmpName(source.readString());
			employee.setEmpAge(source.readInt());
			employee.setEmpCompany(source.readString());
			return employee;
		}
	};

}
