(ns ionlyeatplankton.board-spec
  (:require [speclj.core :refer :all]
            [ionlyeatplankton.board :refer :all]))

(describe "Board"
  (it "a new board of width 3 has a size 9"
    (should= 9 (size (create-board 3))))

  (it "a new board of width 4 has a size 16"
    (should= 16 (size (create-board 4)))))
