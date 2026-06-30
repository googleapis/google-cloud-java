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

package com.google.cloud.storage.it;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.auth.http.HttpTransportFactory;
import com.google.cloud.TransportOptions;
import com.google.cloud.WriteChannel;
import com.google.cloud.http.HttpTransportOptions;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.annotations.SingleBackend;
import com.google.cloud.storage.it.runner.registry.Generator;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@SingleBackend(Backend.PROD)
public class ITWriteChannelConnectionPoolTest {
  private static final byte[] BLOB_BYTE_CONTENT = {0xD, 0xE, 0xA, 0xD};
  private static final String BLOB_STRING_CONTENT = "Hello Google Cloud Storage!";

  @Inject public BucketInfo bucket;
  @Inject public Generator generator;

  private static class CustomHttpTransportFactory implements HttpTransportFactory {
    @Override
    @SuppressWarnings({"unchecked", "deprecation"})
    public HttpTransport create() {
      PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();
      manager.setMaxTotal(1);
      return new ApacheHttpTransport(HttpClients.createMinimal(manager));
    }
  }

  @Test
  public void testWriteChannelWithConnectionPool() throws IOException {
    TransportOptions transportOptions =
        HttpTransportOptions.newBuilder()
            .setHttpTransportFactory(new CustomHttpTransportFactory())
            .build();
    Storage storageWithPool =
        StorageOptions.http().setTransportOptions(transportOptions).build().getService();
    String blobName = generator.randomObjectName();
    BlobInfo blob = BlobInfo.newBuilder(bucket.getName(), blobName).build();
    byte[] stringBytes;
    try (WriteChannel writer = storageWithPool.writer(blob)) {
      stringBytes = BLOB_STRING_CONTENT.getBytes(UTF_8);
      writer.write(ByteBuffer.wrap(BLOB_BYTE_CONTENT));
      writer.write(ByteBuffer.wrap(stringBytes));
    }
    try (WriteChannel writer = storageWithPool.writer(blob)) {
      stringBytes = BLOB_STRING_CONTENT.getBytes(UTF_8);
      writer.write(ByteBuffer.wrap(BLOB_BYTE_CONTENT));
      writer.write(ByteBuffer.wrap(stringBytes));
    }
  }
}
