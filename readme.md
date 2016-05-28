# Tic Tac Toe Tomek
https://code.google.com/codejam/contest/2270488/dashboard

Tic-Tac-Toe-Tomek is a game played on a 4 x 4 square board. The board starts empty, except that a single 'T' symbol may appear in one of the 16 squares. There are two players: X and O. They take turns to make moves, with X starting. In each move a player puts her symbol in one of the empty squares. Player X's symbol is 'X', and player O's symbol is 'O'.

After a player's move, if there is a row, column or a diagonal containing 4 of that player's symbols, or containing 3 of her symbols and the 'T' symbol, she wins and the game ends. Otherwise the game continues with the other player's move. If all of the fields are filled with symbols and nobody won, the game ends in a draw. See the sample input for examples of various winning positions.

Given a 4 x 4 board description containing 'X', 'O', 'T' and '.' characters (where '.' represents an empty square), describing the current state of a game, determine the status of the Tic-Tac-Toe-Tomek game going on. The statuses to choose from are:

* "X won" (the game is over, and X won)
* "O won" (the game is over, and O won)
* "Draw" (the game is over, and it ended in a draw)
* "Game has not completed" (the game is not over yet)

If there are empty cells, and the game is not over, you should output "Game has not completed", even if the outcome of the game is inevitable.

## compile
    mvn package

## test
    mvn test

## run
    cat samples/A-small-practice.in |java -cp target/TicTacToeTomek-1.0.jar fsoc.TicTacToeTomek
