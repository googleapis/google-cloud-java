/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.spanner;

import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.Options.ReadOption;
import java.util.List;

public interface BatchTransaction extends ReadOnlyTransaction {

  List<Partition> generateReadPartitions(
      PartitionParameters parameters,
      String table,
      KeySet keys,
      Iterable<String> columns,
      ReadOption... options);

  List<Partition> generateReadUsingIndexPartitions(
      PartitionParameters parameters,
      String table,
      String index,
      KeySet keys,
      Iterable<String> columns,
      ReadOption... options);

  List<Partition> generateQueryPartitions(
      PartitionParameters parameters, Statement statement, QueryOption... options);

  ResultSet execute(Partition partition);

  BatchTransactionId getBatchTransactionId();

  @Override
  public void close();
}
