package easy;

/**
 * @Description: If there are n buckets and a pig drinking poison will die within m minutes,
 * how many pigs (x) you need to figure out the "poison" bucket within p minutes?
 * There is exact one bucket with poison.
 * @Author: Zhang shaoyang
 * @CreateDate: 2019/1/8 0008 23:03
 */
public class PoorPigs

        /**
         * 1. 一只猪在一次可以测试几只桶子？  答：2个（喝一个，看中毒不中毒）
         * 2. 两只猪在一次可以测试几只桶子？  答：4个（0,0）（1,0）（0,1）（1,1）
         * 3. 那么三只猪呢？               答：8个（2的猪的个数次幂）
         * 4. 一只猪在两次可以测试几只桶子？  答：3个（第一次喝一个，第二次喝一个）
         * 5. 两只猪在两次可以测试几只桶子？  答：9个（1,2,3
         *                                     4,5,6
         *                                     7,8,9）
         * 第一只猪第一次喝1,2,3，第二次喝4,5,6，第二只猪第一次喝1,4,7，第二次喝2,5,8
         * 可以知道可以测试的桶子的个数是（测试次数+1）的猪的个数次幂
         * @param buckets 有多少个桶子
         * @param minutesToDie 喝一口桶里的水到中毒的时间
         * @param minutesToTest 总共测试时间
         * @return
         */
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        while (Math.pow(minutesToTest / minutesToDie + 1, pigs) < buckets) {
            pigs++;
        }
        return pigs;
    }
}
