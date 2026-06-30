/*
 * Copyright 2021 Google LLC
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

import com.google.cloud.storage.Conversions.Decoder;
import com.google.cloud.storage.Retrying.RetrierWithAlg;
import com.google.cloud.storage.spi.v1.StorageRpc;
import java.net.URL;
import java.util.Map;
import java.util.function.Supplier;

final class ResumableMedia {

  static Supplier<String> startUploadForBlobInfo(
      final HttpStorageOptions storageOptions,
      final BlobInfo blob,
      final Map<StorageRpc.Option, ?> optionsMap,
      final RetrierWithAlg retrier) {
    return () ->
        retrier.run(
            () ->
                storageOptions
                    .getStorageRpcV1()
                    .open(Conversions.json().blobInfo().encode(blob), optionsMap),
            Decoder.identity());
  }

  static Supplier<String> startUploadForSignedUrl(
      final HttpStorageOptions storageOptions, final URL signedURL, final RetrierWithAlg retrier) {
    if (!isValidSignedURL(signedURL.getQuery())) {
      throw new StorageException(2, "invalid signedURL");
    }
    return () ->
        retrier.run(
            () -> storageOptions.getStorageRpcV1().open(signedURL.toString()), Decoder.identity());
  }

  static GapicMediaSession gapic() {
    return GapicMediaSession.INSTANCE;
  }

  static HttpMediaSession http() {
    return HttpMediaSession.INSTANCE;
  }

  private static boolean isValidSignedURL(String signedURLQuery) {
    boolean isValid = true;
    if (signedURLQuery.startsWith("X-Goog-Algorithm=")) {
      if (!signedURLQuery.contains("&X-Goog-Credential=")
          || !signedURLQuery.contains("&X-Goog-Date=")
          || !signedURLQuery.contains("&X-Goog-Expires=")
          || !signedURLQuery.contains("&X-Goog-SignedHeaders=")
          || !signedURLQuery.contains("&X-Goog-Signature=")) {
        isValid = false;
      }
    } else if (signedURLQuery.startsWith("GoogleAccessId=")) {
      if (!signedURLQuery.contains("&Expires=") || !signedURLQuery.contains("&Signature=")) {
        isValid = false;
      }
    } else {
      isValid = false;
    }
    return isValid;
  }

  static final class GapicMediaSession {
    private static final GapicMediaSession INSTANCE = new GapicMediaSession();

    private GapicMediaSession() {}

    GapicUploadSessionBuilder write() {
      return GapicUploadSessionBuilder.create();
    }

    GapicDownloadSessionBuilder read() {
      return GapicDownloadSessionBuilder.create();
    }
  }

  static final class HttpMediaSession {
    private static final HttpMediaSession INSTANCE = new HttpMediaSession();

    private HttpMediaSession() {}

    HttpUploadSessionBuilder write() {
      return HttpUploadSessionBuilder.create();
    }

    HttpDownloadSessionBuilder read() {
      return HttpDownloadSessionBuilder.create();
    }
  }
}
