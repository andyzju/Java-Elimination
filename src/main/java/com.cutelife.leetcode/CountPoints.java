package com.cutelife.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}

public class CountPoints {
	public int maxPoints(Point[] points) {
		int maxNum = 0;
		Map<Double, Integer> numMap = new HashMap<Double, Integer>();
		int duplicates = 0;
		for (int i = 0; i < points.length; i++) {
			numMap.clear();
			maxNum=1; // if only one point
			duplicates = 1;
			for (int j = 0; j < points.length; j++) {
				if (j == i) // the same point
					continue;
				if (points[j].x == points[i].x && points[j].y == points[i].y) {
					duplicates++;
					continue;
				}

				double k = (points[i].x == points[j].x) ? Integer.MAX_VALUE
						: (double) (points[j].y - points[i].y)
								/ (points[j].x - points[i].x);

				if (numMap.containsKey(k)) {
					numMap.put(k, numMap.get(k) + 1);
				} else {
					numMap.put(k, 1);
				}

			}

			if(numMap.isEmpty()){
				maxNum = duplicates;
			}else{
				for (double key : numMap.keySet()) {
					if ((numMap.get(key) + duplicates) > maxNum)
						maxNum = (numMap.get(key) + duplicates);
				}
			}
		}
		return maxNum;
	}
	
	public static void main(String args[]){
		Point points[]=new Point[21];
		
		//Point points[]={(0,9),(138,429),(115,359),(115,359),(-30,-102),(230,709),(-150,-686),(-135,-613),(-60,-248),(-161,-481),(207,639),(23,79),(-230,-691),(-115,-341),(92,289),(60,336),(-105,-467),(135,701),(-90,-394),(-184,-551),(150,774)};
		//Point points[]={(0,9)};
		/*for(int i=0;i<50;i++)
		{
			 
			Random ran=new Random();
			points[i]=new Point(ran.nextInt(20),ran.nextInt(20));
			
		}*/
		
		points[0]=new Point(0,9);
		points[1]=new Point(138,429);
		points[2]=new Point(115,359);
		points[3]=new Point(115,359);
		points[4]=new Point(-30,-102);
		points[5]=new Point(230,709);
		points[6]=new Point(-150,-686);
		points[7]=new Point(-135,-613);
		points[8]=new Point(-60,-248);
		points[9]=new Point(-161,-481);
		points[10]=new Point(207,639);
		points[11]=new Point(23,79);
		points[12]=new Point(-230,-691);
		points[13]=new Point(-115,-341);
		points[14]=new Point(92,289);
		points[15]=new Point(60,336);
		points[16]=new Point(-105,-467);
		points[17]=new Point(135,701);
		points[18]=new Point(-90,-394);
		points[19]=new Point(-184,-551);
		points[20]=new Point(150,774);
		
		
		System.out.println(new CountPoints().maxPoints(points));
	}
}
