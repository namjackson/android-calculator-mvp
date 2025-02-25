package edu.nextstep.camp.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CalculatorTest {
    private lateinit var calculator: Calculator

    @BeforeEach
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun `더하기`() {
        // when
        val actual = calculator.calculate("1 + 2")

        // then
        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun `빼기`() {
        // when
        val actual = calculator.calculate("1 - 2")

        // then
        assertThat(actual).isEqualTo(-1)
    }

    @Test
    fun `곱하기`() {
        // when
        val actual = calculator.calculate("1 * 2")

        // then
        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun `나누기`() {
        // when
        val actual = calculator.calculate("4 / 2")

        // then
        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun `수식이 아니면 계산 불가`() {
        // when
        val actual = calculator.calculate("qwe")

        // then
        assertThat(actual).isNull()
    }

    @Test
    fun `미완성된 수식이면 계산 불가`() {
        // when
        val actual = calculator.calculate("1 +")

        // then
        assertThat(actual).isNull()
    }

    @Test
    fun `수식 계산 시, 계산식과 결과가 계산 기록에 추가 되어야 한다`() {
        // given
        val expression = "4 / 2"

        // when
        val result = calculator.calculate(expression)
        val calResult = CalculationHistory(expression, result ?: 0)

        // then
        assertThat(calculator.getHistories()).isEqualTo(listOf(calResult))
    }
}
