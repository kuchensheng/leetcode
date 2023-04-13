package simple

// searchInsert 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 请必须使用时间复杂度为 O(log n) 的算法。
// 1 <= nums.length <= 104
// -104 <= nums[i] <= 104
// nums 为 无重复元素 的 升序 排列数组
// -104 <= target <= 104
func searchInsert(nums []int, target int) int {
	lens := len(nums)
	left, right := 0, lens-1
	idx := lens
	for left <= right {
		mid := (right-left)/2 + left
		if target < nums[mid] {
			idx = mid
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	return idx
}
