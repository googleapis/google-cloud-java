/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.storage.it;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkPositionIndexes;

import com.google.cloud.storage.DataGenerator;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Hashing;
import com.google.common.io.BaseEncoding;
import com.google.common.primitives.Ints;
import com.google.protobuf.ByteString;
import com.google.protobuf.UnsafeByteOperations;
import com.google.storage.v2.BidiWriteObjectRequest;
import com.google.storage.v2.ChecksummedData;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public final class ChecksummedTestContent {

  private final byte[] bytes;
  private final int crc32c;
  private final String md5Base64;

  private ChecksummedTestContent(byte[] bytes, int crc32c, String md5Base64) {
    this.bytes = bytes;
    this.crc32c = crc32c;
    this.md5Base64 = md5Base64;
  }

  public byte[] getBytes() {
    return bytes;
  }

  public int length() {
    return bytes.length;
  }

  public byte[] getBytes(int beginIndex) {
    return UnsafeByteOperations.unsafeWrap(bytes).substring(beginIndex).toByteArray();
  }

  public byte[] getBytes(int beginIndex, int length) {
    return UnsafeByteOperations.unsafeWrap(bytes)
        .substring(beginIndex, beginIndex + length)
        .toByteArray();
  }

  public int getCrc32c() {
    return crc32c;
  }

  public ByteString getMd5Bytes() {
    return ByteString.copyFrom(BaseEncoding.base64().decode(md5Base64));
  }

  public String getMd5Base64() {
    return md5Base64;
  }

  public String getCrc32cBase64() {
    return Base64.getEncoder().encodeToString(Ints.toByteArray(crc32c));
  }

  public byte[] concat(char c) {
    return concat((byte) c);
  }

  public byte[] concat(byte b) {
    int lenOrig = bytes.length;
    int lenNew = lenOrig + 1;
    byte[] newBytes = Arrays.copyOf(bytes, lenNew);
    newBytes[lenOrig] = b;
    return newBytes;
  }

  public ChecksummedTestContent concat(ChecksummedTestContent ctc) {
    byte[] newBytes = new byte[this.length() + ctc.length()];
    System.arraycopy(bytes, 0, newBytes, 0, bytes.length);
    System.arraycopy(ctc.bytes, 0, newBytes, bytes.length, ctc.length());
    return ChecksummedTestContent.of(newBytes);
  }

  public ByteArrayInputStream bytesAsInputStream() {
    return new ByteArrayInputStream(bytes);
  }

  public ChecksummedData asChecksummedData() {
    return ChecksummedData.newBuilder()
        .setContent(ByteString.copyFrom(bytes))
        .setCrc32C(crc32c)
        .build();
  }

  public ChecksummedTestContent slice(int begin, int length) {
    return of(bytes, begin, Math.min(length, bytes.length - begin));
  }

  public List<ChecksummedTestContent> chunkup(int chunkSize) {
    List<ChecksummedTestContent> elements = new ArrayList<>();
    for (int i = 0; i < bytes.length; i += chunkSize) {
      elements.add(slice(i, chunkSize));
    }
    return ImmutableList.copyOf(elements);
  }

  public BidiWriteObjectRequest.Builder asBidiWrite() {
    return BidiWriteObjectRequest.newBuilder().setChecksummedData(asChecksummedData());
  }

  public ByteBuffer asByteBuffer() {
    return ByteBuffer.wrap(bytes);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("byteCount", bytes.length)
        .add("crc32c", Integer.toUnsignedString(crc32c))
        .toString();
  }

  public static ChecksummedTestContent of(String content) {
    byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
    return of(bytes);
  }

  public static ChecksummedTestContent gen(int length) {
    byte[] bytes1 = DataGenerator.base64Characters().genBytes(length);
    return of(bytes1);
  }

  public static ChecksummedTestContent of(byte[] bytes) {
    int crc32c = Hashing.crc32c().hashBytes(bytes).asInt();
    String md5Base64 = Base64.getEncoder().encodeToString(Hashing.md5().hashBytes(bytes).asBytes());
    return new ChecksummedTestContent(bytes, crc32c, md5Base64);
  }

  public static ChecksummedTestContent of(byte[] bytes, int from, int length) {
    checkArgument(length >= 0, "length >= 0 (%s >= 0)", length);
    checkPositionIndexes(from, from + length, bytes.length);
    return of(Arrays.copyOfRange(bytes, from, from + length));
  }
}
