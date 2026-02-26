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

import com.google.bigtable.v2.PeerInfo;
import com.google.bigtable.v2.PeerInfo.TransportType;
import com.google.bigtable.v2.ResponseParams;
import java.util.Locale;
import java.util.Optional;
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
    if (transportType == TransportType.TRANSPORT_TYPE_UNKNOWN) {
      return "none";
    }
    if (transportType == TransportType.UNRECOGNIZED) {
      return "unrecognized";
    }

    return transportType
        .name()
        .substring(TRANSPORT_TYPE_PREFIX.length())
        .toLowerCase(Locale.ENGLISH);
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
}
