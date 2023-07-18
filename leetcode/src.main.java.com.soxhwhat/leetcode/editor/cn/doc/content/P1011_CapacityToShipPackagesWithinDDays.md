<p>传送带上的包裹必须在 <code>days</code> 天内从一个港口运送到另一个港口。</p>

<p>传送带上的第 <code>i</code>&nbsp;个包裹的重量为&nbsp;<code>weights[i]</code>。每一天，我们都会按给出重量（<code>weights</code>）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。</p>

<p>返回能在 <code>days</code> 天内将传送带上的所有包裹送达的船的最低运载能力。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>weights = [1,2,3,4,5,6,7,8,9,10], days = 5
<strong>输出：</strong>15
<strong>解释：</strong>
船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
第 1 天：1, 2, 3, 4, 5
第 2 天：6, 7
第 3 天：8
第 4 天：9
第 5 天：10

请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。 
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>weights = [3,2,2,4,1,4], days = 3
<strong>输出：</strong>6
<strong>解释：</strong>
船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
第 1 天：3, 2
第 2 天：2, 4
第 3 天：1, 4
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>weights = [1,2,3,1,1], days = 4
<strong>输出：</strong>3
<strong>解释：</strong>
第 1 天：1
第 2 天：2
第 3 天：3
第 4 天：1, 1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= days &lt;= weights.length &lt;= 5 * 10<sup>4</sup></code></li> 
 <li><code>1 &lt;= weights[i] &lt;= 500</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 二分查找</details><br>

<div>👍 551, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 即将涨价！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=capacity-to-ship-packages-within-d-days" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 360 页。

正如 [二分搜索思路运用篇](https://labuladong.github.io/article/fname.html?fname=二分运用) 所说，二分搜索的套路比较固定，如果遇到一个算法问题，能够确定 `x, f(x), target` 分别是什么，并写出单调函数 `f` 的代码，那么就可以运用二分搜索的思路求解。

船的运载能力就是自变量 `x`，运输天数和运载能力成反比，所以可以定义 `f(x)` 表示 `x` 的运载能力下需要的运输天数，`target` 显然就是运输天数 `D`，我们要在 `f(x) == D` 的约束下，算出船的最小载重 `x`。

![](https://labuladong.github.io/pictures/二分运用/5.jpeg)

关于本题二分搜索的具体思路见详细题解。

**详细题解：[二分搜索怎么用？我又总结了套路](https://labuladong.github.io/article/fname.html?fname=二分运用)**

**标签：[二分搜索](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
public:
    int shipWithinDays(vector<int>& weights, int days) {
        int left = 0;
        int right = 1;
        for (int w : weights) {
            left = max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(weights, mid) <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // 定义：当运载能力为 x 时，需要 f(x) 天运完所有货物
    // f(x) 随着 x 的增加单调递减
    int f(vector<int>& weights, int x) {
        int days = 0;
        for (int i = 0; i < weights.size(); ) {
            // 尽可能多装货物
            int cap = x;
            while (i < weights.size()) {
                if (cap < weights[i]) break;
                else cap -= weights[i];
                i++;
            }
            days++;
        }
        return days;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        left = max(weights)
        right = sum(weights)

        while left < right:
            mid = (left + right) // 2
            if self.f(weights, mid) <= days:
                right = mid
            else:
                left = mid + 1

        return left

    # 定义：当运载能力为 x 时，需要 f(x) 天运完所有货物
    # f(x) 随着 x 的增加单调递减
    def f(self, weights, x):
        days = 0
        i = 0
        while i < len(weights):
            # 尽可能多装货物
            cap = x
            while i < len(weights):
                if cap < weights[i]:
                    break
                else:
                    cap -= weights[i]
                    i += 1
            days += 1
        return days
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 1;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(weights, mid) <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // 定义：当运载能力为 x 时，需要 f(x) 天运完所有货物
    // f(x) 随着 x 的增加单调递减
    int f(int[] weights, int x) {
        int days = 0;
        for (int i = 0; i < weights.length; ) {
            // 尽可能多装货物
            int cap = x;
            while (i < weights.length) {
                if (cap < weights[i]) break;
                else cap -= weights[i];
                i++;
            }
            days++;
        }
        return days;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func shipWithinDays(weights []int, days int) int {
    left := 0
    right := 1
    for _, w := range weights {
        left = max(left, w)
        right += w
    }

    for left < right {
        mid := left + (right-left)/2
        if f(weights, mid) <= days {
            right = mid
        } else {
            left = mid + 1
        }
    }

    return left
}

// 定义：当运载能力为 x 时，需要 f(x) 天运完所有货物
// f(x) 随着 x 的增加单调递减
func f(weights []int, x int) int {
    days := 0
    for i := 0; i < len(weights); {
        // 尽可能多装货物
        cap := x
        for i < len(weights) {
            if cap < weights[i] {
                break
            } else {
                cap -= weights[i]
                i++
            }
        }
        days++
    }
    return days
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var shipWithinDays = function(weights, days) {
    let left = 0;
    let right = 1;
    for (let w of weights) {
        left = Math.max(left, w);
        right += w;
    }

    while (left < right) {
        let mid = left + Math.floor((right - left) / 2);
        if (f(weights, mid) <= days) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }

    return left;
};

// 定义：当运载能力为 x 时，需要 f(x) 天运完所有货物
// f(x) 随着 x 的增加单调递减
function f(weights, x) {
    let days = 0;
    for (let i = 0; i < weights.length; ) {
        // 尽可能多装货物
        let cap = x;
        while (i < weights.length) {
            if (cap < weights[i]) break;
            else cap -= weights[i];
            i++;
        }
        days++;
    }
    return days;
}
```

</div></div>
</div></div>

<details open><summary><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_capacity-to-ship-packages-within-d-days" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_capacity-to-ship-packages-within-d-days"></div></div>
</details><hr /><br />

**类似题目**：
  - [410. 分割数组的最大值 🔴](/problems/split-array-largest-sum)
  - [875. 爱吃香蕉的珂珂 🟠](/problems/koko-eating-bananas)
  - [剑指 Offer II 073. 狒狒吃香蕉 🟠](/problems/nZZqjQ)

</details>
</div>



