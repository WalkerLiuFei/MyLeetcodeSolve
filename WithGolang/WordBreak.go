package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Print(wordBreak("aaaaaaa",[]string{"aaaa","aaa"}))
}
func wordBreak(s string, wordDict []string) bool {
	sMap := make(map[uint32]*string,0);
	wordDict = quickSort(wordDict)
	for _,s := range wordDict{
		var hashCode  uint32 = uint32(s[0])
		for index := 1; index < len(s);index++{
			hashCode = uint32(hashCode * 31 + uint32(s[index]))
			if (sMap[hashCode] != nil){
				hashCode = uint32(s[index])
			}
		}
		fmt.Printf("%d,%s",hashCode," ")
		sMap[hashCode] = &s;
	}
	fmt.Println()
	if len(s) == 0 {
		return false
	}
	hashCodes := make([]uint32,len(s));
	hashCodes[0] = uint32(s[0])
	isPreMatch := sMap[hashCodes[0]] != nil
	for index := 1; index < len(s);index++{
		if (!isPreMatch){
			hashCodes[index] = hashCodes[index - 1] * 31 + uint32(s[index])
		}else {
			hashCodes[index] = uint32(s[index])
			isPreMatch = false
		}
		fmt.Printf("%d,%s",hashCodes[index]," ")
		if (sMap[hashCodes[index]] != nil){
			isPreMatch = true
		}
	}
	return isPreMatch
}
func quickSort(strings []string) []string {
	//if ()
}
