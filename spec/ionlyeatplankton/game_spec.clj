(ns ionlyeatplankton.game-spec
  (:use [speclj.core]
        [ionlyeatplankton.board]
        [ionlyeatplankton.game]))

(describe "Game"
  (it "knows the current player is X for a new game"
    (should= X (current-player (create-game (create-board 3)))))

  (it "knows the current player is X during gameplay"
    (should= X (current-player (create-game [X O O
                                             ? ? X
                                             X O ?]))))

  (it "knows the current player is O during gameplay"
    (should= O (current-player (create-game [X O ?
                                             ? ? X
                                             X O ?]))))

  (it "knows when the game has a winner"
    (should= :winner (game-state (create-game [X X X
                                               O O ?
                                               ? ? ?]))))

  (it "knows when the game is winner on a full board"
    (should= :winner (game-state (create-game [X X O
                                               O X O
                                               X O X]))))

  (it "knows when the game is draw"
    (should= :draw (game-state (create-game [X X O
                                             O O X
                                             X X O]))))

  (it "knows when the game is inplay"
    (should= :inplay (game-state (create-game [X X ?
                                               O O ?
                                               ? ? ?])))))
