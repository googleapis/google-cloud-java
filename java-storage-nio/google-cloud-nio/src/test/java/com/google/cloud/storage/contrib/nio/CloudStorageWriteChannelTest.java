/*
 * Copyright 2016 Google LLC
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import com.google.cloud.WriteChannel;
import com.google.cloud.testing.junit4.MultipleAttemptsRule;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonReadableChannelException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link CloudStorageWriteChannel}. */
@RunWith(JUnit4.class)
public class CloudStorageWriteChannelTest {
  @Rule public final MultipleAttemptsRule multipleAttemptsRule = new MultipleAttemptsRule(3);

  private final WriteChannel gcsChannel = mock(WriteChannel.class);
  private final CloudStorageWriteChannel chan = new CloudStorageWriteChannel(gcsChannel);

  @Before
  public void before() {
    when(gcsChannel.isOpen()).thenReturn(true);
  }

  @Test
  public void testRead_throwsNonReadableChannelException() throws IOException {
    try {
      chan.read(ByteBuffer.allocate(1));
      Assert.fail();
    } catch (NonReadableChannelException expected) {
    }
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
    try {
      when(gcsChannel.isOpen()).thenReturn(false);
      chan.write(ByteBuffer.allocate(1));
      Assert.fail();
    } catch (ClosedChannelException expected) {
    }
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
    verifyNoMoreInteractions(gcsChannel);
  }

  @Test
  public void testSize_whenClosed_throwsCce() throws IOException {
    try {
      when(gcsChannel.isOpen()).thenReturn(false);
      chan.size();
      Assert.fail();
    } catch (ClosedChannelException expected) {
    }
  }

  @Test
  public void testPosition_whenClosed_throwsCce() throws IOException {
    try {
      when(gcsChannel.isOpen()).thenReturn(false);
      chan.position();
      Assert.fail();
    } catch (ClosedChannelException expected) {
    }
  }

  @Test
  public void testClose_calledMultipleTimes_doesntThrowAnError() throws IOException {
    chan.close();
    chan.close();
    chan.close();
  }
}
