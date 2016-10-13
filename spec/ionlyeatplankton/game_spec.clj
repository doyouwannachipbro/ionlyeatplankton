(ns ionlyeatplankton.game-spec
  (:use [speclj.core])
  (:require [ionlyeatplankton.board :refer :all]
            [ionlyeatplankton.players :refer :all]
            [ionlyeatplankton.ui :refer :all]
            [ionlyeatplankton.game :refer :all])
  (:import (ionlyeatplankton.game Game)))

(describe "Game"

  (defn make-board [board]
    board)

  (with-stubs)

  (around [it]
    (with-redefs [get-number (stub :get-number {:return 1})]
      (it)))

  (it "knows the current player is X for a new game"
    (should= X (current-player (Game. (create-board 3) [human human]))))

  (it "knows the current player is X during gameplay"
    (should= X (current-player (Game. (make-board [X O O
                                                   ? ? X
                                                   X O ?]) [human human]))))

  (it "knows the current player is O during gameplay"
    (should= O (current-player (Game. (make-board [X O ?
                                                   ? ? X
                                                   X O ?]) [human human]))))

  (it "will prompt for a human move"
    (get-move (Game. (create-board 3) [human human]))
    (should-have-invoked :get-number {:times 1})))
