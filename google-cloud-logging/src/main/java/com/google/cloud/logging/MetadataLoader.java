/*
 * Copyright 2021 Google LLC
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

import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.cloud.logging.MonitoredResourceUtil.Label;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Supplier;

public final class MetadataLoader {
  public static final String ENV_FLEXIBLE = "flex";
  public static final String ENV_STANDARD = "standard";

  private final ResourceTypeEnvironmentGetter getter;

  private final ImmutableMap<Label, Supplier<String>> labelResolvers =
      ImmutableMap.<Label, Supplier<String>>builder()
          .put(Label.ClusterName, this::getClusterName)
          .put(Label.ConfigurationName, this::getConfigName)
          .put(Label.ContainerName, this::getContainerName)
          .put(Label.Env, this::getEnv)
          .put(Label.FunctionName, this::getFunctionName)
          .put(Label.InstanceId, this::getInstanceId)
          .put(Label.InstanceName, this::getInstanceName)
          .put(Label.CloudRunLocation, this::getCloudRunLocation)
          .put(Label.GKELocation, this::getGKELocation)
          .put(Label.ModuleId, this::getModuleId)
          .put(Label.NamespaceName, this::getNamespaceName)
          .put(Label.PodName, this::getPodName)
          .put(Label.ProjectId, this::getProjectId)
          .put(Label.Region, this::getRegion)
          .put(Label.RevisionName, this::getRevisionName)
          .put(Label.ServiceName, this::getServiceName)
          .put(Label.VersionId, this::getVersionId)
          .put(Label.Zone, this::getZone)
          .buildOrThrow();

  public MetadataLoader(ResourceTypeEnvironmentGetter getter) {
    this.getter = getter;
  }

  /**
   * Loads metadata value for the {@code label} argument.
   *
   * @param label A resource metadata label of type {@see MonitoredResourceUtil.Label}
   * @return A string with metadata value or {@code null} if the label is not supported.
   */
  public String getValue(MonitoredResourceUtil.Label label) {
    Supplier<String> lambda = labelResolvers.get(label);
    if (lambda != null) {
      return lambda.get();
    }
    return null;
  }

  private String getClusterName() {
    return getter.getAttribute("instance/attributes/cluster-name");
  }

  private String getConfigName() {
    return getter.getEnv("K_CONFIGURATION");
  }

  // due to lack of options to discover container name from within process
  // allow users to provide the container name via environment variable
  private String getContainerName() {
    return getter.getEnv("CONTAINER_NAME");
  }
  /**
   * Distinguish between Standard and Flexible GAE environments. There is no indicator of the
   * environment. The path to the startup-script in the metadata attribute was selected as one of
   * the new values that explicitly mentioning "flex" and cannot be altered by user (e.g.
   * environment variable). The method assumes that the resource type is already identified as
   * {@link Resource.AppEngine}.
   *
   * @return {@link MetadataLoader.ENV_FLEXIBLE} for the Flexible environment and {@link
   *     MetadataLoader.ENV_STANDARD} for the Standard environment.
   */
  private String getEnv() {
    String value = getter.getAttribute("instance/attributes/startup-script");
    if ("/var/lib/flex/startup_script.sh".equals(value)) {
      return ENV_FLEXIBLE;
    }
    return ENV_STANDARD;
  }

  private String getFunctionName() {
    String value = getter.getEnv("K_SERVICE");
    if (value == null) {
      // keep supporting custom function name if is not provided by default
      // for backward compatibility only; reconsider removing it after Gen2
      // environment is enrolled for Cloud Function
      value = getter.getEnv("FUNCTION_NAME");
    }
    return value;
  }

  private String getInstanceId() {
    return getter.getAttribute("instance/id");
  }

  private String getInstanceName() {
    return getter.getAttribute("instance/name");
  }

  private String getCloudRunLocation() {
    return getRegion();
  }

  private String getGKELocation() {
    return getZone();
  }

  private String getModuleId() {
    return getter.getEnv("GAE_SERVICE");
  }
  /**
   * Heuristic to discover the namespace name of the current environment. There is no deterministic
   * way to discover the namespace name of the process. The name is read from the {@link
   * K8S_POD_NAMESPACE_PATH} when available or read from a user defined environment variable
   * "NAMESPACE_NAME"
   *
   * @return Namespace string or null if the name could not be discovered
   */
  private String getNamespaceName() {
    String value = null;
    try {
      value =
          new String(
              Files.readAllBytes(
                  Paths.get("/var/run/secrets/kubernetes.io/serviceaccount/namespace")),
              UTF_8);
    } catch (IOException e) {
      // if SA token is not shared the info about namespace is unavailable
      // allow users to define the namespace name explicitly
      value = getter.getEnv("NAMESPACE_NAME");
    }
    return value;
  }
  // Kubernetes set hostname of the pod to the pod name by default, however hostname can be override
  // in manifest
  // allow users to provide the container name via environment variable
  private String getPodName() {
    String value = getter.getEnv("POD_NAME");
    if (value != null) {
      return value;
    }
    return getter.getEnv("HOSTNAME");
  }

  private String getProjectId() {
    return getter.getAttribute("project/project-id");
  }
  /**
   * Retrieves a region from the qualified region of 'projects/[PROJECT_NUMBER]/regions/[REGION]'
   *
   * @return region string id
   */
  private String getRegion() {
    String loc = getter.getAttribute("instance/region");
    if (loc != null) {
      return loc.substring(loc.lastIndexOf('/') + 1);
    }
    return null;
  }

  private String getRevisionName() {
    return getter.getEnv("K_REVISION");
  }

  private String getServiceName() {
    return getter.getEnv("K_SERVICE");
  }

  private String getVersionId() {
    return getter.getEnv("GAE_VERSION");
  }
  /**
   * Retrieves a zone from the qualified zone of 'projects/[PROJECT_NUMBER]/zones/[ZONE]'
   *
   * @return zone string id
   */
  private String getZone() {
    String loc = getter.getAttribute("instance/zone");
    if (loc != null) {
      return loc.substring(loc.lastIndexOf('/') + 1);
    }
    return null;
  }
}
