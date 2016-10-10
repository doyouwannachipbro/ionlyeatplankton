(ns ionlyeatplankton.core
  (:gen-class)
  (:use [ionlyeatplankton.runner :as runner]))

(defn -main [& args]
  (runner/start))

