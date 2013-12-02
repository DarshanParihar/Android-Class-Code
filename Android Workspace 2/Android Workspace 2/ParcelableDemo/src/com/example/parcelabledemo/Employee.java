package com.example.parcelabledemo;

import android.os.Parcel;
import android.os.Parcelable;

public class Employee implements Parcelable {

	private String empName;
	private int empAge;
	private String empLocation;

	public String getEmpName() {
		return empName;
	}

	public int getEmpAge() {
		return empAge;
	}

	public String getEmpLocation() {
		return empLocation;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(getEmpName());
		dest.writeInt(getEmpAge());
		dest.writeString(getEmpLocation());
	}

	public static Parcelable.Creator<Employee> CREATOR = new Creator<Employee>() {

		@Override
		public Employee[] newArray(int size) {
			return new Employee[size];
		}

		@Override
		public Employee createFromParcel(Parcel source) {

			Employee employee = new Employee();
			employee.setEmpName(source.readString());
			employee.setEmpAge(source.readInt());
			employee.setEmpLocation(source.readString());
			return employee;
		}
	};
}
