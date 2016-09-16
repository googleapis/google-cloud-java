/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

/*
 * EDITING INSTRUCTIONS
 * This file is referenced in Dataset’s javadoc. Any change to this file should be reflected in
 * Dataset’s javadoc.
*/

package com.google.cloud.examples.bigquery.snippets;

import com.google.cloud.Page;
import com.google.cloud.bigquery.BigQuery.TableListOption;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.Dataset.Builder;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.Table;
import java.util.Iterator;

/**
 * This class contains a number of snippets for the {@link Dataset} interface.
 */
public class DatasetSnippets {

  private final Dataset dataset;

  public DatasetSnippets(Dataset dataset) {
    this.dataset = dataset;
  }
  
  /**
   * Example of checking whether a dataset exists.
   */
  // [TARGET exists()]
  public boolean doesDatasetExist() {
    // [START doesDatasetExist]
    boolean exists = this.dataset.exists();
    // [END doesDatasetExist]
    return exists;
  }

  /**
   * Example of reloading a dataset.
   */
  // [TARGET reload(BigQuery.DatasetOption... options)]
  public Dataset reloadDataset() {
    // [START reloadDataset]
    Dataset dataset = this.dataset.reload();
    if (dataset != null) {
      // The dataset was reloaded.
    } else {
      // The dataset was not found.
    }
    // [END reloadDataset]
    return dataset;
  }

  /**
   * Example of updating a dataset.
   */
  // [TARGET update(BigQuery.DatasetOption... options)]
  // [VARIABLE "my_friendly_name"]
  public Dataset updateDataset(String friendlyName) {
    // [START updateDataset]
    Builder builder = this.dataset.toBuilder();
    builder.friendlyName(friendlyName);
    Dataset updatedDataset = builder.build().update();
    // [END updateDataset]
    return updatedDataset;
  }

  /**
   * Example of deleting a dataset.
   */
  // [TARGET delete()]
  public boolean deleteDataset() {
    // [START deleteDataset]
    boolean deleted = this.dataset.delete();
    if (deleted) {
      // The dataset was deleted.
    } else {
      // The dataset was not found.
    }
    // [END deleteDataset]
    return deleted;
  }

  /**
   * Example of listing dataset tables.
   */
  // [TARGET list(BigQuery.TableListOption... options)]
  public Page<Table> listDataset() {
     // [START listDataset]
    Page<Table> tables = dataset.list();
    Iterator<Table> tableIterator = tables.iterateAll();
    while (tableIterator.hasNext()) {
      Table table = tableIterator.next();
      // do something with the table
    }
    // [END listDataset]
   return tables;
  }
  
  /**
   * Example of getting a dataset table.
   */
  // [TARGET get(String table, BigQuery.TableOption... options)]
  // [VARIABLE “my_table”]
  public Table getTable(String tableName) {
    // [START getTable]
    Table table = dataset.get(tableName);
    // [END getTable]
    return table;
  }

  /**
   * Example of creating an empty dataset table.
   */
  // [TARGET create(String table, TableDefinition definition, BigQuery.TableOption... options)]
  // [VARIABLE “my_table”]
  public Table createTable(String tableName) {
    // [START createTable]
    StandardTableDefinition definition = StandardTableDefinition.builder()
        .build();
    Table table = dataset.create(tableName, definition);
    // [END createTable]
    return table;
  }
  
  /**
   * Example of creating a dataset table with schema and time partitioning.
   */
  // [TARGET create(String table, TableDefinition definition, BigQuery.TableOption... options)]
  // [VARIABLE “my_table”]
  // [VARIABLE “my_field”]
  public Table createTable(String tableName, String fieldName) {
    // [START createTable]
    Schema schema = Schema.builder()
        .addField(Field.of(fieldName, Field.Type.string()))
        .build();
    StandardTableDefinition definition = StandardTableDefinition.builder()
        .schema(schema)
        .build();
    Table table = dataset.create(tableName, definition);
    // [END createTable]
    return table;
  }

}
