# Example client app in Re-frame compiled with Shadow-cljs.

This is a simple [re-frame](https://github.com/Day8/re-frame) application made for experiments with React,
Reagent and Re-frame libraries.

## At the start, install the following dependencies

```
npm install react
npm install react-dom
npm install create-react-class
```

or just run

```
npm install
```

Also, install Shadow-cljs compiler by running:

```
npm install -g shadow-cljs
```

## How to run

Set autorecompilation of LESS into CSS:

```
lein less auto
```

Then run Shadow-cljs compiler:

```
shadow-cljs watch client
```

Wait a bit, then browse to [http://localhost:3000](http://localhost:3000).
And connect to the nREPL server running on the port 9000. Changed in the code
or via REPL immediately propagate into the running instance.

## Project structure

All the code is placed under `src/example_client`.

LESS files (which are compiled into CSS) are in `less` directory.

Static resources are placed in `resources` directory. It contains fixed HTML file served by the Webserver
created by Shadow-cljs and compiled js and css files.
