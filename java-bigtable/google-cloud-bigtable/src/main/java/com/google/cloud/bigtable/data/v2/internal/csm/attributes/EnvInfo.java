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

import com.google.auto.value.AutoValue;
import com.google.cloud.opentelemetry.detection.AttributeKeys;
import com.google.cloud.opentelemetry.detection.DetectedPlatform;
import com.google.cloud.opentelemetry.detection.GCPPlatformDetector;
import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

/**
 * Environment attributes, lazily extracted by the Exporter.
 *
 * <p>The information will be extracted from the GCE metadata service and environment.
 */
@AutoValue
public abstract class EnvInfo {
  private static final Logger logger = Logger.getLogger(EnvInfo.class.getName());

  private static final Map<GCPPlatformDetector.SupportedPlatform, String> SUPPORTED_PLATFORM_MAP =
      ImmutableMap.of(
          GCPPlatformDetector.SupportedPlatform.GOOGLE_COMPUTE_ENGINE, "gcp_compute_engine",
          GCPPlatformDetector.SupportedPlatform.GOOGLE_KUBERNETES_ENGINE, "gcp_kubernetes_engine");

  private static final AtomicLong uidSuffix = new AtomicLong(0);

  public abstract String getUid();

  /** The Google platform running this client. ie. gcp_compute_engine */
  public abstract String getPlatform();

  /** The Google project that the VM belongs to. */
  public abstract String getProject();

  /** The geographic region that the VM is located in. */
  public abstract String getRegion();

  /** The numeric GCE vm instance id. */
  public abstract String getHostId();

  /** The hostname of the vm or container running the client. For gke, this will be the pod name. */
  public abstract String getHostName();

  public static Builder builder() {
    return new AutoValue_EnvInfo.Builder().setUid(computeUid() + "-" + uidSuffix.getAndIncrement());
  }

  @AutoValue.Builder
  public abstract static class Builder {
    protected abstract Builder setUid(String uid);

    public abstract Builder setPlatform(String platform);

    public abstract Builder setProject(String project);

    public abstract Builder setRegion(String region);

    public abstract Builder setHostId(String hostId);

    public abstract Builder setHostName(String hostName);

    public abstract EnvInfo build();
  }

  private static String computeUid() {
    final String jvmName = ManagementFactory.getRuntimeMXBean().getName();
    // If jvm doesn't have the expected format, fallback to the local hostname
    if (jvmName.indexOf('@') < 1) {
      String hostname = "localhost";
      try {
        hostname = InetAddress.getLocalHost().getHostName();
      } catch (UnknownHostException e) {
        logger.log(Level.INFO, "Unable to get the hostname.", e);
      }
      // Generate a random number and use the same format "random_number@hostname".
      return "java-" + UUID.randomUUID() + "@" + hostname;
    }
    return "java-" + UUID.randomUUID() + jvmName;
  }

  public static EnvInfo detect() {
    return detect(
        GCPPlatformDetector.DEFAULT_INSTANCE.detectPlatform(),
        System::getenv,
        () -> {
          try {
            return InetAddress.getLocalHost().getHostName();
          } catch (UnknownHostException e) {
            throw new RuntimeException(e);
          }
        });
  }

  @Nullable
  static EnvInfo detect(
      DetectedPlatform detectedPlatform,
      Function<String, String> envGetter,
      Supplier<String> hostnameSupplier) {
    @Nullable
    String cloud_platform = SUPPORTED_PLATFORM_MAP.get(detectedPlatform.getSupportedPlatform());
    if (cloud_platform == null) {
      return EnvInfo.builder()
          .setPlatform("unknown")
          .setHostName(detectHostname(envGetter, hostnameSupplier))
          .setRegion("global")
          .setProject("")
          .setHostId("")
          .build();
    }

    Map<String, String> attrs = detectedPlatform.getAttributes();
    ImmutableList<String> locationKeys =
        ImmutableList.of(
            AttributeKeys.GCE_CLOUD_REGION,
            AttributeKeys.GCE_AVAILABILITY_ZONE,
            AttributeKeys.GKE_LOCATION_TYPE_REGION,
            AttributeKeys.GKE_CLUSTER_LOCATION);

    String region =
        locationKeys.stream().map(attrs::get).filter(Objects::nonNull).findFirst().orElse("global");

    // Deal with possibility of a zone. Zones are of the form us-east1-c, but we want a region
    // which, which is us-east1.
    region = Splitter.on('-').splitToStream(region).limit(2).collect(Collectors.joining("-"));

    String hostname = attrs.get(AttributeKeys.GCE_INSTANCE_NAME);
    // TODO: add support for cloud run & gae by looking at SERVERLESS_COMPUTE_NAME & GAE_MODULE_NAME
    if (hostname == null) {
      hostname = detectHostname(envGetter, hostnameSupplier);
    }

    String hostId = Optional.ofNullable(attrs.get(AttributeKeys.GCE_INSTANCE_ID)).orElse("");

    return builder()
        .setPlatform(cloud_platform)
        .setProject(detectedPlatform.getProjectId())
        .setRegion(region)
        .setHostId(hostId)
        .setHostName(hostname)
        .build();
  }

  private static String detectHostname(
      Function<String, String> envGetter, Supplier<String> hostnameSupplier) {
    String hostname = envGetter.apply("HOSTNAME");

    if (hostname == null) {
      try {
        hostname = hostnameSupplier.get();
      } catch (RuntimeException e) {
        logger.log(Level.WARNING, "failed to detect hostname", e);
      }
    }
    if (hostname == null) {
      hostname = "";
    }
    return hostname;
  }
}
