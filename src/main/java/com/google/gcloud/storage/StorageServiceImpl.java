package com.google.gcloud.storage;

import com.google.api.services.storage.Storage;

final class StorageServiceImpl implements StorageService {

  private final StorageServiceOptions options;
  private final Storage storage;

  StorageServiceImpl(StorageServiceOptions options) {
    this.options = options;
    this.storage = options.getStorage();
  }

  @Override
  public Iterable<Bucket> listBuckets() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Bucket getBucket(String bucket) {
    // TODO Auto-generated method stub
    return null;
  }


}
