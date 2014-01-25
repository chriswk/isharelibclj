(ns isharelib.models.movie
  (:use [environ.core])
  (:require [isharelib.config :as config]
            [clojurewerkz.neocons.rest :as nr]
            [clojurewerkz.neocons.rest.labels :as nl]
            [clojurewerkz.neocons.rest.nodes :as nn]
            [clojurewerkz.neocons.rest.relationships :as rel]
            [clojurewerkz.neocons.rest.cypher :as cypher]
            [isharelib.log :as log]))

(defn conn []
  (nr/connect! config/neo4j-url))

(defn all []
  (conn)
  (log/debug "Performing all query")
  (cypher/tquery "MATCH (f:Movie) return f")
  )

(defn delete [id]
  (conn)
  (nn/destroy (nn/get id)))
