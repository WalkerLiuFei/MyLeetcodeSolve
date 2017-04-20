package main

import "fmt"

func main(){
	nums := []int{1,1,1,2,2,3}

	fmt.Println(nums[0:removeDuplicates(nums)])
}
func removeDuplicates(nums []int) int {
	flag := make(map[int]int, 1)
	if (len(nums) < 1){
		return 0
	}
	back,front := 0,0;
	for  front < len(nums) {
		num := nums[front];
		if (flag[num] < 2) {
			nums[back] = num;
			flag[num] = flag[num] + 1
			back++;
		}
		front++;
	}
	return back;
}