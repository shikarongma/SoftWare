import java.util.List;

public class EventSystemProcessor extends Processor {
    @Override
    public String process(List<String> lines) {
        StringBuilder result = new StringBuilder();
        for (String line : lines) {
            fireEvent(line, result);
        }
        return result.toString();
    }

    private void fireEvent(String line, StringBuilder result) {
        EventHandler eventHandler = new EventHandler();
        eventHandler.handleLine(line, result);
    }

    private class EventHandler {
        public void handleLine(String line, StringBuilder result) {
            result.append("Processed Line (Event System): ").append(line).append("\n");
        }
    }
}