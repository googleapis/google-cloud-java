/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.nativeimage.features.clients;

import com.google.cloud.nativeimage.features.NativeImageUtils;
import com.oracle.svm.core.annotate.AutomaticFeature;
import com.oracle.svm.core.configure.ResourcesRegistry;
import org.graalvm.nativeimage.ImageSingletons;
import org.graalvm.nativeimage.hosted.Feature;

/** Registers Spanner library classes for reflection. */
@AutomaticFeature
final class SpannerFeature implements Feature {

  private static final String SPANNER_CLASS = "com.google.spanner.v1.SpannerGrpc";
  private static final String SPANNER_TEST_CLASS = "com.google.cloud.spanner.GceTestEnvConfig";

  @Override
  public void beforeAnalysis(BeforeAnalysisAccess access) {
    Class<?> spannerTestClass = access.findClassByName(SPANNER_TEST_CLASS);
    if (spannerTestClass != null) {
      NativeImageUtils.registerConstructorsForReflection(access, SPANNER_TEST_CLASS);
    }
    Class<?> spannerClass = access.findClassByName(SPANNER_CLASS);
    if (spannerClass != null) {
      NativeImageUtils.registerClassHierarchyForReflection(
          access, "com.google.spanner.admin.database.v1.Database");
      NativeImageUtils.registerClassHierarchyForReflection(
          access, "com.google.spanner.admin.instance.v1.Instance");
      NativeImageUtils.registerClassForReflection(
          access, "com.google.spanner.admin.database.v1.RestoreInfo");

      // Resources
      ResourcesRegistry resourcesRegistry = ImageSingletons.lookup(ResourcesRegistry.class);
      resourcesRegistry.addResources(
          "\\Qcom/google/cloud/spanner/connection/ClientSideStatements.json\\E");
      resourcesRegistry.addResources(
          "\\Qcom/google/cloud/spanner/spi/v1/grpc-gcp-apiconfig.json\\E");
    }
  }
}
