/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.bigquery.storage.v1.it;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.bigquery.FieldElementType;
import com.google.cloud.bigquery.Range;
import com.google.cloud.bigquery.storage.v1.ArrowRecordBatch;
import com.google.cloud.bigquery.storage.v1.ArrowSchema;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.FieldVector;
import org.apache.arrow.vector.VectorLoader;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.complex.StructVector;
import org.apache.arrow.vector.ipc.ReadChannel;
import org.apache.arrow.vector.ipc.message.MessageSerializer;
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.apache.arrow.vector.types.pojo.ArrowType.ArrowTypeID;
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.vector.util.ByteArrayReadableSeekableByteChannel;

public class SimpleRowReaderArrow implements AutoCloseable {

  public interface ArrowBatchConsumer {

    /** Handler for every new Arrow batch. */
    void accept(VectorSchemaRoot root);
  }

  /** ArrowRangeBatchConsumer accepts batch Arrow data and validate the range values. */
  public static class ArrowRangeBatchConsumer implements ArrowBatchConsumer {

    private final ImmutableMap<String, Range> expectedRangeDateValues;
    private final ImmutableMap<String, Range> expectedRangeDatetimeValues;
    private final ImmutableMap<String, Range> expectedRangeTimestampValues;

    public ArrowRangeBatchConsumer(
        ImmutableMap<String, Range> expectedRangeDateValues,
        ImmutableMap<String, Range> expectedRangeDatetimeValues,
        ImmutableMap<String, Range> expectedRangeTimestampValues) {
      this.expectedRangeDateValues = expectedRangeDateValues;
      this.expectedRangeDatetimeValues = expectedRangeDatetimeValues;
      this.expectedRangeTimestampValues = expectedRangeTimestampValues;
    }

    @Override
    public void accept(VectorSchemaRoot root) {
      StructVector dateVector = (StructVector) root.getVector("date");
      for (int i = 0; i < dateVector.valueCount; i++) {
        Field field = root.getSchema().findField(dateVector.getName());
        assertThat(field.getType().getTypeID()).isEqualTo(ArrowTypeID.Struct);

        Map<String, ?> value = dateVector.getObject(i);
        Range.Builder rangeBuilder = Range.newBuilder();
        if (value.get("start") != null) {
          rangeBuilder.setStart(((Integer) value.get("start")).toString());
        }
        if (value.get("end") != null) {
          rangeBuilder.setEnd(((Integer) value.get("end")).toString());
        }
        rangeBuilder.setType(toFieldElementType(field.getChildren().get(0)));
        assertThat(rangeBuilder.build()).isIn(this.expectedRangeDateValues.values());
      }

      StructVector datetimeVector = (StructVector) root.getVector("datetime");
      for (int i = 0; i < datetimeVector.valueCount; i++) {
        Field field = root.getSchema().findField(datetimeVector.getName());
        assertThat(field.getType().getTypeID()).isEqualTo(ArrowTypeID.Struct);

        Map<String, ?> value = datetimeVector.getObject(i);
        Range.Builder rangeBuilder = Range.newBuilder();
        if (value.get("start") != null) {
          rangeBuilder.setStart(((LocalDateTime) value.get("start")).toString());
        }
        if (value.get("end") != null) {
          rangeBuilder.setEnd(((LocalDateTime) value.get("end")).toString());
        }
        rangeBuilder.setType(toFieldElementType(field.getChildren().get(0)));
        assertThat(rangeBuilder.build()).isIn(this.expectedRangeDatetimeValues.values());
      }

      StructVector timestampVector = (StructVector) root.getVector("timestamp");
      for (int i = 0; i < timestampVector.valueCount; i++) {
        Field field = root.getSchema().findField(timestampVector.getName());
        assertThat(field.getType().getTypeID()).isEqualTo(ArrowTypeID.Struct);

        Map<String, ?> value = timestampVector.getObject(i);
        Range.Builder rangeBuilder = Range.newBuilder();
        if (value.get("start") != null) {
          rangeBuilder.setStart(((Long) value.get("start")).toString());
        }
        if (value.get("end") != null) {
          rangeBuilder.setEnd(((Long) value.get("end")).toString());
        }
        rangeBuilder.setType(toFieldElementType(field.getChildren().get(0)));
        assertThat(rangeBuilder.build()).isIn(this.expectedRangeTimestampValues.values());
      }
    }

    private static FieldElementType toFieldElementType(Field field) {
      switch (field.getType().getTypeID()) {
        case Date:
          return FieldElementType.newBuilder().setType("DATE").build();
        case Timestamp:
          String timezone = ((ArrowType.Timestamp) field.getType()).getTimezone();
          if (timezone == null) {
            // Datetime fields do not have timezone value.
            return FieldElementType.newBuilder().setType("DATETIME").build();
          } else {
            return FieldElementType.newBuilder().setType("TIMESTAMP").build();
          }
        default:
          return null;
      }
    }
  }

  BufferAllocator allocator = new RootAllocator(Long.MAX_VALUE);

  // Decoder object will be reused to avoid re-allocation and too much garbage collection.
  private final VectorSchemaRoot root;
  private final VectorLoader loader;

  public SimpleRowReaderArrow(ArrowSchema arrowSchema) throws IOException {
    org.apache.arrow.vector.types.pojo.Schema schema =
        MessageSerializer.deserializeSchema(
            new ReadChannel(
                new ByteArrayReadableSeekableByteChannel(
                    arrowSchema.getSerializedSchema().toByteArray())));
    Preconditions.checkNotNull(schema);
    List<FieldVector> vectors = new ArrayList<>();
    for (org.apache.arrow.vector.types.pojo.Field field : schema.getFields()) {
      vectors.add(field.createVector(allocator));
    }
    root = new VectorSchemaRoot(vectors);
    loader = new VectorLoader(root);
  }

  /**
   * Method for processing Arrow data which validates Range values.
   *
   * @param batch object returned from the ReadRowsResponse.
   * @param batchConsumer consumer of the batch Arrow data.
   */
  public void processRows(ArrowRecordBatch batch, ArrowBatchConsumer batchConsumer)
      throws IOException {
    org.apache.arrow.vector.ipc.message.ArrowRecordBatch deserializedBatch =
        MessageSerializer.deserializeRecordBatch(
            new ReadChannel(
                new ByteArrayReadableSeekableByteChannel(
                    batch.getSerializedRecordBatch().toByteArray())),
            allocator);

    loader.load(deserializedBatch);
    // Release buffers from batch (they are still held in the vectors in root).
    deserializedBatch.close();
    batchConsumer.accept(root);

    // Release buffers from vectors in root.
    root.clear();
  }

  @Override
  public void close() {
    root.close();
    allocator.close();
  }
}
