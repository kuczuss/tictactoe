package pl.wsiz.tictactoe

/**
 * metoda statyczna sprawdzania nazwy
 */
object ValidName {
    fun validN(
        username: String
    ):Boolean {
        if (username.isEmpty()) {
            return false
        }
        if(username.count { it.isDigit() } > 2) {
            return false
        }

        return true
    }
}