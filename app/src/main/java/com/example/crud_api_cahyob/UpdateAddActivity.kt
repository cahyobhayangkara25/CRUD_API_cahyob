package com.example.crud_api_cahyob

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.crud_api_manan.databinding.ActivityUpdateAddBinding

private var Any.text: String
    get() {
        TODO("Not yet implemented")
    }
    set(value) {}

private val ActivityUpdateAddBinding.btnAction: Any
    get() {
        TODO("Not yet implemented")
    }

@SuppressLint("SENSELESS_COMPARISON")
class UpdateAddActivity<T> : AppCompatActivity(), CrudView {
    private lateinit var presenter: Presenter2
    private lateinit var binding: ActivityUpdateAddBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = Presenter2(this)
        val itemDataItem = intent.getSerializableExtra("dataItem")

        if (itemDataItem != null) {
            binding.BtnAction.text = "Tambah"
            binding.btnAction.setOnClickListener() {
                presenter.addData(
                    binding.etName.text.toString(),
                    binding.etPhone.text.toString(),
                    binding.etAddress.text.toString())
            }
        } else if (itemDataItem != null) {
            binding.btnAction.text = "Update"
            val item = itemDataItem as DataItem?
            binding.etName.setText(item?.staffName.toString())
            binding.etPhone.setText(item?.staffHp.toString())
            binding.etAddress.setText(item?.staffAlamat.toString())
            binding.BtnAction.setOnClickListener() {
                presenter.updateData(item?.staffId ?: "",
                    binding.etName.text.toString(),
                    binding.etPhone.text.toString(),
                    binding.etAddress.text.toString())
                finish()
            }
        }
    }

    override fun SuccessAdd(msg: String) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onErrorAdd(msg: String?) {
    }

    override fun onSuccessUpdate(msg: String) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onErrorUpdate(msg: String?) { }

    override fun onSuccessGet(data: List<DataItem>?) { }

    override fun onFailedGet(msg: String?) { }

    override fun onSuccesDelete(msg: String) { }

    override fun onErrorDelete(msg: String?) { }
}

private fun Any.setOnClickListener(function: () -> Unit) {
    TODO("Not yet implemented")
}
