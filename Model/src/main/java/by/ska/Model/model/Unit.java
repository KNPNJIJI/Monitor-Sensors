package by.ska.Model.model;

public enum Unit {
    bar ("bar"),
    voltage ("voltage"),
    degreesCelsius ("°С"),
    percent("%");

    private String title;

    Unit(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
