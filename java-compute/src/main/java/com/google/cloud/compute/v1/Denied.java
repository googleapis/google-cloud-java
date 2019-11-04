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
import com.google.gson.annotations.SerializedName;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/**
 * The list of DENY rules specified by this firewall. Each rule specifies a protocol and port-range
 * tuple that describes a denied connection.
 */
public final class Denied implements ApiMessage {
  @SerializedName("IPProtocol")
  private final String iPProtocol;

  private final List<String> ports;

  private Denied() {
    this.iPProtocol = null;
    this.ports = null;
  }

  private Denied(String iPProtocol, List<String> ports) {
    this.iPProtocol = iPProtocol;
    this.ports = ports;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("iPProtocol".equals(fieldName)) {
      return iPProtocol;
    }
    if ("ports".equals(fieldName)) {
      return ports;
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
   * The IP protocol to which this rule applies. The protocol type is required when creating a
   * firewall rule. This value can either be one of the following well known protocol strings (tcp,
   * udp, icmp, esp, ah, ipip, sctp) or the IP protocol number.
   */
  public String getIPProtocol() {
    return iPProtocol;
  }

  /**
   * An optional list of ports to which this rule applies. This field is only applicable for the UDP
   * or TCP protocol. Each entry must be either an integer or a range. If not specified, this rule
   * applies to connections through any port.
   *
   * <p>Example inputs include: ["22"], ["80","443"], and ["12345-12349"].
   */
  public List<String> getPortsList() {
    return ports;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Denied prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Denied getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Denied DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Denied();
  }

  public static class Builder {
    private String iPProtocol;
    private List<String> ports;

    Builder() {}

    public Builder mergeFrom(Denied other) {
      if (other == Denied.getDefaultInstance()) return this;
      if (other.getIPProtocol() != null) {
        this.iPProtocol = other.iPProtocol;
      }
      if (other.getPortsList() != null) {
        this.ports = other.ports;
      }
      return this;
    }

    Builder(Denied source) {
      this.iPProtocol = source.iPProtocol;
      this.ports = source.ports;
    }

    /**
     * The IP protocol to which this rule applies. The protocol type is required when creating a
     * firewall rule. This value can either be one of the following well known protocol strings
     * (tcp, udp, icmp, esp, ah, ipip, sctp) or the IP protocol number.
     */
    public String getIPProtocol() {
      return iPProtocol;
    }

    /**
     * The IP protocol to which this rule applies. The protocol type is required when creating a
     * firewall rule. This value can either be one of the following well known protocol strings
     * (tcp, udp, icmp, esp, ah, ipip, sctp) or the IP protocol number.
     */
    public Builder setIPProtocol(String iPProtocol) {
      this.iPProtocol = iPProtocol;
      return this;
    }

    /**
     * An optional list of ports to which this rule applies. This field is only applicable for the
     * UDP or TCP protocol. Each entry must be either an integer or a range. If not specified, this
     * rule applies to connections through any port.
     *
     * <p>Example inputs include: ["22"], ["80","443"], and ["12345-12349"].
     */
    public List<String> getPortsList() {
      return ports;
    }

    /**
     * An optional list of ports to which this rule applies. This field is only applicable for the
     * UDP or TCP protocol. Each entry must be either an integer or a range. If not specified, this
     * rule applies to connections through any port.
     *
     * <p>Example inputs include: ["22"], ["80","443"], and ["12345-12349"].
     */
    public Builder addAllPorts(List<String> ports) {
      if (this.ports == null) {
        this.ports = new LinkedList<>();
      }
      this.ports.addAll(ports);
      return this;
    }

    /**
     * An optional list of ports to which this rule applies. This field is only applicable for the
     * UDP or TCP protocol. Each entry must be either an integer or a range. If not specified, this
     * rule applies to connections through any port.
     *
     * <p>Example inputs include: ["22"], ["80","443"], and ["12345-12349"].
     */
    public Builder addPorts(String ports) {
      if (this.ports == null) {
        this.ports = new LinkedList<>();
      }
      this.ports.add(ports);
      return this;
    }

    public Denied build() {

      return new Denied(iPProtocol, ports);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setIPProtocol(this.iPProtocol);
      newBuilder.addAllPorts(this.ports);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Denied{" + "iPProtocol=" + iPProtocol + ", " + "ports=" + ports + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Denied) {
      Denied that = (Denied) o;
      return Objects.equals(this.iPProtocol, that.getIPProtocol())
          && Objects.equals(this.ports, that.getPortsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(iPProtocol, ports);
  }
}
