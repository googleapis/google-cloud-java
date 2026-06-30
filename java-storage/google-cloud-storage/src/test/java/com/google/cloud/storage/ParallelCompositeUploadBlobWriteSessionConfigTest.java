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

package com.google.cloud.storage;

import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import com.google.cloud.storage.MetadataField.PartRange;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.PartMetadataFieldDecorator;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.PartNamingStrategy;
import com.google.common.truth.StringSubject;
import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Locale;
import org.junit.Test;

public final class ParallelCompositeUploadBlobWriteSessionConfigTest {

  @Test
  public void partNameStrategy_noPrefix() throws Exception {
    PartNamingStrategy strategy = PartNamingStrategy.noPrefix();

    String fmt = strategy.fmtName("object23", PartRange.of(1, 32));
    assertAll(
        // random digest to spread over keyspace
        () -> assertField(fmt, 0).hasLength(22),
        // name digest
        () -> assertField(fmt, 1).hasLength(22),
        () -> assertField(fmt, 2).isEqualTo("0001-0032.part"));
  }

  @Test
  public void partNameStrategy_prefix() throws Exception {
    PartNamingStrategy strategy = PartNamingStrategy.prefix("asdf");

    String fmt = strategy.fmtName("301object23", PartRange.of(1, 96));
    assertAll(
        // random digest with prefix to spread over keyspace
        // digest is 22, prefix is 4, slash is 1
        () -> assertField(fmt, 0).hasLength(22 + 5),
        // name digest
        () -> assertField(fmt, 1).hasLength(22),
        () -> assertField(fmt, 2).isEqualTo("0001-0096.part"),
        () -> assertThat(fmt).startsWith("asdf/"));
  }

  @Test
  public void partNameStrategy_prefix_stillWorksWithFmtPattern() throws Exception {
    PartNamingStrategy strategy = PartNamingStrategy.prefix("[%s]");

    String fmt = strategy.fmtName("301object23", PartRange.of(1, 96));
    assertAll(
        // random digest with prefix to spread over keyspace
        // digest is 22, prefix is 4, slash is 1
        () -> assertField(fmt, 0).hasLength(22 + 5),
        // name digest
        () -> assertField(fmt, 1).hasLength(22),
        () -> assertField(fmt, 2).isEqualTo("0001-0096.part"),
        () -> assertThat(fmt).startsWith("[%s]/"));
  }

  @Test
  public void partNameStrategy_objectNamePrefix() throws Exception {
    // Creating an object level prefix without specifying an additional prefix will append the
    // object name to the beginning of the part name.
    PartNamingStrategy strategy = PartNamingStrategy.useObjectNameAsPrefix();

    String fmt = strategy.fmtName("a/b/obj", PartRange.of(1, 96));
    assertAll(
        // random digest with prefix to spread over keyspace
        // digest is 22, objectName is 7, slash is 1
        () -> assertField(fmt, 0).hasLength(22 + 8),
        // name digest
        () -> assertField(fmt, 1).hasLength(22),
        () -> assertField(fmt, 2).isEqualTo("0001-0096.part"),
        () -> assertThat(fmt).startsWith("a/b/obj"));
  }

  @Test
  public void partMetadataFieldDecorator_customTime() {
    BlobInfo.Builder testBlob = BlobInfo.newBuilder("testBlob", "testBucket");
    Duration duration = Duration.ofSeconds(30);
    TestClock clock = TestClock.tickBy(Instant.EPOCH, Duration.ofSeconds(1));
    OffsetDateTime expected =
        OffsetDateTime.from(Instant.EPOCH.plus(duration).atZone(ZoneId.of("Z")));
    PartMetadataFieldDecorator.setCustomTimeInFuture(duration).newInstance(clock).apply(testBlob);

    assertThat(expected).isEqualTo(testBlob.build().getCustomTimeOffsetDateTime());
  }

  private static StringSubject assertField(String fmt, int idx) {
    String[] split = fmt.split(";");
    String s = split[idx];
    return assertWithMessage(
            String.format(Locale.US, "Formatted name '%s', field[%d] = %s", fmt, idx, s))
        .that(s);
  }
}
