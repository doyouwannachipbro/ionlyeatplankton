(ns ionlyeatplankton.ui-spec
  (:use [speclj.core]
        [ionlyeatplankton.board]
        [ionlyeatplankton.ui]))

(describe "UI"

  (it "produces a welcome message"
    (should= "Welcome to TicTacToe\n" (with-out-str (show-welcome))))

  (it "shows the game choice menu"
    (should= (str "Please choose the game type:\n"
                  "1) Human vs Human\n"
                  "2) Human vs Computer\n"
                  "3) Computer vs Human\n"
                  "4) Computer vs Computer\n")
             (with-out-str (show-game-choice-menu))))

  (it "shows an invalid selection message"
    (should= "Please make a selection from the options presented\n"
             (with-out-str (show-invalid-selection))))

  (it "takes a number from a player"
    (should= 1 (with-in-str "1" (get-number 2))))

  (it "rejects a letter from a player"
    (should= "Please make a selection from the options presented\n"
             (with-out-str (with-in-str "a" (get-number 2)))))

  (it "rejects a long from a player"
    (should= "Please make a selection from the options presented\n"
             (with-out-str (with-in-str "12039857120349851203945712039481239847" (get-number 2)))))

  (it "rejects a nonsense sentence from a player"
    (should= "Please make a selection from the options presented\n"
             (with-out-str (with-in-str "asd;lfkj p29308t5  kljwbdfa7r5  2khj" (get-number 2)))))

  (it "prompts the user to make a move"
    (should= "Mark the board by selecting a number from 1-9\n"
             (with-out-str (show-move-instructions))))

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
                                                 X ? ?]))))))
