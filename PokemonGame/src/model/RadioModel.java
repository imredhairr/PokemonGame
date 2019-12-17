package model;

public class RadioModel {
    private final String text;
    private final String id;
    private final String style;
    private final boolean selected;

    public RadioModel(String text, String id, String style, boolean selected) {
        this.text = text;
        this.id = id;
        this.style = style;
        this.selected = selected;
    }

    public String getText() {
        return text;
    }

    public String getId() {
        return id;
    }

    public String getStyle() {
        return style;
    }

    public boolean isSelected() {
        return selected;
    }
}
