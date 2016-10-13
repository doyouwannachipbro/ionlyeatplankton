(ns ionlyeatplankton.runner-spec
  (:use [speclj.core]
        [ionlyeatplankton.runner]))

(describe "Runner"

  (it "can play through a game with an X winner"
    (should-contain "X is the winner!" (with-in-str "1\n1\n4\n2\n5\n3\nn\n" (with-out-str (start)))))

  (it "can play through a game with an O winner"
    (should-contain "O is the winner!" (with-in-str "1\n1\n4\n2\n5\n8\n6\nn\n" (with-out-str (start)))))

  (it "can play through a game to a draw"
    (should-contain "It's a draw!" (with-in-str "1\n1\n4\n2\n5\n6\n3\n9\n8\n7\nn\n" (with-out-str (start)))))

  (it "can play through a game twice"
    (should-contain "Game is restarting..." (with-in-str "1\n1\n4\n2\n5\n3\ny\n1\n1\n4\n2\n5\n3\nn\n" (with-out-str (start))))))
