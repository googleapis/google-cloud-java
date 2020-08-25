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
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class GRPCHealthCheck implements ApiMessage {
  private final String grpcServiceName;
  private final Integer port;
  private final String portName;
  private final String portSpecification;

  private GRPCHealthCheck() {
    this.grpcServiceName = null;
    this.port = null;
    this.portName = null;
    this.portSpecification = null;
  }

  private GRPCHealthCheck(
      String grpcServiceName, Integer port, String portName, String portSpecification) {
    this.grpcServiceName = grpcServiceName;
    this.port = port;
    this.portName = portName;
    this.portSpecification = portSpecification;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("grpcServiceName".equals(fieldName)) {
      return grpcServiceName;
    }
    if ("port".equals(fieldName)) {
      return port;
    }
    if ("portName".equals(fieldName)) {
      return portName;
    }
    if ("portSpecification".equals(fieldName)) {
      return portSpecification;
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
   * The gRPC service name for the health check. This field is optional. The value of
   * grpc_service_name has the following meanings by convention: - Empty service_name means the
   * overall status of all services at the backend. - Non-empty service_name means the health of
   * that gRPC service, as defined by the owner of the service. The grpc_service_name can only be
   * ASCII.
   */
  public String getGrpcServiceName() {
    return grpcServiceName;
  }

  /**
   * The port number for the health check request. Must be specified if port_name and
   * port_specification are not set or if port_specification is USE_FIXED_PORT. Valid values are 1
   * through 65535.
   */
  public Integer getPort() {
    return port;
  }

  /**
   * Port name as defined in InstanceGroup#NamedPort#name. If both port and port_name are defined,
   * port takes precedence. The port_name should conform to RFC1035.
   */
  public String getPortName() {
    return portName;
  }

  /**
   * Specifies how port is selected for health checking, can be one of following values:
   * USE_FIXED_PORT: The port number in port is used for health checking. USE_NAMED_PORT: The
   * portName is used for health checking. USE_SERVING_PORT: For NetworkEndpointGroup, the port
   * specified for each network endpoint is used for health checking. For other backends, the port
   * or named port specified in the Backend Service is used for health checking.
   *
   * <p>If not specified, gRPC health check follows behavior specified in port and portName fields.
   */
  public String getPortSpecification() {
    return portSpecification;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(GRPCHealthCheck prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static GRPCHealthCheck getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final GRPCHealthCheck DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new GRPCHealthCheck();
  }

  public static class Builder {
    private String grpcServiceName;
    private Integer port;
    private String portName;
    private String portSpecification;

    Builder() {}

    public Builder mergeFrom(GRPCHealthCheck other) {
      if (other == GRPCHealthCheck.getDefaultInstance()) return this;
      if (other.getGrpcServiceName() != null) {
        this.grpcServiceName = other.grpcServiceName;
      }
      if (other.getPort() != null) {
        this.port = other.port;
      }
      if (other.getPortName() != null) {
        this.portName = other.portName;
      }
      if (other.getPortSpecification() != null) {
        this.portSpecification = other.portSpecification;
      }
      return this;
    }

    Builder(GRPCHealthCheck source) {
      this.grpcServiceName = source.grpcServiceName;
      this.port = source.port;
      this.portName = source.portName;
      this.portSpecification = source.portSpecification;
    }

    /**
     * The gRPC service name for the health check. This field is optional. The value of
     * grpc_service_name has the following meanings by convention: - Empty service_name means the
     * overall status of all services at the backend. - Non-empty service_name means the health of
     * that gRPC service, as defined by the owner of the service. The grpc_service_name can only be
     * ASCII.
     */
    public String getGrpcServiceName() {
      return grpcServiceName;
    }

    /**
     * The gRPC service name for the health check. This field is optional. The value of
     * grpc_service_name has the following meanings by convention: - Empty service_name means the
     * overall status of all services at the backend. - Non-empty service_name means the health of
     * that gRPC service, as defined by the owner of the service. The grpc_service_name can only be
     * ASCII.
     */
    public Builder setGrpcServiceName(String grpcServiceName) {
      this.grpcServiceName = grpcServiceName;
      return this;
    }

    /**
     * The port number for the health check request. Must be specified if port_name and
     * port_specification are not set or if port_specification is USE_FIXED_PORT. Valid values are 1
     * through 65535.
     */
    public Integer getPort() {
      return port;
    }

    /**
     * The port number for the health check request. Must be specified if port_name and
     * port_specification are not set or if port_specification is USE_FIXED_PORT. Valid values are 1
     * through 65535.
     */
    public Builder setPort(Integer port) {
      this.port = port;
      return this;
    }

    /**
     * Port name as defined in InstanceGroup#NamedPort#name. If both port and port_name are defined,
     * port takes precedence. The port_name should conform to RFC1035.
     */
    public String getPortName() {
      return portName;
    }

    /**
     * Port name as defined in InstanceGroup#NamedPort#name. If both port and port_name are defined,
     * port takes precedence. The port_name should conform to RFC1035.
     */
    public Builder setPortName(String portName) {
      this.portName = portName;
      return this;
    }

    /**
     * Specifies how port is selected for health checking, can be one of following values:
     * USE_FIXED_PORT: The port number in port is used for health checking. USE_NAMED_PORT: The
     * portName is used for health checking. USE_SERVING_PORT: For NetworkEndpointGroup, the port
     * specified for each network endpoint is used for health checking. For other backends, the port
     * or named port specified in the Backend Service is used for health checking.
     *
     * <p>If not specified, gRPC health check follows behavior specified in port and portName
     * fields.
     */
    public String getPortSpecification() {
      return portSpecification;
    }

    /**
     * Specifies how port is selected for health checking, can be one of following values:
     * USE_FIXED_PORT: The port number in port is used for health checking. USE_NAMED_PORT: The
     * portName is used for health checking. USE_SERVING_PORT: For NetworkEndpointGroup, the port
     * specified for each network endpoint is used for health checking. For other backends, the port
     * or named port specified in the Backend Service is used for health checking.
     *
     * <p>If not specified, gRPC health check follows behavior specified in port and portName
     * fields.
     */
    public Builder setPortSpecification(String portSpecification) {
      this.portSpecification = portSpecification;
      return this;
    }

    public GRPCHealthCheck build() {

      return new GRPCHealthCheck(grpcServiceName, port, portName, portSpecification);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setGrpcServiceName(this.grpcServiceName);
      newBuilder.setPort(this.port);
      newBuilder.setPortName(this.portName);
      newBuilder.setPortSpecification(this.portSpecification);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "GRPCHealthCheck{"
        + "grpcServiceName="
        + grpcServiceName
        + ", "
        + "port="
        + port
        + ", "
        + "portName="
        + portName
        + ", "
        + "portSpecification="
        + portSpecification
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof GRPCHealthCheck) {
      GRPCHealthCheck that = (GRPCHealthCheck) o;
      return Objects.equals(this.grpcServiceName, that.getGrpcServiceName())
          && Objects.equals(this.port, that.getPort())
          && Objects.equals(this.portName, that.getPortName())
          && Objects.equals(this.portSpecification, that.getPortSpecification());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(grpcServiceName, port, portName, portSpecification);
  }
}
