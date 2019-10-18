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

import com.google.common.base.Preconditions;
import com.google.rpc.Code;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Simple {@link Blob} implementation for Google Cloud Spanner. The value is mapped to a byte array
 * in memory. The {@link Blob} data type can be used in combination with the BYTES Cloud Spanner
 * data type.
 */
class JdbcBlob implements Blob {
  private byte[] value = new byte[0];

  /** Creates an empty blob. */
  JdbcBlob() {}

  /** Creates a blob with the specified bytes as its value. */
  JdbcBlob(byte[] value) {
    this.value = value;
  }

  private void checkPosition(long pos) {
    Preconditions.checkArgument(
        pos + 1 <= Integer.MAX_VALUE,
        "position larger than " + Integer.MAX_VALUE + " is not supported");
  }

  private void checkLength(long length) {
    Preconditions.checkArgument(
        length <= Integer.MAX_VALUE,
        "length larger than " + Integer.MAX_VALUE + " is not supported");
  }

  private void checkPositionPlusLength(long pos, long length) {
    Preconditions.checkArgument(
        pos + 1 + length <= Integer.MAX_VALUE,
        "position+length larger than " + Integer.MAX_VALUE + " is not supported");
  }

  @Override
  public long length() throws SQLException {
    return value.length;
  }

  @Override
  public byte[] getBytes(long pos, int length) throws SQLException {
    JdbcPreconditions.checkArgument(pos > 0L, "pos must be >= 1");
    JdbcPreconditions.checkArgument(length >= 0, "length must be >= 0");
    checkPosition(pos);
    checkPositionPlusLength(pos, length);
    int end = (int) pos + length - 1;
    int blobLength = (int) length();
    if (end > blobLength) {
      length = blobLength - (int) pos + 1;
    }
    byte[] res = new byte[length];
    System.arraycopy(value, (int) pos - 1, res, 0, length);
    return res;
  }

  @Override
  public InputStream getBinaryStream() throws SQLException {
    return new ByteArrayInputStream(value);
  }

  @Override
  public long position(byte[] pattern, long start) throws SQLException {
    JdbcPreconditions.checkArgument(
        pattern != null && pattern.length > 0, "pattern must not be empty");
    JdbcPreconditions.checkArgument(start > 0L, "start must be >= 1");
    checkPosition(start);
    for (int outerIndex = (int) start - 1; outerIndex < value.length; outerIndex++) {
      int innerIndex = 0;
      int valueIndex = outerIndex;
      while (valueIndex < value.length
          && innerIndex < pattern.length
          && value[valueIndex] == pattern[innerIndex]) {
        innerIndex++;
        valueIndex++;
      }
      if (innerIndex == pattern.length) {
        return outerIndex + 1;
      }
    }
    return -1;
  }

  @Override
  public long position(Blob pattern, long start) throws SQLException {
    JdbcPreconditions.checkArgument(pattern != null, "pattern must not be empty");
    JdbcPreconditions.checkArgument(start > 0L, "start must be >= 1");
    checkPosition(start);
    byte[] buffer = new byte[1024];
    int totalSize = 0;
    List<byte[]> totalBytes = new ArrayList<>();
    try (InputStream is = pattern.getBinaryStream()) {
      int bytesRead = 0;
      while ((bytesRead = is.read(buffer)) > -1) {
        if (bytesRead == buffer.length) {
          totalBytes.add(buffer);
        } else {
          byte[] dest = new byte[bytesRead];
          System.arraycopy(buffer, 0, dest, 0, bytesRead);
          totalBytes.add(dest);
        }
        totalSize += bytesRead;
        buffer = new byte[1024];
      }
    } catch (IOException e) {
      throw JdbcSqlExceptionFactory.of("reading blob failed", Code.UNKNOWN, e);
    }
    byte[] bytePattern = new byte[totalSize];
    int index = 0;
    for (byte[] b : totalBytes) {
      System.arraycopy(b, 0, bytePattern, index, b.length);
      index += b.length;
    }
    return position(bytePattern, start);
  }

  private void setLength(int length) {
    int prevLength = value.length;
    byte[] newValue = new byte[length];
    System.arraycopy(value, 0, newValue, 0, Math.min(prevLength, newValue.length));
    value = newValue;
  }

  @Override
  public int setBytes(long pos, byte[] bytes) throws SQLException {
    JdbcPreconditions.checkArgument(bytes != null, "bytes must be non-null");
    JdbcPreconditions.checkArgument(pos > 0L, "pos must be >= 1");
    checkPosition(pos);
    int end = (int) pos + bytes.length - 1;
    if (end >= value.length) {
      setLength(end);
    }
    System.arraycopy(bytes, 0, value, (int) pos - 1, bytes.length);
    return bytes.length;
  }

  @Override
  public int setBytes(long pos, byte[] bytes, int offset, int len) throws SQLException {
    JdbcPreconditions.checkArgument(bytes != null, "bytes must be non-null");
    JdbcPreconditions.checkArgument(pos > 0L, "pos must be >= 1");
    JdbcPreconditions.checkArgument(offset >= 0, "offset must be >= 0");
    JdbcPreconditions.checkArgument(len >= 0, "len must be >= 0");
    checkPosition(pos);
    if (offset > bytes.length) {
      offset = 0;
      len = 0;
    } else {
      if (offset + len > bytes.length) {
        len = bytes.length - offset;
      }
    }
    int end = (int) pos + len - 1;
    if (end >= value.length) {
      setLength(end);
    }
    System.arraycopy(bytes, offset, value, (int) pos - 1, len);
    return len;
  }

  private final class BlobOutputStream extends OutputStream {
    private byte[] buffer = new byte[1024];
    private int currentPos = 0;
    private int blobPosition;

    private BlobOutputStream(int pos) {
      blobPosition = pos;
    }

    @Override
    public void write(int b) throws IOException {
      if (currentPos >= buffer.length) {
        byte[] newBuffer = new byte[buffer.length * 2];
        System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);
        buffer = newBuffer;
      }
      buffer[currentPos] = (byte) b;
      currentPos++;
    }

    @Override
    public void flush() throws IOException {
      try {
        setBytes(blobPosition, buffer, 0, currentPos);
        blobPosition += currentPos;
        currentPos = 0;
        Arrays.fill(buffer, (byte) 0);
      } catch (SQLException e) {
        throw new IOException(e);
      }
    }

    @Override
    public void close() throws IOException {
      flush();
    }
  }

  @Override
  public OutputStream setBinaryStream(long pos) throws SQLException {
    JdbcPreconditions.checkArgument(pos > 0L, "pos must be >= 1");
    checkPosition(pos);
    return new BlobOutputStream((int) pos);
  }

  @Override
  public void truncate(long len) throws SQLException {
    JdbcPreconditions.checkArgument(len >= 0, "len must be >= 0");
    checkLength(len);
    setLength((int) len);
  }

  @Override
  public void free() throws SQLException {
    setLength(0);
  }

  @Override
  public InputStream getBinaryStream(long pos, long length) throws SQLException {
    JdbcPreconditions.checkArgument(pos > 0, "pos must be >= 1");
    JdbcPreconditions.checkArgument(length >= 0, "length must be >= 0");
    checkPosition(pos);
    checkPositionPlusLength(pos, length);
    if (pos + length > value.length) {
      length = value.length - pos + 1;
    }
    byte[] buffer = new byte[(int) length];
    System.arraycopy(value, (int) pos - 1, buffer, 0, (int) length);
    return new ByteArrayInputStream(buffer);
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof JdbcBlob)) return false;
    JdbcBlob blob = (JdbcBlob) other;
    return Arrays.equals(this.value, blob.value);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(value);
  }
}
