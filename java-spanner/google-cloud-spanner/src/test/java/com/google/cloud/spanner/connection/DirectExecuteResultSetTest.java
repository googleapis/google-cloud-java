/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.connection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.ResultSets;
import com.google.cloud.spanner.SingerProto.Genre;
import com.google.cloud.spanner.SingerProto.SingerInfo;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Type.StructField;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ProtocolMessageEnum;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DirectExecuteResultSetTest {

  private DirectExecuteResultSet createSubject() {
    ResultSet delegate =
        ResultSets.forRows(
            Type.struct(StructField.of("test", Type.int64())),
            Collections.singletonList(Struct.newBuilder().set("test").to(1L).build()));
    return DirectExecuteResultSet.ofResultSet(delegate);
  }

  @Test
  public void testMethodCallBeforeNext()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    List<String> excludedMethods =
        Arrays.asList(
            "canGetProtobufValue",
            "getStats",
            "getMetadata",
            "next",
            "close",
            "ofResultSet",
            "equals",
            "hashCode",
            "getType",
            "getColumnCount",
            "getColumnIndex",
            "getColumnType");
    DirectExecuteResultSet subject = createSubject();
    callMethods(subject, excludedMethods, IllegalStateException.class);
  }

  @Test
  public void testMethodCallAfterClose()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    List<String> excludedMethods =
        Arrays.asList(
            "canGetProtobufValue",
            "getStats",
            "getMetadata",
            "next",
            "close",
            "getType",
            "getColumnCount",
            "getColumnIndex",
            "getColumnType",
            "ofResultSet",
            "equals",
            "hashCode");
    DirectExecuteResultSet subject = createSubject();
    subject.next();
    subject.close();
    callMethods(subject, excludedMethods, IllegalStateException.class);
  }

  @Test
  public void testMethodCallAfterNextHasReturnedFalse()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    List<String> excludedMethods =
        Arrays.asList(
            "canGetProtobufValue",
            "getStats",
            "getMetadata",
            "next",
            "close",
            "getType",
            "getColumnCount",
            "getColumnIndex",
            "getColumnType",
            "ofResultSet",
            "equals",
            "hashCode");
    DirectExecuteResultSet subject = createSubject();
    subject.next();
    subject.next();
    callMethods(subject, excludedMethods, IndexOutOfBoundsException.class);
  }

  private void callMethods(
      DirectExecuteResultSet subject,
      List<String> excludedMethods,
      Class<? extends Exception> expectedException)
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    for (Method method : DirectExecuteResultSet.class.getDeclaredMethods()) {
      if (Modifier.isPublic(method.getModifiers()) && !excludedMethods.contains(method.getName())) {
        boolean exception = false;
        int numberOfParameters = method.getParameterTypes().length;
        Class<?> firstParameterType = null;
        if (numberOfParameters >= 1) {
          firstParameterType = method.getParameterTypes()[0];
        }
        try {
          switch (numberOfParameters) {
            case 0:
              method.invoke(subject);
              break;
            case 1:
              if (firstParameterType == String.class) {
                method.invoke(subject, "test");
              } else if (firstParameterType == int.class) {
                method.invoke(subject, 0);
              } else {
                fail("unknown parameter type");
              }
              break;
            case 2:
              Class<?> secondParameterType = method.getParameterTypes()[1];
              Object firstArgument = null, secondArgument = null;

              if (firstParameterType == String.class) {
                firstArgument = "test";
              } else if (firstParameterType == int.class) {
                firstArgument = 0;
              }

              if (secondParameterType == Function.class) {
                Function<Long, ProtocolMessageEnum> lambdaFunction =
                    (val) -> Genre.forNumber(val.intValue());
                secondArgument = lambdaFunction;
              } else if (secondParameterType == AbstractMessage.class) {
                secondArgument = SingerInfo.getDefaultInstance();
              }

              if (firstArgument != null && secondArgument != null) {
                method.invoke(subject, firstArgument, secondArgument);
              } else {
                fail("unknown parameter type");
              }
              break;
            default:
              fail("method with more than 2 parameters is unknown");
          }
        } catch (InvocationTargetException e) {
          if (e.getCause().getClass().equals(expectedException)) {
            // expected
            exception = true;
          } else {
            throw e;
          }
        }
        assertThat(
            method.getName() + " did not throw an IllegalStateException", exception, is(true));
      }
    }
  }

  @Test
  public void testValidMethodCall() throws IllegalArgumentException {
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(true, true, false);
    DirectExecuteResultSet subject = DirectExecuteResultSet.ofResultSet(delegate);
    subject.next();

    subject.getBoolean(0);
    verify(delegate).getBoolean(0);
    subject.getBoolean("test0");
    verify(delegate).getBoolean("test0");
    subject.getBooleanArray(1);
    verify(delegate).getBooleanArray(1);
    subject.getBooleanArray("test1");
    verify(delegate).getBooleanArray("test1");
    subject.getBooleanList(2);
    verify(delegate).getBooleanList(2);
    subject.getBooleanList("test2");
    verify(delegate).getBooleanList("test2");

    subject.getBytes(0);
    verify(delegate).getBytes(0);
    subject.getBytes("test0");
    verify(delegate).getBytes("test0");
    subject.getBytesList(2);
    verify(delegate).getBytesList(2);
    subject.getBytesList("test2");
    verify(delegate).getBytesList("test2");

    subject.getDate(0);
    verify(delegate).getDate(0);
    subject.getDate("test0");
    verify(delegate).getDate("test0");
    subject.getDateList(2);
    verify(delegate).getDateList(2);
    subject.getDateList("test2");
    verify(delegate).getDateList("test2");

    subject.getDouble(0);
    verify(delegate).getDouble(0);
    subject.getDouble("test0");
    verify(delegate).getDouble("test0");
    subject.getDoubleArray(1);
    verify(delegate).getDoubleArray(1);
    subject.getDoubleArray("test1");
    verify(delegate).getDoubleArray("test1");
    subject.getDoubleList(2);
    verify(delegate).getDoubleList(2);
    subject.getDoubleList("test2");
    verify(delegate).getDoubleList("test2");

    subject.getBigDecimal(0);
    verify(delegate).getBigDecimal(0);
    subject.getBigDecimal("test0");
    verify(delegate).getBigDecimal("test0");
    subject.getBigDecimalList(1);
    verify(delegate).getBigDecimalList(1);
    subject.getBigDecimalList("test1");
    verify(delegate).getBigDecimalList("test1");
    subject.getBigDecimalList(2);
    verify(delegate).getBigDecimalList(2);
    subject.getBigDecimalList("test2");
    verify(delegate).getBigDecimalList("test2");

    subject.getLong(0);
    verify(delegate).getLong(0);
    subject.getLong("test0");
    verify(delegate).getLong("test0");
    subject.getLongArray(1);
    verify(delegate).getLongArray(1);
    subject.getLongArray("test1");
    verify(delegate).getLongArray("test1");
    subject.getLongList(2);
    verify(delegate).getLongList(2);
    subject.getLongList("test2");
    verify(delegate).getLongList("test2");

    subject.getString(0);
    verify(delegate).getString(0);
    subject.getString("test0");
    verify(delegate).getString("test0");
    subject.getStringList(2);
    verify(delegate).getStringList(2);
    subject.getStringList("test2");
    verify(delegate).getStringList("test2");

    subject.getJson(0);
    verify(delegate).getJson(0);
    subject.getJson("test0");
    verify(delegate).getJson("test0");
    subject.getJsonList(2);
    verify(delegate).getJsonList(2);
    subject.getJsonList("test2");
    verify(delegate).getJsonList("test2");

    subject.getPgJsonb(0);
    verify(delegate).getPgJsonb(0);
    subject.getPgJsonb("test0");
    verify(delegate).getPgJsonb("test0");
    subject.getPgJsonbList(2);
    verify(delegate).getPgJsonbList(2);
    subject.getPgJsonbList("test2");
    verify(delegate).getPgJsonbList("test2");

    subject.getProtoMessage(0, SingerInfo.getDefaultInstance());
    verify(delegate).getProtoMessage(0, SingerInfo.getDefaultInstance());
    subject.getProtoMessage("test0", SingerInfo.getDefaultInstance());
    verify(delegate).getProtoMessage("test0", SingerInfo.getDefaultInstance());
    subject.getProtoMessageList(0, SingerInfo.getDefaultInstance());
    verify(delegate).getProtoMessageList(0, SingerInfo.getDefaultInstance());
    subject.getProtoMessageList("test0", SingerInfo.getDefaultInstance());
    verify(delegate).getProtoMessageList("test0", SingerInfo.getDefaultInstance());

    Function<Integer, ProtocolMessageEnum> lambdaFunction = Genre::forNumber;
    subject.getProtoEnum(0, lambdaFunction);
    verify(delegate).getProtoEnum(0, lambdaFunction);
    subject.getProtoEnum("test0", lambdaFunction);
    verify(delegate).getProtoEnum("test0", lambdaFunction);
    subject.getProtoEnumList(0, lambdaFunction);
    verify(delegate).getProtoEnumList(0, lambdaFunction);
    subject.getProtoEnumList("test0", lambdaFunction);
    verify(delegate).getProtoEnumList("test0", lambdaFunction);

    subject.getStructList(0);
    subject.getStructList("test0");

    subject.getTimestamp(0);
    verify(delegate).getTimestamp(0);
    subject.getTimestamp("test0");
    verify(delegate).getTimestamp("test0");
    subject.getTimestampList(2);
    verify(delegate).getTimestampList(2);
    subject.getTimestampList("test2");
    verify(delegate).getTimestampList("test2");

    subject.getColumnCount();
    verify(delegate).getColumnCount();
    subject.getColumnIndex("test");
    verify(delegate).getColumnIndex("test");
    subject.getColumnType(100);
    verify(delegate).getColumnType(100);
    subject.getColumnType("test");
    verify(delegate).getColumnType("test");
    subject.getCurrentRowAsStruct();
    verify(delegate).getCurrentRowAsStruct();
    subject.getType();
    verify(delegate).getType();
    subject.isNull(50);
    verify(delegate).isNull(50);
    subject.isNull("test");
    verify(delegate).isNull("test");

    while (subject.next()) {
      // ignore
    }
    subject.getStats();
    verify(delegate).getStats();
  }
}
