/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.storage.transfermanager;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.transfermanager.ParallelUploadConfig.UploadBlobInfoFactory;
import java.util.function.Function;
import org.junit.Test;

public final class TransferManagerTest {

  @Test
  public void uploadBlobInfoFactory_prefixObjectNames_leadingSlash() {
    UploadBlobInfoFactory factory = UploadBlobInfoFactory.prefixObjectNames("asdf");

    BlobInfo info = factory.apply("bucket", "/f/i/l/e/n/a/m/e.txt");
    assertThat(info.getBucket()).isEqualTo("bucket");
    assertThat(info.getName()).isEqualTo("asdf/f/i/l/e/n/a/m/e.txt");
  }

  @Test
  public void uploadBlobInfoFactory_prefixObjectNames() {
    UploadBlobInfoFactory factory = UploadBlobInfoFactory.prefixObjectNames("asdf");

    BlobInfo info = factory.apply("bucket", "n/a/m/e.txt");
    assertThat(info.getBucket()).isEqualTo("bucket");
    assertThat(info.getName()).isEqualTo("asdf/n/a/m/e.txt");
  }

  @Test
  public void uploadBlobInfoFactory_transformFileName() {
    UploadBlobInfoFactory factory =
        UploadBlobInfoFactory.transformFileName(
            Function.<String>identity().andThen(s -> s + "|").compose(s -> "|" + s));

    BlobInfo info = factory.apply("bucket", "/e.txt");
    assertThat(info.getBucket()).isEqualTo("bucket");
    assertThat(info.getName()).isEqualTo("|/e.txt|");
  }

  @Test
  public void uploadBlobInfoFactory_default_doesNotModify() {
    UploadBlobInfoFactory factory = UploadBlobInfoFactory.defaultInstance();

    BlobInfo info = factory.apply("bucket", "/e.txt");
    assertThat(info.getBucket()).isEqualTo("bucket");
    assertThat(info.getName()).isEqualTo("/e.txt");
  }
}
