package com.example.yp01osen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog


class MenuFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val teacherButton = view.findViewById<Button>(R.id.buttonTeacher)
        val specializationButton = view.findViewById<Button>(R.id.buttonSpecializatoin)
        val administrationButton = view.findViewById<Button>(R.id.buttonAdministration)
        val collegeButton = view.findViewById<Button>(R.id.buttonCollege)
        val faqButton = view.findViewById<Button>(R.id.buttonFAQ)

        teacherButton.setOnClickListener{
            openFragment(TeacherListFragment())
        }
        specializationButton.setOnClickListener {
            openFragment(SpecializationListFragment())
        }
        administrationButton.setOnClickListener{
            openFragment(AdministrationListFragment())
            }
        collegeButton.setOnClickListener {
            openFragment(CollegeFragment())
        }

        faqButton.setOnClickListener{
            val alerDialog = AlertDialog.Builder(view.context)
                alerDialog.apply {
                    setTitle("Информация о Разроботчиках")
                    .setMessage("Филимонов Илья Александрович\nтел.8(111)222-33-44\n@gmail: Ilya@gmail.com\n" +
                            "  Вежлив Егор Сергеевич\nтел. 8(999)888-77-66\n@gmail: Egor@gmail.com")
                    .setPositiveButton("Ок") {
                                             dialog, id -> dialog.cancel()
                    }
                }.create().show()
        }
    }



    private fun openFragment(fragment: Fragment){
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView,fragment)
            .addToBackStack("mainStack")
            .commit()

    }

}