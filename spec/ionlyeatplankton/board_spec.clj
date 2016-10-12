(ns ionlyeatplankton.board-spec
  (:use [speclj.core]
        [ionlyeatplankton.board]))

(describe "Board"
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
    (should (full? [X O X O X O X O X])))

  (it "knows the available moves"
    (should= [1 2 3 4 5 6 7] (available-moves [X EMPTY EMPTY
                                               EMPTY EMPTY EMPTY
                                               EMPTY EMPTY O])))

  (it "returns the winner if there is one on a row"
    (should= X (winner [X X X
                        EMPTY EMPTY EMPTY
                        EMPTY EMPTY EMPTY])))

  (it "returns the winner if there is one the second row"
    (should= O (winner [EMPTY EMPTY EMPTY
                        O O O
                        EMPTY EMPTY EMPTY])))

  (it "returns the winner if there is one on the third row"
    (should= O (winner [EMPTY EMPTY EMPTY
                        EMPTY EMPTY EMPTY
                        O O O])))

  (it "returns the winner if there is one on a column"
    (should= X (winner [X EMPTY EMPTY
                        X EMPTY EMPTY
                        X EMPTY EMPTY])))

  (it "returns the winner if there is one the second column"
    (should= O (winner [EMPTY O EMPTY
                        EMPTY O EMPTY
                        EMPTY O EMPTY])))

  (it "returns the winner if there is one on the third column"
    (should= X (winner [EMPTY EMPTY X
                        EMPTY EMPTY X
                        EMPTY EMPTY X])))

  (it "returns the winner if there is one on the left diagonal"
    (should= X (winner [X EMPTY EMPTY
                        EMPTY X EMPTY
                        EMPTY EMPTY X])))

  (it "returns the winner if there is one on the right diagonal"
    (should= O (winner [EMPTY EMPTY O
                        EMPTY O EMPTY
                        O EMPTY EMPTY])))

  (it "returns :no-winner if no winner on any row"
    (should= :no-winner (winner [X X EMPTY
                                 O O EMPTY
                                 EMPTY EMPTY EMPTY]))))
