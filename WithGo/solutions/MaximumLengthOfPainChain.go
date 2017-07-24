package solutions

import (
	"sort"
)

/**
You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.

Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.

Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.

Example 1:
Input: [[1,2], [2,3], [3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4]
Note:
The number of given pairs will be in the range [1, 1000].
 */
type PairsContainer  [][]int

func (p PairsContainer )Len() int{
	return len(p)
}

func (p PairsContainer)Swap(i,j int) {
	temp := make([]int,2)
	temp[0],temp[1] = p[i][0],p[i][1]
	p[i][0],p[i][1] = p[j][0],p[j][1]
	p[j][0],p[j][1] = temp[0],temp[1]
}
func (p PairsContainer) Less(i,j int)bool{
	return p[i][0] < p[j][0]
}

func FindLongestChain(pairs [][]int) int{
	return findLongestChain(pairs)
}
func findLongestChain(pairs [][]int) int {
	if (len(pairs) <= 1){
		return len(pairs)
	}
	dp := make([]int,len(pairs))
	maxLen := 0
	dp[0] = 1
	pairContainer := PairsContainer(pairs)
	sort.Sort(pairContainer)
	for index := 1;index < len(pairs); index++{
		flag := false
		for lookBackindex := index - 1; lookBackindex >= 0; lookBackindex--{
			if (pairContainer[index][0] > pairContainer[lookBackindex][1]){
				dp[index] = max(dp[lookBackindex] + 1,dp[index])
				maxLen = max(dp[index],maxLen)
				flag = true
			}
		}
		if (!flag){
			dp[index] = 1
		}
	}
	return maxLen
}