package com.google.gcloud.datastore;


public class DatastoreServiceFactory {

  public DatastoreService getDatastoreService(DatastoreServiceOptions options) {
    return new DatastoreServiceImpl(options);
  }
}
