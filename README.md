# isharelib

Trying Neo4j compojure+ring+hiccup experiment

## Prerequisites

You will need [Leiningen][1] 2.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Running

* NEO
    * You'll need a local Neo4j server running at localhost:7474
    * alternately set up {:env {:neo4j-url "URL_TO_NEO4J REST endpoint"}} in .lein-env or USER_HOME/profiles.clj
    * or set a system variable NEO4J_URL which points to the NEO4J REST endpoint

* TMDB
    * set {:env {:tmdb-api-key "YOURAPIKEY"}} in .lein-env or USER_HOME/profiles.clj
    * or set a system variable TMDB_API_KEY to your api key

To start a web server for the application, run:

    lein ring server

## License
[Eclipse public License v 1.0][2]
[2]: http://www.eclipse.org/legal/epl-v10.html
Copyright © 2014 Christopher Kolstad