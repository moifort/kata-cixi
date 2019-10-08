# cixi

## Challenge

We ask you to develop a window program which builds the map according to user input and then generates the shortest track between two existing cities selected by the user. The map is made of two types of objects :
- Cities​ : A city is defined by its unique name
- Roads : A road links two existing cities, and has a given length. Note that the length is a time

metrics in the example above, but we could also have used the distance between the two cities.
When launching the program, the user gets a window interface in which he can create cities, add roads and ask for the shortest path between two created cities. Feel free to implement this interface using any kind of widget (such as text zones, buttons, lists...). As an option, you can push the UI further by drawing cities and roads, or by adding some other visual features improving the user experience.

## Requirement

* Java 11 

## Build & Run

To build the project execute in the root directory: 

```bash
./mvnw clean install
```

To run the project:

```bash
java -jar target/app-1.0.0.jar
```

Output:

```bash
   _____ _______   _______ 
  / ____|_   _\ \ / |_   _|
 | |      | |  \ V /  | |  
 | |      | |   > <   | |  
 | |____ _| |_ / . \ _| |_ 
  \_____|_____/_/ \_|_____|
                           
                           

Shortest track from Sillingy to Annecy:

[Road{from=Sillingy, to=Epagny, length=1 minute}, Road{from=Epagny, to=Metz-Tessy, length=3 minute}, Road{from=Metz-Tessy, to=Annecy, length=12 minute}]
```


## Architecture

Hexagonal Architecture,  more information [here](https://blog.octo.com/architecture-hexagonale-trois-principes-et-un-exemple-dimplementation/)

## External Library

- `junit` & `assertJ` for testing, because testing is life ;)
- [`hipster`](https://github.com/citiususc/hipster) for shortest path algorithm using **Dijkstra's algorithm**. Very easy to use, perfectly adapted to my need, fully tested and 237 stars on Github.