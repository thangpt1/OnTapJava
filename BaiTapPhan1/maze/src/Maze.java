import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Maze {
    public static void main(String[] args) {
        //
        JFrame frame = new JFrame();
        frame.setSize(650, 470);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MazePanel mp = new MazePanel();
        frame.add(mp);
        frame.setVisible(true);
    }

    public static class MazePanel extends JPanel {
        private static final long serialVersionUID = -566807999447681130L;
        private int[][] maze = { // khởi tạo ma trận mảng 2 chiều
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        private int sizeh, sizew, start, end;

        public MazePanel() {
            // Kích thước ma trận
            sizeh = 21;
            sizew = 31;
            start = 10;
            end = 0;
            solve();
            repaint(); // vẽ ma trận và lời giải
        }

        /**
         * Implement một phương pháp tìm đường nào đó.
         * <p>
         * Yêu cầu : Vẽ đường đi từ điểm bắt đầu đến điểm kết thúc. Không hiện
         * các phần thừa - là các phần đường cụt hoặc đường đi bị sai. Chỉ vẽ
         * tuyến đường chính đi từ điểm đầu (màu vàng) đến màu đỏ.
         * <p>
         * Đường đi từ điểm đầu đến điểm cuối được tô màu xanh dương, để tô màu
         * xanh dương hãy set giá trị của điểm trên ma trận sang một số > 2
         */
        public void solve() {
            // Hàm này chứa phương pháp tìm đường từ điểm start đến vị
            // trí màu đỏ trên ma trận

            // toạ độ điểm bắt đầu,kế thúc
            Point pointStar = new Point(start, end);
            Map<Point, Point> mapPoint = new LinkedHashMap<>();

            //Mp luu dinh con , dinh cha
            // khởi tạo hàng đợi
            Stack<Point> stack = new Stack<>();
            // thêm điển bắt đầu vao stank
            Queue<Point> queue=new LinkedList<>();

//            stack.push(pointStar);
            queue.add(pointStar);

            maze[pointStar.getX()][pointStar.getY()] = 2;

//            while (!stack.isEmpty()) {
            Point point;
            while ((point=queue.poll())!=null){
//                Point point = stack.pop();
                int[] dlk = dinhLienKe(point.getX(), point.getY());

                while (dlk != null) {
                    Point p = new Point(dlk[0], dlk[1]);

                    maze[dlk[0]][dlk[1]] = 1;
//                    stack.push(p);
                    queue.add(p);

                    mapPoint.put(p, point);
                    maze[p.getX()][p.getY()] = 3;

                    dlk = dinhLienKe(point.getX(), point.getY());
                }
            }

            Point pointEnd = new Point(10, 15);
//            while (true) {
//                for (Map.Entry<Point, Point> m : mapPoint.entrySet()) {
//                    Point p = m.getKey();
//                    if (p.getX() == pointEnd.getX() && p.getY() == pointEnd.getY()) {
//                        pointEnd = m.getValue();
//                        maze[p.getX()][p.getY()] = 0;
//                        break;
//                    }
//                }
//                mapPoint.get(pointEnd);
//                if (pointEnd.getX() == 10 && pointEnd.getY() == 1) {
//                    maze[pointEnd.getX()][pointEnd.getY()] = 0;
//                    break;
//                }
//
//            }
            maze[pointEnd.getX()][pointEnd.getY()] = 2;
            while (true){
                pointEnd=mapPoint.get(pointEnd);
                maze[pointEnd.getX()][pointEnd.getY()] = 0;
                if (pointEnd.getX() == 10 && pointEnd.getY() == 1) {

                    break;
                }
            }

        }

        public int[] dinhLienKe(int x, int y) {
            int[] d = {x, y};
            if (y - 1 >= 0 && maze[x][y - 1] == 0) {
                d[0] = x;
                d[1] = y - 1;
                return d;
            } else if (x - 1 >= 0 && maze[x - 1][y] == 0) {
                d[0] = x - 1;
                d[1] = y;
                return d;
            } else if (x + 1 < 21 && maze[x + 1][y] == 0) {
                d[0] = x + 1;
                d[1] = y;
                return d;
            } else if (y + 1 < 31 && maze[x][y + 1] == 0) {
                d[0] = x;
                d[1] = y + 1;
                return d;
            }

            return null;
        }

        public void paintComponent(Graphics g) // vẽ ma trận + lời giải
        {
            super.paintComponent(g);
            for (int j = 0; j < sizew; j++)
                for (int i = 0; i < sizeh; i++) {
                    if (i == start && j == end)
                        g.setColor(Color.yellow);
                    else if (maze[i][j] == 0)
                        g.setColor(Color.blue);
                    else if (maze[i][j] == 1)
                        g.setColor(Color.black);
                    else if (maze[i][j]==2)
                        g.setColor(Color.red);
                    else if (maze[i][j] == 3)
                        g.setColor(Color.white);
                    // blue là màu của lời giải
                    g.fillRect(j * 20, i * 20, 20, 20);
                }
        }
    }
}
