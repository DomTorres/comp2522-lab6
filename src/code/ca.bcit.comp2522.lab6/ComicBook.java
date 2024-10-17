package ca.bcit.comp2522.lab6;

/**
 * Represents a comic book.
 */
public class ComicBook extends Literature
{
    private final String title;

    /**
     * Comic book constructor.
     *
     * @param title title
     */
    public ComicBook(final String title)
    {
        this.title = title;
    }

    /**
     * Title getter.
     *
     * @return title
     */
    @Override
    public String getTitle()
    {
        return title;
    }
}
