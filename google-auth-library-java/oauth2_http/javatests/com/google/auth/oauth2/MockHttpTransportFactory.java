package com.google.auth.oauth2;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.auth.http.HttpTransportFactory;

public class MockHttpTransportFactory implements HttpTransportFactory {

  MockHttpTransport transport = new MockHttpTransport();

  @Override
  public HttpTransport create() {
    return transport;
  }
}
