<p>给你一个由小写英文字母组成的字符串 <code>s</code> ，请你找出并返回第一个出现 <strong>两次</strong> 的字母。</p>

<p><strong>注意：</strong></p>

<ul> 
 <li>如果 <code>a</code> 的 <strong>第二次</strong> 出现比 <code>b</code> 的 <strong>第二次</strong> 出现在字符串中的位置更靠前，则认为字母 <code>a</code> 在字母 <code>b</code> 之前出现两次。</li> 
 <li><code>s</code> 包含至少一个出现两次的字母。</li> 
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>s = "abccbaacz"
<strong>输出：</strong>"c"
<strong>解释：</strong>
字母 'a' 在下标 0 、5 和 6 处出现。
字母 'b' 在下标 1 和 4 处出现。
字母 'c' 在下标 2 、3 和 7 处出现。
字母 'z' 在下标 8 处出现。
字母 'c' 是第一个出现两次的字母，因为在所有字母中，'c' 第二次出现的下标是最小的。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>s = "abcdd"
<strong>输出：</strong>"d"
<strong>解释：</strong>
只有字母 'd' 出现两次，所以返回 'd' 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>2 &lt;= s.length &lt;= 100</code></li> 
 <li><code>s</code> 由小写英文字母组成</li> 
 <li><code>s</code> 包含至少一个重复字母</li> 
</ul>

<div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>计数</li></div></div><br><div><li>👍 17</li><li>👎 0</li></div>

### 位运算思想
> 优化空间占用
- 相当于用二进制来存储 a-z, for 循环里面的第二句左移运算就是把字母放到对应的位置。 然后 for 循环第一句就是 右移， 判断当前字母对应的 mask 的位置是否已经存放了 1， 如果存放了， 说明前面出现过了.
    ```
  int a = 5;  // a 的二进制表示为 101
  int b = 7;  // b 的二进制表示为 111
  a |= b;  // 执行 a = a | b
  // a 的值为 7，二进制表示为 111
    ```