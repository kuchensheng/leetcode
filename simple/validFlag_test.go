package simple

import "testing"

func Test_isValid(t *testing.T) {
	type args struct {
		s string
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{
			name: "0个", args: args{
				s: "[)",
			}, want: false,
		},
		{
			name: "1个", args: args{
				s: "[]",
			}, want: true,
		},
		{
			name: "2个", args: args{
				s: "[()]",
			}, want: true,
		},
		{
			name: "2个", args: args{
				s: "((",
			}, want: false,
		},
		{
			name: "3个", args: args{
				s: "()[]{}",
			}, want: true,
		},
		{
			name: "3个", args: args{
				s: "(){}}{",
			}, want: false,
		},
		{
			name: "3个", args: args{
				s: "([{}])",
			}, want: true,
		},
		{
			name: "5个", args: args{
				s: "(([]){})",
			}, want: true,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := isValid(tt.args.s); got != tt.want {
				t.Errorf("isValid() = %v, want %v", got, tt.want)
			}
		})
	}
}
