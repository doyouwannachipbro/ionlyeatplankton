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
             (with-out-str (show-game-choice-menu))))

  (it "will show an invalid selection message"
    (should= "Please make a selection from the options presented\n"
             (with-out-str (show-invalid-selection))))

  (it "will take a number from a player"
    (should= "1" (with-in-str "1" (get-number 2))))

  (it "will reject a letter from a player"
    (should= "Please make a selection from the options presented\n"
             (with-out-str (with-in-str "a" (get-number 2)))))

  (it "will reject a long from a player"
    (should= "Please make a selection from the options presented\n"
             (with-out-str (with-in-str "12039857120349851203945712039481239847" (get-number 2)))))

  (it "will reject a nonsense sentence from a player"
    (should= "Please make a selection from the options presented\n"
             (with-out-str (with-in-str "asd;lfkj p29308t5  kljwbdfa7r5  2khj" (get-number 2))))))

