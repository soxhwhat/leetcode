<p>给你单链表的头结点 <code>head</code> ，请你找出并返回链表的中间结点。</p>

<p>如果有两个中间结点，则返回第二个中间结点。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/23/lc-midlist1.jpg" style="width: 544px; height: 65px;" /> 
<pre>
<strong>输入：</strong>head = [1,2,3,4,5]
<strong>输出：</strong>[3,4,5]
<strong>解释：</strong>链表只有一个中间结点，值为 3 。
</pre>

<p><strong class="example">示例 2：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/23/lc-midlist2.jpg" style="width: 664px; height: 65px;" /> 
<pre>
<strong>输入：</strong>head = [1,2,3,4,5,6]
<strong>输出：</strong>[4,5,6]
<strong>解释：</strong>该链表有两个中间结点，值分别为 3 和 4 ，返回第二个结点。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>链表的结点数范围是 <code>[1, 100]</code></li> 
 <li><code>1 &lt;= Node.val &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>链表 | 双指针</details><br>

<div>👍 909, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 即将涨价！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=middle-of-the-linked-list" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[链表双指针技巧全面汇总](https://www.bilibili.com/video/BV1q94y1X7vy)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 64 页。

如果想一次遍历就得到中间节点，也需要耍点小聪明，使用「快慢指针」的技巧：

我们让两个指针 `slow` 和 `fast` 分别指向链表头结点 `head`。

**每当慢指针 `slow` 前进一步，快指针 `fast` 就前进两步，这样，当 `fast` 走到链表末尾时，`slow` 就指向了链表中点**。

**详细题解：[双指针技巧秒杀七道链表题目](https://labuladong.github.io/article/fname.html?fname=链表技巧)**

**标签：[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)，[链表](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)，[链表双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

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
    ListNode* middleNode(ListNode* head) {
        // 快慢指针初始化指向 head
        ListNode* slow = head;
        ListNode* fast = head;
        // 快指针走到末尾时停止
        while (fast != nullptr && fast->next != nullptr) {
            // 慢指针走一步，快指针走两步
            slow = slow->next;
            fast = fast->next->next;
        }
        // 慢指针指向中点
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
    def middleNode(self, head: ListNode) -> ListNode:
        # 快慢指针初始化指向 head
        slow = fast = head
        # 快指针走到末尾时停止
        while fast and fast.next:
            # 慢指针走一步，快指针走两步
            slow = slow.next
            fast = fast.next.next
        # 慢指针指向中点
        return slow
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
        }
        // 慢指针指向中点
        return slow;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func middleNode(head *ListNode) *ListNode {
    // 快慢指针初始化指向 head
    slow, fast := head, head
    // 快指针走到末尾时停止
    for fast != nil && fast.Next != nil {
        // 慢指针走一步，快指针走两步
        slow = slow.Next
        fast = fast.Next.Next
    }
    // 慢指针指向中点
    return slow
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var middleNode = function(head) {
  // 快慢指针初始化指向 head
  let slow = head, fast = head;
  // 快指针走到末尾时停止
  while (fast != null && fast.next != null) {
    // 慢指针走一步，快指针走两步
    slow = slow.next;
    fast = fast.next.next;
  }
  // 慢指针指向中点
  return slow;
};
```

</div></div>
</div></div>

<details open><summary><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_middle-of-the-linked-list" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_middle-of-the-linked-list"></div></div>
</details><hr /><br />

**类似题目**：
  - [141. 环形链表 🟢](/problems/linked-list-cycle)
  - [142. 环形链表 II 🟠](/problems/linked-list-cycle-ii)
  - [160. 相交链表 🟢](/problems/intersection-of-two-linked-lists)
  - [19. 删除链表的倒数第 N 个结点 🟠](/problems/remove-nth-node-from-end-of-list)
  - [21. 合并两个有序链表 🟢](/problems/merge-two-sorted-lists)
  - [23. 合并K个升序链表 🔴](/problems/merge-k-sorted-lists)
  - [86. 分隔链表 🟠](/problems/partition-list)
  - [剑指 Offer 22. 链表中倒数第k个节点 🟢](/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof)
  - [剑指 Offer 25. 合并两个排序的链表 🟢](/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof)
  - [剑指 Offer 52. 两个链表的第一个公共节点 🟢](/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof)
  - [剑指 Offer II 021. 删除链表的倒数第 n 个结点 🟠](/problems/SLwz0R)
  - [剑指 Offer II 022. 链表中环的入口节点 🟠](/problems/c32eOV)
  - [剑指 Offer II 023. 两个链表的第一个重合节点 🟢](/problems/3u1WK4)
  - [剑指 Offer II 078. 合并排序链表 🔴](/problems/vvXgSW)

</details>
</div>



