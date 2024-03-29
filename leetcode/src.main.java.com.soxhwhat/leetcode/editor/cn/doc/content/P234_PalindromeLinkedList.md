<p>给你一个单链表的头节点 <code>head</code> ，请你判断该链表是否为回文链表。如果是，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal1linked-list.jpg" style="width: 422px; height: 62px;" /> 
<pre>
<strong>输入：</strong>head = [1,2,2,1]
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal2linked-list.jpg" style="width: 182px; height: 62px;" /> 
<pre>
<strong>输入：</strong>head = [1,2]
<strong>输出：</strong>false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>链表中节点数目在范围<code>[1, 10<sup>5</sup>]</code> 内</li> 
 <li><code>0 &lt;= Node.val &lt;= 9</code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你能否用&nbsp;<code>O(n)</code> 时间复杂度和 <code>O(1)</code> 空间复杂度解决此题？</p>

<details><summary><strong>Related Topics</strong></summary>栈 | 递归 | 链表 | 双指针</details><br>

<div>👍 1727, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 即将涨价！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=palindrome-linked-list" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 277 页。

这道题的关键在于，单链表无法倒着遍历，无法使用双指针技巧。

那么最简单的办法就是，把原始链表反转存入一条新的链表，然后比较这两条链表是否相同。

更聪明一些的办法是借助双指针算法：

**1、先通过 [双指针技巧](https://labuladong.github.io/article/fname.html?fname=链表技巧) 中的快慢指针来找到链表的中点**：

![](https://labuladong.github.io/pictures/回文链表/1.jpg)

**2、如果 `fast` 指针没有指向 `null`，说明链表长度为奇数，`slow` 还要再前进一步**：

![](https://labuladong.github.io/pictures/回文链表/2.jpg)

**3、从 `slow` 开始反转后面的链表，现在就可以开始比较回文串了**：

![](https://labuladong.github.io/pictures/回文链表/3.jpg)

**详细题解：[如何判断回文链表](https://labuladong.github.io/article/fname.html?fname=判断回文链表)**

**标签：回文问题，[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)，[链表](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)，[链表双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

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
    bool isPalindrome(ListNode* head) {
        ListNode *slow, *fast;   // Define two pointers
        slow = fast = head;      // Initialize the pointers
        while (fast != nullptr && fast->next != nullptr) {  // Loop until fast pointer reaches the end
            slow = slow->next;   // Move slow pointer one step
            fast = fast->next->next;   // Move fast pointer two step
        }

        if (fast != nullptr)    // If fast pointer is not nullptr
            slow = slow->next;  // Move the slow pointer one step

        ListNode *left = head;  // Initialize left pointer to head
        ListNode *right = reverse(slow);   // Reverse the right half of the list and make the right pointer point to the new head
        while (right != nullptr) {        // Loop until right pointer is nullptr
            if (left->val != right->val)  // If the values of left and right pointers are not equal
                return false;            // Return false
            left = left->next;           // Move the left pointer one step
            right = right->next;         // Move the right pointer one step
        }

        return true;   // Return true if all elements in the list are equal to their corresponding elements in the reversed list
    }

    ListNode* reverse(ListNode* head) {
        ListNode *pre = nullptr, *cur = head;   // Define two pointers
        while (cur != nullptr) {   // Loop until the last node of the list is reached
            ListNode *next = cur->next;    // Store the next pointer temporarily
            cur->next = pre;               // Reverse the pointer
            pre = cur;                     // Move the pre pointer one step
            cur = next;                    // Move the cur pointer one step forward
        }
        return pre;            // Return the new head
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        if fast:
            slow = slow.next

        left = head
        right = self.reverse(slow)
        while right:
            if left.val != right.val:
                return False
            left = left.next
            right = right.next
            
        return True
    
    def reverse(self, head: ListNode) -> ListNode:
        pre, cur = None, head
        while cur:
            next_node = cur.next
            cur.next = pre
            pre = cur
            cur = next_node
            
        return pre
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null)
            slow = slow.next;

        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }

    ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func isPalindrome(head *ListNode) bool {
    slow, fast := head, head
    for fast != nil && fast.Next != nil {
        slow = slow.Next
        fast = fast.Next.Next
    }

    if fast != nil {
        slow = slow.Next
    }

    left, right := head, reverse(slow)
    for right != nil {
        if left.Val != right.Val {
            return false
        }
        left = left.Next
        right = right.Next
    }

    return true
}

func reverse(head *ListNode) *ListNode {
    var pre, cur *ListNode
    cur = head
    for cur != nil {
        next := cur.Next
        cur.Next = pre
        pre = cur
        cur = next
    }
    return pre
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var isPalindrome = function(head) {
  let [slow, fast] = [head, head];
  while (fast !== null && fast.next !== null) {
    slow = slow.next;
    fast = fast.next.next;
  }

  if (fast !== null)
    slow = slow.next;

  let left = head;
  let right = reverse(slow);
  while (right !== null) {
    if (left.val !== right.val)
      return false;
    left = left.next;
    right = right.next;
  }

  return true;
};

function reverse(head) {
  let [pre, cur] = [null, head];
  while (cur !== null) {
    let next = cur.next;
    cur.next = pre;
    pre = cur;
    cur = next;
  }
  return pre;
}
```

</div></div>
</div></div>

<details open><summary><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_palindrome-linked-list" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_palindrome-linked-list"></div></div>
</details><hr /><br />

**类似题目**：
  - [剑指 Offer II 027. 回文链表 🟢](/problems/aMhZSa)

</details>
</div>



