(ns ionlyeatplankton.game-spec
  (:use [speclj.core]
        [ionlyeatplankton.board]
        [ionlyeatplankton.game]))

(describe "Game"
  (it "knows the current player is X for a new game"
    (should= X (current-player (create-game (create-board 3)))))

  (it "knows the current player is X during gameplay"
    (should= X (current-player (create-game [X O O EMPTY EMPTY X X O EMPTY]))))

  (it "knows the current player is O during gameplay"
    (should= O (current-player (create-game [X O EMPTY EMPTY EMPTY X X O EMPTY])))))

