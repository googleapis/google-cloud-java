package com.google.cloud.examples.compute.v1;

import com.google.api.core.ApiFuture;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.compute.v1.Address;
import com.google.cloud.compute.v1.AddressClient;
import com.google.cloud.compute.v1.AddressSettings;
import com.google.cloud.compute.v1.InsertAddressHttpRequest;
import com.google.cloud.compute.v1.ListAddressesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectRegionAddressName;
import com.google.cloud.compute.v1.ProjectRegionName;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/** Working example code to make live calls on Addresses resources in a GCP Compute project. */
public class ComputeExample {

  // Replace the following String values with your Project and Region ids.
  private static String PROJECT_NAME = "my-project-id";
  private static String REGION = "us-central1";

  /**
   * List addresses, Insert an address, and then delete the address. Use ResourceNames in the
   * request objects.
   */
  public static void main(String[] args) throws IOException {
    AddressClient client = createCredentialedClient();

    System.out.println("Running with Gapic Client.");
    AddressClient.ListAddressesPagedResponse listResponse = listAddresses(client);
    verifyListAddressWithGets(client, listResponse);

    System.out.println("Running with Gapic Client and Resource Name.");
    String newAddressName = "new_address_name";
    System.out.println("Inserting address:");

    insertNewAddressJustClient(client, newAddressName);

    listAddresses(client);

    System.out.println("Deleting address:");
    Operation deleteResponse =
        client.deleteAddress(ProjectRegionAddressName.of(newAddressName, PROJECT_NAME, REGION));
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

  private static AddressClient createCredentialedClient() throws IOException {
    Credentials myCredentials = GoogleCredentials.getApplicationDefault();
    String myEndpoint = AddressSettings.getDefaultEndpoint();

    AddressSettings addressSettings =
        AddressSettings.newBuilder()
            .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
            .setTransportChannelProvider(
                AddressSettings.defaultHttpJsonTransportProviderBuilder()
                    .setEndpoint(myEndpoint)
                    .build())
            .build();
    return AddressClient.create(addressSettings);
  }

  private static void insertNewAddressJustClient(AddressClient client, String newAddressName) {
    // Begin samplegen code for insertAddress().
    Address newAddress = Address.newBuilder().setName(newAddressName).build();
    ProjectRegionName region = ProjectRegionName.of(PROJECT_NAME, REGION);
    Operation response = client.insertAddress(region, newAddress);
    // End samplegen code for insertAddress().
    System.out.format("Result of insert: %s\n", response.toString());
  }

  /** Use an InsertAddressHttpRequest object to make an addresses.insert method call. */
  private static void insertNewAddressUsingRequest(AddressClient client, String newAddressName)
      throws InterruptedException, ExecutionException {
    // Begin samplegen code for insertAddress().
    ProjectRegionName region = ProjectRegionName.of(PROJECT_NAME, REGION);
    Address address = Address.newBuilder().build();
    InsertAddressHttpRequest request =
        InsertAddressHttpRequest.newBuilder()
            .setRegion(region.toString())
            .setAddressResource(address)
            .build();
    // Do something
    Operation response = client.insertAddress(request);

    // End samplegen code for insertAddress().
    System.out.format("Result of insert: %s\n", response.toString());
  }

  /** Use an callable object to make an addresses.insert method call. */
  private static void insertAddressUsingCallable(AddressClient client, String newAddressName)
      throws InterruptedException, ExecutionException {
    // Begin samplegen code for insertAddress().
    ProjectRegionName region = ProjectRegionName.of(PROJECT_NAME, REGION);
    Address address = Address.newBuilder().build();
    InsertAddressHttpRequest request =
        InsertAddressHttpRequest.newBuilder()
            .setRegion(region.toString())
            .setAddressResource(address)
            .build();
    ApiFuture<Operation> future = client.insertAddressCallable().futureCall(request);
    // Do something
    Operation response = future.get();

    // End samplegen code for insertAddress().
    System.out.format("Result of insert: %s\n", response.toString());
  }

  /** List Addresses in the under the project PROJECT_NAME and region REGION. */
  private static AddressClient.ListAddressesPagedResponse listAddresses(AddressClient client) {
    System.out.println("Listing addresses:");
    ProjectRegionName regionName =
        ProjectRegionName.newBuilder().setRegion(REGION).setProject(PROJECT_NAME).build();
    ListAddressesHttpRequest listRequest =
        ListAddressesHttpRequest.newBuilder().setRegion(regionName.toString()).build();
    AddressClient.ListAddressesPagedResponse response = client.listAddresses(listRequest);
    for (Address address : response.iterateAll()) {
      System.out.println("\t - " + address.toString());
    }
    return response;
  }

  private static void verifyListAddressWithGets(
      AddressClient client, AddressClient.ListAddressesPagedResponse listResponse) {
    for (Address address : listResponse.iterateAll()) {
      System.out.format("Making get request for address \"%s\"...\n", address.getName());
      Address fetchedAddress =
          client.getAddress(ProjectRegionAddressName.of(address.getName(), PROJECT_NAME, REGION));
      System.out.format("addresses.get returns \n\t%s\n\n", fetchedAddress.toString());
    }
  }
}
