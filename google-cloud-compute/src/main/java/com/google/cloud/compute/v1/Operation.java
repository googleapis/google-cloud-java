/*
 * Copyright 2018 Google LLC
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
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
      String zone
      ) {
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
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("clientOperationId") && clientOperationId != null) {
      fieldMap.put("clientOperationId", Collections.singletonList(String.valueOf(clientOperationId)));
    }
    if (fieldNames.contains("creationTimestamp") && creationTimestamp != null) {
      fieldMap.put("creationTimestamp", Collections.singletonList(String.valueOf(creationTimestamp)));
    }
    if (fieldNames.contains("description") && description != null) {
      fieldMap.put("description", Collections.singletonList(String.valueOf(description)));
    }
    if (fieldNames.contains("endTime") && endTime != null) {
      fieldMap.put("endTime", Collections.singletonList(String.valueOf(endTime)));
    }
    if (fieldNames.contains("error") && error != null) {
      fieldMap.put("error", Collections.singletonList(String.valueOf(error)));
    }
    if (fieldNames.contains("httpErrorMessage") && httpErrorMessage != null) {
      fieldMap.put("httpErrorMessage", Collections.singletonList(String.valueOf(httpErrorMessage)));
    }
    if (fieldNames.contains("httpErrorStatusCode") && httpErrorStatusCode != null) {
      fieldMap.put("httpErrorStatusCode", Collections.singletonList(String.valueOf(httpErrorStatusCode)));
    }
    if (fieldNames.contains("id") && id != null) {
      fieldMap.put("id", Collections.singletonList(String.valueOf(id)));
    }
    if (fieldNames.contains("insertTime") && insertTime != null) {
      fieldMap.put("insertTime", Collections.singletonList(String.valueOf(insertTime)));
    }
    if (fieldNames.contains("kind") && kind != null) {
      fieldMap.put("kind", Collections.singletonList(String.valueOf(kind)));
    }
    if (fieldNames.contains("name") && name != null) {
      fieldMap.put("name", Collections.singletonList(String.valueOf(name)));
    }
    if (fieldNames.contains("operationType") && operationType != null) {
      fieldMap.put("operationType", Collections.singletonList(String.valueOf(operationType)));
    }
    if (fieldNames.contains("progress") && progress != null) {
      fieldMap.put("progress", Collections.singletonList(String.valueOf(progress)));
    }
    if (fieldNames.contains("region") && region != null) {
      fieldMap.put("region", Collections.singletonList(String.valueOf(region)));
    }
    if (fieldNames.contains("selfLink") && selfLink != null) {
      fieldMap.put("selfLink", Collections.singletonList(String.valueOf(selfLink)));
    }
    if (fieldNames.contains("startTime") && startTime != null) {
      fieldMap.put("startTime", Collections.singletonList(String.valueOf(startTime)));
    }
    if (fieldNames.contains("status") && status != null) {
      fieldMap.put("status", Collections.singletonList(String.valueOf(status)));
    }
    if (fieldNames.contains("statusMessage") && statusMessage != null) {
      fieldMap.put("statusMessage", Collections.singletonList(String.valueOf(statusMessage)));
    }
    if (fieldNames.contains("targetId") && targetId != null) {
      fieldMap.put("targetId", Collections.singletonList(String.valueOf(targetId)));
    }
    if (fieldNames.contains("targetLink") && targetLink != null) {
      fieldMap.put("targetLink", Collections.singletonList(String.valueOf(targetLink)));
    }
    if (fieldNames.contains("user") && user != null) {
      fieldMap.put("user", Collections.singletonList(String.valueOf(user)));
    }
    if (fieldNames.contains("warnings") && warnings != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (Warnings item : warnings) {
        stringList.add(item.toString());
      }
      fieldMap.put("warnings", stringList.build());
    }
    if (fieldNames.contains("zone") && zone != null) {
      fieldMap.put("zone", Collections.singletonList(String.valueOf(zone)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("clientOperationId")) {
      return String.valueOf(clientOperationId);
    }
    if (fieldName.equals("creationTimestamp")) {
      return String.valueOf(creationTimestamp);
    }
    if (fieldName.equals("description")) {
      return String.valueOf(description);
    }
    if (fieldName.equals("endTime")) {
      return String.valueOf(endTime);
    }
    if (fieldName.equals("error")) {
      return String.valueOf(error);
    }
    if (fieldName.equals("httpErrorMessage")) {
      return String.valueOf(httpErrorMessage);
    }
    if (fieldName.equals("httpErrorStatusCode")) {
      return String.valueOf(httpErrorStatusCode);
    }
    if (fieldName.equals("id")) {
      return String.valueOf(id);
    }
    if (fieldName.equals("insertTime")) {
      return String.valueOf(insertTime);
    }
    if (fieldName.equals("kind")) {
      return String.valueOf(kind);
    }
    if (fieldName.equals("name")) {
      return String.valueOf(name);
    }
    if (fieldName.equals("operationType")) {
      return String.valueOf(operationType);
    }
    if (fieldName.equals("progress")) {
      return String.valueOf(progress);
    }
    if (fieldName.equals("region")) {
      return String.valueOf(region);
    }
    if (fieldName.equals("selfLink")) {
      return String.valueOf(selfLink);
    }
    if (fieldName.equals("startTime")) {
      return String.valueOf(startTime);
    }
    if (fieldName.equals("status")) {
      return String.valueOf(status);
    }
    if (fieldName.equals("statusMessage")) {
      return String.valueOf(statusMessage);
    }
    if (fieldName.equals("targetId")) {
      return String.valueOf(targetId);
    }
    if (fieldName.equals("targetLink")) {
      return String.valueOf(targetLink);
    }
    if (fieldName.equals("user")) {
      return String.valueOf(user);
    }
    if (fieldName.equals("warnings")) {
      return String.valueOf(warnings);
    }
    if (fieldName.equals("zone")) {
      return String.valueOf(zone);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  public String getClientOperationId() {
    return clientOperationId;
  }

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public String getDescription() {
    return description;
  }

  public String getEndTime() {
    return endTime;
  }

  public Error getError() {
    return error;
  }

  public String getHttpErrorMessage() {
    return httpErrorMessage;
  }

  public Integer getHttpErrorStatusCode() {
    return httpErrorStatusCode;
  }

  public String getId() {
    return id;
  }

  public String getInsertTime() {
    return insertTime;
  }

  public String getKind() {
    return kind;
  }

  public String getName() {
    return name;
  }

  public String getOperationType() {
    return operationType;
  }

  public Integer getProgress() {
    return progress;
  }

  public String getRegion() {
    return region;
  }

  public String getSelfLink() {
    return selfLink;
  }

  public String getStartTime() {
    return startTime;
  }

  public String getStatus() {
    return status;
  }

  public String getStatusMessage() {
    return statusMessage;
  }

  public String getTargetId() {
    return targetId;
  }

  public String getTargetLink() {
    return targetLink;
  }

  public String getUser() {
    return user;
  }

  public List<Warnings> getWarningsList() {
    return warnings;
  }

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
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
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

    public String getClientOperationId() {
      return clientOperationId;
    }

    public Builder setClientOperationId(String clientOperationId) {
      this.clientOperationId = clientOperationId;
      return this;
    }

    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public String getEndTime() {
      return endTime;
    }

    public Builder setEndTime(String endTime) {
      this.endTime = endTime;
      return this;
    }

    public Error getError() {
      return error;
    }

    public Builder setError(Error error) {
      this.error = error;
      return this;
    }

    public String getHttpErrorMessage() {
      return httpErrorMessage;
    }

    public Builder setHttpErrorMessage(String httpErrorMessage) {
      this.httpErrorMessage = httpErrorMessage;
      return this;
    }

    public Integer getHttpErrorStatusCode() {
      return httpErrorStatusCode;
    }

    public Builder setHttpErrorStatusCode(Integer httpErrorStatusCode) {
      this.httpErrorStatusCode = httpErrorStatusCode;
      return this;
    }

    public String getId() {
      return id;
    }

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public String getInsertTime() {
      return insertTime;
    }

    public Builder setInsertTime(String insertTime) {
      this.insertTime = insertTime;
      return this;
    }

    public String getKind() {
      return kind;
    }

    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public String getOperationType() {
      return operationType;
    }

    public Builder setOperationType(String operationType) {
      this.operationType = operationType;
      return this;
    }

    public Integer getProgress() {
      return progress;
    }

    public Builder setProgress(Integer progress) {
      this.progress = progress;
      return this;
    }

    public String getRegion() {
      return region;
    }

    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public String getStartTime() {
      return startTime;
    }

    public Builder setStartTime(String startTime) {
      this.startTime = startTime;
      return this;
    }

    public String getStatus() {
      return status;
    }

    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    public String getStatusMessage() {
      return statusMessage;
    }

    public Builder setStatusMessage(String statusMessage) {
      this.statusMessage = statusMessage;
      return this;
    }

    public String getTargetId() {
      return targetId;
    }

    public Builder setTargetId(String targetId) {
      this.targetId = targetId;
      return this;
    }

    public String getTargetLink() {
      return targetLink;
    }

    public Builder setTargetLink(String targetLink) {
      this.targetLink = targetLink;
      return this;
    }

    public String getUser() {
      return user;
    }

    public Builder setUser(String user) {
      this.user = user;
      return this;
    }

    public List<Warnings> getWarningsList() {
      return warnings;
    }

    public Builder addAllWarnings(List<Warnings> warnings) {
      if (this.warnings == null) {
        this.warnings = new ArrayList<>(warnings.size());
      }
      this.warnings.addAll(warnings);
      return this;
    }

    public Builder addWarnings(Warnings warnings) {
      this.warnings.add(warnings);
      return this;
    }

    public String getZone() {
      return zone;
    }

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
        zone
      );
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
        + "clientOperationId=" + clientOperationId + ", "
        + "creationTimestamp=" + creationTimestamp + ", "
        + "description=" + description + ", "
        + "endTime=" + endTime + ", "
        + "error=" + error + ", "
        + "httpErrorMessage=" + httpErrorMessage + ", "
        + "httpErrorStatusCode=" + httpErrorStatusCode + ", "
        + "id=" + id + ", "
        + "insertTime=" + insertTime + ", "
        + "kind=" + kind + ", "
        + "name=" + name + ", "
        + "operationType=" + operationType + ", "
        + "progress=" + progress + ", "
        + "region=" + region + ", "
        + "selfLink=" + selfLink + ", "
        + "startTime=" + startTime + ", "
        + "status=" + status + ", "
        + "statusMessage=" + statusMessage + ", "
        + "targetId=" + targetId + ", "
        + "targetLink=" + targetLink + ", "
        + "user=" + user + ", "
        + "warnings=" + warnings + ", "
        + "zone=" + zone
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Operation) {
      Operation that = (Operation) o;
      return
          Objects.equals(this.clientOperationId, that.getClientOperationId()) &&
          Objects.equals(this.creationTimestamp, that.getCreationTimestamp()) &&
          Objects.equals(this.description, that.getDescription()) &&
          Objects.equals(this.endTime, that.getEndTime()) &&
          Objects.equals(this.error, that.getError()) &&
          Objects.equals(this.httpErrorMessage, that.getHttpErrorMessage()) &&
          Objects.equals(this.httpErrorStatusCode, that.getHttpErrorStatusCode()) &&
          Objects.equals(this.id, that.getId()) &&
          Objects.equals(this.insertTime, that.getInsertTime()) &&
          Objects.equals(this.kind, that.getKind()) &&
          Objects.equals(this.name, that.getName()) &&
          Objects.equals(this.operationType, that.getOperationType()) &&
          Objects.equals(this.progress, that.getProgress()) &&
          Objects.equals(this.region, that.getRegion()) &&
          Objects.equals(this.selfLink, that.getSelfLink()) &&
          Objects.equals(this.startTime, that.getStartTime()) &&
          Objects.equals(this.status, that.getStatus()) &&
          Objects.equals(this.statusMessage, that.getStatusMessage()) &&
          Objects.equals(this.targetId, that.getTargetId()) &&
          Objects.equals(this.targetLink, that.getTargetLink()) &&
          Objects.equals(this.user, that.getUser()) &&
          Objects.equals(this.warnings, that.getWarningsList()) &&
          Objects.equals(this.zone, that.getZone())
          ;
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
      zone
    );
  }
}
