package simple

import "testing"

func Test_isPalindrome(t *testing.T) {
	type args struct {
		x int
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		// TODO: Add test cases.
		{
			"int回文", args{100}, true,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := isPalindrome(tt.args.x); got != tt.want {
				t.Logf("isPalindrome() = %v, want %v,不是回文", got, tt.want)
			} else {
				t.Log("是回文")
			}
		})
	}
}
