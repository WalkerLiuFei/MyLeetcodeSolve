package solutions

func Rob(nums []int) int {
	if len(nums) < 1 {
		return 0
	}
	if len(nums) == 1 {
		return nums[0]
	}
	if len(nums) == 2 {
		return max(nums[0], nums[1])
	}
	if len(nums) == 3 {
		return max(nums[0]+nums[2], nums[1])
	}
	dp := make([]int, len(nums))
	dp[0] = nums[0]
	dp[1] = nums[1]
	dp[2] = nums[2] + dp[0]
	for index := 3; index < len(nums); index++ {
		dp[index] = max(dp[index-2]+nums[index], dp[index-3]+nums[index])
	}
	return max(dp[len(nums)-1], dp[len(nums)-2])
}

func max(param1 int, param2 int) int {
	if param1 > param2 {
		return param1
	}
	return param2
}
