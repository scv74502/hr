package external

import com.fasterxml.jackson.annotation.JsonProperty

data class MinWagePerYearResponse(
    @JsonProperty("currentCount")
    var currentCount: Int? = null,

    @JsonProperty("data")
    var data: List<MinWagePerYear>? = null,
    var matchCount: Int? = null,

    @JsonProperty("page")
    var page: Int? = null,

    @JsonProperty("pageCount")
    var pageCount: Int? = null,

    @JsonProperty("totalCount")
    var totalCount: Int? = null,
)

data class MinWagePerYear(
    @JsonProperty("순번")
    var order: Int? = null,

    @JsonProperty("시간급")
    var wagePerHour: Int? = null,

    @JsonProperty("연도")
    var year: Int? = null,
)
