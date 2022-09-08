import data.Repository;
import models.Entry;

import java.util.List;

public class App {
    public static void main(String[] args) {
        /*
        Cupcake
        https://trends.google.com/trends/explore?date=all&q=%2Fm%2F03p1r4
        Numbers represent search interest relative to the highest point on the chart for the given region and time.
        A value of 100 is the peak popularity for the term. A value of 50 means that the term is half as popular.
        A score of 0 means there was not enough data for this term.
        1) Use manual looping to answer the following questions:
        a) Display the rankings for 2010
        b) Which month/year has the highest ranking?
        c) Which month was the first month to have a ranking of 50 or greater?
        d) Which year has the highest average ranking?
        2) Use the Stream API to answer the same questions.
         */

        Repository repository = new Repository("./data/google-trends-data.csv");

        List<Entry> entries = repository.getEntries();



    }
}
