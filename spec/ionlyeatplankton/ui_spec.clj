(ns ionlyeatplankton.ui-spec
  (:use [speclj.core])
  (:require [ionlyeatplankton.board :refer :all]
            [ionlyeatplankton.ui :refer :all]))

(describe "UI"

  (it "produces a welcome message"
    (should= "Welcome to TicTacToe\n\n" (with-out-str (show-welcome))))

  (it "shows the game choice menu"
    (should= (str "Please choose the game type:\n"
                  "1) Human vs Human\n"
                  "2) Human vs Computer\n"
                  "3) Computer vs Human\n"
                  "4) Computer vs Computer\n\n")
             (with-out-str (show-game-choice-menu))))

  (it "shows an invalid selection message"
    (should= "Please make a selection from the options presented\n"
             (with-out-str (show-invalid-selection))))

  (it "takes a number from a player"
    (should= 1 (with-in-str "1" (get-number 2))))

  (it "rejects a letter from a player"
    (should= "Please make a selection from the options presented\n"
             (with-out-str (with-in-str "a\n1" (get-number 2)))))

  (it "rejects a long from a player"
    (should= "Please make a selection from the options presented\n"
             (with-out-str (with-in-str "12039857120349851203945712039481239847\n1" (get-number 2)))))

  (it "rejects a nonsense sentence from a player"
    (should= "Please make a selection from the options presented\n"
             (with-out-str (with-in-str "asd;lfkj p29308t5  kljwbdfa7r5  2khj\n1" (get-number 2)))))

  (it "prompts the user to make a move"
    (should= "Mark the board by selecting a number from 1-9\n\n"
             (with-out-str (show-move-instructions 9))))

  (it "shows a draw message"
    (should= "It's a draw!\n"
             (with-out-str (show-draw))))

  (it "shows a X win message"
    (should= "X is the winner!\n"
             (with-out-str (show-winner (winner [X X X
                                                 O O ?
                                                 ? ? ?])))))

  (it "shows a O win message"
    (should= "O is the winner!\n"
             (with-out-str (show-winner (winner [X X ?
                                                 O O O
                                                 X ? ?])))))

  (it "sends a clear screen code"
    (should= "\033[H\033[2J\n"
             (with-out-str (clear-screen))))

  (it "shows a restart query message"
    (should= "Press 'y' to play again, or any other key to exit.\n"
             (with-out-str (show-restart-query))))

  (it "shows a restart confirmation message"
    (should= "Game is restarting...\n"
             (with-out-str (show-restart-confirm))))

  (it "shows a notification that the computer is making a move"
    (should= "Computer is thinking...\n"
             (with-out-str (show-computer-thinking))))

  (it "takes a letter from a player"
    (should= "y" (with-in-str "y" (get-line))))

  (it "refects a move that conflicts with a mark cell"
    (should-contain "That is not a valid move.\n"
                    (with-out-str (with-in-str "1\n5" (get-move [X X O
                                                                 ? ? ?
                                                                 ? ? ?] O)))))

  (it "takes a 1 based move from a player and converts to zero based"
    (with-out-str
      (should= 0 (with-in-str "1" (get-move (create-board 3) X))))))
