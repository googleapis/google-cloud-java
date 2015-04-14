/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.storage;

import com.google.gcloud.Service;

import java.nio.ByteBuffer;
import java.util.Iterator;

public interface StorageService extends Service<StorageServiceOptions> {

  // todo: consider what to do with predefinedAcl

  // todo: consider supplying create/update/delete options (varargs) for
  // ifGenerationMatch, ifGenerationNotMatch, ifMetagenerationMatch,
  // ifMetagenerationNotMatch, ifSourceGenerationMatch, ifSourceGenerationNotMatch
  // ifSourceMetagenerationMatch and ifSourceMetagenerationNotMatch

  // todo: provide way for construct signed URLs - https://cloud.google.com/storage/docs/access-control#Signed-URLs

  Bucket create(Bucket bucket);

  Blob create(Blob blob, ByteBuffer content);

  Bucket get(String bucket);

  Blob get(String bucket, String blob);

  Iterator<Bucket> list();

  Iterator<Blob> list(String bucket, ListOptions settings);

  Bucket update(Bucket bucket);

  Blob update(Blob blob);

  void delete(Bucket bucket);

  void delete(Blob blob);

  Blob compose(Bucket bucket, Iterable<String> src, Blob dest);

  Blob copy(Blob src, Blob dest);

  BlobReadChannel readFrom(Blob blob); // todo: consider returning Blob

  BlobWriteChannel writeTo(Blob blob); // todo: consider returning Blob
}
