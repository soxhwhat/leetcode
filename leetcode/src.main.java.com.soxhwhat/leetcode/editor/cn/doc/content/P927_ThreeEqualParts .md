<p>给定一个由 <code>0</code> 和 <code>1</code> 组成的数组
 <meta charset="UTF-8" />&nbsp;<code>arr</code>&nbsp;，将数组分成 &nbsp;<strong>3&nbsp;个非空的部分</strong> ，使得所有这些部分表示相同的二进制值。</p>

<p>如果可以做到，请返回<strong>任何</strong>&nbsp;<code>[i, j]</code>，其中 <code>i+1 &lt; j</code>，这样一来：</p>

<ul> 
 <li><code>arr[0], arr[1], ..., arr[i]</code>&nbsp;为第一部分；</li> 
 <li><code>arr[i + 1], arr[i + 2], ..., arr[j - 1]</code>&nbsp;为第二部分；</li> 
 <li><code>arr[j], arr[j + 1], ..., arr[arr.length - 1]</code>&nbsp;为第三部分。</li> 
 <li>这三个部分所表示的二进制值相等。</li> 
</ul>

<p>如果无法做到，就返回&nbsp;<code>[-1, -1]</code>。</p>

<p>注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，<code>[1,1,0]</code>&nbsp;表示十进制中的&nbsp;<code>6</code>，而不会是&nbsp;<code>3</code>。此外，前导零也是<strong>被允许</strong>的，所以&nbsp;<code>[0,1,1]</code> 和&nbsp;<code>[1,1]</code>&nbsp;表示相同的值。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>arr = [1,0,1,0,1]
<strong>输出：</strong>[0,3]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>arr = [1,1,0,1,1]
<strong>输出：</strong>[-1,-1]</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入：</strong>arr = [1,1,0,0,1]
<strong>输出：</strong>[0,2]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p> 
<meta charset="UTF-8" />

<ul> 
 <li><code>3 &lt;= arr.length &lt;= 3 * 10<sup>4</sup></code></li> 
 <li><code>arr[i]</code>&nbsp;是&nbsp;<code>0</code>&nbsp;或&nbsp;<code>1</code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>数学</li></div></div><br><div><li>👍 129</li><li>👎 0</li></div>
**方法一：计数 + 三指针**
```
我们记数组的长度为 $n$，数组中 $1$ 的数量为 $cnt$。

显然 $cnt$ 必须是 $3$ 的倍数，否则无法将数组三等分，可以提前返回 $[-1, -1]$。如果 $cnt$ 为 $0$，那么意味着数组中所有元素都为 $0$，直接返回 $[0, n - 1]$ 即可。

我们将 $cnt$ 除以 $3$，得到每一份中 $1$ 的数量，然后找到每一份的第一个 $1$ 在数组 `arr` 中的位置（参考以下代码中的 $find(x)$ 函数），分别记为 $i$, $j$, $k$。
```
* bash

```bash
0 1 1 0 0 0 1 1 0 0 0 0 0 1 1 0 0
  ^         ^             ^
  i         j             k
```

接着我们从 $i$, $j$, $k$ 开始往后同时遍历每一部分，判断三部分对应的值是否相等，是则继续遍历，直至 $k$ 到达 $arr$ 末尾。

* bash

```bash
0 1 1 0 0 0 1 1 0 0 0 0 0 1 1 0 0
          ^         ^             ^
          i         j             k
```

遍历结束时，若 $k=n$，说明满足三等分，返回此时的 $[i - 1, j]$ 作为答案，否则返回 $[-1, -1]$。

时间复杂度 $O(n)$，空间复杂度 $O(1)$。其中 $n$ 表示 `arr` 的长度。

* [sol1-Python3]

```python
class Solution:
    def threeEqualParts(self, arr: List[int]) -> List[int]:
        def find(x):
            s = 0
            for i, v in enumerate(arr):
                s += v
                if s == x:
                    return i

        n = len(arr)
        cnt, mod = divmod(sum(arr), 3)
        if mod:
            return [-1, -1]
        if cnt == 0:
            return [0, n - 1]

        i, j, k = find(1), find(cnt + 1), find(cnt * 2 + 1)
        while k < n and arr[i] == arr[j] == arr[k]:
            i, j, k = i + 1, j + 1, k + 1
        return [i - 1, j] if k == n else [-1, -1]
```

* [sol1-Java]

```java
class Solution {
    private int[] arr;

    public int[] threeEqualParts(int[] arr) {
        this.arr = arr;
        int cnt = 0;
        int n = arr.length;
        for (int v : arr) {
            cnt += v;
        }
        if (cnt % 3 != 0) {
            return new int[]{-1, -1};
        }
        if (cnt == 0) {
            return new int[]{0, n - 1};
        }
        cnt /= 3;

        int i = find(1), j = find(cnt + 1), k = find(cnt * 2 + 1);
        for (; k < n && arr[i] == arr[j] && arr[j] == arr[k]; ++i, ++j, ++k) {
        }
        return k == n ? new int[]{i - 1, j} : new int[]{-1, -1};
    }

    private int find(int x) {
        int s = 0;
        for (int i = 0; i < arr.length; ++i) {
            s += arr[i];
            if (s == x) {
                return i;
            }
        }
        return 0;
    }
}
```