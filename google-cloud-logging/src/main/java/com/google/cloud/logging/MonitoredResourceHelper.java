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
import com.google.common.base.Strings;
import com.google.cloud.MonitoredResource;
import java.util.List;

class MonitoredResourceHelper {

  private static final String defaultResourceType = "global";

  private static void addResourceLabels(String resourceType,
      MonitoredResource.Builder resourceBuilder) {
    String[] labels;
    switch (resourceType) {
      case "gae_app_flex":
        labels = new String[]{"module_id", "version_id", "zone", "instance_id"};
        break;
      case "gae_app_standard":
        labels = new String[]{"module_id", "version_id"};
        break;
      case "container":
        labels = new String[]{"cluster_name", "zone"};
        break;
      case "gce_instance":
        labels = new String[]{"instance_id", "zone"};
        break;
      default:
        labels = new String[]{};
    }
    for (String label : labels) {
      addLabel(resourceBuilder, label);
    }
  }


  /* Return a self-configured monitored resource.
   */
  static MonitoredResource getResource(String projectId, String resourceType) {
    if (Strings.isNullOrEmpty(resourceType)) {
      resourceType = getAutoDetectedResourceType();
    }
    // Currently, "gae_app" is the supported logging resource type, but we distinguish
    // between "gae_app_flex", "gae_app_standard" to support zone id, instance id logging on flex VMs.
    // This method trims "gae_app_flex", "gae_app_standard" to "gae_app"
    String resourceName = (resourceType.startsWith("gae_app")) ? "gae_app" : resourceType;

    MonitoredResource.Builder builder = com.google.cloud.MonitoredResource
        .newBuilder(resourceName)
        .addLabel("project_id", projectId);
    addResourceLabels(resourceType, builder);
    return builder.build();
  }

  /* Detect monitored resource type using environment variables, else return default
   */
  private static String getAutoDetectedResourceType() {
    if (System.getenv("GAE_INSTANCE") != null) {
      return "gae_app_flex";
    }
    if (System.getenv("KUBERNETES_SERVICE_HOST") != null) {
      return "container";
    }
    if (System.getenv("GAE_MODULE") != null) {
      return "gae_app_standard";
    }
    if (MetadataConfig.getInstanceId() != null) {
      return "gce_instance";
    }
    return defaultResourceType;
  }

  protected static List<Enhancer> getResourceEnhancers() {
    String resourceType = getAutoDetectedResourceType();
    return EnhancerFactory.getEnhancers(resourceType);
  }

  private static void addLabel(MonitoredResource.Builder resourceBuilder, String name) {
    String value;
    switch (name) {
      case "module_id":
        value = getAppEngineModuleId();
        break;
      case "version_id":
        value = getAppEngineVersionId();
        break;
      case "instance_name":
        value = getAppEngineInstanceName();
        break;
      case "zone":
        value = MetadataConfig.getZone();
        break;
      case "instance_id":
        value = MetadataConfig.getInstanceId();
        break;
      case "cluster_name":
        value = MetadataConfig.getClusterName();
      default: value = null;
    }
    if (value != null) {
      resourceBuilder.addLabel(name, value);
    }
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
}
