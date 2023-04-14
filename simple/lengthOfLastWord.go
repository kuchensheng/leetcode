package simple

// LengthOfLastWord 58.最后一个单词的长度
// 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
//
// 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
//
// 1 <= s.length <= 104
// s 仅有英文字母和空格 ' ' 组成
// s 中至少存在一个单词
func LengthOfLastWord(s string) int {

	//s = func(str string) string {
	//	for len(str) > 0 && str[len(str)-1] == ' ' {
	//		str = str[:len(str)-1]
	//	}
	//	return str
	//}(s)
	res := 0
	flag := true
	for i := len(s); i > 1; i-- {
		if s[i-1] != ' ' {
			flag = false
		}
		if flag {
			continue
		}
		if s[i-1] == ' ' {
			return res
		}
		res++
	}
	return res
}
