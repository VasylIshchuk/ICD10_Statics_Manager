import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ICDCodeTabularOptimizedForTime implements  ICDCodeTabular{
    private Map<String,String>  description= new HashMap<>();
    @Override
    public String getDescription( String code ) {
        try(Stream<String> contenstsOfFile = Files.lines(Path.of("icd10.txt"))) {
            description = contenstsOfFile.skip(88)
                    .map(String::trim)
                    .filter(line -> line.matches("[A-Z]\\d\\d.*"))
                    .map (line -> line.split(" ",2))
                    .collect(Collectors.toMap(
                            so -> so[0],
                            descriptor -> descriptor[1],
                            (oldvalue, newvalue) -> oldvalue));// Because c50 is duplicated. Exists 2 times in the file
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  description.get(code);
    }
}
