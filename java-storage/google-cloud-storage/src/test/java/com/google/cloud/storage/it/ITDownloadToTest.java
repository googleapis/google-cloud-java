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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.TestUtils;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    transports = {Transport.HTTP, Transport.GRPC},
    backends = {Backend.PROD})
public final class ITDownloadToTest {

  private static final byte[] helloWorldTextBytes = "hello world".getBytes();
  private static final byte[] helloWorldGzipBytes = TestUtils.gzipBytes(helloWorldTextBytes);

  @Inject public Storage storage;
  @Inject public BucketInfo bucket;
  @Inject public Generator generator;

  private BlobId blobId;

  @Before
  public void before() {
    String objectString = generator.randomObjectName();
    blobId = BlobId.of(bucket.getName(), objectString);
    BlobInfo blobInfo =
        BlobInfo.newBuilder(blobId).setContentEncoding("gzip").setContentType("text/plain").build();
    storage.create(blobInfo, helloWorldGzipBytes);
  }

  @Test
  public void downloadTo_returnRawInputStream_yes() throws IOException {
    Path helloWorldTxtGz = File.createTempFile(blobId.getName(), ".txt.gz").toPath();
    storage.downloadTo(
        blobId, helloWorldTxtGz, Storage.BlobSourceOption.shouldReturnRawInputStream(true));

    byte[] actualTxtGzBytes = Files.readAllBytes(helloWorldTxtGz);
    if (Arrays.equals(actualTxtGzBytes, helloWorldTextBytes)) {
      fail("expected gzipped bytes, but got un-gzipped bytes");
    }
    assertThat(actualTxtGzBytes).isEqualTo(helloWorldGzipBytes);
  }

  @Test
  public void downloadTo_returnRawInputStream_no() throws IOException {
    Path helloWorldTxt = File.createTempFile(blobId.getName(), ".txt").toPath();
    storage.downloadTo(
        blobId, helloWorldTxt, Storage.BlobSourceOption.shouldReturnRawInputStream(false));
    byte[] actualTxtBytes = Files.readAllBytes(helloWorldTxt);
    assertThat(actualTxtBytes).isEqualTo(helloWorldTextBytes);
  }
}
