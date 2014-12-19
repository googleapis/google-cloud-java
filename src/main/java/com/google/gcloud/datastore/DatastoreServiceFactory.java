package com.google.gcloud.datastore;



public abstract class DatastoreServiceFactory {

  private static final DatastoreServiceFactory INSTANCE = new DatastoreServiceFactory() {
      @Override
      public DatastoreService get(DatastoreServiceOptions options) {
        return new DatastoreServiceImpl(options, options.datastore());
      }
    };

  public static DatastoreService getDefault(DatastoreServiceOptions options) {
    return INSTANCE.get(options);
  }

  public abstract DatastoreService get(DatastoreServiceOptions options);
}
