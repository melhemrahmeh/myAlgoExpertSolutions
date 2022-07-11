package Stacks_Queues;

import java.util.*;
 public class MinMaxStack {
     List<Integer> integerStack = new ArrayList<>();
     List<Integer[]> list = new ArrayList<>();

     public int peek() {
         return integerStack.get(integerStack.size()-1);
     }
     public int pop() {
         int toRemove =  integerStack.remove(integerStack.size()-1);
         list.remove(list.size()-1);
         return toRemove;
     }

        public void push(Integer number) {
            if (list.isEmpty()){
                list.add(new Integer[]{number , number});
            }
            else {
                list.add(new Integer[]{Math.min(getMin() , number) , Math.max(getMax() , number)});
            }
            integerStack.add(number);
        }

        public int getMin() {
            return list.get(list.size()-1)[0];
        }

        public int getMax() {
            return list.get(list.size()-1)[1];
        }
    }
