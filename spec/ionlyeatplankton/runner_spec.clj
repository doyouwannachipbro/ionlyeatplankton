(ns ionlyeatplankton.runner-spec
  (:use [speclj.core])
  (:require [ionlyeatplankton.computer :as ai :refer [add-delay]]
            [ionlyeatplankton.runner :refer :all]))

(describe "Runner"

  (with-stubs)

  (around [it]
    (with-redefs [ai/add-delay (stub :add-delay)] (it)))

  (it "can play through a game with an X winner"
    (should-contain "X is the winner!" (with-in-str "1\n1\n4\n2\n5\n3\nn\n" (with-out-str (start)))))

  (it "can play through a game with an O winner"
    (should-contain "O is the winner!" (with-in-str "1\n1\n4\n2\n5\n8\n6\nn\n" (with-out-str (start)))))

  (it "can play a human vs computer game"
    (should-contain "O is the winner!" (with-in-str "2\n1\n2\n4\nn\n" (with-out-str (start)))))

  (it "can play through a game to a draw"
    (should-contain "It's a draw!" (with-in-str "1\n1\n4\n2\n5\n6\n3\n9\n8\n7\nn\n" (with-out-str (start)))))

  (it "can play through a game twice"
    (should-contain "Game is restarting..." (with-in-str "1\n1\n4\n2\n5\n3\ny\n1\n1\n4\n2\n5\n3\nn\n" (with-out-str (start)))))

  (it "can play through a computer vs computer game"
    (should-contain "It's a draw!" (with-in-str "4\nn\n" (with-out-str (start))))))
