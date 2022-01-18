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

package com.google.cloud.nativeimage.features;

import static com.google.cloud.nativeimage.features.NativeImageUtils.registerClassForReflection;

import com.oracle.svm.core.annotate.AutomaticFeature;
import com.oracle.svm.core.configure.ResourcesRegistry;
import org.graalvm.nativeimage.ImageSingletons;
import org.graalvm.nativeimage.hosted.Feature;

/** Configures Native Image settings for the Google JSON Client. */
@AutomaticFeature
final class GoogleJsonClientFeature implements Feature {

  private static final String GOOGLE_API_CLIENT_CLASS =
      "com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient";

  private static final String GOOGLE_API_CLIENT_REQUEST_CLASS =
      "com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest";

  private static final String GENERIC_JSON_CLASS = "com.google.api.client.json.GenericJson";

  @Override
  public void beforeAnalysis(BeforeAnalysisAccess access) {
    loadApiClient(access);
    loadHttpClient(access);
    loadMiscClasses(access);
  }

  private void loadApiClient(BeforeAnalysisAccess access) {
    // For com.google.api-client:google-api-client
    Class<?> googleApiClientClass = access.findClassByName(GOOGLE_API_CLIENT_CLASS);

    if (googleApiClientClass != null) {
      // All reachable instances of the AbstractGoogleJsonClient must be registered.
      access.registerSubtypeReachabilityHandler(
          (duringAccess, subtype) -> registerClassForReflection(access, subtype.getName()),
          googleApiClientClass);

      // All reachable instances of the AbstractGoogleJsonClientRequest must be registered.
      access.registerSubtypeReachabilityHandler(
          (duringAccess, subtype) -> registerClassForReflection(access, subtype.getName()),
          access.findClassByName(GOOGLE_API_CLIENT_REQUEST_CLASS));

      // Resources
      ResourcesRegistry resourcesRegistry = ImageSingletons.lookup(ResourcesRegistry.class);
      resourcesRegistry.addResources(
          "\\Qcom/google/api/client/googleapis/google-api-client.properties\\E");
      resourcesRegistry.addResources("\\Qcom/google/api/client/googleapis/google.p12\\E");
      resourcesRegistry.addResources(
          "\\Qcom/google/api/client/http/google-http-client.properties\\E");
    }
  }

  private void loadHttpClient(BeforeAnalysisAccess access) {
    // For com.google.http-client:google-http-client
    Class<?> genericJsonClass = access.findClassByName(GENERIC_JSON_CLASS);

    if (genericJsonClass != null) {
      // All reachable instances of GenericJson must be registered.
      access.registerSubtypeReachabilityHandler(
          (duringAccess, subtype) -> registerClassForReflection(access, subtype.getName()),
          genericJsonClass);

      registerClassForReflection(access, "com.google.api.client.util.GenericData");
      registerClassForReflection(access, "com.google.api.client.json.webtoken.JsonWebToken");
      registerClassForReflection(access, "com.google.api.client.json.webtoken.JsonWebToken$Header");
      registerClassForReflection(
          access, "com.google.api.client.json.webtoken.JsonWebToken$Payload");
      registerClassForReflection(
          access, "com.google.api.client.json.webtoken.JsonWebSignature$Header");
      registerClassForReflection(access, "com.google.api.client.json.webtoken.JsonWebSignature");
      registerClassForReflection(access, "com.google.api.client.http.UrlEncodedContent");
      registerClassForReflection(access, "com.google.api.client.http.GenericUrl");
      registerClassForReflection(access, "com.google.api.client.http.HttpRequest");
      registerClassForReflection(access, "com.google.api.client.http.HttpHeaders");
    }
  }

  private void loadMiscClasses(BeforeAnalysisAccess access) {
    registerClassForReflection(access, "com.google.common.util.concurrent.AbstractFuture");
    registerClassForReflection(access, "com.google.common.util.concurrent.AbstractFuture$Waiter");
  }
}
