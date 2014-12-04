package com.google.gcloud.datastore;

import com.google.api.services.datastore.client.Datastore;
import com.google.api.services.datastore.client.DatastoreFactory;
import com.google.api.services.datastore.client.DatastoreOptions;
import com.google.api.services.datastore.client.LocalDevelopmentDatastoreFactory;


public interface DatastoreServiceFactory {

  enum Mode implements DatastoreServiceFactory {

    TESTING {

      @Override
      public DatastoreService get(DatastoreServiceOptions options) {
        DatastoreOptions dsOptions = new DatastoreOptions.Builder()
            .dataset(options.dataset())
            .host(options.host())
            .build();
        Datastore datastore = LocalDevelopmentDatastoreFactory.get().create(dsOptions);
        return new DatastoreServiceImpl(options, datastore);
      }
    },

    PROD {
      @Override
      public DatastoreService get(DatastoreServiceOptions options) {
        DatastoreOptions dsOptions = options.toDatastoreOptions();
        Datastore datastore = DatastoreFactory.get().create(dsOptions);
        return new DatastoreServiceImpl(options, datastore);
      }
    };
  }

  DatastoreService get(DatastoreServiceOptions options);
}
