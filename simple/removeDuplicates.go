package simple

import "fmt"

// 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
// 1 <= nums.length <= 3 * 104
// -104 <= nums[i] <= 104
// nums 已按 升序 排列
// NOTE : 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
func removeDuplicates(nums []int) int {
	length := len(nums)
	if length == 1 {
		return length
	}
	idx := 0
	for i := 1; i < length; i++ {
		value := nums[i]
		if nums[idx] != value {
			//修改当前位置的元素信息
			nums[idx+1] = value
			idx++
		}
	}
	length = idx + 1
	nums = nums[:length]
	fmt.Println(nums)
	return length
}
