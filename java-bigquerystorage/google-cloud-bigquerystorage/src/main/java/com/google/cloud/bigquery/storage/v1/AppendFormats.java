/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.bigquery.storage.v1;

import com.google.auto.value.AutoValue;
import javax.annotation.Nullable;

/** Adapter class for data formats used in the AppendRows. */
final class AppendFormats {
  /** Enum for the data format used in the AppendRows. */
  enum DataFormat {
    UNKNOWN,
    PROTO,
    ARROW
  }

  /** Container class for the schema used in the AppendRows request. */
  @AutoValue
  abstract static class AppendRowsSchema {
    abstract DataFormat format();

    @Nullable
    abstract ProtoSchema protoSchema();

    @Nullable
    abstract ArrowSchema arrowSchema();

    static AppendRowsSchema of(ProtoSchema protoSchema) {
      return new AutoValue_AppendFormats_AppendRowsSchema(
          DataFormat.PROTO, protoSchema, /* arrowSchema= */ null);
    }

    static AppendRowsSchema of(ArrowSchema arrowSchema) {
      return new AutoValue_AppendFormats_AppendRowsSchema(
          DataFormat.ARROW, /* protoSchema= */ null, arrowSchema);
    }
  }

  /** Container class for the data used in the AppendRows request. */
  @AutoValue
  abstract static class AppendRowsData {
    abstract DataFormat format();

    @Nullable
    abstract ProtoRows protoRows();

    @Nullable
    abstract ArrowRecordBatch arrowRecordBatch();

    // Row count for arrowRecordBatch. It is defaulted to -1 of not set.
    abstract long recordBatchRowCount();

    static AppendRowsData of(ProtoRows protoRows) {
      return new AutoValue_AppendFormats_AppendRowsData(
          DataFormat.PROTO, protoRows, /* arrowRecordBatch= */ null, /* recordBatchRowCount= */ -1);
    }

    static AppendRowsData of(ArrowRecordBatch arrowRecordBatch) {
      return new AutoValue_AppendFormats_AppendRowsData(
          DataFormat.ARROW, /* protoRows= */ null, arrowRecordBatch, /* recordBatchRowCount= */ -1);
    }

    static AppendRowsData of(ArrowRecordBatch arrowRecordBatch, long recordBatchRowCount) {
      return new AutoValue_AppendFormats_AppendRowsData(
          DataFormat.ARROW, /* protoRows= */ null, arrowRecordBatch, recordBatchRowCount);
    }
  }

  private AppendFormats() {}
}
