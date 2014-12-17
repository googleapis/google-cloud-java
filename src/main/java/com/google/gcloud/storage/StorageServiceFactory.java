package com.google.gcloud.storage;



public abstract class StorageServiceFactory {

  private static final StorageServiceFactory INSTANCE = new StorageServiceFactory() {
      @Override
      public StorageService get(StorageServiceOptions options) {
        return new StorageServiceImpl(options);
      }
    };

  public static StorageService getDefault(StorageServiceOptions options) {
    return INSTANCE.get(options);
  }

  public abstract StorageService get(StorageServiceOptions options);
}
