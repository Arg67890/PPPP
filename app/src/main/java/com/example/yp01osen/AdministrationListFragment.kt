package com.example.yp01osen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdministrationListFragment : Fragment() {


    lateinit var administrationList: List<Administration>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_administration_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler: RecyclerView = view.findViewById(R.id.recyclerViewAdministration)
        intializeList()
        val adapter: AdministrationAdapter = AdministrationAdapter(administrationList) { admin, i ->
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, AdministrationFragment(admin))
                .addToBackStack("Main")
                .commit()
        }
        recycler.adapter = adapter
    }

    private fun intializeList() {
        administrationList = listOf(
            (Administration(
                "Егор",
                "Вежлив",
                "Сергеевич",
                "Владелец",
                "Следит за всеми документами ,отчетами"
            )),
            Administration(
                "Илья",
                "Филимонов",
                "Александрович",
                "Директор",
                "Следит за учереждением"
            ),
            Administration("Иван", "Иванов", "Иванович", "Секретарь ", "Следит за деньгами"),
            Administration("Кирилл", "Фазульянов", "Денисович", "ШефПовар", "Готовит техникуму"),
            Administration("Влад", "Борисов", "Борисович", "Техничка", "Следит за порядком"),
            Administration("Егор", "Вежлив", "Сергеевич", "Владелец", "Следит за порядком"),
            Administration("Егор", "Вежлив", "Сергеевич", "Владелец", "Готовит техникуму"),
            Administration("Егор", "Вежлив", "Сергеевич", "Владелец", "Следит за учереждением"),
            Administration("Егор", "Вежлив", "Сергеевич", "Владелец", "Следит за учереждением"),
            Administration("Егор", "Вежлив", "Сергеевич", "Владелец", "Готовит техникуму"),)

    }
}