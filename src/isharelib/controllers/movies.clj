(ns isharelib.controllers.movies
  (:use [compojure.core]
        [isharelib.helpers.json])
  (:require [clojure.string :as str]
            [ring.util.response :as ring]
            [isharelib.views.movies :as view]
            [isharelib.models.movie :as model]
            [isharelib.tmdb.http :as tmdb-query]
            [clj-json [core :as json]]))

(defn index []
  (view/index (model/all)))

(defn new-movie []
  (view/new-movie))

(defn del-movie [id]
  (model/delete id)
  (ring/redirect "/movies"))

(defn search-movie [title]
  (map (fn [m]
         {:image (tmdb-query/image "w500" (get m "poster_path"))
          :title (get m "title")
          :id (get m "id")})
    (get (tmdb-query/movie-search title) "results")))

(defroutes app-routes
  (GET "/movies" [] (index))
  (GET "/movies/new" [] (new-movie))
  (GET "/movies/search/:title/xhr" [title] (json-response (search-movie title)))
  (GET "/movies/search/:title" [title] (view/movies (search-movie title)))
  (DELETE ["/movies/:id", :id #"[0-9]+"] [id] (del-movie (Integer. id)))
  (GET ["/movies/:id/delete", :id #"[0-9]+"] [id] (del-movie (Integer. id))))