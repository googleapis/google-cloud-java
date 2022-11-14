# CBT Java Test Proxy

The CBT test proxy is intended for running confromance tests for Cloug Bigtable Java Client.

## Set up 

If you have not already done so, [install golang](https://go.dev/doc/install), then clone the go test library:

```
git clone https://github.com/googleapis/cloud-bigtable-clients-test.git
```

## Start test proxy

Build the proxy with the latest version of the client

```
cd java-bigtable/test-proxy
mvn clean install
```

Start the proxy on default port 9999

```
mvn exec:java -Dexec.mainClass=com.google.cloud.bigtable.testproxy.CbtTestProxyMain
```

Start the proxy on a different port

```
mvn exec:java -Dexec.mainClass=com.google.cloud.bigtable.testproxy.CbtTestProxyMain -Dport=1
```

Build and start the proxy with an older version of the client

```
mvn clean install -Dbigtable.client.version=<client_version> -Denforcer.skip
mvn exec:java -Dexec.mainClass=com.google.cloud.bigtable.testproxy.CbtTestProxyMain
```

## Run the test cases

```
cd cloud-bigtable-clients-test/tests
go test -v -proxy_addr=:9999
```
