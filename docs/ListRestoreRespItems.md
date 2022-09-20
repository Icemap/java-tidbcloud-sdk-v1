
# ListRestoreRespItems

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The ID of the restore task. |  [optional]
**createTimestamp** | [**DateTime**](DateTime.md) | The creation time of the backup in UTC.  The time format follows the [ISO8601](http://en.wikipedia.org/wiki/ISO_8601) standard, which is &#x60;YYYY-MM-DD&#x60; (year-month-day) + T +&#x60;HH:MM:SS&#x60; (hour-minutes-seconds) + Z. For example, &#x60;2020-01-01T00:00:00Z&#x60;. |  [optional]
**backupId** | **String** | The ID of the backup. |  [optional]
**clusterId** | **String** | The cluster ID of the backup. |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | The status of the restore task. |  [optional]
**cluster** | [**ListRestoreRespCluster**](ListRestoreRespCluster.md) |  |  [optional]
**errorMessage** | **String** | The error message of restore if failed. |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
PENDING | &quot;PENDING&quot;
RUNNING | &quot;RUNNING&quot;
FAILED | &quot;FAILED&quot;
SUCCESS | &quot;SUCCESS&quot;



