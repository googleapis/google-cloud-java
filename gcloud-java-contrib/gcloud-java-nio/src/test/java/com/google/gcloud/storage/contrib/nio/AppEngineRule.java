package com.google.gcloud.storage.contrib.nio;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import org.junit.rules.ExternalResource;

import java.io.IOException;

/** JUnit rule for App Engine testing environment. */
public final class AppEngineRule extends ExternalResource {

  private LocalServiceTestHelper helper;

  @Override
  protected void before() throws IOException {
    helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
    helper.setUp();
  }

  @Override
  protected void after() {
    helper.tearDown();
  }
}
