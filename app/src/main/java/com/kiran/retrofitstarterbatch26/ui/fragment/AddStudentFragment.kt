package com.kiran.retrofitstarterbatch26.ui.fragment

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import com.kiran.retrofitstarterbatch26.R
import com.kiran.retrofitstarterbatch26.ui.model.Student
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception


class AddStudentFragment : Fragment() {
    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var etAddress: EditText
    private lateinit var btnSubmit: Button
    private lateinit var rdbMale: RadioButton
    private lateinit var rdbFemale: RadioButton
    private lateinit var rdoOther: RadioButton

    private var gender: String = "male"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view:View = inflater.inflate(R.layout.fragment_add_student,container,false)

        etName = view.findViewById(R.id.etName)
        etAge = view.findViewById(R.id.etAge)
        etAddress = view.findViewById(R.id.etAddress)
        btnSubmit = view.findViewById(R.id.btnSubmit)
        rdbMale = view.findViewById(R.id.rdbMale)
        rdbFemale = view.findViewById(R.id.rdbFemale)
        rdoOther = view.findViewById(R.id.rdoOther)


        btnSubmit.setOnClickListener {

            if(TextUtils.isEmpty(etName.text)){
                etName.requestFocus()
                etName.error = "Name is required"
            }
            else if(TextUtils.isEmpty(etAge.text)){
                etAge.requestFocus()
                etAge.error = "Age is required"
            }
            else if(TextUtils.isEmpty(etAddress.text)){
                etAddress.requestFocus()
                etAddress.error = "Address cannot be empty"
            }
            else{
                null
//                val student = Student(etName.toString(),gender,etAge.toString())
//                try {
//                    CoroutineScope(Dispatchers.IO).launch {
//                        StudentDB.getInstance(requireContext()).getStudentDAO().registerStudent(student)
//                    }
//                }catch (ex:Exception){
//                }
            }
        }
        rdbMale.setOnClickListener {
            gender = "male"
        }
        rdbFemale . setOnClickListener {
            gender = "female"
        }
        rdoOther . setOnClickListener {
            gender = "other"
        }
        return view
    }

}