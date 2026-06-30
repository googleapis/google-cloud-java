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

package com.google.cloud.storage;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public final class ReadProjectionConfigsTest {

  @Test
  public void sameInstanceMustBeReturnedIfNoChange_seekable_hasher_true() {
    ReadAsSeekableChannel config1 = ReadProjectionConfigs.asSeekableChannel();

    assertThat(config1.getCrc32cValidationEnabled()).isEqualTo(true);

    ReadAsSeekableChannel config2 = config1.withCrc32cValidationEnabled(true);
    assertThat(config2).isSameInstanceAs(config1);
  }

  @Test
  public void sameInstanceMustBeReturnedIfNoChange_seekable_hasher_false() {
    ReadAsSeekableChannel config1 =
        ReadProjectionConfigs.asSeekableChannel().withCrc32cValidationEnabled(false);

    assertThat(config1.getCrc32cValidationEnabled()).isEqualTo(false);

    ReadAsSeekableChannel config2 = config1.withCrc32cValidationEnabled(false);
    assertThat(config2).isSameInstanceAs(config1);
  }

  @Test
  public void differentInstanceWhenChanged_seekable_hasher() {
    ReadAsSeekableChannel config1 = ReadProjectionConfigs.asSeekableChannel();
    ReadAsSeekableChannel config2 = config1.withCrc32cValidationEnabled(false);

    assertThat(config2).isNotSameInstanceAs(config1);
  }

  @Test
  public void sameInstanceMustBeReturnedIfNoChange_bytes_hasher_true() {
    ReadAsFutureBytes config1 = ReadProjectionConfigs.asFutureBytes();

    assertThat(config1.getCrc32cValidationEnabled()).isEqualTo(true);

    ReadAsFutureBytes config2 = config1.withCrc32cValidationEnabled(true);
    assertThat(config2).isSameInstanceAs(config1);
  }

  @Test
  public void sameInstanceMustBeReturnedIfNoChange_bytes_hasher_false() {
    ReadAsFutureBytes config1 =
        ReadProjectionConfigs.asFutureBytes().withCrc32cValidationEnabled(false);

    assertThat(config1.getCrc32cValidationEnabled()).isEqualTo(false);

    ReadAsFutureBytes config2 = config1.withCrc32cValidationEnabled(false);
    assertThat(config2).isSameInstanceAs(config1);
  }

  @Test
  public void differentInstanceWhenChanged_bytes_hasher() {
    ReadAsFutureBytes config1 = ReadProjectionConfigs.asFutureBytes();
    ReadAsFutureBytes config2 = config1.withCrc32cValidationEnabled(false);

    assertThat(config2).isNotSameInstanceAs(config1);
  }

  @Test
  public void sameInstanceMustBeReturnedIfNoChange_byteString_hasher_true() {
    ReadAsFutureByteString config1 = ReadProjectionConfigs.asFutureByteString();

    assertThat(config1.getCrc32cValidationEnabled()).isEqualTo(true);

    ReadAsFutureByteString config2 = config1.withCrc32cValidationEnabled(true);
    assertThat(config2).isSameInstanceAs(config1);
  }

  @Test
  public void sameInstanceMustBeReturnedIfNoChange_byteString_hasher_false() {
    ReadAsFutureByteString config1 =
        ReadProjectionConfigs.asFutureByteString().withCrc32cValidationEnabled(false);

    assertThat(config1.getCrc32cValidationEnabled()).isEqualTo(false);

    ReadAsFutureByteString config2 = config1.withCrc32cValidationEnabled(false);
    assertThat(config2).isSameInstanceAs(config1);
  }

  @Test
  public void differentInstanceWhenChanged_byteString_hasher() {
    ReadAsFutureByteString config1 = ReadProjectionConfigs.asFutureByteString();
    ReadAsFutureByteString config2 = config1.withCrc32cValidationEnabled(false);

    assertThat(config2).isNotSameInstanceAs(config1);
  }

  @Test
  public void sameInstanceMustBeReturnedIfNoChange_channel_hasher_true() {
    ReadAsChannel config1 = ReadProjectionConfigs.asChannel();

    assertThat(config1.getCrc32cValidationEnabled()).isEqualTo(true);

    ReadAsChannel config2 = config1.withCrc32cValidationEnabled(true);
    assertThat(config2).isSameInstanceAs(config1);
  }

  @Test
  public void sameInstanceMustBeReturnedIfNoChange_channel_hasher_false() {
    ReadAsChannel config1 = ReadProjectionConfigs.asChannel().withCrc32cValidationEnabled(false);

    assertThat(config1.getCrc32cValidationEnabled()).isEqualTo(false);

    ReadAsChannel config2 = config1.withCrc32cValidationEnabled(false);
    assertThat(config2).isSameInstanceAs(config1);
  }

  @Test
  public void differentInstanceWhenChanged_channel_hasher() {
    ReadAsChannel config1 = ReadProjectionConfigs.asChannel();
    ReadAsChannel config2 = config1.withCrc32cValidationEnabled(false);

    assertThat(config2).isNotSameInstanceAs(config1);
  }
}
