package cn.itcast.xml;

import org.junit.Test;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2016/8/20.
 */
public class Demo1 {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        //1. 创建工厂
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //2. 得到DOM解析器
        DocumentBuilder builder = factory.newDocumentBuilder();

        //3. 解析xml，得到代表文档document
        Document document = builder.parse("xml/book.xml");

        NodeList list = document.getElementsByTagName("书名");
        Node node = list.item(1);//读取xml数据
        String s = node.getTextContent();
        System.out.print(s);
    }

    //得到所有标签
    @Test
    public void test1() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document  document = builder.parse("xml/book.xml");

        Node root = document.getElementsByTagName("书架").item(0);
        list(root);
    }
    private void list(Node node) {
        if (node instanceof Element) {
            System.out.println(node.getNodeName());
        }
        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node child = list.item(i);
            list(child);
        }
    }

    @Test
    public void test2() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("xml/book.xml");

        Element element = (Element) document.getElementsByTagName("书名").item(0);
        String s = element.getAttribute("name");
        System.out.println(s);

    }

    @Test
    public void testAdd1() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("xml/book.xml");

        //创建节点
        Element price = document.createElement("售价");
        price.setTextContent("45");
        //挂到第一本书上
        Element book = (Element) document.getElementsByTagName("书").item(0);
        book.appendChild(price);

        //将内存中写回xml
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer tf = transformerFactory.newTransformer();
        tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("xml/book.xml")));

    }

    @Test
    public void testAdd2() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("xml/book.xml");

        //创建节点
        Element price = document.createElement("售价");
        price.setTextContent("45");

        //挂到第一本书上
        Element book = (Element) document.getElementsByTagName("书").item(0);

        //得到参考节点
        Element refbook = (Element) document.getElementsByTagName("定价").item(0);
        book.insertBefore(price, refbook);

        //将内存中写回xml
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer tf = transformerFactory.newTransformer();
        tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("xml/book.xml")));
    }

    @Test
    public void testAddAttr() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("xml/book.xml");


        Element book = (Element) document.getElementsByTagName("书名").item(1);
        book.setAttribute("name", "hehe");

        //将内存中写回xml
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer tf = transformerFactory.newTransformer();
        tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("xml/book.xml")));
    }

    @Test
    public void testDelete() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("xml/book.xml");


        Element e = (Element) document.getElementsByTagName("售价").item(0);

        e.getParentNode().getParentNode().removeChild(e.getParentNode());

//        //得到其父亲
//        Element book = (Element) document.getElementsByTagName("书").item(0);
//
//        //删除
//        book.removeChild(e);

        //将内存中写回xml
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer tf = transformerFactory.newTransformer();
        tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("xml/book.xml")));
    }

    @Test
    public void testUpdate() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("xml/book.xml");

        Element e = (Element)document.getElementsByTagName("售价").item(0);
        e.setTextContent("100");

        //将内存中写回xml
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer tf = transformerFactory.newTransformer();
        tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("xml/book.xml")));
    }

}
