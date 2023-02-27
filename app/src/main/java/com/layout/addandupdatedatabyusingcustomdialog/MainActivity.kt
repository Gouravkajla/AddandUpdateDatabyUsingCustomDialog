package com.layout.addandupdatedatabyusingcustomdialog

import android.annotation.SuppressLint
import android.app.Dialog
import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.layout.addandupdatedatabyusingcustomdialog.databinding.CustomDialogUpdateAndDeleteBinding
import com.layout.addandupdatedatabyusingcustomdialog.databinding.CustomdialogaddBinding

class MainActivity : AppCompatActivity() {
lateinit var lvOutputShow:ListView
lateinit var fabAdd:FloatingActionButton
lateinit var adapter:ArrayAdapter<String>

var userlist=ArrayList<String>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lvOutputShow = findViewById(R.id.lvOutputShow)
        fabAdd = findViewById(R.id.fabAdd)
        fabAdd.setOnClickListener {
            adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, userlist)
            lvOutputShow.adapter = adapter



            fabAdd.setOnClickListener {
                val customDialogg = Dialog(this)
                val dialogbinding = CustomdialogaddBinding.inflate(layoutInflater)
                customDialogg.setContentView(dialogbinding.root)
                dialogbinding.btnAdd.setOnClickListener {
                    if (dialogbinding.btnAdd.text.isEmpty()) {
                        dialogbinding.btnAdd.error = "Enter The Text"
                    } else {
                        userlist.add(dialogbinding.etInput.text.toString())
                        customDialogg.dismiss()
                        adapter.notifyDataSetChanged()


                    }
                }
                customDialogg.show()
            }

        }
        lvOutputShow.setOnItemClickListener { adapterView, view, i, l ->
            val customdialog=Dialog(this@MainActivity)
            val dialogBunding1=CustomDialogUpdateAndDeleteBinding.inflate(layoutInflater)
            customdialog.setContentView(dialogBunding1.root)
            dialogBunding1.btnUpdate.setOnClickListener {
                if (dialogBunding1.btnUpdate.text.isEmpty()){
                    dialogBunding1.btnUpdate.error="Enter Your Value "
                }else{
                    userlist.set(i,dialogBunding1.etUpdate.text.toString())
                    customdialog.dismiss()
                    adapter.notifyDataSetChanged()

                }


            }
            dialogBunding1.btnDelete.setOnClickListener {
                 userlist.removeAt(i)
                customdialog.dismiss()
                customdialog.setCancelable(false)

            }

            customdialog.show()

        }



        }


    }











