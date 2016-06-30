/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.storage.contrib.nio;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import com.google.cloud.WriteChannel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonReadableChannelException;

/**
 * Unit tests for {@link CloudStorageWriteChannel}.
 */
@RunWith(JUnit4.class)
public class CloudStorageWriteChannelTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  private final WriteChannel gcsChannel = mock(WriteChannel.class);
  private final CloudStorageWriteChannel chan = new CloudStorageWriteChannel(gcsChannel);

  @Before
  public void before() {
    when(gcsChannel.isOpen()).thenReturn(true);
  }

  @Test
  public void testRead_throwsNonReadableChannelException() throws IOException {
    thrown.expect(NonReadableChannelException.class);
    chan.read(ByteBuffer.allocate(1));
  }

  @Test
  public void testWrite() throws IOException {
    ByteBuffer buffer = ByteBuffer.allocate(1);
    buffer.put((byte) 'B');
    assertThat(chan.position()).isEqualTo(0L);
    assertThat(chan.size()).isEqualTo(0L);
    when(gcsChannel.write(eq(buffer))).thenReturn(1);
    assertThat(chan.write(buffer)).isEqualTo(1);
    assertThat(chan.position()).isEqualTo(1L);
    assertThat(chan.size()).isEqualTo(1L);
    verify(gcsChannel).write(any(ByteBuffer.class));
    verify(gcsChannel, times(5)).isOpen();
    verifyNoMoreInteractions(gcsChannel);
  }

  @Test
  public void testWrite_whenClosed_throwsCce() throws IOException {
    when(gcsChannel.isOpen()).thenReturn(false);
    thrown.expect(ClosedChannelException.class);
    chan.write(ByteBuffer.allocate(1));
  }

  @Test
  public void testIsOpen() throws IOException {
    when(gcsChannel.isOpen()).thenReturn(true).thenReturn(false);
    assertThat(chan.isOpen()).isTrue();
    chan.close();
    assertThat(chan.isOpen()).isFalse();
    verify(gcsChannel, times(2)).isOpen();
    verify(gcsChannel).close();
    verifyNoMoreInteractions(gcsChannel);
  }

  @Test
  public void testSize() throws IOException {
    assertThat(chan.size()).isEqualTo(0L);
    verify(gcsChannel).isOpen();
    verifyZeroInteractions(gcsChannel);
  }

  @Test
  public void testSize_whenClosed_throwsCce() throws IOException {
    when(gcsChannel.isOpen()).thenReturn(false);
    thrown.expect(ClosedChannelException.class);
    chan.size();
  }

  @Test
  public void testPosition_whenClosed_throwsCce() throws IOException {
    when(gcsChannel.isOpen()).thenReturn(false);
    thrown.expect(ClosedChannelException.class);
    chan.position();
  }

  @Test
  public void testClose_calledMultipleTimes_doesntThrowAnError() throws IOException {
    chan.close();
    chan.close();
    chan.close();
  }
}
