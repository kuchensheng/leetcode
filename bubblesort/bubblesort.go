package bubblesort

import (
	"encoding/json"
	"fmt"
	"net/http"
)

func BubbleSort(values []int) {
	flag := true
	for i := 0; i < len(values); i++ {
		flag = true
		for j := 0; j < len(values)-i-1; j++ {
			if values[j] > values[j+1] {
				values[j], values[j+1] = values[j+1], values[j]
				flag = false
			}
		}
		if flag == true {
			break
		}
	}
	println(values)
}

func Decoder() {
	if resp, err := http.Get(""); err == nil {
		decoder := json.NewDecoder(resp.Body)
		var v map[string]any
		if err = decoder.Decode(&v); err == nil {
			for k, v := range v {
				fmt.Printf("k = %s,v = %v", k, v)
			}
		}
	}
}
