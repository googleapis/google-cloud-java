/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.firestore;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.firestore.annotation.PropertyName;
import com.google.cloud.firestore.annotation.ThrowOnExtraProperties;
import com.google.cloud.firestore.encoding.CustomClassMapper;
import com.google.cloud.firestore.spi.v1.FirestoreRpc;
import com.google.common.collect.ImmutableList;
import com.google.firestore.v1.DatabaseRootName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.google.cloud.firestore.LocalFirestoreHelper.fromSingleQuotedString;
import static com.google.cloud.firestore.LocalFirestoreHelper.mapAnyType;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@SuppressWarnings({"unused", "WeakerAccess", "SpellCheckingInspection"})
@RunWith(MockitoJUnitRunner.class)
public class RecordMapperTest {

  @Spy
  private final FirestoreImpl firestoreMock =
      new FirestoreImpl(
          FirestoreOptions.newBuilder().setProjectId("test-project").build(),
          Mockito.mock(FirestoreRpc.class));

  private static final double EPSILON = 0.0003;

  public record StringBean (
    String value
  ){}

  public record DoubleBean (
    double value
  ){}

  public record BigDecimalBean (
    BigDecimal value
  ){}

  public record FloatBean (
    float value
  ){}

  public record LongBean (
    long value
  ){}

  public record IntBean (
    int value
  ){}

  public record BooleanBean (
    boolean value
  ){}

  public record ShortBean (
    short value
  ){}

  public record ByteBean (
    byte value
  ){}

  public record CharBean (
    char value
  ){}

  public record IntArrayBean (
    int[] values
  ){}

  public record StringArrayBean (
    String[] values
  ){}

  public record XMLAndURLBean (
    String XMLAndURL
  ){}

  public record CaseSensitiveFieldBean1 (
    String VALUE
  ){}

  public record CaseSensitiveFieldBean2 (
    String value
  ){}

  public record CaseSensitiveFieldBean3 (
    String Value
  ){}

  public record CaseSensitiveFieldBean4 (
    String valUE
  ){}

  public record NestedBean (
    StringBean bean
  ){}

  public record ObjectBean (
    Object value
  ){}

  public record GenericBean<B> (
    B value
  ){}

  public record DoubleGenericBean<A, B> (
    A valueA,
    B valueB
  ){}

  public record ListBean (
    List<String> values
  ){}

  public record SetBean (
    Set<String> values
  ){}

  public record CollectionBean (
    Collection<String> values
  ){}

  public record MapBean (
    Map<String, String> values
  ){}

  /**
   * This form is not terribly useful in Java, but Kotlin Maps are immutable and are rewritten into
   * this form (b/67470108 has more details).
   */
  public record UpperBoundedMapBean (
    Map<String, ? extends Date> values
  ){}

  public record MultiBoundedMapBean<T extends Date & Serializable> (
    Map<String, T> values
  ){}

  public record MultiBoundedMapHolderBean (
    MultiBoundedMapBean<Date> map
  ){}

  public record UnboundedMapBean (
    Map<String, ?> values
  ){}

  public record UnboundedTypeVariableMapBean<T> (
    Map<String, T> values
  ){}

  public record UnboundedTypeVariableMapHolderBean (
    UnboundedTypeVariableMapBean<String> map
  ){}

  public record NestedListBean (
    List<StringBean> values
  ){}

  public record NestedMapBean (
    Map<String, StringBean> values
  ){}

  public record IllegalKeyMapBean (
    Map<Integer, StringBean> values
  ){}

  @ThrowOnExtraProperties
  public record ThrowOnUnknownPropertiesBean (
    String value
  ){}

  @ThrowOnExtraProperties
  public record NoFieldBean(
  ){}

  public record PropertyNameBean (
    @PropertyName("my_key")
    String key,

    @PropertyName("my_value")
    String value
  ){}

  @SuppressWarnings({"NonAsciiCharacters"})
  public record UnicodeBean (
    String 漢字
  ){}

  private static <T> T deserialize(String jsonString, Class<T> clazz) {
    return deserialize(jsonString, clazz, /*docRef=*/ null);
  }

  private static <T> T deserialize(Map<String, Object> json, Class<T> clazz) {
    return deserialize(json, clazz, /*docRef=*/ null);
  }

  private static <T> T deserialize(String jsonString, Class<T> clazz, DocumentReference docRef) {
    Map<String, Object> json = fromSingleQuotedString(jsonString);
    return CustomClassMapper.convertToCustomClass(json, clazz, docRef);
  }

  private static <T> T deserialize(
      Map<String, Object> json, Class<T> clazz, DocumentReference docRef) {
    return CustomClassMapper.convertToCustomClass(json, clazz, docRef);
  }

  private static Object serialize(Object object) {
    return CustomClassMapper.convertToPlainJavaTypes(object);
  }

  private static void assertJson(String expected, Object actual) {
    assertEquals(fromSingleQuotedString(expected), actual);
  }

  private static void assertExceptionContains(String partialMessage, Runnable run) {
    try {
      run.run();
      fail("Expected exception not thrown");
    } catch (RuntimeException e) {
      assertTrue(e.getMessage().contains(partialMessage));
    }
  }

  private static <T> T convertToCustomClass(
      Object object, Class<T> clazz, DocumentReference docRef) {
    return CustomClassMapper.convertToCustomClass(object, clazz, docRef);
  }

  private static <T> T convertToCustomClass(Object object, Class<T> clazz) {
    return CustomClassMapper.convertToCustomClass(object, clazz, null);
  }

  @Test
  public void primitiveDeserializeString() {
    StringBean bean = deserialize("{'value': 'foo'}", StringBean.class);
    assertEquals("foo", bean.value());

    // Double
    try {
      deserialize("{'value': 1.1}", StringBean.class);
      fail("Should throw");
    } catch (RuntimeException e) { // ignore
    }

    // Int
    try {
      deserialize("{'value': 1}", StringBean.class);
      fail("Should throw");
    } catch (RuntimeException e) { // ignore
    }

    // Long
    try {
      deserialize("{'value': 1234567890123}", StringBean.class);
      fail("Should throw");
    } catch (RuntimeException e) { // ignore
    }

    // Boolean
    try {
      deserialize("{'value': true}", StringBean.class);
      fail("Should throw");
    } catch (RuntimeException e) { // ignore
    }
  }

  @Test
  public void primitiveDeserializeBoolean() {
    BooleanBean beanBoolean = deserialize("{'value': true}", BooleanBean.class);
    assertEquals(true, beanBoolean.value());

    // Double
    try {
      deserialize("{'value': 1.1}", BooleanBean.class);
      fail("Should throw");
    } catch (RuntimeException e) { // ignore
    }

    // Long
    try {
      deserialize("{'value': 1234567890123}", BooleanBean.class);
      fail("Should throw");
    } catch (RuntimeException e) { // ignore
    }

    // Int
    try {
      deserialize("{'value': 1}", BooleanBean.class);
      fail("Should throw");
    } catch (RuntimeException e) { // ignore
    }

    // String
    try {
      deserialize("{'value': 'foo'}", BooleanBean.class);
      fail("Should throw");
    } catch (RuntimeException e) { // ignore
    }
  }

  @Test
  public void primitiveDeserializeDouble() {
    DoubleBean beanDouble = deserialize("{'value': 1.1}", DoubleBean.class);
    assertEquals(1.1, beanDouble.value(), EPSILON);

    // Int
    DoubleBean beanInt = deserialize("{'value': 1}", DoubleBean.class);
    assertEquals(1, beanInt.value(), EPSILON);
    // Long
    DoubleBean beanLong = deserialize("{'value': 1234567890123}", DoubleBean.class);
    assertEquals(1234567890123L, beanLong.value(), EPSILON);

    // Boolean
    try {
      deserialize("{'value': true}", DoubleBean.class);
      fail("Should throw");
    } catch (RuntimeException e) { // ignore
    }

    // String
    try {
      deserialize("{'value': 'foo'}", DoubleBean.class);
      fail("Should throw");
    } catch (RuntimeException e) { // ignore
    }
  }

  @Test
  public void primitiveDeserializeBigDecimal() {
    BigDecimalBean beanBigdecimal = deserialize("{'value': 123}", BigDecimalBean.class);
    assertEquals(BigDecimal.valueOf(123.0), beanBigdecimal.value());

    beanBigdecimal = deserialize("{'value': '123'}", BigDecimalBean.class);
    assertEquals(BigDecimal.valueOf(123), beanBigdecimal.value());

    // Int
    BigDecimalBean beanInt =
        deserialize(Collections.singletonMap("value", 1), BigDecimalBean.class);
    assertEquals(BigDecimal.valueOf(1), beanInt.value());

    // Long
    BigDecimalBean beanLong =
        deserialize(Collections.singletonMap("value", 1234567890123L), BigDecimalBean.class);
    assertEquals(BigDecimal.valueOf(1234567890123L), beanLong.value());

    // Double
    BigDecimalBean beanDouble =
        deserialize(Collections.singletonMap("value", 1.1), BigDecimalBean.class);
    assertEquals(BigDecimal.valueOf(1.1), beanDouble.value());

    // BigDecimal
    BigDecimalBean beanBigDecimal =
        deserialize(
            Collections.singletonMap("value", BigDecimal.valueOf(1.2)), BigDecimalBean.class);
    assertEquals(BigDecimal.valueOf(1.2), beanBigDecimal.value());

    // Boolean
    try {
      deserialize("{'value': true}", BigDecimalBean.class);
      fail("Should throw");
    } catch (RuntimeException e) { // ignore
    }

    // String
    try {
      deserialize("{'value': 'foo'}", BigDecimalBean.class);
      fail("Should throw");
    } catch (RuntimeException e) { // ignore
    }
  }

  @Test
  public void primitiveDeserializeFloat() {
    FloatBean beanFloat = deserialize("{'value': 1.1}", FloatBean.class);
    assertEquals(1.1, beanFloat.value(), EPSILON);

    // Int
    FloatBean beanInt = deserialize(Collections.singletonMap("value", 1), FloatBean.class);
    assertEquals(1, beanInt.value(), EPSILON);
    // Long
    FloatBean beanLong =
        deserialize(Collections.singletonMap("value", 1234567890123L), FloatBean.class);
    assertEquals((float) 1234567890123L, beanLong.value(), EPSILON);

    // Boolean
    try {
      deserialize("{'value': true}", FloatBean.class);
      fail("Should throw");
    } catch (RuntimeException e) { // ignore
    }

    // String
    try {
      deserialize("{'value': 'foo'}", FloatBean.class);
      fail("Should throw");
    } catch (RuntimeException e) { // ignore
    }
  }

  @Test
  public void primitiveDeserializeInt() {
    IntBean beanInt = deserialize("{'value': 1}", IntBean.class);
    assertEquals(1, beanInt.value());

    // Double
    IntBean beanDouble = deserialize("{'value': 1.1}", IntBean.class);
    assertEquals(1, beanDouble.value());

    // Large doubles
    try {
      deserialize("{'value': 1e10}", IntBean.class);
      fail("Should throw");
    } catch (RuntimeException e) { // ignore
    }

    // Long
    try {
      deserialize("{'value': 1234567890123}", IntBean.class);
      fail("Should throw");
    } catch (RuntimeException e) { // ignore
    }

    // Boolean
    try {
      deserialize("{'value': true}", IntBean.class);
      fail("Should throw");
    } catch (RuntimeException e) { // ignore
    }

    // String
    try {
      deserialize("{'value': 'foo'}", IntBean.class);
      fail("Should throw");
    } catch (RuntimeException e) { // ignore
    }
  }

  @Test
  public void primitiveDeserializeLong() {
    LongBean beanLong = deserialize("{'value': 1234567890123}", LongBean.class);
    assertEquals(1234567890123L, beanLong.value());

    // Int
    LongBean beanInt = deserialize("{'value': 1}", LongBean.class);
    assertEquals(1, beanInt.value());

    // Double
    LongBean beanDouble = deserialize("{'value': 1.1}", LongBean.class);
    assertEquals(1, beanDouble.value());

    // Large doubles
    try {
      deserialize("{'value': 1e300}", LongBean.class);
      fail("Should throw");
    } catch (RuntimeException e) { // ignore
    }

    // Boolean
    try {
      deserialize("{'value': true}", LongBean.class);
      fail("Should throw");
    } catch (RuntimeException e) { // ignore
    }

    // String
    try {
      deserialize("{'value': 'foo'}", LongBean.class);
      fail("Should throw");
    } catch (RuntimeException e) { // ignore
    }
  }

  @Test
  public void primitiveDeserializeWrongTypeMap() {
    String expectedExceptionMessage =
        ".* Failed to convert value of type .*Map to String \\(found in field 'value'\\).*";
    Throwable exception =
        assertThrows(
            RuntimeException.class,
            () -> deserialize("{'value': {'foo': 'bar'}}", StringBean.class));
    assertTrue(exception.getMessage().matches(expectedExceptionMessage));
  }

  @Test
  public void primitiveDeserializeWrongTypeList() {
    assertExceptionContains(
        "Failed to convert value of type java.util.ArrayList to String"
            + " (found in field 'value')",
        () -> deserialize("{'value': ['foo']}", StringBean.class));
  }

  @Test
  public void noFieldDeserialize() {
    assertExceptionContains(
        "No properties to serialize found on class "
            + "com.google.cloud.firestore.RecordMapperTest$NoFieldBean",
        () -> deserialize("{'value': 'foo'}", NoFieldBean.class));
  }

  @Test
  public void throwOnUnknownProperties() {
    assertExceptionContains(
        "No accessor for unknown found on class "
            + "com.google.cloud.firestore.RecordMapperTest$ThrowOnUnknownPropertiesBean",
        () ->
            deserialize("{'value': 'foo', 'unknown': 'bar'}", ThrowOnUnknownPropertiesBean.class));
  }

  @Test
  public void XMLAndURLBean() {
    XMLAndURLBean bean =
        deserialize("{'XMLAndURL': 'foo'}", XMLAndURLBean.class);
    assertEquals("foo", bean.XMLAndURL());
  }

  public record AllCapsDefaultHandlingBean (
    String UUID
  ){}

  @Test
  public void allCapsSerializesToUppercaseByDefault() {
    AllCapsDefaultHandlingBean bean = new AllCapsDefaultHandlingBean("value");
    assertJson("{'UUID': 'value'}", serialize(bean));
    AllCapsDefaultHandlingBean deserialized =
        deserialize("{'UUID': 'value'}", AllCapsDefaultHandlingBean.class);
    assertEquals("value", deserialized.UUID());
  }

  public record AllCapsWithPropertyName (
    @PropertyName("uuid")
    String UUID
  ){}

  @Test
  public void allCapsWithPropertyNameSerializesToLowercase() {
    AllCapsWithPropertyName bean = new AllCapsWithPropertyName("value");
    assertJson("{'uuid': 'value'}", serialize(bean));
    AllCapsWithPropertyName deserialized =
        deserialize("{'uuid': 'value'}", AllCapsWithPropertyName.class);
    assertEquals("value", deserialized.UUID());
  }

  @Test
  public void nestedParsingWorks() {
    NestedBean bean = deserialize("{'bean': {'value': 'foo'}}", NestedBean.class);
    assertEquals("foo", bean.bean().value());
  }

  @Test
  public void beansCanContainLists() {
    ListBean bean = deserialize("{'values': ['foo', 'bar']}", ListBean.class);
    assertEquals(Arrays.asList("foo", "bar"), bean.values());
  }

  @Test
  public void beansCanContainMaps() {
    MapBean bean = deserialize("{'values': {'foo': 'bar'}}", MapBean.class);
    Map<String, Object> expected = fromSingleQuotedString("{'foo': 'bar'}");
    assertEquals(expected, bean.values());
  }

  @Test
  public void beansCanContainUpperBoundedMaps() {
    Date date = new Date(1491847082123L);
    Map<String, Object>  source = mapAnyType("values", mapAnyType("foo", date));
    UpperBoundedMapBean bean = convertToCustomClass(source, UpperBoundedMapBean.class);
    Map<String, Object>  expected = mapAnyType("foo", date);
    assertEquals(expected, bean.values());
  }

  @Test
  public void beansCanContainMultiBoundedMaps() {
    Date date = new Date(1491847082123L);
    Map<String, Object> source = mapAnyType("map", mapAnyType("values", mapAnyType("foo", date)));
    MultiBoundedMapHolderBean bean = convertToCustomClass(source, MultiBoundedMapHolderBean.class);

    Map<String, Object> expected = mapAnyType("foo", date);
    assertEquals(expected, bean.map().values());
  }

  @Test
  public void beansCanContainUnboundedMaps() {
    UnboundedMapBean bean = deserialize("{'values': {'foo': 'bar'}}", UnboundedMapBean.class);
    Map<String, Object> expected = mapAnyType("foo", "bar");
    assertEquals(expected, bean.values());
  }

  @Test
  public void beansCanContainUnboundedTypeVariableMaps() {
    Map<String, Object> source = mapAnyType("map", mapAnyType("values", mapAnyType("foo", "bar")));
    UnboundedTypeVariableMapHolderBean bean =
        convertToCustomClass(source, UnboundedTypeVariableMapHolderBean.class);

        Map<String, Object> expected = mapAnyType("foo", "bar");
    assertEquals(expected, bean.map().values());
  }

  @Test
  public void beansCanContainNestedUnboundedMaps() {
    UnboundedMapBean bean =
        deserialize("{'values': {'foo': {'bar': 'baz'}}}", UnboundedMapBean.class);
        Map<String, Object> expected = mapAnyType("foo", mapAnyType("bar", "baz"));
    assertEquals(expected, bean.values());
  }

  @Test
  public void beansCanContainBeanLists() {
    NestedListBean bean = deserialize("{'values': [{'value': 'foo'}]}", NestedListBean.class);
    assertEquals(1, bean.values().size());
    assertEquals("foo", bean.values().get(0).value());
  }

  @Test
  public void beansCanContainBeanMaps() {
    NestedMapBean bean = deserialize("{'values': {'key': {'value': 'foo'}}}", NestedMapBean.class);
    assertEquals(1, bean.values().size());
    assertEquals("foo", bean.values().get("key").value());
  }

  @Test
  public void beanMapsMustHaveStringKeys() {
    assertExceptionContains(
        "Only Maps with string keys are supported, but found Map with key type class "
            + "java.lang.Integer (found in field 'values')",
        () -> deserialize("{'values': {'1': 'bar'}}", IllegalKeyMapBean.class));
  }

  @Test
  public void serializeStringBean() {
    StringBean bean = new StringBean("foo");
    assertJson("{'value': 'foo'}", serialize(bean));
  }

  @Test
  public void serializeDoubleBean() {
    DoubleBean bean = new DoubleBean(1.1);
    assertJson("{'value': 1.1}", serialize(bean));
  }

  @Test
  public void serializeIntBean() {
    IntBean bean = new IntBean(1);
    assertJson("{'value': 1}", serialize(Collections.singletonMap("value", 1.0)));
  }

  @Test
  public void serializeLongBean() {
    LongBean bean = new LongBean(1234567890123L);
    assertJson(
        "{'value': 1.234567890123E12}",
        serialize(Collections.singletonMap("value", 1.234567890123E12)));
  }

  @Test
  public void serializeBigDecimalBean() {
    BigDecimalBean bean = new BigDecimalBean(BigDecimal.valueOf(1.1));
    assertEquals(mapAnyType("value", "1.1"), serialize(bean));
  }

  @Test
  public void bigDecimalRoundTrip() {
    BigDecimal doubleMaxPlusOne = BigDecimal.valueOf(Double.MAX_VALUE).add(BigDecimal.ONE);
    BigDecimalBean a = new BigDecimalBean(doubleMaxPlusOne);
    Map<String, Object> serialized = (Map<String, Object>) serialize(a);
    BigDecimalBean b = convertToCustomClass(serialized, BigDecimalBean.class);
    assertEquals(a, b);
  }

  @Test
  public void serializeBooleanBean() {
    BooleanBean bean = new BooleanBean(true);
    assertJson("{'value': true}", serialize(bean));
  }

  @Test
  public void serializeFloatBean() {
    FloatBean bean = new FloatBean(0.5f);

    // We don't use assertJson as it converts all floating point numbers to Double.
    assertEquals(mapAnyType("value", 0.5f), serialize(bean));
  }

  @Test
  public void serializePrivateFieldBean() {
    final NoFieldBean bean = new NoFieldBean();
    assertExceptionContains(
        "No properties to serialize found on class "
            + "com.google.cloud.firestore.RecordMapperTest$NoFieldBean",
        () -> serialize(bean));
  }

  @Test
  public void nestedSerializingWorks() {
    NestedBean bean = new NestedBean(new StringBean("foo"));
    assertJson("{'bean': {'value': 'foo'}}", serialize(bean));
  }

  @Test
  public void serializingListsWorks() {
    ListBean bean = new ListBean(Arrays.asList("foo", "bar"));
    assertJson("{'values': ['foo', 'bar']}", serialize(bean));
  }

  @Test
  public void serializingMapsWorks() {
    MapBean bean = new MapBean(new HashMap<>());
    bean.values().put("foo", "bar");
    assertJson("{'values': {'foo': 'bar'}}", serialize(bean));
  }

  @Test
  public void serializingUpperBoundedMapsWorks() {
    Date date = new Date(1491847082123L);
    UpperBoundedMapBean bean = new UpperBoundedMapBean(Map.of("foo", date));
    Map<String, Object> expected =
        mapAnyType("values", mapAnyType("foo", new Date(date.getTime())));
    assertEquals(expected, serialize(bean));
  }

  @Test
  public void serializingMultiBoundedObjectsWorks() {
    Date date = new Date(1491847082123L);

    HashMap<String, Date> values = new HashMap<String, Date>();
    values.put("foo", date);

    MultiBoundedMapHolderBean holder = new MultiBoundedMapHolderBean(new MultiBoundedMapBean<>(values));

    Map<String, Object> expected =
        mapAnyType("map", mapAnyType("values", mapAnyType("foo", new Date(date.getTime()))));
    assertEquals(expected, serialize(holder));
  }

  @Test
  public void serializeListOfBeansWorks() {
    StringBean stringBean = new StringBean("foo");

    NestedListBean bean = new NestedListBean(new ArrayList<>());
    bean.values().add(stringBean);

    assertJson("{'values': [{'value': 'foo'}]}", serialize(bean));
  }

  @Test
  public void serializeMapOfBeansWorks() {
    StringBean stringBean = new StringBean("foo");

    NestedMapBean bean = new NestedMapBean(new HashMap<>());
    bean.values().put("key", stringBean);

    assertJson("{'values': {'key': {'value': 'foo'}}}", serialize(bean));
  }

  @Test
  public void beanMapsMustHaveStringKeysForSerializing() {
    StringBean stringBean = new StringBean("foo");

    final IllegalKeyMapBean bean = new IllegalKeyMapBean(new HashMap<>());
    bean.values().put(1, stringBean);

    assertExceptionContains(
        "Maps with non-string keys are not supported (found in field 'values')",
        () -> serialize(bean));
  }

  @Test
  public void serializeUPPERCASE() {
    XMLAndURLBean bean = new XMLAndURLBean("foo");
    assertJson("{'XMLAndURL': 'foo'}", serialize(bean));
  }

  @Test
  public void roundTripCaseSensitiveFieldBean1() {
    CaseSensitiveFieldBean1 bean = new CaseSensitiveFieldBean1("foo");
    assertJson("{'VALUE': 'foo'}", serialize(bean));
    CaseSensitiveFieldBean1 deserialized =
        deserialize("{'VALUE': 'foo'}", CaseSensitiveFieldBean1.class);
    assertEquals("foo", deserialized.VALUE());
  }

  @Test
  public void roundTripCaseSensitiveFieldBean2() {
    CaseSensitiveFieldBean2 bean = new CaseSensitiveFieldBean2("foo");
    assertJson("{'value': 'foo'}", serialize(bean));
    CaseSensitiveFieldBean2 deserialized =
        deserialize("{'value': 'foo'}", CaseSensitiveFieldBean2.class);
    assertEquals("foo", deserialized.value());
  }

  @Test
  public void roundTripCaseSensitiveFieldBean3() {
    CaseSensitiveFieldBean3 bean = new CaseSensitiveFieldBean3("foo");
    assertJson("{'Value': 'foo'}", serialize(bean));
    CaseSensitiveFieldBean3 deserialized =
        deserialize("{'Value': 'foo'}", CaseSensitiveFieldBean3.class);
    assertEquals("foo", deserialized.Value());
  }

  @Test
  public void roundTripCaseSensitiveFieldBean4() {
    CaseSensitiveFieldBean4 bean = new CaseSensitiveFieldBean4("foo");
    assertJson("{'valUE': 'foo'}", serialize(bean));
    CaseSensitiveFieldBean4 deserialized =
        deserialize("{'valUE': 'foo'}", CaseSensitiveFieldBean4.class);
    assertEquals("foo", deserialized.valUE());
  }

  @Test
  public void roundTripUnicodeBean() {
    UnicodeBean bean = new UnicodeBean("foo");
    assertJson("{'漢字': 'foo'}", serialize(bean));
    UnicodeBean deserialized = deserialize("{'漢字': 'foo'}", UnicodeBean.class);
    assertEquals("foo", deserialized.漢字());
  }

  @Test
  public void shortsCantBeSerialized() {
    final ShortBean bean = new ShortBean((short) 1);
    assertExceptionContains(
        "Numbers of type Short are not supported, please use an int, long, float, double or BigDecimal (found in field 'value')",
        () -> serialize(bean));
  }

  @Test
  public void bytesCantBeSerialized() {
    final ByteBean bean = new ByteBean((byte) 1);
    assertExceptionContains(
        "Numbers of type Byte are not supported, please use an int, long, float, double or BigDecimal (found in field 'value')",
        () -> serialize(bean));
  }

  @Test
  public void charsCantBeSerialized() {
    final CharBean bean = new CharBean((char) 1);
    assertExceptionContains(
        "Characters are not supported, please use Strings (found in field 'value')",
        () -> serialize(bean));
  }

  @Test
  public void intArraysCantBeSerialized() {
    final IntArrayBean bean = new IntArrayBean(new int[] {1});
    assertExceptionContains(
        "Serializing Arrays is not supported, please use Lists instead "
            + "(found in field 'values')",
        () -> serialize(bean));
  }

  @Test
  public void objectArraysCantBeSerialized() {
    final StringArrayBean bean = new StringArrayBean(new String[] {"foo"});
    assertExceptionContains(
        "Serializing Arrays is not supported, please use Lists instead "
            + "(found in field 'values')",
        () -> serialize(bean));
  }

  @Test
  public void shortsCantBeDeserialized() {
    assertExceptionContains(
        "Deserializing values to short is not supported (found in field 'value')",
        () -> deserialize("{'value': 1}", ShortBean.class));
  }

  @Test
  public void bytesCantBeDeserialized() {
    assertExceptionContains(
        "Deserializing values to byte is not supported (found in field 'value')",
        () -> deserialize("{'value': 1}", ByteBean.class));
  }

  @Test
  public void charsCantBeDeserialized() {
    assertExceptionContains(
        "Deserializing values to char is not supported (found in field 'value')",
        () -> deserialize("{'value': '1'}", CharBean.class));
  }

  @Test
  public void intArraysCantBeDeserialized() {
    assertExceptionContains(
        "Converting to Arrays is not supported, please use Lists instead (found in field 'values')",
        () -> deserialize("{'values': [1]}", IntArrayBean.class));
  }

  @Test
  public void objectArraysCantBeDeserialized() {
    assertExceptionContains(
        "Could not deserialize object. Converting to Arrays is not supported, please use Lists "
            + "instead (found in field 'values')",
        () -> deserialize("{'values': ['foo']}", StringArrayBean.class));
  }

  @Test
  public void objectAcceptsAnyObject() {
    ObjectBean stringValue = deserialize("{'value': 'foo'}", ObjectBean.class);
    assertEquals("foo", stringValue.value());
    ObjectBean listValue = deserialize("{'value': ['foo']}", ObjectBean.class);
    assertEquals(Collections.singletonList("foo"), listValue.value());
    ObjectBean mapValue = deserialize("{'value': {'foo':'bar'}}", ObjectBean.class);
    assertEquals(fromSingleQuotedString("{'foo':'bar'}"), mapValue.value());
    String complex = "{'value': {'foo':['bar', ['baz'], {'bam': 'qux'}]}, 'other':{'a': ['b']}}";
    ObjectBean complexValue = deserialize(complex, ObjectBean.class);
    assertEquals(fromSingleQuotedString(complex).get("value"), complexValue.value());
  }

  @Test
  public void passingInGenericBeanTopLevelThrows() {
    assertExceptionContains(
        "Class com.google.cloud.firestore.RecordMapperTest$GenericBean has generic type "
            + "parameters, please use GenericTypeIndicator instead",
        () -> deserialize("{'value': 'foo'}", GenericBean.class));
  }

  @Test
  public void collectionsCanBeSerializedWhenList() {
    CollectionBean bean = new CollectionBean(Collections.singletonList("foo"));
    assertJson("{'values': ['foo']}", serialize(bean));
  }

  @Test
  public void collectionsCantBeSerializedWhenSet() {
    final CollectionBean bean = new CollectionBean(Collections.singleton("foo"));
    assertExceptionContains(
        "Serializing Collections is not supported, please use Lists instead "
            + "(found in field 'values')",
        () -> serialize(bean));
  }

  @Test
  public void collectionsCantBeDeserialized() {
    assertExceptionContains(
        "Collections are not supported, please use Lists instead (found in field 'values')",
        () -> deserialize("{'values': ['foo']}", CollectionBean.class));
  }

  @Test
  public void serializingGenericBeansSupported() {
    GenericBean<String> stringBean = new GenericBean<String>("foo");
    assertJson("{'value': 'foo'}", serialize(stringBean));

    GenericBean<Map<String, String>> mapBean = new GenericBean<Map<String, String>>(Collections.singletonMap("foo", "bar"));
    assertJson("{'value': {'foo': 'bar'}}", serialize(mapBean));

    GenericBean<List<String>> listBean = new GenericBean<List<String>>(Collections.singletonList("foo"));
    assertJson("{'value': ['foo']}", serialize(listBean));

    GenericBean<GenericBean<String>> recursiveBean = new GenericBean<GenericBean<String>>(new GenericBean<>("foo"));
    assertJson("{'value': {'value': 'foo'}}", serialize(recursiveBean));

    DoubleGenericBean<String, Double>  doubleBean = new DoubleGenericBean<String, Double>("foo", 1.0);
    assertJson("{'valueB': 1, 'valueA': 'foo'}", serialize(doubleBean));
  }

  @Test
  public void propertyNamesAreSerialized() {
    PropertyNameBean bean = new PropertyNameBean("foo", "bar");

    assertJson("{'my_key': 'foo', 'my_value': 'bar'}", serialize(bean));
  }

  @Test
  public void propertyNamesAreParsed() {
    PropertyNameBean bean =
        deserialize("{'my_key': 'foo', 'my_value': 'bar'}", PropertyNameBean.class);
    assertEquals("foo", bean.key());
    assertEquals("bar", bean.value());
  }

  // Bean definitions with @DocumentId applied to wrong type.
  public record FieldWithDocumentIdOnWrongTypeBean (
                  @DocumentId Integer intField
  ){}

  public record PropertyWithDocumentIdOnWrongTypeBean (
    @PropertyName("intField")
    @DocumentId
    int intField
  ){}

  @Test
  public void documentIdAnnotateWrongTypeThrows() {
    final String expectedErrorMessage = "instead of String or DocumentReference";
    assertExceptionContains(
        expectedErrorMessage, () -> serialize(new FieldWithDocumentIdOnWrongTypeBean(100)));
    assertExceptionContains(
        expectedErrorMessage,
        () -> deserialize("{'intField': 1}", FieldWithDocumentIdOnWrongTypeBean.class));

    assertExceptionContains(
        expectedErrorMessage, () -> serialize(new PropertyWithDocumentIdOnWrongTypeBean(100)));
    assertExceptionContains(
        expectedErrorMessage,
        () -> deserialize("{'intField': 1}", PropertyWithDocumentIdOnWrongTypeBean.class));
  }

  public record DocumentIdOnStringField (
    @DocumentId String docId
  ){}

  public record DocumentIdOnStringFieldAsProperty (
    @PropertyName("docIdProperty")
    @DocumentId
    String docId,

    @PropertyName("anotherProperty")
    int someOtherProperty
  ){}

  public record DocumentIdOnNestedObjects (
    @PropertyName("nestedDocIdHolder")
    DocumentIdOnStringField nestedDocIdHolder
  ){}

  @Test
  public void documentIdsDeserialize() {
    DocumentReference ref =
        new DocumentReference(
            firestoreMock,
            ResourcePath.create(
                            DatabaseRootName.of("test-project", "(default)"),
                            ImmutableList.of("coll", "doc123")));

    assertEquals("doc123", deserialize("{}", DocumentIdOnStringField.class, ref).docId());

    assertEquals(
        "doc123",
        deserialize(Collections.singletonMap("property", 100), DocumentIdOnStringField.class, ref)
            .docId());

            DocumentIdOnStringFieldAsProperty target =
        deserialize("{'anotherProperty': 100}", DocumentIdOnStringFieldAsProperty.class, ref);
    assertEquals("doc123", target.docId());
    assertEquals(100, target.someOtherProperty());

    assertEquals(
        "doc123",
        deserialize("{'nestedDocIdHolder': {}}", DocumentIdOnNestedObjects.class, ref)
            .nestedDocIdHolder()
            .docId());
  }

  @Test
  public void documentIdsRoundTrip() {
    // Implicitly verifies @DocumentId is ignored during serialization.

    final DocumentReference ref =
        new DocumentReference(
            firestoreMock,
            ResourcePath.create(
                DatabaseRootName.of("test-project", "(default)"),
                ImmutableList.of("coll", "doc123")));

    assertEquals(
        Collections.emptyMap(), serialize(deserialize("{}", DocumentIdOnStringField.class, ref)));

    assertEquals(
        Collections.singletonMap("anotherProperty", 100),
        serialize(
            deserialize("{'anotherProperty': 100}", DocumentIdOnStringFieldAsProperty.class, ref)));

    assertEquals(
        Collections.singletonMap("nestedDocIdHolder", Collections.emptyMap()),
        serialize(deserialize("{'nestedDocIdHolder': {}}", DocumentIdOnNestedObjects.class, ref)));
  }

  @Test
  public void documentIdsDeserializeConflictThrows() {
    final String expectedErrorMessage = "cannot apply @DocumentId on this property";
    final DocumentReference ref =
        new DocumentReference(
            firestoreMock,
            ResourcePath.create(
                DatabaseRootName.of("test-project", "(default)"),
                ImmutableList.of("coll", "doc123")));

    assertExceptionContains(
        expectedErrorMessage,
        () -> deserialize("{'docId': 'toBeOverwritten'}", DocumentIdOnStringField.class, ref));

    assertExceptionContains(
        expectedErrorMessage,
        () ->
            deserialize(
                "{'docIdProperty': 'toBeOverwritten', 'anotherProperty': 100}",
                DocumentIdOnStringFieldAsProperty.class,
                ref));

    assertExceptionContains(
        expectedErrorMessage,
        () ->
            deserialize(
                "{'nestedDocIdHolder': {'docId': 'toBeOverwritten'}}",
                DocumentIdOnNestedObjects.class,
                ref));
  }
}
