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
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import com.google.cloud.ReadChannel;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;

import com.google.cloud.storage.StorageException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonWritableChannelException;

/**
 * Unit tests for {@link CloudStorageReadChannel}.
 */
@RunWith(JUnit4.class)
public class CloudStorageReadChannelTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  private CloudStorageReadChannel chan;

  private final Storage gcsStorage = mock(Storage.class);
  private final BlobId file = BlobId.of("blob", "attack");
  private final Blob metadata = mock(Blob.class);
  private final ReadChannel gcsChannel = mock(ReadChannel.class);

  @Before
  public void before() throws IOException {
    when(metadata.getSize()).thenReturn(42L);
    when(gcsStorage.get(file)).thenReturn(metadata);
    when(gcsStorage.reader(eq(file))).thenReturn(gcsChannel);
    when(gcsChannel.isOpen()).thenReturn(true);
    chan = CloudStorageReadChannel.create(gcsStorage, file, 0, 1);
    verify(gcsStorage).get(eq(file));
    verify(gcsStorage).reader(eq(file));
  }

  @Test
  public void testRead() throws IOException {
    ByteBuffer buffer = ByteBuffer.allocate(1);
    when(gcsChannel.read(eq(buffer))).thenReturn(1);
    assertThat(chan.position()).isEqualTo(0L);
    assertThat(chan.read(buffer)).isEqualTo(1);
    assertThat(chan.position()).isEqualTo(1L);
    verify(gcsChannel).read(any(ByteBuffer.class));
    verify(gcsChannel, times(3)).isOpen();
  }

  @Test
  public void testReadRetry() throws IOException {
    ByteBuffer buffer = ByteBuffer.allocate(1);
    when(gcsChannel.read(eq(buffer)))
        .thenThrow(new StorageException(new IOException("Connection closed prematurely: bytesRead = 33554432, Content-Length = 41943040")))
        .thenReturn(1);
    assertThat(chan.position()).isEqualTo(0L);
    assertThat(chan.read(buffer)).isEqualTo(1);
    assertThat(chan.position()).isEqualTo(1L);
    verify(gcsChannel, times(2)).read(any(ByteBuffer.class));
  }

  @Test
  public void testReadRetryEventuallyGivesUp() throws IOException {
    ByteBuffer buffer = ByteBuffer.allocate(1);
    when(gcsChannel.read(eq(buffer)))
        .thenThrow(new StorageException(new IOException("Connection closed prematurely: bytesRead = 33554432, Content-Length = 41943040")))
        .thenThrow(new StorageException(new IOException("Connection closed prematurely: bytesRead = 33554432, Content-Length = 41943040")))
        .thenReturn(1);
    assertThat(chan.position()).isEqualTo(0L);
    thrown.expect(StorageException.class);
    chan.read(buffer);
  }

  @Test
  public void testRead_whenClosed_throwsCce() throws IOException {
    when(gcsChannel.isOpen()).thenReturn(false);
    thrown.expect(ClosedChannelException.class);
    chan.read(ByteBuffer.allocate(1));
  }

  @Test
  public void testWrite_throwsNonWritableChannelException() throws IOException {
    thrown.expect(NonWritableChannelException.class);
    chan.write(ByteBuffer.allocate(1));
  }

  @Test
  public void testTruncate_throwsNonWritableChannelException() throws IOException {
    thrown.expect(NonWritableChannelException.class);
    chan.truncate(0);
  }

  @Test
  public void testIsOpen() throws IOException {
    when(gcsChannel.isOpen()).thenReturn(true).thenReturn(false);
    assertThat(chan.isOpen()).isTrue();
    chan.close();
    assertThat(chan.isOpen()).isFalse();
    verify(gcsChannel, times(2)).isOpen();
    verify(gcsChannel).close();
  }

  @Test
  public void testSize() throws IOException {
    assertThat(chan.size()).isEqualTo(42L);
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
  public void testSetPosition_whenClosed_throwsCce() throws IOException {
    when(gcsChannel.isOpen()).thenReturn(false);
    thrown.expect(ClosedChannelException.class);
    chan.position(0);
  }

  @Test
  public void testClose_calledMultipleTimes_doesntThrowAnError() throws IOException {
    chan.close();
    chan.close();
    chan.close();
  }

  @Test
  public void testSetPosition() throws IOException {
    assertThat(chan.position()).isEqualTo(0L);
    assertThat(chan.size()).isEqualTo(42L);
    chan.position(1L);
    assertThat(chan.position()).isEqualTo(1L);
    assertThat(chan.size()).isEqualTo(42L);
    verify(gcsChannel).seek(1);
    verify(gcsChannel, times(5)).isOpen();
  }
}
