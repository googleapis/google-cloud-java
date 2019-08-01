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

package com.google.cloud.spanner.jdbc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.ResultSets;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Type.StructField;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ReplaceableForwardingResultSetTest {

  private ReplaceableForwardingResultSet createSubject() {
    ResultSet delegate =
        ResultSets.forRows(
            Type.struct(StructField.of("test", Type.int64())),
            Arrays.asList(Struct.newBuilder().set("test").to(1L).build()));
    return new ReplaceableForwardingResultSet(delegate);
  }

  @Test
  public void testReplace() {
    ResultSet delegate1 =
        ResultSets.forRows(
            Type.struct(StructField.of("test", Type.int64())),
            Arrays.asList(
                Struct.newBuilder().set("test").to(1L).build(),
                Struct.newBuilder().set("test").to(2L).build()));
    // First verify the behavior without replacing.
    try (ResultSet rs = new ReplaceableForwardingResultSet(delegate1)) {
      assertThat(rs.next(), is(true));
      assertThat(rs.getLong("test"), is(equalTo(1L)));
      assertThat(rs.next(), is(true));
      assertThat(rs.getLong("test"), is(equalTo(2L)));
      assertThat(rs.next(), is(false));
    }

    delegate1 =
        ResultSets.forRows(
            Type.struct(StructField.of("test", Type.int64())),
            Arrays.asList(
                Struct.newBuilder().set("test").to(1L).build(),
                Struct.newBuilder().set("test").to(2L).build()));
    ResultSet delegate2 =
        ResultSets.forRows(
            Type.struct(StructField.of("test", Type.int64())),
            Arrays.asList(
                Struct.newBuilder().set("test").to(1L).build(),
                Struct.newBuilder().set("test").to(3L).build()));
    // Then verify the behavior with replacing.
    try (ReplaceableForwardingResultSet rs = new ReplaceableForwardingResultSet(delegate1)) {
      assertThat(rs.next(), is(true));
      assertThat(rs.getLong("test"), is(equalTo(1L)));
      // Advance the delegate result set that will be used as replacement.
      delegate2.next();
      // Replace the result set.
      rs.replaceDelegate(delegate2);
      // Verify that the replacement is being used.
      assertThat(rs.next(), is(true));
      assertThat(rs.getLong("test"), is(equalTo(3L)));
      assertThat(rs.next(), is(false));
    }
  }

  @Test
  public void testMethodCallBeforeNext()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    List<String> excludedMethods = Arrays.asList("getStats", "next", "close", "equals", "hashCode");
    ReplaceableForwardingResultSet subject = createSubject();
    // Test that all methods throw an IllegalStateException except the excluded methods when called
    // before a call to ResultSet#next().
    callMethods(subject, excludedMethods, IllegalStateException.class);
  }

  @Test
  public void testMethodCallAfterClose()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    List<String> excludedMethods =
        Arrays.asList(
            "getStats",
            "next",
            "close",
            "getType",
            "getColumnCount",
            "getColumnIndex",
            "getColumnType",
            "ofResultSet",
            "equals",
            "hashCode");
    ReplaceableForwardingResultSet subject = createSubject();
    subject.next();
    subject.close();
    // Test that all methods throw an SpannerException except the excluded methods when called on a
    // closed ResultSet.
    callMethods(subject, excludedMethods, SpannerException.class);
  }

  @Test
  public void testMethodCallAfterNextHasReturnedFalse()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    List<String> excludedMethods =
        Arrays.asList(
            "getStats",
            "next",
            "close",
            "getType",
            "getColumnCount",
            "getColumnIndex",
            "getColumnType",
            "ofResultSet",
            "equals",
            "hashCode");
    ReplaceableForwardingResultSet subject = createSubject();
    subject.next();
    subject.next();
    // Test that all methods throw an IndexOutOfBoundsException except the excluded methods when
    // called after a call to ResultSet#next() has returned false.
    callMethods(subject, excludedMethods, IndexOutOfBoundsException.class);
  }

  private void callMethods(
      ReplaceableForwardingResultSet subject,
      List<String> excludedMethods,
      Class<? extends Exception> expectedException)
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    for (Method method : ReplaceableForwardingResultSet.class.getDeclaredMethods()) {
      if (Modifier.isPublic(method.getModifiers()) && !excludedMethods.contains(method.getName())) {
        boolean exception = false;
        int numberOfParameters = method.getParameterTypes().length;
        Class<?> firstParameterType = null;
        if (numberOfParameters == 1) {
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
            default:
              fail("method with more than 1 parameter is unknown");
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
  public void testValidMethodCall()
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(true, true, false);
    try (ReplaceableForwardingResultSet subject = new ReplaceableForwardingResultSet(delegate)) {
      subject.next();

      // Cloud Spanner result sets use zero-based column indices, as opposed to the one-based column
      // indices used by JDBC. The subject.getBoolean(0) and further zero-based calls below should
      // therefore not cause any exceptions.
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
}
