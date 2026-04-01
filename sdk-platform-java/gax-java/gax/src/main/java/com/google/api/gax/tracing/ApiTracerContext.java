/*
 * Copyright 2026 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.api.gax.tracing;

import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.LibraryMetadata;
import com.google.api.gax.tracing.ApiTracerFactory.OperationType;
import com.google.auto.value.AutoValue;
import com.google.common.base.Strings;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/**
 * A context object that contains information used to infer attributes that are common for all
 * {@link ApiTracer}s.
 *
 * <p>For internal use only.
 */
@InternalApi
@AutoValue
public abstract class ApiTracerContext {

  public enum Transport {
    GRPC("grpc"),
    HTTP("http");

    private final String label;

    Transport(String label) {
      this.label = label;
    }
  }

  /**
   * Returns the server address of the RPC.
   *
   * <p>Example: "pubsub.googleapis.com". This maps to the {@code server.address} attribute.
   *
   * @return the server address, or {@code null} if not set
   */
  @Nullable
  abstract String serverAddress();

  /**
   * Returns the server port of the RPC.
   *
   * <p>Example: 1337. This maps to the {@code server.port} attribute.
   *
   * @return the server port, or {@code null} if not set
   */
  @Nullable
  public abstract Integer serverPort();

  /**
   * Returns the library metadata associated with the RPC.
   *
   * <p>See {@link LibraryMetadata} for examples of how this maps to observability attributes.
   *
   * @return the library metadata
   */
  abstract LibraryMetadata libraryMetadata();

  /**
   * Returns the RPC system name based on the transport.
   *
   * <p>Example: "grpc" or "http". This maps to the {@code rpc.system.name} attribute.
   *
   * @return the RPC system name, or {@code null} if the transport is not set
   */
  @Nullable
  String rpcSystemName() {
    if (transport() == null) {
      return null;
    }
    return transport().label;
  }

  /**
   * Returns the full name of the RPC method. Used in gRPC requests.
   *
   * <p>This is typically in the format "package.Service/Method"
   *
   * <p>Example: "google.pubsub.v1.Publisher/Publish". This maps to the {@code rpc.method}
   * attribute.
   *
   * @return the full method name, or {@code null} if not set
   */
  @Nullable
  abstract String fullMethodName();

  /**
   * Returns the transport protocol used for the RPC.
   *
   * <p>Example: {@link Transport#GRPC}. This is used to derive the {@code rpc.system.name}
   * attribute (e.g., "grpc").
   *
   * @return the transport protocol, or {@code null} if not set
   */
  @Nullable
  abstract Transport transport();

  /**
   * Returns the type of operation the {@link ApiTracer} is tracing.
   *
   * @return the operation type, or {@code null} if not set
   */
  @Nullable
  public abstract OperationType operationType();

  /**
   * Returns the HTTP method used for the RPC, in case the RPC is an HttpJson method.
   *
   * <p>Example: {@code PATCH}.
   *
   * @return the HTTP method, or {@code null} if not set
   */
  @Nullable
  abstract String httpMethod();

  /**
   * Returns the HTTP path template used for the RPC, in case the RPC is an HttpJson method.
   *
   * <p>Example: {@code /users/{user_id}/get}.
   *
   * @return the HTTP path template, or {@code null} if not set
   */
  @Nullable
  abstract String httpPathTemplate();

  /** The service name of a client (e.g. "bigtable", "spanner"). */
  @Nullable
  public abstract String serviceName();

  /** The url domain of the request (e.g. "pubsub.googleapis.com"). */
  @Nullable
  public abstract String urlDomain();

  /** The destination resource id of the request (e.g. projects/p/locations/l/topics/t). */
  @Nullable
  public abstract String destinationResourceId();

  /**
   * @return a map of attributes to be included in attempt-level spans
   */
  public Map<String, Object> getAttemptAttributes() {
    Map<String, Object> attributes = new HashMap<>();
    if (!Strings.isNullOrEmpty(serverAddress())) {
      attributes.put(ObservabilityAttributes.SERVER_ADDRESS_ATTRIBUTE, serverAddress());
    }
    if (serverPort() != null) {
      attributes.put(ObservabilityAttributes.SERVER_PORT_ATTRIBUTE, serverPort());
    }
    if (rpcSystemName() != null) {
      attributes.put(ObservabilityAttributes.RPC_SYSTEM_NAME_ATTRIBUTE, rpcSystemName());
    }
    if (!libraryMetadata().isEmpty()) {
      if (!Strings.isNullOrEmpty(libraryMetadata().repository())) {
        attributes.put(ObservabilityAttributes.REPO_ATTRIBUTE, libraryMetadata().repository());
      }
      if (!Strings.isNullOrEmpty(libraryMetadata().artifactName())) {
        attributes.put(
            ObservabilityAttributes.ARTIFACT_ATTRIBUTE, libraryMetadata().artifactName());
      }
      if (!Strings.isNullOrEmpty(libraryMetadata().version())) {
        attributes.put(ObservabilityAttributes.VERSION_ATTRIBUTE, libraryMetadata().version());
      }
    }
    if (transport() == Transport.GRPC && !Strings.isNullOrEmpty(fullMethodName())) {
      attributes.put(ObservabilityAttributes.GRPC_RPC_METHOD_ATTRIBUTE, fullMethodName());
    }
    if (transport() == Transport.HTTP) {
      if (!Strings.isNullOrEmpty(httpMethod())) {
        attributes.put(ObservabilityAttributes.HTTP_METHOD_ATTRIBUTE, httpMethod());
      }
      if (!Strings.isNullOrEmpty(httpPathTemplate())) {
        attributes.put(ObservabilityAttributes.HTTP_URL_TEMPLATE_ATTRIBUTE, httpPathTemplate());
      }
    }
    if (!Strings.isNullOrEmpty(serviceName())) {
      attributes.put(ObservabilityAttributes.GCP_CLIENT_SERVICE_ATTRIBUTE, serviceName());
    }
    if (!Strings.isNullOrEmpty(destinationResourceId())) {
      attributes.put(
          ObservabilityAttributes.DESTINATION_RESOURCE_ID_ATTRIBUTE, destinationResourceId());
    }
    return attributes;
  }

  Map<String, Object> getMetricsAttributes() {
    Map<String, Object> attributes = new HashMap<>();
    if (!Strings.isNullOrEmpty(serverAddress())) {
      attributes.put(ObservabilityAttributes.SERVER_ADDRESS_ATTRIBUTE, serverAddress());
    }
    if (serverPort() != null) {
      attributes.put(ObservabilityAttributes.SERVER_PORT_ATTRIBUTE, serverPort());
    }
    if (!Strings.isNullOrEmpty(serviceName())) {
      attributes.put(ObservabilityAttributes.GCP_CLIENT_SERVICE_ATTRIBUTE, serviceName());
    }
    if (!Strings.isNullOrEmpty(rpcSystemName())) {
      attributes.put(ObservabilityAttributes.RPC_SYSTEM_NAME_ATTRIBUTE, rpcSystemName());
    }
    if (!Strings.isNullOrEmpty(fullMethodName())) {
      attributes.put(ObservabilityAttributes.GRPC_RPC_METHOD_ATTRIBUTE, fullMethodName());
    }
    if (transport() == Transport.HTTP) {
      if (!Strings.isNullOrEmpty(urlDomain())) {
        attributes.put(ObservabilityAttributes.URL_DOMAIN_ATTRIBUTE, urlDomain());
      }
      if (!Strings.isNullOrEmpty(httpPathTemplate())) {
        attributes.put(ObservabilityAttributes.URL_TEMPLATE_ATTRIBUTE, httpPathTemplate());
      }
    }
    return attributes;
  }

  /**
   * Merges this context with another context. The values in the other context take precedence.
   *
   * @param other the other context to merge with
   * @return a new {@link ApiTracerContext} with merged values
   */
  ApiTracerContext merge(ApiTracerContext other) {
    Builder builder = toBuilder();
    if (!Strings.isNullOrEmpty(other.serverAddress())) {
      builder.setServerAddress(other.serverAddress());
    }
    if (other.serverPort() != null) {
      builder.setServerPort(other.serverPort());
    }
    if (!other.libraryMetadata().isEmpty()) {
      builder.setLibraryMetadata(other.libraryMetadata());
    }
    if (!Strings.isNullOrEmpty(other.fullMethodName())) {
      builder.setFullMethodName(other.fullMethodName());
    }
    if (other.transport() != null) {
      builder.setTransport(other.transport());
    }
    if (!Strings.isNullOrEmpty(other.httpMethod())) {
      builder.setHttpMethod(other.httpMethod());
    }
    if (!Strings.isNullOrEmpty(other.httpPathTemplate())) {
      builder.setHttpPathTemplate(other.httpPathTemplate());
    }
    if (other.operationType() != null) {
      builder.setOperationType(other.operationType());
    }
    if (!Strings.isNullOrEmpty(other.serviceName())) {
      builder.setServiceName(other.serviceName());
    }
    if (!Strings.isNullOrEmpty(other.urlDomain())) {
      builder.setUrlDomain(other.urlDomain());
    }
    if (other.destinationResourceId() != null) {
      builder.setDestinationResourceId(other.destinationResourceId());
    }
    return builder.build();
  }

  public static ApiTracerContext empty() {
    return newBuilder().setLibraryMetadata(LibraryMetadata.empty()).build();
  }

  public static Builder newBuilder() {
    return new AutoValue_ApiTracerContext.Builder();
  }

  public abstract Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setServerAddress(@Nullable String serverAddress);

    public abstract Builder setLibraryMetadata(LibraryMetadata gapicProperties);

    public abstract Builder setFullMethodName(@Nullable String rpcMethod);

    public abstract Builder setTransport(@Nullable Transport transport);

    public abstract Builder setOperationType(@Nullable OperationType operationType);

    public abstract Builder setServerPort(@Nullable Integer serverPort);

    public abstract Builder setHttpMethod(@Nullable String httpMethod);

    public abstract Builder setHttpPathTemplate(@Nullable String rawString);

    public abstract Builder setServiceName(@Nullable String serviceName);

    public abstract Builder setUrlDomain(@Nullable String urlDomain);

    public abstract Builder setDestinationResourceId(@Nullable String destinationResourceId);

    public abstract ApiTracerContext build();
  }
}
