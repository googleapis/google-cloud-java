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
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class InterconnectDiagnosticsLinkLACPStatus implements ApiMessage {
  private final String googleSystemId;
  private final String neighborSystemId;
  private final String state;

  private InterconnectDiagnosticsLinkLACPStatus() {
    this.googleSystemId = null;
    this.neighborSystemId = null;
    this.state = null;
  }

  private InterconnectDiagnosticsLinkLACPStatus(
      String googleSystemId, String neighborSystemId, String state) {
    this.googleSystemId = googleSystemId;
    this.neighborSystemId = neighborSystemId;
    this.state = state;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("googleSystemId".equals(fieldName)) {
      return googleSystemId;
    }
    if ("neighborSystemId".equals(fieldName)) {
      return neighborSystemId;
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
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  /** System ID of the port on Google?s side of the LACP exchange. */
  public String getGoogleSystemId() {
    return googleSystemId;
  }

  /** System ID of the port on the neighbor?s side of the LACP exchange. */
  public String getNeighborSystemId() {
    return neighborSystemId;
  }

  public String getState() {
    return state;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(InterconnectDiagnosticsLinkLACPStatus prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static InterconnectDiagnosticsLinkLACPStatus getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final InterconnectDiagnosticsLinkLACPStatus DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new InterconnectDiagnosticsLinkLACPStatus();
  }

  public static class Builder {
    private String googleSystemId;
    private String neighborSystemId;
    private String state;

    Builder() {}

    public Builder mergeFrom(InterconnectDiagnosticsLinkLACPStatus other) {
      if (other == InterconnectDiagnosticsLinkLACPStatus.getDefaultInstance()) return this;
      if (other.getGoogleSystemId() != null) {
        this.googleSystemId = other.googleSystemId;
      }
      if (other.getNeighborSystemId() != null) {
        this.neighborSystemId = other.neighborSystemId;
      }
      if (other.getState() != null) {
        this.state = other.state;
      }
      return this;
    }

    Builder(InterconnectDiagnosticsLinkLACPStatus source) {
      this.googleSystemId = source.googleSystemId;
      this.neighborSystemId = source.neighborSystemId;
      this.state = source.state;
    }

    /** System ID of the port on Google?s side of the LACP exchange. */
    public String getGoogleSystemId() {
      return googleSystemId;
    }

    /** System ID of the port on Google?s side of the LACP exchange. */
    public Builder setGoogleSystemId(String googleSystemId) {
      this.googleSystemId = googleSystemId;
      return this;
    }

    /** System ID of the port on the neighbor?s side of the LACP exchange. */
    public String getNeighborSystemId() {
      return neighborSystemId;
    }

    /** System ID of the port on the neighbor?s side of the LACP exchange. */
    public Builder setNeighborSystemId(String neighborSystemId) {
      this.neighborSystemId = neighborSystemId;
      return this;
    }

    public String getState() {
      return state;
    }

    public Builder setState(String state) {
      this.state = state;
      return this;
    }

    public InterconnectDiagnosticsLinkLACPStatus build() {

      return new InterconnectDiagnosticsLinkLACPStatus(googleSystemId, neighborSystemId, state);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setGoogleSystemId(this.googleSystemId);
      newBuilder.setNeighborSystemId(this.neighborSystemId);
      newBuilder.setState(this.state);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "InterconnectDiagnosticsLinkLACPStatus{"
        + "googleSystemId="
        + googleSystemId
        + ", "
        + "neighborSystemId="
        + neighborSystemId
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
    if (o instanceof InterconnectDiagnosticsLinkLACPStatus) {
      InterconnectDiagnosticsLinkLACPStatus that = (InterconnectDiagnosticsLinkLACPStatus) o;
      return Objects.equals(this.googleSystemId, that.getGoogleSystemId())
          && Objects.equals(this.neighborSystemId, that.getNeighborSystemId())
          && Objects.equals(this.state, that.getState());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(googleSystemId, neighborSystemId, state);
  }
}
