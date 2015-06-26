# ##############################################################################
# Field definitions (values):
# _ - empty cell
# w - white men
# W - white king
# b - black men
# B - black king
#
# Position notation:
# - letter (a, b, c, ...) number (1, 2, 3, ...)
#
# Game structure:
# - board[8][8]
# - whiteMans list of positions
# - whiteKings list of positions
# - blackMans list of positions
# - blackKings list of positions
#
# ##############################################################################

from sys import stdout

def printTheBoard(board):
    for lineno in range(len(board) - 1, -1, -1):
        line = board[lineno]
        stdout.write(str(lineno + 1))
        stdout.write("|")
        for cellno in range(0, len(line)):
            cell = line[cellno]
            stdout.write(" ")
            if lineno % 2:
                stdout.write("  ")
            stdout.write(cell)
            if not (lineno % 2):
                stdout.write("  ")
        print
    print " +----------------"
    print "   a b c d e f g h "

def positionToRowIndex(position):
    return int(position[1]) - 1

def positionToColIndex(position):
    return int(ord(position[0]) - 97)

def setTheCell(board, position, value):
    row = positionToRowIndex(position)
    col = positionToColIndex(position)
    board[row][col] = value
    
def createEmptyBoard():
    board = []
    for i in range(0,8):
        board.append(["_", "_", "_", "_", "_", "_", "_", "_"])
    return board

def createEmptyGame():
    return {
        "board": createEmptyBoard(),
        "whiteMans" : (),
        "whiteKings": (),
        "blackMans": (),
        "blackKings": ()
        }

def createInitialBoard():
    board = createEmptyBoard()
    for i in ("a", "c", "e", "g"):
        setTheCell(board, i + "1", "w")
        setTheCell(board, i + "3", "w")
        setTheCell(board, i + "7", "b")
    for i in ("b", "d", "f", "h"):
        setTheCell(board, i + "2", "w")
        setTheCell(board, i + "6", "b")
        setTheCell(board, i + "8", "b")
    return board

def isRowColValid(row, col):
    if(row >= 0 and row < 8 and col >=0 and col < 8):
        if((1 + row + col) % 2):
            return True
    return False

def isPositionValid(position):
    row = positionToRowIndex(position)
    col = positionToColIndex(position)
    return isRowColValid(row, col)

def whoCanMove(board, color):
    """Return the list of possible moves"""
    nope

def main():
    """Main fucnction"""
    print "Hello, chess"
    board = createInitialBoard()
    printTheBoard(board)
    print "a1 = %d %d" % (positionToRowIndex("a1"), positionToColIndex("a1"))
    print "a2 = %d %d" % (positionToRowIndex("a2"), positionToColIndex("a2"))
    print "b1 = %d %d" % (positionToRowIndex("b1"), positionToColIndex("b1"))
    print "b2 = %d %d" % (positionToRowIndex("b2"), positionToColIndex("b2"))
    print "d2 is valid %d" % (isPositionValid("d2"),)
    print "d3 is valid %d" % (isPositionValid("d3"),)
    g = createEmptyGame()
    printTheBoard(g["board"])

if __name__ == "__main__":
    """Entry point"""
    main()
