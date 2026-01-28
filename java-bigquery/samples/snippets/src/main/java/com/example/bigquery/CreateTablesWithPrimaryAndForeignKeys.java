/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.bigquery;

// [START bigquery_create_tables_with_primary_and_foreign_keys]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.ColumnReference;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.ForeignKey;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.PrimaryKey;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.TableConstraints;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import java.util.Arrays;
import java.util.Collections;

// Create tables with primary/foreign key columns
public class CreateTablesWithPrimaryAndForeignKeys {

  private static final Schema PK_FK_SCHEMA =
      Schema.of(
          Field.newBuilder("ID", LegacySQLTypeName.STRING).setMode(Field.Mode.NULLABLE).build(),
          Field.newBuilder("FirstName", LegacySQLTypeName.STRING)
              .setMode(Field.Mode.NULLABLE)
              .build(),
          Field.newBuilder("LastName", LegacySQLTypeName.STRING)
              .setMode(Field.Mode.NULLABLE)
              .build());

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String tableNamePk = "PK_TABLE";
    String tableNameFk = "FK_TABLE";
    createTablesWithPrimaryAndForeignKeys(datasetName, tableNamePk, tableNameFk);
  }

  public static void createTablesWithPrimaryAndForeignKeys(
      String datasetName, String tableNamePk, String tableNameFk) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      // TableIds referenced by foreign keys need project id to be set
      TableId tableIdPk =
          TableId.of(bigquery.getOptions().getProjectId(), datasetName, tableNamePk);
      TableId tableIdFk = TableId.of(datasetName, tableNameFk);

      PrimaryKey primaryKey =
          PrimaryKey.newBuilder().setColumns(Collections.singletonList("ID")).build();
      TableConstraints tableConstraintsPk =
          TableConstraints.newBuilder().setPrimaryKey(primaryKey).build();

      ColumnReference columnReference =
          ColumnReference.newBuilder().setReferencingColumn("ID").setReferencedColumn("ID").build();
      ForeignKey foreignKey =
          ForeignKey.newBuilder()
              .setName("foreign_key")
              .setColumnReferences(Collections.singletonList(columnReference))
              .setReferencedTable(tableIdPk)
              .build();
      TableConstraints tableConstraintsFk =
          TableConstraints.newBuilder().setForeignKeys(Arrays.asList(foreignKey)).build();

      // Create a table with a primary key
      StandardTableDefinition tableDefinitionPk =
          StandardTableDefinition.newBuilder()
              .setSchema(PK_FK_SCHEMA)
              .setTableConstraints(tableConstraintsPk)
              .build();
      TableInfo tableInfoPk = TableInfo.of(tableIdPk, tableDefinitionPk);
      bigquery.create(tableInfoPk);

      // Create a table with a foreign key
      StandardTableDefinition tableDefinitionFk =
          StandardTableDefinition.newBuilder()
              .setSchema(PK_FK_SCHEMA)
              .setTableConstraints(tableConstraintsFk)
              .build();
      TableInfo tableInfoFk = TableInfo.of(tableIdFk, tableDefinitionFk);
      bigquery.create(tableInfoFk);

      System.out.println("Tables with primary and foreign keys created successfully.");
    } catch (BigQueryException e) {
      System.out.println("Tables not created \n" + e.toString());
    }
  }
}
// [END bigquery_create_tables_with_primary_and_foreign_keys]
