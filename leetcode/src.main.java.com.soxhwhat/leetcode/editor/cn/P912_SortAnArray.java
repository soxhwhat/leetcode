//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
//
// Related Topics数组 | 分治 | 桶排序 | 计数排序 | 基数排序 | 排序 | 堆（优先队列） | 归并排序 
//
// 👍 867, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

import java.util.Random;

/**
 * 排序数组
 * @author Soxhwhat
 * @date 2023-07-28 16:20:18
 */
public class P912_SortAnArray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P912_SortAnArray().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
		shuffle(nums);
		int l = 0, r = nums.length - 1;
		sort(nums, l, r);
		return nums;

    }
	void sort(int[] nums, int l, int r) {
		if (l < r) {

			int p = partition(nums, l, r);
			sort(nums, l, p - 1);
			sort(nums, p + 1, r);
		}
	}

	// 洗牌算法，将输入的数组随机打乱
	private void shuffle(int[] nums) {
		Random rand = new Random();
		int n = nums.length;
		for (int i = 0 ; i < n; i++) {
			// 生成 [i, n - 1] 的随机数
			int r = i + rand.nextInt(n - i);
			swap(nums, i, r);
		}
	}

	public int partition(int[] nums, int i, int j) {
		int pivot = nums[i];
		int l = i + 1, r = j;

		while (l <= r) {
			while (l < j && nums[l] <= pivot) l ++;
			while (r > i && nums[r] > pivot) r --;
			if (l >= r) break;
			swap(nums, l, r);
		}
		swap(nums, i, r);
		return r;
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
