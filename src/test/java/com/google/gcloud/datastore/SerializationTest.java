package com.google.gcloud.datastore;

import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableMap;
import com.google.gcloud.datastore.Value.Type;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

public class SerializationTest {

  private static final PartialKey INCOMPLETE_KEY =
      new PartialKey.Builder("ds", "k").addToPath("p", 1).build();
  private static final Key KEY1 = new Key.Builder("ds", "k", "n").build();
  private static final Key KEY2 = new Key.Builder(INCOMPLETE_KEY, 2).build();
  private static final KeyValue KEY_PROPERTY = new KeyValue(KEY1);
  private static final NullValue NULL_PROPERTY =
      new NullValue.Builder().indexed(true).build();
  private static final StringValue STRING_PROPERTY = new StringValue("hello");
  private static final Entity ENTITY1 = new Entity.Builder(KEY1).build();
  private static final Entity ENTITY2 =
      new Entity.Builder(KEY2).setProperty("null", new NullValue()).build();
  private static final PartialEntity EMBEDDED_ENTITY1 = ENTITY1;
  private static final PartialEntity EMBEDDED_ENTITY2 = ENTITY2;
  private static final PartialEntity EMBEDDED_ENTITY3 =
      new PartialEntity.Builder()
          .setKey(INCOMPLETE_KEY)
          .setProperty("p1", STRING_PROPERTY)
          .setProperty("p2", STRING_PROPERTY)
          .build();
  private static final PartialEntityValue EMBEDDED_ENTITY_PROPERTY1 =
      new PartialEntityValue(EMBEDDED_ENTITY1);
  private static final PartialEntityValue EMBEDDED_ENTITY_PROPERTY2 =
      new PartialEntityValue(EMBEDDED_ENTITY2);
  private static final PartialEntityValue EMBEDDED_ENTITY_PROPERTY3 =
      new PartialEntityValue(EMBEDDED_ENTITY3);
  private static final ListValue PROPERTY_LIST_PROPERTY =
      new ListValue.Builder()
          .addValue(NULL_PROPERTY)
          .addValue(STRING_PROPERTY)
          .addValue(new NullValue())
          .build();

  private Map<Type, Value[]> typeToValues = ImmutableMap.<Type, Value[]>of(
      Type.NULL, array(NULL_PROPERTY),
      Type.KEY, array(KEY_PROPERTY),
      Type.STRING, array(STRING_PROPERTY),
      Type.PARTIAL_ENTITY, array(EMBEDDED_ENTITY_PROPERTY1, EMBEDDED_ENTITY_PROPERTY2,
          EMBEDDED_ENTITY_PROPERTY3),
      Type.LIST, array(PROPERTY_LIST_PROPERTY));

  private static <T> T[] array(T... values) {
    return values;
  }

  @Test
  public void testValues() throws Exception {
    for (Type type : Type.values()) {
      Value<?, ?, ?>[] values = typeToValues.get(type);
      for (Value<?, ?, ?> value : values) {
        Value<?, ?, ?> copy = serialiazeAndDeserialize(value);
        assertEquals(value, copy);
        assertEquals(value.get(), copy.get());
      }
    }
  }

  @Test
  public void testTypes() throws Exception {
    Object[] types = { KEY1, KEY2, INCOMPLETE_KEY, ENTITY1, ENTITY2, EMBEDDED_ENTITY1,
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
