package com.cutelife.leetcode;

import java.util.*;

/**
 * Created by andyzju on 2017/7/17.
 * https://leetcode.com/problems/course-schedule/#/description
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

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

        // 开始计算入度为0 的节点，并将其减1
        for(int i = 0;i<numCourses;i++){
            int j  =0;
            for(; j<numCourses;j++){
                if(indegre[j] == 0)
                    break;
            }
            if(j == numCourses )
                return  false;

            indegre[j] = -1;

            Set<Integer> fin = posts.get(j);
            Iterator<Integer> it = fin.iterator();
            while (it.hasNext()){
                indegre[it.next()] --;
            }

        }

        return true;

    }


    public static void  main(String args[]){

        int a[][] = new int[3][2];

        a[0][0] = 1;
        a[0][1] = 0;
        a[1][0] = 2;
        a[1][1] = 1;
        a[2][0] = 2;
        a[2][1] = 0;


        System.out.println(new CourseSchedule().canFinish(3, a));
    }
}
