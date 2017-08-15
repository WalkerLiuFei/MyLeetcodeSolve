package solutions


/**
 * solution：
 * 1. 利用一个map key 指的是 字符串的 字符,value 是字符对应的 （index + 1）！
 * front 自增,并查询map 中字符对应的 index 是不是为0.,
   2. 如果为 0 说明这个value 之前还没有重复,
 * 3. 如果map 对过key 找到的 index 不为0。则有重复
   4. 利用index，back ，front 三个 index 指示器： index - back + 1 比较 front - infex + 1.
      那个大说明那个是更长无重复字符串
   5. 接着4, 如果back 设置为 index , front 则接着往前走，重复1 的操作
 */


//key 字符串 s的 字符，value 指的index
func LengthOfLongestSubstring(s string) int {
	return lengthOfLongestSubstring(s)
}
func lengthOfLongestSubstring(s string) int {
	if (len(s) <= 1){
		return len(s)
	}
	maxLen := 0;

	hashMap := make(map[byte]int,0)

	hashMap[s[0]] = 1
	back,front := 0,1
	for  front < len(s){
		value := s[front]

		if (hashMap[value] < back + 1){
			hashMap[value] = front + 1
			front++
			continue
		}

		index := hashMap[value] - 1
		strLen := max(index - back + 1,front - index)
		maxLen = max(strLen,maxLen)
		back = index + 1
		if (back < len(s)){
			hashMap[s[back]] = back + 1
		}

		hashMap[value] = front + 1
	}
	return maxLen

}