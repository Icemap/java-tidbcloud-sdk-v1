
# Apiv1betaprojectsprojectIdclustersclusterIdConfig

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**components** | [**Apiv1betaprojectsprojectIdclustersclusterIdConfigComponents**](Apiv1betaprojectsprojectIdclustersclusterIdConfigComponents.md) |  |  [optional]
**paused** | **Boolean** | Flag that indicates whether the cluster is paused. &#x60;true&#x60; means to pause the cluster, and &#x60;false&#x60; means to resume the cluster. For more details, refer to [Pause or Resume a TiDB Cluster](https://docs.pingcap.com/tidbcloud/pause-or-resume-tidb-cluster).  **Limitations:**  - The cluster can be paused only when the &#x60;cluster_status&#x60; is &#x60;\&quot;AVAILABLE\&quot;&#x60;. - The cluster can be resumed only when the &#x60;cluster_status&#x60; is &#x60;\&quot;PAUSED\&quot;&#x60;. |  [optional]



