package simple

// 66. 加一 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
// 1 <= digits.length <= 100
// 0 <= digits[i] <= 9
func plusOne(digits []int) []int {
	digits[len(digits)-1] = digits[len(digits)-1] + 1
	for idx := len(digits) - 1; idx > 0; idx-- {
		val := digits[idx]
		if val < 10 {
			break
		}
		digits[idx] = digits[idx] - 10
		digits[idx-1] = digits[idx-1] + 1
	}
	if val := digits[0]; val > 9 {
		//插头
		digits = append([]int{1}, digits...)
		digits[1] = val - 10
	}
	return digits
}
