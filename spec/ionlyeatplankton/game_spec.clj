(ns ionlyeatplankton.game-spec
  (:use [speclj.core])
  (:require [ionlyeatplankton.board :refer :all]
            [ionlyeatplankton.players :refer :all]
            [ionlyeatplankton.ui :as ui :refer :all]
            [ionlyeatplankton.computer :as ai :refer :all]
            [ionlyeatplankton.game :refer :all])
  (:import [ionlyeatplankton.game Game]))

(describe "Game"

  (defn make-board [board]
    board)

  (with-stubs)

  (around [it]
    (with-redefs [ui/get-move (stub :get-move {:return 1})
                  ai/get-best-move (stub :get-best-move {:return 0})]
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

  ; functions need to be explicitly named for these test, otherwise stubs do not work.

  (it "will prompt for a human move"
    (take-turn (Game. (create-board 3) [ui/get-move ui/get-move]))
    (should-have-invoked :get-move {:times 1}))

  (it "will initiate a computer move"
    (take-turn (Game. (create-board 3) [ai/get-best-move ui/get-move]))
    (should-have-invoked :get-best-move {:times 1})))
