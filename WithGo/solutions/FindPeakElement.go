package solutions


func findPeakElement(nums []int) int {
	if (len(nums) == 1){
		return 0
	}
	if (nums[0] >= nums[1]){
		return 0
	}
	if (nums[len(nums) -1] > nums[len(nums) -2]){
		return len(nums) -1
	}
	return FindPeakElement(nums,0,len(nums)-1)
}
func FindPeakElement(nums []int,low int,high int) int {
	var result int
	if (low > high){
		return  -1
	}
	middle := (high - low) / 2 + low

	if (middle != len(nums) -1 && middle != 0 && nums[middle] > nums[middle-1] && nums[middle] > nums[middle+1]){
		return middle
	}

	result = FindPeakElement(nums,low,middle-1)
	if (result != -1){
		return result
	}
	result = FindPeakElement(nums,middle+1,high)
	if (result != -1){
		return result
	}
	return result
}

/**
class Solution {
public:

int findPeakElement(const vector<int> &num) {
    return Helper(num, 0, num.size()-1);
}
int Helper(const vector<int> &num, int low, int high)
{
    if(low == high)
        return low;
    else
    {
        int mid1 = (low+high)/2;
        int mid2 = mid1+1;
        if(num[mid1] > num[mid2])
            return Helper(num, low, mid1);
        else
            return Helper(num, mid2, high);
    }
}
};
 */

