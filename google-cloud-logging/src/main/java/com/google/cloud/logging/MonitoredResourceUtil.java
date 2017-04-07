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

import java.util.*;

abstract class MonitoredResourceUtil {

  private enum Label {
    app_id, cluster_name, instance_id, instance_name, module_id, project_id, version_id, zone
  }

  private enum Resource {
    container, gae_app_flex, gae_app_standard, gce_instance, global
  }

  private static Map<String, Label[]> resourceTypeWithLabels;
  static {
      Map<String, Label[]> map = new HashMap<>();
      addToMap(map, Resource.gae_app_flex,
              new Label[] {
              Label.instance_name, Label.module_id, Label.version_id, Label.instance_id, Label.zone
      });
      addToMap(map, Resource.gae_app_standard,
              new Label[] {
                      Label.app_id, Label.module_id, Label.version_id
      });
      addToMap(map, Resource.container,
              new Label[] {
              Label.cluster_name, Label.zone
      });
      addToMap(map, Resource.gce_instance,
              new Label[] {
              Label.instance_id, Label.zone
      });
      resourceTypeWithLabels = Collections.unmodifiableMap(map);
  }

  private static void addResourceLabels(String resourceType, MonitoredResource.Builder resourceBuilder) {
    Label[] resourceLabels = resourceTypeWithLabels.get(resourceType);
    if (resourceLabels != null) {
      for (Label Label : resourceLabels) {
        addLabel(resourceBuilder, Label);
      }
    }
  }

  /* Return a self-configured monitored Resource.
   */
  static MonitoredResource getResource(String projectId, String resourceType) {
    if (Strings.isNullOrEmpty(resourceType)) {
      Resource detectedResourceType = getAutoDetectedResourceType();
      resourceType = detectedResourceType.name();
    }
    // Currently, "gae_app" is the supported logging Resource type, but we distinguish
    // between "gae_app_flex", "gae_app_standard" to support zone id, instance id logging on flex VMs.
    // This method trims "gae_app_flex", "gae_app_standard" to "gae_app"
    String resourceName = resourceType.startsWith("gae_app") ? "gae_app" : resourceType;
    MonitoredResource.Builder builder =
        MonitoredResource.newBuilder(resourceName).addLabel(
                Label.project_id.name(), projectId);
    addResourceLabels(resourceType, builder);
    return builder.build();
  }

  /* Detect monitored Resource type using environment variables, else return global as default
   */
  private static Resource getAutoDetectedResourceType() {
    if (System.getenv("GAE_INSTANCE") != null) {
      return Resource.gae_app_flex;
    }
    if (System.getenv("KUBERNETES_SERVICE_HOST") != null) {
      return Resource.container;
    }
    if (ServiceOptions.getAppEngineAppId() != null) {
      return Resource.gae_app_standard;
    }
    if (MetadataConfig.getInstanceId() != null) {
      return Resource.gce_instance;
    }
    // default Resource type
    return Resource.global;
  }

  protected static List<LoggingEnhancer> getResourceEnhancers() {
    Resource resourceType = getAutoDetectedResourceType();
    return LoggingEnhancerFactory.getEnhancers(resourceType.name());
  }

  private static void addLabel(MonitoredResource.Builder resourceBuilder, Label label) {
    String value;
    switch (label) {
      case app_id:
        value = ServiceOptions.getAppEngineAppId();
        break;
      case cluster_name:
        value = MetadataConfig.getClusterName();
        break;
      case instance_id:
        value = MetadataConfig.getInstanceId();
        break;
      case instance_name:
        value = getAppEngineInstanceName();
        break;
      case module_id:
        value = getAppEngineModuleId();
        break;
      case version_id:
        value = getAppEngineVersionId();
        break;
      case zone:
        value = MetadataConfig.getZone();
        break;
      default:
        value = null;
        break;
    }
    if (value != null) {
      resourceBuilder.addLabel(label.name(), value);
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

  private static void addToMap(Map<String, Label[]> map, Resource Resource, Label[] labels) {
    map.put(Resource.name(), labels);
  }
}
