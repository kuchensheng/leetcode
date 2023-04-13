package simple

// LongestCommonPrefix 查找字符串数组中的最长公共前缀。
// 如果不存在公共前缀，返回空字符串 ""。 strs最长为200，元素长度200
func LongestCommonPrefix(strs []string) string {
	//1. 找到最短长度的字符串作为锚定
	minLenStr := func(array []string) string {
		minLengthStr := array[0]
		for _, s := range array {
			if len(minLengthStr) > len(s) {
				minLengthStr = s
			}
		}
		return minLengthStr
	}
	ms := minLenStr(strs)
	msLength := len(ms)
	//2. 2分比较,获取前缀信息
	maxEnd := func(prefix string, array []string) bool {
		length := len(prefix)
		for _, s := range array {
			if s[:length] != prefix {
				return false
			}
		}
		return true
	}
	commonPrefix := ""
	for i := msLength; i > 0; i-- {
		if maxEnd(ms[:i], strs) {
			commonPrefix = ms[:i]
			break
		}
	}
	return commonPrefix
}
