(ns ionlyeatplankton.ui-spec
  (:use [speclj.core]
        [ionlyeatplankton.board]
        [ionlyeatplankton.ui]))

(describe "UI"
  (it "will show an empty 3 x 3 board"
    (should= " 1 | 2 | 3 \n-----------\n 4 | 5 | 6 \n-----------\n 7 | 8 | 9 \n"
             (with-out-str (show-board (to-vector (create-board 3))))))

  (it "will show a marked 3 x 3 board"
    (should= " X | 2 | 3 \n-----------\n 4 | O | 6 \n-----------\n 7 | 8 | 9 \n"
             (with-out-str (show-board [X 2 3 4 O 6 7 8 9])))))
