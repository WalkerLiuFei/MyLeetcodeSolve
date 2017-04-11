package solutions

import (

	"math"
)

func abs(value int) float64 {
	return math.Abs(float64(value))
}
func searchInsert(nums []int, target int) int {
	if len(nums) < 1 || target <= nums[0] {
		return 0
	}
	if target > nums[len(nums)-1] {
		return len(nums)
	}

	minValue := math.MaxInt32
	minIndex := 0
	start := 0
	end := len(nums) - 1
	for start <= end {
		mid := start + (end-start)/2
		midValue := nums[mid]
		if midValue > target { //target is int the middle of start to mid-1
			end = mid - 1
			if abs(target-midValue) < abs(minValue) {
				minValue = target - midValue
				minIndex = mid
			}
		} else if nums[mid] < target { //target is int the middle of start to mid-1
			start = mid + 1
			if abs(target-midValue) < abs(minValue) {
				minValue = target - midValue
				minIndex = mid
			}
		} else {
			return mid
		}
	}
	if minValue > 0 {
		minIndex++
	}
	return minIndex
}
