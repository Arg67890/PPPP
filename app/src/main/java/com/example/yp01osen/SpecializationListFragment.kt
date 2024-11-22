package com.example.yp01osen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SpecializationListFragment : Fragment() {


    lateinit var  specializationList : List<Specialization>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specialization_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewSpecialization)
initializeList()
        val adapter: SpecializationAdapter = SpecializationAdapter(specializationList) {specialization, i ->
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView,SpecializationFragment(specialization))
                .addToBackStack("Main")
                .commit()
        }

        recyclerView.adapter = adapter

    }
    private fun initializeList(){
        specializationList = listOf(
            Specialization("Информационные системы и программирование","09.02.07","Подготовка программистов с навыками создания и управления информационными системами, со владением языками программирования."),
            Specialization("Переработка нефти и газа","18.02.09 ","Техники-технологи владеют всеми тонкостями операций по переработке нефти, сопутствующего газа."),
            Specialization("Экономика и бухгалтерский учет (по отраслям)","38.02.01","Подготовка бухгалтеров, специалистов с широкими знаниями в области экономики и управления предприятиями."),
            Specialization("Банковское дело","38.02.07","Подготовка банковских служащих с пониманием принципов работы банковской системы, со знаниями в области экономики."),
            Specialization("Пожарная безопасность","20.02.04","Подготовка специалистов, которые имеют компетенции в защите окружающей среды от пожаров, проведения аварийно-спасательных работ."),
            Specialization("Монтаж, техническое обслуживание и ремонт промышленного оборудования (по отраслям)","15.02.17","Деятельность техников-механиков направлена на сборку, регулировку, тестирование, ремонт, эксплуатационное обслуживание оборудования."),
            Specialization("Теплоснабжение и теплотехническое оборудование","13.02.02","Программа готовит специалистов по техническому обслуживанию и эксплуатации теплотехнического оборудования систем тепловодогазоснабжения."),
            Specialization("Экологическая безопасность природных комплексов","20.02.01","Программа включает подготовку специалистов которые занимаются проведением мониторинга окружающей среды на выбранной территории."),
        )
    }
}