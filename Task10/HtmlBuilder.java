package com.company;

/**
 * Creates and moderates html-file
 */
public class HtmlBuilder {

    /**
     * Colors of html-table
     */
    private static final String HEAD_COLOR = "#808080";
    private static final String LINE1_COLOR = "#efefef";
    private static final String LINE2_COLOR = "#f7f7f7";
    private static final String MAX_LINE_COLOR = "#ff0000";
    private static final String BORDER_COLOR = "#ffffff";

    /**
     * String HEADER contains header of html code
     */
    private static final String HEADER = "<html>\n " +
            "<head>\n " +
            "<title>Table</title>\n " +
            "<meta charset = \"utf-8\">\n " +
            "</head>\n " +
            "<body>\n" +
            "<style type=\"text/css\">\n" +
            "table {\n" +
            "border-collapse: collapse;\n" +
            "}\n" +
            "table thead {\n" +
            "border-bottom: 1px solid " + BORDER_COLOR + ";\n" +
            "}\n" +
            "table td {\n" +
            "padding-left: 9px;\n" +
            "}\n" +
            "</style>\n" +
            "<table border=1 bordercolor =\"" + BORDER_COLOR + "\"CELLSPACING = 0" +
            "cellpadding=\"1\"  width=\"630\" height=\"130\" align = center>\n " +
            "<thead>\n" +
            "<tr valign=\"top\" bgcolor =\"" + HEAD_COLOR + "\" align = center height = \"30\"> \n" +
            "<th width=\"630\">Server</th>\n" +
            "<th width=\"630\">Response, ms</th>\n" +
            "</tr>\n" +
            "</thead>\n" +
            "<tbody>\n";

    /**
     * String FOOTER contains finish part of html code
     */
    private static final String FOOTER = "</table>\n </body>\n </html>\n";

    /**
     * Body of the html code
     */
    private String html = "";


    private int count = 0;

    /**
     * Method getHtml returns full html code of html-table
     */
    public String getHtml() {
        return HEADER + html + FOOTER;
    }

    /**
     * Adds line which contains IP-address and ping, checks the max ping
     *
     * @param ip    - String, ip-address
     * @param ping  - int, ping
     * @param isMax - boolean, checks the maximum
     */
    public void addLine(String ip, Integer ping, boolean isMax) {
        String color;
        if (!isMax) {
            if (count % 2 != 0) {
                color = LINE1_COLOR;
            } else {
                color = LINE2_COLOR;
            }
        } else {
            color = MAX_LINE_COLOR;
        }
            html += "<tr bgcolor = \"" + color + "\" width=\"630\"><td>" + ip + "</td><td>"
                    + ping + "</td></tr>";
        count++;
    }

}
