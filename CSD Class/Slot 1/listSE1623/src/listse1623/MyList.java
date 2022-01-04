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
public class MyList {
    
    Node head, tail;
    
    MyList() {
        head = tail = null;
    }
    
    void clear() {
        head = tail = null;
    }
    
    boolean isEmpty() {
        return (head == null);
    }

    //(1) Thêm phần tử x vào cuối 
    void addLast(Person x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }
    
    void visit(Node p) {//in ra nội dung tạo bởi p
        if (p != null) {
            System.out.print(p.info + " ");
        }
    }
    
    void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
    }
    
    void addMany(String[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            addLast(new Person(a[i], b[i]));
        }
    }

    //(2) tim node co ten ung voi ten truyen vao
    Node searchByName(String xName) {
        Node p = head;
        while (p != null) {
            if (p.info.name.equals(xName)) {
                return (p);
            }
            p = p.next;
            
        }
        return (null);
    }

    //Tìm kiếm bằng tuổi
    Node searchByAge(int xAge) {
        Node p = head;
        while (p != null) {
            if (p.info.name.equals(xAge)) {
                return (p);
            }
            p = p.next;
            
        }
        return (null);
    }

    //(3) Them 1 phan tu vao dau linkedlist 
    void addFirst(Person x) {
        head = new Node(x, head);
        if (tail == null) {
            tail = head;
        }
    }
    
    void insertAfter(Node q, Person x) {
        if (isEmpty() || q == null) {
            return;
        }
        Node q1 = q.next;
        Node p = new Node(x, q1);
        q.next = p;
        if (tail == q) {
            tail = p;
        }
    }
    //Chèn vào trước nút bởi q nút có dung nội dung là x
    void insertBefore(Node q, Person x) {
        if (isEmpty() || q == null) {
            return;
        }
        if (q == head) {
            addFirst(x);
            return;
        }
        //tim node f truoc node q
        Node f = head;
        while (f != null && f.next != q) {            
            f = f.next;
        }
        if (f == null) {
            insertAfter(f, x);
        }
    }
    //(6)Xoa node dau tien trong list
    void removeFirst(){
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }
    //xoa node q trong list
    void remove(Node q)
     {
         if (isEmpty() || q==null) {
             return;
         }
         if (q == head) {
             removeFirst();
             return;
         }
         Node f = head;
         while (f != null && f.next  != q) {             
             f = f.next;
         }
         if (f == null) {
             return;//q is not in the list
         }
         Node q1 = q.next;//xoa node tail
         f.next = q1;
         if(f.next == null){
             tail = f;
         }
     }
    // Xoa node ung voi ten truyen vao
    void remove(String xName) {
        remove(searchByName(xName));
    }

    // Xoa node ung voi tuoi truyen vao
    void remove(int xAge) {
        remove(searchByAge(xAge));
    }
    
    //Xoa tat ca ca node ten truyen vao
    void removeAll(String xName) {
        Node p;
        while ((p = searchByName(xName)) != null) {
            remove(p);
        }
    }

    // Xoa tat ca cac node tuoi truyen vao
    void removeAll(int xAge) {
        Node p;
        while ((p = searchByAge(xAge)) != null) {
            remove(p);
        }
    }
    
    // tra ve node ung voi vi tri k truyen vao
    Node pos(int k) {
        int i = 0;
        Node p = head;
        while (p != null) {
            if (i == k) {
                return p;
            }
            i++;
            p = p.next;
        }
        return (null);
    }

    // (17)
    void removePos(int k) {
        remove(pos(k));
    }
    //Sap xep node theo ten
     void sortByName() {
        Node pi, pj;
        Person tmp;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pi.info.name.compareTo(pj.info.name) > 0) {
                    tmp = pi.info;
                    pi.info = pj.info;
                    pj.info = tmp;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    // Sap xep node theo tuoi
    void sortByAge() {
        Node pi, pj;
        Person tmp;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pi.info.age > pj.info.age) {
                    tmp = pi.info;
                    pi.info = pj.info;
                    pj.info = tmp;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }
    
    //tra ve kick thuoc cua linkedlist
    int size() {
        int count = 0;
        Node p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        return (count);
    }

    //chuyen list sang mang
    Person[] toArray() {
        int n, i;
        n = size();
        Person[] persons = new Person[n];
        Node p = head;
        i = 0;
        while (p != null) {
            persons[i++] = new Person(p.info.name, p.info.age);
            p = p.next;
        }
        return (persons);
    }
    
    //dao linkedlist
     void reverse() {
        MyList t = new MyList();
        Node p = head;
        while (p != null) {
            t.addFirst(p.info);
        }
        head = t.head;
        tail = t.tail;
    }

    // (23) 
    Node findMaxAge() {
        return (null);
    }

    // (24) 
    Node findMinAge() {
        return (null);
    }

    // (24) 
    void setData(Node p, Person x) {
        if (p != null) {
            p.info = x;
        }
    }

    // (26) 
    void sortByAge(int k, int h) {
    }

    // (27) 
    void reverse(int k, int h) // reverse from k to h 
    {
    }
}
