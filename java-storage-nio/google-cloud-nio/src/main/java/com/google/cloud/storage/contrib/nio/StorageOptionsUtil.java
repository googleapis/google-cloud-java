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

package com.google.cloud.storage.contrib.nio;

import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.cloud.storage.StorageOptions;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

final class StorageOptionsUtil {
  static final String USER_AGENT_ENTRY_NAME = "gcloud-java-nio";
  static final String USER_AGENT_ENTRY_VERSION = getVersion();
  private static final String USER_AGENT_ENTRY =
      String.format("%s/%s", USER_AGENT_ENTRY_NAME, USER_AGENT_ENTRY_VERSION);
  private static final FixedHeaderProvider DEFAULT_HEADER_PROVIDER =
      FixedHeaderProvider.create("user-agent", USER_AGENT_ENTRY);

  private static final StorageOptions DEFAULT_STORAGE_OPTIONS_INSTANCE =
      StorageOptions.newBuilder().setHeaderProvider(DEFAULT_HEADER_PROVIDER).build();
  private static final FixedHeaderProvider EMTPY_HEADER_PROVIDER =
      FixedHeaderProvider.create(Collections.emptyMap());

  private StorageOptionsUtil() {}

  static StorageOptions getDefaultInstance() {
    return DEFAULT_STORAGE_OPTIONS_INSTANCE;
  }

  static StorageOptions mergeOptionsWithUserAgent(StorageOptions providedStorageOptions) {
    if (providedStorageOptions == DEFAULT_STORAGE_OPTIONS_INSTANCE) {
      return providedStorageOptions;
    }

    String userAgent = providedStorageOptions.getUserAgent();
    if (userAgent == null) {
      return nullSafeSet(providedStorageOptions, DEFAULT_HEADER_PROVIDER);
    } else {
      if (!userAgent.contains(USER_AGENT_ENTRY_NAME)) {
        HeaderProvider providedHeaderProvider = getHeaderProvider(providedStorageOptions);
        Map<String, String> newHeaders = new HashMap<>(providedHeaderProvider.getHeaders());
        newHeaders.put("user-agent", String.format("%s %s", userAgent, USER_AGENT_ENTRY));
        FixedHeaderProvider headerProvider =
            FixedHeaderProvider.create(ImmutableMap.copyOf(newHeaders));
        return nullSafeSet(providedStorageOptions, headerProvider);
      } else {
        return providedStorageOptions;
      }
    }
  }

  /**
   * Due to some complex interactions between init and mocking, it's possible that the builder
   * instance returned from {@link StorageOptions#toBuilder()} can be null. This utility method will
   * attempt to create the builder and set the new header provider. If however the builder instance
   * is null, the orignal options will be returned without setting the header provider.
   *
   * <p>Since this method is only every called by us trying to add our user-agent entry to the
   * headers this makes our attempt effectively a no-op, which is much better than failing customer
   * code.
   */
  private static StorageOptions nullSafeSet(
      StorageOptions storageOptions, HeaderProvider headerProvider) {
    StorageOptions.Builder builder = storageOptions.toBuilder();
    if (builder == null) {
      return storageOptions;
    } else {
      return builder.setHeaderProvider(headerProvider).build();
    }
  }

  /** Resolve the version of google-cloud-nio for inclusion in request meta-data */
  private static String getVersion() {
    // attempt to read the library's version from a properties file generated during the build
    // this value should be read and cached for later use
    String version = "";
    try (InputStream inputStream =
        CloudStorageFileSystemProvider.class.getResourceAsStream(
            "/META-INF/maven/com.google.cloud/google-cloud-nio/pom.properties")) {
      if (inputStream != null) {
        final Properties properties = new Properties();
        properties.load(inputStream);
        version = properties.getProperty("version");
      }
    } catch (IOException e) {
      // ignore
    }
    return version;
  }

  /**
   * {@link com.google.cloud.ServiceOptions} does not specify a getter for the headerProvider, so
   * instead merge with an empty provider.
   */
  @VisibleForTesting
  static HeaderProvider getHeaderProvider(StorageOptions options) {
    return options.getMergedHeaderProvider(EMTPY_HEADER_PROVIDER);
  }
}
