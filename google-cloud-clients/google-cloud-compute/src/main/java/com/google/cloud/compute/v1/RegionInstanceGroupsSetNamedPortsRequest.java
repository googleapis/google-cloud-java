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
    if (fieldName.equals("fingerprint")) {
      return fingerprint;
    }
    if (fieldName.equals("namedPorts")) {
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
  public List<String> getFieldMask() {
    return null;
  }

  public String getFingerprint() {
    return fingerprint;
  }

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

    public String getFingerprint() {
      return fingerprint;
    }

    public Builder setFingerprint(String fingerprint) {
      this.fingerprint = fingerprint;
      return this;
    }

    public List<NamedPort> getNamedPortsList() {
      return namedPorts;
    }

    public Builder addAllNamedPorts(List<NamedPort> namedPorts) {
      if (this.namedPorts == null) {
        this.namedPorts = new LinkedList<>();
      }
      this.namedPorts.addAll(namedPorts);
      return this;
    }

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
