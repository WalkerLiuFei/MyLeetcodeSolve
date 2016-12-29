package main

import "fmt"

func main() {
	fmt.Println(longestPalindrome("aasssdsadadjashsdgfahjksbb"))
}
func longestPalindrome(s string) string {
	if len(s) < 2 {
		return s
	}
	maxLeft, maxRight := 0, 0
	for index := 0; index < len(s) - 1; index++ {
		left1, right1 := extendCheck(s, index, index)
		if maxRight - maxLeft < right1 - left1 {
			maxLeft = left1
			maxRight = right1
		}
		//如果相邻的两个元素符合条件，去check它
		if s[index] == s[index + 1] {
			left2, right2 := extendCheck(s, index, index + 1)
			if maxRight - maxLeft < right2 - left2 {
				maxLeft = left2
				maxRight = right2
			}
		}
	}
	return s[maxLeft:maxRight + 1]
}
//用一个（两个圆心扩算的原理，类似于double pointer .....）
func extendCheck(s string, index1 int, index2 int) (left int, right int) {
	for index1 > 0 && index2 < len(s) - 1 && s[index2] == s[index1] {
		index1--
		index2++
	}
	if (index1 < 0 || index2 > len(s) - 1 || s[index2] != s[index1]){
		index1++
		index2--
	}
	return index1, index2;
}