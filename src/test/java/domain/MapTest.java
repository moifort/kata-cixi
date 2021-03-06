package domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MapTest {
    @Mock
    ShortestTrackAlgorithm shortestTrackAlgorithm;

    @Test
    public void shortestTrack() {
        // Given
        City sillingy = new City("Sillingy");
        City annecy = new City("Annecy");
        City epagny = new City("Epagny");
        City metzTessy = new City("Metz-Tessy");
        City seynod = new City("Seynod");
        List<City> cities = List.of(sillingy, annecy, epagny, metzTessy, seynod);

        Road sillingyToEpany = new Road(sillingy, epagny, new Length(1));
        Road epagnyToMetzTessy = new Road(epagny, metzTessy, new Length(3));
        Road metzTessyToAnnecy = new Road(metzTessy, annecy, new Length(12));
        Road metzTessyToSeynod = new Road(metzTessy, seynod, new Length(4));
        Road sillingyToSeynod = new Road(sillingy, seynod, new Length(11));
        Road sillingyToAnnecy = new Road(sillingy, annecy, new Length(19));
        Road annecyToSeynod = new Road(annecy, seynod, new Length(9));
        List<Road> roads = List.of(
                sillingyToEpany,
                epagnyToMetzTessy,
                metzTessyToAnnecy,
                metzTessyToSeynod,
                sillingyToSeynod,
                sillingyToAnnecy,
                annecyToSeynod);

        when(shortestTrackAlgorithm.shortestTrack(sillingy, annecy, roads))
                .thenReturn(List.of(sillingyToEpany, epagnyToMetzTessy, metzTessyToAnnecy));

        Map map = new Map(cities, roads, shortestTrackAlgorithm);

        // When
        List<Road> shortestTrack = map.shortestTrack(sillingy, annecy);

        // Then
        assertThat(shortestTrack).containsExactly(sillingyToEpany, epagnyToMetzTessy, metzTessyToAnnecy);
    }
}