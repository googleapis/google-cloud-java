package com.google.gcloud.storage.contrib.nio;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.appengine.tools.cloudstorage.GcsFileMetadata;
import com.google.appengine.tools.cloudstorage.GcsFilename;
import com.google.appengine.tools.cloudstorage.GcsInputChannel;
import com.google.appengine.tools.cloudstorage.GcsService;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.NoSuchFileException;

import javax.annotation.concurrent.ThreadSafe;

/**
 * Cloud Storage read channel.
 *
 * @see CloudStorageWriteChannel
 */
@ThreadSafe
final class CloudStorageReadChannel implements SeekableByteChannel {

  static CloudStorageReadChannel create(
      GcsService gcsService, GcsFilename file, long position) throws IOException {
    // XXX: Reading size and opening file should be atomic.
    long size = fetchSize(gcsService, file);
    return new CloudStorageReadChannel(gcsService, file, position, size,
        gcsService.openReadChannel(file, position));
  }

  private final GcsService gcsService;
  private final GcsFilename file;
  private long position;
  private long size;
  private GcsInputChannel channel;

  private CloudStorageReadChannel(
      GcsService gcsService, GcsFilename file, long position, long size, GcsInputChannel channel) {
    this.gcsService = gcsService;
    this.file = file;
    this.position = position;
    this.size = size;
    this.channel = channel;
  }

  @Override
  public boolean isOpen() {
    synchronized (this) {
      return channel.isOpen();
    }
  }

  @Override
  public void close() throws IOException {
    synchronized (this) {
      channel.close();
    }
  }

  @Override
  public int read(ByteBuffer dst) throws IOException {
    synchronized (this) {
      checkOpen();
      int amt = channel.read(dst);
      if (amt > 0) {
        position += amt;
        // XXX: This would only ever happen if the fetchSize() race-condition occurred.
        if (position > size) {
          size = position;
        }
      }
      return amt;
    }
  }

  @Override
  public long size() throws IOException {
    synchronized (this) {
      checkOpen();
      return size;
    }
  }

  @Override
  public long position() throws IOException {
    synchronized (this) {
      checkOpen();
      return position;
    }
  }

  @Override
  public SeekableByteChannel position(long newPosition) throws IOException {
    checkArgument(newPosition >= 0);
    synchronized (this) {
      checkOpen();
      if (newPosition == position) {
        return this;
      }
      position = newPosition;
      size = fetchSize(gcsService, file);
      channel.close();
      channel = gcsService.openReadChannel(file, position);
      return this;
    }
  }

  @Override
  public int write(ByteBuffer src) throws IOException {
    throw new NonWritableChannelException();
  }

  @Override
  public SeekableByteChannel truncate(long size) throws IOException {
    throw new NonWritableChannelException();
  }

  private void checkOpen() throws ClosedChannelException {
    if (!channel.isOpen()) {
      throw new ClosedChannelException();
    }
  }

  private static long fetchSize(GcsService gcsService, GcsFilename file) throws IOException,
      NoSuchFileException {
    GcsFileMetadata metadata = gcsService.getMetadata(file);
    if (metadata == null) {
      throw new NoSuchFileException(
          String.format("gs://%s/%s", file.getBucketName(), file.getObjectName()));
    }
    return metadata.getLength();
  }
}
