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
import com.google.cloud.bigtable.data.v2.models.AuthorizedViewId;
import com.google.cloud.bigtable.data.v2.models.TableId;
import com.google.cloud.bigtable.data.v2.models.TargetId;
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
  private static final Pattern AUTHORIZED_VIEW_PATTERN =
      Pattern.compile("projects/([^/]+)/instances/([^/]+)/tables/([^/]+)/authorizedViews/([^/]+)");

  public static String formatInstanceName(@Nonnull String projectId, @Nonnull String instanceId) {
    return "projects/" + projectId + "/instances/" + instanceId;
  }

  public static String formatTableName(
      @Nonnull String projectId, @Nonnull String instanceId, @Nonnull String tableId) {
    return formatInstanceName(projectId, instanceId) + "/tables/" + tableId;
  }

  public static String formatAuthorizedViewName(
      @Nonnull String projectId,
      @Nonnull String instanceId,
      @Nonnull String tableId,
      @Nonnull String authorizedViewId) {
    return formatTableName(projectId, instanceId, tableId) + "/authorizedViews/" + authorizedViewId;
  }

  public static String extractTableIdFromTableName(@Nonnull String fullTableName) {
    Matcher matcher = TABLE_PATTERN.matcher(fullTableName);
    if (!matcher.matches()) {
      throw new IllegalArgumentException("Invalid table name: " + fullTableName);
    }
    return matcher.group(3);
  }

  public static String extractTableIdFromAuthorizedViewName(
      @Nonnull String fullAuthorizedViewName) {
    Matcher matcher = AUTHORIZED_VIEW_PATTERN.matcher(fullAuthorizedViewName);
    if (!matcher.matches()) {
      throw new IllegalArgumentException("Invalid authorized view name: " + fullAuthorizedViewName);
    }
    return matcher.group(3);
  }

  public static String extractTableNameFromAuthorizedViewName(
      @Nonnull String fullAuthorizedViewName) {
    Matcher matcher = AUTHORIZED_VIEW_PATTERN.matcher(fullAuthorizedViewName);
    if (!matcher.matches()) {
      throw new IllegalArgumentException("Invalid authorized view name: " + fullAuthorizedViewName);
    }
    return formatTableName(matcher.group(1), matcher.group(2), matcher.group(3));
  }

  public static String extractAuthorizedViewIdFromAuthorizedViewName(
      @Nonnull String fullAuthorizedViewName) {
    Matcher matcher = AUTHORIZED_VIEW_PATTERN.matcher(fullAuthorizedViewName);
    if (!matcher.matches()) {
      throw new IllegalArgumentException("Invalid authorized view name: " + fullAuthorizedViewName);
    }
    return matcher.group(4);
  }

  /** A helper to convert fully qualified tableName and authorizedViewName to a {@link TargetId} */
  public static TargetId extractTargetId(
      @Nonnull String tableName, @Nonnull String authorizedViewName) {
    if (tableName.isEmpty() && authorizedViewName.isEmpty()) {
      throw new IllegalArgumentException(
          "Either table name or authorized view name must be specified. Table name: "
              + tableName
              + ", authorized view name: "
              + authorizedViewName);
    }
    if (!tableName.isEmpty() && !authorizedViewName.isEmpty()) {
      throw new IllegalArgumentException(
          "Table name and authorized view name cannot be specified at the same time. Table name: "
              + tableName
              + ", authorized view name: "
              + authorizedViewName);
    }

    if (!tableName.isEmpty()) {
      String tableId = extractTableIdFromTableName(tableName);
      return TableId.of(tableId);
    } else {
      String tableId = extractTableIdFromAuthorizedViewName(authorizedViewName);
      String authorizedViewId = extractAuthorizedViewIdFromAuthorizedViewName(authorizedViewName);
      return AuthorizedViewId.of(tableId, authorizedViewId);
    }
  }
}
