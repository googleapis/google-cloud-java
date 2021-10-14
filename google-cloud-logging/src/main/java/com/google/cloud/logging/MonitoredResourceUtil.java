/*
 * Copyright 2017 Google LLC
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

import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.LogEntry.Builder;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMultimap;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Monitored resource construction utilities to detect resource type and add labels. Used by logging
 * framework adapters to configure default resource. See usage in {@link LoggingHandler}.
 */
public class MonitoredResourceUtil {

  private static final String APPENGINE_LABEL_PREFIX = "appengine.googleapis.com/";
  private static final String CLUSTER_NAME_ATTRIBUTE = "instance/attributes/cluster-name";
  private static final String K8S_POD_NAMESPACE_PATH =
      "/var/run/secrets/kubernetes.io/serviceaccount/namespace";
  private static final String FLEX_ENV = "flex";
  private static final String STD_ENV = "standard";

  private enum Label {
    ClusterName("cluster_name"),
    ConfigurationName("configuration_name"),
    ContainerName("container_name"),
    Env("env"),
    FunctionName("function_name"),
    InstanceId("instance_id"),
    InstanceName("instance_name"),
    Location("location"),
    ModuleId("module_id"),
    NamespaceName("namespace_name"),
    PodName("pod_name"),
    ProjectId("project_id"),
    Region("region"),
    RevisionName("revision_name"),
    ServiceName("service_name"),
    VersionId("version_id"),
    Zone("zone");

    private final String key;

    Label(String key) {
      this.key = key;
    }

    String getKey() {
      return key;
    }
  }

  private enum Resource {
    CloudRun("cloud_run_revision"),
    CloudFunction("cloud_function"),
    AppEngine("gae_app"),
    GceInstance("gce_instance"),
    K8sContainer("k8s_container"),
    Global("global");

    private final String key;

    Resource(String key) {
      this.key = key;
    }

    String getKey() {
      return key;
    }
  }

  private static ImmutableMultimap<String, Label> resourceTypeWithLabels =
      ImmutableMultimap.<String, Label>builder()
          .putAll(Resource.CloudFunction.getKey(), Label.FunctionName, Label.Region)
          .putAll(
              Resource.CloudRun.getKey(),
              Label.RevisionName,
              Label.ServiceName,
              Label.Location,
              Label.ConfigurationName)
          .putAll(
              Resource.AppEngine.getKey(), Label.ModuleId, Label.VersionId, Label.Zone, Label.Env)
          .putAll(Resource.GceInstance.getKey(), Label.InstanceId, Label.Zone)
          .putAll(
              Resource.K8sContainer.getKey(),
              Label.Location,
              Label.ClusterName,
              Label.NamespaceName,
              Label.PodName,
              Label.ContainerName)
          .build();

  private static Map<String, MonitoredResource> cachedMonitoredResources = new HashMap<>();
  private static ResourceTypeEnvironmentGetter getter = new ResourceTypeEnvironmentGetterImpl();

  private MonitoredResourceUtil() {}

  /**
   * Method is intended to assist in testing <code>MonitoredResourceUtil</code> class only.
   *
   * @param getter A mocked environment getter for simulated test environments.
   */
  protected static void setEnvironmentGetter(ResourceTypeEnvironmentGetter getter) {
    MonitoredResourceUtil.getter = getter;
  }

  /**
   * Build {@link MonitoredResource} based on detected resource type and populate it with labels
   * following Monitored Resource Types documentation.
   *
   * @param projectId A string defining the project id
   * @param resourceType A custom resource type
   * @return the created {@link MonitoredResource}
   * @see <a href="https://cloud.google.com/monitoring/api/resources">Monitored resource Types</a>
   */
  public static MonitoredResource getResource(String projectId, String resourceType) {
    if (projectId == null || projectId.trim().isEmpty()) {
      projectId = getter.getAttribute("project/project-id");
    }

    MonitoredResource result = cachedMonitoredResources.get(projectId + "/" + resourceType);
    if (result != null) {
      return result;
    }

    if (Strings.isNullOrEmpty(resourceType)) {
      Resource detectedResourceType = detectResourceType();
      resourceType = detectedResourceType.getKey();
    }
    MonitoredResource.Builder builder =
        MonitoredResource.newBuilder(resourceType).addLabel(Label.ProjectId.getKey(), projectId);

    for (Label label : resourceTypeWithLabels.get(resourceType)) {
      String value = getValue(label, resourceType);
      if (value != null) {
        builder.addLabel(label.getKey(), value);
      }
    }
    result = builder.build();
    cachedMonitoredResources.put(projectId + "/" + resourceType, result);
    return result;
  }

  /**
   * Detect monitored Resource type using the following heuristic rules based on the environment and
   * metadata server.
   */
  private static Resource detectResourceType() {
    // expects supported Google Cloud resource to have access to metadata server
    if (getter.getAttribute("") == null) {
      return Resource.Global;
    }

    if (getter.getEnv("K_SERVICE") != null
        && getter.getEnv("K_REVISION") != null
        && getter.getEnv("K_CONFIGURATION") != null) {
      return Resource.CloudRun;
    }
    if (getter.getEnv("GAE_INSTANCE") != null
        && getter.getEnv("GAE_RUNTIME") != null
        && getter.getEnv("GAE_SERVICE") != null
        && getter.getEnv("GAE_VERSION") != null) {
      return Resource.AppEngine;
    }
    if (getter.getEnv("FUNCTION_SIGNATURE_TYPE") != null
        && getter.getEnv("FUNCTION_TARGET") != null) {
      return Resource.CloudFunction;
    }
    if (getter.getAttribute(CLUSTER_NAME_ATTRIBUTE) != null) {
      return Resource.K8sContainer;
    }
    if (getter.getAttribute("instance/preempted") != null
        && getter.getAttribute("instance/cpu-platform") != null
        && getter.getAttribute("instance/attributes/gae_app_bucket") == null) {
      return Resource.GceInstance;
    }
    // other Google Cloud resources (e.g. CloudBuild) might be misdetected
    return Resource.Global;
  }

  /**
   * Returns custom log entry enhancers (if available) for resource type.
   *
   * @return custom log entry enhancers
   */
  public static List<LoggingEnhancer> getResourceEnhancers() {
    Resource resourceType = detectResourceType();
    return createEnhancers(resourceType);
  }

  @SuppressWarnings("incomplete-switch")
  private static String getValue(Label label, String resourceType) {
    String value = "";

    switch (label) {
      case ClusterName:
        value = getter.getAttribute(CLUSTER_NAME_ATTRIBUTE);
        break;
      case ConfigurationName:
        value = getter.getEnv("K_CONFIGURATION");
        break;
      case ContainerName:
        // there is no determenistic way to discover name of container
        // allow users to define the container name explicitly
        value = getter.getEnv("CONTAINER_NAME");
        if (value == null) {
          value = "";
        }
        break;
      case Env:
        value = getAppEngineEnvironment();
        break;
      case FunctionName:
      case ServiceName:
        value = getter.getEnv("K_SERVICE");
        if (value == null) {
          value = getter.getEnv("FUNCTION_NAME");
        }
        break;
      case InstanceId:
        value = getter.getAttribute("instance/id");
        break;
      case InstanceName:
        value = getter.getAttribute("instance/name");
        break;
      case Location:
        if (Resource.CloudFunction.getKey() == resourceType
            || Resource.CloudRun.getKey() == resourceType) {
          value = getRegion();
        } else {
          value = getZone();
        }
        break;
      case ModuleId:
        value = getter.getEnv("GAE_SERVICE");
        break;
      case NamespaceName:
        value = getK8sNamespace();
        break;
      case PodName:
        // there is no determenistic way to discover name of container
        // by default the pod name is set as pod's hostname
        // note that hostname can be overriden in pod manifest or at runtime
        value = getter.getEnv("HOSTNAME");
        break;
      case Region:
        value = getRegion();
        break;
      case RevisionName:
        value = getter.getEnv("K_REVISION");
        break;
      case VersionId:
        value = getter.getEnv("GAE_VERSION");
        break;
      case Zone:
        value = getZone();
        break;
    }

    return value;
  }

  /**
   * Heuristic to discover the namespace name of the current environment. There is no determenistic
   * way to discover the namespace name of the process. The name is read from the {@link
   * K8S_POD_NAMESPACE_PATH} when available or read from a user defined environment variable
   * "NAMESPACE_NAME"
   *
   * @return Namespace name or empty string if the name could not be discovered
   */
  private static String getK8sNamespace() {
    String value = "";
    try {
      value =
          new String(Files.readAllBytes(Paths.get(K8S_POD_NAMESPACE_PATH)), StandardCharsets.UTF_8);
    } catch (IOException e) {
      // if SA token is not shared the info about namespace is unavailable
      // allow users to define the namespace name explicitly
      value = getter.getEnv("NAMESPACE_NAME");
      if (value == null) {
        value = "";
      }
    }
    return value;
  }

  /**
   * Distinguish between Standard and Flexible GAE environments. There is no indicator of the
   * environment. The path to the startup-script in the metadata attribute was selected as one of
   * the new values that explitly mentioning "flex" and cannot be altered by user (e.g. environment
   * variable). The method assumes that the resource type is already identified as {@link
   * Resource.AppEngine}.
   *
   * @return "flex" {@link String} for the Flexible environment and "standard" for the Standard.
   */
  private static String getAppEngineEnvironment() {
    String value = getter.getAttribute("instance/attributes/startup-script");
    if (value == "/var/lib/flex/startup_script.sh") {
      return FLEX_ENV;
    }
    return STD_ENV;
  }

  /**
   * Retrieves a region from the qualified region of 'projects/[PROJECT_NUMBER]/regions/[REGION]'
   *
   * @return region string id
   */
  private static String getRegion() {
    String loc = getter.getAttribute("instance/region");
    return loc.substring(loc.lastIndexOf('/') + 1);
  }

  /**
   * Retrieves a zone from the qualified zone of 'projects/[PROJECT_NUMBER]/zones/[ZONE]'
   *
   * @return zone string id
   */
  private static String getZone() {
    String loc = getter.getAttribute("instance/zone");
    return loc.substring(loc.lastIndexOf('/') + 1);
  }

  private static List<LoggingEnhancer> createEnhancers(Resource resourceType) {
    List<LoggingEnhancer> enhancers = new ArrayList<>(2);
    if (resourceType == Resource.AppEngine) {
      enhancers.add(new TraceLoggingEnhancer(APPENGINE_LABEL_PREFIX));
      if (getAppEngineEnvironment() == FLEX_ENV) {
        enhancers.add(
            new LabelLoggingEnhancer(
                APPENGINE_LABEL_PREFIX, Collections.singletonList(Label.InstanceName)));
      }
    }
    return enhancers;
  }

  /**
   * Adds additional resource-based labels to log entries. Labels that can be provided with {@link
   * MonitoredResource.Builder#addLabel(String, String)} are restricted to a supported set per
   * resource.
   *
   * @see <a href= "https://cloud.google.com/logging/docs/api/v2/resource-list">Logging Labels</a>
   */
  private static class LabelLoggingEnhancer implements LoggingEnhancer {

    private final Map<String, String> labels;

    LabelLoggingEnhancer(String prefix, List<Label> labelNames) {
      labels = new HashMap<>();
      if (labelNames != null) {
        for (Label labelName : labelNames) {
          String fullLabelName =
              (prefix != null) ? prefix + labelName.getKey() : labelName.getKey();
          String labelValue = MonitoredResourceUtil.getValue(labelName, fullLabelName);
          if (labelValue != null) {
            labels.put(fullLabelName, labelValue);
          }
        }
      }
    }

    @Override
    public void enhanceLogEntry(Builder logEntry) {
      for (Map.Entry<String, String> label : labels.entrySet()) {
        logEntry.addLabel(label.getKey(), label.getValue());
      }
    }
  }
}
