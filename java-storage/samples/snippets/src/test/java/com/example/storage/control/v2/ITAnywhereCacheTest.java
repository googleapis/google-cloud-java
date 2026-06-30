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

package com.example.storage.control.v2;

import static org.junit.Assume.assumeTrue;

import com.example.storage.TestBase;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.cloud.storage.it.runner.registry.Zone;
import com.google.common.base.Strings;
import com.google.storage.control.v2.AnywhereCacheName;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import org.junit.Before;
import org.junit.Test;

public final class ITAnywhereCacheTest extends TestBase {

  @Inject public Zone zone;
  @Inject public Generator generator;

  private String cacheName;

  @Before
  public void setUp() {
    assumeTrue(
        "AnywhereCache sample tests skipped in CI due to very long operation times.",
        Strings.isNullOrEmpty(System.getenv("JOB_TYPE")));
    cacheName = generator.randomObjectName();
  }

  @Test
  public void create() throws IOException, ExecutionException, InterruptedException {
    AnywhereCacheCreate.anywhereCacheCreate(bucket.getName(), cacheName, zone.getZone());
  }

  @Test
  public void get() throws IOException {
    AnywhereCacheGet.anywhereCacheGet(AnywhereCacheName.format("_", bucket.getName(), cacheName));
  }

  @Test
  public void list() throws IOException {
    AnywhereCacheList.anywhereCacheList(bucket.getName());
  }

  @Test
  public void update() throws IOException, ExecutionException, InterruptedException {
    AnywhereCacheUpdate.anywhereCacheUpdate(cacheName, "admit-on-second-miss");
  }

  @Test
  public void pause() throws IOException {
    AnywhereCachePause.anywhereCachePause(
        AnywhereCacheName.format("_", bucket.getName(), cacheName));
  }

  @Test
  public void resume() throws IOException {
    AnywhereCacheResume.anywhereCacheResume(
        AnywhereCacheName.format("_", bucket.getName(), cacheName));
  }

  @Test
  public void disable() throws IOException {
    AnywhereCacheDisable.anywhereCacheDisable(
        AnywhereCacheName.format("_", bucket.getName(), cacheName));
  }
}
