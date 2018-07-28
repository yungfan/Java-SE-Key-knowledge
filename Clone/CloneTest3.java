package com.yangfan.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * 利用Serializable实现深复制 也是实现深复制最好的方式
 * @author 杨帆
 *
 */
public class CloneTest3
{
	public static void main(String[] args) throws CloneNotSupportedException,IOException, ClassNotFoundException
	{
		Teacher2 teacher = new Teacher2();

		teacher.setAge(40);
		teacher.setName("Teacher zhang");

		Student3 s1 = new Student3();

		s1.setAge(20);
		s1.setName("zhangsan");
		s1.setTeacher(teacher);

		Student3 s2 = (Student3) s1.deepCopy();
		System.out.println(s2.getName());
		System.out.println(s2.getAge());

		System.out.println(s1.getTeacher().getName());
		System.out.println(s1.getTeacher().getAge());
		System.out.println(s2.getTeacher().getName());
		System.out.println(s2.getTeacher().getAge());

		System.out.println("--------------------");

		teacher.setName("Teacher Li");

		System.out.println(s1.getTeacher().getName());
		System.out.println(s1.getTeacher().getAge());
		System.out.println(s2.getTeacher().getName());
		System.out.println(s2.getTeacher().getAge());
	}

}

class Teacher2 implements Serializable
{
	private int age;

	private String name;

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}

class Student3 implements Serializable
{
	private int age;

	private String name;

	private Teacher2 teacher;

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Teacher2 getTeacher()
	{
		return teacher;
	}

	public void setTeacher(Teacher2 teacher)
	{
		this.teacher = teacher;
	}

	public Object deepCopy() throws IOException, ClassNotFoundException
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		ObjectOutputStream oos = new ObjectOutputStream(bos);

		oos.writeObject(this);

		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());

		ObjectInputStream ois = new ObjectInputStream(bis);

		return ois.readObject();
	}

}