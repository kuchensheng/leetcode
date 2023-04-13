package closure

import "fmt"

// 闭包=函数+引用环境
// 闭包的价值：对象是附有行为的数据，闭包是附有数据的行为
func do() {
	a := 1
	func() {
		fmt.Print(a)
		a = 2
	}()
}
