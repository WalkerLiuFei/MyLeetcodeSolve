package solutions

/**
1. key 正确位置右侧元素 大于 k-1, 那么第K大的数还是 key 位置的右侧.查询key右侧，保持k 的值
2. key 正确位置右侧元素小于 k-1，那么第k大的数在Key位置的左侧，查询key的左侧，k =  k - （key右侧元素数量）
3. key 正确位置右侧元素等于 k-1，那么第k大的数就是key！
*/
func FindKthLargest(nums []int, k int) int {
	if len(nums) == 0 {
		return 0
	}
	if len(nums) == 1 {
		return nums[0]
	}
	key := nums[len(nums)-1]
	low := 0
	high := len(nums) - 2
	for high > low {
		for low < high && nums[low] <= key {
			low++
		}
		for low < high && nums[high] >= key {
			high--
		}
		nums[low], nums[high] = nums[high], nums[low]
	}
	// 比较之后，low的位置即为 key的位置
	if nums[low] >= key {
		nums[low], nums[len(nums)-1] = nums[len(nums)-1], nums[low]
	} else {
		low++
	}
	// low 位置 右侧 的元素数量
	rightElementNums := len(nums) - low - 1
	if rightElementNums == k-1 {
		return key
	} else if rightElementNums > k-1 {
		return FindKthLargest(nums[low+1:], k)
	} else {
		return FindKthLargest(nums[:low], k-rightElementNums-1)
	}
}
