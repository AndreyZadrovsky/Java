package Chat.Chat_app.Net;

import javafx.print.Collation;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HistoryMaker {
    private static final int SIZE_OF_RETRIEVED_HISTORY = 100;
    private static final String HISTORY_PATH = "history/";
    private String login;
    private File history;

    public HistoryMaker(String login){
        this.login = login;
        this.history = new File(HISTORY_PATH + "history_" + login + ".txt");
        if (!history.exists()){
            File path = new File(HISTORY_PATH);
            path.mkdirs();
        }
    }
    public List<String> readHistory(){
        if (!history.exists()) return Collections.singletonList("Еще нет истории сообщений ");
        List<String> result = null;
        if (history.exists()){
            try(BufferedReader reader = new BufferedReader(new FileReader(history))){
                String historyString;
                List<String> historyStrings = new ArrayList<>();
                while((historyString = reader.readLine()) != null){
                    historyStrings.add(historyString);
                }
                if (historyStrings.size() <= SIZE_OF_RETRIEVED_HISTORY){
                    result = historyStrings;
                }
                if (historyStrings.size() > SIZE_OF_RETRIEVED_HISTORY){
                    int firstIndex = historyStrings.size() - SIZE_OF_RETRIEVED_HISTORY;
                    result = new ArrayList<>(SIZE_OF_RETRIEVED_HISTORY);
                    for (int counter = firstIndex - 1; counter < historyStrings.size(); counter++){
                        result.add(historyStrings.get(counter));
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("История " + result.size());
        return result;
    }
    public void writeHistory(String message){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(history, true))){
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
