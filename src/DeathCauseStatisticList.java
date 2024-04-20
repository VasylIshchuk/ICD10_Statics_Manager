import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeathCauseStatisticList {
    List<DeathCauseStatistic> infoAboutAllObjects = new ArrayList<>();
    public void repopulate(String path) {
        try (Stream<String> stream = Files.lines(Path.of(path))) {
            infoAboutAllObjects = stream
                    .skip(2)
                    .map(DeathCauseStatistic::fromCsvLine)
                    .toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<DeathCauseStatistic> mostDeadlyDiseases(Integer age, int n){
        return infoAboutAllObjects.stream()
                .sorted((o1,o2) -> Integer.compare(
                        o2.getAgeBracketDeaths(age).deathCount,
                        o1.getAgeBracketDeaths(age).deathCount))
//                .sorted(Comparator.comparing(str ->
//                        str.getAgeBracketDeaths(age).deathCount).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }
}
