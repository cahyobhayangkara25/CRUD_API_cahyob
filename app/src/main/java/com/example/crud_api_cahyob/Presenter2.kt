package com.example.crud_api_cahyob

import retrofit2.Call
import retrofit2.Response

class Presenter2 (val crudView: UpdateAddActivity<Any?>) {
    //add data
    fun addData(name: String, hp : String, alamat: String) {
        NetworkConfig.getService()
            .addStaff(name, hp, alamat)
            .enqueue(object : retrofit2.Callback<ResultStatus>{
                override fun onFailure(call: Call<ResultStatus>, t: Throwable) {
                    crudView.onErrorAdd(t.localizedMessage)
                }

                override fun onResponse(call: Call<ResultStatus>,
                                        response: Response<ResultStatus>
                ){
                    if (response.isSuccessful && response.body()?.status == 200) {
                        crudView.SuccessAdd(response.body()?.pesan ?: "")
                    } else{
                        response.body()?.pesan?.let { crudView.onErrorAdd(it) }
                    }
                }
            })
    }

    //update data
    fun updateData(id: String, name: String, hp: String, alamat: String) {
        NetworkConfig.getService()
            .updateStaff(id, name, hp, alamat)
            .enqueue(object : retrofit2.Callback<ResultStatus>{
                override fun onFailure(call: Call<ResultStatus>, t: Throwable) {
                    crudView.onErrorUpdate(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultStatus>,
                    response: Response<ResultStatus>
                ){
                    if (response.isSuccessful && response.body()?.status == 200) {
                        crudView.onSuccessUpdate(response.body()?.pesan ?: "")
                    } else {
                        crudView.onErrorUpdate(response.body()?. pesan ?: "")
                    }
                }
            })
    }
}