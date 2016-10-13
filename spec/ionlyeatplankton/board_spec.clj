(ns ionlyeatplankton.board-spec
  (:use [speclj.core]
        [ionlyeatplankton.board]))

(describe "Board"

  (defn make-board [board]
    board)

  (it "knows its size"
    (should= 9 (size (create-board 3))))

  (it "knows its width"
    (should= 3 (width (create-board 3))))

  (it "can be marked with X"
    (let [marked-board (to-vector (mark (create-board 3) 3 X))]
      (should= :X (.mark (get marked-board 3)))))

  (it "can be marked with O"
    (let [marked-board (to-vector (mark (create-board 3) 3 O))]
      (should= :O (.mark (get marked-board 3)))))

  (it "knows when it is full"
    (should (full? (make-board [X O X O X O X O X]))))

  (it "knows when it is not full"
    (should-not (full? (make-board [X O X ? X O X O X]))))

  (it "knows the available moves"
    (should= [1 2 3 4 5 6 7] (available-moves (make-board [X ? ?
                                                           ? ? ?
                                                           ? ? O]))))

  (it "returns the winner if there is one on a row"
    (should= X (winner (make-board [X X X
                                    ? ? ?
                                    ? ? ?]))))

  (it "returns the winner if there is one the second row"
    (should= O (winner (make-board [? ? ?
                                    O O O
                                    ? ? ?]))))

  (it "returns the winner if there is one on the third row"
    (should= O (winner (make-board [? ? ?
                                    ? ? ?
                                    O O O]))))

  (it "returns the winner if there is one on a column"
    (should= X (winner (make-board [X ? ?
                                    X ? ?
                                    X ? ?]))))

  (it "returns the winner if there is one the second column"
    (should= O (winner (make-board [? O ?
                                    ? O ?
                                    ? O ?]))))

  (it "returns the winner if there is one on the third column"
    (should= X (winner (make-board [? ? X
                                    ? ? X
                                    ? ? X]))))

  (it "returns the winner if there is one on the left diagonal"
    (should= X (winner (make-board [X ? ?
                                    ? X ?
                                    ? ? X]))))

  (it "returns the winner if there is one on the right diagonal"
    (should= O (winner (make-board [? ? O
                                    ? O ?
                                    O ? ?]))))

  (it "returns :no-winner if no winner when in play"
    (should= :no-winner (winner (make-board [X X ?
                                             O O ?
                                             ? ? ?]))))

  (it "returns :no-winner if no winner in new game"
    (should= :no-winner (winner (create-board 4))))

  (it "knows when X is the winner"
    (should= :winner (state (make-board [X X X
                                         O O ?
                                         ? ? ?]))))

  (it "knows when X is the winner on a full board"
    (should= :winner (state (make-board [X X O
                                         O X O
                                         X O X]))))

  (it "knows when O is the winner"
    (should= :winner (state (make-board [X X ?
                                         O O O
                                         ? X ?]))))

  (it "knows when the game is draw"
    (should= :draw (state (make-board [X X O
                                       O O X
                                       X X O]))))

  (it "knows when the game is inplay"
    (should= :inplay (state (make-board [X X ?
                                         O O ?
                                         ? ? ?])))))
