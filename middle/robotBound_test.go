package middle

import "testing"

func Test_isRobotBounded(t *testing.T) {
	type args struct {
		instructions string
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{"0Test", args{"GGLLGG"}, true},
		{"1Test", args{"GL"}, true},
		{"2Test", args{"LRRRRLLLRL"}, true},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := isRobotBounded(tt.args.instructions); got != tt.want {
				t.Errorf("isRobotBounded() = %v, want %v", got, tt.want)
			}
		})
	}
}
