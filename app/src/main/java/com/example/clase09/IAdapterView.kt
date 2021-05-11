package com.example.clase09

interface IAdapterView{
    fun addItem(item: Any)
    val onClickListener: OnClickListener
}