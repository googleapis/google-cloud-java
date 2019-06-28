/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.conformance;

import static com.google.cloud.conformance.ConformanceTestLocator.newMatchPattern;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;

import com.google.cloud.conformance.ConformanceTestLocator.MatchPattern;
import com.google.common.base.Joiner;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.junit.Test;

public class ConformanceTestLocatorTest {

  private static final Set<String> ALL_RESOURCES_ORG_JUNIT_VALIDATOR =
      newHashSet(
          "org/junit/validator/AnnotationsValidator.class",
          "org/junit/validator/AnnotationsValidator$1.class",
          "org/junit/validator/AnnotationsValidator$AnnotatableValidator.class",
          "org/junit/validator/AnnotationsValidator$ClassValidator.class",
          "org/junit/validator/AnnotationsValidator$FieldValidator.class",
          "org/junit/validator/AnnotationsValidator$MethodValidator.class",
          "org/junit/validator/AnnotationValidator.class",
          "org/junit/validator/AnnotationValidatorFactory.class",
          "org/junit/validator/PublicClassValidator.class",
          "org/junit/validator/TestClassValidator.class",
          "org/junit/validator/ValidateWith.class");

  private static final Set<String> ALL_RESOURCES_JUNIT_RUNNER_GIF =
      newHashSet(
          "junit/runner/smalllogo.gif", // in junit:junit:4.12
          "junit/runner/logo.gif", // in junit:junit:4.12
          "junit/runner/next-2019-hashtag.gif" // in ../src/test/resources
          );

  @Test
  public void load_all__org_junit_validator() throws IOException, URISyntaxException {
    doTest(newMatchPattern("org/junit/validator", ".class"), ALL_RESOURCES_ORG_JUNIT_VALIDATOR);
  }

  @Test
  public void load_all__load_across_dir_and_jars() throws IOException, URISyntaxException {
    doTest(newMatchPattern("junit", ".gif"), ALL_RESOURCES_JUNIT_RUNNER_GIF);
  }

  @Test
  public void newMatchPattern__validation_suffix__null() {
    try {
      newMatchPattern("something", null);
    } catch (IllegalArgumentException e) {
      assertThat(e).hasMessageThat().isEqualTo("suffix must be non-null and non-empty");
    }
  }

  @Test
  public void newMatchPattern__validation_suffix__empty() {
    try {
      newMatchPattern("something", "");
    } catch (IllegalArgumentException e) {
      assertThat(e).hasMessageThat().isEqualTo("suffix must be non-null and non-empty");
    }
  }

  @Test
  public void newMatchPattern__validation_baseResourcePath__null() {
    try {
      newMatchPattern(null, "*.class");
    } catch (IllegalArgumentException e) {
      assertThat(e).hasMessageThat().isEqualTo("baseResourcePath must be non-null");
    }
  }

  @Test
  public void newMatchPattern__ensure_no_leading_slash() {
    final MatchPattern matchPattern = newMatchPattern("/something", ".class");
    assertThat(matchPattern.getBaseResourcePath()).isEqualTo("something");
  }

  private void doTest(final MatchPattern mp, Collection<String> expectedResources)
      throws IOException, URISyntaxException {
    final List<String> expected = newArrayList(expectedResources);

    final List<String> actual = ConformanceTestLocator.findAllResourcePaths(mp);

    Collections.sort(expected);
    Collections.sort(actual);

    final Joiner joiner = Joiner.on("\n");
    final String expectedS = joiner.join(expected);
    final String actualS = joiner.join(actual);
    assertEquals(expectedS, actualS);
  }
}
