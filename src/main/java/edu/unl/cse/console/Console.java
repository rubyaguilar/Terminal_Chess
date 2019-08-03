/*
 * Copyright (c) 2019 Christopher A. Bohn, bohn@unl.edu.
 */

package edu.unl.cse.console;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Provides a mechanism to place text on arbitrary locations of a terminal window. The general usage is to
 * construct the text placement and then use the {@link #draw()} method to update the actual terminal window.</p>
 *
 * <p>This is a very simple tool. It is <i>not</i> event-based; updates will not occur automatically.</p>
 * <p>The {@link Console} class relies on VT100 terminal emulation to provide a reference to the upper-left corner of
 * the terminal window. If your terminal window doesn't recognize VT100 terminal escape codes then do not expect the
 * {@link #draw()} method to be able to overwrite existing on-screen text.</p>
 *
 * <p>While it is possible to place text directly in the {@link Console}, in most cases you will find it more convenient
 * to use {@link #createBox(int, int)} to get a {@link Console.Box} objects to work in a smaller area that can then be
 * placed in the {@link Console}.</p>
 */
public class Console {

    /**
     * Provides a {@link Console.Box} object of the specified dimensions.
     *
     * @param numberOfRows    The number of rows (lines of text) in the {@link Console.Box}
     * @param numberOfColumns The width of the {@link Console.Box}
     * @return A {@link Console.Box} that is {@code numberOfRows} tall and {@code numberOfColumns} wide
     */
    public static Box createBox(int numberOfRows, int numberOfColumns) {
        return new Console.Box(numberOfRows, numberOfColumns);
    }

    static final String VT100_HOME = "\u001B[H";

    private final Box fullScreen;
    private String prompt;

    /**
     * The default constructor assumes a standard 24x80 terminal window.
     */
    public Console() {
        this(24, 80);
    }

    /**
     * This constructor allows specifying the size of the terminal window.
     *
     * @param numberOfRows    The height of the terminal window, in lines
     * @param numberOfColumns The width of the terminal window, in spaces
     */
    public Console(int numberOfRows, int numberOfColumns) {
        fullScreen = createBox(numberOfRows, numberOfColumns);
        prompt = "";
    }

    /**
     * Overwrites the terminal window with the contents of this {@link Console} object.
     * Will also place the prompt (set by {@link #setPrompt(String)} in the upper-left corner, possibly hiding some
     * other content, and placing the cursor at the end of the prompt.
     */
    public void draw() {
        System.out.print(VT100_HOME + fullScreen);
        System.out.print(VT100_HOME + prompt);
    }

    /**
     * Replaces any existing text on the screen with whitespace.
     */
    public void clear() {
        fullScreen.clear();
    }

    /**
     * Replaces part of a line on the screen with whitespace.
     *
     * @param row    The line on the screen that will have text cleared
     * @param column The left side of the portion of the screen to be cleared
     * @param length The number of spaces to clear
     */
    public void clear(int row, int column, int length) {
        fullScreen.clear(row, column, length);
    }

    /**
     * Replaces a section of screen equal in dimensions to the {@code box} provided. The {@link Console.Box} object
     * remains unchanged.  The ({@code row},{@code column}) ordered pair is the upper-left portion of the screen to be
     * cleared.
     *
     * @param row    The top line of the area to be cleared
     * @param column The left side of the area to be cleared
     * @param box    The reference {@link Console.Box} whose dimensions will be used to specify the size of the area
     *               to be cleared
     */
    public void clear(int row, int column, Box box) {
        int placementRow = row;
        for (String string : box) {
            clear(placementRow, column, string.length());
            placementRow++;
        }
    }

    /**
     * Places a single character on the screen.
     *
     * @param row       The line on the screen on which the character will be placed
     * @param column    The number of spaces from the left where the character will be placed
     * @param character The character to be placed
     */
    public void place(int row, int column, char character) {
        fullScreen.place(row, column, character);
    }

    /**
     * Places a string of text on the screen.
     *
     * @param row    The line on the screen on which the character will be placed
     * @param column The number of spaces from the left where the first character of the string will be placed
     * @param string The text to be placed
     */
    public void place(int row, int column, String string) {
        fullScreen.place(row, column, string);
    }

    /**
     * Places a {@link Console.Box} on the screen.  The ({@code row},{@code column}) ordered pair is the upper-left
     * portion of the screen where the {@link Console.Box} will be placed.
     *
     * @param row    The top line of the portion of the screen where the box will be placed
     * @param column The left side of the portion of the screen where the box will be placed
     * @param box    The box containing the text to be placed
     */
    public void place(int row, int column, Box box) {
        int placementRow = row;
        for (String string : box) {
            place(placementRow, column, string);
            placementRow++;
        }
    }

    /**
     * Sets the prompt to tell the user what input should be provided. The prompt will always be displayed whenever
     * {@link #draw()} is called, possibly hiding some other content. If you do not want a prompt to be displayed then
     * call {@code setPrompt} with an empty string. If you want the prompt to be shown on a different line then
     * add line feeds to the start of the prompt.
     *
     * @param prompt The message to the user
     */
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }


    /**
     * <p>Provides a smaller text area to work with when different sections of the screen are used for different
     * purposes.</p>
     *
     * <p>By working with a smaller text area, there will be less math needed in your code to assure proper text
     * placement, and you'll also be able to separate concerns in your code better.</p>
     */
    public static class Box implements Iterable<String> {
        final int numberOfRows;
        final int numberOfColumns;
        private StringBuilder[] canvas;
        private final String emptyRow;

        public Box(int rows, int columns) {
            numberOfRows = rows;
            numberOfColumns = columns;
            canvas = new StringBuilder[rows];
            emptyRow = whitespace(numberOfColumns);
            initializeCanvas();
        }

        @Override
        public String toString() {
            StringBuilder fullString = new StringBuilder();
            for (StringBuilder row : canvas) {
                fullString.append(row);
                fullString.append('\n');
            }
            fullString.deleteCharAt(fullString.length() - 1);
            return fullString.toString();
        }

        @Override
        public Iterator<String> iterator() {
            List<String> stringList = new LinkedList<>();
            for (StringBuilder row : canvas) {
                stringList.add(row.toString());
            }
            return stringList.iterator();
        }

        /**
         * Replaces any existing text in the box with whitespace.
         */
        public void clear() {
            for (StringBuilder row : canvas) {
                row.replace(0, numberOfColumns, emptyRow);
            }
        }

        /**
         * Replaces part of a line in the box with whitespace.
         *
         * @param row    The line (relative to the box) have text cleared
         * @param column The left side (relative to the box) of the portion of text to be cleared
         * @param length The number of spaces to clear
         */
        public void clear(int row, int column, int length) {
            place(row, column, whitespace(length));
        }

        /**
         * <p>Places a single character in the box.</p>
         * <p>Will silently ignore a request to place the character
         * beyond the right or bottom bounds of the box. Does not (yet) protect against trying to place the character
         * beyond the left or top bounds of the box: do not pass negative values for ({@code row},{@code column}).</p>
         *
         * @param row       The line (relative to the box) on which the character will be placed
         * @param column    The number of spaces from the left of the box where the character will be placed
         * @param character The character to be placed
         * @throws IndexOutOfBoundsException if {@code row < 0} or {@code column < 0}
         */
        public void place(int row, int column, char character) {
            if (row < numberOfRows && column < numberOfColumns) {
                canvas[row].replace(column, column + 1, Character.toString(character));
            }
        }

        /**
         * <p>Places a string of text in the box.</p>
         * <p>Will silently ignore a request to place the text beyond the bottom bound
         * of the box, and will silently truncate any text extending beyond the right bound of the box. Does not (yet)
         * protect against trying to text beyond the left or top bounds of the box: do not pass negative values for
         * ({@code row},{@code column}).</p>
         *
         * @param row    The line (relative to the box) on which the character will be placed
         * @param column The number of spaces from the left of the box where the first character of the string will
         *               be placed
         * @param string The text to be placed
         * @throws IndexOutOfBoundsException if {@code row < 0} or {@code column < 0}
         */
        public void place(int row, int column, String string) {
            if (row < numberOfRows && column < numberOfColumns) {
                int lastColumn = column + string.length();
                int lastPrintableColumn = (lastColumn < numberOfColumns ? lastColumn : numberOfColumns) - 1;
                int numberOfTruncatedCharacters = lastColumn - lastPrintableColumn - 1;
                String subString = string.substring(0, string.length() - numberOfTruncatedCharacters);
                canvas[row].replace(column, column + subString.length(), subString);
            }
        }

        public void initializeCanvas() {
            for (int i = 0; i < numberOfRows; i++) {
                canvas[i] = new StringBuilder();
            }
            clear();
        }

        private String whitespace(int length) {
            StringBuilder stringBuilder = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                stringBuilder.append(" ");
            }
            return stringBuilder.toString();
        }
    }
}
