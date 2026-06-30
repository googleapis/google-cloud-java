/*
 * Copyright 2021 Google LLC
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

import com.google.common.base.Preconditions;

/**
 * Commit statistics are returned by a read/write transaction if specifically requested by passing
 * in {@link Options#commitStats()} to the transaction.
 */
public class CommitStats {
  private final long mutationCount;

  private CommitStats(long mutationCount) {
    this.mutationCount = mutationCount;
  }

  static CommitStats fromProto(com.google.spanner.v1.CommitResponse.CommitStats proto) {
    Preconditions.checkNotNull(proto);
    return new CommitStats(proto.getMutationCount());
  }

  /**
   * The number of mutations that were executed by the transaction. Insert and update operations
   * count with the multiplicity of the number of columns they affect. For example, inserting a new
   * record may count as five mutations, if values are inserted into five columns. Delete and delete
   * range operations count as one mutation regardless of the number of columns affected. Deleting a
   * row from a parent table that has the ON DELETE CASCADE annotation is also counted as one
   * mutation regardless of the number of interleaved child rows present. The exception to this is
   * if there are secondary indexes defined on rows being deleted, then the changes to the secondary
   * indexes are counted individually. For example, if a table has 2 secondary indexes, deleting a
   * range of rows in the table counts as 1 mutation for the table, plus 2 mutations for each row
   * that is deleted because the rows in the secondary index might be scattered over the key-space,
   * making it impossible for Cloud Spanner to call a single delete range operation on the secondary
   * indexes. Secondary indexes include the foreign keys backing indexes.
   */
  public long getMutationCount() {
    return mutationCount;
  }
}
