// Copyright 2021 Google LLC
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

import java.util.Arrays;
import java.util.Optional;

public final class ResourceReferenceUtils {

  private static final String SLASH = "/";

  private ResourceReferenceUtils() {}

  public static Optional<String> parseParentPattern(String pattern) {
    String[] tokens = pattern.split(SLASH);
    String lastToken = tokens[tokens.length - 1];
    if (lastToken.equals(ResourceNameConstants.DELETED_TOPIC_LITERAL)
        || lastToken.equals(ResourceNameConstants.WILDCARD_PATTERN)) {
      return Optional.empty();
    }

    int lastTokenIndex = tokens.length - 2;
    int minLengthWithParent = 4;
    // Singleton patterns, e.g. projects/{project}/agent.
    if (!lastToken.contains("{")) {
      minLengthWithParent = 3;
      lastTokenIndex = tokens.length - 1;
    }

    // No fully-formed parent. Expected: ancestors/{ancestor}/childNodes/{child_node}.
    if (tokens.length < minLengthWithParent) {
      return Optional.empty();
    }

    return Optional.of(String.join(SLASH, Arrays.asList(tokens).subList(0, lastTokenIndex)));
  }
}
