(ns isharelib.controllers.people
  (:use [compojure.core]
        [isharelib.helpers.json])
  (:require [clojure.string :as str]
            [ring.util.response :as ring]
            [isharelib.tmdb.http :as tmdb-query]
            [isharelib.views.people :as view]
            [clj-json [core :as json]]
            [isharelib.log :as log]))

(defn search [name]
  (map (fn [m]
         {:image (tmdb-query/image "w500" (get m "profile_path"))
          :name (get m "name")
          :id (get m "id")})
    (get (tmdb-query/people-search name) "results")))


(defroutes app-routes
  (GET "/people/search/:name/xhr" [name] (json-response (search name)))
  (GET "/people/search/:name" [name] (view/search (search name))))