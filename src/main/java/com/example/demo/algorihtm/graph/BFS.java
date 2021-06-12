package com.example.demo.algorihtm.graph;

import java.util.*;

/**
 * BFS (Breadth First Search)
 * - 넓이 우선 탐색
 * - Queue 자료구조를 이용
 * - 각 간선의 비용이 동일한 상황에서 최단거리 문제로 사용
 */
public class BFS {

    // 방문 리스트
    public static boolean[] visited;

    // graph
    public static ArrayList<ArrayList<Integer>> graph =
            new ArrayList<ArrayList<Integer>>();


    // 그래프
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nms  = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = nms[0]; // 노드의 갯수
        int m = nms[0]; // 간선의 갯수
        int s = nms[0]; // 시작노드

        // 데이터 초기화
        visited = new boolean[n+1];
        /**
         * input
         * graph = [
         *  [],
         *  [2, 3, 8],
         *  [1, 7],
         *  [1, 4, 5],
         *  [3, 5],
         *  [3, 4],
         *  [7],
         *  [2, 6, 8],
         *  [1, 7]
         * ]
         */
        for (int i = 1; i <= n+1; i++) {
            int[] nodeVals = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j=0; j<nodeVals.length; j++) {
                graph.get(i).add(nodeVals[j]);
            }
        }

        execute_BFS(graph, s);
    }

    // bfs 수행
    private static void execute_BFS(ArrayList<ArrayList<Integer>> graph, int node) {

        Queue<Integer> q = new LinkedList<>();
        // 첫번째 노드를 큐에넣고 방문처리한다.
        q.offer(node);
        visited[node] = true;

        // 큐가 빌 떄까지 반복하면서 원소를 뽑음
        while (!q.isEmpty()) {
            // 1. 큐에 있는 원소를 꺼낸다.
            int x = q.poll();
            // 2. 큐에서 꺼낸 원소의 인접리스트를 차례대로 방문처리 됐는지 확인한다.
            for (int i=0; i<graph.get(x).size(); i++) {
                int val = graph.get(x).get(i);

                // 3. 방문처리 안된것만 큐에 넣고 방문처리한다.
                if (!visited[val]) {
                    q.offer(val);
                    visited[val]  = true;
                }
            }
        }
        Queue<Integer> q2 = new LinkedList<>();
        q2.offer(node);
        visited[node] = true;

        while (!q2.isEmpty()) {
            int x = q2.poll();
            for (int i=0; i<graph.get(x).size(); i++) {
                int val = graph.get(x).get(i);

                if (!visited[val]) {
                    q.offer(val);
                    visited[val] = true;
                }
            }
        }
    }
}
