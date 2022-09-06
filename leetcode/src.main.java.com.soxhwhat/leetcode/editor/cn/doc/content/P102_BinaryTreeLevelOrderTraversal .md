<p>给你二叉树的根节点 <code>root</code> ，返回其节点值的 <strong>层序遍历</strong> 。 （即逐层地，从左到右访问所有节点）。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree1.jpg" style="width: 277px; height: 302px;" /> 
<pre>
<strong>输入：</strong>root = [3,9,20,null,null,15,7]
<strong>输出：</strong>[[3],[9,20],[15,7]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>root = [1]
<strong>输出：</strong>[[1]]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>root = []
<strong>输出：</strong>[]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>树中节点数目在范围 <code>[0, 2000]</code> 内</li> 
 <li><code>-1000 &lt;= Node.val &lt;= 1000</code></li> 
</ul>

<div><div>Related Topics</div><div><li>树</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 1449</li><li>👎 0</li></div>

### BFS使用场景
- DFS、BFS在遍历一棵树、一张图上的所有结点的时候，更倾向于更方便写、空间复杂度更低的BFS遍历。
- 只能使用BFS的场景：层序遍历、最短路径。
### 两者区别
- DFS:主要使用递归
```JAVA
void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        dfs(root.right);
        }
```
- BFS：主要借助队列
```java
void bfs(TreeNode root){
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    
    while(!queue.isEmpty()){
        TreeNode node = queue.poll();
        if(node.left != null) queue.add(node.left);
        if(node.right != null) queue.add(node.right);
        }
        }
```
