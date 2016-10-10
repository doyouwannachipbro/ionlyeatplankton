(ns ionlyeatplankton.board-spec
  (:use [speclj.core]
        [ionlyeatplankton.board]))

(describe "Board"
  (it "a new board of width 3 has a size 9"
    (should= 9 (size (create-board 3))))

  (it "a new board of width 4 has a size 16"
    (should= 16 (size (create-board 4))))

  (it "knows its width"
    (should= 3 (width (create-board 3))))

  (it "can be marked with X"
    (let [marked-board (to-vector (mark 3 X (create-board 3)))]
      (should= :X (.mark (get marked-board 3)))))

  (it "can be marked with O"
    (let [marked-board (to-vector (mark 3 O (create-board 3)))]
      (should= :O (.mark (get marked-board 3))))))
