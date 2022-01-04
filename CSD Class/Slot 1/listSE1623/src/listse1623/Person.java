/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listse1623;

/**
 *
 * @author Lenovo
 */
public class Person {

    String name;
    int age;

    Person(String xName, int xAge) {
        name = xName;
        age = xAge;
    }

    public String toString() {
        return ("(" + name + "," + age + ") ");
    }
}
