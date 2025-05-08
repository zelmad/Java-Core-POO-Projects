package com.zelmad.generics;

import java.util.ArrayList;
import java.util.List;

public class samples {
    public static void main(String[] args) {
        // Without using Generics
        List l = new ArrayList();
        l.add("rest");
        String r = (String) l.get(0);
        System.out.println(r);

        // Using Generics
        List<String> ll = new ArrayList<>();
        ll.add("restRest");
        String rr = ll.get(0);
        System.out.println(rr);

        // Using One Type Parameter
        Box<String> box = new Box<>("box test");
        System.out.println(box.getObj());

        Box<Integer> inetegrBox = new Box<>(1);
        System.out.println(inetegrBox.getObj());

        // Using Multiple Parameters
        Pair<String, Integer> first = new OrderPair<>("test", 1);
        System.out.println("Pair key : " + first.getKey() + " and it's value : " + first.getValue());

        Pair<String, String> second = new OrderPair<>("all", "one");
        System.out.println("Pair key : " + second.getKey() + " and it's value : " + second.getValue());

        Pair<String, Box<String>> boxParam = new OrderPair<>("box key", new Box<>("bow example"));
        System.out.println("Pair key : " + boxParam.getKey() + " With it's value : " + boxParam.getValue().getObj());

        // Test Generic method
        Pair<Integer, String> p1 = new OrderPair<>(1, "test");
        Pair<Integer, String> p2 = new OrderPair<>(1, "tout");
        Util util = new Util();
        boolean result = util.compare(p1, p2);
        System.out.println("Compare result " + result);
    }

    static class Util {
        public <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
            return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
        }
    }

    static class Box<T> {
        private T obj;

        public Box(T obj) {
            this.obj = obj;
        }

        private T getObj() {
            return obj;
        }
    }

    static interface Pair<K, V> {
        public K getKey();

        public V getValue();
    }

    static class OrderPair<K, V> implements Pair<K, V> {
        private K key;
        private V value;

        public OrderPair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }
}
