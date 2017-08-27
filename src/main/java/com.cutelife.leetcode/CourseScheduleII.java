package com.cutelife.leetcode;

import java.util.*;

/**
 * Created by andyzju on 2017/7/19.
 */
public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // 初始化空间
        List<Set> posts = new ArrayList<Set>();
        for(int i = 0; i < numCourses; i++){
            posts.add(new HashSet<Integer>());
        }

        for(int i=0;i<prerequisites.length; i++){
            posts.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // 计算入度
        int indegre[] = new int[numCourses];
        for(int i=0; i<numCourses; i++){

            Set set = posts.get(i);
            Iterator<Integer> it = set.iterator();
            while(it.hasNext()){
                indegre[it.next()] ++;
            }
        }

        int result[] = new int[numCourses];
        int num = 0;
        // 开始计算入度为0 的节点，并将其减1
        for(int i = 0;i<numCourses;i++) {
            int j = 0;
            for (; j < numCourses; j++) {
                if (indegre[j] == 0) {
                    result[num++] = j;
                    indegre[j] = -1;

                    Set<Integer> fin = posts.get(j);
                    Iterator<Integer> it = fin.iterator();
                    while (it.hasNext()) {
                        indegre[it.next()]--;
                    }
                    break;
                }

            }
            if (j == numCourses) {
                return new int[0];
            }
        }
        for(int i =0; i<result.length; i++){
            System.out.println(result[i]);
        }
        return result;

    }


    public static void  main(String args[]){

        int a[][] = new int[2][2];


        a[0][0] = 1;
        a[0][1] = 0;
        a[1][0] = 0;
        a[1][1] = 1;
//        a[2][0] = 3;
//        a[2][1] = 1;
//        a[3][0] = 3;
//        a[3][1] = 2;


        System.out.println(new CourseScheduleII().findOrder(2, a));
    }
}

