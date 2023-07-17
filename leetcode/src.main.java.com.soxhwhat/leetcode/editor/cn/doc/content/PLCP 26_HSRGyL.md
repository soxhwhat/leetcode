小扣参加的秋日市集景区共有 $N$ 个景点，景点编号为 $1$~$N$。景点内设有 $N-1$ 条双向道路，使所有景点形成了一个二叉树结构，根结点记为 `root`，景点编号即为节点值。

由于秋日市集景区的结构特殊，游客很容易迷路，主办方决定在景区的若干个景点设置导航装置，按照所在景点编号升序排列后定义装置编号为 1 ~ M。导航装置向游客发送数据，数据内容为列表 `[游客与装置 1 的相对距离,游客与装置 2 的相对距离,...,游客与装置 M 的相对距离]`。由于游客根据导航装置发送的信息来确认位置，因此主办方需保证游客在每个景点接收的数据信息皆不相同。请返回主办方最少需要设置多少个导航装置。

**示例 1：**

> 输入：`root = [1,2,null,3,4]`
>
> 输出：`2`
>
> 解释：在景点 1、3 或景点 1、4 或景点 3、4 设置导航装置。
>
> ![image.png](https://pic.leetcode-cn.com/1597996812-tqrgwu-image.png){:height="250px"}

**示例 2：**

> 输入：`root = [1,2,3,4]`
>
> 输出：`1`
>
> 解释：在景点 3、4 设置导航装置皆可。
>
> ![image.png](https://pic.leetcode-cn.com/1597996826-EUQRyz-image.png){:height="200px"}

**提示：**
- `2 <= N <= 50000`
- 二叉树的非空节点值为 `1~N` 的一个排列。

<details><summary><strong>Related Topics</strong></summary>树 | 动态规划 | 二叉树</details><br>

<div>👍 18, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 即将涨价！**

</div>



