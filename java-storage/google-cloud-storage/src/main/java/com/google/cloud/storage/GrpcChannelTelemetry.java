/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.storage;

import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.common.annotations.VisibleForTesting;
import io.grpc.internal.GrpcUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Package-private transport classification and startup configuration diagnostics for gRPC channels,
 * supporting CloudPath, DirectPath, and DirectPath over Cloud Interconnect.
 */
final class GrpcChannelTelemetry {

  static final String C2P_PREFIX = "google-c2p:///";
  static final String C2P_EXPERIMENTAL_PREFIX = "google-c2p-experimental:///";
  static final String FORCE_XDS_PARAM = "force-xds";
  static final String DIRECT_PATH_INTERCONNECT_HOST = "storage-direct.googleapis.com";
  static final String DIRECT_PATH_INTERCONNECT_PREPROD_HOST =
      "storage-preprod-direct.sandbox.googleapis.com";

  @VisibleForTesting
  static final Logger LOG = Logger.getLogger(GrpcChannelTelemetry.class.getName());

  private static final String DIRECT_PATH_INTERCONNECT_INFIX = "-direct.";
  private static final String ENV_ENABLE_DIRECT_PATH_XDS_OVER_INTERCONNECT =
      "GOOGLE_CLOUD_ENABLE_DIRECT_PATH_XDS_OVER_INTERCONNECT";
  private static final boolean GRPC_FORCE_XDS_SUPPORTED = detectGrpcForceXdsSupport();

  /** The transport used to reach the GCS service. */
  enum TransportType {
    CLOUD_PATH("CloudPath"),
    DIRECT_PATH("DirectPath"),
    DIRECT_PATH_INTERCONNECT("DirectPathInterconnect");

    private final String label;

    TransportType(String label) {
      this.label = label;
    }

    @Override
    public String toString() {
      return label;
    }
  }

  @VisibleForTesting
  static boolean hasQueryParameter(@Nullable String uri, String key) {
    if (uri == null || key == null) {
      return false;
    }
    int fragmentPos = uri.indexOf('#');
    String addressable = fragmentPos >= 0 ? uri.substring(0, fragmentPos) : uri;
    int queryPos = addressable.indexOf('?');
    if (queryPos < 0) {
      return false;
    }
    String query = addressable.substring(queryPos + 1);
    int start = 0;
    while (start <= query.length()) {
      int ampPos = query.indexOf('&', start);
      String param = ampPos >= 0 ? query.substring(start, ampPos) : query.substring(start);
      int eqPos = param.indexOf('=');
      String paramName = eqPos >= 0 ? param.substring(0, eqPos) : param;
      if (paramName.equals(key)) {
        return true;
      }
      if (ampPos < 0) {
        break;
      }
      start = ampPos + 1;
    }
    return false;
  }

  @VisibleForTesting
  static TransportType detectTransportType(@Nullable String endpoint) {
    if (endpoint == null
        || (!endpoint.startsWith(C2P_PREFIX) && !endpoint.startsWith(C2P_EXPERIMENTAL_PREFIX))) {
      return TransportType.CLOUD_PATH;
    }
    if (hasQueryParameter(endpoint, FORCE_XDS_PARAM)) {
      return TransportType.DIRECT_PATH_INTERCONNECT;
    }
    return TransportType.DIRECT_PATH;
  }

  @VisibleForTesting
  static String extractHost(@Nullable String endpointOrAuthority) {
    if (endpointOrAuthority == null || endpointOrAuthority.isEmpty()) {
      return "";
    }
    String normalized = endpointOrAuthority;
    if (normalized.startsWith(C2P_EXPERIMENTAL_PREFIX)) {
      normalized = C2P_PREFIX + normalized.substring(C2P_EXPERIMENTAL_PREFIX.length());
    }
    int queryIdx = normalized.indexOf('?');
    if (queryIdx >= 0) {
      normalized = normalized.substring(0, queryIdx);
    }
    int fragmentIdx = normalized.indexOf('#');
    if (fragmentIdx >= 0) {
      normalized = normalized.substring(0, fragmentIdx);
    }
    String extracted = OpenTelemetryBootstrappingUtils.extractServerAddress(normalized);
    return extracted != null ? extracted : "";
  }

  @VisibleForTesting
  static boolean isDirectPathInterconnectHost(@Nullable String host) {
    String h = extractHost(host);
    return DIRECT_PATH_INTERCONNECT_HOST.equals(h)
        || DIRECT_PATH_INTERCONNECT_PREPROD_HOST.equals(h);
  }

  @VisibleForTesting
  static boolean grpcForceXdsIsSupported() {
    return GRPC_FORCE_XDS_SUPPORTED;
  }

  static boolean isDirectPathInterconnectEnabled(boolean attemptDirectPathXdsOverInterconnect) {
    return isDirectPathInterconnectEnabled(
        attemptDirectPathXdsOverInterconnect,
        System.getenv(ENV_ENABLE_DIRECT_PATH_XDS_OVER_INTERCONNECT));
  }

  @VisibleForTesting
  static boolean isDirectPathInterconnectEnabled(
      boolean attemptDirectPathXdsOverInterconnect, @Nullable String envValue) {
    if (envValue != null) {
      String trimmed = envValue.trim();
      if ("true".equalsIgnoreCase(trimmed)) {
        return true;
      }
      if ("false".equalsIgnoreCase(trimmed)) {
        return false;
      }
    }
    return attemptDirectPathXdsOverInterconnect;
  }

  @VisibleForTesting
  static String resolveEffectiveTarget(
      InstantiatingGrpcChannelProvider provider, boolean attemptDirectPathXdsOverInterconnect) {
    String endpoint = provider.getEndpoint();
    if (endpoint == null) {
      return "";
    }
    if (endpoint.startsWith(C2P_PREFIX) || endpoint.startsWith(C2P_EXPERIMENTAL_PREFIX)) {
      return endpoint;
    }
    boolean interconnectEnabled =
        isDirectPathInterconnectEnabled(attemptDirectPathXdsOverInterconnect);
    if (!provider.needsCredentials()
        && provider.canUseDirectPath()
        && provider.isDirectPathXdsEnabled()) {
      String serviceAddress = extractHost(endpoint);
      if (interconnectEnabled) {
        return C2P_PREFIX
            + rewriteDirectPathInterconnectHost(serviceAddress)
            + "?"
            + FORCE_XDS_PARAM;
      }
      return C2P_PREFIX + serviceAddress;
    }
    return endpoint;
  }

  @VisibleForTesting
  static void logChannelConfiguration(
      String effectiveEndpoint,
      @Nullable String authority,
      boolean interconnectEnabled,
      boolean grpcSupportsForceXds) {
    TransportType requestedTransport = detectTransportType(effectiveEndpoint);
    String effectiveAuthority =
        (authority == null || authority.isEmpty()) ? extractHost(effectiveEndpoint) : authority;
    String grpcVersion = GrpcUtil.getGrpcBuildVersion().toString();

    if (!grpcSupportsForceXds
        && (interconnectEnabled || requestedTransport == TransportType.DIRECT_PATH_INTERCONNECT)) {
      LOG.log(
          Level.WARNING,
          "DirectPath over Interconnect requires a gRPC version supporting force-xds (found "
              + grpcVersion
              + "). The force-xds query parameter will be ignored by the google-c2p resolver;"
              + " outside GCE this channel will fall back to CloudPath, and on GCE it will use"
              + " standard DirectPath. endpoint="
              + effectiveEndpoint);
      return;
    }
    if (interconnectEnabled && requestedTransport != TransportType.DIRECT_PATH_INTERCONNECT) {
      LOG.log(
          Level.WARNING,
          "DirectPath over Interconnect is enabled, but the effective endpoint does not request"
              + " it. Check whether a custom endpoint, non-default universe domain, disabled"
              + " DirectPath, or unauthenticated credentials overrode the DirectPath over"
              + " Interconnect target. requested_transport_type="
              + requestedTransport
              + ", endpoint="
              + effectiveEndpoint);
      return;
    }
    if (requestedTransport == TransportType.DIRECT_PATH_INTERCONNECT
        && !isDirectPathInterconnectHost(effectiveAuthority)) {
      LOG.log(
          Level.WARNING,
          "DirectPath over Interconnect is active, but the channel authority is not a DirectPath"
              + " over Interconnect host; the service will route RPCs as standard DirectPath. Use '"
              + DIRECT_PATH_INTERCONNECT_HOST
              + "' (or '"
              + DIRECT_PATH_INTERCONNECT_PREPROD_HOST
              + "' in preprod). requested_transport_type="
              + requestedTransport
              + ", endpoint="
              + effectiveEndpoint
              + ", authority="
              + effectiveAuthority
              + ", grpc_version="
              + grpcVersion);
      return;
    }
    LOG.log(
        Level.INFO,
        "Configured gRPC transport. requested_transport_type="
            + requestedTransport
            + ", endpoint="
            + effectiveEndpoint
            + ", authority="
            + effectiveAuthority
            + ", grpc_version="
            + grpcVersion);
  }

  private GrpcChannelTelemetry() {}

  private static boolean detectGrpcForceXdsSupport() {
    try {
      Class<?> clazz = Class.forName("io.grpc.googleapis.GoogleCloudToProdNameResolver");
      clazz.getDeclaredField("forceXds");
      return true;
    } catch (Throwable e) {
      return false;
    }
  }

  private static String rewriteDirectPathInterconnectHost(String serviceAddress) {
    if (!serviceAddress.contains(DIRECT_PATH_INTERCONNECT_INFIX)) {
      int dotIndex = serviceAddress.indexOf('.');
      if (dotIndex > 0) {
        return serviceAddress.substring(0, dotIndex)
            + DIRECT_PATH_INTERCONNECT_INFIX
            + serviceAddress.substring(dotIndex + 1);
      }
    }
    return serviceAddress;
  }
}
