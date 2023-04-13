package main

import (
	"fmt"
)

func main() {

	strs := []string{"flower", "flow", "flight"}
	result := simple.LongestCommonPrefix(strs)
	fmt.Println(result)
}
