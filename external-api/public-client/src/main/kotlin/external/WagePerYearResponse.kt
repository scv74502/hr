package external

data class WagePerYearResponse(
    var currentCount: Int? = null,
    var data: List<WagePerYear>? = null,
    var matchCount: Int? = null,
    var page: Int? = null,
    var pageCount: Int? = null,
    var totalCount: Int? = null,
)
