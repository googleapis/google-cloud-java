/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.bigquery.storage.v1alpha2;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
import com.google.common.annotations.VisibleForTesting;
import com.google.protobuf.Descriptors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class that checks the schema compatibility between user schema in proto descriptor and Bigquery
 * table schema. If this check is passed, then user can write to BigQuery table using the user
 * schema, otherwise the write will fail.
 *
 * <p>The implementation as of now is not complete, which measn, if this check passed, there is
 * still a possbility of writing will fail.
 */
public class SchemaCompact {
  private BigQuery bigquery;
  private static SchemaCompact compact;
  private static String tablePatternString = "projects/([^/]+)/datasets/([^/]+)/tables/([^/]+)";
  private static Pattern tablePattern = Pattern.compile(tablePatternString);

  private SchemaCompact(BigQuery bigquery) {
    this.bigquery = bigquery;
  }

  /**
   * Gets a singleton {code SchemaCompact} object.
   *
   * @return
   */
  public static SchemaCompact getInstance() {
    if (compact == null) {
      RemoteBigQueryHelper bigqueryHelper = RemoteBigQueryHelper.create();
      compact = new SchemaCompact(bigqueryHelper.getOptions().getService());
    }
    return compact;
  }

  /**
   * Gets a {code SchemaCompact} object with custom BigQuery stub.
   *
   * @param bigquery
   * @return
   */
  @VisibleForTesting
  public static SchemaCompact getInstance(BigQuery bigquery) {
    return new SchemaCompact(bigquery);
  }

  private TableId getTableId(String tableName) {
    Matcher matcher = tablePattern.matcher(tableName);
    if (!matcher.matches() || matcher.groupCount() != 3) {
      throw new IllegalArgumentException("Invalid table name: " + tableName);
    }
    return TableId.of(matcher.group(1), matcher.group(2), matcher.group(3));
  }

  /**
   * Checks if the userSchema is compatible with the table's current schema for writing. The current
   * implementatoin is not complete. If the check failed, the write couldn't succeed.
   *
   * @param tableName The name of the table to write to.
   * @param userSchema The schema user uses to append data.
   * @throws IllegalArgumentException the check failed.
   */
  public void check(String tableName, Descriptors.Descriptor userSchema)
      throws IllegalArgumentException {
    Table table = bigquery.getTable(getTableId(tableName));
    Schema schema = table.getDefinition().getSchema();
    // TODO: We only have very limited check here. More checks to be added.
    if (schema.getFields().size() != userSchema.getFields().size()) {
      throw new IllegalArgumentException(
          "User schema doesn't have expected field number with BigQuery table schema, expected: "
              + schema.getFields().size()
              + " actual: "
              + userSchema.getFields().size());
    }
  }
}
