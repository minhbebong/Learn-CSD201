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

    //(2) Tìm kiếm bằng tên
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

    //(3) Thêm phần tử có nội dung vào đầu 
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
        Node f = head;
        while (f != null && f.next != q) {            
            f = f.next;
        }
        if (f == null) {
            insertAfter(f, x);
        }
    }
    //(6)Xóa nút đầu tiên
    void removeFirst(){
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }
    //Xóa nút tạo từ q
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
             return;
         }
         Node q1 = q.next;//giữ địa chỉ phần tử phía sau q bằng q1
         f.next = q1;
         if(f.next == null){
             tail = f;
         }
     }
}
