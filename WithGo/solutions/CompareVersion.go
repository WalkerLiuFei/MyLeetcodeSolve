package solutions

import (
	"strings"
	"bytes"
)

func CompareVersion(version1 string, version2 string) int {
	result := 0
	index1,index2 := 0,0
	num1 := bytes.Buffer{}
	num2 := bytes.Buffer{}
	for index1 <= len(version1) || index2 <= len(version2) {
		if ((index1 >= len(version1) || version1[index1] ==  '.') && (index2 >= len(version2) || version2[index2] == '.')){
			var r int = 0

			if (len(num1.String()) != len(num2.String())){
				if (len(num1.String()) > len(num2.String())){
					r = 1;
				}else {
					r = -1
				}
				return r
			}
			r = strings.Compare(num1.String(),num2.String())
			if (r != 0){
				return r
			}
			num2.Reset()
			num1.Reset()
			index2++
			index1++
			continue
		}
		if (index1 < len(version1)){
			if (version1[index1] == '0' && num1.Len() == 0){
				index1++
				continue
			}else if (version1[index1] == '.'){
				//continue
			}else{
				num1.WriteByte(version1[index1])
				index1++
			}
		}
		if (index2 < len(version2)){
			if (version2[index2] == '0' && num2.Len() == 0){
				index2++
				continue
			}else if (version2[index2] == '.'){
				//continue
			}else{
				num2.WriteByte(version2[index2])
				index2++
			}
		}
	}
	return  result
}

