var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "30000",
        "ok": "15780",
        "ko": "14220"
    },
    "minResponseTime": {
        "total": "1",
        "ok": "37",
        "ko": "1"
    },
    "maxResponseTime": {
        "total": "541",
        "ok": "541",
        "ko": "382"
    },
    "meanResponseTime": {
        "total": "266",
        "ok": "206",
        "ko": "332"
    },
    "standardDeviation": {
        "total": "77",
        "ok": "33",
        "ko": "57"
    },
    "percentiles1": {
        "total": "258",
        "ok": "194",
        "ko": "341"
    },
    "percentiles2": {
        "total": "340",
        "ok": "221",
        "ko": "352"
    },
    "percentiles3": {
        "total": "360",
        "ok": "265",
        "ko": "364"
    },
    "percentiles4": {
        "total": "369",
        "ok": "279",
        "ko": "372"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 15780,
    "percentage": 53
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 14220,
    "percentage": 47
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1111.111",
        "ok": "584.444",
        "ko": "526.667"
    }
},
contents: {
"req_request-0-684d2": {
        type: "REQUEST",
        name: "request_0",
path: "request_0",
pathFormatted: "req_request-0-684d2",
stats: {
    "name": "request_0",
    "numberOfRequests": {
        "total": "30000",
        "ok": "15780",
        "ko": "14220"
    },
    "minResponseTime": {
        "total": "1",
        "ok": "37",
        "ko": "1"
    },
    "maxResponseTime": {
        "total": "541",
        "ok": "541",
        "ko": "382"
    },
    "meanResponseTime": {
        "total": "266",
        "ok": "206",
        "ko": "332"
    },
    "standardDeviation": {
        "total": "77",
        "ok": "33",
        "ko": "57"
    },
    "percentiles1": {
        "total": "258",
        "ok": "194",
        "ko": "341"
    },
    "percentiles2": {
        "total": "340",
        "ok": "221",
        "ko": "352"
    },
    "percentiles3": {
        "total": "360",
        "ok": "265",
        "ko": "364"
    },
    "percentiles4": {
        "total": "370",
        "ok": "279",
        "ko": "372"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 15780,
    "percentage": 53
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 14220,
    "percentage": 47
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1111.111",
        "ok": "584.444",
        "ko": "526.667"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
