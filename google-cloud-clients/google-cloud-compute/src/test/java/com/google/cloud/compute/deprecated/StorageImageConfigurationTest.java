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

package com.google.cloud.compute.deprecated;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StorageImageConfigurationTest {

  private static final String SOURCE = "source";
  private static final ImageConfiguration.SourceType SOURCE_TYPE =
      ImageConfiguration.SourceType.RAW;
  private static final StorageImageConfiguration.ContainerType CONTAINER_TYPE =
      StorageImageConfiguration.ContainerType.TAR;
  private static final Long ARCHIVE_SIZE_BYTES = 42L;
  private static final String SHA1 = "sha1";
  private static final StorageImageConfiguration CONFIGURATION =
      StorageImageConfiguration.newBuilder(SOURCE)
          .setSourceType(SOURCE_TYPE)
          .setContainerType(CONTAINER_TYPE)
          .setArchiveSizeBytes(ARCHIVE_SIZE_BYTES)
          .setSha1(SHA1)
          .build();

  @Test
  public void testToBuilder() {
    compareRawImageConfiguration(CONFIGURATION, CONFIGURATION.toBuilder().build());
    String newSource = "newSource";
    StorageImageConfiguration configuration = CONFIGURATION.toBuilder().setSource(newSource).build();
    assertEquals(newSource, configuration.getSource());
    configuration = configuration.toBuilder().setSource(SOURCE).build();
    compareRawImageConfiguration(CONFIGURATION, configuration);
  }

  @Test
  public void testToBuilderIncomplete() {
    StorageImageConfiguration configuration = StorageImageConfiguration.of(SOURCE);
    compareRawImageConfiguration(configuration, configuration.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(SOURCE_TYPE, CONFIGURATION.getSourceType());
    assertEquals(SOURCE, CONFIGURATION.getSource());
    assertEquals(CONTAINER_TYPE, CONFIGURATION.getContainerType());
    assertEquals(ARCHIVE_SIZE_BYTES, CONFIGURATION.getArchiveSizeBytes());
    assertEquals(SHA1, CONFIGURATION.getSha1());
    assertEquals(ImageConfiguration.Type.STORAGE, CONFIGURATION.getType());
  }

  @Test
  public void testToAndFromPb() {
    assertTrue(ImageConfiguration.fromPb(CONFIGURATION.toPb()) instanceof StorageImageConfiguration);
    compareRawImageConfiguration(CONFIGURATION,
        ImageConfiguration.<StorageImageConfiguration>fromPb(CONFIGURATION.toPb()));
    StorageImageConfiguration configuration = StorageImageConfiguration.of(SOURCE);
    compareRawImageConfiguration(configuration,
        StorageImageConfiguration.fromPb(configuration.toPb()));
  }

  @Test
  public void testOf() {
    StorageImageConfiguration configuration = StorageImageConfiguration.of(SOURCE);
    assertEquals(ImageConfiguration.Type.STORAGE, configuration.getType());
    assertNull(configuration.getSourceType());
    assertEquals(SOURCE, configuration.getSource());
    assertNull(configuration.getContainerType());
    assertNull(configuration.getArchiveSizeBytes());
    assertNull(configuration.getSha1());
  }

  @Test
  public void testSetProjectId() {
    assertSame(CONFIGURATION, CONFIGURATION.setProjectId("project"));
  }

  private void compareRawImageConfiguration(StorageImageConfiguration expected,
      StorageImageConfiguration value) {
    assertEquals(expected, value);
    assertEquals(expected.getType(), value.getType());
    assertEquals(expected.getSource(), value.getSource());
    assertEquals(expected.getSourceType(), value.getSourceType());
    assertEquals(expected.getContainerType(), value.getContainerType());
    assertEquals(expected.getArchiveSizeBytes(), value.getArchiveSizeBytes());
    assertEquals(expected.getSha1(), value.getSha1());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
