<p>给定一个已排序的链表的头
 <meta charset="UTF-8" />&nbsp;<code>head</code>&nbsp;，&nbsp;<em>删除所有重复的元素，使每个元素只出现一次</em>&nbsp;。返回 <em>已排序的链表</em>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/list1.jpg" style="height: 160px; width: 200px;" /> 
<pre>
<strong>输入：</strong>head = [1,1,2]
<strong>输出：</strong>[1,2]
</pre>

<p><strong>示例 2：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/list2.jpg" style="height: 123px; width: 300px;" /> 
<pre>
<strong>输入：</strong>head = [1,1,2,3,3]
<strong>输出：</strong>[1,2,3]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>链表中节点数目在范围 <code>[0, 300]</code> 内</li> 
 <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
 <li>题目数据保证链表已经按升序 <strong>排列</strong></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>链表</details><br>

<div>👍 1013, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 即将涨价！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=remove-duplicates-from-sorted-list" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[数组双指针技巧汇总](https://www.bilibili.com/video/BV1iG411W7Wm)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 371 页。

思路和 [26. 删除有序数组中的重复项](/problems/remove-duplicates-from-sorted-array) 完全一样，唯一的区别是把数组赋值操作变成操作指针而已。

![](https://labuladong.github.io/pictures/数组去重/2.gif)

**详细题解：[双指针技巧秒杀七道数组题目](https://labuladong.github.io/article/fname.html?fname=双指针技巧)**

**标签：[链表](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)，[链表双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

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
    ListNode* deleteDuplicates(ListNode* head) {  // 删除链表中重复的元素
        if (head == NULL) return NULL;  // 如果链表为空，直接返回NULL
        ListNode *slow = head, *fast = head;  // 定义快慢指针，初始都指向头结点
        while (fast != NULL) {  // 只要快指针没有遍历完整个链表
            if (fast->val != slow->val) {  // 快慢指针值不同
                slow->next = fast;  // 慢指针连接新节点
                slow = slow->next;  // 慢指针向后移动一位
            }
            fast = fast->next;  // 快指针向后移动一位
        }
        slow->next = NULL;  // 断开与后面重复元素的连接
        return head;  // 返回头结点
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if head == None:
            return None
        slow = head
        fast = head
        while fast != None:
            if fast.val != slow.val:
                # nums[slow] = nums[fast];
                slow.next = fast
                # slow++;
                slow = slow.next
            # fast++
            fast = fast.next
        # 断开与后面重复元素的连接
        slow.next = None
        return head
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                // nums[slow] = nums[fast];
                slow.next = fast;
                // slow++;
                slow = slow.next;
            }
            // fast++
            fast = fast.next;
        }
        // 断开与后面重复元素的连接
        slow.next = null;
        return head;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func deleteDuplicates(head *ListNode) *ListNode {
    if head == nil {
        return nil
    }

    slow, fast := head, head
    for fast != nil {
        if fast.Val != slow.Val {
            // nums[slow] = nums[fast];
            slow.Next = fast
            // slow++;
            slow = slow.Next
        }
        // fast++
        fast = fast.Next
    }
    // 断开与后面重复元素的连接
    slow.Next = nil
    return head
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicates = function(head) {
  if (head === null) return null;
  var slow = head;
  var fast = head;
  while (fast !== null) {
    if (fast.val !== slow.val) {
      // nums[slow] = nums[fast];
      slow.next = fast;
      // slow++;
      slow = slow.next;
    }
    // fast++
    fast = fast.next;
  }
  // 断开与后面重复元素的连接
  slow.next = null;
  return head;
};
```

</div></div>
</div></div>

<details open><summary><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_remove-duplicates-from-sorted-list" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-duplicates-from-sorted-list"></div></div>
</details><hr /><br />

**类似题目**：
  - [167. 两数之和 II - 输入有序数组 🟠](/problems/two-sum-ii-input-array-is-sorted)
  - [26. 删除有序数组中的重复项 🟢](/problems/remove-duplicates-from-sorted-array)
  - [27. 移除元素 🟢](/problems/remove-element)
  - [283. 移动零 🟢](/problems/move-zeroes)
  - [344. 反转字符串 🟢](/problems/reverse-string)
  - [5. 最长回文子串 🟠](/problems/longest-palindromic-substring)
  - [82. 删除排序链表中的重复元素 II 🟠](/problems/remove-duplicates-from-sorted-list-ii)
  - [剑指 Offer 57. 和为s的两个数字 🟢](/problems/he-wei-sde-liang-ge-shu-zi-lcof)
  - [剑指 Offer II 006. 排序数组中两个数字之和 🟢](/problems/kLl5u1)

</details>
</div>



