(ns ionlyeatplankton.ui-spec
  (:use [speclj.core]
        [ionlyeatplankton.board]
        [ionlyeatplankton.ui]))

(describe "UI"

  (it "will produce a welcome message"
    (should= "Welcome to TicTacToe\n" (with-out-str (show-welcome))))

  (it "will show the game choice menu"
    (should= (str "Please choose the game type:\n"
                  "1) Human vs Human\n"
                  "2) Human vs Computer\n"
                  "3) Computer vs Human\n"
                  "4) Computer vs Computer\n")
             (with-out-str (show-game-choice-menu)))))

