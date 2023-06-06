var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "60000",
        "ok": "59327",
        "ko": "673"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "2"
    },
    "maxResponseTime": {
        "total": "54731",
        "ok": "54731",
        "ko": "742"
    },
    "meanResponseTime": {
        "total": "1292",
        "ok": "1303",
        "ko": "312"
    },
    "standardDeviation": {
        "total": "1515",
        "ok": "1520",
        "ko": "254"
    },
    "percentiles1": {
        "total": "1114",
        "ok": "1123",
        "ko": "206"
    },
    "percentiles2": {
        "total": "1695",
        "ok": "1704",
        "ko": "562"
    },
    "percentiles3": {
        "total": "2622",
        "ok": "2628",
        "ko": "670"
    },
    "percentiles4": {
        "total": "3690",
        "ok": "3700",
        "ko": "705"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 19039,
    "percentage": 32
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 12931,
    "percentage": 22
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 27357,
    "percentage": 46
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 673,
    "percentage": 1
},
    "meanNumberOfRequestsPerSecond": {
        "total": "156.658",
        "ok": "154.901",
        "ko": "1.757"
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
        "total": "60000",
        "ok": "59327",
        "ko": "673"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "2"
    },
    "maxResponseTime": {
        "total": "54731",
        "ok": "54731",
        "ko": "742"
    },
    "meanResponseTime": {
        "total": "1292",
        "ok": "1303",
        "ko": "312"
    },
    "standardDeviation": {
        "total": "1515",
        "ok": "1520",
        "ko": "254"
    },
    "percentiles1": {
        "total": "1114",
        "ok": "1123",
        "ko": "206"
    },
    "percentiles2": {
        "total": "1695",
        "ok": "1704",
        "ko": "562"
    },
    "percentiles3": {
        "total": "2622",
        "ok": "2628",
        "ko": "670"
    },
    "percentiles4": {
        "total": "3690",
        "ok": "3700",
        "ko": "705"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 19039,
    "percentage": 32
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 12931,
    "percentage": 22
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 27357,
    "percentage": 46
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 673,
    "percentage": 1
},
    "meanNumberOfRequestsPerSecond": {
        "total": "156.658",
        "ok": "154.901",
        "ko": "1.757"
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
