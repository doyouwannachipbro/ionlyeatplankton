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

  (defn get-board [game]
    (to-vector (.board game)))

  (with-stubs)

  (around [it]
    (with-redefs [ui/get-move (stub :get-move {:return 3})
                  ai/get-best-move (stub :get-best-move {:return 0})]
      (it)))

  ; move functions need to be explicitly named for these tests, otherwise stubs do not work.

  (it "can be create with a board size and player match up"
    (let [game (create-game 3 1)]
    (should= [human human] (.move-functions game))
    (should= [? ? ? ? ? ? ? ? ?] (.board game))))

  (it "will prompt for a human move"
    (take-turn (Game. (create-board 3) [ui/get-move ui/get-move]))
    (should-have-invoked :get-move {:times 1}))

  (it "will initiate a computer move"
    (take-turn (Game. (create-board 3) [ai/get-best-move ui/get-move]))
    (should-have-invoked :get-best-move {:times 1}))

  (it "marks the board with X for the first move"
    (should= [? ? ?
              X ? ?
              ? ? ?] (get-board (take-turn (Game. (create-board 3) [ui/get-move ui/get-move])))))

  (it "knows the current player is X during gameplay"
    (should= [X O O
              X ? X
              X O ?] (get-board (take-turn (Game. (make-board [X O O
                                                               ? ? X
                                                               X O ?]) [ui/get-move ui/get-move])))))

  (it "knows the current player is O during gameplay"
    (should= [X O ?
              O ? X
              X O ?] (get-board (take-turn (Game. (make-board [X O ?
                                                               ? ? X
                                                               X O ?]) [ui/get-move ui/get-move]))))))

