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
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.Dataset.Builder;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Field.Type;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TimePartitioning;

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
    // [START exists]
    boolean exists = dataset.exists();
    if (exists) {
      // the dataset exists
    } else {
      // the dataset was not found
    }
    // [END exists]
    return exists;
  }

  /**
   * Example of reloading a dataset.
   */
  // [TARGET reload(DatasetOption...)]
  public Dataset reloadDataset() {
    // [START reload]
    Dataset latestDataset = dataset.reload();
    if (latestDataset == null) {
      // The dataset was not found
    }
    // [END reload]
    return latestDataset;
  }

  /**
   * Example of updating a dataset.
   */
  // [TARGET update(DatasetOption...)]
  // [VARIABLE "my_friendly_name"]
  public Dataset updateDataset(String friendlyName) {
    // [START update]
    Builder builder = dataset.toBuilder();
    builder.setFriendlyName(friendlyName);
    Dataset updatedDataset = builder.build().update();
    // [END update]
    return updatedDataset;
  }

  /**
   * Example of deleting a dataset.
   */
  // [TARGET delete(DatasetDeleteOption...)]
  public boolean deleteDataset() {
    // [START delete]
    boolean deleted = dataset.delete();
    if (deleted) {
      // The dataset was deleted
    } else {
      // The dataset was not found
    }
    // [END delete]
    return deleted;
  }

  /**
   * Example of listing tables in the dataset.
   */
  // [TARGET list(TableListOption...)]
  public Page<Table> list() {
     // [START list]
    Page<Table> tables = dataset.list();
    Iterator<Table> tableIterator = tables.iterateAll();
    while (tableIterator.hasNext()) {
      Table table = tableIterator.next();
      // do something with the table
    }
    // [END list]
   return tables;
  }
  
  /**
   * Example of getting a table in the dataset.
   */
  // [TARGET get(String, TableOption...)]
  // [VARIABLE “my_table”]
  public Table getTable(String tableName) {
    // [START getTable]
    Table table = dataset.get(tableName);
    // [END getTable]
    return table;
  }
  
  /**
   * Example of creating a table in the dataset with schema and time partitioning.
   */
  // [TARGET create(String, TableDefinition, TableOption...)]
  // [VARIABLE “my_table”]
  // [VARIABLE “my_field”]
  public Table createTable(String tableName, String fieldName) {
    // [START createTable]
    Schema schema = Schema.of(Field.of(fieldName, Type.string()));
    StandardTableDefinition definition = StandardTableDefinition.newBuilder()
        .setSchema(schema)
        .setTimePartitioning(TimePartitioning.of(TimePartitioning.Type.DAY))
        .build();
    Table table = dataset.create(tableName, definition);
    // [END createTable]
    return table;
  }
}
