package com.company;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.math.BigDecimal;

public class TriangleTest {

    private static final String VALID_TRIANGLES = "validTriangles";
    private static final String INVALID_TRIANGLES = "invalidTriangles";
    private static final String ISOSCELES_NODE = "isosceles";
    private static final String EQUILATERAL_NODE = "equilateral";
    private static final String PATH = "C:\\Users\\Kristina\\IdeaProjects\\Task5Test\\triangleData.xml";
    private static final String SIDE_A = "a";
    private static final String SIDE_B = "b";
    private static final String SIDE_C = "c";


    Triangle triangle;

    @DataProvider(name = "valid triangles from xml")
    public Object[][] readXMLforPositiveIsosceles() throws Exception {
        ParseFile parseFile = new ParseFile();
        Document document = parseFile.parseInputFile();
        Node validTriangleElement = document.getElementsByTagName(VALID_TRIANGLES).item(0);
        NodeList nodes = validTriangleElement.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            if (Node.TEXT_NODE == nodes.item(i).getNodeType()) {
                validTriangleElement.removeChild(nodes.item(0));
            }
        }

        Object[][] result = new Object[nodes.getLength()][];
        for (int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap attributes = nodes.item(i).getAttributes();
            String nodeName = nodes.item(i).getNodeName();
            int triangleType;
            if (nodeName == ISOSCELES_NODE) {
                triangleType = Triangle.TYPE_ISOSCELES;
            } else if (nodeName == EQUILATERAL_NODE) {
                triangleType = Triangle.TYPE_EQUILATERAL;
            } else {
                triangleType = Triangle.TYPE_VERSATILE;
            }
            result[i] = resultArray(attributes, triangleType);
        }
        return result;
    }

    @Test(dataProvider = "valid triangles from xml")
    public void constructorForValidTriangle(BigDecimal a, BigDecimal b, BigDecimal c, int triangleType) throws Exception {
        triangle = new Triangle(a, b, c);
        Assert.assertEquals(triangle.getType(), triangleType);
    }

    @DataProvider(name = "invalid triangles from xml")
    public Object[][] readXML() throws Exception {
        ParseFile parseFile = new ParseFile();
        Document document = parseFile.parseInputFile();
        NodeList nodes = document.getElementsByTagName(INVALID_TRIANGLES);
        Object[][] result = new BigDecimal[nodes.getLength()][];
        for (int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap attributes = nodes.item(i).getAttributes();
            result[i] = resultArray(attributes);
        }
        return result;
    }

    @Test(dataProvider = "invalid triangles from xml", expectedExceptions = Exception.class)
    public void testNegativeSetNotValidSidesOfTheTriangle(BigDecimal a, BigDecimal b, BigDecimal c) throws Exception {
        triangle = new Triangle(a, b, c);
    }

    private static Object[] resultArray(NamedNodeMap attributes) {
        return new BigDecimal[]{
                attributes.getNamedItem(SIDE_A) == null ? null : new BigDecimal(attributes.getNamedItem(SIDE_A).getNodeValue()),
                attributes.getNamedItem(SIDE_B) == null ? null : new BigDecimal(attributes.getNamedItem(SIDE_B).getNodeValue()),
                attributes.getNamedItem(SIDE_C) == null ? null : new BigDecimal(attributes.getNamedItem(SIDE_C).getNodeValue())
        };
    }

    private static Object[] resultArray(NamedNodeMap attributes, int triangleType) {
        return new Object[]{
                attributes.getNamedItem(SIDE_A) == null ? null : new BigDecimal(attributes.getNamedItem(SIDE_A).getNodeValue()),
                attributes.getNamedItem(SIDE_B) == null ? null : new BigDecimal(attributes.getNamedItem(SIDE_B).getNodeValue()),
                attributes.getNamedItem(SIDE_C) == null ? null : new BigDecimal(attributes.getNamedItem(SIDE_C).getNodeValue()),
                triangleType
        };
    }

    public class ParseFile {
        Document parseInputFile() throws Exception {
            File inputFile = new File(PATH);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputFile);
            return document;
        }
    }
}