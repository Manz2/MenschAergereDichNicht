var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "24240",
        "ok": "17394",
        "ko": "6846"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "1601",
        "ok": "1601",
        "ko": "113"
    },
    "meanResponseTime": {
        "total": "313",
        "ok": "434",
        "ko": "4"
    },
    "standardDeviation": {
        "total": "395",
        "ok": "406",
        "ko": "4"
    },
    "percentiles1": {
        "total": "112",
        "ok": "158",
        "ko": "3"
    },
    "percentiles2": {
        "total": "716",
        "ok": "830",
        "ko": "5"
    },
    "percentiles3": {
        "total": "1083",
        "ok": "1131",
        "ko": "8"
    },
    "percentiles4": {
        "total": "1339",
        "ok": "1370",
        "ko": "18"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 12520,
    "percentage": 52
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 4317,
    "percentage": 18
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 557,
    "percentage": 2
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 6846,
    "percentage": 28
},
    "meanNumberOfRequestsPerSecond": {
        "total": "198.689",
        "ok": "142.574",
        "ko": "56.115"
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
        "total": "12120",
        "ok": "7636",
        "ko": "4484"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "102",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "1601",
        "ok": "1601",
        "ko": "113"
    },
    "meanResponseTime": {
        "total": "402",
        "ok": "636",
        "ko": "4"
    },
    "standardDeviation": {
        "total": "447",
        "ok": "412",
        "ko": "5"
    },
    "percentiles1": {
        "total": "112",
        "ok": "779",
        "ko": "3"
    },
    "percentiles2": {
        "total": "845",
        "ok": "948",
        "ko": "4"
    },
    "percentiles3": {
        "total": "1147",
        "ok": "1216",
        "ko": "8"
    },
    "percentiles4": {
        "total": "1374",
        "ok": "1415",
        "ko": "18"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 4057,
    "percentage": 33
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 3156,
    "percentage": 26
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 423,
    "percentage": 3
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 4484,
    "percentage": 37
},
    "meanNumberOfRequestsPerSecond": {
        "total": "99.344",
        "ok": "62.59",
        "ko": "36.754"
    }
}
    },"req_request-1-46da4": {
        type: "REQUEST",
        name: "request_1",
path: "request_1",
pathFormatted: "req_request-1-46da4",
stats: {
    "name": "request_1",
    "numberOfRequests": {
        "total": "12120",
        "ok": "9758",
        "ko": "2362"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "1"
    },
    "maxResponseTime": {
        "total": "1584",
        "ok": "1584",
        "ko": "23"
    },
    "meanResponseTime": {
        "total": "223",
        "ok": "276",
        "ko": "4"
    },
    "standardDeviation": {
        "total": "309",
        "ok": "323",
        "ko": "3"
    },
    "percentiles1": {
        "total": "113",
        "ok": "128",
        "ko": "4"
    },
    "percentiles2": {
        "total": "174",
        "ok": "207",
        "ko": "5"
    },
    "percentiles3": {
        "total": "970",
        "ok": "1001",
        "ko": "8"
    },
    "percentiles4": {
        "total": "1216",
        "ok": "1266",
        "ko": "13"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 8463,
    "percentage": 70
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 1161,
    "percentage": 10
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 134,
    "percentage": 1
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 2362,
    "percentage": 19
},
    "meanNumberOfRequestsPerSecond": {
        "total": "99.344",
        "ok": "79.984",
        "ko": "19.361"
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
