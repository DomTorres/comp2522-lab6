package ca.bcit.comp2522.lab6;

/**
 * Represents a magazine.
 */
public class Magazine extends Literature
{
    private final String title;

    /**
     * Magazine constructor.
     *
     * @param title title
     */
    public Magazine(final String title)
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
