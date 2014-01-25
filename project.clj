(defproject isharelib "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/tools.logging "0.2.6"]
                 [ch.qos.logback/logback-classic "1.0.13"]
                 [me.moocar/logback-gelf "0.9.6p2"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.4"]
                 [clojurewerkz/neocons "2.0.0"]
                 [clj-time "0.6.0"]
                 [environ "0.4.0"]
                 [clj-http "0.7.8"]
                 [clj-json "0.5.3"]
                 [clj-webjars "0.9.0"]
                 [org.webjars/bootstrap "3.0.3"]
                 [org.webjars/jquery "2.1.0"]
                 ]
  :plugins [[lein-ring "0.8.10"]
            [lein-environ "0.4.0"]]
  :ring {:handler isharelib.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.5"]]}})
