/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigquery.storage.v1;

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.StatusProto;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/** Exceptions for Storage Client Libraries. */
public final class Exceptions {
  /** Main Storage Exception. Might contain map of streams to errors for that stream. */
  public static class StorageException extends StatusRuntimeException {

    private final ImmutableMap<String, GrpcStatusCode> errors;
    private final String streamName;
    private final Long expectedOffset;
    private final Long actualOffset;

    private StorageException() {
      this(null, null, null, null, ImmutableMap.of());
    }

    private StorageException(
        @Nullable Status grpcStatus,
        @Nullable String streamName,
        @Nullable Long expectedOffset,
        @Nullable Long actualOffset,
        ImmutableMap<String, GrpcStatusCode> errors) {
      super(grpcStatus);
      this.streamName = streamName;
      this.expectedOffset = expectedOffset;
      this.actualOffset = actualOffset;
      this.errors = errors;
    }

    public ImmutableMap<String, GrpcStatusCode> getErrors() {
      return errors;
    }

    public String getStreamName() {
      return streamName;
    }

    public long getExpectedOffset() {
      return expectedOffset;
    }

    public long getActualOffset() {
      return actualOffset;
    }
  }

  /**
   * The write stream has already been finalized and will not accept further appends or flushes. To
   * send additional requests, you will need to create a new write stream via CreateWriteStream.
   */
  public static final class StreamFinalizedException extends StorageException {
    protected StreamFinalizedException(Status grpcStatus, String name) {
      super(grpcStatus, name, null, null, ImmutableMap.of());
    }
  }

  /**
   * There was a schema mismatch due to bigquery table with fewer fields than the input message.
   * This can be resolved by updating the table's schema with the message schema.
   */
  public static final class SchemaMismatchedException extends StorageException {
    protected SchemaMismatchedException(Status grpcStatus, String name) {
      super(grpcStatus, name, null, null, ImmutableMap.of());
    }
  }

  /**
   * Offset already exists. This indicates that the append request attempted to write data to an
   * offset before the current end of the stream. This is an expected exception when ExactOnce is
   * enforced. You can safely ignore it, and keep appending until there is new data to append.
   */
  public static final class OffsetAlreadyExists extends StorageException {
    protected OffsetAlreadyExists(
        Status grpcStatus, String name, Long expectedOffset, Long actualOffset) {
      super(grpcStatus, name, expectedOffset, actualOffset, ImmutableMap.of());
    }
  }

  /**
   * Offset out of range. This indicates that the append request is attempting to write data to a
   * point beyond the current end of the stream. To append data successfully, you must either
   * specify the offset corresponding to the current end of stream, or omit the offset from the
   * append request. It usually means a bug in your code that introduces a gap in appends.
   */
  public static final class OffsetOutOfRange extends StorageException {
    protected OffsetOutOfRange(
        Status grpcStatus, String name, Long expectedOffset, Long actualOffset) {
      super(grpcStatus, name, expectedOffset, actualOffset, ImmutableMap.of());
    }
  }

  /**
   * The stream is not found. Possible causes include incorrectly specifying the stream identifier
   * or attempting to use an old stream identifier that no longer exists. You can invoke
   * CreateWriteStream to create a new stream.
   */
  public static final class StreamNotFound extends StorageException {
    protected StreamNotFound(Status grpcStatus, String name) {
      super(grpcStatus, name, null, null, ImmutableMap.of());
    }
  }

  private static StorageError toStorageError(com.google.rpc.Status rpcStatus) {
    for (Any detail : rpcStatus.getDetailsList()) {
      if (detail.is(StorageError.class)) {
        try {
          return detail.unpack(StorageError.class);
        } catch (InvalidProtocolBufferException protoException) {
          throw new IllegalStateException(protoException);
        }
      }
    }
    return null;
  }

  /**
   * Converts a c.g.rpc.Status into a StorageException, if possible. Examines the embedded
   * StorageError, and potentially returns a {@link StreamFinalizedException} or {@link
   * SchemaMismatchedException} (both derive from StorageException). If there is no StorageError, or
   * the StorageError is a different error it will return NULL.
   */
  @Nullable
  public static StorageException toStorageException(
      com.google.rpc.Status rpcStatus, Throwable exception) {
    StorageError error = toStorageError(rpcStatus);
    Status grpcStatus =
        Status.fromCodeValue(rpcStatus.getCode()).withDescription(rpcStatus.getMessage());
    if (error == null) {
      return null;
    }
    String streamName = error.getEntity();
    // The error message should have Entity but it's missing from the message for
    // OFFSET_ALREADY_EXISTS
    // TODO: Simplify the logic below when backend fixes passing Entity for OFFSET_ALREADY_EXISTS
    // error
    String errorMessage =
        error.getErrorMessage().indexOf("Entity") > 0
            ? error.getErrorMessage().substring(0, error.getErrorMessage().indexOf("Entity")).trim()
            : error.getErrorMessage().trim();

    // Ensure that erro message has the desirable pattern for parsing
    String errormessagePatternString = "expected offset [0-9]+, received [0-9]+";
    Pattern errorMessagePattern = Pattern.compile(errormessagePatternString);
    Matcher errorMessageMatcher = errorMessagePattern.matcher(errorMessage);

    Long expectedOffet;
    Long actualOffset;
    if (!errorMessageMatcher.find()) {
      expectedOffet = -1L;
      actualOffset = -1L;
    } else {
      expectedOffet =
          Long.parseLong(
              errorMessage.substring(
                  errorMessage.lastIndexOf("offset") + 7, errorMessage.lastIndexOf(",")));
      actualOffset = Long.parseLong(errorMessage.substring(errorMessage.lastIndexOf(" ") + 1));
    }
    switch (error.getCode()) {
      case STREAM_FINALIZED:
        return new StreamFinalizedException(grpcStatus, streamName);

      case STREAM_NOT_FOUND:
        return new StreamNotFound(grpcStatus, streamName);

      case SCHEMA_MISMATCH_EXTRA_FIELDS:
        return new SchemaMismatchedException(grpcStatus, streamName);

      case OFFSET_OUT_OF_RANGE:
        return new OffsetOutOfRange(grpcStatus, streamName, expectedOffet, actualOffset);

      case OFFSET_ALREADY_EXISTS:
        return new OffsetAlreadyExists(grpcStatus, streamName, expectedOffet, actualOffset);

      default:
        return null;
    }
  }

  /**
   * Converts a Throwable into a StorageException, if possible. Examines the embedded error message,
   * and potentially returns a {@link StreamFinalizedException} or {@link SchemaMismatchedException}
   * (both derive from StorageException). If there is no StorageError, or the StorageError is a
   * different error it will return NULL.
   */
  @Nullable
  public static StorageException toStorageException(Throwable exception) {
    com.google.rpc.Status rpcStatus = StatusProto.fromThrowable(exception);
    return toStorageException(rpcStatus, exception);
  }

  /**
   * This exception is thrown from {@link JsonStreamWriter#append()} when the client side Json to
   * Proto serializtion fails. It can also be thrown by the server in case rows contains invalid
   * data. The exception contains a Map of indexes of faulty rows and the corresponding error
   * message.
   */
  public static class AppendSerializtionError extends StatusRuntimeException {
    private final Map<Integer, String> rowIndexToErrorMessage;
    private final String streamName;

    public AppendSerializtionError(
        int codeValue,
        String description,
        String streamName,
        Map<Integer, String> rowIndexToErrorMessage) {
      super(Status.fromCodeValue(codeValue).withDescription(description));
      this.rowIndexToErrorMessage = rowIndexToErrorMessage;
      this.streamName = streamName;
    }

    public Map<Integer, String> getRowIndexToErrorMessage() {
      return rowIndexToErrorMessage;
    }

    public String getStreamName() {
      return streamName;
    }
  }

  /** This exception is used internally to handle field level parsing errors. */
  public static class FieldParseError extends IllegalArgumentException {
    private final String fieldName;
    private final String bqType;
    private final Throwable cause;

    protected FieldParseError(String fieldName, String bqType, Throwable cause) {
      this.fieldName = fieldName;
      this.bqType = bqType;
      this.cause = cause;
    }

    public String getFieldName() {
      return fieldName;
    }

    public String getBqType() {
      return bqType;
    }

    public Throwable getCause() {
      return cause;
    }

    public String getMessage() {
      return cause.getMessage();
    }
  }

  /**
   * This writer instance has either been closed by the user explicitly, or has encountered
   * non-retriable errors.
   *
   * <p>To continue to write to the same stream, you will need to create a new writer instance.
   */
  public static final class StreamWriterClosedException extends StatusRuntimeException {
    private final String streamName;
    private final String writerId;

    protected StreamWriterClosedException(Status grpcStatus, String streamName, String writerId) {
      super(grpcStatus);
      this.streamName = streamName;
      this.writerId = writerId;
    }

    public String getStreamName() {
      return streamName;
    }

    public String getWriterId() {
      return writerId;
    }
  }

  /**
   * If FlowController.LimitExceededBehavior is set to Block and inflight limit is exceeded, this
   * exception will be thrown. If it is just a spike, you may retry the request. Otherwise, you can
   * increase the inflight limit or create more StreamWriter to handle your traffic.
   */
  public static class InflightLimitExceededException extends StatusRuntimeException {
    private final long currentLimit;
    private final String writerId;

    protected InflightLimitExceededException(
        Status grpcStatus, String writerId, long currentLimit) {
      super(grpcStatus);
      this.currentLimit = currentLimit;
      this.writerId = writerId;
    }

    public String getWriterId() {
      return writerId;
    }

    public long getCurrentLimit() {
      return currentLimit;
    }
  }

  public static class InflightRequestsLimitExceededException
      extends InflightLimitExceededException {
    protected InflightRequestsLimitExceededException(String writerId, long currentLimit) {
      super(
          Status.fromCode(Status.Code.RESOURCE_EXHAUSTED)
              .withDescription(
                  "Exceeds client side inflight buffer, consider add more buffer or open more connections. Current limit: "
                      + currentLimit),
          writerId,
          currentLimit);
    }
  }

  public static class InflightBytesLimitExceededException extends InflightLimitExceededException {
    protected InflightBytesLimitExceededException(String writerId, long currentLimit) {
      super(
          Status.fromCode(Status.Code.RESOURCE_EXHAUSTED)
              .withDescription(
                  "Exceeds client side inflight buffer, consider add more buffer or open more connections. Current limit:  "
                      + currentLimit),
          writerId,
          currentLimit);
    }
  }
  /**
   * Input Json data has unknown field to the schema of the JsonStreamWriter. User can either turn
   * on IgnoreUnknownFields option on the JsonStreamWriter, or if they don't want the error to be
   * ignored, they should recreate the JsonStreamWriter with the updated table schema.
   */
  public static final class JsonDataHasUnknownFieldException extends IllegalArgumentException {
    private final String jsonFieldName;

    protected JsonDataHasUnknownFieldException(String jsonFieldName) {
      super(String.format("JSONObject has fields unknown to BigQuery: %s.", jsonFieldName));
      this.jsonFieldName = jsonFieldName;
    }

    public String getFieldName() {
      return jsonFieldName;
    }
  }

  private Exceptions() {}
}
