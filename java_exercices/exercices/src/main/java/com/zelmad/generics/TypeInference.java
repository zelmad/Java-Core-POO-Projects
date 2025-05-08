package com.zelmad.generics;

import java.util.ArrayList;
import java.util.List;

public class TypeInference {
    public static void main(String[] args) {
        BoxDemo boxDemo = new BoxDemo();
        List<Box<Integer>> boxes = new ArrayList<>();
        boxDemo.addBox(10, boxes);
        boxDemo.addBox(20, boxes);
        boxDemo.outputBoxes(boxes);
    }

    static class BoxDemo {
        public static <U> void addBox(U u, List<Box<U>> boxes) {
            Box<U> box = new Box<>();
            box.set(u);
            boxes.add(box);
        }

        public static <U> void outputBoxes(List<Box<U>> boxes) {
            int count = 0;
            for(Box<U> box : boxes) {
                System.out.println("box # " + count + " is " + box.get());
                count++;
            }
        }
    }

    static class Box<U> {
        private U u;

        private void set(U u) {
            this.u = u;
        }

        private U get() {
            return this.u;
        }
    }
}