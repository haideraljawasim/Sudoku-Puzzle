import kotlin.math.sqrt


/**
 * A simple function to check if a given list of numbers and "-" [sudokuPuzzle] represents a valid Sudoku puzzle.
 * @param sudokuPuzzle The grid to test if it's a valid Sudoku puzzle , represented as NxN numbers and "-".
 * @return Returns true if it's a valid Sudoku puzzle, and false if not.
 */
fun isValidSudoku(sudokuPuzzle: List<List<String>>): Boolean {

    if (sudokuPuzzle.isEmpty()) return false


    // Return True if all of these functions returned False
    return !(checkDuplicatesInRowsNColumns(sudokuPuzzle) ||
            checkDuplicatesInSubgrid(sudokuPuzzle))
}


// return true if the list have duplicates in Rows
fun checkDuplicatesInRowsNColumns(sudokuPuzzle: List<List<String>>) : Boolean {
    sudokuPuzzle.forEachIndexed { colIndex, row ->

        if (row.size != sudokuPuzzle.size) return true   //return if sudokuPuzzle not NxN

        val currentRowNumbers = mutableListOf<String>()
        val currentCol = mutableListOf<String>()

        row.forEachIndexed { rowIndex, rowElement ->
            val colElement = sudokuPuzzle[rowIndex][colIndex]
            //return true if element not equal to "-"  and can't be integer or   not in range between 1 and sudokuPuzzle size

            if (rowElement != "-" && (rowElement.toIntOrNull() == null || rowElement.toInt() !in 1..sudokuPuzzle.size)) return true


            //return true if the element duplicated in the same row or the same column
            if (rowElement != "-" && currentRowNumbers.contains(rowElement) || colElement != "-" && currentCol.contains(
                    colElement
                )
            ) {
                return true
            }
            currentRowNumbers.add(rowElement)
            currentCol.add(colElement)

        }
    }
    return false
}


// return true if the list have duplicates in one Subgrid
fun checkDuplicatesInSubgrid(sudokuPuzzle: List<List<String>>) : Boolean {


    //get the length of rows and columns a subgrid should have
    val subgridSize = sqrt(sudokuPuzzle.size.toFloat()).toInt()

    for (startRow in sudokuPuzzle.indices step subgridSize) {   //row start index for each subgrid
        for (startCol in sudokuPuzzle.indices step subgridSize) { // column start  for each subgrid
            val currentSubGrid = mutableListOf<String>()
            for (row in 0..<subgridSize) {
                for (col in 0..<subgridSize) {

                    val newElement = sudokuPuzzle[startRow + row][startCol + col]
                    if (newElement != "-" && currentSubGrid.contains(newElement)) {
                        return true
                    }
                    currentSubGrid.add(newElement)
                }
            }
        }
    }
    return false
}

