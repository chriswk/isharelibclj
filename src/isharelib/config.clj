(ns isharelib.config
  (:use [environ.core])
  (:require [isharelib.tmdb.config :as tmdb-config]))

(def neo4j-url (or (env :neo4j-url) "http://localhost:7474/db/data"))

(def neo4j-user (or (env :neo4j-user) ""))

(def neo4j-password (or (env :neo4j-password) ""))

(defn tmdb []
  {:api-key tmdb-config/tmdb-api-key
   :base-url tmdb-config/tmdb-base-url
   :search-base-url tmdb-config/tmdb-search-base-url
   :people-search-url tmdb-config/people-search-url
   :person-url tmdb-config/person-url
   :movies-search-url tmdb-config/movies-search-url
   :movie-url tmdb-config/movie-url
   :series-search-url tmdb-config/series-search-url
   :series-url tmdb-config/series-url})

(defn all []
  { :neo4j-url (neo4j-url)
    :neo4j-user (neo4j-user)
    :neo4j-password (neo4j-password)
    :tmdb (tmdb)})