package com.google.cloud.examples.compute.v1;

import com.google.api.core.ApiFuture;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.compute.v1.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Use gax-java and generated message type to List Addresses in a test GCP Compute project.
 */
public class ComputeExample {
  private static String PROJECT_NAME = "gapic-test";
  private static String REGION = "us-central1";

  public static void main(String[] args) {
    try {
      AddressClient addressClient = createCredentialedClient();
      runExampleWithGapicGen(addressClient);
      System.out.println("-------------------------------------------------------");
      runExampleWithGapicGenResourceName(addressClient);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static AddressClient createCredentialedClient() throws IOException {
    Credentials myCredentials = GoogleCredentials.getApplicationDefault();
    String myEndpoint = AddressSettings.getDefaultEndpoint();

    // Begin samplegen code. This combines the "customize credentials" and "customize the endpoint" samples.
    AddressSettings addressSettings =
        AddressSettings.newBuilder()
            .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
            .setTransportChannelProvider(
                AddressSettings.defaultHttpJsonTransportProviderBuilder()
                   .setEndpoint(myEndpoint).build()).build();
    AddressClient addressClient =
        AddressClient.create(addressSettings);
    // End samplegen code.

    return addressClient;
  }

  // A basic List Address example.
  private static void runExampleWithGapicGen(AddressClient client) {
    System.out.println("Running with Gapic Client.");
    AddressClient.ListAddressesPagedResponse listResponse = listAddresses(client);
    verifyListAddressWithGets(client, listResponse);
  }

  // Insert an address, and then delete the address. Use ResourceNames in the request objects.
  private static void runExampleWithGapicGenResourceName(AddressClient client) {
    System.out.println("Running with Gapic Client and Resource Name.");
    String newAddressName = "usseaparkview";
    System.out.println("Inserting address:");

    insertNewAddressJustClient(client, newAddressName);

    listAddresses(client);

    System.out.println("Deleting address:");
    Operation deleteResponse = client.deleteAddress(
        ProjectRegionAddressName.of(newAddressName, PROJECT_NAME, REGION));
    System.out.format("Result of delete: %s\n", deleteResponse.toString());
    int sleepTimeInSeconds = 3;
    System.out.format("Waiting %d seconds for server to update...\n", sleepTimeInSeconds);
    // Wait for the delete operation to finish on the server.
    try {
      TimeUnit.SECONDS.sleep(sleepTimeInSeconds);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    listAddresses(client);
  }

  private static void insertNewAddressJustClient(AddressClient client, String newAddressName) {
    // Begin samplegen code for insertAddress().
    Address newAddress = Address.newBuilder().setName(newAddressName).build();
    ProjectRegionName region = ProjectRegionName.of(PROJECT_NAME, REGION);
    Operation response = client.insertAddress(region, newAddress);
    // End samplegen code for insertAddress().
    System.out.format("Result of insert: %s\n", response.toString());
  }

  private static void insertNewAddressUsingRequest(AddressClient client, String newAddressName)
      throws InterruptedException, ExecutionException {
    // Begin samplegen code for insertAddress().
    ProjectRegionName region = ProjectRegionName.of(PROJECT_NAME, REGION);
    Address address = Address.newBuilder().build();
    InsertAddressHttpRequest request = InsertAddressHttpRequest.newBuilder()
        .setRegion(region.toString())
        .setAddressResource(address)
        .build();
    // Do something
    Operation response = client.insertAddress(request);

    // End samplegen code for insertAddress().
    System.out.format("Result of insert: %s\n", response.toString());
  }

  private static void insertAddressUsingCallable(AddressClient client, String newAddressName)
      throws InterruptedException, ExecutionException {
    // Begin samplegen code for insertAddress().
    ProjectRegionName region = ProjectRegionName.of(PROJECT_NAME, REGION);
    Address address = Address.newBuilder().build();
    InsertAddressHttpRequest request = InsertAddressHttpRequest.newBuilder()
        .setRegion(region.toString())
        .setAddressResource(address)
        .build();
    ApiFuture<Operation> future = client.insertAddressCallable().futureCall(request);
    // Do something
    Operation response = future.get();

    // End samplegen code for insertAddress().
    System.out.format("Result of insert: %s\n", response.toString());
  }

  private static AddressClient.ListAddressesPagedResponse listAddresses(AddressClient client) {
    System.out.println("Listing addresses:");
    ProjectRegionName regionName = ProjectRegionName.newBuilder().setRegion(REGION).setProject(PROJECT_NAME).build();
    ListAddressesHttpRequest listRequest = ListAddressesHttpRequest.newBuilder()
        .setRegion(regionName.toString())
        .build();
    AddressClient.ListAddressesPagedResponse response = client.listAddresses(listRequest);
    for (Address address : response.iterateAll()) {
      System.out.println("\t - " + address.toString());
    }
    return response;
  }

  private static void verifyListAddressWithGets(AddressClient client, AddressClient.ListAddressesPagedResponse listResponse) {
    for (Address address : listResponse.iterateAll()) {
      System.out.format("Making get request for address \"%s\"...\n", address.getName());
      Address fetchedAddress = client.getAddress(
          ProjectRegionAddressName.of(address.getName(), PROJECT_NAME, REGION));
      System.out.format("addresses.get returns \n\t%s\n\n", fetchedAddress.toString());
    }
  }
}