/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.logging;

import com.google.cloud.MetadataConfig;
import com.google.cloud.MonitoredResource;
import com.google.cloud.ServiceOptions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Monitored resource construction utilities to detect resource type and add labels.
 */
abstract class MonitoredResourceUtil {

  private enum Label {
    appId("app_id"),
    clusterName("cluster_name"),
    instanceId("instance_id"),
    instanceName("instance_name"),
    moduleId("module_id"),
    projectId("project_id"),
    versionId("version_id"),
    zone("zone");

    private final String key;

    Label(String key) {
      this.key = key;
    }

    String getKey() {
      return key;
    }
  }

  private enum Resource {
    container("container"),
    gaeAppFlex("gae_app_flex"),
    gaeAppStandard("gae_app_standard"),
    gceInstance("gce_instance"),
    global("global");

    private final String key;

    Resource(String key) {
      this.key = key;
    }

    String getKey() {
      return key;
    }
  }

  private static Map<String, Label[]> resourceTypeWithLabels;

  static {
    resourceTypeWithLabels =
        new ImmutableMap.Builder<String, Label[]>()
            .put(
                Resource.gaeAppFlex.getKey(),
                new Label[] {
                  Label.instanceName,
                  Label.moduleId,
                  Label.versionId,
                  Label.instanceName,
                  Label.zone
                })
            .put(
                Resource.gaeAppStandard.getKey(),
                new Label[] {Label.appId, Label.moduleId, Label.versionId})
            .put(Resource.container.getKey(), new Label[] {Label.clusterName, Label.zone})
            .put(Resource.gceInstance.getKey(), new Label[] {Label.instanceId, Label.zone})
            .build();
  }

  /* Return a self-configured monitored Resource. */
  static MonitoredResource getResource(String projectId, String resourceTypeParam) {
    String resourceType = resourceTypeParam;
    if (Strings.isNullOrEmpty(resourceType)) {
      Resource detectedResourceType = getAutoDetectedResourceType();
      resourceType = detectedResourceType.getKey();
    }
    // Currently, "gae_app" is the supported logging Resource type, but we distinguish
    // between "gae_app_flex", "gae_app_standard" to support zone id, instance name logging on flex VMs.
    // Hence, "gae_app_flex", "gae_app_standard" are trimmed to "gae_app"
    String resourceName = resourceType.startsWith("gae_app") ? "gae_app" : resourceType;
    MonitoredResource.Builder builder =
        MonitoredResource.newBuilder(resourceName).addLabel(Label.projectId.getKey(), projectId);
    Label[] resourceLabels = resourceTypeWithLabels.get(resourceType);
    if (resourceLabels != null) {
      for (Label label : resourceLabels) {
        String value = getValue(label);
        if (value != null) {
          builder.addLabel(label.getKey(), value);
        }
      }
    }
    return builder.build();
  }

  /* Detect monitored Resource type using environment variables, else return global as default. */
  private static Resource getAutoDetectedResourceType() {
    if (System.getenv("GAE_INSTANCE") != null) {
      return Resource.gaeAppFlex;
    }
    if (System.getenv("KUBERNETES_SERVICE_HOST") != null) {
      return Resource.container;
    }
    if (ServiceOptions.getAppEngineAppId() != null) {
      return Resource.gaeAppStandard;
    }
    if (MetadataConfig.getInstanceId() != null) {
      return Resource.gceInstance;
    }
    // default Resource type
    return Resource.global;
  }

  protected static List<LoggingEnhancer> getResourceEnhancers() {
    Resource resourceType = getAutoDetectedResourceType();
    return getEnhancers(resourceType);
  }

  private static String getValue(Label label) {
    String value;
    switch (label) {
      case appId:
        value = ServiceOptions.getAppEngineAppId();
        break;
      case clusterName:
        value = MetadataConfig.getClusterName();
        break;
      case instanceId:
        value = MetadataConfig.getInstanceId();
        break;
      case instanceName:
        value = getAppEngineInstanceName();
        break;
      case moduleId:
        value = getAppEngineModuleId();
        break;
      case versionId:
        value = getAppEngineVersionId();
        break;
      case zone:
        value = MetadataConfig.getZone();
        break;
      default:
        value = null;
        break;
    }
    return value;
  }

  private static String getAppEngineModuleId() {
    return System.getenv("GAE_SERVICE");
  }

  private static String getAppEngineVersionId() {
    return System.getenv("GAE_VERSION");
  }

  private static String getAppEngineInstanceName() {
    return System.getenv("GAE_INSTANCE");
  }

  private static List<LoggingEnhancer> getEnhancers(Resource resourceType) {
    List<LoggingEnhancer> enhancers;
    switch (resourceType) {
      case gaeAppFlex:
        enhancers = new ArrayList<>();
        enhancers.add(new TraceLoggingEnhancer());
        break;
      default:
        enhancers = Collections.emptyList();
        break;
    }
    return enhancers;
  }
}
