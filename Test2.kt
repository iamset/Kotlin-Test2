// Question 1: 

fun lenOfLongSubString(s: String): Int {
        var tmp = ""
        var max  = 0
        for (i in 0..s.lastIndex){
            if (tmp.contains(s[i])){
                tmp = tmp.takeLastWhile{it != s[i]}            
            }
            tmp += s[i]
            if (tmp.length > max){ max = tmp.length }
        }
        return max
 }
 
 //Question 3:
 fun medianOfSortedArrays(a:Array<Int>, b:Array<Int>):Double {
    var combinedArray:Array<Int> = a + b
    combinedArray.sort();
    
    var middleIndex =  Math.floor(combinedArray.size / 2.0).toInt()
    if(combinedArray.size % 2 == 1) return combinedArray[middleIndex].toDouble()
    else {
        return ((combinedArray[middleIndex-1] + combinedArray[middleIndex])/2.0)
    }
    return 1.0
}

//Question 4:
fun displayForLegibility(s:String, numRows:Int):String{
    val stringHolder:HashMap<Char, MutableList<Char>> = hashMapOf<Char,MutableList<Char>>()
    var counter = 0
    var key = counter + 1
    var isTop = true
    if(s.length == 1 || s.length == 2) return s
    if(numRows == 1) return s
    while(counter < s.length){
        if(isTop){
            
            if(stringHolder.containsKey(key.toChar())){
                val chars:MutableList<Char> = stringHolder.getValue(key.toChar())
                chars.add(s[counter])
                
            } else {
                stringHolder.put(key.toChar(), mutableListOf(s[counter]))
            }
            if(key != numRows)key++
            else {
                key--
                isTop = false
            }
        } else {
            if(stringHolder.containsKey(key.toChar())){
                val chars:MutableList<Char> = stringHolder.getValue(key.toChar())
                chars.add(s[counter])
            } else {
                stringHolder.put(key.toChar(), mutableListOf(s[counter]))
            }
            if(key != 1) key--
            else {
                key++
                isTop = true
            }
        }
        counter++
    }
    var result = ""
    for((key, value) in stringHolder){
        result+=value.joinToString("")
    }
    return result
}

//Question 5:
fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var tail = ListNode(-1)
        var head = tail
        var l1Copy = l1
        var l2Copy = l2
        while(l1Copy != null && l2Copy !=null){
            if(l1Copy.`val` < l2Copy.`val`){
                tail.next = l1Copy
                tail = tail.next
                l1Copy = l1Copy.next
            } else {
                tail.next = l2Copy
                tail = tail.next
                l2Copy = l2Copy.next
            }
        }
        if(l1Copy != null){
            tail.next = l1Copy
            tail = tail.next
        } else if(l2Copy != null){
            tail.next = l2Copy
            tail = tail.next
        }
        
        return head.next
    }
//Question 7:
fun searchInsert(nums: IntArray, target: Int): Int {
        fun binarySearch(nums:IntArray, target:Int):Int{
            var start:Int = 0
            var end:Int = nums.size-1
            
            while(start <= end){
                var middle:Int = Math.floor((start+end)/2.0).toInt()
                if(nums[middle] == target) return middle
                if(nums[middle] > target){
                    end = middle - 1
                } else if(nums[middle] < target){
                    start = middle + 1
                }
            }
            return -1
        }
        val resultOfSearch = binarySearch(nums, target)
        if(resultOfSearch != -1) return resultOfSearch
        var index = 0
        while(index < nums.size){
            if(nums[index] >= target){
                if(index == 0) return 0
                return index
            }
            index++
        }
        return nums.size
    }

//Question 8:
fun removeDuplicates(nums: IntArray): Int {
       if(nums.size == 0) return 0
        
        var i = 0
        for(j in 1..nums.size-1){
            if(nums[j] != nums[i]){
                i++
                nums[i] = nums[j]
            }
        }
        return i + 1
    }

 
