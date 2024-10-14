import java.util.List;

public class MainSubroutineProcessor extends Processor {
    @Override
    public String process(List<String> lines) {
        StringBuilder result = new StringBuilder();
        for (String line : lines) {
            result.append("Processed Line (Main-Subroutine): ").append(line).append("\n");
        }
        return result.toString();
    }
}