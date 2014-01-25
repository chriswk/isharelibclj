(ns isharelib.views.movies
  (:use [hiccup.core :only (html)]
        [hiccup.form :only (form-to label text-field submit-button hidden-field)])
  (:require [isharelib.views.layout :as layout]
            [isharelib.models.movie :as movie]
            [isharelib.log :as log]))

(defn delete-movie-link [id]
  (html [:form {:method "post" :action (str "/movie/" id) :class "button_to"}
         (hidden-field "_method" "DELETE")
         (submit-button {:class "destroy" :data-confirm "Are you sure?"} "Delete")]))

(defn display-movie [movie]
  (log/debug movie)
  (let [data (get (get movie "movie") :data)
        tmdbid (get data :tmdbid)
        title (get data :title)
        releaseDate (get data :releaseDate)]
    (log/debug data)
    (log/debug tmdbid)
    (html
      [:tr
       [:td tmdbid]
       [:td title]
       [:td releaseDate]
       [:td
        [:a {:href (str "/movies/" tmdbid)} "Show"]]
       [:td
        [:a {:href (str "/movies/" tmdbid "/edit") } "Edit"]]
       [:td (delete-movie-link tmdbid)]]
      )))

(defn display-movies [movies]
  (html
    [:h1 "Listing movies"]
    [:table.table.table-striped
     [:thead
      [:tr
       [:th "Id"]
       [:th "Title"]
       [:th "Release date"]
       [:th]
       [:th]
       [:th]]]
     [:tbody
      (map display-movie movies)]]
    ))

(defn form []
  (html
    [:div#movie-form.form.form-stacked
     (form-to [:post "/movies"]
       (label "tmdbid" "TMDB id")
       (text-field "tmdbid")
       [:br]
       (submit-button {:id "movieAdd"} "Add it"))]
    [:div#movies]))

(defn new-movie []
  (layout/common "Editing Movie"
    (form)))


(defn movie [m]
  [:div
   [:h2 (:title m)]
   [:div.image
    [:img {:src (:image m)}]
    ]])

(defn movies [movies]
  (layout/common "Movies"
    (map movie movies)))

(defn index [movies]
  (layout/common "Movies"
    (display-movies movies)
    [:div {:class "clear"}]
    [:div
     [:a {:href "/movies/new"} "New Movie"]]))