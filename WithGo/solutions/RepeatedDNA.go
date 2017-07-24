package solutions

import (
	"hash/fnv"
)

func FindRepeatedDnaSequences(s string) []string {
	return findRepeatedDnaSequences(s)
}
func findRepeatedDnaSequences(s string) []string {
	hashMap := make(map[uint64]*string, 0)
	isAddToMap := make(map[uint64]bool, 0)
	results := make([]string, 0)
	for index := uint(0); index+10 <= uint(len(s)); index++ {
		str := s[index : index+10]
		hashCode := hash(str)
		if hashMap[hashCode] != nil {
			if isAddToMap[hashCode] == false {
				results = append(results, str)
				isAddToMap[hashCode] = true
			}

		}
		hashMap[hashCode] = &str
	}
	return results
}

func hash(s string) uint64 {
	h := fnv.New64a()
	h.Write([]byte(s))
	return h.Sum64()
}
