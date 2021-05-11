package com.ballot.rigging.controller;

import com.ballot.rigging.pojo.Automaton;
import com.ballot.rigging.pojo.ListNode;
import com.ballot.rigging.pojo.ListNode2;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author: wkd
 */
@RestController
public class LongestPalindrome {

    /**
     * 两数之和 一次遍历map解法
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            int cha = target - nums[i];
            if (map.containsKey(cha)) {
                return new int[]{map.get(cha), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * 两数相加
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode(0);
        ListNode ler1 = l1, ler2 = l2, pointer = headNode;
        //进位
        int carry = 0;
        while (ler1 != null || ler2 != null) {
            int x = ler1 != null ? ler1.val : 0;
            int y = ler2 != null ? ler2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            pointer.next = new ListNode(sum % 10);
            pointer = pointer.next;

            if (ler1 != null) {
                ler1 = ler1.next;
            }
            if (ler2 != null) {
                ler2 = ler2.next;
            }
        }

        if (carry > 0) {
            pointer.next = new ListNode(carry);
        }
        return headNode.next;
    }

    /**
     * 无重复字符的最长子串  滑动窗口
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            //charArray也可以换成在这里使用 s.charAt(end)
            char ch = charArray[end];
            if (map.containsKey(ch)) {
                start = Math.max(map.get(ch), start);
            }
            max = Math.max(max, end - start + 1);
            // end+1 是发现重复后要减去的长度
            map.put(ch, end + 1);
        }
        return max;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int allLength = nums1.length + nums2.length;
        if (allLength % 2 == 1) {
            //奇数
            return findMinNumber(nums1, nums2, allLength / 2 + 1);
        } else {
            //偶数
            return (findMinNumber(nums1, nums2, allLength / 2) + findMinNumber(nums1, nums2, allLength / 2 + 1)) / 2.0;
        }
    }

    public double findMinNumber(int[] nums1, int[] nums2, int key) {
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            if (length1 <= index1) {
                return nums2[index2 + key - 1];
            }
            if (length2 <= index2) {
                return nums1[index1 + key - 1];
            }
            if (key == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            int point = key / 2;
            int newIndex1 = Math.min(index1 + point, length1) - 1;
            int newIndex2 = Math.min(index2 + point, length2) - 1;
            if (nums1[newIndex1] >= nums2[newIndex2]) {
                key = key - (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
            if (nums1[newIndex1] < nums2[newIndex2]) {
                key = key - (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }
        }
    }

    /**
     * 动态规划法 最长回文子串
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] booleans = new boolean[length][length];
        String result = "";
        for (int line = 0; line < length; ++line) {
            for (int row = 0; row + line < length; ++row) {
                int area = row + line;
                boolean boo = s.charAt(row) == s.charAt(area);
                if (line == 0) {
                    booleans[row][area] = true;
                } else if (line == 1) {
                    booleans[row][area] = boo;
                } else {
                    booleans[row][area] = (boo && booleans[row + 1][area - 1]);
                }
                if (booleans[row][area] && line + 1 > result.length()) {
                    result = s.substring(row, row + line + 1);
                }
            }
        }
        return result;
    }

    /**
     * 中心拓展算法 最长回文子串
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int length = s.length();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            int palindromeSize1 = expandAroundCenter(s, i, i);
            int palindromeSize2 = expandAroundCenter(s, i, i + 1);
            int max = Math.max(palindromeSize1, palindromeSize2);
            if (end - start < max) {
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left > 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * z字变形
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

    /**
     * z字变形 根据规律得出计算公式
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder ret = new StringBuilder();
        int length = s.length();
        int offset = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            //j 是偏移量
            for (int j = 0; j + i < length; j += offset) {
                ret.append(s.charAt(j + i));
                //i 不能是第一行  也不能是最后一行  长度不能超过字符串长度
                if (i != 0 && i != numRows - 1 && j + offset - i < length) {
                    ret.append(s.charAt(j + offset - i));
                }
            }
        }
        return ret.toString();
    }

    /**
     * 整数倒序
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            // 7 是 Integer.MAX_VALUE%10 的余数   -8是Integer.MIN_VALUE % 10
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    /**
     * 字符串变形为int
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }

    public int myAtoi2(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        //判断第一个字符是不是 数字/-/+
        if (!Character.isDigit(str.charAt(0)) && str.charAt(0) != '-' && str.charAt(0) != '+') {
            return 0;
        }
        long ans = 0L;
        boolean neg = str.charAt(0) == '-';
        int i = !Character.isDigit(str.charAt(0)) ? 1 : 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            ans = ans * 10 + (str.charAt(i++) - '0');
            if (!neg && ans > Integer.MAX_VALUE) {
                ans = Integer.MAX_VALUE;
                break;
            }
            // ans 没有符号 int的最小值为-2147483648
            // int 的最大值为2147483647
            if (neg && ans > 1L + Integer.MAX_VALUE) {
                ans = 1L + Integer.MAX_VALUE;
                break;
            }
        }
        return neg ? (int) -ans : (int) ans;
    }

    /**
     * 判断一个数字是不是回文数 字符串法
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        String reversed = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversed);
    }

    /**
     * 判断一个数字是不是回文数 数字对半分开法
     *
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] booleans = new boolean[m + 1][n + 1];
        booleans[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    booleans[i][j] = booleans[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        booleans[i][j] = booleans[i][j] || booleans[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        booleans[i][j] = booleans[i - 1][j - 1];
                    }
                }
            }
        }
        return booleans[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1;
        int max = 0;
        while (start < end) {
            int sum = Math.min(height[start], height[end]) * (end - start);
            max = Math.max(max,sum);
            if (height[start] > height[end]) {
                end--;
            } else {
                start++;
            }
        }
        return max;
    }

    /**
     * 数字转罗马字符
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        int[] baseNumber = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strings = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < baseNumber.length && num >= 0; i++) {
            while (baseNumber[i] <= num) {
                num -= baseNumber[i];
                stringBuilder.append(strings[i]);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 罗马字符转数字
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int num = 0;
        int pre = getValue(chars[0]);
        for (int i = 1; i < s.length(); i++) {
            int a = getValue(chars[i]);
            if (a > pre) {
                num -= pre;
            } else {
                num += pre;
            }
            pre = a;
        }
        num += pre;
        return num;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    /**
     * 最长公共前缀
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        if (strs == null || strs.length <= 0) {
            return "";
        }

        for (String s : strs) {
            minLength = Math.min(s.length(), minLength);
        }
        StringBuilder stringBuilder = new StringBuilder();
        one:
        for (int i = 0; i < minLength; i++) {
            char ch = strs[0].charAt(i);
            for (String str : strs) {
                if (ch != str.charAt(i)) {
                    break one;
                }
            }
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        /* * 思路：
         * 1. 采用两两比较的方式，首先拿第一个字符串做“基准”，然后逐个与后面的字符串进行比较；
         * 2. 每次在比较的过程中，如果返回 -1，则说明需要将“基准”的最后一个字符删除；
         * 3. 通过不断的删除，那么该“基准”就会逐渐的变成要返回的最长公共前缀。
         */
        //首先拿出第一个字符串作为基准，然后逐个与后面的字符串进行比较
        String res = strs[0];
        for (String str : strs) {
            //如果不为0，说明res不在str这个字符串当中
            while (str.indexOf(res) != 0) {
                //通过删除一个字符，来不断地更新res
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);
        for (int first = 0; first < nums.length - 2; first++) {
            if (first == 0 || nums[first] != nums[first - 1]) {
                int third = nums.length - 1;
                for (int second = first + 1; second < nums.length; second++) {
                    if (second == first + 1 || nums[second] != nums[second - 1]) {
                        while (second < third && nums[first] + nums[second] + nums[third] > 0) {
                            third -= 1;
                        }
                        if (second == third) {
                            break;
                        }
                        if (nums[first] + nums[second] + nums[third] == 0) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[first]);
                            list.add(nums[second]);
                            list.add(nums[third]);
                            lists.add(list);
                        }
                    }
                }
            }
        }
        return lists;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int target = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((target = nums[i]) > 0) {
                break;
            }
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] + target < 0) {
                    ++l;
                } else if (nums[l] + nums[r] + target > 0) {
                    --r;
                } else {
                    result.add(Arrays.asList(target, nums[l++], nums[r--]));
                    while (l < r && nums[l] == nums[l - 1]) {
                        ++l;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        --r;
                    }
                }
            }
        }
        return result;

    }

    /**
     * 最接近三数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 100000000;
        int length = nums.length;
        for (int first = 0; first < length; first++) {
            if (first == 0 || nums[first] != nums[first - 1]) {
                int second = first + 1;
                int third = length - 1;
                while (third > second) {
                    int sum = nums[first] + nums[second] + nums[third];
                    int cha = Math.abs(target - sum);
                    if (cha == 0) {
                        return target;
                    }
                    if (cha < Math.abs(target - result)) {
                        result = sum;
                    }
                    if (sum > target) {
                        third--;
                    } else {
                        second++;
                    }
                }
            }
        }
        return result;
    }


    /**
     * 电话号码的字母组合
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap,
                          String digits, int index, StringBuffer stringBuffer) {
        if (index == digits.length()) {
            combinations.add(stringBuffer.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            for (char ch : letters.toCharArray()) {
                stringBuffer.append(ch);
                backtrack(combinations, phoneMap, digits, index + 1, stringBuffer);
                // 递归结束 清除字符 或者回到上一次递归继续下一个字母拼接
                stringBuffer.deleteCharAt(index);
            }
        }
    }


    /**
     * 删除链表的倒数第N个节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode2 removeNthFromEnd(ListNode2 head, int n) {
        ListNode2 dummy = new ListNode2(0);
        dummy.next = head;
        int length = 0;
        ListNode2 first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    public ListNode2 removeNthFromEnd2(ListNode2 head, int n) {
        ListNode2 dummy = new ListNode2(0);
        dummy.next = head;
        ListNode2 first = dummy;
        ListNode2 second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public ListNode2 removeNthFromEnd3(ListNode2 head, int n) {
        ListNode2 dummy = new ListNode2(0, head);
        Deque<ListNode2> stack = new LinkedList<ListNode2>();
        ListNode2 cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode2 prev = stack.peek();
        prev.next = prev.next.next;
        ListNode2 ans = dummy.next;
        return ans;
    }

}
