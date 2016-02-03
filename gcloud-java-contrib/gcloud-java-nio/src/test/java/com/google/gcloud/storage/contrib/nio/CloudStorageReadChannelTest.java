package com.google.gcloud.storage.contrib.nio;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import com.google.appengine.tools.cloudstorage.GcsFileMetadata;
import com.google.appengine.tools.cloudstorage.GcsFileOptions;
import com.google.appengine.tools.cloudstorage.GcsFilename;
import com.google.appengine.tools.cloudstorage.GcsInputChannel;
import com.google.appengine.tools.cloudstorage.GcsService;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonWritableChannelException;

/** Unit tests for {@link CloudStorageReadChannel}. */
@RunWith(JUnit4.class)
public class CloudStorageReadChannelTest {

  @Rule
  public final ExpectedException thrown = ExpectedException.none();

  private final GcsService gcsService = mock(GcsService.class);
  private final GcsInputChannel gcsChannel = mock(GcsInputChannel.class);
  private final GcsFilename file = new GcsFilename("enya", "rocks");
  private final GcsFileOptions options = GcsFileOptions.getDefaultInstance();
  private final GcsFileMetadata metadata = new GcsFileMetadata(file, options, null, 42, null);
  private CloudStorageReadChannel chan;

  @Before
  public void before() throws Exception {
    when(gcsService.getMetadata(eq(file))).thenReturn(metadata);
    when(gcsService.openReadChannel(eq(file), anyInt())).thenReturn(gcsChannel);
    when(gcsChannel.isOpen()).thenReturn(true);
    chan = CloudStorageReadChannel.create(gcsService, file, 0);
    verify(gcsService).getMetadata(eq(file));
    verify(gcsService).openReadChannel(eq(file), eq(0L));
  }

  @Test
  public void testRead() throws Exception {
    ByteBuffer buffer = ByteBuffer.allocate(1);
    when(gcsChannel.read(eq(buffer))).thenReturn(1);
    assertThat(chan.position()).isEqualTo(0L);
    assertThat(chan.read(buffer)).isEqualTo(1);
    assertThat(chan.position()).isEqualTo(1L);
    verify(gcsChannel).read(any(ByteBuffer.class));
    verify(gcsChannel, times(3)).isOpen();
    verifyNoMoreInteractions(gcsService, gcsChannel);
  }

  @Test
  public void testRead_whenClosed_throwsCce() throws Exception {
    when(gcsChannel.isOpen()).thenReturn(false);
    thrown.expect(ClosedChannelException.class);
    chan.read(ByteBuffer.allocate(1));
  }

  @Test
  public void testWrite_throwsNonWritableChannelException() throws Exception {
    thrown.expect(NonWritableChannelException.class);
    chan.write(ByteBuffer.allocate(1));
  }

  @Test
  public void testTruncate_throwsNonWritableChannelException() throws Exception {
    thrown.expect(NonWritableChannelException.class);
    chan.truncate(0);
  }

  @Test
  public void testIsOpen() throws Exception {
    when(gcsChannel.isOpen()).thenReturn(true).thenReturn(false);
    assertThat(chan.isOpen()).isTrue();
    chan.close();
    assertThat(chan.isOpen()).isFalse();
    verify(gcsChannel, times(2)).isOpen();
    verify(gcsChannel).close();
    verifyNoMoreInteractions(gcsService, gcsChannel);
  }

  @Test
  public void testSize() throws Exception {
    assertThat(chan.size()).isEqualTo(42L);
    verify(gcsChannel).isOpen();
    verifyZeroInteractions(gcsChannel);
    verifyNoMoreInteractions(gcsService);
  }

  @Test
  public void testSize_whenClosed_throwsCce() throws Exception {
    when(gcsChannel.isOpen()).thenReturn(false);
    thrown.expect(ClosedChannelException.class);
    chan.size();
  }

  @Test
  public void testPosition_whenClosed_throwsCce() throws Exception {
    when(gcsChannel.isOpen()).thenReturn(false);
    thrown.expect(ClosedChannelException.class);
    chan.position();
  }

  @Test
  public void testSetPosition_whenClosed_throwsCce() throws Exception {
    when(gcsChannel.isOpen()).thenReturn(false);
    thrown.expect(ClosedChannelException.class);
    chan.position(0);
  }

  @Test
  public void testClose_calledMultipleTimes_doesntThrowAnError() throws Exception {
    chan.close();
    chan.close();
    chan.close();
  }

  @Test
  public void testSetPosition() throws Exception {
    assertThat(chan.position()).isEqualTo(0L);
    assertThat(chan.size()).isEqualTo(42L);
    chan.position(1L);
    assertThat(chan.position()).isEqualTo(1L);
    assertThat(chan.size()).isEqualTo(42L);
    verify(gcsChannel).close();
    verify(gcsChannel, times(5)).isOpen();
    verify(gcsService, times(2)).getMetadata(eq(file));
    verify(gcsService).openReadChannel(eq(file), eq(1L));
    verifyNoMoreInteractions(gcsService, gcsChannel);
  }
}
