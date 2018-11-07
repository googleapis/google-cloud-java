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
public final class VmEndpointNatMappingsInterfaceNatMappings implements ApiMessage {
  private final List<String> natIpPortRanges;
  private final Integer numTotalNatPorts;
  private final String sourceAliasIpRange;
  private final String sourceVirtualIp;

  private VmEndpointNatMappingsInterfaceNatMappings() {
    this.natIpPortRanges = null;
    this.numTotalNatPorts = null;
    this.sourceAliasIpRange = null;
    this.sourceVirtualIp = null;
  }

  private VmEndpointNatMappingsInterfaceNatMappings(
      List<String> natIpPortRanges,
      Integer numTotalNatPorts,
      String sourceAliasIpRange,
      String sourceVirtualIp) {
    this.natIpPortRanges = natIpPortRanges;
    this.numTotalNatPorts = numTotalNatPorts;
    this.sourceAliasIpRange = sourceAliasIpRange;
    this.sourceVirtualIp = sourceVirtualIp;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("natIpPortRanges")) {
      return natIpPortRanges;
    }
    if (fieldName.equals("numTotalNatPorts")) {
      return numTotalNatPorts;
    }
    if (fieldName.equals("sourceAliasIpRange")) {
      return sourceAliasIpRange;
    }
    if (fieldName.equals("sourceVirtualIp")) {
      return sourceVirtualIp;
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

  public List<String> getNatIpPortRangesList() {
    return natIpPortRanges;
  }

  public Integer getNumTotalNatPorts() {
    return numTotalNatPorts;
  }

  public String getSourceAliasIpRange() {
    return sourceAliasIpRange;
  }

  public String getSourceVirtualIp() {
    return sourceVirtualIp;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(VmEndpointNatMappingsInterfaceNatMappings prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static VmEndpointNatMappingsInterfaceNatMappings getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final VmEndpointNatMappingsInterfaceNatMappings DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new VmEndpointNatMappingsInterfaceNatMappings();
  }

  public static class Builder {
    private List<String> natIpPortRanges;
    private Integer numTotalNatPorts;
    private String sourceAliasIpRange;
    private String sourceVirtualIp;

    Builder() {}

    public Builder mergeFrom(VmEndpointNatMappingsInterfaceNatMappings other) {
      if (other == VmEndpointNatMappingsInterfaceNatMappings.getDefaultInstance()) return this;
      if (other.getNatIpPortRangesList() != null) {
        this.natIpPortRanges = other.natIpPortRanges;
      }
      if (other.getNumTotalNatPorts() != null) {
        this.numTotalNatPorts = other.numTotalNatPorts;
      }
      if (other.getSourceAliasIpRange() != null) {
        this.sourceAliasIpRange = other.sourceAliasIpRange;
      }
      if (other.getSourceVirtualIp() != null) {
        this.sourceVirtualIp = other.sourceVirtualIp;
      }
      return this;
    }

    Builder(VmEndpointNatMappingsInterfaceNatMappings source) {
      this.natIpPortRanges = source.natIpPortRanges;
      this.numTotalNatPorts = source.numTotalNatPorts;
      this.sourceAliasIpRange = source.sourceAliasIpRange;
      this.sourceVirtualIp = source.sourceVirtualIp;
    }

    public List<String> getNatIpPortRangesList() {
      return natIpPortRanges;
    }

    public Builder addAllNatIpPortRanges(List<String> natIpPortRanges) {
      if (this.natIpPortRanges == null) {
        this.natIpPortRanges = new LinkedList<>();
      }
      this.natIpPortRanges.addAll(natIpPortRanges);
      return this;
    }

    public Builder addNatIpPortRanges(String natIpPortRanges) {
      if (this.natIpPortRanges == null) {
        this.natIpPortRanges = new LinkedList<>();
      }
      this.natIpPortRanges.add(natIpPortRanges);
      return this;
    }

    public Integer getNumTotalNatPorts() {
      return numTotalNatPorts;
    }

    public Builder setNumTotalNatPorts(Integer numTotalNatPorts) {
      this.numTotalNatPorts = numTotalNatPorts;
      return this;
    }

    public String getSourceAliasIpRange() {
      return sourceAliasIpRange;
    }

    public Builder setSourceAliasIpRange(String sourceAliasIpRange) {
      this.sourceAliasIpRange = sourceAliasIpRange;
      return this;
    }

    public String getSourceVirtualIp() {
      return sourceVirtualIp;
    }

    public Builder setSourceVirtualIp(String sourceVirtualIp) {
      this.sourceVirtualIp = sourceVirtualIp;
      return this;
    }

    public VmEndpointNatMappingsInterfaceNatMappings build() {

      return new VmEndpointNatMappingsInterfaceNatMappings(
          natIpPortRanges, numTotalNatPorts, sourceAliasIpRange, sourceVirtualIp);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllNatIpPortRanges(this.natIpPortRanges);
      newBuilder.setNumTotalNatPorts(this.numTotalNatPorts);
      newBuilder.setSourceAliasIpRange(this.sourceAliasIpRange);
      newBuilder.setSourceVirtualIp(this.sourceVirtualIp);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "VmEndpointNatMappingsInterfaceNatMappings{"
        + "natIpPortRanges="
        + natIpPortRanges
        + ", "
        + "numTotalNatPorts="
        + numTotalNatPorts
        + ", "
        + "sourceAliasIpRange="
        + sourceAliasIpRange
        + ", "
        + "sourceVirtualIp="
        + sourceVirtualIp
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof VmEndpointNatMappingsInterfaceNatMappings) {
      VmEndpointNatMappingsInterfaceNatMappings that =
          (VmEndpointNatMappingsInterfaceNatMappings) o;
      return Objects.equals(this.natIpPortRanges, that.getNatIpPortRangesList())
          && Objects.equals(this.numTotalNatPorts, that.getNumTotalNatPorts())
          && Objects.equals(this.sourceAliasIpRange, that.getSourceAliasIpRange())
          && Objects.equals(this.sourceVirtualIp, that.getSourceVirtualIp());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(natIpPortRanges, numTotalNatPorts, sourceAliasIpRange, sourceVirtualIp);
  }
}
