(ns isharelib.handler
  (:use [compojure.core]
        [hiccup.page :only (html5)]
        [ring.middleware params
         keyword-params
         nested-params
         multipart-params
         cookies
         session
         flash]
        [clj-webjars])
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [isharelib.controllers.movies :as movies]
            [isharelib.controllers.people :as people]
            [isharelib.controllers.config :as isharelib-config]
            [isharelib.views.layout :as layout]))

(defn index []
  (html5 [:head [:title "Isharelib"]]
         [:body
            [:div {:id "content"} "Hello world"]]))

(defroutes app-routes
  movies/app-routes
  people/app-routes
  isharelib-config/app-routes
  (route/resources "/")
  (route/not-found (layout/four-oh-four)))

(refresh-assets!)

(def app
  (-> (handler/api app-routes)
      (wrap-multipart-params)
      (wrap-flash)
      (wrap-webjars)
      (wrap-session)))
