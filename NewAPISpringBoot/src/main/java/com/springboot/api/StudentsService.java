package com.springboot.api;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class StudentsService {
    
	public static ArrayList<Students> list = new ArrayList<Students>();
	
	static {
		list.add(new Students(1,"Anjali","CSE","Raipur"));
		list.add(new Students(2,"Vanshika","CSE","Bhilai"));
		list.add(new Students(3,"Pooja","Medical","Durg"));
	}
	
	public ArrayList<Students> getStudents(){
		return list;
	}
	

	//display students by id
	public Students getStudentsById(int id) {
		
		Students student=null;
		
		for(Students i : list) {
			if (i.getId()==id) {
				student=i;
			}
		}
		return student;
	}
	
	//display student by course
	public ArrayList<Students> getStudentsByCourse(String course) {
		
		ArrayList<Students> newlist = new ArrayList<Students>();
		Students student = null;
		
		for(Students i : list) {
			if(i.getCourse()==course) {
				student=i;
				newlist.add(student);
			}
		}
		return newlist;
	}
	
	//add a student
	public Students addStudent(Students s) {
		
		list.add(s);
		return s;
	}
	
	//delete a student by id 
	public Students deleteById(int id) {
		Students student=null;
		
		for(Students i : list) {
			if(i.getId()==id) {
				student=i;
			}
		}
		list.remove(student);
		return student;
	}
	
	//update a student by id 
	public Students updateById(Students s,int id) {
		
		int index;
		Students  students=  null;
		
		for(Students i : list) {
			if(i.getId()==id) {
				index= list.indexOf(i);
				students = s;
				list.set(index,students);
			}
		}
		return students;
	}
}
