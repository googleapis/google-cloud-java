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
public final class InterconnectOutageNotification implements ApiMessage {
  private final List<String> affectedCircuits;
  private final String description;
  private final String endTime;
  private final String issueType;
  private final String name;
  private final String source;
  private final String startTime;
  private final String state;

  private InterconnectOutageNotification() {
    this.affectedCircuits = null;
    this.description = null;
    this.endTime = null;
    this.issueType = null;
    this.name = null;
    this.source = null;
    this.startTime = null;
    this.state = null;
  }

  private InterconnectOutageNotification(
      List<String> affectedCircuits,
      String description,
      String endTime,
      String issueType,
      String name,
      String source,
      String startTime,
      String state) {
    this.affectedCircuits = affectedCircuits;
    this.description = description;
    this.endTime = endTime;
    this.issueType = issueType;
    this.name = name;
    this.source = source;
    this.startTime = startTime;
    this.state = state;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("affectedCircuits".equals(fieldName)) {
      return affectedCircuits;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("endTime".equals(fieldName)) {
      return endTime;
    }
    if ("issueType".equals(fieldName)) {
      return issueType;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("source".equals(fieldName)) {
      return source;
    }
    if ("startTime".equals(fieldName)) {
      return startTime;
    }
    if ("state".equals(fieldName)) {
      return state;
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
  public List<String> getFieldMask() {
    return null;
  }

  public List<String> getAffectedCircuitsList() {
    return affectedCircuits;
  }

  public String getDescription() {
    return description;
  }

  public String getEndTime() {
    return endTime;
  }

  public String getIssueType() {
    return issueType;
  }

  public String getName() {
    return name;
  }

  public String getSource() {
    return source;
  }

  public String getStartTime() {
    return startTime;
  }

  public String getState() {
    return state;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InterconnectOutageNotification prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InterconnectOutageNotification getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InterconnectOutageNotification DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InterconnectOutageNotification();
  }

  public static class Builder {
    private List<String> affectedCircuits;
    private String description;
    private String endTime;
    private String issueType;
    private String name;
    private String source;
    private String startTime;
    private String state;

    Builder() {}

    public Builder mergeFrom(InterconnectOutageNotification other) {
      if (other == InterconnectOutageNotification.getDefaultInstance()) return this;
      if (other.getAffectedCircuitsList() != null) {
        this.affectedCircuits = other.affectedCircuits;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getEndTime() != null) {
        this.endTime = other.endTime;
      }
      if (other.getIssueType() != null) {
        this.issueType = other.issueType;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getSource() != null) {
        this.source = other.source;
      }
      if (other.getStartTime() != null) {
        this.startTime = other.startTime;
      }
      if (other.getState() != null) {
        this.state = other.state;
      }
      return this;
    }

    Builder(InterconnectOutageNotification source) {
      this.affectedCircuits = source.affectedCircuits;
      this.description = source.description;
      this.endTime = source.endTime;
      this.issueType = source.issueType;
      this.name = source.name;
      this.source = source.source;
      this.startTime = source.startTime;
      this.state = source.state;
    }

    public List<String> getAffectedCircuitsList() {
      return affectedCircuits;
    }

    public Builder addAllAffectedCircuits(List<String> affectedCircuits) {
      if (this.affectedCircuits == null) {
        this.affectedCircuits = new LinkedList<>();
      }
      this.affectedCircuits.addAll(affectedCircuits);
      return this;
    }

    public Builder addAffectedCircuits(String affectedCircuits) {
      if (this.affectedCircuits == null) {
        this.affectedCircuits = new LinkedList<>();
      }
      this.affectedCircuits.add(affectedCircuits);
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

    public String getIssueType() {
      return issueType;
    }

    public Builder setIssueType(String issueType) {
      this.issueType = issueType;
      return this;
    }

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public String getSource() {
      return source;
    }

    public Builder setSource(String source) {
      this.source = source;
      return this;
    }

    public String getStartTime() {
      return startTime;
    }

    public Builder setStartTime(String startTime) {
      this.startTime = startTime;
      return this;
    }

    public String getState() {
      return state;
    }

    public Builder setState(String state) {
      this.state = state;
      return this;
    }

    public InterconnectOutageNotification build() {

      return new InterconnectOutageNotification(
          affectedCircuits, description, endTime, issueType, name, source, startTime, state);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllAffectedCircuits(this.affectedCircuits);
      newBuilder.setDescription(this.description);
      newBuilder.setEndTime(this.endTime);
      newBuilder.setIssueType(this.issueType);
      newBuilder.setName(this.name);
      newBuilder.setSource(this.source);
      newBuilder.setStartTime(this.startTime);
      newBuilder.setState(this.state);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InterconnectOutageNotification{"
        + "affectedCircuits="
        + affectedCircuits
        + ", "
        + "description="
        + description
        + ", "
        + "endTime="
        + endTime
        + ", "
        + "issueType="
        + issueType
        + ", "
        + "name="
        + name
        + ", "
        + "source="
        + source
        + ", "
        + "startTime="
        + startTime
        + ", "
        + "state="
        + state
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof InterconnectOutageNotification) {
      InterconnectOutageNotification that = (InterconnectOutageNotification) o;
      return Objects.equals(this.affectedCircuits, that.getAffectedCircuitsList())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.endTime, that.getEndTime())
          && Objects.equals(this.issueType, that.getIssueType())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.source, that.getSource())
          && Objects.equals(this.startTime, that.getStartTime())
          && Objects.equals(this.state, that.getState());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        affectedCircuits, description, endTime, issueType, name, source, startTime, state);
  }
}
