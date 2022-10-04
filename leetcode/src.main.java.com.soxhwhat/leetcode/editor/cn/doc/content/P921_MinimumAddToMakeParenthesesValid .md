<p>只有满足下面几点之一，括号字符串才是有效的：</p>

<ul> 
 <li>它是一个空字符串，或者</li> 
 <li>它可以被写成&nbsp;<code>AB</code>&nbsp;（<code>A</code>&nbsp;与&nbsp;<code>B</code>&nbsp;连接）, 其中&nbsp;<code>A</code> 和&nbsp;<code>B</code>&nbsp;都是有效字符串，或者</li> 
 <li>它可以被写作&nbsp;<code>(A)</code>，其中&nbsp;<code>A</code>&nbsp;是有效字符串。</li> 
</ul>

<p>给定一个括号字符串 <code>s</code> ，移动N次，你就可以在字符串的任何位置插入一个括号。</p>

<ul> 
 <li>例如，如果 <code>s = "()))"</code> ，你可以插入一个开始括号为 <code>"(()))"</code> 或结束括号为 <code>"())))"</code> 。</li> 
</ul>

<p>返回 <em>为使结果字符串 <code>s</code> 有效而必须添加的最少括号数</em>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "())"
<strong>输出：</strong>1
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "((("
<strong>输出：</strong>3
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 1000</code></li> 
 <li><code>s</code> 只包含&nbsp;<code>'('</code> 和&nbsp;<code>')'</code>&nbsp;字符。</li> 
</ul>

<div><div>Related Topics</div><div><li>栈</li><li>贪心</li><li>字符串</li></div></div><br><div><li>👍 228</li><li>👎 0</li></div>
过程：

网上搜了一下，说是 charAt() 效率高，并且有代码验证。
自己 copy 代码试了一下，发现有时候 charAt 效率高，有时候 toCharArray 效率高。
找了做 c++ 的朋友指点了一下，优化 for 循环中的 length() 方法，charAt 和 toCharArray 的运行效率一下子拉开了差距。
以前知道最好不要在 for 循环条件里面写方法，会影响效率，但是在实际业务代码里因为时间或者代码美观等原因，没有注意这个细节。在毫秒级别的运算，一个小小的细节就会导致结果逆转。
总结：

String 使用 charAt 比使用 toCharArray 遍历，效率要高。
避免在 for 循环中使用 s.length() 方法，可以显著提升效率。
虽然底层都调用了 C 语言的 Native 方法，toCharArray 多了复制数组的一个步骤，所以会慢，因为 String 的数据结构本来也是数组。

https://stackoverflow.com/questions/8894258/fastest-way-to-iterate-over-all-the-chars-in-a-string
StackOverflow