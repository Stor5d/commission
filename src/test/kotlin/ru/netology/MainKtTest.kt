package ru.netology

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun transactionMaestroDownLimit() {
        val transferAmount = 10000_00
        val transferAmountPrev = 60000_00
        val card = "Maestro"
        val expectedCommission = 0
        val actualCommission = transaction(transferAmount, transferAmountPrev, card)
        assertEquals(expectedCommission, actualCommission)
    }

    @Test
    fun transactionVkDefault() {
        val transferAmount = 10000_00
        val expectedCommission = 0
        val actualCommission = transaction(transferAmount)
        assertEquals(expectedCommission, actualCommission)
    }

    @Test
    fun transactionMaestroUpLimit() {
        val transferAmount = 10000_00
        val transferAmountPrev = 66000_00
        val card = "Maestro"
        val expectedCommission = 80_00
        val actualCommission = transaction(transferAmount, transferAmountPrev, card)
        assertEquals(expectedCommission, actualCommission)
    }

    @Test
    fun transactionVkPrevDefault() {
        val transferAmount = 10000_00
        val transferAmountPrev = 66000_00
        val expectedCommission = 0
        val actualCommission = transaction(transferAmount,transferAmountPrev)
        assertEquals(expectedCommission, actualCommission)
    }

    @Test
    fun transactionMastercardDownLimit() {
        val transferAmount = 10000_00
        val transferAmountPrev = 60000_00
        val card = "Mastercard"
        val expectedCommission = 0
        val actualCommission = transaction(transferAmount, transferAmountPrev, card)
        assertEquals(expectedCommission, actualCommission)
    }

    @Test
    fun transactionMastercardUpLimit() {
        val transferAmount = 10000_00
        val transferAmountPrev = 66000_00
        val card = "Mastercard"
        val expectedCommission = 80_00
        val actualCommission = transaction(transferAmount, transferAmountPrev, card)
        assertEquals(expectedCommission, actualCommission)
    }

    @Test
    fun transactionVK() {
        val transferAmount = 10000_00
        val transferAmountPrev = 66000_00
        val card = "Vk Pay"
        val expectedCommission = 0
        val actualCommission = transaction(transferAmount, transferAmountPrev, card)
        assertEquals(expectedCommission, actualCommission)
    }

    @Test
    fun transactionVisaDownLimit() {
        val transferAmount = 4533_00
        val transferAmountPrev = 60000_00
        val card = "Visa"
        val expectedCommission = 35_00
        val actualCommission = transaction(transferAmount, transferAmountPrev, card)
        assertEquals(expectedCommission, actualCommission)
    }

    @Test
    fun transactionVisaUpLimit() {
        val transferAmount = 5000_00
        val transferAmountPrev = 66000_00
        val card = "Visa"
        val expectedCommission = 37_50
        val actualCommission = transaction(transferAmount, transferAmountPrev, card)
        assertEquals(expectedCommission, actualCommission)
    }

    @Test
    fun transactionMirDownLimit() {
        val transferAmount = 4500_00
        val transferAmountPrev = 10000_00
        val card = "Мир"
        val expectedCommission = 35_00
        val actualCommission = transaction(transferAmount, transferAmountPrev, card)
        assertEquals(expectedCommission, actualCommission)
    }

    @Test
    fun transactionMirUpLimit() {
        val transferAmount = 4670_00
        val transferAmountPrev = 2000_00
        val card = "Мир"
        val expectedCommission = 35_03
        val actualCommission = transaction(transferAmount, transferAmountPrev, card)
        assertEquals(expectedCommission, actualCommission)
    }
}