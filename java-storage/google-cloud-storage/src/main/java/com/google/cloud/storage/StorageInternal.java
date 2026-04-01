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

import com.google.cloud.storage.Storage.ComposeRequest;
import com.google.cloud.storage.UnifiedOpts.ObjectSourceOpt;
import com.google.cloud.storage.UnifiedOpts.ObjectTargetOpt;
import com.google.cloud.storage.UnifiedOpts.Opts;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Path;

interface StorageInternal {

  default BlobInfo internalCreateFrom(Path path, BlobInfo info, Opts<ObjectTargetOpt> opts)
      throws IOException {
    throw new UnsupportedOperationException("not implemented");
  }

  default BlobInfo internalDirectUpload(BlobInfo info, Opts<ObjectTargetOpt> opts, ByteBuffer buf) {
    throw new UnsupportedOperationException("not implemented");
  }

  // Void to allow easier mapping/use within streams and other mapping contexts
  @SuppressWarnings("UnusedReturnValue")
  default Void internalObjectDelete(BlobId id, Opts<ObjectSourceOpt> opts) {
    throw new UnsupportedOperationException("not implemented");
  }

  default BlobInfo compose(ComposeRequest composeRequest) {
    throw new UnsupportedOperationException("not implemented");
  }

  default BlobInfo internalObjectGet(BlobId blobId, Opts<ObjectSourceOpt> opts) {
    throw new UnsupportedOperationException("not implemented");
  }
}
