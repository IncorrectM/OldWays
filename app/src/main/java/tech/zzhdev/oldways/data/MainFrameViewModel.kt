package tech.zzhdev.oldways.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainFrameViewModel: ViewModel() {
    private val _searchValue = MutableLiveData("输入以搜索")
    val searchValue: MutableLiveData<String> = _searchValue

    fun onSearchValueChanged(newValue: String) {
        searchValue.value = newValue
    }
}