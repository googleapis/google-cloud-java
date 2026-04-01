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

package com.google.cloud.storage;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.storage.UnifiedOpts.ObjectTargetOpt;
import com.google.cloud.storage.UnifiedOpts.SetContentType;
import com.google.storage.v2.Object;
import com.google.storage.v2.UpdateObjectRequest;
import com.google.storage.v2.WriteObjectRequest;
import com.google.storage.v2.WriteObjectSpec;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public final class DetectContentTypeTest {

  private final String objectName;
  private final String expectedContentType;
  private final SetContentType expected;

  public DetectContentTypeTest(String objectName, String expectedContentType) {
    this.objectName = objectName;
    this.expectedContentType = expectedContentType;
    this.expected = UnifiedOpts.setContentType(expectedContentType);
  }

  @Test
  public void blobId() {
    ObjectTargetOpt actual =
        UnifiedOpts.detectContentType().extractFromBlobId(BlobId.of("bucket", objectName));
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void blobInfo() {
    ObjectTargetOpt actual =
        UnifiedOpts.detectContentType()
            .extractFromBlobInfo(BlobInfo.newBuilder("bucket", objectName).build());
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void updateBlobInfo() {
    BlobInfo base = BlobInfo.newBuilder("bucket", objectName).build();
    BlobInfo actual =
        UnifiedOpts.detectContentType()
            .extractFromBlobInfo(base)
            .blobInfo()
            .apply(base.toBuilder())
            .build();
    BlobInfo expected = base.toBuilder().setContentType(expectedContentType).build();
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void writeObjectRequest() {
    WriteObjectRequest base =
        WriteObjectRequest.newBuilder()
            .setWriteObjectSpec(
                WriteObjectSpec.newBuilder()
                    .setResource(
                        Object.newBuilder().setBucket("bucket").setName(objectName).build())
                    .build())
            .build();
    WriteObjectRequest actual =
        UnifiedOpts.detectContentType()
            .extractFromBlobInfo(BlobInfo.newBuilder("bucket", objectName).build())
            .writeObject()
            .apply(base.toBuilder())
            .build();
    WriteObjectRequest.Builder b2 = base.toBuilder();
    b2.getWriteObjectSpecBuilder().getResourceBuilder().setContentType(expectedContentType);
    WriteObjectRequest expected = b2.build();
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void updateObjectRequest() {
    UpdateObjectRequest base =
        UpdateObjectRequest.newBuilder()
            .setObject(Object.newBuilder().setBucket("bucket").setName(objectName).build())
            .build();
    UpdateObjectRequest actual =
        UnifiedOpts.detectContentType()
            .extractFromBlobInfo(BlobInfo.newBuilder("bucket", objectName).build())
            .updateObject()
            .apply(base.toBuilder())
            .build();
    UpdateObjectRequest.Builder b2 = base.toBuilder();
    b2.getObjectBuilder().setContentType(expectedContentType);
    UpdateObjectRequest expected = b2.build();
    assertThat(actual).isEqualTo(expected);
  }

  @Parameters(name = "{0}")
  public static Iterable<java.lang.Object[]> data() {
    return Arrays.asList(
        new java.lang.Object[] {"file1.txt", "text/plain"},
        new java.lang.Object[] {"file.Jpg", "image/jpeg"},
        new java.lang.Object[] {"file", "application/octet-stream"});
  }
}
