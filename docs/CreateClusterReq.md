
# CreateClusterReq

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** | The name of the cluster. The name must be 4-64 characters that can only include numbers, letters, and hyphens, and the first and last character must be a letter or number. | 
**clusterType** | [**ClusterTypeEnum**](#ClusterTypeEnum) | The cluster type. - &#x60;\&quot;DEVELOPER\&quot;&#x60;: create a [Developer Tier](https://docs.pingcap.com/tidbcloud/select-cluster-tier#developer-tier) cluster - &#x60;\&quot;DEDICATED\&quot;&#x60;: create a [Dedicated Tier](https://docs.pingcap.com/tidbcloud/select-cluster-tier#dedicated-tier) cluster. Before creating a Dedicated Tier cluster, you must [set a Project CIDR](https://docs.pingcap.com/tidbcloud/set-up-vpc-peering-connections#prerequisite-set-a-project-cidr) on [TiDB Cloud console](https://tidbcloud.com/). | 
**cloudProvider** | [**CloudProviderEnum**](#CloudProviderEnum) | The cloud provider on which your TiDB cluster is hosted. - &#x60;\&quot;AWS\&quot;&#x60;: the Amazon Web Services cloud provider - &#x60;\&quot;GCP\&quot;&#x60;: the Google Cloud Platform cloud provider | 
**region** | **String** | The region value should match the cloud provider&#39;s region code. You can get the complete list of available regions from the response of [List the cloud providers, regions and available specifications](#tag/Cluster/operation/ListProviderRegions).  For the detailed information on each region, refer to the documentation of the corresponding cloud provider ([AWS](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-regions-availability-zones.html) | [GCP](https://cloud.google.com/about/locations#americas)).  For example, if you want to deploy the cluster in the Oregon region for AWS, set the value to &#x60;\&quot;us-west-2\&quot;&#x60;. | 
**config** | [**Apiv1betaprojectsprojectIdclustersConfig**](Apiv1betaprojectsprojectIdclustersConfig.md) |  |  [optional]


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



