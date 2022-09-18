<p>给你一个大小为 <code>n x n</code> 二进制矩阵 <code>grid</code> 。<strong>最多</strong> 只能将一格&nbsp;<code>0</code> 变成&nbsp;<code>1</code> 。</p>

<p>返回执行此操作后，<code>grid</code> 中最大的岛屿面积是多少？</p>

<p><strong>岛屿</strong> 由一组上、下、左、右四个方向相连的&nbsp;<code>1</code> 形成。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入: </strong>grid = [[1, 0], [0, 1]]
<strong>输出:</strong> 3
<strong>解释:</strong> 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入: </strong>grid =<strong> </strong>[[1, 1], [1, 0]]
<strong>输出:</strong> 4
<strong>解释:</strong> 将一格0变成1，岛屿的面积扩大为 4。</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入: </strong>grid = [[1, 1], [1, 1]]
<strong>输出:</strong> 4
<strong>解释:</strong> 没有0可以让我们变成1，面积依然为 4。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>n == grid.length</code></li> 
 <li><code>n == grid[i].length</code></li> 
 <li><code>1 &lt;= n &lt;= 500</code></li> 
 <li><code>grid[i][j]</code> 为 <code>0</code> 或 <code>1</code></li> 
</ul>

<div><div>Related Topics</div><div><li>深度优先搜索</li><li>广度优先搜索</li><li>并查集</li><li>数组</li><li>矩阵</li></div></div><br><div><li>👍 278</li><li>👎 0</li></div>

### 并查集  + 枚举
1. 常规模板：二维扫描，坐标转换，并查集
2. 做法：
    1. 首先初始化，将每个位置的并查集初始化，结果数组为1
    2. 二维扫描各个位置，将连通块的并查集和结果循环出来
    3. 最终将为0的位置，将相邻位置的连通块和结果插入map（此处无需考虑是否已经连通，直接放入并查集即可）
    4. 遍历key，得到值
    5. 循环获得最终结果。