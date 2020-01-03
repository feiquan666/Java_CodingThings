package mianshiti;


import java.math.BigDecimal;
import java.util.*;

public class MyMinimumRoute {
    private static List<Pointer> pointers = new ArrayList<>();// 存储所有点
    private static List<BigDecimal> routes = new ArrayList<>();// 存储一次问题中的较小的可到达路径的权密度值
    private static List<Integer> points = new ArrayList<>();// 已经走过的点

    public static void main(String[] args) {
        getInput();
    }

    private static void getInput() {
        Scanner scanner = new Scanner(System.in);
        int points = scanner.nextInt();
        pointers.add(new Pointer(-1));
        for (int i = 1; i <= points; i++) {
            pointers.add(new Pointer(i));
        }
        int edges = scanner.nextInt();
        String edge;
        scanner.useDelimiter("\n");
        for (int i = 0; i < edges; i++) {
            edge = scanner.next();
            createEdge(edge);
        }
        int asks = scanner.nextInt();
        String problem;
        for(int i = 0; i < asks; i++){
            problem = scanner.next();
            routes = new ArrayList<>();
            MyMinimumRoute.points = new ArrayList<>();
            System.out.println(answer(problem));
        }
    }

    private static String answer(String problem) {
        String[] names = problem.split(" ");
        int startName = Integer.valueOf(names[0]);// 起点名称
        Pointer pointer = pointers.get(startName);// 获取起点
        int endName = Integer.valueOf(names[1]);// 终点名称
        Map<Pointer,Integer> nextList = pointer.getNextList();
        points.add(startName);
        return findMinRoute(1,0,endName,nextList);
    }

    private static String findMinRoute(int edges,int length,int endName,Map<Pointer,Integer> nextList){
        for (Pointer point : nextList.keySet()){
            if(hadPoint(point.getName())){ // 如果是已经经过的点，则跳过
                continue;
            }
            if(point.getName() == endName){ // 是终点
                // 计算路径权密度并加入权密度数组中
                int finalLength = 0;
                try {
                     finalLength = length + nextList.get(point);
                }catch (Exception e){
                    System.out.println(nextList);
                    finalLength = length + nextList.get(point);
                    System.out.println(point);
                }
                calculateWeight(finalLength,edges);
                continue;
            }
            edges++;
            try {
                length += nextList.get(point);
            }catch (Exception e){
//                System.out.println("nextList"+nextList);
//                System.out.println("point"+point);
            }
            nextList = point.getNextList();
            points.add(point.getName());// 加入已走过的点
            findMinRoute(edges,length,endName,nextList);
        }
        if(routes.size() == 0){
            return "NO";
        }
        return routes.get(0).toString();
    }

    private static void createEdge(String info) {
        String[] numbers = info.split(" ");
        int name = Integer.valueOf(numbers[0]);
        int next = Integer.valueOf(numbers[1]);
        int length = Integer.valueOf(numbers[2]);
        Map<Pointer, Integer> nextList = pointers.get(name).getNextList();// 获取边集合
        nextList.put(pointers.get(next), length);// 添加边信息
        pointers.get(name).setNextList(nextList);//存放边集合
    }

    private static void calculateWeight(int length,int edges){
        double value = (double) length / edges;
        BigDecimal bigDecimal = new BigDecimal(value).setScale(3,BigDecimal.ROUND_HALF_UP);
        if(routes.size() == 0){
            routes.add(bigDecimal);
            return;
        }
    }

    private static boolean hadPoint(int name){
        boolean flag = false;
        for(Integer item : points){
            if(item == name){
                flag = true;
            }
        }
        return flag;
    }
}

class Pointer {
    private int name;// 点的名称：1，2，3....
    private Map<Pointer, Integer> nextList;// 与之相连的点

    public int getName() {
        return name;
    }

    public Pointer(int name) {
        this.nextList = new HashMap<>();
        this.name = name;
    }

    public Map<Pointer, Integer> getNextList() {
        return nextList;
    }

    public void setNextList(Map<Pointer, Integer> nextList) {
        this.nextList = nextList;
    }
}
