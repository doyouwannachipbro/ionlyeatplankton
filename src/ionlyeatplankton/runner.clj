(ns ionlyeatplankton.runner
  (:use [ionlyeatplankton.ui :as ui]
        [ionlyeatplankton.board :as board]))

(defn start []
  (ui/show-welcome)
  (ui/show-game-choice-menu)
  (ui/show-board (create-board 3)))

