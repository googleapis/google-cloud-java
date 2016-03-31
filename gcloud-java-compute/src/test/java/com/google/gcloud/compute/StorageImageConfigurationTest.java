/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.gcloud.compute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.gcloud.compute.ImageConfiguration.SourceType;
import com.google.gcloud.compute.StorageImageConfiguration.ContainerType;
import com.google.gcloud.compute.ImageConfiguration.Type;

import org.junit.Test;

public class StorageImageConfigurationTest {

  private static final String SOURCE = "source";
  private static final SourceType SOURCE_TYPE = SourceType.RAW;
  private static final ContainerType CONTAINER_TYPE = ContainerType.TAR;
  private static final Long ARCHIVE_SIZE_BYTES = 42L;
  private static final String SHA1 = "sha1";
  private static final StorageImageConfiguration CONFIGURATION =
      StorageImageConfiguration.builder(SOURCE)
          .sourceType(SOURCE_TYPE)
          .containerType(CONTAINER_TYPE)
          .archiveSizeBytes(ARCHIVE_SIZE_BYTES)
          .sha1(SHA1)
          .build();

  @Test
  public void testToBuilder() {
    compareRawImageConfiguration(CONFIGURATION, CONFIGURATION.toBuilder().build());
    String newSource = "newSource";
    StorageImageConfiguration configuration = CONFIGURATION.toBuilder().source(newSource).build();
    assertEquals(newSource, configuration.source());
    configuration = configuration.toBuilder().source(SOURCE).build();
    compareRawImageConfiguration(CONFIGURATION, configuration);
  }

  @Test
  public void testToBuilderIncomplete() {
    StorageImageConfiguration configuration = StorageImageConfiguration.of(SOURCE);
    compareRawImageConfiguration(configuration, configuration.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(SOURCE_TYPE, CONFIGURATION.sourceType());
    assertEquals(SOURCE, CONFIGURATION.source());
    assertEquals(CONTAINER_TYPE, CONFIGURATION.containerType());
    assertEquals(ARCHIVE_SIZE_BYTES, CONFIGURATION.archiveSizeBytes());
    assertEquals(SHA1, CONFIGURATION.sha1());
    assertEquals(Type.STORAGE, CONFIGURATION.type());
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
    assertEquals(Type.STORAGE, configuration.type());
    assertNull(configuration.sourceType());
    assertEquals(SOURCE, configuration.source());
    assertNull(configuration.containerType());
    assertNull(configuration.archiveSizeBytes());
    assertNull(configuration.sha1());
  }

  @Test
  public void testSetProjectId() {
    assertSame(CONFIGURATION, CONFIGURATION.setProjectId("project"));
  }

  private void compareRawImageConfiguration(StorageImageConfiguration expected,
      StorageImageConfiguration value) {
    assertEquals(expected, value);
    assertEquals(expected.type(), value.type());
    assertEquals(expected.source(), value.source());
    assertEquals(expected.sourceType(), value.sourceType());
    assertEquals(expected.containerType(), value.containerType());
    assertEquals(expected.archiveSizeBytes(), value.archiveSizeBytes());
    assertEquals(expected.sha1(), value.sha1());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
