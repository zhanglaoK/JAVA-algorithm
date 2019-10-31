package com.junxi.day03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 自定义比较器练习
 */
public class SelfComparator {

    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name,int id,int age){
            this.name = name;
            this.id = id;
            this.age = age;
        }

    }
    public static class IdAscComparator implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }

    public static void printStudents(Student[]students){
        for (Student student:students) {
            System.out.println("Name:"+student.name+"\t"+"Id:"+student.id+"\t"+"age:"+student.age);
        }
        System.out.println("=======================================");
    }

    public static class AgeDescComparator implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return o2.age - o1.age;
        }
    }

    public static class AgeAscComparator implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("Amy", 2, 18);
        Student s2 = new Student("Mike", 1, 16);
        Student s3 = new Student("laozhang", 3, 22);
        Student[] students = new Student[]{s1,s2,s3};
        printStudents(students);
        Arrays.sort(students,new IdAscComparator());
        printStudents(students);
        Arrays.sort(students,new AgeDescComparator());
        printStudents(students);
        Arrays.sort(students,new AgeAscComparator());
        printStudents(students);

        PriorityQueue<Student> pq = new PriorityQueue<Student>(new IdAscComparator());
        pq.add(s1);
        pq.add(s2);
        pq.add(s3);
        while(!pq.isEmpty()){
            Student student = pq.poll();
            System.out.println("Name:"+student.name+"\t"+"Id:"+student.id+"\t"+"age:"+student.age);
        }
    }

}
