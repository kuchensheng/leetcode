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
type location struct {
	First  int
	Second int
	XFlag  int
	YFlag  int
}

func isRobotBounded(instructions string) bool {
	init := &location{0, 0, 0, 1}

	change := func(l *location, i byte) {
		switch i {
		case 'R':
			//第一象限
			if l.XFlag == 0 && l.YFlag == 1 {
				l.XFlag, l.YFlag = 1, 0
			} else if l.XFlag == 1 && l.YFlag == 0 {
				l.XFlag, l.YFlag = 0, -1
			} else if l.XFlag == 0 && l.YFlag == -1 {
				l.XFlag, l.YFlag = -1, 0
			} else {
				l.XFlag, l.YFlag = 0, 1
			}
		case 'L':
			//第一象限
			if l.XFlag == 0 && l.YFlag == 1 {
				l.XFlag, l.YFlag = -1, 0
			} else if l.XFlag == -1 && l.YFlag == 0 {
				l.XFlag, l.YFlag = 0, -1
			} else if l.XFlag == 0 && l.YFlag == -1 {
				l.XFlag, l.YFlag = 1, 0
			} else {
				l.XFlag, l.YFlag = 0, 1
			}
		}
	}
	move := func(l *location) {
		l.First += l.XFlag
		l.Second += l.YFlag
	}
	circle := 0
	hasG := false
	length := len(instructions)
	for i := 0; i < length*4; i++ {
		idx := i % length
		switch instructions[idx] {
		case 'G':
			hasG = true
			move(init)
		default:
			change(init, instructions[idx])
		}
		if init.First == 0 && init.Second == 0 && hasG {
			circle += 1
		}
	}
	if !hasG {
		return true
	}

	return init.First == 0 && init.Second == 0 && circle > 0
}
