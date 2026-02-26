/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.bigtable.data.v2.internal.csm.attributes;

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.bigtable.v2.PeerInfo;
import com.google.bigtable.v2.PeerInfo.TransportType;
import com.google.bigtable.v2.ResponseParams;
import com.google.common.annotations.VisibleForTesting;
import io.grpc.Status;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;

public class Util {
  static final String TRANSPORT_TYPE_PREFIX = "TRANSPORT_TYPE_";

  public static String formatTransportZone(@Nullable PeerInfo peerInfo) {
    return Optional.ofNullable(peerInfo).map(PeerInfo::getApplicationFrontendZone).orElse("");
  }

  public static String formatTransportSubzone(@Nullable PeerInfo peerInfo) {
    return Optional.ofNullable(peerInfo).map(PeerInfo::getApplicationFrontendSubzone).orElse("");
  }

  public static String formatTransportType(@Nullable PeerInfo peerInfo) {
    return transportTypeToString(
        Optional.ofNullable(peerInfo)
            .map(PeerInfo::getTransportType)
            .orElse(TransportType.TRANSPORT_TYPE_UNKNOWN));
  }

  public static String transportTypeToString(TransportType transportType) {
    String label = transportTypeToStringWithoutFallback(transportType);
    if (label != null) {
      return label;
    }
    // In case the client is running with a newer version of protos
    if (transportType.name().startsWith(TRANSPORT_TYPE_PREFIX)) {
      return transportType
          .name()
          .substring(TRANSPORT_TYPE_PREFIX.length())
          .toLowerCase(Locale.ENGLISH);
    } else {
      return transportType.name();
    }
  }

  @VisibleForTesting
  static String transportTypeToStringWithoutFallback(TransportType transportType) {
    if (transportType == null) {
      return "null";
    }
    switch (transportType) {
      case TRANSPORT_TYPE_UNKNOWN:
        return "unknown";
      case TRANSPORT_TYPE_EXTERNAL:
        return "external";
      case TRANSPORT_TYPE_CLOUD_PATH:
        return "cloudpath";
      case TRANSPORT_TYPE_DIRECT_ACCESS:
        return "directpath";
      case TRANSPORT_TYPE_SESSION_UNKNOWN:
        return "session_unknown";
      case TRANSPORT_TYPE_SESSION_EXTERNAL:
        return "session_external";
      case TRANSPORT_TYPE_SESSION_CLOUD_PATH:
        return "session_cloudpath";
      case TRANSPORT_TYPE_SESSION_DIRECT_ACCESS:
        return "session_directpath";
      case UNRECOGNIZED:
        return "unrecognized";
      default:
        return null;
    }
  }

  public static String formatClusterIdMetricLabel(@Nullable ResponseParams clusterInfo) {
    return Optional.ofNullable(clusterInfo)
        .map(ResponseParams::getClusterId)
        .filter(s -> !s.isEmpty())
        .orElse("<unspecified>");
  }

  public static String formatZoneIdMetricLabel(@Nullable ResponseParams clusterInfo) {
    return Optional.ofNullable(clusterInfo)
        .map(ResponseParams::getZoneId)
        .filter(s -> !s.isEmpty())
        .orElse("global");
  }

  public static Status.Code extractStatus(@Nullable Throwable error) {
    if (error == null) {
      return Status.Code.OK;
    }
    // Handle java CancellationException as if it was a gax CancelledException
    if (error instanceof CancellationException) {
      return Status.Code.CANCELLED;
    }
    if (error instanceof ApiException) {
      ApiException apiException = (ApiException) error;
      if (apiException.getStatusCode() instanceof GrpcStatusCode) {
        return ((GrpcStatusCode) apiException.getStatusCode()).getTransportCode();
      }
    }

    Status s = Status.fromThrowable(error);
    if (s != null) {
      return s.getCode();
    }
    return Status.Code.UNKNOWN;
  }
}
