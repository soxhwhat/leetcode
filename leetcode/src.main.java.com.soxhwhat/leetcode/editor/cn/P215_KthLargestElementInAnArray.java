//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics数组 | 分治 | 快速选择 | 排序 | 堆（优先队列） 
//
// 👍 2229, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

/**
 * 数组中的第K个最大元素
 * @author Soxhwhat
 * @date 2023-07-28 15:36:31
 */
public class P215_KthLargestElementInAnArray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P215_KthLargestElementInAnArray().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
		int l = 0, r = nums.length - 1;
		k = nums.length - k;

		while (l <= r) {
			int p = partition(nums, l, r);
			if (p < k) {
				l = p + 1;
			} else if (p > k) {
				r = p - 1;
			} else {
				return nums[p];
			}
		}
		return -1;
    }


	void quickSort(int[] nums, int l, int r) {
		if (l >= r) return;

		int p = partition(nums, l, r);

		quickSort(nums, l, p - 1);
		quickSort(nums, p + 1, r);
	}

	int partition(int[] nums, int lo, int hi) {
		int temp = nums[lo];
		int l = lo + 1, r = hi;

		while (l <= r) {
			while (l < hi && nums[l] <= temp) l ++;
			while (r > lo && nums[r] > temp) r --;
			if (l >= r) break;
			swap(nums, l, r);

		}
		swap(nums, lo, r);
		return r;
	}

			// 原地交换数组中的两个元素
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}
