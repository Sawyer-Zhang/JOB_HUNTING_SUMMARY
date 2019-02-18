package easy;

/**
 * @Description: 求一个数字的补码的值
 * @Author: Zhang shaoyang
 * @CreateDate: 2019/1/20 0020 11:33
 */
public class NumberComplement {
    public int findComplement(int num) {
        int comparison = (Integer.highestOneBit(num) << 1) - 1;
        num = ~num;
        return comparison & num;
    }
}
