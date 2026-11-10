/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.spanner.connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerException;
import com.google.spanner.v1.ExecuteSqlRequest;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPOutputStream;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PartitionIdTest {

  private static final AtomicBoolean gadgetExecuted = new AtomicBoolean(false);

  @After
  public void teardown() {
    PartitionId.resetLimitsForTesting();
  }

  private static class TestObject implements Serializable {
    private final String id;

    TestObject(String id) {
      this.id = id;
    }

    public String getId() {
      return id;
    }
  }

  private static class MaliciousGadgetClass implements Serializable {
    private static final long serialVersionUID = 1L;

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
      gadgetExecuted.set(true);
      throw new IOException("Gadget executed!");
    }
  }

  private static String createSampleEncodedPartitionId(String sql) throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(gzipOutputStream)) {
      dataOutputStream.writeByte(1); // Version 1

      // 1. BatchTransactionId
      dataOutputStream.writeUTF("projects/p/instances/i/databases/d/sessions/s");
      dataOutputStream.writeInt(4);
      dataOutputStream.write(new byte[] {1, 2, 3, 4});
      dataOutputStream.writeLong(1700000000L);
      dataOutputStream.writeInt(500000);

      // 2. Partition
      dataOutputStream.writeInt(5);
      dataOutputStream.write("token".getBytes(StandardCharsets.UTF_8));
      dataOutputStream.writeLong(2048L);
      dataOutputStream.writeLong(10L);

      // 3. ExecuteSqlRequest
      ExecuteSqlRequest request = ExecuteSqlRequest.newBuilder().setSql(sql).build();
      byte[] requestBytes = request.toByteArray();
      dataOutputStream.writeInt(requestBytes.length);
      dataOutputStream.write(requestBytes);
    }
    return Base64.getUrlEncoder().encodeToString(byteArrayOutputStream.toByteArray());
  }

  @Test
  public void testDeserializeInvalidLegacyJavaSerialization() throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try (ObjectOutputStream objectOutputStream =
        new ObjectOutputStream(new GZIPOutputStream(byteArrayOutputStream))) {
      objectOutputStream.writeObject(new TestObject("foo"));
    }
    String base64 = Base64.getUrlEncoder().encodeToString(byteArrayOutputStream.toByteArray());

    SpannerException exception =
        assertThrows(SpannerException.class, () -> PartitionId.decodeFromString(base64));
    assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
  }

  @Test
  public void testGadgetIgnoredAndRejected() throws IOException {
    gadgetExecuted.set(false);
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try (ObjectOutputStream objectOutputStream =
        new ObjectOutputStream(new GZIPOutputStream(byteArrayOutputStream))) {
      objectOutputStream.writeObject(new MaliciousGadgetClass());
    }
    String maliciousPayload =
        Base64.getUrlEncoder().encodeToString(byteArrayOutputStream.toByteArray());

    SpannerException exception =
        assertThrows(SpannerException.class, () -> PartitionId.decodeFromString(maliciousPayload));
    assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
    assertFalse("Arbitrary gadget readObject must never be executed", gadgetExecuted.get());
  }

  @Test
  public void testDecodeAndEqualsAndHashCode() throws IOException {
    String encoded1 = createSampleEncodedPartitionId("SELECT * FROM Singers");
    String encoded2 = createSampleEncodedPartitionId("SELECT * FROM Albums");

    PartitionId partitionId1a = PartitionId.decodeFromString(encoded1);
    PartitionId partitionId1b = PartitionId.decodeFromString(encoded1);
    PartitionId partitionId2 = PartitionId.decodeFromString(encoded2);

    assertNotNull(partitionId1a.getTransactionId());
    assertNotNull(partitionId1a.getPartition());

    assertEquals(partitionId1a, partitionId1a);
    assertEquals(partitionId1a, partitionId1b);
    assertEquals(partitionId1a.hashCode(), partitionId1b.hashCode());

    assertFalse(partitionId1a.equals(partitionId2));
    assertFalse(partitionId1a.equals(null));
    assertFalse(partitionId1a.equals("other"));

    // Verify encodeToString roundtrip
    String reEncoded =
        PartitionId.encodeToString(partitionId1a.getTransactionId(), partitionId1a.getPartition());
    PartitionId roundTripped = PartitionId.decodeFromString(reEncoded);
    assertEquals(partitionId1a, roundTripped);
  }

  @Test
  public void testDecodeNullOrTooLarge() {
    assertThrows(SpannerException.class, () -> PartitionId.decodeFromString(null));

    PartitionId.setLimitsForTesting(10, 1024, 1024);
    assertThrows(
        SpannerException.class,
        () -> PartitionId.decodeFromString("abcdefghijk")); // 11 chars > 10 chars limit
  }

  @Test
  public void testDecodeCorruptedBase64() {
    assertThrows(
        SpannerException.class, () -> PartitionId.decodeFromString("not-valid-base-64!!!"));
  }
}
