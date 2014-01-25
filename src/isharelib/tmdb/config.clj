(ns isharelib.tmdb.config
  (:use [environ.core]))

(def tmdb-api-key
  (or (env :tmdb-api-key) "NOAPIKEYSET")
  )

(def tmdb-base-url (or (env :tmdb-api-base-url) "http://api.themoviedb.org/3"))

(def tmdb-search-base-url (str tmdb-base-url "/search"))

(def movies-search-url (str tmdb-search-base-url "/movie"))

(def people-search-url (str tmdb-search-base-url "/person"))

(def series-search-url (str tmdb-search-base-url "/tv"))

(def movie-url (str tmdb-base-url "/movie"))

(def person-url (str tmdb-base-url "/person"))

(def series-url (str tmdb-search-base-url "/tv"))

(def configuration-url (str tmdb-base-url "/configuration"))
