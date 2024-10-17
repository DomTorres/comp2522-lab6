package ca.bcit.comp2522.lab6;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Represent a bookstore which stores literature items.
 *
 * @param <T> literature item
 */
public class BookStore<T extends Literature>
{
    private final List<T> items = new ArrayList<>();

    /** static nested class */
    static class BookStoreInfo
    {
        public void displayInfo(final String storeName, int itemCount)
        {
            System.out.println("BookStore: " + storeName + ", Items: " + itemCount);
        }
    }

    /** non-static inner class */
    class NovelStatistics
    {
        public double averageTitleLength()
        {
            int totalLength = 0;

            if(items != null)
            {
                for(final T item : items)
                {
                    if(item != null)
                    {
                        totalLength += item.getTitle().length();
                    }
                }
            }

            return totalLength / (double) items.size();
        }
    }

    /**
     * Adds literature item to bookstore.
     *
     * @param item literature item
     */
    public void addItem(final T item)
    {
        items.add(item);
    }

    /**
     * Prints all literature item titles.
     */
    public void printItems()
    {
        if(items != null)
        {
            for(final T item : items)
            {
                if(item != null)
                {
                    System.out.println(item.getTitle());
                }
            }
        }
    }

    /**
     * Prints literature item
     * if that title contains title parameter.
     *
     * @param title title
     */
    public void printBookTitle(final String title)
    {
        items.forEach(item -> {
            if(item.getTitle().contains(title))
            {
                System.out.println(item.getTitle());
            }
        });
    }

    /**
     * Prints literature items in alphabetical order.
     */
    public void printTitlesInAlphaOrder()
    {
        final Comparator<Literature> compareToIgnoreCase;
        compareToIgnoreCase = (Literature l1, Literature l2) ->
        {
            return l1.getTitle().toLowerCase().compareTo(l2.getTitle().toLowerCase());
        };

        items.sort(compareToIgnoreCase);
        items.forEach(item -> System.out.println(item.getTitle()));
    }

    /**
     * Accepts a collection of novels
     * and add novels from this bookstore to it.
     *
     * @param novelCollection novel collection
     */
    public void addNovelsToCollection(final List<? super Novel> novelCollection)
    {
        if(items != null)
        {
            for(final T item : items)
            {
                if(item != null && item instanceof Novel)
                {
                    novelCollection.add((Novel) item);
                }
            }
        }
    }

    /**
     * Items getter.
     *
     * @return items
     */
    protected List<T> getItems()
    {
        return items;
    }

    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(final String[] args)
    {
        BookStore<Literature> store = new BookStore<>();

        store.addItem(new Novel("War and Peace"));
        store.addItem(new ComicBook("Spider-Man"));
        store.addItem(new Magazine("National Geographic"));

        store.printItems();

        /** Sort books by title length using an anonymous inner class */
        store.getItems().sort(new Comparator<Literature>() {

            @Override
            public int compare(Literature o1, Literature o2)
            {
                return Integer.compare(o1.getTitle().length(), o2.getTitle().length());
            }
        });
    }
}
