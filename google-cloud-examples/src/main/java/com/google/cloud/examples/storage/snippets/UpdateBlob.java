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

/*
 * EDITING INSTRUCTIONS
 * This file is referenced in READMEs and javadoc. Any change to this file should be reflected in
 * the project's READMEs and package-info.java.
 */

package com.google.cloud.examples.storage.snippets;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/**
 * A snippet for Google Cloud Storage showing how to update the blob's content if the blob exists.
 */
public class UpdateBlob {

  public static void main(String... args) throws IOException {
    Storage storage = StorageOptions.getDefaultInstance().getService();
    BlobId blobId = BlobId.of("bucket", "blob_name");
    Blob blob = storage.get(blobId);
    if (blob != null) {
      byte[] prevContent = blob.getContent();
      System.out.println(new String(prevContent, UTF_8));
      WritableByteChannel channel = blob.writer();
      channel.write(ByteBuffer.wrap("Updated content".getBytes(UTF_8)));
      channel.close();
    }
  }
}
