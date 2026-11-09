/*
 * Copyright 2022 Google LLC
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

import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;
import java.util.List;
import javax.annotation.Nullable;

class NoRowsResultSet extends AbstractResultSet<List<Object>> {
  private final ResultSetStats stats;
  private final ResultSetMetadata metadata;

  NoRowsResultSet(ResultSet resultSet) {
    this.stats = resultSet.getStats();
    this.metadata = resultSet.getMetadata();
  }

  @Override
  protected GrpcStruct currRow() {
    throw SpannerExceptionFactory.newSpannerException(
        ErrorCode.FAILED_PRECONDITION, "This result set has no rows");
  }

  @Override
  public boolean next() throws SpannerException {
    return false;
  }

  @Override
  public void close() {}

  @Nullable
  @Override
  public ResultSetStats getStats() {
    return stats;
  }

  @Override
  public ResultSetMetadata getMetadata() {
    return metadata;
  }

  @Override
  public Type getType() {
    return Type.struct();
  }
}
