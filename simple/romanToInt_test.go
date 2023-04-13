package simple

import "testing"

func Test_romanToInt(t *testing.T) {
	type args struct {
		s string
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{
			name: "单个值I",
			args: args{"I"},
			want: 1,
		},
		{
			name: "单个值V",
			args: args{"V"},
			want: 5,
		},
		{
			name: "两个值V",
			args: args{"II"},
			want: 2,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := romanToInt(tt.args.s); got != tt.want {
				t.Errorf("romanToInt() = %v, want %v", got, tt.want)
			}
		})
	}
}
