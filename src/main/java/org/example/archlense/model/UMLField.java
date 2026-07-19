package org.example.archlense.model;




public class UMLField{
    private String name;

    private String type;

    private String visibility;

    @Override
    public String toString() {
        return visibility + " "
                + name
                + " : "
                + type;
    }

    public UMLField(String visibility, String type, String name) {
        this.visibility = visibility;
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
}
