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
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ForwardingResultSetTest {

  private interface MockStreamingResultSet extends ResultSet, StreamingResultSet {}

  @Test
  public void testDelegation() {
    MockStreamingResultSet delegate = mock(MockStreamingResultSet.class);
    when(delegate.next()).thenReturn(true, false);
    ResultSetStats stats = ResultSetStats.getDefaultInstance();
    ResultSetMetadata metadata = ResultSetMetadata.getDefaultInstance();
    when(delegate.getStats()).thenReturn(stats);
    when(delegate.getMetadata()).thenReturn(metadata);

    ForwardingResultSet forwardingResultSet = new ForwardingResultSet(delegate);

    assertTrue(forwardingResultSet.next());
    assertFalse(forwardingResultSet.next());
    assertEquals(stats, forwardingResultSet.getStats());
    assertEquals(metadata, forwardingResultSet.getMetadata());
    assertEquals(delegate, forwardingResultSet.getDelegate());

    forwardingResultSet.close();
    verify(delegate).close();
  }

  @Test
  public void testInitiateStreamingDelegation() {
    MockStreamingResultSet delegate = mock(MockStreamingResultSet.class);
    AsyncResultSet.StreamMessageListener listener =
        mock(AsyncResultSet.StreamMessageListener.class);
    when(delegate.initiateStreaming(listener)).thenReturn(true);

    ForwardingResultSet forwardingResultSet = new ForwardingResultSet(delegate);
    assertTrue(forwardingResultSet.initiateStreaming(listener));
    verify(delegate).initiateStreaming(listener);
  }

  @Test
  public void testIsDataAvailableDelegation() {
    MockStreamingResultSet delegate = mock(MockStreamingResultSet.class);
    when(delegate.isDataAvailable()).thenReturn(false, true);

    ForwardingResultSet forwardingResultSet = new ForwardingResultSet(delegate);
    assertFalse(forwardingResultSet.isDataAvailable());
    assertTrue(forwardingResultSet.isDataAvailable());
  }

  @Test
  public void testReplaceDelegate() {
    ResultSet firstDelegate = mock(ResultSet.class);
    ResultSet secondDelegate = mock(ResultSet.class);
    when(firstDelegate.next()).thenReturn(true);
    when(secondDelegate.next()).thenReturn(false);

    ForwardingResultSet forwardingResultSet = new ForwardingResultSet(firstDelegate);
    assertTrue(forwardingResultSet.next());

    forwardingResultSet.replaceDelegate(secondDelegate);
    assertFalse(forwardingResultSet.next());
    assertEquals(secondDelegate, forwardingResultSet.getDelegate());
  }
}
