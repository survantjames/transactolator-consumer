(ns transactolator-tester.core
  (:require
   [ring.adapter.jetty :refer [run-jetty]]
   [compojure.core :refer [GET]]
   [hiccup.core :refer [html h]]
   [datomic.api :as d]))

(defonce config (atom {}))

(defn home []
  (let [turi (:datomic-uri @config)]
    ;; show that it works in the logs
    (println "the datomic conn str is:")
    (println (:datomic-uri @config))
    (if (d/create-database turi)
      (println "created the datomic db")
      (println "connecting to an extant datomic db"))
    (swap! config assoc
           :datomic-conn (d/connect turi))
    (println "the conn itself is:")
    (println (:datomic-conn @config))
    ;; show that it works in the browser
    (html
     [:html
      [:body
       [:head
        [:link
         {:type "text/css" :rel "stylesheet"
          :href "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"}]]
       [:div {:class "container"}
        [:p (str @config)]]]])))

(def handler
  (GET "/" req
       {:status 200
        :body (home)}))

(defn prod []
  (let [turi  (format "datomic:sql://my-db?%s"
                      (System/getenv
                       "TRANSACTOLATOR_TRANSACTOR_URI"))]
    (swap! config assoc
           :datomic-uri turi))
  (run-jetty #'handler {:port (Integer/parseInt (System/getenv "PORT")) :join? false}))

(defn -main []
  (prod))
