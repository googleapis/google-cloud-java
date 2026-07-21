/*
 * Copyright 2026 Google LLC
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
import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.base.Supplier;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.contrib.gcp.resource.GCPResourceProvider;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
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

  private static final AtomicLong uidSuffix = new AtomicLong(0);

  private static final GCPResourceProvider gcpResourceProvider = new GCPResourceProvider();

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
    public abstract Builder setUid(String uid);

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
        gcpResourceProvider.getAttributes(),
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
      Attributes detectedAttributes,
      Function<String, String> envGetter,
      Supplier<String> hostnameSupplier) {
    @Nullable
    String cloud_platform = detectedAttributes.get(AttributeKey.stringKey("cloud.platform"));
    if (cloud_platform == null) {
      return EnvInfo.builder()
          .setPlatform("unknown")
          .setHostName(detectHostname(envGetter, hostnameSupplier))
          .setRegion("global")
          .setProject("")
          .setHostId("")
          .build();
    }

    // All platform except GKE uses "cloud.region" for region attribute.
    // GKE could either use "cloud.region" or "cloud.availability_zone" for region attribute.
    String region = detectedAttributes.get(AttributeKey.stringKey("cloud.region"));
    String gkeZonalClusterLocation =
        detectedAttributes.get(AttributeKey.stringKey("cloud.availability_zone"));
    if (region == null && gkeZonalClusterLocation != null) {
      region = gkeZonalClusterLocation;
    }
    region = region == null ? "global" : region;

    // Deal with possibility of a zone. Zones are of the form us-east1-c, but we want a region
    // which, which is us-east1.
    region = Splitter.on('-').splitToStream(region).limit(2).collect(Collectors.joining("-"));

    String hostname = detectedAttributes.get(AttributeKey.stringKey("host.name"));

    // TODO: add support for cloud run & gae by looking at SERVERLESS_COMPUTE_NAME & GAE_MODULE_NAME
    if (hostname == null) {
      hostname = detectHostname(envGetter, hostnameSupplier);
    }

    String hostId =
        Optional.ofNullable(detectedAttributes.get(AttributeKey.stringKey("host.id"))).orElse("");

    return builder()
        .setPlatform(cloud_platform)
        .setProject(detectedAttributes.get(AttributeKey.stringKey("cloud.account.id")))
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
