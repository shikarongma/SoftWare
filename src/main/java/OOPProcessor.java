import java.util.List;

public class OOPProcessor extends Processor {
    @Override
    public String process(List<String> lines) {
        StringBuilder result = new StringBuilder();
        for (String line : lines) {
            LineProcessor lineProcessor = new LineProcessor();
            result.append(lineProcessor.processLine(line)).append("\n");
        }
        return result.toString();
    }

    private class LineProcessor {
        public String processLine(String line) {
            return "Processed Line (OOP): " + line;
        }
    }
}