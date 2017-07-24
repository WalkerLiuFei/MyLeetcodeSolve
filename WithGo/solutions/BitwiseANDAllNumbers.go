package solutions

func RangeBitwiseAnd(m int, n int) int {
	result := 0
	high := uint(31)
	for high >= 0 {
		// 只有两个数 位相同，且都为1 的时候
		if ((m>>high ^ n>>high) == 0) && ((m >> high & 1) == 1) {
			result |= 1 << high
		}
		if high == 0 {
			break
		}
		high--
	}
	return result
}
