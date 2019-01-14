package easy;

import java.util.Arrays;

/**
 * @Description:
 *  
 * @Author:         Zhang shaoyang
 * @CreateDate:     2019/1/7 0007 21:15
 */
public class AssignCookies {
    public int findContentChildren(int []g, int []s){
        Arrays.sort(g);
        Arrays.sort(s);
        int gIndex = 0;
        int sIndex = 0;
        while(gIndex<g.length&& sIndex<s.length){
            if(g[gIndex] <= s[sIndex++]){
                gIndex++;
            }
        }
        return gIndex;
    }
}
