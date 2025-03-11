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
import com.google.cloud.bigtable.data.v2.models.MaterializedViewId;
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
  private static final Pattern MATERIALIZED_VIEW_PATTERN =
      Pattern.compile("projects/([^/]+)/instances/([^/]+)/materializedViews/([^/]+)");

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

  public static String formatMaterializedViewName(
      @Nonnull String projectId, @Nonnull String instanceId, @Nonnull String materializedViewId) {
    return formatInstanceName(projectId, instanceId) + "/materializedViews/" + materializedViewId;
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

  public static String extractMaterializedViewIdFromMaterializedViewName(
      @Nonnull String fullMaterializedViewName) {
    Matcher matcher = MATERIALIZED_VIEW_PATTERN.matcher(fullMaterializedViewName);
    if (!matcher.matches()) {
      throw new IllegalArgumentException(
          "Invalid materialized view name: " + fullMaterializedViewName);
    }
    return matcher.group(3);
  }

  /** A helper to convert fully qualified tableName andauthorizedViewName to a {@link TargetId} */
  public static TargetId extractTargetId(
      @Nonnull String tableName, @Nonnull String authorizedViewName) {
    return extractTargetId(tableName, authorizedViewName, "");
  }

  /**
   * A helper to convert fully qualified tableName, authorizedViewName and materializedViewName to a
   * {@link TargetId}
   */
  public static TargetId extractTargetId(
      @Nonnull String tableName,
      @Nonnull String authorizedViewName,
      @Nonnull String materializedViewName) {
    if (tableName.isEmpty() && authorizedViewName.isEmpty() && materializedViewName.isEmpty()) {
      throw new IllegalArgumentException(
          "Either table name, authorized view name or materialized view name must be specified. Table name: "
              + tableName
              + ", authorized view name: "
              + authorizedViewName
              + ", materialized view name: "
              + materializedViewName);
    }
    int names = 0;
    if (!tableName.isEmpty()) {
      ++names;
    }
    if (!authorizedViewName.isEmpty()) {
      ++names;
    }
    if (!materializedViewName.isEmpty()) {
      ++names;
    }
    if (names > 1) {
      throw new IllegalArgumentException(
          "Only one of table name, authorized view name and materialized view name can be specified at the same time. Table name: "
              + tableName
              + ", authorized view name: "
              + authorizedViewName
              + ", materialized view name: "
              + materializedViewName);
    }

    if (!tableName.isEmpty()) {
      String tableId = extractTableIdFromTableName(tableName);
      return TableId.of(tableId);
    } else if (!authorizedViewName.isEmpty()) {
      String tableId = extractTableIdFromAuthorizedViewName(authorizedViewName);
      String authorizedViewId = extractAuthorizedViewIdFromAuthorizedViewName(authorizedViewName);
      return AuthorizedViewId.of(tableId, authorizedViewId);
    }
    String materializedViewId =
        extractMaterializedViewIdFromMaterializedViewName(materializedViewName);
    return MaterializedViewId.of(materializedViewId);
  }
}
