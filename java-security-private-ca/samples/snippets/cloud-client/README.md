# Google Cloud Private Certificate Authority Service

<a href="https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-security-private-ca&page=editor&open_in_editor=samples/snippets/cloud-client/README.md">
<img alt="Open in Cloud Shell" src ="http://gstatic.com/cloudssh/images/open-btn.png"></a>

Google [Cloud Private Certificate Authority Service](https://cloud.google.com/certificate-authority-service) is a highly available, scalable Google Cloud service that enables you to simplify, automate, and customize the deployment, management, and security of private certificate authorities (CA).

These sample Java applications demonstrate how to access the Cloud CA API using the
Google Java API Client Libraries.

## Prerequisites

### Google Cloud Project

Set up a Google Cloud project with billing enabled.

### Enable the API

You must [enable the Google Private Certificate Authority Service API](https://console.cloud.google.com/flows/enableapi?apiid=privateca.googleapis.com) for your project in order to use these samples.

### Service account

A service account with private key credentials is required to create signed bearer tokens.
Create a [service account](https://console.cloud.google.com/iam-admin/serviceaccounts/create) and download the credentials file as JSON.

### Set Environment Variables

You must set your project ID and service account credentials in order to run the tests.

```
$ export GOOGLE_CLOUD_PROJECT="<google-project-id-here>"
$ export GOOGLE_APPLICATION_CREDENTIALS="<path-to-service-account-credentials-file>"
```

### Grant Permissions

You must ensure that the [user account or service account](https://cloud.google.com/iam/docs/service-accounts#differences_between_a_service_account_and_a_user_account) you used to authorize your gcloud session has the proper permissions to edit Private CA resources for your project. In the Cloud Console under IAM, add the following roles to the project whose service account you're using to test:

* Cloud CA Service Admin
* Cloud CA Service Certificate Requester
* Cloud CA Service Certificate Manager  
* Cloud CA Service Certificate Template User
* Cloud CA Service Workload Certificate Requester  
* Cloud CA Service Operation Manager  
* Cloud CA Service Auditor

More information can be found in the [Google Private Certificate Authority Service Docs](https://cloud.google.com/certificate-authority-service/docs/reference/permissions-and-roles).


## Build and Run

The following instructions will help you prepare your development environment.

1. Download and install the [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html). 
   Verify that the [JAVA_HOME](https://docs.oracle.com/javase/8/docs/technotes/guides/troubleshoot/envvars001.html) environment variable is set and points to your JDK installation.


2. Download and install [Apache Maven](http://maven.apache.org/download.cgi) by following the [Maven installation guide](http://maven.apache.org/install.html) for your specific operating system.


3. Clone the java-security-private-ca repository.
```
git clone https://github.com/googleapis/java-security-private-ca.git
```

4. Navigate to the sample code directory.

```
cd java-security-private-ca/samples/snippets/cloud-client
```

5. Run the **SnippetsIT** test file present under the test folder.

### Crypto frameworks 
[Bouncy Castle](https://www.bouncycastle.org/documentation.html) cryptographic framework is used as a part of testing.
