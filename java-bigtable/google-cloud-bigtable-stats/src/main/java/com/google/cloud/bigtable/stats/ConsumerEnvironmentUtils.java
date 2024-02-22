/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigtable.stats;

import com.google.common.annotations.VisibleForTesting;
import io.opencensus.contrib.resource.util.CloudResource;
import io.opencensus.contrib.resource.util.ContainerResource;
import io.opencensus.contrib.resource.util.HostResource;
import io.opencensus.contrib.resource.util.ResourceUtils;
import io.opencensus.resource.Resource;
import java.util.Objects;

/** A class for extracting details about consumer environments (GCE and GKE) for metrics. */
class ConsumerEnvironmentUtils {

  private static ResourceUtilsWrapper resourceUtilsWrapper = new ResourceUtilsWrapper();

  @VisibleForTesting
  public static void setResourceUtilsWrapper(ResourceUtilsWrapper newResourceUtilsWrapper) {
    resourceUtilsWrapper = newResourceUtilsWrapper;
  }

  public static boolean isEnvGce() {
    Resource resource = resourceUtilsWrapper.detectOpenCensusResource();
    return Objects.equals(resource.getType(), HostResource.TYPE)
        && Objects.equals(
            resource.getLabels().get(CloudResource.PROVIDER_KEY), CloudResource.PROVIDER_GCP);
  }

  public static boolean isEnvGke() {
    Resource resource = resourceUtilsWrapper.detectOpenCensusResource();
    return Objects.equals(resource.getType(), ContainerResource.TYPE)
        && Objects.equals(
            resource.getLabels().get(CloudResource.PROVIDER_KEY), CloudResource.PROVIDER_GCP);
  }

  // We wrap the static ResourceUtils.detectResource() method in a non-static method for mocking.
  @VisibleForTesting
  public static class ResourceUtilsWrapper {
    public Resource detectOpenCensusResource() {
      return ResourceUtils.detectResource();
    }
  }
}
