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
public final class RegionInstanceGroupsSetNamedPortsRequest implements ApiMessage {
  private final String fingerprint;
  private final List<NamedPort> namedPorts;

  private RegionInstanceGroupsSetNamedPortsRequest() {
    this.fingerprint = null;
    this.namedPorts = null;
  }

  private RegionInstanceGroupsSetNamedPortsRequest(String fingerprint, List<NamedPort> namedPorts) {
    this.fingerprint = fingerprint;
    this.namedPorts = namedPorts;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("fingerprint".equals(fieldName)) {
      return fingerprint;
    }
    if ("namedPorts".equals(fieldName)) {
      return namedPorts;
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
   * The fingerprint of the named ports information for this instance group. Use this optional
   * property to prevent conflicts when multiple users change the named ports settings concurrently.
   * Obtain the fingerprint with the instanceGroups.get method. Then, include the fingerprint in
   * your request to ensure that you do not overwrite changes that were applied from another
   * concurrent request.
   */
  public String getFingerprint() {
    return fingerprint;
  }

  /** The list of named ports to set for this instance group. */
  public List<NamedPort> getNamedPortsList() {
    return namedPorts;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(RegionInstanceGroupsSetNamedPortsRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static RegionInstanceGroupsSetNamedPortsRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final RegionInstanceGroupsSetNamedPortsRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new RegionInstanceGroupsSetNamedPortsRequest();
  }

  public static class Builder {
    private String fingerprint;
    private List<NamedPort> namedPorts;

    Builder() {}

    public Builder mergeFrom(RegionInstanceGroupsSetNamedPortsRequest other) {
      if (other == RegionInstanceGroupsSetNamedPortsRequest.getDefaultInstance()) return this;
      if (other.getFingerprint() != null) {
        this.fingerprint = other.fingerprint;
      }
      if (other.getNamedPortsList() != null) {
        this.namedPorts = other.namedPorts;
      }
      return this;
    }

    Builder(RegionInstanceGroupsSetNamedPortsRequest source) {
      this.fingerprint = source.fingerprint;
      this.namedPorts = source.namedPorts;
    }

    /**
     * The fingerprint of the named ports information for this instance group. Use this optional
     * property to prevent conflicts when multiple users change the named ports settings
     * concurrently. Obtain the fingerprint with the instanceGroups.get method. Then, include the
     * fingerprint in your request to ensure that you do not overwrite changes that were applied
     * from another concurrent request.
     */
    public String getFingerprint() {
      return fingerprint;
    }

    /**
     * The fingerprint of the named ports information for this instance group. Use this optional
     * property to prevent conflicts when multiple users change the named ports settings
     * concurrently. Obtain the fingerprint with the instanceGroups.get method. Then, include the
     * fingerprint in your request to ensure that you do not overwrite changes that were applied
     * from another concurrent request.
     */
    public Builder setFingerprint(String fingerprint) {
      this.fingerprint = fingerprint;
      return this;
    }

    /** The list of named ports to set for this instance group. */
    public List<NamedPort> getNamedPortsList() {
      return namedPorts;
    }

    /** The list of named ports to set for this instance group. */
    public Builder addAllNamedPorts(List<NamedPort> namedPorts) {
      if (this.namedPorts == null) {
        this.namedPorts = new LinkedList<>();
      }
      this.namedPorts.addAll(namedPorts);
      return this;
    }

    /** The list of named ports to set for this instance group. */
    public Builder addNamedPorts(NamedPort namedPorts) {
      if (this.namedPorts == null) {
        this.namedPorts = new LinkedList<>();
      }
      this.namedPorts.add(namedPorts);
      return this;
    }

    public RegionInstanceGroupsSetNamedPortsRequest build() {

      return new RegionInstanceGroupsSetNamedPortsRequest(fingerprint, namedPorts);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setFingerprint(this.fingerprint);
      newBuilder.addAllNamedPorts(this.namedPorts);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "RegionInstanceGroupsSetNamedPortsRequest{"
        + "fingerprint="
        + fingerprint
        + ", "
        + "namedPorts="
        + namedPorts
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RegionInstanceGroupsSetNamedPortsRequest) {
      RegionInstanceGroupsSetNamedPortsRequest that = (RegionInstanceGroupsSetNamedPortsRequest) o;
      return Objects.equals(this.fingerprint, that.getFingerprint())
          && Objects.equals(this.namedPorts, that.getNamedPortsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(fingerprint, namedPorts);
  }
}
