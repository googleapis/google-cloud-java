/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Options.RpcPriority;
import com.google.cloud.spanner.PartitionCodec.DecodedPartition;
import com.google.protobuf.ByteString;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.RequestOptions.ClientContext;
import com.google.spanner.v1.RequestOptions.Priority;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPOutputStream;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PartitionCodecTest {

  private static final AtomicBoolean gadgetExecuted = new AtomicBoolean(false);

  @After
  public void teardown() {
    PartitionCodec.resetLimitsForTesting();
  }

  private static class MaliciousGadgetClass implements Serializable {
    private static final long serialVersionUID = 1L;

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
      gadgetExecuted.set(true);
      throw new IOException("Gadget executed!");
    }
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
        assertThrows(
            SpannerException.class, () -> PartitionCodec.decodeFromString(maliciousPayload));
    assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
    assertFalse("Arbitrary gadget readObject must never be executed", gadgetExecuted.get());
  }

  @Test
  public void testEncodeDecodeRoundTripSimple() {
    BatchTransactionId batchTransactionId =
        new BatchTransactionId(
            "projects/p/instances/i/databases/d/sessions/s",
            ByteString.copyFromUtf8("txn-12345"),
            Timestamp.ofTimeSecondsAndNanos(1700000000L, 500000));

    Statement statement =
        Statement.newBuilder("SELECT * FROM Singers WHERE SingerId = @id AND FirstName = @name")
            .bind("id")
            .to(12345L)
            .bind("name")
            .to("John")
            .build();

    PartitionOptions partitionOptions =
        PartitionOptions.newBuilder().setPartitionSizeBytes(2048).setMaxPartitions(10).build();

    Partition partition =
        Partition.createQueryPartition(
            ByteString.copyFromUtf8("token-abcde"),
            partitionOptions,
            statement,
            /* queryOption= */ null);

    String encoded = PartitionCodec.encodeToString(batchTransactionId, partition);
    assertNotNull(encoded);

    DecodedPartition decoded = PartitionCodec.decodeFromString(encoded);
    assertNotNull(decoded);

    assertEquals(batchTransactionId.getSessionId(), decoded.getTransactionId().getSessionId());
    assertEquals(
        batchTransactionId.getTransactionId(), decoded.getTransactionId().getTransactionId());
    assertEquals(batchTransactionId.getTimestamp(), decoded.getTransactionId().getTimestamp());

    assertEquals(partition.getPartitionToken(), decoded.getPartition().getPartitionToken());
    assertEquals(
        partitionOptions.getPartitionSizeBytes(),
        decoded.getPartition().getPartitionOptions().getPartitionSizeBytes());
    assertEquals(
        partitionOptions.getMaxPartitions(),
        decoded.getPartition().getPartitionOptions().getMaxPartitions());

    ExecuteSqlRequest expectedRequest = statement.toExecuteSqlRequestBuilder().build();
    assertEquals(expectedRequest, decoded.getPartition().getExecuteSqlRequest());
    assertEquals(statement.getSql(), decoded.getPartition().getExecuteSqlRequest().getSql());
  }

  @Test
  public void testEncodeDecodeAllValueTypes() {
    BatchTransactionId batchTransactionId =
        new BatchTransactionId(
            "projects/p/instances/i/databases/d/sessions/s",
            ByteString.copyFromUtf8("txn-all-types"),
            Timestamp.ofTimeSecondsAndNanos(1710000000L, 123456));

    Statement statement =
        Statement.newBuilder(
                "SELECT * FROM AllTypes WHERE bool_col = @p_bool AND int_col = @p_int AND float_col ="
                    + " @p_float AND float32_col = @p_float32 AND str_col = @p_str AND bytes_col ="
                    + " @p_bytes AND timestamp_col = @p_ts AND date_col = @p_date AND numeric_col ="
                    + " @p_num AND json_col = @p_json AND proto_col = @p_proto AND proto_enum_col ="
                    + " @p_enum AND string_arr = @p_string_array AND int64_arr_null ="
                    + " @p_int64_array_null")
            .bind("p_bool")
            .to(true)
            .bind("p_int")
            .to(9876543210L)
            .bind("p_float")
            .to(3.1415926535d)
            .bind("p_float32")
            .to(2.71828f)
            .bind("p_str")
            .to("Hello, Spanner!")
            .bind("p_bytes")
            .to(ByteArray.copyFrom("binary-data".getBytes(StandardCharsets.UTF_8)))
            .bind("p_ts")
            .to(Timestamp.ofTimeSecondsAndNanos(1712345678L, 999))
            .bind("p_date")
            .to(Date.fromYearMonthDay(2024, 4, 15))
            .bind("p_num")
            .to(new BigDecimal("123456789.987654321"))
            .bind("p_json")
            .to(Value.json("{\"key\":\"value\",\"count\":42}"))
            .bind("p_proto")
            .to(
                Value.protoMessage(
                    ByteArray.copyFrom(new byte[] {0x08, 0x01}),
                    "google.spanner.v1.ResultSetMetadata"))
            .bind("p_enum")
            .to(Value.protoEnum(1L, "google.spanner.v1.TypeAnnotationCode"))
            .bind("p_string_array")
            .to(Value.stringArray(Arrays.asList("first", null, "third")))
            .bind("p_int64_array_null")
            .to(Value.int64Array((Iterable<Long>) null))
            .build();

    Partition partition =
        Partition.createQueryPartition(
            ByteString.copyFromUtf8("token-all-types"),
            PartitionOptions.getDefaultInstance(),
            statement,
            /* queryOption= */ null);

    String encoded = PartitionCodec.encodeToString(batchTransactionId, partition);
    DecodedPartition decoded = PartitionCodec.decodeFromString(encoded);

    assertEquals(
        statement.toExecuteSqlRequestBuilder().build(),
        decoded.getPartition().getExecuteSqlRequest());
    DecodedPartition decodedAgain = PartitionCodec.decodeFromString(encoded);
    assertEquals(decoded, decodedAgain);
  }

  @Test
  public void testEncodeDecodeWithOptions() {
    BatchTransactionId batchTransactionId =
        new BatchTransactionId(
            "projects/p/instances/i/databases/d/sessions/s",
            ByteString.copyFromUtf8("txn-options"),
            Timestamp.ofTimeSecondsAndNanos(1700000000L, 0));

    ExecuteSqlRequest.QueryOptions statementQueryOptions =
        ExecuteSqlRequest.QueryOptions.newBuilder()
            .setOptimizerVersion("5")
            .setOptimizerStatisticsPackage("latest")
            .build();

    Statement statement =
        Statement.newBuilder("SELECT 1").withQueryOptions(statementQueryOptions).build();

    ClientContext clientContext =
        ClientContext.newBuilder()
            .putSecureContext(
                "trace-id",
                com.google.protobuf.Value.newBuilder().setStringValue("trace-12345").build())
            .build();

    Partition partition =
        Partition.createQueryPartition(
            ByteString.copyFromUtf8("token-options"),
            PartitionOptions.getDefaultInstance(),
            statement,
            Options.fromQueryOptions(
                Options.dataBoostEnabled(true),
                Options.priority(RpcPriority.HIGH),
                Options.tag("test-request-tag"),
                Options.clientContext(clientContext)));

    String encoded = PartitionCodec.encodeToString(batchTransactionId, partition);
    DecodedPartition decoded = PartitionCodec.decodeFromString(encoded);

    assertEquals(
        statementQueryOptions, decoded.getPartition().getExecuteSqlRequest().getQueryOptions());
    assertTrue(decoded.getPartition().getExecuteSqlRequest().getDataBoostEnabled());
    assertEquals(
        Priority.PRIORITY_HIGH,
        decoded.getPartition().getExecuteSqlRequest().getRequestOptions().getPriority());
    assertEquals(
        "test-request-tag",
        decoded.getPartition().getExecuteSqlRequest().getRequestOptions().getRequestTag());
    assertEquals(
        clientContext,
        decoded.getPartition().getExecuteSqlRequest().getRequestOptions().getClientContext());
    DecodedPartition decodedAgain = PartitionCodec.decodeFromString(encoded);
    assertEquals(decoded, decodedAgain);
  }

  @Test
  public void testDecodeNullOrTooLarge() {
    assertThrows(SpannerException.class, () -> PartitionCodec.decodeFromString(null));

    StringBuilder longString = new StringBuilder();
    for (int i = 0; i < 11; i++) {
      longString.append("a");
    }
    PartitionCodec.setLimitsForTesting(10, 1024, 1024);
    assertThrows(
        SpannerException.class,
        () -> PartitionCodec.decodeFromString("abcdefghijk")); // 11 chars > 10 chars limit
  }

  @Test
  public void testDecodeInvalidFormatVersion() throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(gzipOutputStream)) {
      dataOutputStream.writeByte(99); // Unsupported version
    }
    String encoded = Base64.getUrlEncoder().encodeToString(byteArrayOutputStream.toByteArray());

    SpannerException exception =
        assertThrows(SpannerException.class, () -> PartitionCodec.decodeFromString(encoded));
    assertTrue(exception.getMessage().contains("Unsupported PartitionId format version: 99"));
  }

  @Test
  public void testDecodePayloadTooLargeTransactionId() throws IOException {
    PartitionCodec.setLimitsForTesting(1_000_000, 1024 * 1024, 1024 * 1024, 100, 1024 * 1024);

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(gzipOutputStream)) {
      dataOutputStream.writeByte(1); // Version 1
      dataOutputStream.writeUTF("session");
      dataOutputStream.writeInt(101); // Exceeds 100 max transaction ID limit
    }
    String encoded = Base64.getUrlEncoder().encodeToString(byteArrayOutputStream.toByteArray());

    SpannerException exception =
        assertThrows(SpannerException.class, () -> PartitionCodec.decodeFromString(encoded));
    assertTrue(exception.getMessage().contains("Invalid length in serialized PartitionId"));
  }

  @Test
  public void testDecodePayloadTooLargeToken() throws IOException {
    PartitionCodec.setLimitsForTesting(1_000_000, 1024 * 1024, 1024 * 1024, 1024 * 1024, 100);

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(gzipOutputStream)) {
      dataOutputStream.writeByte(1); // Version 1
      dataOutputStream.writeUTF("session");
      dataOutputStream.writeInt(4);
      dataOutputStream.write(new byte[] {1, 2, 3, 4});
      dataOutputStream.writeLong(100L);
      dataOutputStream.writeInt(0);
      dataOutputStream.writeInt(101); // Exceeds 100 max token limit
    }
    String encoded = Base64.getUrlEncoder().encodeToString(byteArrayOutputStream.toByteArray());

    SpannerException exception =
        assertThrows(SpannerException.class, () -> PartitionCodec.decodeFromString(encoded));
    assertTrue(exception.getMessage().contains("Invalid length in serialized PartitionId"));
  }

  @Test
  public void testDecodePayloadTooLargeRequest() throws IOException {
    PartitionCodec.setLimitsForTesting(1_000_000, 1024 * 1024, 100, 1024 * 1024, 1024 * 1024);

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(gzipOutputStream)) {
      dataOutputStream.writeByte(1); // Version 1
      dataOutputStream.writeUTF("session");
      dataOutputStream.writeInt(4);
      dataOutputStream.write(new byte[] {1, 2, 3, 4});
      dataOutputStream.writeLong(100L);
      dataOutputStream.writeInt(0);
      dataOutputStream.writeInt(10);
      dataOutputStream.write(new byte[10]);
      dataOutputStream.writeLong(0L);
      dataOutputStream.writeLong(0L);
      dataOutputStream.writeInt(101); // Exceeds 100 max payload limit
    }
    String encoded = Base64.getUrlEncoder().encodeToString(byteArrayOutputStream.toByteArray());

    SpannerException exception =
        assertThrows(SpannerException.class, () -> PartitionCodec.decodeFromString(encoded));
    assertTrue(exception.getMessage().contains("Invalid length in serialized PartitionId"));
  }

  @Test
  public void testDecodeNegativeFieldLengthThrows() throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(gzipOutputStream)) {
      dataOutputStream.writeByte(1); // Version 1
      dataOutputStream.writeUTF("session-id");
      dataOutputStream.writeInt(10);
      dataOutputStream.write(new byte[10]);
      dataOutputStream.writeLong(0);
      dataOutputStream.writeInt(0);
      dataOutputStream.writeInt(-1); // Negative length
    }
    String encoded = Base64.getUrlEncoder().encodeToString(byteArrayOutputStream.toByteArray());

    SpannerException exception =
        assertThrows(SpannerException.class, () -> PartitionCodec.decodeFromString(encoded));
    assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
    assertTrue(exception.getMessage().contains("Invalid length in serialized PartitionId"));
  }

  @Test
  public void testDecodeDecompressedSizeExceeded() throws IOException {
    PartitionCodec.setLimitsForTesting(1_000_000, 100, 1024);

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(gzipOutputStream)) {
      dataOutputStream.writeByte(1);
      dataOutputStream.writeUTF("session");
      dataOutputStream.writeInt(4);
      dataOutputStream.write(new byte[] {1, 2, 3, 4});
      dataOutputStream.writeLong(100L);
      dataOutputStream.writeInt(0);
      byte[] largePayload = new byte[200]; // Exceeds 100 max decompressed bytes limit
      dataOutputStream.writeInt(largePayload.length);
      dataOutputStream.write(largePayload);
    }
    String encoded = Base64.getUrlEncoder().encodeToString(byteArrayOutputStream.toByteArray());

    assertThrows(SpannerException.class, () -> PartitionCodec.decodeFromString(encoded));
  }

  @Test
  public void testDecodeCorruptedBase64() {
    assertThrows(
        SpannerException.class, () -> PartitionCodec.decodeFromString("not-valid-base-64!!!"));
  }

  @Test
  public void testDecodeCorruptedGzip() {
    byte[] notGzipBytes = "Hello world this is not gzip".getBytes(StandardCharsets.UTF_8);
    String notGzip = Base64.getUrlEncoder().encodeToString(notGzipBytes);
    assertThrows(SpannerException.class, () -> PartitionCodec.decodeFromString(notGzip));
  }

  @Test
  public void testDecodeCorruptedMagicStream() throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream)) {
      gzipOutputStream.write(new byte[] {(byte) 0xac, (byte) 0xed, 0x00, 0x05});
    }
    String maliciousPayload =
        Base64.getUrlEncoder().encodeToString(byteArrayOutputStream.toByteArray());

    SpannerException exception =
        assertThrows(
            SpannerException.class, () -> PartitionCodec.decodeFromString(maliciousPayload));
    assertTrue(exception.getMessage().contains("Unsupported PartitionId format version: -84"));
  }

  @Test
  public void testEncodeReadPartitionFails() {
    BatchTransactionId batchTransactionId =
        new BatchTransactionId(
            "projects/p/instances/i/databases/d/sessions/s",
            ByteString.copyFromUtf8("txn"),
            Timestamp.ofTimeSecondsAndNanos(100L, 0));

    Partition readPartition =
        Partition.createReadPartition(
            ByteString.copyFromUtf8("read-token"),
            PartitionOptions.getDefaultInstance(),
            "Singers",
            null,
            KeySet.all(),
            Arrays.asList("SingerId", "Name"),
            null);

    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> PartitionCodec.encodeToString(batchTransactionId, readPartition));
    assertEquals("Only query partitions are supported for PartitionId", exception.getMessage());
  }

  @Test
  public void testEncodeExecuteSqlRequestPartition() {
    BatchTransactionId batchTransactionId =
        new BatchTransactionId(
            "projects/p/instances/i/databases/d/sessions/s",
            ByteString.copyFromUtf8("txn"),
            Timestamp.ofTimeSecondsAndNanos(100L, 0));

    ExecuteSqlRequest request =
        ExecuteSqlRequest.newBuilder().setSql("SELECT * FROM Albums").build();

    Partition protoPartition =
        Partition.createQueryPartition(
            ByteString.copyFromUtf8("token"), PartitionOptions.getDefaultInstance(), request);

    String encoded = PartitionCodec.encodeToString(batchTransactionId, protoPartition);
    DecodedPartition decoded = PartitionCodec.decodeFromString(encoded);
    assertEquals(request, decoded.getPartition().getExecuteSqlRequest());
  }

  @Test
  public void testEncodeStatementPartition() {
    BatchTransactionId batchTransactionId =
        new BatchTransactionId(
            "projects/p/instances/i/databases/d/sessions/s",
            ByteString.copyFromUtf8("txn"),
            Timestamp.ofTimeSecondsAndNanos(100L, 0));

    Partition partition =
        Partition.createQueryPartition(
            ByteString.copyFromUtf8("token"),
            PartitionOptions.getDefaultInstance(),
            Statement.of("SELECT * FROM Albums"),
            null);

    String encoded = PartitionCodec.encodeToString(batchTransactionId, partition);
    DecodedPartition decoded = PartitionCodec.decodeFromString(encoded);
    assertEquals("SELECT * FROM Albums", decoded.getPartition().getExecuteSqlRequest().getSql());
  }

  @Test
  public void testEncodeDecodeNullPartitionOptions() {
    BatchTransactionId batchTransactionId =
        new BatchTransactionId(
            "projects/p/instances/i/databases/d/sessions/s",
            ByteString.copyFromUtf8("txn-null-opts"),
            Timestamp.ofTimeSecondsAndNanos(100L, 0));

    Partition partition =
        Partition.createQueryPartition(
            ByteString.copyFromUtf8("token-null-opts"), null, Statement.of("SELECT 1"), null);

    String encoded = PartitionCodec.encodeToString(batchTransactionId, partition);
    DecodedPartition decoded = PartitionCodec.decodeFromString(encoded);

    assertEquals(0L, decoded.getPartition().getPartitionOptions().getPartitionSizeBytes());
    assertEquals(0L, decoded.getPartition().getPartitionOptions().getMaxPartitions());
  }

  @Test
  public void testDecodeTrailingBytesFails() throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(gzipOutputStream)) {
      dataOutputStream.writeByte(1); // Version 1

      // 1. BatchTransactionId
      dataOutputStream.writeUTF("session");
      dataOutputStream.writeInt(4);
      dataOutputStream.write(new byte[] {1, 2, 3, 4});
      dataOutputStream.writeLong(100L);
      dataOutputStream.writeInt(0);

      // 2. Partition
      dataOutputStream.writeInt(5);
      dataOutputStream.write(new byte[] {1, 2, 3, 4, 5});
      dataOutputStream.writeLong(0L);
      dataOutputStream.writeLong(0L);

      // 3. ExecuteSqlRequest
      ExecuteSqlRequest request = ExecuteSqlRequest.newBuilder().setSql("SELECT 1").build();
      byte[] requestBytes = request.toByteArray();
      dataOutputStream.writeInt(requestBytes.length);
      dataOutputStream.write(requestBytes);

      // Trailing bytes
      dataOutputStream.writeUTF("extra trailing garbage bytes");
    }
    String encoded = Base64.getUrlEncoder().encodeToString(byteArrayOutputStream.toByteArray());

    SpannerException exception =
        assertThrows(SpannerException.class, () -> PartitionCodec.decodeFromString(encoded));
    assertTrue(exception.getMessage().contains("Unexpected trailing bytes in PartitionId"));
  }

  @Test
  public void testDecodedPartitionEqualsAndHashCode() {
    BatchTransactionId txn1 =
        new BatchTransactionId(
            "session-1", ByteString.copyFromUtf8("txn-1"), Timestamp.ofTimeSecondsAndNanos(1, 0));
    BatchTransactionId txn2 =
        new BatchTransactionId(
            "session-2", ByteString.copyFromUtf8("txn-2"), Timestamp.ofTimeSecondsAndNanos(2, 0));

    Partition p1 =
        Partition.createQueryPartition(
            ByteString.copyFromUtf8("tok-1"),
            PartitionOptions.getDefaultInstance(),
            Statement.of("SELECT 1"),
            null);
    Partition p2 =
        Partition.createQueryPartition(
            ByteString.copyFromUtf8("tok-2"),
            PartitionOptions.getDefaultInstance(),
            Statement.of("SELECT 2"),
            null);

    DecodedPartition dp1a = new DecodedPartition(txn1, p1);
    DecodedPartition dp1b = new DecodedPartition(txn1, p1);
    DecodedPartition dp2 = new DecodedPartition(txn2, p2);

    assertEquals(dp1a, dp1a);
    assertEquals(dp1a, dp1b);
    assertEquals(dp1a.hashCode(), dp1b.hashCode());
    assertFalse(dp1a.equals(dp2));
    assertFalse(dp1a.equals(null));
    assertFalse(dp1a.equals("not a DecodedPartition"));
    assertTrue(dp1a.toString().contains("DecodedPartition"));
  }
}
