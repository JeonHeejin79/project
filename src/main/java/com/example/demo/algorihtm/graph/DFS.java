package com.example.demo.algorihtm.graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * DFS (Depth First Search)
 * - 깊이 우선 탐색
 * - STACK 을 이용 or 재귀 함수 이용
 */

public class DFS {

    static int[][] graphMap;

    static boolean[] visited;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] nms  = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = nms[0]; // 노드의 갯수
        int m = nms[0]; // 간선의 갯수
        int s = nms[0]; // 시작노드

        //데이터 초기화
        graphMap = new int[n+1][n+1];
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
        for (int i = 1; i <= n; i++) {
            // Min + (int)(Math.random() * ((Max - Min) + 1))
            // int randomVal = 1 + ((int)Math.random() * (8));
            int[] nodeVals = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // i 노드에 nodeVals 간선노드 저장
            for (int j=0; j < nodeVals.length; j++) {
                graphMap[i][j] = nodeVals[j];
            }
        }

        execute_DFS(graphMap, s);

    }

    // dfs 수행
    public static void execute_DFS(int[][] graphMap, int node) {
        // 방문처리
        visited[node] = true;

        // 1. 그래프의 특정 노드 영역 탐색후 -> graphMap[node] or graphList.get(node)
        // 2. 방문하지 않은 노드가 있으면 dfs 시작
        for (int i=0; i<graphMap[node].length; i++) {
            int curVal = graphMap[node][i];
            // 탐색한 노드가 방문처리 안되어있을 경우만
            if (!visited[curVal]) {
                // 재귀로 다시 dfs 수행
                execute_DFS(graphMap, curVal);
            }
        }
    }
}
