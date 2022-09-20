
# OpenapiClusterConfig

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**rootPassword** | **String** | The root password to access the cluster. It must be 8-64 characters. | 
**port** | **Integer** | The TiDB port for connection. The port must be in the range of 1024-65535 except 10080.  **Limitations**: - For a Developer Tier cluster, only port &#x60;4000&#x60; is available. |  [optional]
**components** | [**Apiv1betaprojectsprojectIdclustersConfigComponents**](Apiv1betaprojectsprojectIdclustersConfigComponents.md) |  |  [optional]
**ipAccessList** | [**List&lt;Apiv1betaprojectsprojectIdclustersConfigIpAccessList&gt;**](Apiv1betaprojectsprojectIdclustersConfigIpAccessList.md) | A list of IP addresses and Classless Inter-Domain Routing (CIDR) addresses that are allowed to access the TiDB Cloud cluster via [standard connection](https://docs.pingcap.com/tidbcloud/connect-to-tidb-cluster#connect-via-standard-connection). |  [optional]



