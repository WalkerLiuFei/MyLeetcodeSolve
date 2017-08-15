package solutions

import "strconv"

func DecodeWays(s string)  int{
	return decodeWays(s)
}
func decodeWays(s string)int{
	if (len(s) < 1){
		return 0
	}
	dp := make([]int,len(s))
	if (s[0] > '0' && s[0] < '9'){
		dp[0] = 1
	}else {
		return 0
	}
	index := 1
	for index < len(s){
		if (s[index] == '0'){
			strconvNum,_ := strconv.Atoi(s[index-1:index + 1])
			recover()
			if (strconvNum > 26 || strconvNum <= 0){
				return 0
			}else{
				if (index - 2 >= 0){
					dp[index] = dp[index - 2]
				}else {
					dp[index] = 1
				}
			}
		}else {
			if (s[index - 1] == '0'){
				dp[index] = dp[index - 1]
				index ++
				continue
			}
			strconvNum,_ := strconv.Atoi(s[index-1:index+1])
			recover()
			if (strconvNum <= 26 && strconvNum > 0){
				if (index - 2 >= 0){
					dp[index] = dp[index - 2] + 2
				}else {
					dp[index] = dp[index - 1] + 1
				}

			}else {
				dp[index] = dp[index - 1]
			}
		}
		index ++
	}
	return dp[len(s) - 1]
}