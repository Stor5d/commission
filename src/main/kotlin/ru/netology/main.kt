package ru.netology

import kotlin.math.roundToInt

fun main() {
    val transferAmount = 1000_00
    val transferAmountPrev = 74000_01
    val card = "Maestro"
    val commission = transaction(transferAmount, transferAmountPrev, card)
    val rubles: Int = commission / 100
    val pennies: Int = commission % 100
    println("Комиссия составит: $rubles руб. $pennies коп.")
}

fun transaction(transferAmount: Int, transferAmountPrev: Int = 0, card: String = "Vk Pay"): Int {
    val commissionPercentageMastercardMaestro = 0.6
    val commissionMastercardMaestroDefault = 20_00
    val amountMastercardMaestroMax = 75000_00
    val commissionPercentageVisaMir = 0.75
    val commissionVisaMirMin = 35_00
    return when (card) {
        "Mastercard", "Maestro" -> {
            val commission =
                (transferAmount * commissionPercentageMastercardMaestro / 100.00).roundToInt() + commissionMastercardMaestroDefault
            val commissionResult: Int =
                if (transferAmount + transferAmountPrev > amountMastercardMaestroMax) commission else 0
            commissionResult
        }
        "Visa", "Мир" -> {
            val commission = (transferAmount * commissionPercentageVisaMir / 100.00).roundToInt()
            val commissionResult: Int = if (commission > commissionVisaMirMin) commission else commissionVisaMirMin
            commissionResult
        }
        else -> 0
    }
}


