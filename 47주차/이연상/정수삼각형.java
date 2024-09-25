// [PRG] 정수 삼각형

import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        for(int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i - 1][0];
            triangle[i][triangle[i].length - 1] += triangle[i - 1][triangle[i - 1].length - 1];
            
            for(int j = 1; j < triangle[i].length - 1; j++) {
                triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
            }
        }
        Arrays.sort(triangle[triangle.length - 1]);
        answer = triangle[triangle.length - 1][triangle[triangle.length - 1].length - 1];
        
        return answer;
    }
}