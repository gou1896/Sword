/**
 * @Author: lei
 * @Data: 2020.3.31 21:28
 * @Description: 《剑指offer》30.连续子数组的最大和
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class test30 {
	public static void main(String[] args) {
		int [] nums = {6,-3,-2,7,-15,1,2,2};
		System.out.println(FindGreatestSumOfSubArray(nums));
	}
	
	//局部最大解，当前面的数的和为负的时候，不要它们，重新开始。
	public static int FindGreatestSumOfSubArray(int[] array) {
		if(array == null || array.length == 0) return 0;
		int [] dp = new int[array.length]; dp[0] = array[0];
		int max = dp[0];
		for(int i = 1;i < array.length;i++){
			if(dp[i-1] > 0)
				dp[i] = dp[i-1] + array[i];
			else
				dp[i] = array[i];
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}//class end
