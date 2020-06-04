package com.company;

import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.util.*;
import java.util.List;

public class TaxiPark<T> implements List<T> {
    private TaxiParkNode<T> head;
    private TaxiParkNode<T> tail;
    private int size;

    TaxiPark(){
        head=null;tail=null;size=0;
    }

    TaxiPark(T c) {
        this();
        add(c);
    }

    TaxiPark(List<T> c) {
        this();
        addAll(c);
    }


    public boolean add(T k){
        size++;
        if (head==null) {
            head=new TaxiParkNode<>(k);
            tail=head;
            return true;
        }
        tail.next = new TaxiParkNode<>(k);
        tail = tail.next;
        return true;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean contains(Object c) {
        TaxiParkNode<T> tmpT = head;
        if (head == null) return false;
        while (tmpT.next!=null) {
            if (tmpT.value.equals(c)) return true;
        }
        return false;
    }

    public Iterator<T> iterator(){
        return new TaxiParkIterator<T>(this.head);
    }

    public Object[] toArray(){
        Object[] arrT = new Object[size];
        int i = 0;
        for (T e:this) arrT[i++]=e;
        return arrT;
    }


    public <E> E[] toArray(E[] arr){
        E[] arrT = (E[])new Object[size];
        int i = 0;
        for (T e:this) arrT[i++]=(E)e;
        return arr;
    }

    public boolean remove(Object o){
        if (head == null) return false;
        if (head==tail && head.value.equals(o)){
            head=null;
            tail=null;
            size--;
            return true;
        }
        if (head.value.equals(o)){
            head = head.next;
            size--;
            return true;
        }
        TaxiParkNode<T> t = head;
        while(t.next !=null){
            if(t.next.value.equals(o)){
                if (tail == t.next){
                    tail = t;
                }
                t.next = t.next.next;
                size--;
                return true;
            }
            t = t.next;
        }
        return false;
    }


    public boolean containsAll(Collection<?> c){
        for (Object o: c)
            if (!contains(o)) return false;
        return true;
    }


    public boolean addAll(int i,Collection<? extends T> c){
        if (i>=size) addAll(c);
        if (i == 0) {
            int k = 0;
            TaxiParkNode<T> newHead = new TaxiParkNode<T>((T)new Object());
            TaxiParkNode<T> newTail = new TaxiParkNode<T>((T)new Object());
            for (T o: c){
                newTail.next = new TaxiParkNode<T>(o);
                newTail = newTail.next;
            }
            newHead = newHead.next;
            newTail.next = head;
            head = newHead;
            return true;
        }
        TaxiParkNode<T> tmpH = head;
        int index = 0;
        while (index < i-1) {
            tmpH = tmpH.next;
            index++;
        }
        for (T o: c){
            TaxiParkNode<T> node = tmpH.next;
            tmpH.next = new TaxiParkNode<T>(o);
            tmpH.next.next = node;
            tmpH = tmpH.next;
        }
        return true;
    }


    public boolean addAll(Collection<? extends T> c){
        for (Object o: c)
            add((T)o);
        return false;
    }

    public boolean removeAll(Collection<?> c){
        for (Object o: c) remove(o);
        return true;
    }


    public boolean retainAll(Collection<?> c){
        Object[] arr = toArray();
        for (Object o: arr){
            if (!c.contains(o)) remove(o);
        }
        return true;
    }


    public void clear(){
        head = null;
        tail = head;
        size = 0;
    }


    public T get(int i){
        if (i>=size) throw new IndexOutOfBoundsException();
        TaxiParkNode<T> tmpH = head;
        while (i-->0) tmpH = tmpH.next;
        return tmpH.value;
    }

    public T set(int i, T e){
        if (i>=size) throw new IndexOutOfBoundsException();
        TaxiParkNode<T> tmpH = head;
        while (i-->0) tmpH = tmpH.next;
        tmpH.value = e;
        return tmpH.value;
    }

    public void add(int i, T c){
        if (i >=size){
            tail.next = new TaxiParkNode<T>(c);
            tail.next = tail;
            size++;
            return;
        }
        if (i==0){
            TaxiParkNode<T> tmpN = new TaxiParkNode<T>(c);
            tmpN.next = head;
            head = tmpN;
            size++;
            return;
        }
        TaxiParkNode<T> tmpH = head;
        while (i-->1) tmpH = tmpH.next;
        TaxiParkNode<T> tmpN = tmpH.next;
        tmpH.next = new TaxiParkNode<T>(c);
        tmpH.next.next = tmpN;
        size++;
        return;
    }

    public T remove(int i){
        if (i==0){
            T n = head.value;
            head = head.next;
            size--;
            return n;
        }
        if (i==size-1){
            T n = tail.value;
            tail = head;
            while (tail.next!=null) tail = tail.next;
            size--;
            return n;
        }
        TaxiParkNode<T> tmpH = head;
        while (i-->1) tmpH = tmpH.next;
        T n = tmpH.next.value;
        tmpH.next = tmpH.next.next;
        size--;
        return n;
    }


    public int indexOf(Object o){
        int i =0;
        for (T c: this)
            if (c.equals(o)) return i;
            else i++;
        return -1;
    }


    public int lastIndexOf(Object o){
        int i = 0;
        int p = -1;
        for (T c: this)
            if (c.equals(o)) p=i++;
            else i++;
        return p;
    }

    public ListIterator<T> listIterator(){
        return new TaxiParkListIterator<T>(head);
    }


    public ListIterator<T> listIterator(int i){
        return null;
    }


    public List<T> subList(int fromIndex, int toIndex) {
        TaxiPark<T> list = new TaxiPark<T>();
        T[] arrT = (T[])toArray();
        for (int i=fromIndex;i<=toIndex;i++) list.add(arrT[i]);
        return list;
    }

    public List<T> toList() {
        return Arrays.asList((T[])toArray());
    }

    public int getCost(){
        int cost=0;
        for (T v : this){
            cost+=((Vehicle)v).getPrice();

        }
        return cost;
    }

    public void sort(Comparator<? super T> c){
        List<T> arr= toList();
        arr.sort(c);
        this.clear();
        this.addAll(arr);
    }


    public Vehicle getVehicleBySpeedRange(int from, int to){
        for(T o: this) {
            if (((Vehicle)o).getSpeed() >= from && ((Vehicle)o).getSpeed() <= to) return (Vehicle)o;
        }
        return null;
    }

    @Override
    public String toString(){
        String s = "";
        for(T o: this) {
        s += o.toString()+"\n";
        }
        return s;
    }
}
