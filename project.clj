(defproject ionlyeatplankton "0.1.0-SNAPSHOT"
  :description "TicTacToe in Clojure"
  :url "www.github.com/doyouwannachipbro/ionlyeatplankton"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0-RC2"]
                 [org.clojure/math.numeric-tower "0.0.4"]]
  :profiles {:dev {:dependencies [[speclj "3.3.1"]]}}
  :plugins [[speclj "3.3.1"]]
  :test-paths ["spec"]
  :main ionlyeatplankton.core
  :aot [ionlyeatplankton.core])
