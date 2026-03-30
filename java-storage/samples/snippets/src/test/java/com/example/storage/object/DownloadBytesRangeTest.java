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

package com.example.storage.object;

import static com.google.common.truth.Truth.assertThat;

import com.example.storage.Env;
import com.example.storage.TestBase;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage.BlobTargetOption;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class DownloadBytesRangeTest extends TestBase {

  @Rule public final TemporaryFolder tmp = new TemporaryFolder();

  @Test
  public void testDownloadByteRange() throws IOException {
    byte[] bytes = { // 18 elements per row
      'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
      's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
      'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
      's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
      'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
      's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };

    BlobInfo gen1 =
        storage.create(
            BlobInfo.newBuilder(bucket, generator.randomObjectName()).build(),
            bytes,
            BlobTargetOption.doesNotExist());

    File file = tmp.newFile();

    int startByte = 14;
    int endBytes = 37;
    byte[] expectedBytes = Arrays.copyOfRange(bytes, startByte, endBytes);

    try {
      String destFileName = file.getAbsolutePath();
      BlobId id = gen1.getBlobId();
      DownloadByteRange.downloadByteRange(
          Env.GOOGLE_CLOUD_PROJECT,
          id.getBucket(),
          id.getName(),
          startByte,
          endBytes,
          destFileName);

      byte[] readBytes = Files.readAllBytes(Paths.get(destFileName));

      assertThat(stdOut.getCapturedOutputAsUtf8String()).contains("downloaded to");
      assertThat(stdOut.getCapturedOutputAsUtf8String()).contains("from byte 14 to byte 37");
      assertThat(readBytes).isEqualTo(expectedBytes);
    } finally {
      file.delete();
    }
  }
}
