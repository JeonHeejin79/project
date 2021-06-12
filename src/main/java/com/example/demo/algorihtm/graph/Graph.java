package com.example.demo.algorihtm.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Graph {

    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //ex )  4 5 1
        String nms = scan.nextLine(); // n : 정점의개수,  m : 간선의갯수 , s : 시작점

        String[] nmsString = nms.split(" ");

        int n = Integer.parseInt(nmsString[0]);
        int m = Integer.parseInt(nmsString[1]);
        int s = Integer.parseInt(nmsString[2]);

        for (int i=0; i<m; i++) { // 간선의 갯수만큼 입력 받아서 graph 에 저장
            String scan2 = scan.nextLine();

            String[] scannerValues = scan2.split(" ");


        }
    }
}
