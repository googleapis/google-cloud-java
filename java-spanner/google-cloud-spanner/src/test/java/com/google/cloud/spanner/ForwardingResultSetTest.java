/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.common.base.Supplier;
import com.google.protobuf.Value;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ForwardingResultSetTest {

  @Test
  public void testDelegation() {
    StreamingResultSet delegate = mock(StreamingResultSet.class);
    when(delegate.next()).thenReturn(true, false);
    ResultSetStats stats = ResultSetStats.getDefaultInstance();
    ResultSetMetadata metadata = ResultSetMetadata.getDefaultInstance();
    when(delegate.getStats()).thenReturn(stats);
    when(delegate.getMetadata()).thenReturn(metadata);

    try (ForwardingResultSet forwardingResultSet = new ForwardingResultSet(delegate)) {
      assertTrue(forwardingResultSet.next());
      assertFalse(forwardingResultSet.next());
      assertEquals(stats, forwardingResultSet.getStats());
      assertEquals(metadata, forwardingResultSet.getMetadata());
      assertEquals(delegate, forwardingResultSet.getDelegate());
    }

    verify(delegate).close();
  }

  @Test
  public void testInitiateStreamingDelegation() {
    StreamingResultSet delegate = mock(StreamingResultSet.class);
    AsyncResultSet.StreamMessageListener listener =
        mock(AsyncResultSet.StreamMessageListener.class);
    when(delegate.initiateStreaming(listener)).thenReturn(true);

    try (ForwardingResultSet forwardingResultSet = new ForwardingResultSet(delegate)) {
      assertTrue(forwardingResultSet.initiateStreaming(listener));
      verify(delegate).initiateStreaming(listener);
    }
  }

  @Test
  public void testIsDataAvailableDelegation() {
    StreamingResultSet delegate = mock(StreamingResultSet.class);
    when(delegate.isDataAvailable()).thenReturn(false, true);

    try (ForwardingResultSet forwardingResultSet = new ForwardingResultSet(delegate)) {
      assertFalse(forwardingResultSet.isDataAvailable());
      assertTrue(forwardingResultSet.isDataAvailable());
    }
  }

  @Test
  public void testIsDataAvailableWhenDelegateIsNotStreamingResultSet() {
    ResultSet delegate = mock(ResultSet.class);
    try (ForwardingResultSet forwardingResultSet = new ForwardingResultSet(delegate)) {
      assertTrue(forwardingResultSet.isDataAvailable());
    }
  }

  @Test
  public void testReplaceDelegate() {
    ResultSet firstDelegate = mock(ResultSet.class);
    ResultSet secondDelegate = mock(ResultSet.class);
    when(firstDelegate.next()).thenReturn(true);
    when(secondDelegate.next()).thenReturn(false);

    try (ForwardingResultSet forwardingResultSet = new ForwardingResultSet(firstDelegate)) {
      assertTrue(forwardingResultSet.next());

      forwardingResultSet.replaceDelegate(secondDelegate);
      assertFalse(forwardingResultSet.next());
      assertEquals(secondDelegate, forwardingResultSet.getDelegate());
    }
  }

  @Test
  public void testSupplierConstructor() {
    ResultSet delegate = mock(ResultSet.class);
    when(delegate.next()).thenReturn(true);

    try (ForwardingResultSet forwardingResultSet = new ForwardingResultSet(() -> delegate)) {
      assertTrue(forwardingResultSet.next());
      assertEquals(delegate, forwardingResultSet.getDelegate());
    }
  }

  @Test
  public void testGetCurrentRowAsStruct() {
    ResultSet delegate = mock(ResultSet.class);
    Struct struct = mock(Struct.class);
    when(delegate.getCurrentRowAsStruct()).thenReturn(struct);

    try (ForwardingResultSet forwardingResultSet = new ForwardingResultSet(delegate)) {
      assertEquals(struct, forwardingResultSet.getCurrentRowAsStruct());
    }
  }

  @Test
  public void testProtobufResultSetDelegationWhenSupported() {
    ProtobufResultSet delegate = mock(ProtobufResultSet.class);
    Value value = Value.newBuilder().setStringValue("test").build();
    when(delegate.canGetProtobufValue(0)).thenReturn(true);
    when(delegate.getProtobufValue(0)).thenReturn(value);

    try (ForwardingResultSet forwardingResultSet = new ForwardingResultSet(delegate)) {
      assertTrue(forwardingResultSet.canGetProtobufValue(0));
      assertEquals(value, forwardingResultSet.getProtobufValue(0));
    }
  }

  @Test
  public void testProtobufResultSetDelegationWhenNotSupported() {
    ResultSet delegate = mock(ResultSet.class);
    try (ForwardingResultSet forwardingResultSet = new ForwardingResultSet(delegate)) {
      assertFalse(forwardingResultSet.canGetProtobufValue(0));
      IllegalStateException exception =
          assertThrows(IllegalStateException.class, () -> forwardingResultSet.getProtobufValue(0));
      assertEquals("The result set does not support protobuf values", exception.getMessage());
    }
  }

  @Test
  public void testCloseWhenSupplierThrowsException() {
    Supplier<ResultSet> failingSupplier =
        () -> {
          throw new RuntimeException("failed to obtain delegate");
        };
    try (ForwardingResultSet forwardingResultSet = new ForwardingResultSet(failingSupplier)) {
      // Exiting the try block invokes close(), testing that it catches and swallows the exception
      // cleanly.
    }
  }

  @Test
  public void testConstructorNullCheck() {
    assertThrows(NullPointerException.class, () -> new ForwardingResultSet((ResultSet) null));
  }

  @Test
  public void testReplaceDelegateNullCheck() {
    ResultSet delegate = mock(ResultSet.class);
    try (ForwardingResultSet forwardingResultSet = new ForwardingResultSet(delegate)) {
      assertThrows(NullPointerException.class, () -> forwardingResultSet.replaceDelegate(null));
    }
  }
}
