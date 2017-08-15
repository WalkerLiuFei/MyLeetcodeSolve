package solutions

/**
	解题策略：
	1. 利用贪心算法，将满足条件的两个数据作为pair作为条件push进入队列中
	2. 条件1的选择并不会影响后续的问题的求解
	具体步奏
	1. 选取一个前置节点，根据上次的条件，一次选择后缀节点
	2. 例如： 如果上次的是增量的，就选取一个相对与前缀节点最小的后缀节点，直到找到一个自增次序的两个两点
	3. 反之一致
	例如：
	第一次我们选择1 作为前缀节点,然后依次往后寻找，直到找到4，这个依次自增顺序的最后一个节点.
	同样的,在4 push进入我们的结果队列中，往后选择一个依次递减的最后一个元素0。。。以此类推
	最后的结果自然是
	【1,4,0,4,3,5】 长度为 6
	1,2,3,4,3,0,2,4,3,5
 */

func WiggleMaxLength(nums []int) int{
	return wiggleMaxLength(nums)
}
func wiggleMaxLength(nums []int) int {
	if (len(nums) < 2){
		return len(nums)
	}
	front := 1
	back := 0
	for  front  < len(nums)  && nums[back] == nums[front]{
		front ++
	}
	back = front -1
	if (front == len(nums)){
		return 1
	}

	//negative : 小于，positive : 大于
	var lastSymbol  = nums[front] - nums[back] > 0
	result := 1
	for front < len(nums){
		for front < len(nums){
			if ((lastSymbol && nums[front - 1] > nums[front]) ||
				(!lastSymbol  && nums[front - 1] < nums[front])){
				//自增结束,跳出循环
				back = front - 1
				result ++
				lastSymbol = !lastSymbol
				break
			}
			front++
		}
	}
	return  result + 1
}