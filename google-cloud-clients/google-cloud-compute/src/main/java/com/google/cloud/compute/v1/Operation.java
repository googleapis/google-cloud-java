/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.httpjson.ApiMessage;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/**
 * Represents an Operation resource.
 *
 * <p>You can use an operation resource to manage asynchronous API requests. For more information,
 * read Handling API responses.
 *
 * <p>Operations can be global, regional or zonal. - For global operations, use the globalOperations
 * resource. - For regional operations, use the regionOperations resource. - For zonal operations,
 * use the zonalOperations resource.
 *
 * <p>For more information, read Global, Regional, and Zonal Resources. (== resource_for
 * v1.globalOperations ==) (== resource_for beta.globalOperations ==) (== resource_for
 * v1.regionOperations ==) (== resource_for beta.regionOperations ==) (== resource_for
 * v1.zoneOperations ==) (== resource_for beta.zoneOperations ==)
 */
public final class Operation implements ApiMessage {
  private final String clientOperationId;
  private final String creationTimestamp;
  private final String description;
  private final String endTime;
  private final Error error;
  private final String httpErrorMessage;
  private final Integer httpErrorStatusCode;
  private final String id;
  private final String insertTime;
  private final String kind;
  private final String name;
  private final String operationType;
  private final Integer progress;
  private final String region;
  private final String selfLink;
  private final String startTime;
  private final String status;
  private final String statusMessage;
  private final String targetId;
  private final String targetLink;
  private final String user;
  private final List<Warnings> warnings;
  private final String zone;

  private Operation() {
    this.clientOperationId = null;
    this.creationTimestamp = null;
    this.description = null;
    this.endTime = null;
    this.error = null;
    this.httpErrorMessage = null;
    this.httpErrorStatusCode = null;
    this.id = null;
    this.insertTime = null;
    this.kind = null;
    this.name = null;
    this.operationType = null;
    this.progress = null;
    this.region = null;
    this.selfLink = null;
    this.startTime = null;
    this.status = null;
    this.statusMessage = null;
    this.targetId = null;
    this.targetLink = null;
    this.user = null;
    this.warnings = null;
    this.zone = null;
  }

  private Operation(
      String clientOperationId,
      String creationTimestamp,
      String description,
      String endTime,
      Error error,
      String httpErrorMessage,
      Integer httpErrorStatusCode,
      String id,
      String insertTime,
      String kind,
      String name,
      String operationType,
      Integer progress,
      String region,
      String selfLink,
      String startTime,
      String status,
      String statusMessage,
      String targetId,
      String targetLink,
      String user,
      List<Warnings> warnings,
      String zone) {
    this.clientOperationId = clientOperationId;
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.endTime = endTime;
    this.error = error;
    this.httpErrorMessage = httpErrorMessage;
    this.httpErrorStatusCode = httpErrorStatusCode;
    this.id = id;
    this.insertTime = insertTime;
    this.kind = kind;
    this.name = name;
    this.operationType = operationType;
    this.progress = progress;
    this.region = region;
    this.selfLink = selfLink;
    this.startTime = startTime;
    this.status = status;
    this.statusMessage = statusMessage;
    this.targetId = targetId;
    this.targetLink = targetLink;
    this.user = user;
    this.warnings = warnings;
    this.zone = zone;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("clientOperationId".equals(fieldName)) {
      return clientOperationId;
    }
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("endTime".equals(fieldName)) {
      return endTime;
    }
    if ("error".equals(fieldName)) {
      return error;
    }
    if ("httpErrorMessage".equals(fieldName)) {
      return httpErrorMessage;
    }
    if ("httpErrorStatusCode".equals(fieldName)) {
      return httpErrorStatusCode;
    }
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("insertTime".equals(fieldName)) {
      return insertTime;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("operationType".equals(fieldName)) {
      return operationType;
    }
    if ("progress".equals(fieldName)) {
      return progress;
    }
    if ("region".equals(fieldName)) {
      return region;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("startTime".equals(fieldName)) {
      return startTime;
    }
    if ("status".equals(fieldName)) {
      return status;
    }
    if ("statusMessage".equals(fieldName)) {
      return statusMessage;
    }
    if ("targetId".equals(fieldName)) {
      return targetId;
    }
    if ("targetLink".equals(fieldName)) {
      return targetLink;
    }
    if ("user".equals(fieldName)) {
      return user;
    }
    if ("warnings".equals(fieldName)) {
      return warnings;
    }
    if ("zone".equals(fieldName)) {
      return zone;
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  @Nullable
  @Override
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  /**
   * [Output Only] The value of `requestId` if you provided it in the request. Not present
   * otherwise.
   */
  public String getClientOperationId() {
    return clientOperationId;
  }

  /** [Deprecated] This field is deprecated. */
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  /**
   * [Output Only] A textual description of the operation, which is set when the operation is
   * created.
   */
  public String getDescription() {
    return description;
  }

  /**
   * [Output Only] The time that this operation was completed. This value is in RFC3339 text format.
   */
  public String getEndTime() {
    return endTime;
  }

  /**
   * [Output Only] If errors are generated during processing of the operation, this field will be
   * populated.
   */
  public Error getError() {
    return error;
  }

  /**
   * [Output Only] If the operation fails, this field contains the HTTP error message that was
   * returned, such as NOT FOUND.
   */
  public String getHttpErrorMessage() {
    return httpErrorMessage;
  }

  /**
   * [Output Only] If the operation fails, this field contains the HTTP error status code that was
   * returned. For example, a 404 means the resource was not found.
   */
  public Integer getHttpErrorStatusCode() {
    return httpErrorStatusCode;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /**
   * [Output Only] The time that this operation was requested. This value is in RFC3339 text format.
   */
  public String getInsertTime() {
    return insertTime;
  }

  /** [Output Only] Type of the resource. Always compute#operation for Operation resources. */
  public String getKind() {
    return kind;
  }

  /** [Output Only] Name of the resource. */
  public String getName() {
    return name;
  }

  /** [Output Only] The type of operation, such as insert, update, or delete, and so on. */
  public String getOperationType() {
    return operationType;
  }

  /**
   * [Output Only] An optional progress indicator that ranges from 0 to 100. There is no requirement
   * that this be linear or support any granularity of operations. This should not be used to guess
   * when the operation will be complete. This number should monotonically increase as the operation
   * progresses.
   */
  public Integer getProgress() {
    return progress;
  }

  /**
   * [Output Only] The URL of the region where the operation resides. Only applicable when
   * performing regional operations.
   */
  public String getRegion() {
    return region;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * [Output Only] The time that this operation was started by the server. This value is in RFC3339
   * text format.
   */
  public String getStartTime() {
    return startTime;
  }

  /**
   * [Output Only] The status of the operation, which can be one of the following: PENDING, RUNNING,
   * or DONE.
   */
  public String getStatus() {
    return status;
  }

  /** [Output Only] An optional textual description of the current status of the operation. */
  public String getStatusMessage() {
    return statusMessage;
  }

  /**
   * [Output Only] The unique target ID, which identifies a specific incarnation of the target
   * resource.
   */
  public String getTargetId() {
    return targetId;
  }

  /**
   * [Output Only] The URL of the resource that the operation modifies. For operations related to
   * creating a snapshot, this points to the persistent disk that the snapshot was created from.
   */
  public String getTargetLink() {
    return targetLink;
  }

  /** [Output Only] User who requested the operation, for example: user{@literal @}example.com. */
  public String getUser() {
    return user;
  }

  /**
   * [Output Only] If warning messages are generated during processing of the operation, this field
   * will be populated.
   */
  public List<Warnings> getWarningsList() {
    return warnings;
  }

  /**
   * [Output Only] The URL of the zone where the operation resides. Only applicable when performing
   * per-zone operations.
   */
  public String getZone() {
    return zone;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Operation prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Operation getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Operation DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Operation();
  }

  public static class Builder {
    private String clientOperationId;
    private String creationTimestamp;
    private String description;
    private String endTime;
    private Error error;
    private String httpErrorMessage;
    private Integer httpErrorStatusCode;
    private String id;
    private String insertTime;
    private String kind;
    private String name;
    private String operationType;
    private Integer progress;
    private String region;
    private String selfLink;
    private String startTime;
    private String status;
    private String statusMessage;
    private String targetId;
    private String targetLink;
    private String user;
    private List<Warnings> warnings;
    private String zone;

    Builder() {}

    public Builder mergeFrom(Operation other) {
      if (other == Operation.getDefaultInstance()) return this;
      if (other.getClientOperationId() != null) {
        this.clientOperationId = other.clientOperationId;
      }
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getEndTime() != null) {
        this.endTime = other.endTime;
      }
      if (other.getError() != null) {
        this.error = other.error;
      }
      if (other.getHttpErrorMessage() != null) {
        this.httpErrorMessage = other.httpErrorMessage;
      }
      if (other.getHttpErrorStatusCode() != null) {
        this.httpErrorStatusCode = other.httpErrorStatusCode;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getInsertTime() != null) {
        this.insertTime = other.insertTime;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getOperationType() != null) {
        this.operationType = other.operationType;
      }
      if (other.getProgress() != null) {
        this.progress = other.progress;
      }
      if (other.getRegion() != null) {
        this.region = other.region;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getStartTime() != null) {
        this.startTime = other.startTime;
      }
      if (other.getStatus() != null) {
        this.status = other.status;
      }
      if (other.getStatusMessage() != null) {
        this.statusMessage = other.statusMessage;
      }
      if (other.getTargetId() != null) {
        this.targetId = other.targetId;
      }
      if (other.getTargetLink() != null) {
        this.targetLink = other.targetLink;
      }
      if (other.getUser() != null) {
        this.user = other.user;
      }
      if (other.getWarningsList() != null) {
        this.warnings = other.warnings;
      }
      if (other.getZone() != null) {
        this.zone = other.zone;
      }
      return this;
    }

    Builder(Operation source) {
      this.clientOperationId = source.clientOperationId;
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.endTime = source.endTime;
      this.error = source.error;
      this.httpErrorMessage = source.httpErrorMessage;
      this.httpErrorStatusCode = source.httpErrorStatusCode;
      this.id = source.id;
      this.insertTime = source.insertTime;
      this.kind = source.kind;
      this.name = source.name;
      this.operationType = source.operationType;
      this.progress = source.progress;
      this.region = source.region;
      this.selfLink = source.selfLink;
      this.startTime = source.startTime;
      this.status = source.status;
      this.statusMessage = source.statusMessage;
      this.targetId = source.targetId;
      this.targetLink = source.targetLink;
      this.user = source.user;
      this.warnings = source.warnings;
      this.zone = source.zone;
    }

    /**
     * [Output Only] The value of `requestId` if you provided it in the request. Not present
     * otherwise.
     */
    public String getClientOperationId() {
      return clientOperationId;
    }

    /**
     * [Output Only] The value of `requestId` if you provided it in the request. Not present
     * otherwise.
     */
    public Builder setClientOperationId(String clientOperationId) {
      this.clientOperationId = clientOperationId;
      return this;
    }

    /** [Deprecated] This field is deprecated. */
    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    /** [Deprecated] This field is deprecated. */
    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    /**
     * [Output Only] A textual description of the operation, which is set when the operation is
     * created.
     */
    public String getDescription() {
      return description;
    }

    /**
     * [Output Only] A textual description of the operation, which is set when the operation is
     * created.
     */
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    /**
     * [Output Only] The time that this operation was completed. This value is in RFC3339 text
     * format.
     */
    public String getEndTime() {
      return endTime;
    }

    /**
     * [Output Only] The time that this operation was completed. This value is in RFC3339 text
     * format.
     */
    public Builder setEndTime(String endTime) {
      this.endTime = endTime;
      return this;
    }

    /**
     * [Output Only] If errors are generated during processing of the operation, this field will be
     * populated.
     */
    public Error getError() {
      return error;
    }

    /**
     * [Output Only] If errors are generated during processing of the operation, this field will be
     * populated.
     */
    public Builder setError(Error error) {
      this.error = error;
      return this;
    }

    /**
     * [Output Only] If the operation fails, this field contains the HTTP error message that was
     * returned, such as NOT FOUND.
     */
    public String getHttpErrorMessage() {
      return httpErrorMessage;
    }

    /**
     * [Output Only] If the operation fails, this field contains the HTTP error message that was
     * returned, such as NOT FOUND.
     */
    public Builder setHttpErrorMessage(String httpErrorMessage) {
      this.httpErrorMessage = httpErrorMessage;
      return this;
    }

    /**
     * [Output Only] If the operation fails, this field contains the HTTP error status code that was
     * returned. For example, a 404 means the resource was not found.
     */
    public Integer getHttpErrorStatusCode() {
      return httpErrorStatusCode;
    }

    /**
     * [Output Only] If the operation fails, this field contains the HTTP error status code that was
     * returned. For example, a 404 means the resource was not found.
     */
    public Builder setHttpErrorStatusCode(Integer httpErrorStatusCode) {
      this.httpErrorStatusCode = httpErrorStatusCode;
      return this;
    }

    /**
     * [Output Only] The unique identifier for the resource. This identifier is defined by the
     * server.
     */
    public String getId() {
      return id;
    }

    /**
     * [Output Only] The unique identifier for the resource. This identifier is defined by the
     * server.
     */
    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    /**
     * [Output Only] The time that this operation was requested. This value is in RFC3339 text
     * format.
     */
    public String getInsertTime() {
      return insertTime;
    }

    /**
     * [Output Only] The time that this operation was requested. This value is in RFC3339 text
     * format.
     */
    public Builder setInsertTime(String insertTime) {
      this.insertTime = insertTime;
      return this;
    }

    /** [Output Only] Type of the resource. Always compute#operation for Operation resources. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of the resource. Always compute#operation for Operation resources. */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /** [Output Only] Name of the resource. */
    public String getName() {
      return name;
    }

    /** [Output Only] Name of the resource. */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /** [Output Only] The type of operation, such as insert, update, or delete, and so on. */
    public String getOperationType() {
      return operationType;
    }

    /** [Output Only] The type of operation, such as insert, update, or delete, and so on. */
    public Builder setOperationType(String operationType) {
      this.operationType = operationType;
      return this;
    }

    /**
     * [Output Only] An optional progress indicator that ranges from 0 to 100. There is no
     * requirement that this be linear or support any granularity of operations. This should not be
     * used to guess when the operation will be complete. This number should monotonically increase
     * as the operation progresses.
     */
    public Integer getProgress() {
      return progress;
    }

    /**
     * [Output Only] An optional progress indicator that ranges from 0 to 100. There is no
     * requirement that this be linear or support any granularity of operations. This should not be
     * used to guess when the operation will be complete. This number should monotonically increase
     * as the operation progresses.
     */
    public Builder setProgress(Integer progress) {
      this.progress = progress;
      return this;
    }

    /**
     * [Output Only] The URL of the region where the operation resides. Only applicable when
     * performing regional operations.
     */
    public String getRegion() {
      return region;
    }

    /**
     * [Output Only] The URL of the region where the operation resides. Only applicable when
     * performing regional operations.
     */
    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    /** [Output Only] Server-defined URL for the resource. */
    public String getSelfLink() {
      return selfLink;
    }

    /** [Output Only] Server-defined URL for the resource. */
    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    /**
     * [Output Only] The time that this operation was started by the server. This value is in
     * RFC3339 text format.
     */
    public String getStartTime() {
      return startTime;
    }

    /**
     * [Output Only] The time that this operation was started by the server. This value is in
     * RFC3339 text format.
     */
    public Builder setStartTime(String startTime) {
      this.startTime = startTime;
      return this;
    }

    /**
     * [Output Only] The status of the operation, which can be one of the following: PENDING,
     * RUNNING, or DONE.
     */
    public String getStatus() {
      return status;
    }

    /**
     * [Output Only] The status of the operation, which can be one of the following: PENDING,
     * RUNNING, or DONE.
     */
    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    /** [Output Only] An optional textual description of the current status of the operation. */
    public String getStatusMessage() {
      return statusMessage;
    }

    /** [Output Only] An optional textual description of the current status of the operation. */
    public Builder setStatusMessage(String statusMessage) {
      this.statusMessage = statusMessage;
      return this;
    }

    /**
     * [Output Only] The unique target ID, which identifies a specific incarnation of the target
     * resource.
     */
    public String getTargetId() {
      return targetId;
    }

    /**
     * [Output Only] The unique target ID, which identifies a specific incarnation of the target
     * resource.
     */
    public Builder setTargetId(String targetId) {
      this.targetId = targetId;
      return this;
    }

    /**
     * [Output Only] The URL of the resource that the operation modifies. For operations related to
     * creating a snapshot, this points to the persistent disk that the snapshot was created from.
     */
    public String getTargetLink() {
      return targetLink;
    }

    /**
     * [Output Only] The URL of the resource that the operation modifies. For operations related to
     * creating a snapshot, this points to the persistent disk that the snapshot was created from.
     */
    public Builder setTargetLink(String targetLink) {
      this.targetLink = targetLink;
      return this;
    }

    /** [Output Only] User who requested the operation, for example: user{@literal @}example.com. */
    public String getUser() {
      return user;
    }

    /** [Output Only] User who requested the operation, for example: user{@literal @}example.com. */
    public Builder setUser(String user) {
      this.user = user;
      return this;
    }

    /**
     * [Output Only] If warning messages are generated during processing of the operation, this
     * field will be populated.
     */
    public List<Warnings> getWarningsList() {
      return warnings;
    }

    /**
     * [Output Only] If warning messages are generated during processing of the operation, this
     * field will be populated.
     */
    public Builder addAllWarnings(List<Warnings> warnings) {
      if (this.warnings == null) {
        this.warnings = new LinkedList<>();
      }
      this.warnings.addAll(warnings);
      return this;
    }

    /**
     * [Output Only] If warning messages are generated during processing of the operation, this
     * field will be populated.
     */
    public Builder addWarnings(Warnings warnings) {
      if (this.warnings == null) {
        this.warnings = new LinkedList<>();
      }
      this.warnings.add(warnings);
      return this;
    }

    /**
     * [Output Only] The URL of the zone where the operation resides. Only applicable when
     * performing per-zone operations.
     */
    public String getZone() {
      return zone;
    }

    /**
     * [Output Only] The URL of the zone where the operation resides. Only applicable when
     * performing per-zone operations.
     */
    public Builder setZone(String zone) {
      this.zone = zone;
      return this;
    }

    public Operation build() {

      return new Operation(
          clientOperationId,
          creationTimestamp,
          description,
          endTime,
          error,
          httpErrorMessage,
          httpErrorStatusCode,
          id,
          insertTime,
          kind,
          name,
          operationType,
          progress,
          region,
          selfLink,
          startTime,
          status,
          statusMessage,
          targetId,
          targetLink,
          user,
          warnings,
          zone);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setClientOperationId(this.clientOperationId);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setEndTime(this.endTime);
      newBuilder.setError(this.error);
      newBuilder.setHttpErrorMessage(this.httpErrorMessage);
      newBuilder.setHttpErrorStatusCode(this.httpErrorStatusCode);
      newBuilder.setId(this.id);
      newBuilder.setInsertTime(this.insertTime);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setOperationType(this.operationType);
      newBuilder.setProgress(this.progress);
      newBuilder.setRegion(this.region);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setStartTime(this.startTime);
      newBuilder.setStatus(this.status);
      newBuilder.setStatusMessage(this.statusMessage);
      newBuilder.setTargetId(this.targetId);
      newBuilder.setTargetLink(this.targetLink);
      newBuilder.setUser(this.user);
      newBuilder.addAllWarnings(this.warnings);
      newBuilder.setZone(this.zone);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Operation{"
        + "clientOperationId="
        + clientOperationId
        + ", "
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "endTime="
        + endTime
        + ", "
        + "error="
        + error
        + ", "
        + "httpErrorMessage="
        + httpErrorMessage
        + ", "
        + "httpErrorStatusCode="
        + httpErrorStatusCode
        + ", "
        + "id="
        + id
        + ", "
        + "insertTime="
        + insertTime
        + ", "
        + "kind="
        + kind
        + ", "
        + "name="
        + name
        + ", "
        + "operationType="
        + operationType
        + ", "
        + "progress="
        + progress
        + ", "
        + "region="
        + region
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "startTime="
        + startTime
        + ", "
        + "status="
        + status
        + ", "
        + "statusMessage="
        + statusMessage
        + ", "
        + "targetId="
        + targetId
        + ", "
        + "targetLink="
        + targetLink
        + ", "
        + "user="
        + user
        + ", "
        + "warnings="
        + warnings
        + ", "
        + "zone="
        + zone
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Operation) {
      Operation that = (Operation) o;
      return Objects.equals(this.clientOperationId, that.getClientOperationId())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.endTime, that.getEndTime())
          && Objects.equals(this.error, that.getError())
          && Objects.equals(this.httpErrorMessage, that.getHttpErrorMessage())
          && Objects.equals(this.httpErrorStatusCode, that.getHttpErrorStatusCode())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.insertTime, that.getInsertTime())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.operationType, that.getOperationType())
          && Objects.equals(this.progress, that.getProgress())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.startTime, that.getStartTime())
          && Objects.equals(this.status, that.getStatus())
          && Objects.equals(this.statusMessage, that.getStatusMessage())
          && Objects.equals(this.targetId, that.getTargetId())
          && Objects.equals(this.targetLink, that.getTargetLink())
          && Objects.equals(this.user, that.getUser())
          && Objects.equals(this.warnings, that.getWarningsList())
          && Objects.equals(this.zone, that.getZone());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        clientOperationId,
        creationTimestamp,
        description,
        endTime,
        error,
        httpErrorMessage,
        httpErrorStatusCode,
        id,
        insertTime,
        kind,
        name,
        operationType,
        progress,
        region,
        selfLink,
        startTime,
        status,
        statusMessage,
        targetId,
        targetLink,
        user,
        warnings,
        zone);
  }
}
