package stack;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class StackMain {

    public static void main(String[] args) {

        System.out.println("스택 시작~");
        Stack<Integer> stackInteger = new Stack<>();

        stackInteger.push(1);
        stackInteger.push(2);
        stackInteger.push(3);
        stackInteger.push(4);

        while (!stackInteger.empty()) {
            System.out.println(stackInteger.pop());
        }

        System.out.println("큐 시작~");
        Queue<Integer> queueInteger = new LinkedList<>();

        queueInteger.add(1); // 만약 데이터를 추가하는데 배열이 꽉찬 상태면 예외를 던짐
        queueInteger.offer(2); // 만약 데이터를 추가하는데 배열이 꽉찬 상태면 false를 리턴함
        queueInteger.offer(3);
        queueInteger.offer(4);

//        queueInteger.remove(); // 제거할 때 큐가 비어있으면 예외가 발생함
//        queueInteger.poll(); // 제가할 때 큐가 비어있으면 null을 반환

        while (!queueInteger.isEmpty()) {
            System.out.println(queueInteger.poll());
        }

    }

}
