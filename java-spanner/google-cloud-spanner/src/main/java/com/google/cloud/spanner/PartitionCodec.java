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

import com.google.api.core.InternalApi;
import com.google.cloud.Timestamp;
import com.google.common.annotations.VisibleForTesting;
import com.google.protobuf.ByteString;
import com.google.spanner.v1.ExecuteSqlRequest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Objects;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Encapsulates the serialization and deserialization of {@link BatchTransactionId} and {@link
 * Partition} pairs into URL-safe base64 strings using structured protobuf and binary encoding.
 */
@InternalApi
@NullMarked
public final class PartitionCodec {

  private static final byte FORMAT_VERSION_1 = 1;
  private static final int DEFAULT_MAX_ENCODED_STRING_LENGTH = 32_000_000;
  private static final long DEFAULT_MAX_DECOMPRESSED_BYTES = 64 * 1024 * 1024L; // 64 MB
  private static final int DEFAULT_MAX_PAYLOAD_BYTES = 64 * 1024 * 1024; // 64 MB
  private static final int DEFAULT_MAX_TRANSACTION_ID_BYTES = 1024 * 1024; // 1 MB
  private static final int DEFAULT_MAX_PARTITION_TOKEN_BYTES = 4 * 1024 * 1024; // 4 MB

  private static int maxEncodedStringLength =
      Integer.getInteger("spanner.max_partition_id_length", DEFAULT_MAX_ENCODED_STRING_LENGTH);
  private static long maxDecompressedBytes =
      Long.getLong("spanner.max_partition_id_bytes", DEFAULT_MAX_DECOMPRESSED_BYTES);
  private static int maxPayloadBytes =
      Integer.getInteger("spanner.max_partition_payload_bytes", DEFAULT_MAX_PAYLOAD_BYTES);
  private static int maxTransactionIdBytes =
      Integer.getInteger(
          "spanner.max_partition_transaction_id_bytes", DEFAULT_MAX_TRANSACTION_ID_BYTES);
  private static int maxPartitionTokenBytes =
      Integer.getInteger("spanner.max_partition_token_bytes", DEFAULT_MAX_PARTITION_TOKEN_BYTES);

  @VisibleForTesting
  public static void setLimitsForTesting(
      int testMaxEncodedLength, long testMaxDecompressed, int testMaxPayload) {
    setLimitsForTesting(
        testMaxEncodedLength,
        testMaxDecompressed,
        testMaxPayload,
        DEFAULT_MAX_TRANSACTION_ID_BYTES,
        DEFAULT_MAX_PARTITION_TOKEN_BYTES);
  }

  @VisibleForTesting
  public static void setLimitsForTesting(
      int testMaxEncodedLength,
      long testMaxDecompressed,
      int testMaxPayload,
      int testMaxTransactionId,
      int testMaxPartitionToken) {
    maxEncodedStringLength = testMaxEncodedLength;
    maxDecompressedBytes = testMaxDecompressed;
    maxPayloadBytes = testMaxPayload;
    maxTransactionIdBytes = testMaxTransactionId;
    maxPartitionTokenBytes = testMaxPartitionToken;
  }

  @VisibleForTesting
  public static void resetLimitsForTesting() {
    maxEncodedStringLength =
        Integer.getInteger("spanner.max_partition_id_length", DEFAULT_MAX_ENCODED_STRING_LENGTH);
    maxDecompressedBytes =
        Long.getLong("spanner.max_partition_id_bytes", DEFAULT_MAX_DECOMPRESSED_BYTES);
    maxPayloadBytes =
        Integer.getInteger("spanner.max_partition_payload_bytes", DEFAULT_MAX_PAYLOAD_BYTES);
    maxTransactionIdBytes =
        Integer.getInteger(
            "spanner.max_partition_transaction_id_bytes", DEFAULT_MAX_TRANSACTION_ID_BYTES);
    maxPartitionTokenBytes =
        Integer.getInteger("spanner.max_partition_token_bytes", DEFAULT_MAX_PARTITION_TOKEN_BYTES);
  }

  /** Holds the decoded {@link BatchTransactionId} and {@link Partition}. */
  @InternalApi
  public static final class DecodedPartition {
    private final BatchTransactionId transactionId;
    private final Partition partition;

    DecodedPartition(BatchTransactionId transactionId, Partition partition) {
      this.transactionId = Objects.requireNonNull(transactionId);
      this.partition = Objects.requireNonNull(partition);
    }

    public BatchTransactionId getTransactionId() {
      return transactionId;
    }

    public Partition getPartition() {
      return partition;
    }

    @Override
    public boolean equals(@Nullable Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof DecodedPartition)) {
        return false;
      }
      DecodedPartition other = (DecodedPartition) o;
      return Objects.equals(this.transactionId, other.transactionId)
          && Objects.equals(this.partition, other.partition);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.transactionId, this.partition);
    }

    @Override
    public String toString() {
      return "DecodedPartition{transactionId=" + transactionId + ", partition=" + partition + "}";
    }
  }

  private static class BoundedInputStream extends InputStream {
    private final InputStream delegate;
    private final long maxBytes;
    private long bytesRead = 0;

    BoundedInputStream(InputStream delegate, long maxBytes) {
      this.delegate = delegate;
      this.maxBytes = maxBytes;
    }

    @Override
    public int read() throws IOException {
      int nextByte = delegate.read();
      if (nextByte != -1) {
        incrementBytes(1);
      }
      return nextByte;
    }

    @Override
    public int read(byte[] buffer, int offset, int length) throws IOException {
      int count = delegate.read(buffer, offset, length);
      if (count > 0) {
        incrementBytes(count);
      }
      return count;
    }

    private void incrementBytes(int count) throws IOException {
      bytesRead += count;
      if (bytesRead > maxBytes) {
        throw new IOException(
            "Decompressed partition ID exceeds maximum allowed size of " + maxBytes + " bytes");
      }
    }

    @Override
    public void close() throws IOException {
      delegate.close();
    }
  }

  private static void checkLength(int length, int maxLength) throws IOException {
    if (length < 0 || length > maxLength) {
      throw new IOException("Invalid length in serialized PartitionId: " + length);
    }
  }

  /**
   * Deserializes an encoded string representation into a {@link DecodedPartition}.
   *
   * @param id the URL-safe base64 string
   * @return the decoded transaction ID and partition
   */
  public static DecodedPartition decodeFromString(@Nullable String id) {
    if (id == null || id.length() > maxEncodedStringLength) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INVALID_ARGUMENT, "The id is null or exceeds the maximum allowed length");
    }
    try (BoundedInputStream boundedInputStream =
            new BoundedInputStream(
                new GZIPInputStream(new ByteArrayInputStream(Base64.getUrlDecoder().decode(id))),
                maxDecompressedBytes);
        DataInputStream dataInputStream = new DataInputStream(boundedInputStream)) {
      byte version = dataInputStream.readByte();
      if (version != FORMAT_VERSION_1) {
        throw new IOException("Unsupported PartitionId format version: " + version);
      }

      // 1. BatchTransactionId
      String sessionId = dataInputStream.readUTF();
      int transactionIdLength = dataInputStream.readInt();
      checkLength(transactionIdLength, maxTransactionIdBytes);
      byte[] transactionIdBytes = new byte[transactionIdLength];
      dataInputStream.readFully(transactionIdBytes);
      long seconds = dataInputStream.readLong();
      int nanos = dataInputStream.readInt();
      BatchTransactionId transactionId =
          new BatchTransactionId(
              sessionId,
              ByteString.copyFrom(transactionIdBytes),
              Timestamp.ofTimeSecondsAndNanos(seconds, nanos));

      // 2. Partition
      int tokenLength = dataInputStream.readInt();
      checkLength(tokenLength, maxPartitionTokenBytes);
      byte[] tokenBytes = new byte[tokenLength];
      dataInputStream.readFully(tokenBytes);
      ByteString partitionToken = ByteString.copyFrom(tokenBytes);

      long partitionSizeBytes = dataInputStream.readLong();
      long maxPartitions = dataInputStream.readLong();
      PartitionOptions.Builder partitionOptionsBuilder = PartitionOptions.newBuilder();
      if (partitionSizeBytes > 0) {
        partitionOptionsBuilder.setPartitionSizeBytes(partitionSizeBytes);
      }
      if (maxPartitions > 0) {
        partitionOptionsBuilder.setMaxPartitions(maxPartitions);
      }
      PartitionOptions partitionOptions = partitionOptionsBuilder.build();

      // 3. ExecuteSqlRequest
      int requestLength = dataInputStream.readInt();
      checkLength(requestLength, maxPayloadBytes);
      byte[] requestBytes = new byte[requestLength];
      dataInputStream.readFully(requestBytes);
      ExecuteSqlRequest executeSqlRequest = ExecuteSqlRequest.parseFrom(requestBytes);
      if (dataInputStream.read() != -1) {
        throw new IOException("Unexpected trailing bytes in PartitionId");
      }

      Partition partition =
          Partition.createQueryPartition(partitionToken, partitionOptions, executeSqlRequest);
      return new DecodedPartition(transactionId, partition);
    } catch (IOException | IllegalArgumentException exception) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INVALID_ARGUMENT, exception.getMessage(), exception);
    } catch (Exception exception) {
      throw SpannerExceptionFactory.asSpannerException(exception);
    }
  }

  /**
   * Encodes a {@link BatchTransactionId} and a {@link Partition} into a URL-safe base64 string.
   *
   * @param transactionId the batch transaction ID
   * @param partition the query partition
   * @return the encoded string
   */
  public static String encodeToString(BatchTransactionId transactionId, Partition partition) {
    ExecuteSqlRequest executeSqlRequest = partition.getExecuteSqlRequest();
    if (executeSqlRequest == null && partition.getStatement() != null) {
      ExecuteSqlRequest.Builder builder = partition.getStatement().toExecuteSqlRequestBuilder();
      if (partition.getQueryOptions() != null) {
        partition.getQueryOptions().applyTo(builder);
      }
      executeSqlRequest = builder.build();
    }
    if (executeSqlRequest == null) {
      throw new IllegalArgumentException("Only query partitions are supported for PartitionId");
    }
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(gzipOutputStream)) {
      dataOutputStream.writeByte(FORMAT_VERSION_1);

      // 1. BatchTransactionId
      dataOutputStream.writeUTF(transactionId.getSessionId());
      dataOutputStream.writeInt(transactionId.getTransactionId().size());
      transactionId.getTransactionId().writeTo(dataOutputStream);
      dataOutputStream.writeLong(transactionId.getTimestamp().getSeconds());
      dataOutputStream.writeInt(transactionId.getTimestamp().getNanos());

      // 2. Partition
      dataOutputStream.writeInt(partition.getPartitionToken().size());
      partition.getPartitionToken().writeTo(dataOutputStream);

      PartitionOptions partitionOptions =
          partition.getPartitionOptions() == null
              ? PartitionOptions.getDefaultInstance()
              : partition.getPartitionOptions();
      dataOutputStream.writeLong(partitionOptions.getPartitionSizeBytes());
      dataOutputStream.writeLong(partitionOptions.getMaxPartitions());

      // 3. ExecuteSqlRequest
      dataOutputStream.writeInt(executeSqlRequest.getSerializedSize());
      executeSqlRequest.writeTo(dataOutputStream);
    } catch (IOException exception) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INTERNAL,
          "Failed to encode partition ID: " + exception.getMessage(),
          exception);
    }
    return Base64.getUrlEncoder().encodeToString(byteArrayOutputStream.toByteArray());
  }

  private PartitionCodec() {}
}
