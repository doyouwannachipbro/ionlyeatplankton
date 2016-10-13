(ns ionlyeatplankton.runner-spec
  (:use [speclj.core]
        [ionlyeatplankton.runner]))

(describe "Runner"

  (it "can play through a game"
    (should-contain "X is the winner!" (with-in-str "1\n1\n4\n2\n5\n3\nn\n" (with-out-str (start)))))

  (it "can play through a game twice"
    (should-contain "Game is restarting..." (with-in-str "1\n1\n4\n2\n5\n3\ny\n1\n1\n4\n2\n5\n3\nn\n" (with-out-str (start))))))
