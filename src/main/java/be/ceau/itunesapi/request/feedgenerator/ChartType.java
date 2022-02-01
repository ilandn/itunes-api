package be.ceau.itunesapi.request.feedgenerator;

public enum ChartType {

    TOP("top");

    private final String code;

    ChartType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
