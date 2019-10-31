package com.junxi.day04;


import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 猫狗队列
 * 实现一种狗猫队列的结构，要求如下： 用户可以调用add方法将cat类或dog类的
 * 实例放入队列中； 用户可以调用pollAll方法，将队列中所有的实例按照进队列
 * 的先后顺序依次弹出； 用户可以调用pollDog方法，将队列中dog类的实例按照
 * 进队列的先后顺序依次弹出； 用户可以调用pollCat方法，将队列中cat类的实
 * 例按照进队列的先后顺序依次弹出； 用户可以调用isEmpty方法，检查队列中是
 * 否还有dog或cat的实例； 用户可以调用isDogEmpty方法，检查队列中是否有dog
 * 类的实例； 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
 *

 */
public class DogCatQueue {

    public static class Pet{
        private String type;

        public Pet(String type){
            this.type = type;
        }

        public String getType() {
            return this.type;
        }


    }

    public static class Dog extends Pet{
        public Dog(){
            super("dog");
        }
    }

    public static class Cat extends Pet{
        public Cat(){
            super("cat");
        }
    }


    public static class PetEntry{
        private Pet pet;
        private long count;

        public PetEntry(Pet pet,long count){
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return this.pet;
        }

        public long getCount() {
            return this.count;
        }

        public String getPetType(){
            return this.pet.getType();
        }
    }

    public static class CatAndDog{
        private Queue<PetEntry> dogQ;
        private Queue<PetEntry> catQ;
        private int count;

        public CatAndDog(){
            this.dogQ = new LinkedList<PetEntry>();
            this.catQ = new LinkedList<PetEntry>();
            this.count = 0;
        }

        public void add(Pet pet){
            if(pet.getType().equals("dog")){
                this.dogQ.add(new PetEntry(pet,this.count++));
            }else if(pet.getType().equals("cat")){
                this.catQ.add(new PetEntry(pet,this.count++));
            }else{
                throw new RuntimeException("err, not dog or cat");
            }
        }


    }

}
