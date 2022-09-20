
# OpenapiClusterItem

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The ID of the cluster. | 
**projectId** | **String** | The ID of the project. | 
**name** | **String** | The name of the cluster. |  [optional]
**clusterType** | [**ClusterTypeEnum**](#ClusterTypeEnum) | The cluster type: - &#x60;\&quot;DEVELOPER\&quot;&#x60;: a [Developer Tier](https://docs.pingcap.com/tidbcloud/select-cluster-tier#developer-tier) cluster - &#x60;\&quot;DEDICATED\&quot;&#x60;: a [Dedicated Tier](https://docs.pingcap.com/tidbcloud/select-cluster-tier#dedicated-tier) cluster. |  [optional]
**cloudProvider** | [**CloudProviderEnum**](#CloudProviderEnum) | The cloud provider on which your TiDB cluster is hosted. - &#x60;\&quot;AWS\&quot;&#x60;: the Amazon Web Services cloud provider - &#x60;\&quot;GCP\&quot;&#x60;: the Google Cloud Platform cloud provider |  [optional]
**region** | **String** | Region of the cluster. |  [optional]
**createTimestamp** | **String** | The creation time of the cluster in Unix timestamp seconds (epoch time). |  [optional]
**config** | [**GetClustersOfProjectRespConfig**](GetClustersOfProjectRespConfig.md) |  |  [optional]
**status** | [**GetClustersOfProjectRespStatus**](GetClustersOfProjectRespStatus.md) |  |  [optional]


<a name="ClusterTypeEnum"></a>
## Enum: ClusterTypeEnum
Name | Value
---- | -----
DEDICATED | &quot;DEDICATED&quot;
DEVELOPER | &quot;DEVELOPER&quot;


<a name="CloudProviderEnum"></a>
## Enum: CloudProviderEnum
Name | Value
---- | -----
AWS | &quot;AWS&quot;
GCP | &quot;GCP&quot;



