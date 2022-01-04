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
public class Node {

    Person info;
    Node next;

    Node(Person x, Node p) {
        info = x;
        next = p;
    }

    Node(Person x) {
        this(x, null);
    }
}
