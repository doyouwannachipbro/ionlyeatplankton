(ns ionlyeatplankton.players
  (:require [ionlyeatplankton.ui :refer [get-move] :as ui]
            [ionlyeatplankton.computer :refer [get-best-move] :as ai]))

(def human ui/get-move)
(def computer ai/get-best-move)

(defn choose-game [selection]
  (case selection
    1 [human human]
    2 [human computer]
    3 [computer human]
    4 [computer computer]))
