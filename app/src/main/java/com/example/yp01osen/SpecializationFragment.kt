package com.example.yp01osen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class SpecializationFragment(val specialization: Specialization) : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specialization, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name : TextView = view.findViewById(R.id.textViewSpecilizationFragmentName)
        val code : TextView = view.findViewById(R.id.textViewSpecilizationFragmentCode)
        val description : TextView = view.findViewById(R.id.textViewSpecilizationFragmentDescription)
        name.append(specialization.name)
        code.append(specialization.code)
        description.text = specialization.description
    }


}