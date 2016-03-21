package com.google.gcloud.storage.contrib.nio;

import com.google.gcloud.spi.ServiceRpcFactory;
import com.google.gcloud.storage.Storage;
import com.google.gcloud.storage.StorageOptions;
import com.google.gcloud.storage.spi.StorageRpc;

/**
 * Helper for creating NIO file system instances without using the SPI.
 *
 * <p>There's no way to create perfect isolation between unit tests when using the Java SPI, because
 * it stores a list of loaded provider instances. We instead rely on integration tests to test our
 * usage of the SPI.
 */
final class NioTestHelper {

  // Within a unit test we use the same provider for multiple file systems. Having a different
  // provider instance causes the behavior of many operations, such as Files.copy, to change
  // dramatically.
  private final CloudStorageFileSystemProvider provider;

  NioTestHelper(StorageRpc storage) {
    this.provider = new CloudStorageFileSystemProvider(makeStorage(storage));
  }

  CloudStorageFileSystem forBucket(String bucket) {
    return forBucket(bucket, CloudStorageConfiguration.getDefault());
  }

  CloudStorageFileSystem forBucket(String bucket, CloudStorageConfiguration config) {
    return new CloudStorageFileSystem(provider, config, bucket);
  }

  private static Storage makeStorage(final StorageRpc storageRpc) {
    return StorageOptions.builder()
        .projectId("dummy-project-for-testing")
        .serviceRpcFactory(
          new ServiceRpcFactory<StorageRpc, StorageOptions>() {
            @Override
            public StorageRpc create(StorageOptions options) {
              return storageRpc;
            }
          })
        .build()
        .service();
  }

  static CloudStorageConfiguration stripPrefixSlash(boolean value) {
    return CloudStorageConfiguration.builder().stripPrefixSlash(value).build();
  }

  static CloudStorageConfiguration permitEmptyPathComponents(boolean value) {
    return CloudStorageConfiguration.builder().permitEmptyPathComponents(value).build();
  }

  static CloudStorageConfiguration workingDirectory(String value) {
    return CloudStorageConfiguration.builder().workingDirectory(value).build();
  }

  static CloudStorageConfiguration usePseudoDirectories(boolean value) {
    return CloudStorageConfiguration.builder().usePseudoDirectories(value).build();
  }
}
