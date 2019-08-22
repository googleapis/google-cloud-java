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
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.sql.Clob;
import java.sql.NClob;
import java.sql.SQLException;

/**
 * Simple implementation of {@link Clob} and {@link NClob} for Google Cloud Spanner. The value is
 * mapped to a {@link StringBuilder} in memory. {@link Clob} and {@link NClob} can be used with the
 * STRING data type of Cloud Spanner.
 */
class JdbcClob implements NClob {
  private StringBuilder value = new StringBuilder();

  JdbcClob() {}

  JdbcClob(String value) {
    this.value.append(value);
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

  private StringBuilder repeat(char c, long length) {
    checkLength(length);
    StringBuilder res = new StringBuilder((int) length);
    for (int i = 0; i < length; i++) {
      res.append(c);
    }
    return res;
  }

  @Override
  public long length() throws SQLException {
    return value.length();
  }

  @Override
  public String getSubString(long pos, int length) throws SQLException {
    JdbcPreconditions.checkArgument(pos >= 1, "Start position must be >= 1");
    JdbcPreconditions.checkArgument(length >= 0, "Length must be >= 0");
    checkPosition(pos);
    checkPositionPlusLength(pos, length);
    if (pos > length()) {
      return "";
    }
    int end = (int) pos + length - 1;
    if (end >= value.length()) {
      end = value.length();
    }
    return value.substring((int) pos - 1, end);
  }

  @Override
  public Reader getCharacterStream() throws SQLException {
    return new StringReader(value.toString());
  }

  @Override
  public InputStream getAsciiStream() throws SQLException {
    return new ByteArrayInputStream(StandardCharsets.US_ASCII.encode(value.toString()).array());
  }

  @Override
  public long position(String searchStr, long start) throws SQLException {
    JdbcPreconditions.checkArgument(start >= 1, "Start position must be >= 1");
    JdbcPreconditions.checkArgument(searchStr != null, "searchStr may not be null");
    checkPosition(start);
    int res = value.indexOf(searchStr, (int) start - 1);
    if (res == -1) {
      return res;
    }
    return res + 1;
  }

  @Override
  public long position(Clob searchStr, long start) throws SQLException {
    JdbcPreconditions.checkArgument(start >= 1, "Start position must be >= 1");
    JdbcPreconditions.checkArgument(searchStr != null, "searchStr may not be null");
    checkPosition(start);
    checkPositionPlusLength(start, searchStr.length());
    int res = value.indexOf(searchStr.getSubString(1L, (int) searchStr.length()), (int) start - 1);
    if (res == -1) {
      return res;
    }
    return res + 1;
  }

  @Override
  public int setString(long pos, String str) throws SQLException {
    JdbcPreconditions.checkArgument(str != null, "str is null");
    JdbcPreconditions.checkArgument(pos >= 1, "Position must be >= 1");
    checkPosition(pos);
    if ((pos - 1) > length()) {
      value.append(repeat(' ', pos - length() - 1));
    }
    value.replace((int) pos - 1, (int) pos + str.length() - 1, str);
    return str.length();
  }

  @Override
  public int setString(long pos, String str, int offset, int len) throws SQLException {
    JdbcPreconditions.checkArgument(str != null, "str is null");
    JdbcPreconditions.checkArgument(pos >= 1, "Position must be >= 1");
    JdbcPreconditions.checkArgument(offset >= 1, "Offset must be >= 1");
    JdbcPreconditions.checkArgument(
        offset + len - 1 <= str.length(), "offset + len is greater than str.length()");
    checkPosition(pos);
    return setString(pos, str.substring(offset - 1, offset + len - 1));
  }

  private class ClobWriter extends StringWriter {
    private final long startPos;

    private ClobWriter(long startPos) {
      this.startPos = startPos;
    }

    @Override
    public void flush() {
      try {
        setString(startPos, getBuffer().toString());
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public void close() {
      flush();
    }
  }

  @Override
  public OutputStream setAsciiStream(long pos) throws SQLException {
    throw JdbcSqlExceptionFactory.unsupported(
        "setAsciiStream is not supported. Use setCharacterStream instead");
  }

  @Override
  public Writer setCharacterStream(long pos) throws SQLException {
    JdbcPreconditions.checkArgument(pos >= 1, "pos must be >= 1");
    return new ClobWriter(pos);
  }

  @Override
  public void truncate(long len) throws SQLException {
    JdbcPreconditions.checkArgument(len >= 0, "len must be >= 0");
    checkLength(len);
    value.setLength((int) len);
  }

  @Override
  public void free() throws SQLException {
    value = new StringBuilder();
  }

  @Override
  public Reader getCharacterStream(long pos, long length) throws SQLException {
    JdbcPreconditions.checkArgument(pos >= 1, "pos must be >= 1");
    JdbcPreconditions.checkArgument(length >= 0, "length must be >= 0");
    checkPosition(pos);
    checkPositionPlusLength(pos, length);
    return new StringReader(
        value.substring((int) pos - 1, (int) pos + (int) length - 1).toString());
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof JdbcClob)) return false;
    JdbcClob blob = (JdbcClob) other;
    return value.toString().equals(blob.value.toString());
  }

  @Override
  public int hashCode() {
    return value.toString().hashCode();
  }
}
