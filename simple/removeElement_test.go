package simple

import "testing"

func Test_removeElement(t *testing.T) {
	type args struct {
		nums []int
		val  int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"0Test", args{nums: []int{}}, 0},
		{"1Test", args{nums: []int{1}, val: 0}, 1},
		{"2Test", args{nums: []int{1}, val: 1}, 0},
		{"3Test", args{nums: []int{1, 1}, val: 1}, 0},
		{"4Test", args{nums: []int{1, 1, 2}, val: 1}, 1},
		{"5Test", args{nums: []int{1, 1, 2, 3}, val: 1}, 2},
		{"6Test", args{nums: []int{0, 1, 2, 2, 3, 0, 4, 2}, val: 2}, 5},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := removeElement(tt.args.nums, tt.args.val); got != tt.want {
				t.Errorf("removeElement() = %v, want %v", got, tt.want)
			}
		})
	}
}
