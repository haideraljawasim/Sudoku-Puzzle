fun main() {
    check(
        name = "When a valid Sudoku puzzle should return true",
        result = isValidSudoku(
            listOf(
                listOf("5", "3", "-", "-", "7", "-", "-", "-", "-"),
                listOf("6", "-", "-", "1", "9", "5", "-", "-", "-"),
                listOf("-", "9", "8", "-", "-", "-", "-", "6", "-"),
                listOf("9", "-", "-", "-", "6", "-", "-", "-", "3"),
                listOf("4", "-", "-", "8", "-", "3", "-", "-", "1"),
                listOf("7", "-", "-", "-", "2", "-", "-", "-", "6"),
                listOf("-", "6", "-", "-", "-", "-", "2", "8", "-"),
                listOf("-", "-", "-", "4", "1", "9", "-", "-", "5"),
                listOf("-", "-", "-", "-", "8", "-", "-", "7", "9")
            )
        ),
        correctResult = true
    )

    check(
        name = "When the Sudoku puzzle not NxN should return false",
        result = isValidSudoku(
            listOf(
                listOf("5", "3", "-", "-", "7", "-", "-", "-", "-"),
                listOf("6", "-", "-", "1", "9", "5", "-", "-", "-"),
                listOf("-", "9", "8", "-", "-", "-", "-", "6", "-"),
                listOf("8", "-", "-", "-", "6", "-", "-", "-", "3"),
                listOf("4", "-", "-", "8", "-", "3", "-", "-", "1"),
                listOf("7", "-", "-", "-", "2", "-", "-", "-", "6"),
                listOf("-", "6", "-", "-", "-", "-", "2", "8", "-"),
                listOf("-", "-", "-", "4", "1", "9", "-", "-", "5"),
                listOf("-", "-", "-", "-", "8", "-", "-", "7", "9", "1")
            )
        ),
        correctResult = false
    )
    check(
        name = "when a valid 16x16 or any perfect square Sudoku puzzle size should return true",
        result = isValidSudoku(
            listOf(
                listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"),
                listOf("5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "1", "2", "3", "4"),
                listOf("9", "10", "11", "12", "13", "14", "15", "16", "1", "2", "3", "4", "5", "6", "7", "8"),
                listOf("13", "14", "15", "16", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"),
                listOf("2", "1", "4", "3", "6", "5", "8", "7", "10", "9", "12", "11", "14", "13", "16", "15"),
                listOf("6", "5", "8", "7", "10", "9", "12", "11", "14", "13", "16", "15", "2", "1", "4", "3"),
                listOf("10", "9", "12", "11", "14", "13", "16", "15", "2", "1", "4", "3", "6", "5", "8", "7"),
                listOf("14", "13", "16", "15", "2", "1", "4", "3", "6", "5", "8", "7", "10", "9", "12", "11"),
                listOf("3", "4", "1", "2", "7", "8", "5", "6", "11", "12", "9", "10", "15", "16", "13", "14"),
                listOf("7", "8", "5", "6", "11", "12", "9", "10", "15", "16", "13", "14", "3", "4", "1", "2"),
                listOf("11", "12", "9", "10", "15", "16", "13", "14", "3", "4", "1", "2", "7", "8", "5", "6"),
                listOf("15", "16", "13", "14", "3", "4", "1", "2", "7", "8", "5", "6", "11", "12", "9", "10"),
                listOf("4", "3", "2", "1", "8", "7", "6", "5", "12", "11", "10", "9", "16", "15", "14", "13"),
                listOf("8", "7", "6", "5", "12", "11", "10", "9", "16", "15", "14", "13", "4", "3", "2", "1"),
                listOf("12", "11", "10", "9", "16", "15", "14", "13", "4", "3", "2", "1", "8", "7", "6", "5"),
                listOf("16", "15", "14", "13", "4", "3", "2", "1", "8", "7", "6", "5", "12", "11", "10", "9")
            )
        ),
        correctResult = true
    )
    check(
        name = "when a valid 4x4 Sudoku puzzle should return true",
        result = isValidSudoku(
            listOf(
                listOf("1", "2", "3", "4"),
                listOf("3", "4", "1", "2"),
                listOf("2", "1", "4", "3"),
                listOf("4", "3", "2", "1")
            )
        ),
        correctResult = true
    )

    check(
        name = "When the Sudoku puzzle is empty should return false",
        result = isValidSudoku(
            emptyList()
        ),
        correctResult = false
    )

    check(
        name = "When there is duplicated in one subgrid should return false",
        result = isValidSudoku(
            listOf(
                listOf("5", "3", "-", "-", "7", "-", "-", "-", "-"),
                listOf("6", "3", "-", "1", "9", "5", "-", "-", "-"),
                listOf("-", "9", "8", "-", "-", "-", "-", "6", "-"),
                listOf("8", "-", "-", "-", "6", "-", "-", "-", "3"),
                listOf("4", "-", "-", "8", "-", "3", "-", "-", "1"),
                listOf("7", "-", "-", "-", "2", "-", "-", "-", "6"),
                listOf("-", "6", "-", "-", "-", "-", "2", "8", "-"),
                listOf("-", "-", "-", "4", "1", "9", "-", "-", "5"),
                listOf("-", "-", "-", "-", "8", "-", "-", "7", "9")
            )
        ),
        correctResult = false
    )

    check(
        name = "When there is duplicated in one row or more should return false",
        result = isValidSudoku(
            listOf(
                listOf("5", "3", "3", "-", "7", "-", "-", "-", "-"),
                listOf("6", "3", "-", "1", "9", "5", "-", "-", "-"),
                listOf("-", "9", "8", "-", "-", "-", "-", "6", "-"),
                listOf("8", "-", "-", "-", "6", "-", "-", "-", "3"),
                listOf("4", "-", "-", "8", "-", "3", "-", "-", "1"),
                listOf("7", "-", "-", "-", "2", "-", "-", "-", "6"),
                listOf("-", "6", "-", "-", "-", "-", "2", "8", "-"),
                listOf("-", "-", "-", "4", "1", "9", "-", "-", "5"),
                listOf("-", "-", "-", "-", "8", "-", "-", "7", "9")
            )
        ),
        correctResult = false
    )

    check(
        name = "When there is duplicated in one column or more should return false",
        result = isValidSudoku(
            listOf(
                listOf("5", "3", "-", "-", "7", "-", "-", "-", "-"),
                listOf("6", "3", "-", "1", "9", "5", "-", "-", "-"),
                listOf("-", "3", "8", "-", "-", "-", "-", "6", "-"),
                listOf("8", "-", "-", "-", "6", "-", "-", "-", "3"),
                listOf("4", "-", "-", "8", "-", "3", "-", "-", "1"),
                listOf("7", "-", "-", "-", "2", "-", "-", "-", "6"),
                listOf("-", "6", "-", "-", "-", "-", "2", "8", "-"),
                listOf("-", "-", "-", "4", "1", "9", "-", "-", "5"),
                listOf("-", "-", "-", "-", "8", "-", "-", "7", "9")
            )
        ),
        correctResult = false
    )

    check(
        name = "When there is a letter or special character in the puzzle should return false",
        result = isValidSudoku(
            listOf(
                listOf("5", "3", "-", "-", "7", "-", "-", "-", "-"),
                listOf("6", "a", "-", "1", "9", "5", "-", "-", "-"),
                listOf("-", "9", "8", "-", "-", "-", "-", "6", "-"),
                listOf("8", "-", "-", "-", "6", "-", "-", "-", "3"),
                listOf("4", "-", "-", "8", "-", "3", "-", "-", "1"),
                listOf("7", "-", "-", "-", "2", "-", "-", "-", "6"),
                listOf("-", "6", "-", "-", "-", "-", "2", "8", "-"),
                listOf("-", "-", "-", "4", "1", "9", "-", "-", "5"),
                listOf("-", "-", "-", "-", "8", "-", "-", "7", "9")
            )
        ),
        correctResult = false
    )
    check(
        name = "When the Sudoku puzzle have numbers that are bigger than it size  the puzzle should return false",
        result = isValidSudoku(
            listOf(
                listOf("10", "3", "-", "-", "7", "-", "-", "-", "-"),
                listOf("6", "a", "-", "1", "9", "5", "-", "-", "-"),
                listOf("-", "9", "8", "-", "-", "-", "-", "6", "-"),
                listOf("8", "-", "-", "-", "6", "-", "-", "-", "3"),
                listOf("4", "-", "-", "8", "-", "3", "-", "-", "1"),
                listOf("7", "-", "-", "-", "2", "-", "-", "-", "6"),
                listOf("-", "6", "-", "-", "-", "-", "2", "8", "-"),
                listOf("-", "-", "-", "4", "1", "9", "-", "-", "5"),
                listOf("-", "-", "-", "-", "8", "-", "-", "7", "9")
            )
        ),
        correctResult = false
    )
}

/**
 * a simple test function to test some cases based on the returned value from other function,
 * Print "Success" with the [name] param if the  [result] param match the [correctResult] param
 * and "Fail" with the [name] param on the opposite
 * @param name represent one case of cases to test
 * @param result  represent the  returned value of  a given function
 * @param correctResult  represent the result should the function returned based on the input
 *
 */
fun check(name:String, result: Boolean, correctResult:Boolean){

    if (correctResult == result){
        println( "success - $name ")
    }else{
        println("fail - $name ")
    }
}

