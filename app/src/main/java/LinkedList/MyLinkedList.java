package LinkedList;

import android.support.annotation.NonNull;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> trail;

    public boolean add(Node<T> node) {
        if (node == null) {
            return false;
        }
        if (head == null) {
            head = trail = node;
            return true;
        }

        node.next = null;
        trail.next = node;
        trail = node;
        return true;
    }

    public boolean remove(Node<T> node) {
        if (head == null) {
            return false;
        }

        if (node.data == head.data) {// 删除链表的头节点，只需要把链表首指针指向第二个节点即可
            head = head.next;
            return true;
        } else if (trail.data == node.data) { //如果为尾节点，只要将指向最后一个节点的指针直接指向null即可
            Node c = head;
            //找到要删除的节点的前一个节点（注意是c.next中的数据与要删除节点中的数据相比较）
            while (c.next.data != node.data) {
                c = c.next;
            }
            c.next = null;
        } else {//中间节点，将要删除节点的前一个节点的下一个节点设为将要删除节点的下一个节点
            Node c = head;//要删除的节点
            Node p = null;//要删除的节点的前一个节点
            //找到节点
            while (c.data != node.data) {
                p = c;
                c = c.next;
            }
            p.next = c.next;
        }
        return true;
    }

    public Node getLast() {
        Node temp = head;
        //找到尾节点
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }


    public void reverse() {


    }


    @NonNull
    @Override
    public String toString() {
        Node temp = head;
        StringBuilder builder = new StringBuilder();
        //找到节点
        while (temp.next != null) {
            builder.append(temp.data.toString()).append(",");
            temp = temp.next;
        }

        return builder.append(temp.data).toString();
    }
}
