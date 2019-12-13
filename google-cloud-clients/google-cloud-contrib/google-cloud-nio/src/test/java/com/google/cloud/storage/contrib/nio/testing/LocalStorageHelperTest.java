/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.storage.contrib.nio.testing;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link LocalStorageHelper}. */
@RunWith(JUnit4.class)
public class LocalStorageHelperTest {

  Storage localStorageService = null;
  private final String testBucket = "bucket";
  private final String sourceFile = "testSource";
  private final String destinationFile = "testDestination";
  private final String payload = "copy me";

  @Before
  public void before() throws IOException {
    localStorageService = LocalStorageHelper.getOptions().getService();

    byte[] payloadBytes = payload.getBytes();
    BlobId id = BlobId.of(testBucket, sourceFile);
    BlobInfo info = BlobInfo.newBuilder(id).build();

    WriteChannel writer = localStorageService.writer(info);
    try {
      writer.write(ByteBuffer.wrap(payloadBytes));
    } finally {
      writer.close();
    }
  }

  @After
  public void after() {
    localStorageService.delete(testBucket, sourceFile);
    localStorageService.delete(testBucket, destinationFile);
  }

  private Storage.CopyRequest copyRequest() {
    Storage.CopyRequest request =
        Storage.CopyRequest.newBuilder()
            .setSource(BlobId.of(testBucket, sourceFile))
            .setTarget(BlobId.of(testBucket, destinationFile))
            .build();

    return request;
  }

  @Test
  public void testCopyCanBeRead() throws Exception {
    Storage.CopyRequest request = copyRequest();
    localStorageService.copy(request).getResult();
    Blob obj = localStorageService.get(BlobId.of(testBucket, destinationFile));
    String copiedContents = new String(obj.getContent(Blob.BlobSourceOption.generationMatch()));
    File file = File.createTempFile("file", ".txt");
    file.deleteOnExit();
    obj.downloadTo(file.toPath());
    Assert.assertArrayEquals(payload.getBytes(), Files.readAllBytes(file.toPath()));

    assertThat(copiedContents).isEqualTo(payload);
    assertThat(obj.getGeneration()).isEqualTo(1);
    assertThat(obj.getSize()).isEqualTo(7);
  }

  @Test
  public void testCopyIncrementsGenerations() {
    Storage.CopyRequest request = copyRequest();

    localStorageService.copy(request).getResult();
    localStorageService.copy(request).getResult();
    Blob obj = localStorageService.get(BlobId.of(testBucket, destinationFile));
    String copiedContents = new String(obj.getContent(Blob.BlobSourceOption.generationMatch()));

    assertThat(copiedContents).isEqualTo(payload);
    assertThat(obj.getGeneration()).isEqualTo(2);
    assertThat(obj.getSize()).isEqualTo(7);
  }
}
