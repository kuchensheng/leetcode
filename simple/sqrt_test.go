package simple

import (
	"math"
	"testing"
)

func Test_mySqrt(t *testing.T) {
	type args struct {
		x int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		// TODO: Add test cases.
		{"0Test", args{0}, 0},
		{"1Test", args{1}, 1},
		{"2Test", args{2}, 1},
		{"3Test", args{3}, 1},
		{"4Test", args{4}, 2},
		{"6Test", args{6}, 2},
		{"8Test", args{8}, 2},
		{"15Test", args{15}, 3},
		{"bigTest", args{int(math.Pow(float64(2), float64(30)))}, int(math.Sqrt(math.Pow(float64(2), float64(30))))},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := mySqrt(tt.args.x); got != tt.want {
				t.Errorf("mySqrt() = %v, want %v", got, tt.want)
			}
		})
	}
}
