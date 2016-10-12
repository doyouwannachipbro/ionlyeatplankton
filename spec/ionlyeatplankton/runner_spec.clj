(ns ionlyeatplankton.runner-spec
  (:use [speclj.core]
        [ionlyeatplankton.runner]))

(describe "Runner"

  (it "can play through a game"
    (should-contain "X is the winner!" (with-in-str "1\n4\n2\n5\n3\n" (with-out-str (start))))))
