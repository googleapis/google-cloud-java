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

package com.google.cloud.storage.contrib.nio;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.spi.FileSystemProvider;

/**
 * Unit tests for {@link CloudStorageFileSystemProvider} when gcloud is not configured.
 */
//@RunWith(JUnit4.class)
@Ignore // these tests must be run manually because they require gcloud to NOT be configured.
public class CloudStorageLateInitializationTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  @BeforeClass
  public static void beforeClass() {
    if (System.getenv().containsKey("GOOGLE_APPLICATION_CREDENTIALS")) {
      throw new RuntimeException("CloudStorageLateInitializationTest can only be run if gcloud is not configured. This means no GOOGLE_APPLICATION_CREDENTIALS environment variable.");
    }
    // actually that one's OK so long as it doesn't point to a valid configuration, but it's simpler
    // to check that it isn't there.
    if (System.getenv().containsKey("CLOUDSDK_CONFIG")) {
      throw new RuntimeException("CloudStorageLateInitializationTest can only be run if gcloud is" +
          " not configured. This means no CLOUDSDK_CONFIG environment variable.");
    }
    if (Files.exists(Paths.get(System.getenv("HOME"), ".config/gcloud/properties"))) {
      throw new RuntimeException("CloudStorageLateInitializationTest can only be run if gcloud is" +
          " not configured. This means no ~/.config/gcloud/properties.");
    }
    if (Files.exists(Paths.get(System.getenv("HOME"), ".config/gcloud/active_config"))) {
      throw new RuntimeException("CloudStorageLateInitializationTest can only be run if gcloud is" +
          " not configured. This means no ~/.config/gcloud/active_config.");
    }
  }

  @Test(expected = java.lang.IllegalArgumentException.class)
  public void pathFailsIfNoEnvVariable() throws IOException {
    // this should fail if we haven't set GOOGLE_APPLICATION_CREDENTIALS nor CLOUDSDK_CONFIG
    // *and* we don't have a ~/.config/gcloud/properties file (or %APPDATA%/gcloud in Windows)
    // and we don't have a ~/.config/gcloud/active-config.
    // (since we're also not providing credentials in any other way)
    Paths.get(URI.create("gs://bucket/wat"));
  }

  @Test
  public void enumerateFilesystemsIfNoEnvVariable() throws IOException {
    // listing available filesystem providers should work even if we can't initialize
    // CloudStorageFilesystemProvider. This makes it possible to use other filesystems
    // when gcloud-java is in the classpath but gcloud isn't configured.
    System.out.println("Installed filesystem providers:");
    for (FileSystemProvider p : FileSystemProvider.installedProviders()) {
      System.out.println("  " + p.getScheme());
    }
  }

}
