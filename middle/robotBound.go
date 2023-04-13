package middle

/*
在无限的平面上，机器人最初位于(0, 0)处，面朝北方。注意:

北方向 是y轴的正方向。
南方向 是y轴的负方向。
东方向 是x轴的正方向。
西方向 是x轴的负方向。
机器人可以接受下列三条指令之一：

"G"：直走 1 个单位
"L"：左转 90 度
"R"：右转 90 度
机器人按顺序执行指令instructions，并一直重复它们。

只有在平面中存在环使得机器人永远无法离开时，返回true。否则，返回 false。

1 <= instructions.length <= 100
instructions[i] 仅包含 'G', 'L', 'R'
*/
const (
	NORTH int = iota + 1
	SOUTH
	EST
	WES
)

type location struct {
	First  int
	Second int
	Dir    int // ± 1
	Xory   bool
}

func isRobotBounded(instructions string) bool {
	init := &location{0, 0, NORTH, true}

	change := func(val int, dir int) int {
		switch dir {
		case NORTH:
			fallthrough
		case EST:
			val++
		default:
			val--
		}
		return val
	}
	move := func(l *location, instruction byte) {
		switch instruction {
		case 'G':
			if l.Xory {
				l.Second += change(l.Second, l.Dir)
			} else {
				l.First += change(l.Second, l.Dir)
			}
		case 'R':
			fallthrough
		case 'L':
			//反转
			if l.Xory {
				l.Xory = false
			} else {
				l.Xory = true
			}
		default:

		}
	}
	length := len(instructions)
	for i := 0; i < length; i++ {
		move(init, instructions[i])
		println(init.First, init.Second)
	}

	return init.First == 0 && init.Second == 0
}
