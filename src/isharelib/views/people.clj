(ns isharelib.views.people
  (:use [hiccup.core :only (html)]
        [hiccup.form :only (form-to label text-field submit-button hidden-field)])
  (:require [isharelib.views.layout :as layout]
            ))


(defn display-person [p]
  (html
    [:div (:name p)]
    [:div [:img {:src (:image p)}]]))

(defn display-people [people]
  (html
    [:div
     (map (fn [p] (display-person p)) people)])
  )

(defn search [people]
  (layout/common "People"
    (display-people people)
    [:div {:class "clear"}]
    [:div
     [:a {:href "/people/new"} "New Person"]]))