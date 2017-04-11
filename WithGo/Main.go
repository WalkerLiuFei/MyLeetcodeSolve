package main

import (
	"fmt"
	"math"
	"./solutions"
	"strings"
)


func main() {
	//fmt.Println(MaxProduct([]int{-5, -2, -4}))
/*	head := &solutions.ListNode{
		Val:0,
		Next:nil,
	}
	list := head
	for index := 1;index < 11;index ++ {
		head.Next = &solutions.ListNode{
			Val:index,
			Next:nil,
		}
		head = head.Next
	}
	solutions.ReorderList(list)*/
	//fmt.Println(solutions.FindMin([]int{3,3,3,3,3,3,1,2}))
	fmt.Println(strings.Compare("","1"))
	fmt.Println(solutions.CompareVersion("0.1","1.0"))
/*	for index := 0;index < 10;index ++ {
		testArray := make([]int,0)
		for index := 0;index < 10;index ++{
			testArray = append(testArray,rand.Intn(100))
		}

		quickSort(testArray,0,len(testArray)-1)
	}*/
//solutions.SingleNumberII([]int{-2,-2,1,1,-3,1,-3,-3,-4,-2})
	//fmt.Println(solutions.FindRepeatedDnaSequences("AAAAAAAAAAA"))

}

func MaxProduct(nums []int) int {
	if len(nums) < 1 {
		return 0
	}
	max := nums[0]
	min := nums[0]
	result := max
	for index := 1; index < len(nums); index++ {
		num := nums[index]
		temp := max
		max = int(math.Max(math.Max(float64(max*num), float64(min*num)), float64(num)))
		min = int(math.Min(math.Min(float64(min*num), float64(temp*num)), float64(num)))
		if max > result {
			result = max
		}
	}
	return result
}

func quickSort(nums []int, low int, high int) []int {
	if low > high || nums == nil || len(nums) <= 1 {
		return nums
	}
	key := nums[0]
	i := low + 1
	j := high
	for (i < j) {
		for ; key > nums[i] && i < j; i++ {
		}
		for ; key < nums[j] && j > i; j-- {
		}
		nums[i], nums[j] = nums[j], nums[i]
		i++
		j--
	}
	fmt.Printf("%d,%d",i,j)
	fmt.Println(nums)
	fmt.Println()
	quickSort(nums[low:j-1],low,j-1)
	quickSort(nums[j+1:high],j+1,high)
	return nil
}
