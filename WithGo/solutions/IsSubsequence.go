package solutions

func  IsSubsequence(s string, t string) bool {
	return isSubsequence(s,t)
}
func isSubsequence(s string, t string) bool {
	sIndex := 0
	tIndex := 0
	for sIndex < len(s){
		for tIndex < len(t) &&  s[sIndex] != t[tIndex]{
			tIndex++
		}
		if (tIndex > len(t) - 1){
			return false
		}
		tIndex++
		sIndex++
	}
	return true
}
