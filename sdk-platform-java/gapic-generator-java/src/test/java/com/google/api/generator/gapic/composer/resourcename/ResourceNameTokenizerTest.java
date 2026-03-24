// Copyright 2020 Google LLC
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

package com.google.api.generator.gapic.composer.resourcename;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;

import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.ServiceDescriptor;
import com.google.showcase.v1beta1.EchoOuterClass;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResourceNameTokenizerTest {
  private ServiceDescriptor echoService;
  private FileDescriptor echoFileDescriptor;

  @BeforeEach
  void setUp() {
    echoFileDescriptor = EchoOuterClass.getDescriptor();
    echoService = echoFileDescriptor.getServices().get(0);
    assertEquals(echoService.getName(), "Echo");
  }

  @Test
  void parseTokenHierarchy_basic() {
    List<String> patterns =
        Arrays.asList(
            "projects/{project}/locations/{location}/autoscalingPolicies/{autoscaling_policy}",
            "projects/{project}/regions/{region}/autoscalingPolicies/{autoscaling_policy}",
            "projects/{project}/autoscalingPolicies/{autoscaling_policy}");
    List<List<String>> tokenHierarchies = ResourceNameTokenizer.parseTokenHierarchy(patterns);
    assertEquals(3, tokenHierarchies.size());
    assertThat(tokenHierarchies.get(0))
        .containsExactly("project", "location", "autoscaling_policy");
    assertThat(tokenHierarchies.get(1)).containsExactly("project", "region", "autoscaling_policy");
    assertThat(tokenHierarchies.get(2)).containsExactly("project", "autoscaling_policy");
  }

  @Test
  void parseTokenHierarchy_substringsInPattern() {
    List<String> patterns =
        Arrays.asList(
            "customers/{customer}/customerExtensionSettings/{customer_extension_setting}");
    List<List<String>> tokenHierarchies = ResourceNameTokenizer.parseTokenHierarchy(patterns);
    assertEquals(1, tokenHierarchies.size());
    assertThat(tokenHierarchies.get(0)).containsExactly("customer", "customer_extension_setting");
  }

  @Test
  void parseTokenHierarchy_wildcards() {
    List<String> patterns =
        Arrays.asList(
            "projects/{project}/metricDescriptors/{metric_descriptor=**}",
            "organizations/{organization}/metricDescriptors/{metric_descriptor=**}",
            "folders/{folder=**}/metricDescriptors/{metric_descriptor}");
    List<List<String>> tokenHierarchies = ResourceNameTokenizer.parseTokenHierarchy(patterns);
    assertEquals(3, tokenHierarchies.size());
    assertThat(tokenHierarchies.get(0)).containsExactly("project", "metric_descriptor");
    assertThat(tokenHierarchies.get(1)).containsExactly("organization", "metric_descriptor");
    assertThat(tokenHierarchies.get(2)).containsExactly("folder", "metric_descriptor");
  }

  @Test
  void parseTokenHierarchy_singletonCollection() {
    List<String> patterns =
        Arrays.asList(
            "projects/{project}/agent/sessions/{session}",
            "projects/{project}/agent/environments/{environment}/users/{user}/sessions/{session}");
    List<List<String>> tokenHierarchies = ResourceNameTokenizer.parseTokenHierarchy(patterns);
    assertEquals(2, tokenHierarchies.size());
    assertThat(tokenHierarchies.get(0)).containsExactly("project", "session");
    assertThat(tokenHierarchies.get(1))
        .containsExactly("project", "environment", "user", "session");
  }

  @Test
  void parseTokenHierarchy_singletonCollectionAndNonSlashSeparators() {
    List<String> patterns =
        Arrays.asList(
            "users/{user}/profile/blurbs/legacy/{legacy_user}~{blurb}",
            "users/{user}/profile/blurbs/{blurb}",
            "rooms/{room}/blurbs/{blurb}",
            "users/{user}/profile/blurbs/legacy/{legacy_document}_{blurb}",
            "users/{user}/profile/blurbs/legacy/{legacy_book}-{blurb}",
            "rooms/{room}/blurbs/legacy/{legacy_room}.{blurb}");

    List<List<String>> tokenHierarchies = ResourceNameTokenizer.parseTokenHierarchy(patterns);
    assertEquals(6, tokenHierarchies.size());
    assertThat(tokenHierarchies.get(0)).containsExactly("user", "legacy_user", "blurb");
    assertThat(tokenHierarchies.get(1)).containsExactly("user", "blurb");
    assertThat(tokenHierarchies.get(2)).containsExactly("room", "blurb");
    assertThat(tokenHierarchies.get(3)).containsExactly("user", "legacy_document", "blurb");
    assertThat(tokenHierarchies.get(4)).containsExactly("user", "legacy_book", "blurb");
    assertThat(tokenHierarchies.get(5)).containsExactly("room", "legacy_room", "blurb");
  }

  @Test
  void parseTokenHierarchy_invalidPatterns() {
    List<String> patterns =
        Arrays.asList(
            "projects/{project}/agent/sessions/{session}/anotherSingleton",
            "{project}/agent/environments/{environment}/users/{user}/sessions/{session}");
    List<List<String>> tokenHierarchies = ResourceNameTokenizer.parseTokenHierarchy(patterns);
    assertEquals(2, tokenHierarchies.size());
    assertThat(tokenHierarchies.get(0)).containsExactly("project", "session");
    assertThat(tokenHierarchies.get(1))
        .containsExactly("project", "environment", "user", "session");
  }
}
