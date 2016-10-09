(ns ionlyeatplankton.board-spec
  (:require [speclj.core :refer :all]
            [ionlyeatplankton.board :refer :all]))

(describe "Board"
  (it "a new board of width 3 has a size 9"
    (should= 9 (size (create-board 3)))))
