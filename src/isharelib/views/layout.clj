(ns isharelib.views.layout
  (:use [environ.core]
        [hiccup.core :only (html)]
        [hiccup.page :only (html5 include-css include-js)]
        )
  (:require [isharelib.tmdb.config :as tmdb-config]))

(defn topbar []
  (html [:div.navbar.navbar-inverse.navbar-fixed-top
         [:div.navbar-inner
          [:div.container-fluid
           [:a {:href "/" :class "brand"} "Isharelib"]
           [:ul.nav
            [:li
             [:a {:href "/movies"} "Movies"]]
            [:li
             [:a {:href "/people"} "People"]]
            [:li.divider-vertical]
            ]]]])
  )

(defn sidebar []
  (html [:div.well.sidebar-nav
         [:ul.nav.nav-list
          [:li.nav-header "Isharelib"]
          [:li
           [:a {:href "/movies"} "Movies"]]
          [:li
           [:a {:href "/people"} "People"]]
          [:li
           [:a {:href "/countries"} "Countries"]]
          ]]))

(defn footer []
  (html [:footer "&copy; ISharelib 2013"]))

(defn meta-tags []
  (html [:meta {:charset "utf-8"}]
    [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
    [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]))

(defn styles []
  (include-css "/assets/css/bootstrap.min.css"
    "/css/isharelib.css"))

(defn javascript []
  (html (include-js "/assets/js/jquery.min.js"
          "/assets/js/bootstrap.min.js")))

(defn tmdbApi []
  [:script {:type "text/javascript"}
   "var ISharelib = ISharelib || {};
    ISharelib.api_key = \"" tmdb-config/tmdb-api-key "\";"
   ])

(defn common [title & body]
  (html5
    [:head
     (meta-tags)
     (styles)
     [:title title]]
    [:body
     (topbar)
     [:div.container-fluid
      [:div.row-fluid
       [:div.span2
        (sidebar)]
       [:div.span10
        body]
       [:hr]
       (footer)
       ]]
     (tmdbApi)
     (javascript)]))

(defn four-oh-four []
  (common "Page Not Found"
    [:div {:id "four-oh-four"}
     "The page you requested could not be found"]))