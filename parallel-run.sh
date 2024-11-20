#!/bin/bash
set -e

ALL_LIBRARIES=accessapproval,accesscontextmanager,admanager,advisorynotifications,aiplatform,alloydb,alloydb-connectors,analytics-admin,analytics-data,analyticshub,api-gateway,apigee-connect,apigee-registry,apihub,apikeys,appengine-admin,apphub,area120-tables,artifact-registry,asset,assured-workloads,automl,backupdr,bare-metal-solution,batch,beyondcorp-appconnections,beyondcorp-appconnectors,beyondcorp-appgateways,beyondcorp-clientconnectorservices,beyondcorp-clientgateways,biglake,bigquery-data-exchange,bigqueryconnection,bigquerydatapolicy,bigquerydatatransfer,bigquerymigration,bigqueryreservation,billing,billingbudgets,binary-authorization,certificate-manager,channel,chat,cloudbuild,cloudcommerceconsumerprocurement,cloudcontrolspartner,cloudquotas,cloudsupport,compute,confidentialcomputing,connectgateway,contact-center-insights,container,containeranalysis,contentwarehouse,data-fusion,datacatalog,dataflow,dataform,datalabeling,datalineage,dataplex,dataproc,dataproc-metastore,datastream,debugger-client,deploy,developerconnect,dialogflow,dialogflow-cx,discoveryengine,distributedcloudedge,dlp,dms,document-ai,domains,edgenetwork,enterpriseknowledgegraph,errorreporting,essential-contacts,eventarc,eventarc-publishing,filestore,functions,gdchardwaremanagement,gke-backup,gke-connect-gateway,gke-multi-cloud,gkehub,grafeas,gsuite-addons,iam,iam-admin,iamcredentials,iap,ids,infra-manager,iot,kms,kmsinventory,language,life-sciences,managed-identities,managedkafka,maps-addressvalidation,maps-area-insights,maps-fleetengine,maps-fleetengine-delivery,maps-mapsplatformdatasets,maps-places,maps-routeoptimization,maps-routing,maps-solar,marketingplatformadminapi,mediatranslation,meet,memcache,migrationcenter,monitoring,monitoring-dashboards,monitoring-metricsscope,netapp,network-management,network-security,networkconnectivity,networkservices,notebooks,optimization,oracledatabase,orchestration-airflow,orgpolicy,os-config,os-login,parallelstore,phishingprotection,policy-troubleshooter,policysimulator,private-catalog,privilegedaccessmanager,profiler,publicca,rapidmigrationassessment,recaptchaenterprise,recommendations-ai,recommender,redis,redis-cluster,resource-settings,resourcemanager,retail,run,scheduler,secretmanager,securesourcemanager,security-private-ca,securitycenter,securitycenter-settings,securitycentermanagement,securityposture,service-control,service-management,service-usage,servicedirectory,servicehealth,shell,shopping-css,shopping-merchant-accounts,shopping-merchant-conversions,shopping-merchant-datasources,shopping-merchant-inventories,shopping-merchant-lfp,shopping-merchant-products,shopping-merchant-promotions,shopping-merchant-quota,shopping-merchant-reports,speech,storage-transfer,storageinsights,talent,tasks,telcoautomation,texttospeech,tpu,trace,translate,video-intelligence,video-live-stream,video-stitcher,video-transcoder,vision,visionai,vmmigration,vmwareengine,vpcaccess,webrisk,websecurityscanner,workflow-executions,workflows,workspaceevents,workstations
workspace_name="/workspace"
IFS=, read -r -a array <<< "${ALL_LIBRARIES}"
mkdir -p logs
library_names=""
count=0
for a_library in "${array[@]}"; do
  library_names="${library_names},${a_library}"
  count=$((count + 1))
  if [[ $((count % 20)) -eq 0 ]]; then
    time docker run \
       --rm \
       -u "$(id -u):$(id -g)" \
       -v "$(pwd):${workspace_name}" \
       -v "$(pwd)/../apis:${workspace_name}/apis" \
       local:latest \
       --library-names="${library_names}" \
       --api-definitions-path="${workspace_name}/apis" > "$(pwd)/logs/${count}.log" 2>&1 &
    library_names=""
  fi
done

# generate the remaining libraries.
time docker run \
   --rm \
   -u "$(id -u):$(id -g)" \
   -v "$(pwd):${workspace_name}" \
   -v "$(pwd)/../apis:${workspace_name}/apis" \
   local:latest \
   --library-names="${library_names}" \
   --api-definitions-path="${workspace_name}/apis" > "$(pwd)/logs/${count}.log" 2>&1 &