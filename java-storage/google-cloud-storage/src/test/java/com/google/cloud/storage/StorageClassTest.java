/*
 * Copyright 2026 Google LLC
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import java.util.Arrays;
import org.junit.Test;
public class StorageClassTest {
  @Test
  public void testEnumInstances() {
    assertThat(StorageClass.STANDARD.toString()).isEqualTo("STANDARD");
    assertThat(StorageClass.NEARLINE.toString()).isEqualTo("NEARLINE");
    assertThat(StorageClass.COLDLINE.toString()).isEqualTo("COLDLINE");
    assertThat(StorageClass.ARCHIVE.toString()).isEqualTo("ARCHIVE");
    assertThat(StorageClass.REGIONAL.toString()).isEqualTo("REGIONAL");
    assertThat(StorageClass.MULTI_REGIONAL.toString()).isEqualTo("MULTI_REGIONAL");
    assertThat(StorageClass.DURABLE_REDUCED_AVAILABILITY.toString())
        .isEqualTo("DURABLE_REDUCED_AVAILABILITY");
    assertThat(StorageClass.STANDARD_ENTERPRISE.toString()).isEqualTo("STANDARD_ENTERPRISE");
    assertThat(StorageClass.LR_STANDARD_ENTERPRISE.toString()).isEqualTo("LR_STANDARD_ENTERPRISE");
    assertThat(StorageClass.STANDARD_FLEXBACKUP_ENTERPRISE.toString())
        .isEqualTo("STANDARD_FLEXBACKUP_ENTERPRISE");
  }
  @Test
  public void testValueOf() {
    assertSame(StorageClass.STANDARD, StorageClass.valueOf("STANDARD"));
    assertSame(StorageClass.NEARLINE, StorageClass.valueOf("NEARLINE"));
    assertSame(StorageClass.COLDLINE, StorageClass.valueOf("COLDLINE"));
    assertSame(StorageClass.ARCHIVE, StorageClass.valueOf("ARCHIVE"));
    assertSame(StorageClass.REGIONAL, StorageClass.valueOf("REGIONAL"));
    assertSame(StorageClass.MULTI_REGIONAL, StorageClass.valueOf("MULTI_REGIONAL"));
    assertSame(
        StorageClass.DURABLE_REDUCED_AVAILABILITY,
        StorageClass.valueOf("DURABLE_REDUCED_AVAILABILITY"));
    assertSame(StorageClass.STANDARD_ENTERPRISE, StorageClass.valueOf("STANDARD_ENTERPRISE"));
    assertSame(StorageClass.LR_STANDARD_ENTERPRISE, StorageClass.valueOf("LR_STANDARD_ENTERPRISE"));
    assertSame(
        StorageClass.STANDARD_FLEXBACKUP_ENTERPRISE,
        StorageClass.valueOf("STANDARD_FLEXBACKUP_ENTERPRISE"));
    assertEquals(
        "NonExistentStorageClass", StorageClass.valueOf("NonExistentStorageClass").toString());
  }
  @Test
  public void testValueOfStrict() {
    assertSame(StorageClass.STANDARD, StorageClass.valueOfStrict("STANDARD"));
    assertSame(StorageClass.NEARLINE, StorageClass.valueOfStrict("NEARLINE"));
    assertSame(StorageClass.COLDLINE, StorageClass.valueOfStrict("COLDLINE"));
    assertSame(StorageClass.ARCHIVE, StorageClass.valueOfStrict("ARCHIVE"));
    assertSame(StorageClass.REGIONAL, StorageClass.valueOfStrict("REGIONAL"));
    assertSame(StorageClass.MULTI_REGIONAL, StorageClass.valueOfStrict("MULTI_REGIONAL"));
    assertSame(
        StorageClass.DURABLE_REDUCED_AVAILABILITY,
        StorageClass.valueOfStrict("DURABLE_REDUCED_AVAILABILITY"));
    assertSame(
        StorageClass.STANDARD_ENTERPRISE, StorageClass.valueOfStrict("STANDARD_ENTERPRISE"));
    assertSame(
        StorageClass.LR_STANDARD_ENTERPRISE, StorageClass.valueOfStrict("LR_STANDARD_ENTERPRISE"));
    assertSame(
        StorageClass.STANDARD_FLEXBACKUP_ENTERPRISE,
        StorageClass.valueOfStrict("STANDARD_FLEXBACKUP_ENTERPRISE"));
  }
  @Test
  public void testValueOfStrict_invalid() {
    IllegalArgumentException ex =
        assertThrows(
            IllegalArgumentException.class,
            () -> StorageClass.valueOfStrict("NonExistentStorageClass"));
    assertNotNull(ex.getMessage());
  }
  @Test
  public void testValues() {
    assertThat(
            Arrays.asList(StorageClass.values())
                .containsAll(
                    Arrays.asList(
                        StorageClass.STANDARD,
                        StorageClass.NEARLINE,
                        StorageClass.COLDLINE,
                        StorageClass.ARCHIVE,
                        StorageClass.REGIONAL,
                        StorageClass.MULTI_REGIONAL,
                        StorageClass.DURABLE_REDUCED_AVAILABILITY,
                        StorageClass.STANDARD_ENTERPRISE,
                        StorageClass.LR_STANDARD_ENTERPRISE,
                        StorageClass.STANDARD_FLEXBACKUP_ENTERPRISE)))
        .isTrue();
  }
}
