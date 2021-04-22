(defproject example-client "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.597"]
                 [thheller/shadow-cljs "2.8.77"]
                 [reagent "0.9.0-rc3"]
                 [re-frame "0.11.0-rc2"]]

  :plugins [[lein-less "1.7.5"]]

  :min-lein-version "2.5.3"

  :source-paths ["src"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]


  :less {:source-paths ["less"]
         :target-path  "resources/public/css"}

  :aliases {"dev"  ["with-profile" "dev" "run" "-m" "shadow.cljs.devtools.cli" "watch" "app"]
            "prod" ["with-profile" "prod" "run" "-m" "shadow.cljs.devtools.cli" "release" "app"]}

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "0.9.10"]]}

   :prod { }
   })
