//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics数组 | 双指针 
//
// 👍 2063, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package leetcode.editor.cn;

/**
 * 移动零
 * @author Soxhwhat
 * @date 2023-07-17 14:03:49
 */
public class P283_MoveZeroes{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P283_MoveZeroes().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
		int slow = remove(nums, 0);
		for (; slow < nums.length; slow ++) {
			nums[slow] = 0;
		}
    }

	private int remove(int[] nums, int i) {
		int slow, fast;
		slow = fast = 0;

		while (fast != nums.length) {
			if (nums[fast] != i) {
				nums[slow] = nums[fast];
				slow ++;
			}
			fast ++;
		}
		return slow;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
