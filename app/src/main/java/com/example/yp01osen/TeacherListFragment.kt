package com.example.yp01osen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TeacherListFragment : Fragment() {


    private lateinit var teacher: List<Teacher>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teacher_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.requireViewById<RecyclerView>(R.id.recyclerViewTeacher)
        initializeList()
        var adapter : TeacherAdapter = TeacherAdapter(teacher){teacher, i ->
            parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView,TeacherFragment(teacher))
                .addToBackStack("Main")
                .commit()

    }
        recyclerView.adapter = adapter

    }

    private fun initializeList(){
        teacher = listOf(
            Teacher("Иван", "Иван", "Иванович", "Преподаватель физ.культуры", "Ведение уроков физической культуры"),
            Teacher("Кирилл", "Фазуль", "Денисович", "Преподаватель рус.яз.", "Ведение уроков русского языка"),
            Teacher("Ваня", "Романов", "Романович", "Преподаватель математики", "Ведение уроков математики"),
            Teacher("Антон", "Антонов", "Антонович", "Преподаватель окр.мира", "Ведение уроков окружающего мира"),
            Teacher("Кирилл", "Кирилов", "Кирилович", "Преподаватель биологии", "Ведение уроков биологии"),
            Teacher("Петров", "Петр", "Петрович", "Преподаватель физики", "Ведение уроков физики"),
            Teacher("Петров", "Петр", "Петрович", "Преподаватель физики", "Ведение уроков физики"),
            Teacher("Петров", "Петр", "Петрович", "Преподаватель физики", "Ведение уроков физики"),
            Teacher("Петров", "Петр", "Петрович", "Преподаватель физики", "Ведение уроков физики"),
            Teacher("Петров", "Петр", "Петрович", "Преподаватель физики", "Ведение уроков физики"),
            Teacher("Петров", "Петр", "Петрович", "Преподаватель физики", "Ведение уроков физики"),
            Teacher("Петров", "Петр", "Петрович", "Преподаватель физики", "Ведение уроков физики"),
            Teacher("Петров", "Петр", "Петрович", "Преподаватель физики", "Ведение уроков физики"),
            Teacher("Петров", "Петр", "Петрович", "Преподаватель физики", "Ведение уроков физики"),
            Teacher("Петров", "Петр", "Петрович", "Преподаватель физики", "Ведение уроков физики"),
        )
    }

}