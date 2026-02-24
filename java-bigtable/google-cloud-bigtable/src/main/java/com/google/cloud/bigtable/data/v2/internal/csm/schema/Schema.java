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

package com.google.cloud.bigtable.data.v2.internal.csm.schema;

import com.google.api.MonitoredResource;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.EnvInfo;
import com.google.common.collect.ImmutableList;
import com.google.monitoring.v3.ProjectName;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public abstract class Schema {
  private final String name;
  private final List<AttributeKey<?>> resourceKeys;
  private final List<DeferredAttr> deferredAttrs;

  Schema(String name, List<AttributeKey<?>> resourceKeys) {
    this(name, resourceKeys, ImmutableList.of());
  }

  Schema(String name, List<AttributeKey<?>> resourceKeys, List<DeferredAttr> deferredAttrs) {
    this.name = name;
    this.resourceKeys = resourceKeys;
    this.deferredAttrs = deferredAttrs;
  }

  public List<AttributeKey<?>> getResourceKeys() {
    return resourceKeys;
  }

  public abstract ProjectName extractProjectName(
      Attributes attrs, EnvInfo envInfo, ClientInfo clientInfo);

  public MonitoredResource extractMonitoredResource(
      Attributes attrs, EnvInfo envInfo, ClientInfo clientInfo) {
    MonitoredResource.Builder builder = MonitoredResource.newBuilder().setType(name);

    for (AttributeKey<?> key : resourceKeys) {
      Object value = attrs.get(key);
      if (value != null) {
        builder.putLabels(key.getKey(), value.toString());
      }
    }
    for (DeferredAttr a : deferredAttrs) {
      builder.putLabels(a.getKey().getKey(), a.getValue(envInfo, clientInfo));
    }
    return builder.build();
  }

  public String getName() {
    return name;
  }

  static class DeferredAttr {
    private final AttributeKey<String> name;
    private BiFunction<EnvInfo, ClientInfo, String> extractor;

    static DeferredAttr fromEnv(String name, Function<EnvInfo, String> envExtractor) {
      return new DeferredAttr(
          AttributeKey.stringKey(name), (envInfo, ignored) -> envExtractor.apply(envInfo));
    }

    static DeferredAttr fromClientInfo(String name, Function<ClientInfo, String> envExtractor) {
      return new DeferredAttr(
          AttributeKey.stringKey(name), (ignored, clientInfo) -> envExtractor.apply(clientInfo));
    }

    private DeferredAttr(
        AttributeKey<String> name, BiFunction<EnvInfo, ClientInfo, String> extractor) {
      this.name = name;
      this.extractor = extractor;
    }

    AttributeKey<String> getKey() {
      return name;
    }

    String getValue(EnvInfo envInfo, ClientInfo clientInfo) {
      return extractor.apply(envInfo, clientInfo);
    }
  }
}
