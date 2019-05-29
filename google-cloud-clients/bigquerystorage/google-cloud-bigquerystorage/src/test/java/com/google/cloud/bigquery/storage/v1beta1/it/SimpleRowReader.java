/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.bigquery.storage.v1beta1.it;

import com.google.cloud.bigquery.storage.v1beta1.AvroProto.AvroRows;
import com.google.common.base.Preconditions;
import java.io.IOException;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DecoderFactory;

/*
 * SimpleRowReader handles deserialization of the Avro-encoded row blocks transmitted
 * from the storage API using a generic datum decoder.
 */
public class SimpleRowReader {

  public interface AvroRowConsumer {
    void accept(GenericRecord record);
  }

  private final DatumReader<GenericRecord> datumReader;

  // Decoder object will be reused to avoid re-allocation and too much garbage collection.
  private BinaryDecoder decoder = null;

  // GenericRecord object will be reused.
  private GenericRecord row = null;

  public SimpleRowReader(Schema schema) {
    Preconditions.checkNotNull(schema);
    datumReader = new GenericDatumReader<>(schema);
  }

  /**
   * Processes Avro rows by calling a consumer for each decoded row.
   *
   * @param avroRows object returned from the ReadRowsResponse.
   * @param rowConsumer consumer that accepts GenericRecord.
   */
  public void processRows(AvroRows avroRows, AvroRowConsumer rowConsumer) throws IOException {
    Preconditions.checkNotNull(avroRows);
    Preconditions.checkNotNull(rowConsumer);
    decoder =
        DecoderFactory.get()
            .binaryDecoder(avroRows.getSerializedBinaryRows().toByteArray(), decoder);

    while (!decoder.isEnd()) {
      row = datumReader.read(row, decoder);
      rowConsumer.accept(row);
    }
  }
}
