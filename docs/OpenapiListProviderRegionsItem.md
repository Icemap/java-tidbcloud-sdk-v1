
# OpenapiListProviderRegionsItem

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**clusterType** | [**ClusterTypeEnum**](#ClusterTypeEnum) | The cluster type. - &#x60;\&quot;DEVELOPER\&quot;&#x60;: a [Developer Tier](https://docs.pingcap.com/tidbcloud/select-cluster-tier#developer-tier) cluster - &#x60;\&quot;DEDICATED\&quot;&#x60;: a [Dedicated Tier](https://docs.pingcap.com/tidbcloud/select-cluster-tier#dedicated-tier) cluster |  [optional]
**cloudProvider** | [**CloudProviderEnum**](#CloudProviderEnum) | The cloud provider on which your TiDB cluster is hosted. - &#x60;\&quot;AWS\&quot;&#x60;: the Amazon Web Services cloud provider - &#x60;\&quot;GCP\&quot;&#x60;: the Google Cloud Platform cloud provider |  [optional]
**region** | **String** | The region in which your TiDB cluster is hosted.  For the detailed information on each region, refer to the documentation of the corresponding cloud provider ([AWS](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-regions-availability-zones.html) | [GCP](https://cloud.google.com/about/locations#americas)).  For example, &#x60;\&quot;us-west-2\&quot;&#x60; refers to Oregon for AWS. |  [optional]
**tidb** | [**List&lt;GetProviderRegionsRespTidb&gt;**](GetProviderRegionsRespTidb.md) | The list of TiDB specifications in the region. |  [optional]
**tikv** | [**List&lt;GetProviderRegionsRespTikv&gt;**](GetProviderRegionsRespTikv.md) | The list of TiKV specifications in the region. |  [optional]
**tiflash** | [**List&lt;GetProviderRegionsRespTiflash&gt;**](GetProviderRegionsRespTiflash.md) | The list of TiFlash specifications in the region. |  [optional]


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



