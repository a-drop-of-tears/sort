package test;

import java.io.Serializable;

/**
 * @program: sort
 * @Date: 2018/10/11 17:05
 * @Author: Mr.Li
 * @Description:
 */
public class Person implements Serializable {
    private String name;
    private Integer age;
    public String p;

    public Person(){}

    public Person(String name,Integer age){
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return name.hashCode()+age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (obj instanceof Person) {
            Person p = (Person) obj;
            return name.equals(p.name) && age.equals(p.age);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", p=" + p +
                '}';
    }
}
