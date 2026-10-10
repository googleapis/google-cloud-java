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

import static com.google.api.gax.nativeimage.NativeImageUtils.registerClassForJni;
import static com.google.api.gax.nativeimage.NativeImageUtils.registerClassForReflection;
import static com.google.api.gax.nativeimage.NativeImageUtils.registerClassHierarchyForJni;
import static com.google.api.gax.nativeimage.NativeImageUtils.registerClassHierarchyForReflection;

import org.graalvm.nativeimage.hosted.Feature;
import org.jspecify.annotations.NullMarked;

/** Configures Native Image settings for the Google JSON Client. */
@NullMarked
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
    loadConscrypt(access);
    loadMiscClasses(access);
  }

  /**
   * Registers Conscrypt SSLContext and Security Provider SPI implementation classes (and their
   * nested protocol subclasses) for GraalVM reflection, as well as Conscrypt native JNI classes and
   * native C shared library resources when Conscrypt is present on the classpath.
   *
   * <p>When Conscrypt is configured as the security provider for HTTP/JSON transports, Java's JCA
   * framework reflectively instantiates provider implementation classes (e.g. {@code
   * OpenSSLContextImpl$TLSv13}) via String lookup in {@code SSLContext.getInstance("TLS",
   * provider)}. In GraalVM Native Image builds, these reflectively looked-up SPI classes are
   * stripped by static analysis unless explicitly registered for reflection, leading to {@code
   * ClassNotFoundException} / {@code NoSuchAlgorithmException} at runtime. Additionally, native JNI
   * methods and JDK classes accessed by Conscrypt's native C library must be registered for GraalVM
   * JNI linkage.
   */
  private void loadConscrypt(BeforeAnalysisAccess access) {
    Class<?> conscryptClass = access.findClassByName("org.conscrypt.Conscrypt");
    if (conscryptClass != null) {
      registerClassHierarchyForReflection(access, "org.conscrypt.OpenSSLContextImpl");
      registerClassHierarchyForReflection(access, "org.conscrypt.OpenSSLProvider");
      registerClassHierarchyForReflection(access, "org.conscrypt.KeyManagerFactoryImpl");
      registerClassHierarchyForReflection(access, "org.conscrypt.TrustManagerFactoryImpl");

      // Register Conscrypt native JNI bridge classes and hierarchy
      registerClassHierarchyForReflection(access, "org.conscrypt.NativeCrypto");
      registerClassHierarchyForReflection(access, "org.conscrypt.NativeCryptoJni");
      registerClassHierarchyForReflection(access, "org.conscrypt.CryptoUpcalls");
      registerClassHierarchyForReflection(access, "org.conscrypt.NativeRef");
      registerClassHierarchyForReflection(access, "org.conscrypt.OpenSSLBIOInputStream");

      registerClassHierarchyForJni(access, "org.conscrypt.NativeCrypto");
      registerClassHierarchyForJni(access, "org.conscrypt.NativeCryptoJni");
      registerClassHierarchyForJni(access, "org.conscrypt.CryptoUpcalls");
      registerClassHierarchyForJni(access, "org.conscrypt.NativeRef");
      registerClassHierarchyForJni(access, "org.conscrypt.OpenSSLBIOInputStream");

      // Register array types and JDK classes accessed via JNI by Conscrypt native C code
      registerClassForJni(Object[].class);
      registerClassForJni(byte[].class);
      registerClassForJni(byte[][].class);
      registerClassForJni(int[].class);

      registerClassHierarchyForJni(access, "java.util.Calendar");
      registerClassHierarchyForJni(access, "java.io.InputStream");
      registerClassHierarchyForJni(access, "java.io.OutputStream");
      registerClassHierarchyForJni(access, "java.io.FileDescriptor");
      registerClassHierarchyForJni(access, "java.lang.Integer");
      registerClassHierarchyForJni(access, "java.lang.String");
      registerClassHierarchyForJni(access, "java.lang.Object");
      registerClassHierarchyForJni(access, "java.nio.Buffer");
      registerClassHierarchyForJni(access, "java.nio.ByteBuffer");
      registerClassHierarchyForJni(access, "java.security.PrivateKey");
      registerClassHierarchyForJni(access, "java.security.Key");
    }
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
