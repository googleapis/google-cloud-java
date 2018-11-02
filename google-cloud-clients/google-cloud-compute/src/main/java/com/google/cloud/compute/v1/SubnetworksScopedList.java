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
public final class SubnetworksScopedList implements ApiMessage {
  private final List<Subnetwork> subnetworks;
  private final Warning warning;

  private SubnetworksScopedList() {
    this.subnetworks = null;
    this.warning = null;
  }

  private SubnetworksScopedList(List<Subnetwork> subnetworks, Warning warning) {
    this.subnetworks = subnetworks;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("subnetworks")) {
      return subnetworks;
    }
    if (fieldName.equals("warning")) {
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
  public List<String> getFieldMask() {
    return null;
  }

  public List<Subnetwork> getSubnetworksList() {
    return subnetworks;
  }

  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(SubnetworksScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SubnetworksScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final SubnetworksScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new SubnetworksScopedList();
  }

  public static class Builder {
    private List<Subnetwork> subnetworks;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(SubnetworksScopedList other) {
      if (other == SubnetworksScopedList.getDefaultInstance()) return this;
      if (other.getSubnetworksList() != null) {
        this.subnetworks = other.subnetworks;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(SubnetworksScopedList source) {
      this.subnetworks = source.subnetworks;
      this.warning = source.warning;
    }

    public List<Subnetwork> getSubnetworksList() {
      return subnetworks;
    }

    public Builder addAllSubnetworks(List<Subnetwork> subnetworks) {
      if (this.subnetworks == null) {
        this.subnetworks = new LinkedList<>();
      }
      this.subnetworks.addAll(subnetworks);
      return this;
    }

    public Builder addSubnetworks(Subnetwork subnetworks) {
      if (this.subnetworks == null) {
        this.subnetworks = new LinkedList<>();
      }
      this.subnetworks.add(subnetworks);
      return this;
    }

    public Warning getWarning() {
      return warning;
    }

    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public SubnetworksScopedList build() {

      return new SubnetworksScopedList(subnetworks, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllSubnetworks(this.subnetworks);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "SubnetworksScopedList{"
        + "subnetworks="
        + subnetworks
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
    if (o instanceof SubnetworksScopedList) {
      SubnetworksScopedList that = (SubnetworksScopedList) o;
      return Objects.equals(this.subnetworks, that.getSubnetworksList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(subnetworks, warning);
  }
}
