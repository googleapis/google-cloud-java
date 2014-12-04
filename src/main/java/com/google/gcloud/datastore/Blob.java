package com.google.gcloud.datastore;

import static com.google.api.client.util.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.protobuf.ByteString;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/**
 * A Google Cloud Datastore Blob.
 * A Datastore blob is limited to {@value #MAX_LENGTH} bytes.
 * This class is immutable.
 *
 * @see <a href="https://cloud.google.com/datastore/docs/concepts/entities">Google Cloud Datastore Entities, Properties, and Keys</a>
 */
public final class Blob implements java.io.Serializable {

  private static final long serialVersionUID = 3835421019618247721L;
  private static final int MAX_LENGTH = 1_000_000;

  private final ByteString byteString;

  Blob(ByteString byteString, boolean enforceLimits) {
    this.byteString = checkNotNull(byteString);
    if (enforceLimits) {
      checkArgument(byteString.size() <= MAX_LENGTH, "May be a maximum of 1,000,000 bytes");
    }
  }

  @Override
  public String toString() {
    return byteString.toString();
  }

  @Override
  public int hashCode() {
    return byteString.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Blob)) {
      return false;
    }
    return Objects.equals(byteString, ((Blob) obj).byteString);
  }

  /**
   * Returns the size of this blob.
   */
  public int length() {
    return byteString.size();
  }

  /**
   * Returns a copy as byte array.
   */
  public byte[] toByteArray() {
    return byteString.toByteArray();
  }

  /**
   * Returns a read-only {@link ByteBuffer} for this blob content.
   */
  public ByteBuffer asReadOnlyByteBuffer() {
    return byteString.asReadOnlyByteBuffer();
  }

  /**
   * Returns an {@link InputStream} for this blob content.
   */
  public InputStream asInputStream() {
    final ByteBuffer byteBuffer = asReadOnlyByteBuffer();
    return new InputStream() {
      @Override public int read() throws IOException {
        return !byteBuffer.hasRemaining() ? -1 : byteBuffer.get() & 0xFF;
      }
    };
  }

  /**
   * Copies bytes into a ByteBuffer.
   *
   * @throws java.nio.ReadOnlyBufferException if the target is read-only
   * @throws java.nio.BufferOverflowException if the target's remaining() space is not large
   *        enough to hold the data.
   */
  public void copyTo(ByteBuffer target) {
    byteString.copyTo(target);
  }

  /**
   * Copies bytes into a buffer.
   *
   * @throws java.io.IndexOutOfBoundsException if an offset or size is negative or too large
   */
  public void copyTo(byte[] target) {
    byteString.copyTo(target, 0, 0, length());
  }

  ByteString byteString() {
    return byteString;
  }

  public static Blob copyFrom(byte[] bytes) {
    return new Blob(ByteString.copyFrom(bytes), true);
  }

  public static Blob copyFrom(ByteBuffer bytes) {
    return new Blob(ByteString.copyFrom(bytes), true);
  }

  public static Blob copyFrom(InputStream input) throws IOException {
    BufferedInputStream bufferedInput = new BufferedInputStream(input);
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    int value;
    while ((value = bufferedInput.read()) != -1) {
      bytes.write(value);
    }
    return copyFrom(bytes.toByteArray());
  }
}
