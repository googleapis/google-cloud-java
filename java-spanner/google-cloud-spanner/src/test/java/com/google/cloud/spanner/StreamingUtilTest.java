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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StreamingUtilTest {

  private interface MockStreamingResultSet extends ResultSet, StreamingResultSet {}

  @Test
  public void testInitiateStreamingOnStreamingResultSet() {
    MockStreamingResultSet streamingResultSet = mock(MockStreamingResultSet.class);
    AsyncResultSet.StreamMessageListener listener =
        mock(AsyncResultSet.StreamMessageListener.class);
    when(streamingResultSet.initiateStreaming(listener)).thenReturn(true);

    assertTrue(StreamingUtil.initiateStreaming(streamingResultSet, listener));
    verify(streamingResultSet).initiateStreaming(listener);
  }

  @Test
  public void testInitiateStreamingOnNonStreamingResultSetReturnsFalse() {
    ResultSet nonStreamingResultSet = mock(ResultSet.class);
    AsyncResultSet.StreamMessageListener listener =
        mock(AsyncResultSet.StreamMessageListener.class);

    assertFalse(StreamingUtil.initiateStreaming(nonStreamingResultSet, listener));
  }

  @Test
  public void testIsDataAvailableOnStreamingResultSet() {
    MockStreamingResultSet streamingResultSet = mock(MockStreamingResultSet.class);
    when(streamingResultSet.isDataAvailable()).thenReturn(false, true);

    assertFalse(StreamingUtil.isDataAvailable(streamingResultSet));
    assertTrue(StreamingUtil.isDataAvailable(streamingResultSet));
  }

  @Test
  public void testIsDataAvailableOnNonStreamingResultSetReturnsTrue() {
    ResultSet nonStreamingResultSet = mock(ResultSet.class);
    assertTrue(StreamingUtil.isDataAvailable(nonStreamingResultSet));
  }

  @Test
  public void testIsDataAvailableOnNestedForwardingResultSet() {
    MockStreamingResultSet underlyingStreamingResultSet = mock(MockStreamingResultSet.class);
    ForwardingResultSet innerForwarder = new ForwardingResultSet(underlyingStreamingResultSet);
    ForwardingResultSet outerForwarder = new ForwardingResultSet(innerForwarder);

    when(underlyingStreamingResultSet.isDataAvailable()).thenReturn(false);
    assertFalse(StreamingUtil.isDataAvailable(outerForwarder));

    when(underlyingStreamingResultSet.isDataAvailable()).thenReturn(true);
    assertTrue(StreamingUtil.isDataAvailable(outerForwarder));
  }

  @Test
  public void testInitiateStreamingOnForwardingResultSet() {
    MockStreamingResultSet underlyingStreamingResultSet = mock(MockStreamingResultSet.class);
    ForwardingResultSet forwarder = new ForwardingResultSet(underlyingStreamingResultSet);
    AsyncResultSet.StreamMessageListener listener =
        mock(AsyncResultSet.StreamMessageListener.class);

    when(underlyingStreamingResultSet.initiateStreaming(listener)).thenReturn(true);
    assertTrue(StreamingUtil.initiateStreaming(forwarder, listener));
    verify(underlyingStreamingResultSet).initiateStreaming(listener);
  }
}
