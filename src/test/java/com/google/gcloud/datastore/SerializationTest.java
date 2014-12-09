package com.google.gcloud.datastore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.gcloud.datastore.Value.Type;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationTest {

  private static final PartialKey INCOMPLETE_KEY1 =
      PartialKey.builder("ds", "k").addAncestor("p", 1).build();
  private static final Key KEY1 = Key.builder("ds", "k", "n").build();
  private static final PartialKey INCOMPLETE_KEY2 =
      PartialKey.builder(KEY1, "v").addAncestor("p", 1).build();
  private static final Key KEY2 = Key.builder(KEY1, "v", 2).build();
  private static final KeyValue KEY_VALUE = new KeyValue(KEY1);
  private static final NullValue NULL_VALUE = NullValue.builder().indexed(true).build();
  private static final StringValue STRING_VALUE = new StringValue("hello");
  private static final LongValue LONG_VALUE = new LongValue(123);
  private static final DoubleValue DOUBLE_VALUE = new DoubleValue(12.34);
  private static final BooleanValue BOOLEAN_VALUE = new BooleanValue(true);
  private static final DateTimeValue DATE_AND_TIME_VALUE =
      new DateTimeValue(DateTime.now());
  private static final BlobValue BLOB_VALUE =
      new BlobValue(Blob.copyFrom(new byte[] {10, 0, -2}));
  private static final RawValue RAW_VALUE = new RawValue(
      DatastoreV1.Value.newBuilder().setBlobKeyValue("blob-key").setMeaning(18).build());
  private static final Entity ENTITY1 = Entity.builder(KEY1).build();
  private static final Entity ENTITY2 =
      Entity.builder(KEY2).setProperty("null", new NullValue()).build();
  private static final Entity ENTITY3 = Entity.builder(KEY2)
      .setProperty("p1", StringValue.builder("hi1").meaning(10).build())
      .setProperty("p2", StringValue.builder("hi2").meaning(11).indexed(false).build())
      .setProperty("p3", LongValue.builder(100).indexed(false).meaning(100).build())
      .build();
  private static final PartialEntity EMBEDDED_ENTITY1 = ENTITY1;
  private static final PartialEntity EMBEDDED_ENTITY2 = ENTITY2;
  private static final PartialEntity EMBEDDED_ENTITY3 = PartialEntity.builder(INCOMPLETE_KEY1)
      .setProperty("p1", STRING_VALUE)
      .setProperty("p2", LongValue.builder(100).indexed(false).meaning(100).build())
      .build();
  private static final EntityValue EMBEDDED_ENTITY_VALUE1 =
      new EntityValue(EMBEDDED_ENTITY1);
  private static final EntityValue EMBEDDED_ENTITY_VALUE2 =
      new EntityValue(EMBEDDED_ENTITY2);
  private static final EntityValue EMBEDDED_ENTITY_VALUE3 =
      new EntityValue(EMBEDDED_ENTITY3);
  private static final ListValue LIST_VALUE = ListValue.builder()
      .addValue(NULL_VALUE)
      .addValue(STRING_VALUE)
      .addValue(new NullValue())
      .build();

  @SuppressWarnings("rawtypes")
  private Multimap<Type, Value> typeToValues = ImmutableMultimap.<Type, Value>builder()
      .put(Type.NULL, NULL_VALUE)
      .put(Type.KEY, KEY_VALUE)
      .put(Type.STRING, STRING_VALUE)
      .putAll(Type.ENTITY, EMBEDDED_ENTITY_VALUE1, EMBEDDED_ENTITY_VALUE2,
          EMBEDDED_ENTITY_VALUE3)
      .put(Type.LIST, LIST_VALUE)
      .put(Type.LONG, LONG_VALUE)
      .put(Type.DOUBLE, DOUBLE_VALUE)
      .put(Type.BOOLEAN, BOOLEAN_VALUE)
      .put(Type.DATE_TIME, DATE_AND_TIME_VALUE)
      .put(Type.BLOB, BLOB_VALUE)
      .put(Type.RAW_VALUE, RAW_VALUE)
      .build();

  @Test
  public void testValues() throws Exception {
    for (Type type : Type.values()) {
      for (Value<?> value : typeToValues.get(type)) {
        Value<?> copy = serialiazeAndDeserialize(value);
        assertEquals(value, value);
        assertEquals(value, copy);
        assertNotSame(value, copy);
        assertEquals(copy, copy);
        assertEquals(value.get(), copy.get());
      }
    }
  }

  @Test
  public void testTypes() throws Exception {
    Object[] types = { KEY1, KEY2, INCOMPLETE_KEY1, INCOMPLETE_KEY2, ENTITY1, ENTITY2,
        ENTITY3, EMBEDDED_ENTITY1, EMBEDDED_ENTITY2, EMBEDDED_ENTITY3};
    for (Object obj : types) {
      Object copy = serialiazeAndDeserialize(obj);
      assertEquals(obj, obj);
      assertEquals(obj, copy);
      assertNotSame(obj, copy);
      assertEquals(copy, copy);
    }
  }

  @SuppressWarnings("unchecked")
  private <T> T serialiazeAndDeserialize(T obj) throws Exception {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
      objectOutputStream.writeObject(obj);
    }
    byte[] bytes = byteArrayOutputStream.toByteArray();
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
    try (ObjectInputStream in = new ObjectInputStream(byteArrayInputStream)) {
      return (T) in.readObject();
    }
  }
}
