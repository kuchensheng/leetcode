package simple

//romanToInt 罗马数字转int，给定一个罗马数字，将其转换为整数
//罗马数字包含以下7种字符 I(1)、V(5)、X(10)、L(50)、C(100)、D(500)、M(1000)
//NOTE: 通常情况下，罗马数字中小的数字在大的数字的右边
//特例：IV（4）、IX（9）、XL（40）、XC(90)、CD（400）、CM（900）

func romanToInt(s string) int {
	length := len(s)
	if length < 1 || length > 15 {
		return 0
	}

	return 0
}
