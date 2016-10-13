(ns ionlyeatplankton.computer-spec
  (:use [speclj.core]
        [ionlyeatplankton.computer]
        [ionlyeatplankton.board]))

(describe "Computer"

  (it "will choose a corner if the board is empty"
    (should (contains? #{0 2 6 8} (get-best-move (create-board 3) O))))

  (it "will make simple move to stop win"
    (should= 8 (get-best-move [X O X
                               ? O X
                               O X ?] O)))

  (it "will play center if first player took a corner"
    (should= 4 (get-best-move [X ? ?
                               ? ? ?
                               ? ? ?] O)))

  (it "will win game if option is available"
    (should= 1 (get-best-move [X ? X
                               O O ?
                               ? ? ?] X)))

  (it "will stop game win if option is available"
    (should= 2 (get-best-move [? X ?
                               ? ? X
                               O O X] O)))

  (it "will prevent diagonal fork"
    (should= 2 (get-best-move [O ? ?
                               ? X ?
                               ? ? X] O)))

  (it "will prevent alternate diagonal fork"
    (should= 4 (get-best-move [X ? ?
                               ? ? O
                               ? ? X] O)))

  (it "will prevent edge trap"
    (should= 0 (get-best-move [? X ?
                               X O ?
                               ? ? ?] O)))

  (it "will prevent reverse edge trap"
    (should= 2 (get-best-move [? ? ?
                               ? O X
                               ? X ?] O))))
