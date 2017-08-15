package solutions


/**
  思路：
  1. 开一个stack(直接用slice 模拟),依次遍历 num 字符串，遇到栈顶元素便利到的元素，
  	pop出这个栈顶元素，将遍历到的元素push进stack
  2. 接着step.1,向前遍历栈,一致pop出比对应元素大的栈顶元素,直到遇到了一个小于栈顶的数,遇到了之后,结果站里面的元素就坐牢进入stack，
  	是最后结果之一
  3.
 举例：
  num = "1432219", k = 3
  1. --> 1
  2. --> 14
  3. --> 13  4被pop 出来
  4. --> 12  3被pop 出来
  5. --> 12  2被pop	出来 (只要是不小于，都需要pop出)
  6. --> 121 遇到了1,说明结果已经做牢，另外可以看出已经有三个元素被弹出，所以结果为 1219
  特殊： 0和前面的元素进行结合，一块形成一个元素 x0
 */
func RemoveKdigits(num string, k int) string {
	return removeKdigits(num,k)
}
func removeKdigits(num string, k int) string {
	var result = ""
	if (k >= len(num)){
		return "0"
	}
	if (len(num) < 1){
		return num
	}
	stack := make([]byte,1)
	stack[0] = num[0]
	removedCount := 0
	numIndex := 1
	for ;numIndex < len(num);numIndex++{
		number := byte(num[numIndex] - '0')
		//1.如果栈顶元素元素大于遍历到的元素,pop出栈顶元素（remove 结果加 1）
		for index := len(stack) - 1;index >= 0 &&
			(stack[index] - '0') > number;index --{
			removedCount++
			stack = stack[0:index]
			if (removedCount >= k){
				break
			}
		}
		if (removedCount >= k){
			stack = append(stack,number + '0')
			numIndex ++
			break
		}
		stack = append(stack,number + '0')
	}

	if removedCount >= k{
		result = string(stack) + num[numIndex:]
	} else {
		result = string(stack[: len(stack) - k + removedCount])
	}
	index := 0
	for ;index < len(result) && result[index] == '0';index++{

	}
	if (index == len(result)){
		return "0"
	}
	return result[index:]
}