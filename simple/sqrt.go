package simple

// 69. x 的平方根
// 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5
//
// 来源：力扣（LeetCode）
func mySqrt(x int) int {
	l, r := 0, x
	res := -1
	for l <= r {
		m := (l + r) >> 1
		if m*m <= x {
			res = m
			l = m + 1
		} else {
			r = m - 1
		}
	}
	return res
}
