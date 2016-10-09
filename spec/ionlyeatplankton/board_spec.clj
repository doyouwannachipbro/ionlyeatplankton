(ns ionlyeatplankton.board-spec
  (:require [speclj.core :refer :all]
            [ionlyeatplankton.board :refer :all]))

(describe "Board"
  (it "a new board is empty"
    (should= true (empty? (create-board 3)))))
