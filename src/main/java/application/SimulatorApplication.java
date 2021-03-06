package application;

import application.clock.Clock;
import application.clock.SystemClock;
import application.print.Printable;
import application.print.Printer;
import application.print.SystemOutPrinter;
import domain.City;
import domain.Length;
import domain.Map;
import domain.Road;
import infra.algorithm.homemade.MyDijkstraAdaptor;

import java.util.List;

public class SimulatorApplication {
    private Printer printer;

    public SimulatorApplication() {
        this(new SystemOutPrinter(), new SystemClock());
    }

    public SimulatorApplication(Printable print, Clock clock) {
        this.printer = new Printer(print, clock);
    }

    public void run() {
        printer.title("City");
        City sillingy = new City("Sillingy");
        City annecy = new City("Annecy");
        City epagny = new City("Epagny");
        City metzTessy = new City("Metz-Tessy");
        City seynod = new City("Seynod");
        List<City> cities = List.of(sillingy, annecy, epagny, metzTessy, seynod);
        cities.stream().forEach(printer::result);

        printer.title("Road");
        Road sillingyToEpany = new Road(sillingy, epagny, new Length(1));
        Road epagnyToMetzTessy = new Road(epagny, metzTessy, new Length(3));
        Road metzTessyToAnnecy = new Road(metzTessy, annecy, new Length(12));
        Road metzTessyToSeynod = new Road(metzTessy, seynod, new Length(4));
        Road sillingyToSeynod = new Road(sillingy, seynod, new Length(11));
        Road sillingyToAnnecy = new Road(sillingy, annecy, new Length(19));
        Road annecyToSeynod = new Road(annecy, seynod, new Length(9));
        List<Road> roads = List.of(sillingyToEpany,
                epagnyToMetzTessy,
                metzTessyToAnnecy,
                metzTessyToSeynod,
                sillingyToSeynod,
                sillingyToAnnecy,
                annecyToSeynod);
        roads.stream().forEach(printer::result);

        printer.title("Map");
        Map map = new Map(cities, roads, new MyDijkstraAdaptor());
        printer.map(map);

        printer.title("Route");
        City from = sillingy;
        City to = annecy;
        List<Road> route = map.shortestTrack(from, to);
        printer.route(from, to, route);
    }
}
