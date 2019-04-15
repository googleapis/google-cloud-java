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
public final class NetworkEndpointGroupsScopedList implements ApiMessage {
  private final List<NetworkEndpointGroup> networkEndpointGroups;
  private final Warning warning;

  private NetworkEndpointGroupsScopedList() {
    this.networkEndpointGroups = null;
    this.warning = null;
  }

  private NetworkEndpointGroupsScopedList(
      List<NetworkEndpointGroup> networkEndpointGroups, Warning warning) {
    this.networkEndpointGroups = networkEndpointGroups;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("networkEndpointGroups".equals(fieldName)) {
      return networkEndpointGroups;
    }
    if ("warning".equals(fieldName)) {
      return warning;
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

  /** [Output Only] The list of network endpoint groups that are contained in this scope. */
  public List<NetworkEndpointGroup> getNetworkEndpointGroupsList() {
    return networkEndpointGroups;
  }

  /**
   * [Output Only] An informational warning that replaces the list of network endpoint groups when
   * the list is empty.
   */
  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NetworkEndpointGroupsScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NetworkEndpointGroupsScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NetworkEndpointGroupsScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NetworkEndpointGroupsScopedList();
  }

  public static class Builder {
    private List<NetworkEndpointGroup> networkEndpointGroups;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(NetworkEndpointGroupsScopedList other) {
      if (other == NetworkEndpointGroupsScopedList.getDefaultInstance()) return this;
      if (other.getNetworkEndpointGroupsList() != null) {
        this.networkEndpointGroups = other.networkEndpointGroups;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(NetworkEndpointGroupsScopedList source) {
      this.networkEndpointGroups = source.networkEndpointGroups;
      this.warning = source.warning;
    }

    /** [Output Only] The list of network endpoint groups that are contained in this scope. */
    public List<NetworkEndpointGroup> getNetworkEndpointGroupsList() {
      return networkEndpointGroups;
    }

    /** [Output Only] The list of network endpoint groups that are contained in this scope. */
    public Builder addAllNetworkEndpointGroups(List<NetworkEndpointGroup> networkEndpointGroups) {
      if (this.networkEndpointGroups == null) {
        this.networkEndpointGroups = new LinkedList<>();
      }
      this.networkEndpointGroups.addAll(networkEndpointGroups);
      return this;
    }

    /** [Output Only] The list of network endpoint groups that are contained in this scope. */
    public Builder addNetworkEndpointGroups(NetworkEndpointGroup networkEndpointGroups) {
      if (this.networkEndpointGroups == null) {
        this.networkEndpointGroups = new LinkedList<>();
      }
      this.networkEndpointGroups.add(networkEndpointGroups);
      return this;
    }

    /**
     * [Output Only] An informational warning that replaces the list of network endpoint groups when
     * the list is empty.
     */
    public Warning getWarning() {
      return warning;
    }

    /**
     * [Output Only] An informational warning that replaces the list of network endpoint groups when
     * the list is empty.
     */
    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public NetworkEndpointGroupsScopedList build() {

      return new NetworkEndpointGroupsScopedList(networkEndpointGroups, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllNetworkEndpointGroups(this.networkEndpointGroups);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NetworkEndpointGroupsScopedList{"
        + "networkEndpointGroups="
        + networkEndpointGroups
        + ", "
        + "warning="
        + warning
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NetworkEndpointGroupsScopedList) {
      NetworkEndpointGroupsScopedList that = (NetworkEndpointGroupsScopedList) o;
      return Objects.equals(this.networkEndpointGroups, that.getNetworkEndpointGroupsList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkEndpointGroups, warning);
  }
}
