package solutions

/**
	思路 一：
	1. 根据题设，如果一个元素的横竖坐标都大于一个元素，那么这个元素肯定要比这个值大，反之亦然
	2. 如果两个值得的横竖坐标其中一个比另一个值大，另一个坐标比它小，那么这个两种元素的大小不确定
	3. 所以2 的问题是解决问题的关键，怎样将值得范围缩小

	思路二:
	[

		 [1,   4,  7, 11, 15],
		 [2,   5,  8, 12, 19],
		[3,   6,  9, 16, 22],
		[10, 13, 14, 17, 24],
		[18, 21, 23, 26, 30]
	]
   1. 上面的 5 x 5 二维坐标，假设我们要找  11 这个元素是否存在
   2. 第一次的二分我们找到 位于 坐标 （2,2）也就是 9 这个元素，显然这个值比 11小，所以 （2,2） 左上角子矩阵都被忽略掉，
   3. 接下来我们只考虑 （2,2）右下，然后再一次二分，我们找到位于 坐标（3,3）的17这个元素，然而这个值比 11要大，所以(3,3)
   	  右下角的子矩阵被忽略
   4. 接下来我们只需要考虑 子矩阵 【（3,0）-（4,2）】and 【(0,3) - (2,4)】 and 【(2,2) - (3,3)】
       中间的这些元素,4 是 矩阵的长度
   5. 利用上面的元素重复1 的操作！
*/
func searchMatrix(matrix [][]int, target int) bool {


	right, down := len(matrix[0]), len(matrix)
	left, up := 0, 0
	if target > matrix[down-1][right-1] ||
		target < matrix[left][up] {
		return false
	}
	for left < right && up > 0{
		if matrix[left][up] == target {
			return true

		}else if (matrix[left][up] > target){
			up--
		}else {
			left++
		}
	}
	return false
}

/**
	if len(matrix) < 1 {
		return false
	}
	//初始化
	right, down := len(matrix[0]), len(matrix)
	left, up := 0, 0
	return searchMatrix2(matrix, target, left, up, right, down, 0)
}

// 0： 还没比较， 1： 比target 要大 ，-1 ：比target要小
func searchMatrix2(matrix [][]int, target int, left int, right int, up int, down int, lastCompare int) bool {
	if (left < 0 || up < 0 || right > len(matrix[0]) || down > len(matrix) )

	if target > matrix[down-1][right-1] ||
		target < matrix[left][up] {
		return false
	}
	// 横坐标，竖坐标
	midRight := (right-left)/2 + left
	midDown := (down-up)/2 + up
	if matrix[midDown][midRight] == target {
		return true
	}

	if matrix[midDown][midRight] < target && (lastCompare == 0 || lastCompare < 0) {
		//向右下角的子矩阵搜索
		return searchMatrix2(matrix, target, left, midRight, up, midDown, -1)
	} else if matrix[midDown][midRight] > target && (lastCompare == 0 || lastCompare > 0) {
		//向左上角的子矩阵搜索
		return searchMatrix2(matrix, target, midRight, right, midDown, down, 1)
	}
    /**
    	如果这次比较的结果是比target要小，但是上次比较的大
    	那么 横竖坐标不能同时！同时 小于 midRight, 和 midDown
    	且都不能同时 大于 right和 down
    	所以 left = midRi
     */

/**if matrix[midDown][midRight] < target && lastCompare > 0{
if (searchMatrix2(matrix,target,midRight + 1,0,right,))
}
if matrix[midDown][midRight] > target && lastCompare < 0 {

}
return false
 */