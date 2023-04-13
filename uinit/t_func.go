package main

import (
	"fmt"
	"log"
	"time"
)

func main() {
	var counter = 100
	var catCh = make(chan string, counter)
	var dogCh = make(chan string, counter)
	var fishCh = make(chan string, counter)
	//生产
	go func() {
		for i := 0; i < counter; i++ {
			go func() {
				catCh <- printCat()
			}()
			go func() {
				dogCh <- printDog()
			}()
			go func() {
				fishCh <- printFish()
			}()
		}
	}()
	//消费
	for i := 0; i < counter; i++ {
		select {
		case c := <-catCh:
			fmt.Printf("%s\t", c)
		case <-time.After(time.Millisecond * 100):
			log.Fatal("异常退出")
		}

		select {
		case c := <-dogCh:
			fmt.Printf("%s\t", c)
		}
		select {
		case c := <-fishCh:
			fmt.Printf("%s\t", c)
		}
		println()
	}

}

func printCat() string {
	print("cat")
	return "cat"
}

func printDog() string {
	print("dog")
	return "dog"
}
func printFish() string {
	print("fish")
	return "fish"
}
