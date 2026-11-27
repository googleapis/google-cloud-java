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

package com.google.cloud.storage.transfermanager;

import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.StorageException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

final class TransferManagerUtils {

  private TransferManagerUtils() {}

  static Path createAndValidateDestPath(ParallelDownloadConfig config, BlobInfo originalBlob) {
    Path targetDirectory = config.getDownloadDirectory().toAbsolutePath().normalize();
    Path newPath =
        targetDirectory
            .resolve(originalBlob.getName().replaceFirst(config.getStripPrefix(), ""))
            .normalize();

    // Verify the resolved path stays within the configured download directory.
    if (!newPath.startsWith(targetDirectory) || newPath.equals(targetDirectory)) {
      return null;
    }

    try {
      Path realTargetDir = Files.exists(targetDirectory) ? targetDirectory.toRealPath() : null;
      // Each relative component below the download directory must not be a symlink or resolve
      // outside the canonical download directory.
      Path current = targetDirectory;
      for (Path part : targetDirectory.relativize(newPath)) {
        current = current.resolve(part);
        if (Files.isSymbolicLink(current)) {
          return null;
        }
        if (realTargetDir != null
            && Files.exists(current, LinkOption.NOFOLLOW_LINKS)
            && !current.toRealPath().startsWith(realTargetDir)) {
          return null;
        }
      }

      Path parent = newPath.getParent();
      // Check existence (following links) so a symlinked download directory is accepted on JDK 8.
      if (!Files.exists(parent)) {
        Files.createDirectories(parent);
      }
      if (realTargetDir == null) {
        realTargetDir = targetDirectory.toRealPath();
      }
      // The canonical parent must remain under the canonical download directory.
      if (!parent.toRealPath().startsWith(realTargetDir)) {
        return null;
      }
      return newPath;
    } catch (IOException e) {
      throw new StorageException(e);
    }
  }
}
