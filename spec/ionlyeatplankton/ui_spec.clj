(ns ionlyeatplankton.ui-spec
  (:use [speclj.core]
        [ionlyeatplankton.board]
        [ionlyeatplankton.ui]))

(describe "UI"
  (it "will show a 3 x 3 board"
    (should= " 1 | 2 | 3 \n-----------\n 4 | 5 | 6 \n-----------\n 7 | 8 | 9 \n"
             (with-out-str (show-board (to-vector (create-board 3)))))))
