package wait

import (
	"fmt"
	"sync"
	"testing"
	"time"
)

func TestA(t *testing.T) {
	start := time.Now()
	var wg sync.WaitGroup
	counter := 100
	wg.Add(100)
	printName := func(name string) string {
		print(name)
		return name
	}
	//一写
	str := fmt.Sprintf("%s%s%s", printName("cat"), printName("dog"), printName("fish"))
	//多读
	for i := 0; i < counter; i++ {
		go func(idx int) {
			println(idx, "\t", str)
			wg.Done()
		}(i)
	}
	wg.Wait()
	t.Logf("程序执行完毕,耗时[%d]ns", time.Now().Nanosecond()-start.Nanosecond())
}
