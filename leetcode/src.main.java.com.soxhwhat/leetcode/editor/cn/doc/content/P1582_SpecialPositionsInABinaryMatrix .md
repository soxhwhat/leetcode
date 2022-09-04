<p>给你一个大小为 <code>rows x cols</code> 的矩阵 <code>mat</code>，其中 <code>mat[i][j]</code> 是 <code>0</code> 或 <code>1</code>，请返回 <strong>矩阵&nbsp;<em><code>mat</code></em> 中特殊位置的数目</strong> 。</p>

<p><strong>特殊位置</strong> 定义：如果 <code>mat[i][j] == 1</code> 并且第 <code>i</code> 行和第 <code>j</code> 列中的所有其他元素均为 <code>0</code>（行和列的下标均 <strong>从 0 开始</strong> ），则位置 <code>(i, j)</code> 被称为特殊位置。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>mat = [[1,0,0],
&nbsp;           [0,0,<strong>1</strong>],
&nbsp;           [1,0,0]]
<strong>输出：</strong>1
<strong>解释：</strong>(1,2) 是一个特殊位置，因为 mat[1][2] == 1 且所处的行和列上所有其他元素都是 0
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>mat = [[<strong>1</strong>,0,0],
&nbsp;           [0,<strong>1</strong>,0],
&nbsp;           [0,0,<strong>1</strong>]]
<strong>输出：</strong>3
<strong>解释：</strong>(0,0), (1,1) 和 (2,2) 都是特殊位置
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>mat = [[0,0,0,<strong>1</strong>],
&nbsp;           [<strong>1</strong>,0,0,0],
&nbsp;           [0,1,1,0],
&nbsp;           [0,0,0,0]]
<strong>输出：</strong>2
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>mat = [[0,0,0,0,0],
&nbsp;           [<strong>1</strong>,0,0,0,0],
&nbsp;           [0,<strong>1</strong>,0,0,0],
&nbsp;           [0,0,<strong>1</strong>,0,0],
&nbsp;           [0,0,0,1,1]]
<strong>输出：</strong>3
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>rows == mat.length</code></li> 
 <li><code>cols == mat[i].length</code></li> 
 <li><code>1 &lt;= rows, cols &lt;= 100</code></li> 
 <li><code>mat[i][j]</code> 是 <code>0</code> 或 <code>1</code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>矩阵</li></div></div><br><div><li>👍 79</li><li>👎 0</li></div>

### 暴力循环
```aidl
根据题意，使用数组 r 和 c 分别预处理除每行和每列所含 1 的个数，复杂度为 O(m×n)。

随后分别统计特殊位置的个数：满足 mat[i][j]=1 且 r[i]=c[j]=1 的位置。
```
### 优化思路
- 确定上下边界
- 边界内行内求和有单调性，故可以采用双指针或二分
- 快速求区间内算法（前缀和）
1. 双指针做法（确定两个指针是否单调-一个指针随另一个指针单调）
