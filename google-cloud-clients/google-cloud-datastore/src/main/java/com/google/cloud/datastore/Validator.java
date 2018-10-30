/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.datastore;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.base.Strings;

import java.util.regex.Pattern;

/**
 * Utility to validate Datastore type/values.
 */
final class Validator {

  private static final Pattern PROJECT_ID_PATTERN = Pattern.compile(
      "([a-z\\d\\-]{1,100}~)?([a-z\\d][a-z\\d\\-\\.]{0,99}:)?([a-z\\d][a-z\\d\\-]{0,99})");
  private static final int MAX_NAMESPACE_LENGTH = 100;
  private static final Pattern NAMESPACE_PATTERN =
      Pattern.compile("[0-9A-Za-z\\._\\-]{0," + MAX_NAMESPACE_LENGTH + "}");

  private Validator() {
    // utility class
  }

  static String validateDatabase(String projectId) {
    checkArgument(!Strings.isNullOrEmpty(projectId), "projectId can't be empty or null");
    checkArgument(PROJECT_ID_PATTERN.matcher(projectId).matches(),
    	"projectId " + projectId + " does not match the required pattern: " + PROJECT_ID_PATTERN.pattern());
    return projectId;
  }

  static String validateNamespace(String namespace) {
    checkArgument(namespace != null, "Namespace cannot be null. Leave unset for default.");
    checkArgument(namespace.length() <= MAX_NAMESPACE_LENGTH,
        "namespace must not contain more than 100 characters");
    checkArgument(NAMESPACE_PATTERN.matcher(namespace).matches(),
        "namespace must the following pattern: " + NAMESPACE_PATTERN.pattern());
    return namespace;
  }

  static String validateKind(String kind) {
    checkArgument(!Strings.isNullOrEmpty(kind), "kind must not be empty or null");
    return kind;
  }


}
