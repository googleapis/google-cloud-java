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
import static org.junit.Assert.assertThrows;

import com.google.cloud.storage.UnifiedOpts.Crc32cMatchExtractor;
import com.google.cloud.storage.UnifiedOpts.GenerationMatch;
import com.google.cloud.storage.UnifiedOpts.GenerationMatchExtractor;
import com.google.cloud.storage.UnifiedOpts.GenerationNotMatch;
import com.google.cloud.storage.UnifiedOpts.GenerationNotMatchExtractor;
import com.google.cloud.storage.UnifiedOpts.Md5MatchExtractor;
import com.google.cloud.storage.UnifiedOpts.MetagenerationMatchExtractor;
import com.google.cloud.storage.UnifiedOpts.MetagenerationNotMatchExtractor;
import com.google.cloud.storage.UnifiedOpts.NoOpObjectTargetOpt;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

public final class ObjectOptExtractorTest {

  @Test
  public void generationMatch_success() {
    GenerationMatchExtractor ex = UnifiedOpts.generationMatchExtractor();
    BlobId id = BlobId.of("b", "o", 7654L);
    BlobInfo info = BlobInfo.newBuilder(id).build();

    GenerationMatch expected = UnifiedOpts.generationMatch(7654);
    assertThat(ex.extractFromBlobId(id)).isEqualTo(expected);
    assertThat(ex.extractFromBlobInfo(info)).isEqualTo(expected);
  }

  @Test
  public void generationMatch_errorOnNull() {
    GenerationMatchExtractor ex = UnifiedOpts.generationMatchExtractor();
    BlobId id = BlobId.of("b", "o");
    BlobInfo info = BlobInfo.newBuilder(id).build();

    assertExceptions(
        () -> ex.extractFromBlobId(id), () -> ex.extractFromBlobInfo(info), "ifGenerationMatch");
  }

  @Test
  public void generationNotMatch_success() {
    GenerationNotMatchExtractor ex = UnifiedOpts.generationNotMatchExtractor();
    BlobId id = BlobId.of("b", "o", 7654L);
    BlobInfo info = BlobInfo.newBuilder(id).build();

    GenerationNotMatch expected = UnifiedOpts.generationNotMatch(7654);
    assertThat(ex.extractFromBlobId(id)).isEqualTo(expected);
    assertThat(ex.extractFromBlobInfo(info)).isEqualTo(expected);
  }

  @Test
  public void generationNotMatch_errorOnNull() {
    GenerationNotMatchExtractor ex = UnifiedOpts.generationNotMatchExtractor();
    BlobId id = BlobId.of("b", "o");
    BlobInfo info = BlobInfo.newBuilder(id).build();

    assertExceptions(
        () -> ex.extractFromBlobId(id), () -> ex.extractFromBlobInfo(info), "ifGenerationNotMatch");
  }

  @Test
  public void metagenerationMatch_success_blob() {
    MetagenerationMatchExtractor ex = UnifiedOpts.metagenerationMatchExtractor();
    BlobId id = BlobId.of("b", "o");
    BlobInfo info = BlobInfo.newBuilder(id).setMetageneration(3L).build();

    assertThat(ex.extractFromBlobId(id)).isEqualTo(NoOpObjectTargetOpt.INSTANCE);
    assertThat(ex.extractFromBlobInfo(info)).isEqualTo(UnifiedOpts.metagenerationMatch(3));
  }

  @Test
  public void metagenerationMatch_errorOnNull_blob() {
    MetagenerationMatchExtractor ex = UnifiedOpts.metagenerationMatchExtractor();
    BlobId id = BlobId.of("b", "o");
    BlobInfo info = BlobInfo.newBuilder(id).build();

    assertThat(ex.extractFromBlobId(id)).isEqualTo(NoOpObjectTargetOpt.INSTANCE);
    IllegalArgumentException e1 =
        assertThrows(IllegalArgumentException.class, () -> ex.extractFromBlobInfo(info));
    assertThat(e1).hasMessageThat().contains("ifMetagenerationMatch");
  }

  @Test
  public void metagenerationNotMatch_success_blob() {
    MetagenerationNotMatchExtractor ex = UnifiedOpts.metagenerationNotMatchExtractor();
    BlobId id = BlobId.of("b", "o");
    BlobInfo info = BlobInfo.newBuilder(id).setMetageneration(3L).build();

    assertThat(ex.extractFromBlobId(id)).isEqualTo(NoOpObjectTargetOpt.INSTANCE);
    assertThat(ex.extractFromBlobInfo(info)).isEqualTo(UnifiedOpts.metagenerationNotMatch(3));
  }

  @Test
  public void metagenerationNotMatch_errorOnNull_blob() {
    MetagenerationNotMatchExtractor ex = UnifiedOpts.metagenerationNotMatchExtractor();
    BlobId id = BlobId.of("b", "o");
    BlobInfo info = BlobInfo.newBuilder(id).build();

    assertThat(ex.extractFromBlobId(id)).isEqualTo(NoOpObjectTargetOpt.INSTANCE);
    IllegalArgumentException e1 =
        assertThrows(IllegalArgumentException.class, () -> ex.extractFromBlobInfo(info));
    assertThat(e1).hasMessageThat().contains("ifMetagenerationNotMatch");
  }

  @Test
  public void metagenerationMatch_success_bucket() {
    MetagenerationMatchExtractor ex = UnifiedOpts.metagenerationMatchExtractor();
    BucketInfo info = BucketInfo.newBuilder("b").setMetageneration(3L).build();

    assertThat(ex.extractFromBucketInfo(info)).isEqualTo(UnifiedOpts.metagenerationMatch(3));
  }

  @Test
  public void metagenerationMatch_errorOnNull_bucket() {
    MetagenerationMatchExtractor ex = UnifiedOpts.metagenerationMatchExtractor();
    BucketInfo info = BucketInfo.newBuilder("b").build();

    IllegalArgumentException e1 =
        assertThrows(IllegalArgumentException.class, () -> ex.extractFromBucketInfo(info));
    assertThat(e1).hasMessageThat().contains("ifMetagenerationMatch");
  }

  @Test
  public void metagenerationNotMatch_success_bucket() {
    MetagenerationNotMatchExtractor ex = UnifiedOpts.metagenerationNotMatchExtractor();
    BucketInfo info = BucketInfo.newBuilder("b").setMetageneration(3L).build();

    assertThat(ex.extractFromBucketInfo(info)).isEqualTo(UnifiedOpts.metagenerationNotMatch(3));
  }

  @Test
  public void metagenerationNotMatch_errorOnNull_bucket() {
    MetagenerationNotMatchExtractor ex = UnifiedOpts.metagenerationNotMatchExtractor();
    BucketInfo info = BucketInfo.newBuilder("b").build();

    IllegalArgumentException e1 =
        assertThrows(IllegalArgumentException.class, () -> ex.extractFromBucketInfo(info));
    assertThat(e1).hasMessageThat().contains("ifMetagenerationNotMatch");
  }

  @Test
  public void md5Match_success() {
    Md5MatchExtractor ex = UnifiedOpts.md5MatchExtractor();
    BlobId id = BlobId.of("b", "o");
    BlobInfo info = BlobInfo.newBuilder(id).setMd5("md5").build();

    assertThat(ex.extractFromBlobId(id)).isEqualTo(NoOpObjectTargetOpt.INSTANCE);
    assertThat(ex.extractFromBlobInfo(info)).isEqualTo(UnifiedOpts.md5Match("md5"));
  }

  @Test
  public void md5Match_noOpOnNull() {
    Md5MatchExtractor ex = UnifiedOpts.md5MatchExtractor();
    BlobId id = BlobId.of("b", "o");
    BlobInfo info = BlobInfo.newBuilder(id).build();

    assertThat(ex.extractFromBlobId(id)).isEqualTo(NoOpObjectTargetOpt.INSTANCE);
    assertThat(ex.extractFromBlobInfo(info)).isEqualTo(NoOpObjectTargetOpt.INSTANCE);
  }

  @Test
  public void crc32cMatch_success() {
    Crc32cMatchExtractor ex = UnifiedOpts.crc32cMatchExtractor();
    BlobId id = BlobId.of("b", "o");
    BlobInfo info = BlobInfo.newBuilder(id).setCrc32c("crc32c").build();

    assertThat(ex.extractFromBlobId(id)).isEqualTo(NoOpObjectTargetOpt.INSTANCE);
    assertThat(ex.extractFromBlobInfo(info)).isEqualTo(UnifiedOpts.crc32cMatch("crc32c"));
  }

  @Test
  public void crc32cMatch_noOpOnNull() {
    Crc32cMatchExtractor ex = UnifiedOpts.crc32cMatchExtractor();
    BlobId id = BlobId.of("b", "o");
    BlobInfo info = BlobInfo.newBuilder(id).build();

    assertThat(ex.extractFromBlobId(id)).isEqualTo(NoOpObjectTargetOpt.INSTANCE);
    assertThat(ex.extractFromBlobInfo(info)).isEqualTo(NoOpObjectTargetOpt.INSTANCE);
  }

  private static void assertExceptions(ThrowingRunnable r1, ThrowingRunnable r2, String contains) {
    IllegalArgumentException e1 = assertThrows(IllegalArgumentException.class, r1);
    assertThat(e1).hasMessageThat().contains(contains);
    IllegalArgumentException e2 = assertThrows(IllegalArgumentException.class, r2);
    assertThat(e2).hasMessageThat().contains(contains);
  }
}
