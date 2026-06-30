/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc.utils;

import com.google.api.core.InternalApi;
import com.google.protobuf.ByteString;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.vector.VectorUnloader;
import org.apache.arrow.vector.ipc.WriteChannel;
import org.apache.arrow.vector.ipc.message.ArrowRecordBatch;
import org.apache.arrow.vector.ipc.message.MessageSerializer;
import org.apache.arrow.vector.types.pojo.Schema;

@InternalApi("Used for testing purpose")
public class ArrowUtilities {

  public static ByteString serializeSchema(Schema schema) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    MessageSerializer.serialize(new WriteChannel(Channels.newChannel(out)), schema);
    return ByteString.readFrom(new ByteArrayInputStream(out.toByteArray()));
  }

  public static ByteString serializeVectorSchemaRoot(VectorSchemaRoot root) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    ArrowRecordBatch recordBatch = new VectorUnloader(root).getRecordBatch();
    MessageSerializer.serialize(new WriteChannel(Channels.newChannel(out)), recordBatch);
    return ByteString.readFrom(new ByteArrayInputStream(out.toByteArray()));

    // ArrowStreamWriter writer = new ArrowStreamWriter(root, null, Channels.newChannel(out));
    // writer.start();
    // writer.writeBatch();
    // writer.end();
    // return ByteString.readFrom(new ByteArrayInputStream(out.toByteArray()));
  }
}
