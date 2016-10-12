(ns ionlyeatplankton.runner
  (:use [ionlyeatplankton.ui :as ui]
        [ionlyeatplankton.game :as game]
        [ionlyeatplankton.board :as board]))

(declare play-game)

(defn start []
  (ui/show-welcome)
  (ui/show-game-choice-menu)
  (let [game (create-board 3)]
    (show-winner (winner (play-game game)))))

(defn- play-game [game]
  (let [gamestate (game/game-state game)]
    (if (= :inplay gamestate)
      (do (ui/show-board game)
          (recur (board/mark game (dec (read-string (ui/get-number 9))) (current-player game))))
      (do (show-board game) game))))
