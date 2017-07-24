package solutions

import "fmt"

/**
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
Note:
The input string length won't exceed 1000.
 */

func CountSubStrings(s string) int  {
	return countSubstrings(s)
}
func countSubstrings(s string) int {
	resultCount := 0
	if (len(s) < 2){
		return len(s)
	}
	maxLeft := 0
	maxRight := len(s)-1
	for index := 0; index < maxRight; index++ {
		  leftIndex ,rightIndex := 0,0
		  if (s[index] == s[index+1]){
			  leftIndex,rightIndex = index,index+1

			  for (leftIndex >= maxLeft && rightIndex <= maxRight){
				  if (s[leftIndex] == s[rightIndex]){
					  fmt.Println(s[leftIndex:rightIndex+1])
					  leftIndex--
					  rightIndex++
					  resultCount++
				  }else{
					  break
				  }
			  }
		  }
		  leftIndex,rightIndex = index,index
		  for (leftIndex >= maxLeft && rightIndex <= maxRight){
			  if (s[leftIndex] == s[rightIndex]){
				  fmt.Println(s[leftIndex:rightIndex+1])
				  leftIndex--
				  rightIndex++
				  resultCount++
			  }else{
				  break
			  }
		  }
	}
	return resultCount + 1
}

func extendCheck2(s string, leftIndex int,rightIndex int) (int,int){

	return leftIndex,rightIndex
}