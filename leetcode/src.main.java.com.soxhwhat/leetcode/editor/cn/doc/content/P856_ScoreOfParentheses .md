<p>给定一个平衡括号字符串&nbsp;<code>S</code>，按下述规则计算该字符串的分数：</p>

<ul> 
 <li><code>()</code> 得 1 分。</li> 
 <li><code>AB</code> 得&nbsp;<code>A + B</code>&nbsp;分，其中 A 和 B 是平衡括号字符串。</li> 
 <li><code>(A)</code> 得&nbsp;<code>2 * A</code>&nbsp;分，其中 A 是平衡括号字符串。</li> 
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入： </strong>"()"
<strong>输出： </strong>1
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入： </strong>"(())"
<strong>输出： </strong>2
</pre>

<p><strong>示例&nbsp;3：</strong></p>

<pre><strong>输入： </strong>"()()"
<strong>输出： </strong>2
</pre>

<p><strong>示例&nbsp;4：</strong></p>

<pre><strong>输入： </strong>"(()(()))"
<strong>输出： </strong>6
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol> 
 <li><code>S</code>&nbsp;是平衡括号字符串，且只含有&nbsp;<code>(</code>&nbsp;和&nbsp;<code>)</code>&nbsp;。</li> 
 <li><code>2 &lt;= S.length &lt;= 50</code></li> 
</ol>

<div><div>Related Topics</div><div><li>栈</li><li>字符串</li></div></div><br><div><li>👍 446</li><li>👎 0</li></div>
方法二：栈
我们把平衡字符串 s 看作是一个空字符串加上 s 本身，并且定义空字符串的分数为 0。使用栈 st 记录平衡字符串的分数，在开始之前要压入分数 0，表示空字符串的分数。

在遍历字符串 s 的过程中：

遇到左括号，那么我们需要计算该左括号内部的子平衡括号字符串 A 的分数，我们也要先压入分数 0，表示 A 前面的空字符串的分数。
遇到右括号，说明该右括号内部的子平衡括号字符串 A 的分数已经计算出来了，我们将它弹出栈，并保存到变量 v 中。如果 v=0，那么说明子平衡括号字符串 A 是空串，(A) 的分数为 1，否则 (A) 的分数为 2v，然后将 (A) 的分数加到栈顶元素上。
遍历结束后，栈顶元素保存的就是 s 的分数。