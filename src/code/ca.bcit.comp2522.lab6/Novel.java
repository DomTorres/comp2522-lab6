package ca.bcit.comp2522.lab6;

/**
 * Represents a novel.
 */
public class Novel extends Literature
{
    private final String title;

    /**
     * Novel constructor.
     *
     * @param title title
     */
    public Novel(final String title)
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