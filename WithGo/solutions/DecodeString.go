package solutions


/***
# 394 ：
解题思路：
1. 遍历字符串,当遇到/d[ :数字加 左中括号时,入栈
2. 遇到a-z时,记录下来这个子字符串
3. 一大
 */
func DecodeString(s string)  string{
	return decodeString(s)
}

func decodeString(s string) string {
	if (len(s) < 1){
		return ""
	}
	repeatCount := int(s[0] - '0')
	result,_ := deepSearch(s, 2,repeatCount)
	return string(result)
}
/**
  return : repeat stack , result

 */
func deepSearch(s string,index int,repeatCount int ) ([]byte,int){
	if (index > len(s)){
		return []byte{},index;
	}
	result := make([]byte,0)
	for ;index < len(s);index++{

		if (s[index]  < '9' && s[index] > '0'){
			subResult,indexReturn := deepSearch(s,index + 2,int(s[index] - '0'))
			index = indexReturn
			result =  sliceCopy(result,subResult)
		}
		if (index < len(s) && s[index] == ']'){
			sourceResult := result
			for repeatCount > 1{
				result = sliceCopy(result,sourceResult)
				repeatCount--
			}
			continue
		}
		result = append(result,s[index])
	}
	return result,index - 1

}

// co
func sliceCopy(slice1 []byte, slice2 []byte)  []byte{
	if slice1 == nil || slice2 == nil{
		return nil
	}
	for _,value := range slice2{
		slice1 = append(slice1,value)
	}
	return slice1
}