(ns ionlyeatplankton.board-spec
  (:use [speclj.core]
        [ionlyeatplankton.board]))

(describe "Board"
  (it "a new board of width 3 has a size 9"
    (should= 9 (size (create-board 3))))

  (it "a new board of width 4 has a size 16"
    (should= 16 (size (create-board 4))))

  (it "knows its width"
    (should= 3 (width (create-board 3))))
  )
