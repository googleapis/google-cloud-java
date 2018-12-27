/*
 * Copyright 2018 Google LLC
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
 * This file is referenced in DatasetInfo’s javadoc. Any change to this file should be reflected in
 * DatasetInfo’s javadoc. Use utilities/add_snipptets_to_file.py to copy.
 */

package com.google.cloud.examples.bigquery.snippets;

import com.google.cloud.bigquery.Acl;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.DatasetInfo;
import java.util.ArrayList;
import java.util.List;

/** This class contains a number of snippets for the {@link DatasetInfo} interface. */
public class DatasetInfoSnippets {

  private final BigQuery bigquery;

  public DatasetInfoSnippets(BigQuery bigquery) {
    this.bigquery = bigquery;
  }

  /** Update the ACLs for a dataset. */
  // [TARGET getAcl()]
  // [VARIABLE bigquery.getDataset(DatasetId.of("my_dataset"))]
  public List<Acl> updateDatasetAccess(DatasetInfo dataset) {
    // [START bigquery_update_dataset_access]
    List<Acl> beforeAcls = dataset.getAcl();

    // Make a copy of the ACLs so that they can be modified.
    ArrayList<Acl> acls = new ArrayList<>(beforeAcls);
    acls.add(Acl.of(new Acl.User("sample.bigquery.dev@gmail.com"), Acl.Role.READER));
    DatasetInfo.Builder builder = dataset.toBuilder();
    builder.setAcl(acls);

    bigquery.update(builder.build()); // API request.
    // [END bigquery_update_dataset_access]

    return beforeAcls;
  }

  /** Update the default table expiration time for a dataset. */
  // [TARGET getDefaultTableLifetime()]
  // [VARIABLE bigquery.getDataset(DatasetId.of("my_dataset"))]
  public Long updateDatasetExpiration(DatasetInfo dataset) {
    // [START bigquery_update_dataset_expiration]
    Long beforeExpiration = dataset.getDefaultTableLifetime();

    Long oneDayMilliseconds = 24 * 60 * 60 * 1000L;
    DatasetInfo.Builder builder = dataset.toBuilder();
    builder.setDefaultTableLifetime(oneDayMilliseconds);
    bigquery.update(builder.build()); // API request.
    // [END bigquery_update_dataset_expiration]

    return beforeExpiration;
  }
}
