package solutions

import ()

func MinSubArrayLen(s int, nums []int) int {
	if len(nums) < 1 {
		return 0
	}

	temp := nums[0]
	smallLength := len(nums) + 1
	for back, front := 0, 0; back < len(nums) && front < len(nums); {
		if smallLength > front-back+1 && temp >= s {
			smallLength = front - back + 1
		}
		if temp < s {
			front++
			if front < len(nums) {
				temp += nums[front]
			}
		} else {
			temp -= nums[back]
			back++
		}
	}
	if smallLength == len(nums) {
		return 0
	} else {
		return smallLength
	}

}
