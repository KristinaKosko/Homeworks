package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

/**
 * Reads data(instructions) from the XML-file
 */
public class XMLFile {

    public static final String COMMANDS = "commands";

    ArrayList<Command> commands;
    private static final String FIRST_PARAMETER = "param0";
    private static final String SECOND_PARAMETER = "param1";
    private static final String THIRD_PARAMETER = "param2";
    private static final String COMMANDS_NODE = "command";

    public XMLFile() {
        commands = new ArrayList<Command>();
    }

    /**
     * Reads data from the XML-file, adds the name of the command and its params to the ArrayList of commands
     *
     * @param filePath - path to the XML file
     * @throws Exception
     */
    public void readFromXML(String filePath) throws Exception {
        File inputFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputFile);
        Node commandsFromXML = document.getElementsByTagName(COMMANDS).item(0);
        NodeList nodes = commandsFromXML.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            if (Node.TEXT_NODE == nodes.item(i).getNodeType()) {
                commandsFromXML.removeChild(nodes.item(0));
            }
        }
        for (int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap attributes = nodes.item(i).getAttributes();
            String nodeName = nodes.item(i).getNodeName();
            String name = "";
            ArrayList<String> attrs = new ArrayList<String>();
            if (nodeName == COMMANDS_NODE) {
                if (attributes.getNamedItem(FIRST_PARAMETER).equals("open")) {
                    name = attributes.getNamedItem(FIRST_PARAMETER).getNodeValue();
                    attrs.add(attributes.getNamedItem(SECOND_PARAMETER).getNodeValue());
                    attrs.add(attributes.getNamedItem(THIRD_PARAMETER).getNodeValue());
                } else if (attributes.getNamedItem(FIRST_PARAMETER).equals("checkLinkPresentByHref")) {
                    name = attributes.getNamedItem(FIRST_PARAMETER).getNodeValue();
                    attrs.add(attributes.getNamedItem(SECOND_PARAMETER).getNodeValue());
                } else if (attributes.getNamedItem(FIRST_PARAMETER).equals("checkLinkPresentByName")) {
                    name = attributes.getNamedItem(FIRST_PARAMETER).getNodeValue();
                    attrs.add(attributes.getNamedItem(SECOND_PARAMETER).getNodeValue());
                } else if (attributes.getNamedItem(FIRST_PARAMETER).equals("checkPageTitle")) {
                    name = attributes.getNamedItem(FIRST_PARAMETER).getNodeValue();
                    attrs.add(attributes.getNamedItem(SECOND_PARAMETER).getNodeValue());
                }
            }
            commands.add(new Command(name, attrs));
        }
    }

    /**
     * Trivial getter
     *
     * @return commands - ArrayList<Command>
     */
    public ArrayList<Command> getCommands() {
        return commands;
    }
}