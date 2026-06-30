/*
 * Copyright 2022 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.api.gax.nativeimage;

import static com.google.api.gax.nativeimage.NativeImageUtils.registerClassForReflection;

import org.graalvm.nativeimage.hosted.Feature;

/** Configures Native Image settings for the Google JSON Client. */
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
