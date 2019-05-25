/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.data.v2.internal;

import com.google.api.core.InternalApi;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;

/**
 * Internal helper to compose full resource names.
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications.
 */
@InternalApi
public class NameUtil {
  private static final Pattern TABLE_PATTERN =
      Pattern.compile("projects/([^/]+)/instances/([^/]+)/tables/([^/]+)");

  public static String formatInstanceName(@Nonnull String projectId, @Nonnull String instanceId) {
    return "projects/" + projectId + "/instances/" + instanceId;
  }

  public static String formatTableName(
      @Nonnull String projectId, @Nonnull String instanceId, @Nonnull String tableId) {
    return formatInstanceName(projectId, instanceId) + "/tables/" + tableId;
  }

  public static String extractTableIdFromTableName(@Nonnull String fullTableName) {
    Matcher matcher = TABLE_PATTERN.matcher(fullTableName);
    if (!matcher.matches()) {
      throw new IllegalArgumentException("Invalid table name: " + fullTableName);
    }
    return matcher.group(3);
  }
}
