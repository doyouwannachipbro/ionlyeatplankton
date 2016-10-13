(ns ionlyeatplankton.players-spec
  (:use [speclj.core])
  (:require [ionlyeatplankton.players :refer :all]))

(describe "Players"

  (it "can create a human vs human game"
    (should= [human human] (choose-game 1)))

  (it "can create a human vs computer game"
    (should= [human computer] (choose-game 2)))

  (it "can create a computer vs human game"
    (should= [computer human] (choose-game 3)))

  (it "can create a computer vs computer game"
    (should= [computer computer] (choose-game 4))))
