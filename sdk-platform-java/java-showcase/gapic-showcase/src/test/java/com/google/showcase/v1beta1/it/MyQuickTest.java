package com.google.showcase.v1beta1.it;
import com.google.showcase.v1beta1.EchoSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.tracing.GoldenSignalsMetricsTracerFactory;
import com.google.showcase.v1beta1.stub.EchoStubSettings;
public class MyQuickTest {
  public static void main(String[] args) throws Exception {
    EchoSettings grpcEchoSettings = EchoSettings.newBuilder().build();
    EchoStubSettings echoStubSettings = (EchoStubSettings) grpcEchoSettings.getStubSettings().toBuilder().build();
    System.out.println("Metadata artifact = " + echoStubSettings.getLibraryMetadata().artifactName());
  }
}
