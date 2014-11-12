package com.google.gcloud.datastore;


public interface DatastoreServiceFactory {

  DatastoreService getDatastoreService(DatastoreServiceOptions options);
}
