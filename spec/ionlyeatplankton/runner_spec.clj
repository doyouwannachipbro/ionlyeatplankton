(ns ionlyeatplankton.runner-spec
  (:use [speclj.core]
        [ionlyeatplankton.runner]))

(describe "Runner"

  (it "can start a game"
    (should-contain "Welcome to TicTacToe" (with-out-str (start)))))
