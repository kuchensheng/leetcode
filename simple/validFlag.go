package simple

// 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
// 每个右括号都有一个对应的相同类型的左括号。
//
// 来源：力扣（LeetCode）
// 1 <= s.length <= 104
// s 仅由括号 '()[]{}' 组成
var byteMap = map[byte]byte{'[': ']', '(': ')', '{': '}'}

func isValid(s string) bool {
	length := len(s)
	if length%2 != 0 {
		return false
	}
	var stack []byte

	for i := 0; i < length; i++ {
		//左括号入栈
		if lr, ok := byteMap[s[i]]; ok {
			stack = append(stack, lr)
		} else {
			//右括号比较且stack不为空
			if len(stack) == 0 {
				return false
			}
			//右括号与最后输入的左括号匹配
			right := stack[len(stack)-1]
			if s[i] != right {
				return false
			}
			stack = stack[:len(stack)-1]
		}
	}
	return len(stack) == 0

}
