(ns ionlyeatplankton.board-spec
  (:use [speclj.core]
        [ionlyeatplankton.board]))

(describe "Board"
  (it "knows its size"
    (should= 9 (size (create-board 3))))

  (it "knows its width"
    (should= 3 (width (create-board 3))))

  (it "can be marked with X"
    (let [marked-board (to-vector (mark 3 X (create-board 3)))]
      (should= :X (.mark (get marked-board 3)))))

  (it "can be marked with O"
    (let [marked-board (to-vector (mark 3 O (create-board 3)))]
      (should= :O (.mark (get marked-board 3)))))

  (it "knows when it is full"
    (should (full? [X O X O X O X O X])))

  (it "knows the available moves"
    (should= [1 2 3 4 5 6 7] (available-moves [X EMPTY EMPTY
                                               EMPTY EMPTY EMPTY
                                               EMPTY EMPTY O]))))

