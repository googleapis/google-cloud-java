package com.google.gcloud.datastore;


public class DatastoreServiceFactory {

  public static DatastoreService getDatastoreService(DatastoreServiceOptions options) {
    return new DatastoreServiceImpl(options);
  }
}
