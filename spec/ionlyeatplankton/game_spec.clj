(ns ionlyeatplankton.game-spec
  (:use [speclj.core]
        [ionlyeatplankton.board]
        [ionlyeatplankton.players]
        [ionlyeatplankton.ui :as ui]
        [ionlyeatplankton.game])
  (:import (ionlyeatplankton.game Game)))

(describe "Game"

  (with-stubs)

  (around [it]
    (with-redefs [ui/get-number (stub :get-number {:return 1})]
      (it)))

  (it "knows the current player is X for a new game"
    (should= X (current-player (Game. (create-board 3) [human human]))))

  (it "knows the current player is X during gameplay"
    (should= X (current-player (Game. [X O O
                                       ? ? X
                                       X O ?] [human human]))))

  (it "knows the current player is O during gameplay"
    (should= O (current-player (Game. [X O ?
                                       ? ? X
                                       X O ?] [human human]))))

  (it "knows when X is the winner"
    (should= :winner (game-state (Game. [X X X
                                         O O ?
                                         ? ? ?] [human human]))))

  (it "knows when X is the winner on a full board"
    (should= :winner (game-state (Game. [X X O
                                         O X O
                                         X O X] [human human]))))

  (it "knows when O is the winner"
    (should= :winner (game-state (Game. [X X ?
                                         O O O
                                         ? X ?] [human human]))))

  (it "knows when the game is draw"
    (should= :draw (game-state (Game. [X X O
                                       O O X
                                       X X O] [human human]))))

  (it "knows when the game is inplay"
    (should= :inplay (game-state (Game. [X X ?
                                         O O ?
                                         ? ? ?] [human human]))))

  (it "will prompt for a human move"
    (get-move (Game. (create-board 3) [human human]))
    (should-have-invoked :get-number {:times 1})))
