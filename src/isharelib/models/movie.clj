(ns isharelib.models.movie
  (:use [environ.core])
  (:require [isharelib.config :as config]
            [clojurewerkz.neocons.rest :as nr]
            [clojurewerkz.neocons.rest.labels :as nl]
            [clojurewerkz.neocons.rest.nodes :as nn]
            [clojurewerkz.neocons.rest.relationships :as rel]
            [clojurewerkz.neocons.rest.cypher :as cypher]
            [clojurewerkz.neocons.rest.constraints :as constraints]
            [isharelib.log :as log]
            [isharelib.helpers.json :as json]))

(defn conn []
  (nr/connect! config/neo4j-url))

(defn all []
  (conn)
  (log/debug "Performing all query")
  (cypher/tquery "MATCH (movie:Movie) return movie")
  )

(defn configure-uniqueness-on-tmdb-id []
  (conn)
  (constraints/create-unique "Movie" "tmdbid")
  )

(defn delete [id]
  (conn)
  (nn/destroy (nn/get id)))

(defn add-movie [attrs]
  (conn)
  (let [mStore (nn/create attrs)]
    (nl/add mStore "Movie"))
  )
