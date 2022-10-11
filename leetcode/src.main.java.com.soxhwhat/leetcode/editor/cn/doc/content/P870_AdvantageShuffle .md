<p>给定两个大小相等的数组&nbsp;<code>nums1</code>&nbsp;和&nbsp;<code>nums2</code>，<code>nums1</code>&nbsp;相对于 <code>nums2</code> 的<em>优势</em>可以用满足&nbsp;<code>nums1[i] &gt; nums2[i]</code>&nbsp;的索引 <code>i</code>&nbsp;的数目来描述。</p>

<p>返回 <font color="#c7254e" face="Menlo, Monaco, Consolas, Courier New, monospace" size="1"><span style="background-color: rgb(249, 242, 244);">nums1</span></font>&nbsp;的<strong>任意</strong>排列，使其相对于 <code>nums2</code>&nbsp;的优势最大化。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums1 = [2,7,11,15], nums2 = [1,10,4,11]
<strong>输出：</strong>[2,11,7,15]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums1 = [12,24,8,32], nums2 = [13,25,32,11]
<strong>输出：</strong>[24,32,8,12]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums1.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>nums2.length == nums1.length</code></li> 
 <li><code>0 &lt;= nums1[i], nums2[i] &lt;= 10<sup>9</sup></code></li> 
</ul>

<div><div>Related Topics</div><div><li>贪心</li><li>数组</li><li>双指针</li><li>排序</li></div></div><br><div><li>👍 323</li><li>👎 0</li></div>
显然，对于任意一个 t=nums2[i] 而言，我们应当在候选集合中选择比其大的最小数，若不存在这样的数字，则选择候选集合中的最小值。

同时，由于 nums1 相同数会存在多个，我们还要对某个具体数字的可用次数进行记录。

也就是我们总共涉及两类操作：

实时维护一个候选集合，该集合支持高效查询比某个数大的数值操作；
对候选集合中每个数值的可使用次数进行记录，当使用到了候选集合中的某个数后，要对其进行计数减一操作，若计数为 0，则将该数值从候选集合中移除。
计数操作容易想到哈希表，而实时维护候选集合并高效查询可以使用基于红黑树的 TreeSet 数据结构。