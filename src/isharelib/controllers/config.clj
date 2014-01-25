(ns isharelib.controllers.config
  (:use [compojure.core]
        [isharelib.helpers.json])
  (:require [isharelib.config :as config]
            [isharelib.tmdb.http :as tmdb]))

(defroutes app-routes
  (GET "/config" [] (json-response (config/all)))
  (GET "/tmdbconfig" [] (json-response (tmdb/configuration)))
  (GET "/image" [] (json-response (tmdb/image "500w" "path"))))