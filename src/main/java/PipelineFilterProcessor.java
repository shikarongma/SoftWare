import java.util.List;

public class PipelineFilterProcessor extends Processor {
    @Override
    public String process(List<String> lines) {
        StringBuilder result = new StringBuilder();
        for (String line : lines) {
            String filteredLine = firstFilter(line);
            filteredLine = secondFilter(filteredLine);
            result.append(filteredLine).append("\n");
        }
        return result.toString();
    }

    private String firstFilter(String line) {
        return "First Filter: " + line;
    }

    private String secondFilter(String line) {
        return "Second Filter: " + line;
    }
}