package com.example.crud_api_cahyob

interface CrudView {
    //untuk add
    fun SuccessAdd (msg: String)
    fun onErrorAdd (msg: String?)

    //untuk get data
    fun onSuccessGet (data: List<DataItem>?)
    fun onFailedGet (msg: String?)

    //untuk update
    fun onSuccessUpdate (msg: String)
    fun onErrorUpdate (msg: String?)

    //untuk delete
    fun onSuccesDelete (msg: String)
    fun onErrorDelete (msg: String?)
}