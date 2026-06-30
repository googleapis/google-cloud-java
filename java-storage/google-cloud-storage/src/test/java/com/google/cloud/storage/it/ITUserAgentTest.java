/*
 * Copyright 2023 Google LLC
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

import static com.google.common.truth.Truth.assertThat;

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.DataGenerator;
import com.google.cloud.storage.HttpStorageOptions;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.annotations.SingleBackend;
import com.google.cloud.storage.it.runner.annotations.StorageFixture;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.common.collect.ImmutableList;
import java.util.Objects;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@SingleBackend(Backend.PROD)
public final class ITUserAgentTest {

  @Inject
  @StorageFixture(Transport.HTTP)
  public Storage storage;

  @Inject public BucketInfo bucket;
  @Inject public Generator generator;

  @Test
  public void userAgentIncludesGcloudJava_writer_http() throws Exception {
    RequestAuditing requestAuditing = new RequestAuditing();
    HttpStorageOptions options2 =
        StorageOptions.http().setTransportOptions(requestAuditing).build();
    try (Storage storage = options2.getService()) {
      try (WriteChannel writer =
          storage.writer(BlobInfo.newBuilder(bucket, generator.randomObjectName()).build())) {
        writer.write(DataGenerator.base64Characters().genByteBuffer(13));
      }
    }

    ImmutableList<String> userAgents =
        requestAuditing.getRequests().stream()
            .map(HttpRequest::getHeaders)
            .map(HttpHeaders::getUserAgent)
            .filter(Objects::nonNull)
            .collect(ImmutableList.toImmutableList());

    ImmutableList<String> found =
        userAgents.stream()
            .filter(ua -> ua.contains("gcloud-java/"))
            .collect(ImmutableList.toImmutableList());
    assertThat(found).hasSize(2); // one for the create session, and one for the PUT and finalize
  }
}
