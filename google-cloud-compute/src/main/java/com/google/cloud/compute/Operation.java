/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.compute;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.Clock;
import com.google.cloud.WaitForOption;
import com.google.cloud.WaitForOption.CheckingPeriod;
import com.google.cloud.compute.Compute.OperationOption;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Google Compute Engine operations. Operation identity can be obtained via {@link #operationId()}.
 * {@link #operationId()} returns {@link GlobalOperationId} for global operations,
 * {@link RegionOperationId} for region operations, and {@link ZoneOperationId} for zone operations.
 * To get an {@code Operation} object with the most recent information, use
 * {@link #reload(Compute.OperationOption...)}.
 */
public class Operation implements Serializable {

  private static final long serialVersionUID = -8979001444590023899L;
  private static final DateTimeFormatter TIMESTAMP_FORMATTER = ISODateTimeFormat.dateTime();

  private transient Compute compute;
  private final ComputeOptions options;
  private final String generatedId;
  private final OperationId operationId;
  private final String clientOperationId;
  private final String operationType;
  private final String targetLink;
  private final String targetId;
  private final Status status;
  private final String statusMessage;
  private final String user;
  private final Integer progress;
  private final Long insertTime;
  private final Long startTime;
  private final Long endTime;
  private final List<OperationError> errors;
  private final List<OperationWarning> warnings;
  private final Integer httpErrorStatusCode;
  private final String httpErrorMessage;
  private final String description;

  /**
   * Status of an operation.
   */
  public enum Status {
    PENDING,
    RUNNING,
    DONE
  }

  /**
   * An error that can occur during the processing of a Google Compute Engine operation.
   */
  public static final class OperationError implements Serializable {

    static final Function<com.google.api.services.compute.model.Operation.Error.Errors,
        OperationError> FROM_PB_FUNCTION = new Function<
            com.google.api.services.compute.model.Operation.Error.Errors, OperationError>() {
          @Override
          public OperationError apply(
              com.google.api.services.compute.model.Operation.Error.Errors pb) {
            return OperationError.fromPb(pb);
          }
        };
    static final Function<OperationError,
        com.google.api.services.compute.model.Operation.Error.Errors> TO_PB_FUNCTION =
        new Function<OperationError,
            com.google.api.services.compute.model.Operation.Error.Errors>() {
          @Override
          public com.google.api.services.compute.model.Operation.Error.Errors apply(
              OperationError operation) {
            return operation.toPb();
          }
        };

    private static final long serialVersionUID = -1155314394806515873L;

    private final String code;
    private final String location;
    private final String message;

    OperationError(String code, String location, String message) {
      this.code = code;
      this.location = location;
      this.message = message;
    }

    /**
     * Returns an error type identifier for this error.
     */
    @Deprecated
    public String code() {
      return getCode();
    }

    /**
     * Returns an error type identifier for this error.
     */
    public String getCode() {
      return code;
    }

    /**
     * Returns the field in the request which caused the error. This value is optional.
     */
    @Deprecated
    public String location() {
      return getLocation();
    }

    /**
     * Returns the field in the request which caused the error. This value is optional.
     */
    public String getLocation() {
      return location;
    }

    /**
     * Returns an optional, human-readable error message.
     */
    @Deprecated
    public String message() {
      return getMessage();
    }

    /**
     * Returns an optional, human-readable error message.
     */
    public String getMessage() {
      return message;
    }

    com.google.api.services.compute.model.Operation.Error.Errors toPb() {
      return new com.google.api.services.compute.model.Operation.Error.Errors()
          .setCode(code)
          .setLocation(location)
          .setMessage(message);
    }

    static OperationError fromPb(
        com.google.api.services.compute.model.Operation.Error.Errors errorPb) {
      return new OperationError(errorPb.getCode(), errorPb.getLocation(), errorPb.getMessage());
    }

    @Override
    public boolean equals(Object obj) {
      return obj instanceof OperationError
          && Objects.equals(code, ((OperationError) obj).code)
          && Objects.equals(message, ((OperationError) obj).message)
          && Objects.equals(location, ((OperationError) obj).location);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("code", code)
          .add("location", location)
          .add("message", message)
          .toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(code, location, message);
    }
  }

  /**
   * A warning message that is generated during the processing of a Google Compute Engine operation.
   */
  public static final class OperationWarning implements Serializable {

    static final
        Function<com.google.api.services.compute.model.Operation.Warnings, OperationWarning>
        FROM_PB_FUNCTION =
        new Function<com.google.api.services.compute.model.Operation.Warnings,
            OperationWarning>() {
          @Override
          public OperationWarning apply(
              com.google.api.services.compute.model.Operation.Warnings pb) {
            return OperationWarning.fromPb(pb);
          }
        };
    static final
        Function<OperationWarning, com.google.api.services.compute.model.Operation.Warnings>
        TO_PB_FUNCTION =
        new Function<OperationWarning,
            com.google.api.services.compute.model.Operation.Warnings>() {
          @Override
          public com.google.api.services.compute.model.Operation.Warnings apply(
              OperationWarning operation) {
            return operation.toPb();
          }
        };

    private static final long serialVersionUID = 4917326627380228928L;

    private final String code;
    private final String message;
    private final Map<String, String> metadata;

    OperationWarning(String code, String message, Map<String, String> metadata) {
      this.code = code;
      this.metadata = metadata != null ? ImmutableMap.copyOf(metadata) : null;
      this.message = message;
    }

    /**
     * Returns a warning identifier for this warning. For example, {@code NO_RESULTS_ON_PAGE} if
     * there are no results in the response.
     */
    @Deprecated
    public String code() {
      return getCode();
    }

    /**
     * Returns a warning identifier for this warning. For example, {@code NO_RESULTS_ON_PAGE} if
     * there are no results in the response.
     */
    public String getCode() {
      return code;
    }

    /**
     * Returns a human-readable error message.
     */
    @Deprecated
    public String message() {
      return getMessage();
    }

    /**
     * Returns a human-readable error message.
     */
    public String getMessage() {
      return message;
    }

    /**
     * Returns metadata about this warning. Each key provides more detail on the warning being
     * returned. For example, for warnings where there are no results in a list request for a
     * particular zone, this key might be {@code scope} and the key's value might be the zone name.
     * Other examples might be a key indicating a deprecated resource, and a suggested replacement,
     * or a warning about invalid network settings (for example, if an instance attempts to perform
     * IP forwarding but is not enabled for IP forwarding).
     */
    @Deprecated
    public Map<String, String> metadata() {
      return getMetadata();
    }

    /**
     * Returns metadata about this warning. Each key provides more detail on the warning being
     * returned. For example, for warnings where there are no results in a list request for a
     * particular zone, this key might be {@code scope} and the key's value might be the zone name.
     * Other examples might be a key indicating a deprecated resource, and a suggested replacement,
     * or a warning about invalid network settings (for example, if an instance attempts to perform
     * IP forwarding but is not enabled for IP forwarding).
     */
    public Map<String, String> getMetadata() {
      return metadata;
    }

    com.google.api.services.compute.model.Operation.Warnings toPb() {
      com.google.api.services.compute.model.Operation.Warnings warningPb =
          new com.google.api.services.compute.model.Operation.Warnings()
              .setCode(code)
              .setMessage(message);
      if (this.metadata != null) {
        List<com.google.api.services.compute.model.Operation.Warnings.Data> metadataPb =
            Lists.newArrayListWithCapacity(metadata.size());
        for (Map.Entry<String, String> entry : metadata.entrySet()) {
          metadataPb.add(new com.google.api.services.compute.model.Operation.Warnings.Data()
              .setKey(entry.getKey()).setValue(entry.getValue()));
        }
        warningPb.setData(metadataPb);
      }
      return warningPb;
    }

    static OperationWarning fromPb(
        com.google.api.services.compute.model.Operation.Warnings warningPb) {
      Map<String, String> metadata = null;
      if (warningPb.getData() != null) {
        metadata = Maps.newHashMapWithExpectedSize(warningPb.getData().size());
        for (com.google.api.services.compute.model.Operation.Warnings.Data data
            : warningPb.getData()) {
          metadata.put(data.getKey(), data.getValue());
        }
      }
      return new OperationWarning(warningPb.getCode(), warningPb.getMessage(), metadata);
    }

    @Override
    public boolean equals(Object obj) {
      return obj instanceof OperationWarning
          && Objects.equals(code, ((OperationWarning) obj).code)
          && Objects.equals(message, ((OperationWarning) obj).message)
          && Objects.equals(metadata, ((OperationWarning) obj).metadata);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("code", code)
          .add("message", message)
          .add("metadata", metadata)
          .toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(code, message, metadata);
    }
  }

  static final class Builder {

    private Compute compute;
    private String generatedId;
    private OperationId operationId;
    private String clientOperationId;
    private String operationType;
    private String targetLink;
    private String targetId;
    private Status status;
    private String statusMessage;
    private String user;
    private Integer progress;
    private Long insertTime;
    private Long startTime;
    private Long endTime;
    private List<OperationError> errors;
    private List<OperationWarning> warnings;
    private Integer httpErrorStatusCode;
    private String httpErrorMessage;
    private String description;

    Builder(Compute compute) {
      this.compute = compute;
    }

    Builder(Compute compute, com.google.api.services.compute.model.Operation operationPb) {
      this.compute = compute;
      if (operationPb.getId() != null) {
        generatedId = operationPb.getId().toString();
      }
      if (RegionOperationId.matchesUrl(operationPb.getSelfLink())) {
        operationId = RegionOperationId.fromUrl(operationPb.getSelfLink());
      } else if (ZoneOperationId.matchesUrl(operationPb.getSelfLink())) {
        operationId = ZoneOperationId.fromUrl(operationPb.getSelfLink());
      } else {
        operationId = GlobalOperationId.fromUrl(operationPb.getSelfLink());
      }
      clientOperationId = operationPb.getClientOperationId();
      operationType = operationPb.getOperationType();
      targetLink = operationPb.getTargetLink();
      if (operationPb.getTargetId() != null) {
        targetId = operationPb.getTargetId().toString();
      }
      if (operationPb.getStatus() != null) {
        status = Status.valueOf(operationPb.getStatus());
      }
      statusMessage = operationPb.getStatusMessage();
      user = operationPb.getUser();
      progress = operationPb.getProgress();
      if (operationPb.getInsertTime() != null) {
        insertTime = TIMESTAMP_FORMATTER.parseMillis(operationPb.getInsertTime());
      }
      if (operationPb.getStartTime() != null) {
        startTime = TIMESTAMP_FORMATTER.parseMillis(operationPb.getStartTime());
      }
      if (operationPb.getEndTime() != null) {
        endTime = TIMESTAMP_FORMATTER.parseMillis(operationPb.getEndTime());
      }
      if (operationPb.getError() != null && operationPb.getError().getErrors() != null) {
        errors =
            Lists.transform(operationPb.getError().getErrors(), OperationError.FROM_PB_FUNCTION);
      }
      if (operationPb.getWarnings() != null) {
        warnings = Lists.transform(operationPb.getWarnings(), OperationWarning.FROM_PB_FUNCTION);
      }
      httpErrorStatusCode = operationPb.getHttpErrorStatusCode();
      httpErrorMessage = operationPb.getHttpErrorMessage();
      description = operationPb.getDescription();
    }

    Builder getGeneratedId(String generatedId) {
      this.generatedId = generatedId;
      return this;
    }

    Builder setOperationId(OperationId operationId) {
      this.operationId = checkNotNull(operationId);
      return this;
    }

    Builder setClientOperationId(String clientOperationId) {
      this.clientOperationId = clientOperationId;
      return this;
    }

    Builder setOperationType(String operationType) {
      this.operationType = operationType;
      return this;
    }

    Builder setTargetLink(String targetLink) {
      this.targetLink = targetLink;
      return this;
    }

    Builder setTargetId(String targetId) {
      this.targetId = targetId;
      return this;
    }

    Builder setStatus(Status status) {
      this.status = status;
      return this;
    }

    Builder setStatusMessage(String statusMessage) {
      this.statusMessage = statusMessage;
      return this;
    }

    Builder setUser(String user) {
      this.user = user;
      return this;
    }

    Builder setProgress(Integer progress) {
      this.progress = progress;
      return this;
    }

    Builder setInsertTime(Long insertTime) {
      this.insertTime = insertTime;
      return this;
    }

    Builder setStartTime(Long startTime) {
      this.startTime = startTime;
      return this;
    }

    Builder setEndTime(Long endTime) {
      this.endTime = endTime;
      return this;
    }

    Builder setErrors(List<OperationError> errors) {
      this.errors = ImmutableList.copyOf(checkNotNull(errors));
      return this;
    }

    Builder setWarnings(List<OperationWarning> warnings) {
      this.warnings = ImmutableList.copyOf(checkNotNull(warnings));
      return this;
    }

    Builder setHttpErrorStatusCode(Integer httpErrorStatusCode) {
      this.httpErrorStatusCode = httpErrorStatusCode;
      return this;
    }

    Builder setHttpErrorMessage(String httpErrorMessage) {
      this.httpErrorMessage = httpErrorMessage;
      return this;
    }

    Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    Operation build() {
      return new Operation(this);
    }
  }

  private Operation(Builder builder) {
    this.compute = checkNotNull(builder.compute);
    this.options = compute.options();
    this.generatedId = builder.generatedId;
    this.operationId = checkNotNull(builder.operationId);
    this.clientOperationId = builder.clientOperationId;
    this.operationType = builder.operationType;
    this.targetLink = builder.targetLink;
    this.targetId = builder.targetId;
    this.status = builder.status;
    this.statusMessage = builder.statusMessage;
    this.user = builder.user;
    this.progress = builder.progress;
    this.insertTime = builder.insertTime;
    this.startTime = builder.startTime;
    this.endTime = builder.endTime;
    this.errors = builder.errors != null ? ImmutableList.copyOf(builder.errors) : null;
    this.warnings = builder.warnings != null ? ImmutableList.copyOf(builder.warnings) : null;
    this.httpErrorStatusCode = builder.httpErrorStatusCode;
    this.httpErrorMessage = builder.httpErrorMessage;
    this.description = builder.description;
  }

  /**
   * Returns the operation's {@code Compute} object used to issue requests.
   */
  @Deprecated
  public Compute compute() {
    return getCompute();
  }

  /**
   * Returns the operation's {@code Compute} object used to issue requests.
   */
  public Compute getCompute() {
    return compute;
  }

  /**
   * Returns the service-generated unique identifier for the operation.
   */
  @Deprecated
  public String generatedId() {
    return getGeneratedId();
  }

  /**
   * Returns the service-generated unique identifier for the operation.
   */
  public String getGeneratedId() {
    return generatedId;
  }

  /**
   * Returns the operation's identity. This method returns an {@link GlobalOperationId} for global
   * operations, a {@link RegionOperationId} for region operations and a {@link ZoneOperationId} for
   * zone operations.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  @SuppressWarnings("unchecked")
  @Deprecated
  public <T extends OperationId> T operationId() {
    return getOperationId();
  }

  /**
   * Returns the operation's identity. This method returns an {@link GlobalOperationId} for global
   * operations, a {@link RegionOperationId} for region operations and a {@link ZoneOperationId} for
   * zone operations.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  @SuppressWarnings("unchecked")
  public <T extends OperationId> T getOperationId() {
    return (T) operationId;
  }

  /**
   * Reserved for future use.
   */
  String getClientOperationId() {
    return clientOperationId;
  }

  /**
   * Returns the type of operation.
   */
  @Deprecated
  public String operationType() {
    return getOperationType();
  }

  /**
   * Returns the type of operation.
   */
  public String getOperationType() {
    return operationType;
  }

  /**
   * Returns the URL of the resource that the operation is modifying.
   */
  @Deprecated
  public String targetLink() {
    return getTargetLink();
  }

  /**
   * Returns the URL of the resource that the operation is modifying.
   */
  public String getTargetLink() {
    return targetLink;
  }

  /**
   * Returns the unique service-defined target ID, which identifies the resource that the operation
   * is modifying.
   */
  @Deprecated
  public String targetId() {
    return getTargetId();
  }

  /**
   * Returns the unique service-defined target ID, which identifies the resource that the operation
   * is modifying.
   */
  public String getTargetId() {
    return targetId;
  }

  /**
   * Returns the status of the operation.
   */
  @Deprecated
  public Status status() {
    return getStatus();
  }

  /**
   * Returns the status of the operation.
   */
  public Status getStatus() {
    return status;
  }

  /**
   * Returns an optional textual description of the current status of the operation.
   */
  @Deprecated
  public String statusMessage() {
    return getStatusMessage();
  }

  /**
   * Returns an optional textual description of the current status of the operation.
   */
  public String getStatusMessage() {
    return statusMessage;
  }

  /**
   * Returns the user who requested the operation, for example: {@code user@example.com}.
   */
  @Deprecated
  public String user() {
    return getUser();
  }

  /**
   * Returns the user who requested the operation, for example: {@code user@example.com}.
   */
  public String getUser() {
    return user;
  }

  /**
   * Returns an optional progress indicator that ranges from 0 to 100. There is no requirement that
   * this be linear or support any granularity of operations. This should not be used to guess when
   * the operation will be complete. This number should monotonically increase as the operation
   * progresses.
   */
  @Deprecated
  public Integer progress() {
    return getProgress();
  }

  /**
   * Returns an optional progress indicator that ranges from 0 to 100. There is no requirement that
   * this be linear or support any granularity of operations. This should not be used to guess when
   * the operation will be complete. This number should monotonically increase as the operation
   * progresses.
   */
  public Integer getProgress() {
    return progress;
  }

  /**
   * Returns the time that this operation was requested. In milliseconds since epoch.
   */
  @Deprecated
  public Long insertTime() {
    return getInsertTime();
  }

  /**
   * Returns the time that this operation was requested. In milliseconds since epoch.
   */
  public Long getInsertTime() {
    return insertTime;
  }

  /**
   * Returns the time that this operation was started by the service. In milliseconds since epoch.
   * This value will be {@code null} if the operation has not started yet.
   */
  @Deprecated
  public Long startTime() {
    return getStartTime();
  }

  /**
   * Returns the time that this operation was started by the service. In milliseconds since epoch.
   * This value will be {@code null} if the operation has not started yet.
   */
  public Long getStartTime() {
    return startTime;
  }

  /**
   * Returns the time that this operation was completed. In milliseconds since epoch. This value
   * will be {@code null} if the operation has not finished yet.
   */
  @Deprecated
  public Long endTime() {
    return getEndTime();
  }

  /**
   * Returns the time that this operation was completed. In milliseconds since epoch. This value
   * will be {@code null} if the operation has not finished yet.
   */
  public Long getEndTime() {
    return endTime;
  }

  /**
   * Returns the errors encountered while processing this operation, if any. Returns {@code null} if
   * no error occurred.
   */
  @Deprecated
  public List<OperationError> errors() {
    return getErrors();
  }

  /**
   * Returns the errors encountered while processing this operation, if any. Returns {@code null} if
   * no error occurred.
   */
  public List<OperationError> getErrors() {
    return errors;
  }

  /**
   * Returns the warnings encountered while processing this operation, if any. Returns {@code null}
   * if no warning occurred.
   */
  @Deprecated
  public List<OperationWarning> warnings() {
    return getWarnings();
  }

  /**
   * Returns the warnings encountered while processing this operation, if any. Returns {@code null}
   * if no warning occurred.
   */
  public List<OperationWarning> getWarnings() {
    return warnings;
  }

  /**
   * Returns the HTTP error status code that was returned, if the operation failed. For example, a
   * {@code 404} means the resource was not found.
   */
  @Deprecated
  public Integer httpErrorStatusCode() {
    return getHttpErrorStatusCode();
  }

  /**
   * Returns the HTTP error status code that was returned, if the operation failed. For example, a
   * {@code 404} means the resource was not found.
   */
  public Integer getHttpErrorStatusCode() {
    return httpErrorStatusCode;
  }

  /**
   * Returns the the HTTP error message that was returned, if the operation failed. For example, a
   * {@code NOT FOUND} message is returned if the resource was not found.
   */
  @Deprecated
  public String httpErrorMessage() {
    return getHttpErrorMessage();
  }

  /**
   * Returns the the HTTP error message that was returned, if the operation failed. For example, a
   * {@code NOT FOUND} message is returned if the resource was not found.
   */
  public String getHttpErrorMessage() {
    return httpErrorMessage;
  }

  /**
   * Returns an optional textual description of the operation.
   */
  @Deprecated
  public String description() {
    return getDescription();
  }

  /**
   * Returns an optional textual description of the operation.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Checks if this operation exists.
   *
   * @return {@code true} if this operation exists, {@code false} otherwise
   * @throws ComputeException upon failure
   */
  public boolean exists() {
    return reload(OperationOption.fields()) != null;
  }

  /**
   * Checks if this operation has completed its execution, either failing or succeeding. If the
   * operation does not exist this method returns {@code true}. You can wait for operation
   * completion with:
   * <pre> {@code
   * while(!operation.isDone()) {
   *   Thread.sleep(1000L);
   * }}</pre>
   *
   * @return {@code true} if this operation is in {@link Operation.Status#DONE} state or if it does
   *     not exist, {@code false} if the state is not {@link Operation.Status#DONE}
   * @throws ComputeException upon failure
   */
  public boolean isDone() {
    Operation operation = compute.getOperation(operationId,
        OperationOption.fields(Compute.OperationField.STATUS));
    return operation == null || operation.getStatus() == Status.DONE;
  }

  /**
   * Blocks until this operation completes its execution, either failing or succeeding. This method
   * returns current operation's latest information. If the operation no longer exists, this method
   * returns {@code null}. By default, the operation status is checked every 500 milliseconds, to
   * configure this value use {@link WaitForOption#checkEvery(long, TimeUnit)}. Use
   * {@link WaitForOption#timeout(long, TimeUnit)} to set the maximum time to wait.
   *
   * <p>Example usage of {@code waitFor()}:
   * <pre> {@code
   * Operation completedOperation = operation.waitFor();
   * if (completedOperation == null) {
   *   // operation no longer exists
   * } else if (completedOperation.errors() != null) {
   *   // operation failed, handle error
   * } else {
   *   // operation completed successfully
   * }}</pre>
   *
   * <p>Example usage of {@code waitFor()} with checking period and timeout:
   * <pre> {@code
   * Operation completedOperation =
   *     operation.waitFor(WaitForOption.checkEvery(1, TimeUnit.SECONDS),
   *         WaitForOption.timeout(60, TimeUnit.SECONDS));
   * if (completedOperation == null) {
   *   // operation no longer exists
   * } else if (completedOperation.errors() != null) {
   *   // operation failed, handle error
   * } else {
   *   // operation completed successfully
   * }}</pre>
   *
   * @param waitOptions options to configure checking period and timeout
   * @throws ComputeException upon failure
   * @throws InterruptedException if the current thread gets interrupted while waiting for the
   *     operation to complete
   * @throws TimeoutException if the timeout provided with
   *     {@link WaitForOption#timeout(long, TimeUnit)} is exceeded. If no such option is provided
   *     this exception is never thrown.
   */
  public Operation waitFor(WaitForOption... waitOptions)
      throws InterruptedException, TimeoutException {
    WaitForOption.Timeout timeout = WaitForOption.Timeout.getOrDefault(waitOptions);
    CheckingPeriod checkingPeriod = CheckingPeriod.getOrDefault(waitOptions);
    long timeoutMillis = timeout.timeoutMillis();
    Clock clock = options.clock();
    long startTime = clock.millis();
    while (!isDone()) {
      if (timeoutMillis  != -1 && (clock.millis() - startTime)  >= timeoutMillis) {
        throw new TimeoutException();
      }
      checkingPeriod.sleep();
    }
    return reload();
  }

  /**
   * Fetches current operation's latest information. Returns {@code null} if the operation does not
   * exist.
   *
   * @param options operation options
   * @return an {@code Operation} object with latest information or {@code null} if not found
   * @throws ComputeException upon failure
   */
  public Operation reload(OperationOption... options) {
    return compute.getOperation(operationId, options);
  }

  /**
   * Deletes this operation. Delete is only possible for operations that have completed their
   * execution. Any attempt to delete a running operation will fail.
   *
   * @return {@code true} if operation was deleted, {@code false} if it was not found
   * @throws ComputeException upon failure
   */
  public boolean delete() {
    return compute.deleteOperation(operationId);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("generatedId", generatedId)
        .add("operationsId", operationId)
        .add("clientOperationId", clientOperationId)
        .add("operationType", operationType)
        .add("targetLink", targetLink)
        .add("targetId", targetId)
        .add("status", status)
        .add("statusMessage", statusMessage)
        .add("user", user)
        .add("progress", progress)
        .add("insertTime", insertTime)
        .add("startTime", startTime)
        .add("endTime", endTime)
        .add("errors", errors)
        .add("warnings", warnings)
        .add("httpErrorStatusCode", httpErrorStatusCode)
        .add("httpErrorMessage", httpErrorMessage)
        .add("description", description)
        .toString();
  }

  @Override
  public final int hashCode() {
    return Objects.hash(operationId);
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(Operation.class)) {
      return false;
    }
    Operation other = (Operation) obj;
    return Objects.equals(toPb(), other.toPb()) && Objects.equals(options, other.options);
  }

  com.google.api.services.compute.model.Operation toPb() {
    com.google.api.services.compute.model.Operation operationPb =
        new com.google.api.services.compute.model.Operation();
    if (generatedId != null) {
      operationPb.setId(new BigInteger(generatedId));
    }
    operationPb.setName(operationId.getOperation());
    operationPb.setClientOperationId(clientOperationId);
    switch (operationId.getType()) {
      case REGION:
        operationPb.setRegion(this.<RegionOperationId>getOperationId().getRegionId().getSelfLink());
        break;
      case ZONE:
        operationPb.setZone(this.<ZoneOperationId>getOperationId().getZoneId().getSelfLink());
        break;
    }
    if (operationType != null) {
      operationPb.setOperationType(operationType);
    }
    operationPb.setTargetLink(targetLink);
    if (targetId != null) {
      operationPb.setTargetId(new BigInteger(targetId));
    }
    if (status != null) {
      operationPb.setStatus(status.name());
    }
    operationPb.setStatusMessage(statusMessage);
    operationPb.setUser(user);
    operationPb.setProgress(progress);
    if (insertTime != null) {
      operationPb.setInsertTime(TIMESTAMP_FORMATTER.print(insertTime));
    }
    if (startTime != null) {
      operationPb.setStartTime(TIMESTAMP_FORMATTER.print(startTime));
    }
    if (endTime != null) {
      operationPb.setEndTime(TIMESTAMP_FORMATTER.print(endTime));
    }
    if (errors != null) {
      operationPb.setError(new com.google.api.services.compute.model.Operation.Error().setErrors(
          Lists.transform(errors, OperationError.TO_PB_FUNCTION)));
    }
    if (warnings != null) {
      operationPb.setWarnings(Lists.transform(warnings, OperationWarning.TO_PB_FUNCTION));
    }
    operationPb.setHttpErrorStatusCode(httpErrorStatusCode);
    operationPb.setHttpErrorMessage(httpErrorMessage);
    operationPb.setSelfLink(operationId.getSelfLink());
    operationPb.setDescription(description);
    return operationPb;
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    this.compute = options.service();
  }

  static Operation fromPb(Compute compute,
      com.google.api.services.compute.model.Operation operationPb) {
    return new Builder(compute, operationPb).build();
  }
}
