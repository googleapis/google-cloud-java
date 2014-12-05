package com.google.gcloud.datastore;

import com.google.api.services.datastore.client.Datastore;
import com.google.api.services.datastore.client.DatastoreFactory;
import com.google.api.services.datastore.client.DatastoreOptions;


public abstract class DatastoreServiceFactory {

  private static final DatastoreServiceFactory INSTANCE = new DatastoreServiceFactory() {
      @Override
      public DatastoreService get(DatastoreServiceOptions options) {
        DatastoreOptions dsOptions = options.toDatastoreOptions();
        Datastore datastore = DatastoreFactory.get().create(dsOptions);
        return new DatastoreServiceImpl(options, datastore);
      }
    };

  public static DatastoreService getDefault(DatastoreServiceOptions options) {
    return INSTANCE.get(options);
  }

  public abstract DatastoreService get(DatastoreServiceOptions options);
}
