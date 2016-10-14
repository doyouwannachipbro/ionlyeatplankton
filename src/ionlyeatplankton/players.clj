(ns ionlyeatplankton.players
  (:require [ionlyeatplankton.ui :as ui :refer [get-move]]
            [ionlyeatplankton.computer :as ai :refer [get-best-move]]))

(def human ui/get-move)
(def computer ai/get-best-move)

(defn choose-game [selection]
  (case selection
    1 [human human]
    2 [human computer]
    3 [computer human]
    4 [computer computer]))
