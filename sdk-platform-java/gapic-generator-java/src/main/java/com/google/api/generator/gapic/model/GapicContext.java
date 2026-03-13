// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.generator.gapic.model;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gapic.metadata.GapicMetadata;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

@AutoValue
public abstract class GapicContext {
  // Keep a non-AutoValue reference to GapicMetadata, since we need to update
  // it iteratively as we generate client methods.
  private GapicMetadata gapicMetadata = defaultGapicMetadata();

  public static final GapicContext EMPTY =
      builder()
          .setServices(Collections.emptyList())
          .setMessages(Collections.emptyMap())
          .setServiceConfig(GapicServiceConfig.create(Optional.empty()))
          .setResourceNames(Collections.emptyMap())
          .setHelperResourceNames(Collections.emptySet())
          .setTransport(Transport.GRPC)
          .build();

  // Maps the message name (as it appears in the protobuf) to Messages.
  public abstract ImmutableMap<String, Message> messages();

  // Maps the resource type string to ResourceNames.
  public abstract ImmutableMap<String, ResourceName> resourceNames();

  public abstract ImmutableList<Service> services();

  // Ensures ordering for deterministic tests.
  public abstract ImmutableList<Service> mixinServices();

  public abstract ImmutableMap<String, ResourceName> helperResourceNames();

  public abstract boolean gapicMetadataEnabled();

  public abstract boolean restNumericEnumsEnabled();

  public GapicMetadata gapicMetadata() {
    return gapicMetadata;
  }

  @Nullable
  public abstract GapicServiceConfig serviceConfig();

  @Nullable
  public abstract com.google.api.Service serviceYamlProto();

  @Nullable
  public abstract String repo();

  @Nullable
  public abstract String artifact();

  public boolean containsServices() {
    return !services().isEmpty();
  }

  public boolean hasServiceYamlProto() {
    return serviceYamlProto() != null;
  }

  public void updateGapicMetadata(GapicMetadata newMetadata) {
    gapicMetadata = newMetadata;
  }

  static GapicMetadata defaultGapicMetadata() {
    return GapicMetadata.newBuilder()
        .setSchema("1.0")
        .setComment(
            "This file maps proto services/RPCs to the corresponding library clients/methods")
        .setLanguage("java")
        .build();
  }

  public abstract Builder toBuilder();

  public abstract Transport transport();

  public static Builder builder() {
    return new AutoValue_GapicContext.Builder()
        .setMixinServices(Collections.emptyList())
        .setGapicMetadataEnabled(false)
        .setRestNumericEnumsEnabled(false);
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setMessages(Map<String, Message> messages);

    public abstract Builder setResourceNames(Map<String, ResourceName> resourceNames);

    public abstract Builder setServices(List<Service> services);

    public abstract Builder setMixinServices(List<Service> mixinServices);

    public Builder setHelperResourceNames(Set<ResourceName> helperResourceNames) {
      return setHelperResourceNames(
          helperResourceNames.stream()
              .collect(Collectors.toMap(r -> r.resourceTypeString(), r -> r)));
    }

    abstract Builder setHelperResourceNames(Map<String, ResourceName> helperResourceNames);

    public abstract Builder setServiceConfig(GapicServiceConfig serviceConfig);

    public abstract Builder setServiceYamlProto(com.google.api.Service serviceYamlProto);

    public abstract Builder setGapicMetadataEnabled(boolean gapicMetadataEnabled);

    public abstract Builder setRestNumericEnumsEnabled(boolean restNumericEnumsEnabled);

    public abstract Builder setTransport(Transport transport);

    public abstract Builder setRepo(String repo);

    public abstract Builder setArtifact(String artifact);

    abstract ImmutableMap<String, ResourceName> resourceNames();

    abstract ImmutableMap<String, ResourceName> helperResourceNames();

    abstract GapicContext autoBuild();

    public GapicContext build() {
      setResourceNames(new TreeMap<>(resourceNames()));
      setHelperResourceNames(new TreeMap<>(helperResourceNames()));
      return autoBuild();
    }
  }
}
