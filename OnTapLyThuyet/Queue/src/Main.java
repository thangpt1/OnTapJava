import Point.Poin;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        Queue<Poin> q = new LinkedList<>();

        // Thêm phần tử vào hàng đợi
        Poin poi1 = new Poin(1, 2);
        Poin poi2 = new Poin(2, 2);
        Poin poi3 = new Poin(3, 2);
        Poin poi4 = new Poin(4, 2);
        Poin poi5 = new Poin(5, 2);
        Poin poi6 = new Poin(6, 2);
        Poin poi7 = new Poin(7, 2);

        System.out.println();
        q.add(poi1);
        q.add(poi2);
        q.add(poi3);
        q.add(poi4);
        q.add(poi5);
        q.add(poi6);
        q.add(poi7);
        q.add(poi4);

        Poin poin;
        while ((poin = q.poll()) != null) {

//            if (poi!=null)
            System.out.println(poin);
//            else
//                break;
        }

    }
}
