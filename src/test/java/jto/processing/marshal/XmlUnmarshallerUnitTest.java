package jto.processing.marshal;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class XmlUnmarshallerUnitTest {

    private static final String thingString = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<thing>\n" +
            "    <id>100</id>\n" +
            "    <name>Taylor</name>\n" +
            "</thing>\n" +
            "<!--__Type__jto.processing.marshal.Thing-->";

    @Test
    public void testDataFormat() {
        assertEquals(DataFormat.XML, new XmlUnmarshaller().dataFormat());
    }

    @Test
    public void testUnmarshal() {
        Object result = new XmlUnmarshaller().unmarshal(thingString);
        Thing thing = (Thing) result;
        assertEquals("Taylor", thing.getName());
        assertEquals(100, thing.getId());
    }

    @Test
    public void testUnmarshal_typed() {
        Thing thing = new XmlUnmarshaller().unmarshal(thingString, Thing.class);
        assertEquals("Taylor", thing.getName());
        assertEquals(100, thing.getId());
    }
}