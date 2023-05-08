<p>在一个无限的 x 坐标轴上，有许多水果分布在其中某些位置。给你一个二维整数数组 <code>fruits</code> ，其中 <code>fruits[i] = [position<sub>i</sub>, amount<sub>i</sub>]</code> 表示共有 <code>amount<sub>i</sub></code> 个水果放置在 <code>position<sub>i</sub></code> 上。<code>fruits</code> 已经按 <code>position<sub>i</sub></code> <strong>升序排列</strong> ，每个 <code>position<sub>i</sub></code> <strong>互不相同</strong> 。</p>

<p>另给你两个整数 <code>startPos</code> 和 <code>k</code> 。最初，你位于 <code>startPos</code> 。从任何位置，你可以选择 <strong>向左或者向右</strong> 走。在 x 轴上每移动 <strong>一个单位</strong> ，就记作 <strong>一步</strong> 。你总共可以走 <strong>最多</strong> <code>k</code> 步。你每达到一个位置，都会摘掉全部的水果，水果也将从该位置消失（不会再生）。</p>

<p>返回你可以摘到水果的 <strong>最大总数</strong> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/11/21/1.png" style="width: 472px; height: 115px;"> <pre><strong>输入：</strong>fruits = [[2,8],[6,3],[8,6]], startPos = 5, k = 4
<strong>输出：</strong>9
<strong>解释：</strong>
最佳路线为：
- 向右移动到位置 6 ，摘到 3 个水果
- 向右移动到位置 8 ，摘到 6 个水果
移动 3 步，共摘到 3 + 6 = 9 个水果
</pre> </img>

<p><strong>示例 2：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/11/21/2.png" style="width: 512px; height: 129px;"> <pre><strong>输入：</strong>fruits = [[0,9],[4,1],[5,7],[6,2],[7,4],[10,9]], startPos = 5, k = 4
<strong>输出：</strong>14
<strong>解释：</strong>
可以移动最多 k = 4 步，所以无法到达位置 0 和位置 10 。
最佳路线为：
- 在初始位置 5 ，摘到 7 个水果
- 向左移动到位置 4 ，摘到 1 个水果
- 向右移动到位置 6 ，摘到 2 个水果
- 向右移动到位置 7 ，摘到 4 个水果
移动 1 + 3 = 4 步，共摘到 7 + 1 + 2 + 4 = 14 个水果
</pre> </img>

<p><strong>示例 3：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/11/21/3.png" style="width: 476px; height: 100px;"> <pre><strong>输入：</strong>fruits = [[0,3],[6,4],[8,5]], startPos = 3, k = 2
<strong>输出：</strong>0
<strong>解释：</strong>
最多可以移动 k = 2 步，无法到达任一有水果的地方
</pre> </img>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= fruits.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>fruits[i].length == 2</code></li> 
 <li><code>0 &lt;= startPos, position<sub>i</sub> &lt;= 2 * 10<sup>5</sup></code></li> 
 <li>对于任意 <code>i &gt; 0</code> ，<code>position<sub>i-1</sub> &lt; position<sub>i</sub></code> 均成立（下标从 <strong>0</strong> 开始计数）</li> 
 <li><code>1 &lt;= amount<sub>i</sub> &lt;= 10<sup>4</sup></code></li> 
 <li><code>0 &lt;= k &lt;= 2 * 10<sup>5</sup></code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>前缀和</li><li>滑动窗口</li></div></div><br><div><li>👍 72</li><li>👎 0</li></div>

我们不妨假设移动的位置区间为 [l,r]，开始位置为 startPos，来看看如何算出移动的最小步数。根据 startPos 所处的位置，我们可以分为三种情况：

如果 startPos≤l，那么就是从 startPos 向右移动到 r。移动的最小步数为 r−startPos；
如果 startPos≥r，那么就是从 startPos 向左移动到 l。移动的最小步数为 startPos−l；
如果 l<startPos<r，那么可以从 startPos 向左移动到 l，再向右移动到 r；也可以从 startPos 向右移动到 r，再向左移动到 l。移动的最小步数为 r−l+min(∣startPos−l∣,∣r−startPos∣)。
以上三种情况可以统一用式子 r−l+min(∣startPos−l∣,∣r−startPos∣) 表示。

假设我们固定区间右端点 r，向右移动左端点 l，我们来看看最小移动步数是怎么变化的。

如果 startPos≤l，随着 l 的增大，最小步数不会发生变化。
如果 startPos>l，随着 l 的增大，最小步数会减小。
因此，随着 l 的增大，最小移动步数一定是非严格单调递减的。基于此，我们可以使用双指针的方法，找出所有符合条件的最大区间，然后取所有符合条件的区间中水果总数最大的一个作为答案。

具体地，我们用两个指针 i 和 j 分别指向区间的左右下标，初始时 i=j=0。另外用一个变量 s 记录区间内的水果总数，初始时 s=0。

每次我们将 j 加入区间中，然后更新 s=s+fruits[j][1]。如果此时区间内的最小步数 fruits[j][0]−fruits[i][0]+min(∣startPos−fruits[i][0]∣,∣startPos−fruits[j][0]∣) 大于 k，那么我们就将 i 循环向右移动，直到 i>j 或者区间内的最小步数小于等于 k。此时我们更新答案 ans=max(ans,s)。继续移动 j，直到 j 到达数组末尾。