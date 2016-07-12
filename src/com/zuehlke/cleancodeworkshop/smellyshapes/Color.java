package com.zuehlke.cleancodeworkshop.smellyshapes;

public class Color {

    private String colorAsHex;
    private String colorAsText;
    private String colorAsRGB_Red;
    private String colorAsRGB_Green;
    private String colorAsRGB_Blue;
    private String errorMessage;

    public Color(String colorAsText) {
        this.colorAsText = colorAsText;
        convertTextValueToRGBAndHex();
    }

    private void convertTextValueToRGBAndHex() {
        errorMessage = "";
        if ("Red".equals(colorAsText)) {
            colorAsRGB_Red = "255";
            colorAsRGB_Blue = "0";
            colorAsRGB_Green = "0";
            colorAsHex = "#FF0000";
        } else if ("Blue".equals(colorAsText)) {
            colorAsRGB_Red = "0";
            colorAsRGB_Blue = "255";
            colorAsRGB_Green = "0";
            colorAsHex = "#00FF00";
        } else if ("Green".equals(colorAsText)) {
            colorAsRGB_Red = "0";
            colorAsRGB_Blue = "0";
            colorAsRGB_Green = "255";
            colorAsHex = "#0000FF";
        } else {
            errorMessage = "Color not recognized";
        }
    }

    public String getBlue() {
        return colorAsRGB_Blue;
    }

    public String getGreen() {
        return colorAsRGB_Green;
    }

    public String getRed() {
        return colorAsRGB_Red;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getColorFormatted() {
            return colorAsText;
    }

    public String getColorFormattedWithHexAndRGB() {
        return colorAsText + " " + colorAsHex + " " + colorAsRGB_Red + ":" + colorAsRGB_Green + ":" + colorAsRGB_Blue;
    }

    public String getColorAsHex() {
        return colorAsHex;
    }
}
