package bubblesort

import (
	"fmt"
	"testing"
)

func TestA(t *testing.T) {
	foo := make([]int, 5)
	foo[3] = 42
	foo[4] = 100
	fmt.Println("foo = ", &foo, foo)
	bar := foo[1:4]
	bar[1] = 99
	fmt.Println("bar = ", &bar, bar, foo)

	foo = append(foo, 100, 1000, 10000)

}

func TestB(t *testing.T) {
	defer func() {
		fmt.Println("我没返回值")
	}()

	hash := make(map[string]any)

	hash["a"] = 1
	hash["b"] = "库陈胜"

	av := hash["a"]
	fmt.Printf("%+v\n", av)

	v, ok := hash["b"]

	fmt.Printf("%v,%v\n", v, ok)

}
