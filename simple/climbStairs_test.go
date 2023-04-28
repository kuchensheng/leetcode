package simple

import "testing"

func Test_climbStairs(t *testing.T) {
	type args struct {
		n int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		// TODO: Add test cases.
		{"1Test", args{1}, 1},
		{"2Test", args{2}, 2},
		{"3Test", args{3}, 3},
		{"4Test", args{4}, 5},
		{"5Test", args{5}, 8},
		{"6Test", args{6}, 13},
		{"7Test", args{7}, 21},
		{"8Test", args{8}, 34},
		{"9Test", args{9}, 55},
		{"10Test", args{10}, 89},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := climbStairs(tt.args.n); got != tt.want {
				t.Errorf("climbStairs() = %v, want %v", got, tt.want)
			}
		})
	}
}
