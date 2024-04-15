package advanced_dsa;

/**
 * Design a text editor with a cursor that can do the following:
 * Add text to where the cursor is.
 * Delete text from where the cursor is (simulating the backspace key).
 * Move the cursor either left or right.
 * When deleting text, only characters to the left of the cursor will be deleted. The cursor will also remain within the actual text and cannot be moved beyond it.
 * More formally, we have that 0 <= cursor.position <= currentText.length always holds.
 * 
 * Implement the TextEditor class:
 * TextEditor() Initializes the object with empty text.
 * void addText(string text)
 * - Appends text to where the cursor is. The cursor ends to the right of text.
 * int deleteText(int k)
 * - Deletes k characters to the left of the cursor. Returns the number of characters actually deleted.
 * string cursorLeft(int k)
 * - Moves the cursor to the left k times. Returns the last min(10, len) characters to the left of the cursor, where len is the number of characters to the left of the cursor.
 * string cursorRight(int k)
 * - Moves the cursor to the right k times. Returns the last min(10, len) characters to the left of the cursor, where len is the number of characters to the left of the cursor.
 */
class TextEditor {
    StringBuilder text;
    int cursor;
    public TextEditor() {
        this.text = new StringBuilder("|");
        this.cursor = 0;
    }
    
    public void addText(String text) {
        // "lee|tcode" -> "add" -> "leeadd|tcode"
        this.text.insert(this.cursor, text);
        this.cursor += text.length();
    }
    
    public int deleteText(int k) {
        // "lee|tcode" -> 3
        int count = Math.min(k, this.cursor);
        this.text.delete(this.cursor - count, this.cursor);
        this.cursor -= count;
        return count;
    }
    
    public String cursorLeft(int k) {
        int count = Math.min(k, this.cursor);
        if (count > 0) {
            this.text.deleteCharAt(this.cursor);
            this.text.insert(this.cursor - count, '|');
            this.cursor -= count;
        }
        return this.text.substring(this.cursor - Math.min(this.cursor, 10), this.cursor);
    }
    
    public String cursorRight(int k) {
        int count = Math.min(this.cursor + k, this.text.length() - 1);
        if (this.cursor < count) {
            this.text.deleteCharAt(this.cursor);
            this.text.insert(count, '|');
            this.cursor = count;
        }
        return this.text.substring(this.cursor - Math.min(this.cursor, 10), this.cursor);
    }
}
