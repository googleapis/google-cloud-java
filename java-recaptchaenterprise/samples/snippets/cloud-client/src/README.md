# Google Cloud reCAPTCHA Enterprise

<a href="https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-recaptchaenterprise&page=editor&open_in_editor=samples/snippets/cloud-client/src/README.md">
<img alt="Open in Cloud Shell" src ="http://gstatic.com/cloudssh/images/open-btn.png"></a>

Google [Cloud reCAPTCHA Enterprise](https://cloud.google.com/recaptcha-enterprise) defends your website against common 
web-based attacks like credential stuffing, account takeovers, and scraping and 
help prevent costly exploits from malicious human and automated actors. 
Just like reCAPTCHA v3, reCAPTCHA Enterprise will never interrupt your 
users with a challenge, so you can run it on all webpages where your customers interact with your services.

These sample Java applications demonstrate how to access the Cloud reCAPTCHA Enterprise API using the
Google Java API Client Libraries.

## Prerequisites

### Google Cloud Project

Set up a Google Cloud project with billing enabled.

### Enable the API

You must [enable the Google reCAPTCHA Enterprise API](https://console.cloud.google.com/flows/enableapi?apiid=recaptchaenterprise.googleapis.com) for your project in order to use these samples.

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

You must ensure that the [user account or service account](https://cloud.google.com/iam/docs/service-accounts#differences_between_a_service_account_and_a_user_account) you used to authorize your gcloud session has the proper permissions to edit reCAPTCHA resources for your project. In the Cloud Console under IAM, add the following roles (as needed) to the project whose service account you're using to test:

* reCAPTCHA Enterprise Agent
* reCAPTCHA Enterprise Admin
* reCAPTCHA Enterprise Viewer

More information can be found in the [Google reCAPTCHA Enterprise Docs](https://cloud.google.com/recaptcha-enterprise/docs/access-control).


## Build and Run

The following instructions will help you prepare your development environment.

1. Download and install the [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html).
   Verify that the [JAVA_HOME](https://docs.oracle.com/javase/8/docs/technotes/guides/troubleshoot/envvars001.html) environment variable is set and points to your JDK installation.


2. Download and install [Apache Maven](http://maven.apache.org/download.cgi) by following the [Maven installation guide](http://maven.apache.org/install.html) for your specific operating system.


3. Clone the java-recaptchaenterprise repository.
```
git clone https://github.com/googleapis/java-recaptchaenterprise.git
```

4. Navigate to the sample code directory.

```
cd java-recaptchaenterprise/samples/snippets/cloud-client/src
```

5. Run the **SnippetsIT** test file present under the test folder.

### Test Frameworks used
[Spring Boot module](https://spring.io/projects/spring-boot) from Spring Framework.

[Selenium](https://www.selenium.dev/).
