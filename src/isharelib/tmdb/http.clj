(ns isharelib.tmdb.http
  (:require [clj-http.client :as client]
            [isharelib.tmdb.config :as config]
            [clj-json [core :as json]]))

(defn people-search [name]
  (json/parse-string (:body (client/get config/people-search-url {:accept :json :query-params {"query" name "api_key" config/tmdb-api-key}})))
  )

(defn movie-search [title]
  (json/parse-string (:body (client/get config/movies-search-url {:accept :json :query-params {"query" title "api_key" config/tmdb-api-key}}))))

(def configuration
  (json/parse-string (:body (client/get config/configuration-url {:accept :json :query-params {"api_key" config/tmdb-api-key}}))))

(def image-url (str (get (get configuration "images") "base_url")))

(defn image [size file-path]
  (str image-url size file-path))