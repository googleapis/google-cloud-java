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

package com.google.api.generator.gapic.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;
import org.junit.jupiter.api.Test;

class ResourceReferenceUtilsTest {

  @Test
  void parseParentPattern_basic() {
    String parentPattern = "projects/{project}";
    String pattern = String.format("%s/folders/{folder}", parentPattern);
    assertEquals(parentPattern, ResourceReferenceUtils.parseParentPattern(pattern).get());
  }

  @Test
  void parseParentPattern_wildcard() {
    Optional<String> parentPatternOpt =
        ResourceReferenceUtils.parseParentPattern(ResourceNameConstants.WILDCARD_PATTERN);
    assertFalse(parentPatternOpt.isPresent());
  }

  @Test
  void parseParentPattern_deletedTopicLiteral() {
    Optional<String> parentPatternOpt =
        ResourceReferenceUtils.parseParentPattern(ResourceNameConstants.DELETED_TOPIC_LITERAL);
    assertFalse(parentPatternOpt.isPresent());
  }

  @Test
  void parseParentPattern_noParents() {
    Optional<String> parentPatternOpt =
        ResourceReferenceUtils.parseParentPattern("projects/{project}");
    assertFalse(parentPatternOpt.isPresent());
  }

  @Test
  void parseParentPattern_insufficientPathComponents() {
    Optional<String> parentPatternOpt =
        ResourceReferenceUtils.parseParentPattern("projects/foobars/{foobar}");
    assertFalse(parentPatternOpt.isPresent());
  }

  @Test
  void parseParentPattern_lastComponentIsNotAVariable() {
    Optional<String> parentPatternOpt =
        ResourceReferenceUtils.parseParentPattern("projects/{project}/foobars");
    assertTrue(parentPatternOpt.isPresent());
    assertEquals("projects/{project}", parentPatternOpt.get());
  }
}
