(defproject transactolator-tester "0.0.0-DEMO"
  :description "Example of how to consume the Survant James Transactolator Addon"
  :url "http://transactolator.survantjames.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [com.datomic/datomic-pro "0.9.5350" :exclusions
                  [joda-time commons-codec]]
                 [hiccup "1.0.5"]
                 [ring "1.4.0"]
                 [compojure "1.5.0" :exclusions
                  [commons-codec]]
                 [org.postgresql/postgresql "9.4.1208"]]
  :repositories
  {"my.datomic.com" {:url "https://my.datomic.com/repo"
                     :username ~(System/getenv "DATOMIC_EMAIL")
                     :password ~(System/getenv "DATOMIC_KEY")}}
  :uberjar-name "tester.jar"
  :min-lein-version "2.0.0")
