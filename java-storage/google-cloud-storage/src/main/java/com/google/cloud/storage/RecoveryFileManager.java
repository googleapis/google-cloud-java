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

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.collect.ImmutableList;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

final class RecoveryFileManager {

  private final ImmutableList<RecoveryVolume> volumes;

  /** Keep track of active info and file */
  private final Map<BlobInfo, RecoveryFile> files;

  private final HashFunction hashFunction;

  /**
   * Round-robin assign recovery files to the configured volumes. Use this index to keep track of
   * which volume to assign to next.
   */
  private int nextVolumeIndex;

  private RecoveryFileManager(List<RecoveryVolume> volumes) {
    this.volumes = ImmutableList.copyOf(volumes);
    this.files = Collections.synchronizedMap(new HashMap<>());
    this.nextVolumeIndex = 0;
    this.hashFunction = Hashing.goodFastHash(64);
  }

  @SuppressWarnings("UnstableApiUsage")
  public RecoveryFile newRecoveryFile(BlobInfo info) {
    int i = getNextVolumeIndex();
    RecoveryVolume v = volumes.get(i);
    UUID uuid = UUID.randomUUID();
    String string = uuid.toString();
    Hasher hasher = hashFunction.newHasher();
    HashCode hash = hasher.putString(string, StandardCharsets.UTF_8).hash();
    String fileName = Base64.getUrlEncoder().encodeToString(hash.asBytes());
    Path path = v.basePath.resolve(fileName);
    RecoveryFile recoveryFile = new RecoveryFile(path, v.sink, () -> files.remove(info));
    files.put(info, recoveryFile);
    return recoveryFile;
  }

  private synchronized int getNextVolumeIndex() {
    return nextVolumeIndex = (nextVolumeIndex + 1) % volumes.size();
  }

  static RecoveryFileManager of(List<Path> volumes) throws IOException {
    return of(volumes, p -> ThroughputSink.nullSink());
  }

  static RecoveryFileManager of(List<Path> volumes, RecoveryVolumeSinkFactory factory)
      throws IOException {
    checkArgument(!volumes.isEmpty(), "At least one volume must be specified");
    checkArgument(
        volumes.stream().allMatch(p -> !Files.exists(p) || Files.isDirectory(p)),
        "All provided volumes must either:\n1. Not yet exists\n2. Be directories");

    for (Path v : volumes) {
      if (!Files.exists(v)) {
        Files.createDirectories(v);
      }
    }
    ImmutableList<RecoveryVolume> recoveryVolumes =
        volumes.stream()
            .map(p -> RecoveryVolume.of(p, factory.apply(p)))
            .collect(ImmutableList.toImmutableList());
    return new RecoveryFileManager(recoveryVolumes);
  }

  @FunctionalInterface
  interface RecoveryVolumeSinkFactory {
    ThroughputSink apply(Path p);
  }

  static final class RecoveryVolume {
    private final Path basePath;
    private final ThroughputSink sink;

    private RecoveryVolume(Path basePath, ThroughputSink sink) {
      this.basePath = basePath;
      this.sink = sink;
    }

    public static RecoveryVolume of(Path basePath, ThroughputSink sink) {
      return new RecoveryVolume(basePath, sink);
    }
  }
}
