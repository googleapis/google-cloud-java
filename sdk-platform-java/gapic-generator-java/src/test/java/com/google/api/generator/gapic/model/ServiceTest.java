// Copyright 2022 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.generator.gapic.model;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.api.generator.engine.ast.TypeNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServiceTest {
  private static final String SHOWCASE_PACKAGE_NAME = "com.google.showcase.v1beta1";
  private Service.Builder testServiceBuilder;

  private static final Method.Builder testMethodBuilder =
      Method.builder()
          .setName("My method")
          .setInputType(TypeNode.STRING)
          .setOutputType(TypeNode.STRING);

  private static final HttpBindings.Builder testHttpBindingsBuilder =
      HttpBindings.builder()
          .setPathParameters(
              ImmutableSet.of(HttpBindings.HttpBinding.builder().setName("table").build()))
          .setPattern("/pattern/test")
          .setAdditionalPatterns(Arrays.asList("/extra_pattern/test", "/extra_pattern/hey"))
          .setIsAsteriskBody(false)
          .setHttpVerb(HttpBindings.HttpVerb.GET);

  @BeforeEach
  void init() {
    testServiceBuilder =
        Service.builder()
            .setName("Echo")
            .setDefaultHost("localhost:7469")
            .setOauthScopes(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"))
            .setPakkage(SHOWCASE_PACKAGE_NAME)
            .setProtoPakkage(SHOWCASE_PACKAGE_NAME)
            .setOriginalJavaPackage(SHOWCASE_PACKAGE_NAME)
            .setOverriddenName("Echo");
  }

  @Test
  void apiShortName_shouldReturnApiShortNameIfHostContainsRegionalEndpoint() {
    String defaultHost = "us-east1-pubsub.googleapis.com";
    Service testService = testServiceBuilder.setDefaultHost(defaultHost).build();
    assertEquals("pubsub", testService.apiShortName());
  }

  @Test
  void apiShortName_shouldReturnApiShortName() {
    String defaultHost = "logging.googleapis.com";
    Service testService = testServiceBuilder.setDefaultHost(defaultHost).build();
    assertEquals("logging", testService.apiShortName());
  }

  @Test
  void apiShortName_shouldReturnApiShortNameForIam() {
    String defaultHost = "iam-meta-api.googleapis.com";
    Service testService = testServiceBuilder.setDefaultHost(defaultHost).build();
    assertEquals("iam", testService.apiShortName());
  }

  @Test
  void apiShortName_shouldReturnHostIfNoPeriods() {
    String defaultHost = "logging:7469";
    Service testService = testServiceBuilder.setDefaultHost(defaultHost).build();
    assertEquals("logging:7469", testService.apiShortName());
  }

  @Test
  void packageVersion_shouldReturnVersionIfMatch() {
    String protoPackage = "com.google.showcase.v1";
    Service testService = testServiceBuilder.setProtoPakkage(protoPackage).build();
    assertEquals("v1", testService.packageVersion());
  }

  @Test
  void packageVersion_shouldReturnEmptyIfNoMatch() {
    String protoPackage = "com.google.showcase";
    Service testService = testServiceBuilder.setProtoPakkage(protoPackage).build();
    assertEquals("", testService.packageVersion());
  }

  @Test
  void apiVersion_shouldReturnApiVersion() {
    String apiVersion = "v1_20230601";
    Service testService = testServiceBuilder.setApiVersion(apiVersion).build();
    assertTrue(testService.hasApiVersion());
    assertEquals(apiVersion, testService.apiVersion());
  }

  @Test
  void apiVersion_shouldReturnNoApiVersionWhenNull() {
    Service testService = testServiceBuilder.build();
    assertNull(testService.apiVersion());
    assertFalse(testService.hasApiVersion());
  }

  @Test
  void apiVersion_shouldReturnNoApiVersionWhenEmpty() {
    String apiVersion = "";
    Service testService = testServiceBuilder.setApiVersion(apiVersion).build();
    assertEquals("", testService.apiVersion());
    assertFalse(testService.hasApiVersion());
  }

  @Test
  void hasAnyEnabledMethodsForTransport_shouldReturnFalseForEmptyMethodListForBothTransports() {
    Service testService = testServiceBuilder.setMethods(ImmutableList.of()).build();
    assertThat(testService.hasAnyEnabledMethodsForTransport(Transport.GRPC)).isFalse();
    assertThat(testService.hasAnyEnabledMethodsForTransport(Transport.REST)).isFalse();
  }

  @Test
  void hasAnyEnabledMethodsForTransport_shouldReturnTrueForAnyNonEmptyMethodListGRPCTransport() {
    Method testMethod1 =
        testMethodBuilder
            .setStream(Method.Stream.NONE)
            .setHttpBindings(testHttpBindingsBuilder.build())
            .build();
    Service testService1 = testServiceBuilder.setMethods(ImmutableList.of(testMethod1)).build();
    assertThat(testService1.hasAnyEnabledMethodsForTransport(Transport.GRPC)).isTrue();

    Method testMethod2 =
        testMethodBuilder
            .setStream(Method.Stream.BIDI)
            .setHttpBindings(testHttpBindingsBuilder.build())
            .build();
    Service testService2 = testServiceBuilder.setMethods(ImmutableList.of(testMethod2)).build();
    assertThat(testService2.hasAnyEnabledMethodsForTransport(Transport.GRPC)).isTrue();

    Service testService3 =
        testServiceBuilder.setMethods(ImmutableList.of(testMethod1, testMethod2)).build();
    assertThat(testService3.hasAnyEnabledMethodsForTransport(Transport.GRPC)).isTrue();
  }

  @Test
  void
      hasAnyEnabledMethodsForTransport_shouldReturnTrueForAnyNonEmptyAndValidMethodListRESTTransport() {
    Method testMethod1 =
        testMethodBuilder
            .setStream(Method.Stream.NONE)
            .setHttpBindings(testHttpBindingsBuilder.build())
            .build();
    Service testService1 = testServiceBuilder.setMethods(ImmutableList.of(testMethod1)).build();
    assertThat(testService1.hasAnyEnabledMethodsForTransport(Transport.REST)).isTrue();

    Method testMethod2 =
        testMethodBuilder
            .setStream(Method.Stream.SERVER)
            .setHttpBindings(testHttpBindingsBuilder.build())
            .build();
    Service testService2 = testServiceBuilder.setMethods(ImmutableList.of(testMethod2)).build();
    assertThat(testService2.hasAnyEnabledMethodsForTransport(Transport.REST)).isTrue();

    Service testService3 =
        testServiceBuilder.setMethods(ImmutableList.of(testMethod1, testMethod2)).build();
    assertThat(testService3.hasAnyEnabledMethodsForTransport(Transport.REST)).isTrue();
  }

  @Test
  void
      hasAnyEnabledMethodsForTransport_shouldReturnFalseForAnyNonEmptyButInvalidMethodListRESTTransport() {
    Method testMethod1 =
        testMethodBuilder
            .setStream(Method.Stream.BIDI)
            .setHttpBindings(testHttpBindingsBuilder.build())
            .build();
    Service testService1 = testServiceBuilder.setMethods(ImmutableList.of(testMethod1)).build();
    assertThat(testService1.hasAnyEnabledMethodsForTransport(Transport.REST)).isFalse();

    Method testMethod2 =
        testMethodBuilder
            .setStream(Method.Stream.CLIENT)
            .setHttpBindings(testHttpBindingsBuilder.build())
            .build();
    Service testService2 = testServiceBuilder.setMethods(ImmutableList.of(testMethod2)).build();
    assertThat(testService2.hasAnyEnabledMethodsForTransport(Transport.REST)).isFalse();

    Service testService3 =
        testServiceBuilder.setMethods(ImmutableList.of(testMethod1, testMethod2)).build();
    assertThat(testService3.hasAnyEnabledMethodsForTransport(Transport.REST)).isFalse();
  }

  @Test
  void hasAnyEnabledMethodsForTransport_shouldThrowExceptionForGRPCRESTTransport() {
    Service testService = testServiceBuilder.build();
    assertThrows(
        IllegalArgumentException.class,
        () -> testService.hasAnyEnabledMethodsForTransport(Transport.GRPC_REST));
  }

  @Test
  void hostServiceName_googleApisDefaultHost() {
    Service service = testServiceBuilder.setDefaultHost("test.googleapis.com").build();
    assertThat(service.hostServiceName()).isEqualTo("test");
  }

  @Test
  void hostServiceName_nonGoogleApisDefaultHost() {
    // Default Host is localhost:7469
    Service service = testServiceBuilder.build();
    assertThat(service.hostServiceName()).isEqualTo("");
  }
}
