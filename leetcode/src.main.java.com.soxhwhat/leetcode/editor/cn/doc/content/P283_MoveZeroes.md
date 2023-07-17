<p>给定一个数组 <code>nums</code>，编写一个函数将所有 <code>0</code> 移动到数组的末尾，同时保持非零元素的相对顺序。</p>

<p><strong>请注意</strong>&nbsp;，必须在不复制数组的情况下原地对数组进行操作。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> nums = <span><code>[0,1,0,3,12]</code></span>
<strong>输出:</strong> <span><code>[1,3,12,0,0]</code></span>
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> nums = <span><code>[0]</code></span>
<strong>输出:</strong> <span><code>[0]</code></span></pre>

<p>&nbsp;</p>

<p><strong>提示</strong>:</p> 
<meta charset="UTF-8" />

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>-2<sup>31</sup>&nbsp;&lt;= nums[i] &lt;= 2<sup>31</sup>&nbsp;- 1</code></li> 
</ul>

<p>&nbsp;</p>

<p><b>进阶：</b>你能尽量减少完成的操作次数吗？</p>

<details><summary><strong>Related Topics</strong></summary>数组 | 双指针</details><br>

<div>👍 2063, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 即将涨价！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=move-zeroes" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[数组双指针技巧汇总](https://www.bilibili.com/video/BV1iG411W7Wm)

可以直接复用 [27. 移除元素](/problems/remove-element) 的解法，先移除所有 0，然后把最后的元素都置为 0，就相当于移动 0 的效果。

**详细题解：[双指针技巧秒杀七道数组题目](https://labuladong.github.io/article/fname.html?fname=双指针技巧)**

**标签：[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)，[数组双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        // 去除 nums 中的所有 0
        // 返回去除 0 之后的数组长度
        int p = removeElement(nums, 0);
        // 将 p 之后的所有元素赋值为 0
        for (; p < nums.size(); p++) {
            nums[p] = 0;
        }
    }

    // 双指针技巧，复用 [27. 移除元素] 的解法。
    int removeElement(vector<int>& nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.size()) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # 去除 nums 中的所有 0
        # 返回去除 0 之后的数组长度
        p = self.removeElement(nums, 0)
        # 将 p 之后的所有元素赋值为 0
        for i in range(p, len(nums)):
            nums[i] = 0
            
    # 双指针技巧，复用 [27. 移除元素] 的解法。
    def removeElement(self, nums: List[int], val: int) -> int:
        fast = 0
        slow = 0
        while fast < len(nums):
            if nums[fast] != val:
                nums[slow] = nums[fast]
                slow += 1
            fast += 1
        return slow
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public void moveZeroes(int[] nums) {
        // 去除 nums 中的所有 0
        // 返回去除 0 之后的数组长度
        int p = removeElement(nums, 0);
        // 将 p 之后的所有元素赋值为 0
        for (; p < nums.length; p++) {
            nums[p] = 0;
        }
    }

    // 双指针技巧，复用 [27. 移除元素] 的解法。
    int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func moveZeroes(nums []int) {
    // 去除 nums 中的所有 0
    // 返回去除 0 之后的数组长度
    p := removeElement(nums, 0)
    // 将 p 之后的所有元素赋值为 0
    for ; p < len(nums); p++ {
        nums[p] = 0
    }
}

// 双指针技巧，复用 [27. 移除元素] 的解法。
func removeElement(nums []int, val int) int {
    fast := 0
    slow := 0
    for fast < len(nums) {
        if nums[fast] != val {
            nums[slow] = nums[fast]
            slow++
        }
        fast++
    }
    return slow
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var moveZeroes = function(nums) {
    // 去除 nums 中的所有 0
    // 返回去除 0 之后的数组长度
    var p = removeElement(nums, 0);
    // 将 p 之后的所有元素赋值为 0
    for (; p < nums.length; p++) {
        nums[p] = 0;
    }
};

// 双指针技巧，复用 [27. 移除元素] 的解法。
var removeElement = function(nums, val) {
    var fast = 0, slow = 0;
    while (fast < nums.length) {
        if (nums[fast] !== val) {
            nums[slow] = nums[fast];
            slow++;
        }
        fast++;
    }
    return slow;
};
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_move-zeroes" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_move-zeroes"></div></div>
</details><hr /><br />

**类似题目**：
  - [167. 两数之和 II - 输入有序数组 🟠](/problems/two-sum-ii-input-array-is-sorted)
  - [26. 删除有序数组中的重复项 🟢](/problems/remove-duplicates-from-sorted-array)
  - [27. 移除元素 🟢](/problems/remove-element)
  - [344. 反转字符串 🟢](/problems/reverse-string)
  - [5. 最长回文子串 🟠](/problems/longest-palindromic-substring)
  - [83. 删除排序链表中的重复元素 🟢](/problems/remove-duplicates-from-sorted-list)
  - [剑指 Offer 57. 和为s的两个数字 🟢](/problems/he-wei-sde-liang-ge-shu-zi-lcof)
  - [剑指 Offer II 006. 排序数组中两个数字之和 🟢](/problems/kLl5u1)

</details>
</div>



