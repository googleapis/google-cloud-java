package com.google.gcloud.storage;

public interface StorageService {

  Iterable<Bucket> listBuckets();

  Bucket getBucket(String bucket);
}
