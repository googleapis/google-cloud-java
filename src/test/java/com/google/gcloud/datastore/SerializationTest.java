package com.google.gcloud.datastore;

import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableMap;
import com.google.gcloud.datastore.Property.Type;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

public class SerializationTest {

  private static final IncompleteKey INCOMPLETE_KEY =
      new IncompleteKey.Builder("ds", "k").addToPath("p", 1).build();
  private static final Key KEY1 = new Key.Builder("ds", "k", "n").build();
  private static final Key KEY2 = new Key.Builder(INCOMPLETE_KEY, 2).build();
  private static final KeyProperty KEY_PROPERTY = new KeyProperty(KEY1);
  private static final NullProperty NULL_PROPERTY =
      new NullProperty.Builder().indexed(true).build();
  private static final StringProperty STRING_PROPERTY = new StringProperty("hello");
  private static final Entity ENTITY1 = new Entity.Builder(KEY1).build();
  private static final Entity ENTITY2 =
      new Entity.Builder(KEY2).setProperty("null", new NullProperty()).build();
  private static final EmbeddedEntity EMBEDDED_ENTITY1 = new EmbeddedEntity(ENTITY1);
  private static final EmbeddedEntity EMBEDDED_ENTITY2 = new EmbeddedEntity(ENTITY2);
  private static final EmbeddedEntity EMBEDDED_ENTITY3 =
      new EmbeddedEntity.Builder()
          .setKey(INCOMPLETE_KEY)
          .setProperty("p1", STRING_PROPERTY)
          .setProperty("p2", STRING_PROPERTY)
          .build();
  private static final EmbeddedEntityProperty EMBEDDED_ENTITY_PROPERTY1 =
      new EmbeddedEntityProperty(EMBEDDED_ENTITY1);
  private static final EmbeddedEntityProperty EMBEDDED_ENTITY_PROPERTY2 =
      new EmbeddedEntityProperty(EMBEDDED_ENTITY2);
  private static final EmbeddedEntityProperty EMBEDDED_ENTITY_PROPERTY3 =
      new EmbeddedEntityProperty(EMBEDDED_ENTITY3);
  private static final PropertyListProperty PROPERTY_LIST_PROPERTY =
      new PropertyListProperty.Builder()
          .addProperty(NULL_PROPERTY)
          .addProperty(STRING_PROPERTY)
          .addProperty(new NullProperty())
          .build();

  private Map<Type, Property[]> typeToProperties = ImmutableMap.<Type, Property[]>of(
      Type.NULL, array(NULL_PROPERTY),
      Type.KEY, array(KEY_PROPERTY),
      Type.STRING, array(STRING_PROPERTY),
      Type.EMBEDDED_ENTITY, array(EMBEDDED_ENTITY_PROPERTY1, EMBEDDED_ENTITY_PROPERTY2,
          EMBEDDED_ENTITY_PROPERTY3),
      Type.PROPERTY_LIST, array(PROPERTY_LIST_PROPERTY));

  private static <T> T[] array(T... values) {
    return values;
  }

  @Test
  public void testProperties() throws Exception {
    for (Type type : Type.values()) {
      Property[] properties = typeToProperties.get(type);
      for (Property property : properties) {
        Property copy = serialiazeAndDeserialize(property);
        assertEquals(property, copy);
        assertEquals(property.get(), copy.get());
      }
    }
  }

  @Test
  public void testTypes() throws Exception {
    Object[] types = new Object[] { KEY1, KEY2, INCOMPLETE_KEY, ENTITY1, ENTITY2, EMBEDDED_ENTITY1,
        EMBEDDED_ENTITY2, EMBEDDED_ENTITY3};
    for (Object obj : types) {
      Object copy = serialiazeAndDeserialize(obj);
      assertEquals(obj, copy);
    }
  }

  private <T> T serialiazeAndDeserialize(T obj) throws Exception {
    ByteArrayOutputStream bOut = new ByteArrayOutputStream();
    ObjectOutputStream out = new ObjectOutputStream(bOut);
    out.writeObject(obj);
    out.close();
    byte[] bytes = bOut.toByteArray();
    ByteArrayInputStream bIn = new ByteArrayInputStream(bytes);
    ObjectInputStream in = new ObjectInputStream(bIn);
    @SuppressWarnings("unchecked")
    T copy = (T) in.readObject();
    in.close();
    return copy;
  }
}
