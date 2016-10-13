(ns ionlyeatplankton.computer-spec
  (:use [speclj.core]
        [ionlyeatplankton.computer]
        [ionlyeatplankton.board]))

(describe "Computer"

  (it "can make a move"
    (should= 0 (get-best-move (create-board 3)))))
