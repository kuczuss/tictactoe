package pl.wsiz.tictactoe

import com.google.common.truth.Truth.assertThat
import org.junit.Test
class ValidNameTest {
    /**
     * test sprawdzajacy czy puste pole da wartosc false
     */
    @Test
    fun `empty username returns false`() {
        val result = ValidName.validN(
            ""
        )
        assertThat(result).isFalse()
    }

    /**
     * test sprawdzajacy czy poprawne dane zwroci wartosc true
     */
    @Test
    fun `correct username returns true`() {
        val result = ValidName.validN(
            "UserName"
        )
        assertThat(result).isTrue()
    }

    /**
     * test sprawdzajacy czy krótsze niż na 2 znaki zwroci false
     */
    @Test
    fun `less than 2 digit name returns false`() {
        val result = ValidName.validN(
            "p"
        )
        assertThat(result).isFalse()
    }
}