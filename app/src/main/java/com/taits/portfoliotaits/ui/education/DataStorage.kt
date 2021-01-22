package com.taits.fifthapplication.ui.contacts

import com.taits.portfoliotaits.R

object DataStorage {
    fun getEducationList(): List<Institution> {
        return listOf(
            Institution(
                "Детский сад №19",
                R.drawable.detsad
            ),

            Institution(
                "ГБОУ лицей №419",
                R.drawable.lyceum
            ),

            Institution(
                "Детская музыкальная школа №22",
                R.drawable.dmsh
            ),

            Institution(
                "Университет ИТМО",
                R.drawable.itmo

            )
        )
    }
}
