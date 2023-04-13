package simple

import "testing"

func TestLongestCommonPrefix(t *testing.T) {
	type args struct {
		strs []string
	}
	tests := []struct {
		name string
		args args
		want string
	}{
		{
			name: "空",
			want: "",
			args: args{strs: []string{"1", "12", "23"}},
		},

		{
			name: "1",
			want: "1",
			args: args{strs: []string{"1", "12", "123"}},
		},
		{
			name: "12",
			want: "1",
			args: args{strs: []string{"12336yyy", "12s", "12r3bn"}},
		},
		{
			name: "fl",
			want: "fl",
			args: args{strs: []string{"flower", "flow", "flight"}},
		},
		{
			name: "nil",
			want: "",
			args: args{strs: []string{"dog", "racecar", "car"}},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := LongestCommonPrefix(tt.args.strs); got != tt.want {
				t.Errorf("LongestCommonPrefix() = %v, want %v", got, tt.want)
			} else {
				t.Logf("tt.want:%s", tt.want)
			}
		})
	}
}
