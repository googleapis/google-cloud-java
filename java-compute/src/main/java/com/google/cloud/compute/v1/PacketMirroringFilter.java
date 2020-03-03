/*
 * Copyright 2020 Google LLC
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
import com.google.gson.annotations.SerializedName;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class PacketMirroringFilter implements ApiMessage {
  private final List<String> cidrRanges;

  @SerializedName("IPProtocols")
  private final List<String> iPProtocols;

  private PacketMirroringFilter() {
    this.cidrRanges = null;
    this.iPProtocols = null;
  }

  private PacketMirroringFilter(List<String> cidrRanges, List<String> iPProtocols) {
    this.cidrRanges = cidrRanges;
    this.iPProtocols = iPProtocols;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("cidrRanges".equals(fieldName)) {
      return cidrRanges;
    }
    if ("iPProtocols".equals(fieldName)) {
      return iPProtocols;
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
   * IP CIDR ranges that apply as filter on the source (ingress) or destination (egress) IP in the
   * IP header. Only IPv4 is supported. If no ranges are specified, all traffic that matches the
   * specified IPProtocols is mirrored. If neither cidrRanges nor IPProtocols is specified, all
   * traffic is mirrored.
   */
  public List<String> getCidrRangesList() {
    return cidrRanges;
  }

  /**
   * Protocols that apply as filter on mirrored traffic. If no protocols are specified, all traffic
   * that matches the specified CIDR ranges is mirrored. If neither cidrRanges nor IPProtocols is
   * specified, all traffic is mirrored.
   */
  public List<String> getIPProtocolsList() {
    return iPProtocols;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(PacketMirroringFilter prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static PacketMirroringFilter getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final PacketMirroringFilter DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new PacketMirroringFilter();
  }

  public static class Builder {
    private List<String> cidrRanges;
    private List<String> iPProtocols;

    Builder() {}

    public Builder mergeFrom(PacketMirroringFilter other) {
      if (other == PacketMirroringFilter.getDefaultInstance()) return this;
      if (other.getCidrRangesList() != null) {
        this.cidrRanges = other.cidrRanges;
      }
      if (other.getIPProtocolsList() != null) {
        this.iPProtocols = other.iPProtocols;
      }
      return this;
    }

    Builder(PacketMirroringFilter source) {
      this.cidrRanges = source.cidrRanges;
      this.iPProtocols = source.iPProtocols;
    }

    /**
     * IP CIDR ranges that apply as filter on the source (ingress) or destination (egress) IP in the
     * IP header. Only IPv4 is supported. If no ranges are specified, all traffic that matches the
     * specified IPProtocols is mirrored. If neither cidrRanges nor IPProtocols is specified, all
     * traffic is mirrored.
     */
    public List<String> getCidrRangesList() {
      return cidrRanges;
    }

    /**
     * IP CIDR ranges that apply as filter on the source (ingress) or destination (egress) IP in the
     * IP header. Only IPv4 is supported. If no ranges are specified, all traffic that matches the
     * specified IPProtocols is mirrored. If neither cidrRanges nor IPProtocols is specified, all
     * traffic is mirrored.
     */
    public Builder addAllCidrRanges(List<String> cidrRanges) {
      if (this.cidrRanges == null) {
        this.cidrRanges = new LinkedList<>();
      }
      this.cidrRanges.addAll(cidrRanges);
      return this;
    }

    /**
     * IP CIDR ranges that apply as filter on the source (ingress) or destination (egress) IP in the
     * IP header. Only IPv4 is supported. If no ranges are specified, all traffic that matches the
     * specified IPProtocols is mirrored. If neither cidrRanges nor IPProtocols is specified, all
     * traffic is mirrored.
     */
    public Builder addCidrRanges(String cidrRanges) {
      if (this.cidrRanges == null) {
        this.cidrRanges = new LinkedList<>();
      }
      this.cidrRanges.add(cidrRanges);
      return this;
    }

    /**
     * Protocols that apply as filter on mirrored traffic. If no protocols are specified, all
     * traffic that matches the specified CIDR ranges is mirrored. If neither cidrRanges nor
     * IPProtocols is specified, all traffic is mirrored.
     */
    public List<String> getIPProtocolsList() {
      return iPProtocols;
    }

    /**
     * Protocols that apply as filter on mirrored traffic. If no protocols are specified, all
     * traffic that matches the specified CIDR ranges is mirrored. If neither cidrRanges nor
     * IPProtocols is specified, all traffic is mirrored.
     */
    public Builder addAllIPProtocols(List<String> iPProtocols) {
      if (this.iPProtocols == null) {
        this.iPProtocols = new LinkedList<>();
      }
      this.iPProtocols.addAll(iPProtocols);
      return this;
    }

    /**
     * Protocols that apply as filter on mirrored traffic. If no protocols are specified, all
     * traffic that matches the specified CIDR ranges is mirrored. If neither cidrRanges nor
     * IPProtocols is specified, all traffic is mirrored.
     */
    public Builder addIPProtocols(String iPProtocols) {
      if (this.iPProtocols == null) {
        this.iPProtocols = new LinkedList<>();
      }
      this.iPProtocols.add(iPProtocols);
      return this;
    }

    public PacketMirroringFilter build() {

      return new PacketMirroringFilter(cidrRanges, iPProtocols);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllCidrRanges(this.cidrRanges);
      newBuilder.addAllIPProtocols(this.iPProtocols);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "PacketMirroringFilter{"
        + "cidrRanges="
        + cidrRanges
        + ", "
        + "iPProtocols="
        + iPProtocols
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PacketMirroringFilter) {
      PacketMirroringFilter that = (PacketMirroringFilter) o;
      return Objects.equals(this.cidrRanges, that.getCidrRangesList())
          && Objects.equals(this.iPProtocols, that.getIPProtocolsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(cidrRanges, iPProtocols);
  }
}
