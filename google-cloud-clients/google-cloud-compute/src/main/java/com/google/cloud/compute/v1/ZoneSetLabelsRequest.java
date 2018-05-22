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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class ZoneSetLabelsRequest implements ApiMessage {
  private final String labelFingerprint;
  private final Map<String, String> labels;

  private ZoneSetLabelsRequest() {
    this.labelFingerprint = null;
    this.labels = null;
  }

  private ZoneSetLabelsRequest(String labelFingerprint, Map<String, String> labels) {
    this.labelFingerprint = labelFingerprint;
    this.labels = labels;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("labelFingerprint")) {
      return labelFingerprint;
    }
    if (fieldName.equals("labels")) {
      return labels;
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

  public String getLabelFingerprint() {
    return labelFingerprint;
  }

  public Map<String, String> getLabelsMap() {
    return labels;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ZoneSetLabelsRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ZoneSetLabelsRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ZoneSetLabelsRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ZoneSetLabelsRequest();
  }

  public static class Builder {
    private String labelFingerprint;
    private Map<String, String> labels;

    Builder() {}

    public Builder mergeFrom(ZoneSetLabelsRequest other) {
      if (other == ZoneSetLabelsRequest.getDefaultInstance()) return this;
      if (other.getLabelFingerprint() != null) {
        this.labelFingerprint = other.labelFingerprint;
      }
      if (other.getLabelsMap() != null) {
        this.labels = other.labels;
      }
      return this;
    }

    Builder(ZoneSetLabelsRequest source) {
      this.labelFingerprint = source.labelFingerprint;
      this.labels = source.labels;
    }

    public String getLabelFingerprint() {
      return labelFingerprint;
    }

    public Builder setLabelFingerprint(String labelFingerprint) {
      this.labelFingerprint = labelFingerprint;
      return this;
    }

    public Map<String, String> getLabelsMap() {
      return labels;
    }

    public Builder putAllLabels(Map<String, String> labels) {
      this.labels = labels;
      return this;
    }

    public ZoneSetLabelsRequest build() {

      return new ZoneSetLabelsRequest(labelFingerprint, labels);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setLabelFingerprint(this.labelFingerprint);
      newBuilder.putAllLabels(this.labels);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ZoneSetLabelsRequest{"
        + "labelFingerprint="
        + labelFingerprint
        + ", "
        + "labels="
        + labels
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ZoneSetLabelsRequest) {
      ZoneSetLabelsRequest that = (ZoneSetLabelsRequest) o;
      return Objects.equals(this.labelFingerprint, that.getLabelFingerprint())
          && Objects.equals(this.labels, that.getLabelsMap());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(labelFingerprint, labels);
  }
}
