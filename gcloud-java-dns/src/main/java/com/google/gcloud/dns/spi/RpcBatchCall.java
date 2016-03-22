package com.google.gcloud.dns.spi;

import com.google.api.client.googleapis.batch.json.JsonBatchCallback;
import com.google.gcloud.dns.DnsBatch;

import java.util.Map;

/**
 * A container for the Cloud DNS calls to be made within a batch.
 */
public class RpcBatchCall {

  private DnsBatch.Request request;
  private JsonBatchCallback callback;
  private Map<DnsRpc.Option, ?> options;

  public RpcBatchCall(DnsBatch.Request request, JsonBatchCallback callback,
      Map<DnsRpc.Option, ?> options) {
    this.request = request;
    this.callback = callback;
    this.options = options;
  }

  DnsBatch.Request request() {
    return request;
  }

  JsonBatchCallback callback() {
    return callback;
  }

  Map<DnsRpc.Option, ?> options() {
    return options;
  }
}
