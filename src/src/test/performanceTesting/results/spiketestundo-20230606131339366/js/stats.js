var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "20000",
        "ok": "435",
        "ko": "19565"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "956",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "20346",
        "ok": "11867",
        "ko": "20346"
    },
    "meanResponseTime": {
        "total": "8898",
        "ok": "8286",
        "ko": "8911"
    },
    "standardDeviation": {
        "total": "7151",
        "ok": "2602",
        "ko": "7219"
    },
    "percentiles1": {
        "total": "7212",
        "ok": "9301",
        "ko": "6917"
    },
    "percentiles2": {
        "total": "15813",
        "ok": "10068",
        "ko": "15895"
    },
    "percentiles3": {
        "total": "19498",
        "ok": "11050",
        "ko": "19515"
    },
    "percentiles4": {
        "total": "20155",
        "ok": "11787",
        "ko": "20155"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 12,
    "percentage": 0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 423,
    "percentage": 2
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 19565,
    "percentage": 98
},
    "meanNumberOfRequestsPerSecond": {
        "total": "512.821",
        "ok": "11.154",
        "ko": "501.667"
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
        "total": "10000",
        "ok": "435",
        "ko": "9565"
    },
    "minResponseTime": {
        "total": "956",
        "ok": "956",
        "ko": "8708"
    },
    "maxResponseTime": {
        "total": "20346",
        "ok": "11867",
        "ko": "20346"
    },
    "meanResponseTime": {
        "total": "15470",
        "ok": "8286",
        "ko": "15797"
    },
    "standardDeviation": {
        "total": "3220",
        "ok": "2602",
        "ko": "2842"
    },
    "percentiles1": {
        "total": "15808",
        "ok": "9301",
        "ko": "15927"
    },
    "percentiles2": {
        "total": "18161",
        "ok": "10068",
        "ko": "18333"
    },
    "percentiles3": {
        "total": "19871",
        "ok": "11050",
        "ko": "19872"
    },
    "percentiles4": {
        "total": "20264",
        "ok": "11787",
        "ko": "20266"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 12,
    "percentage": 0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 423,
    "percentage": 4
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 9565,
    "percentage": 96
},
    "meanNumberOfRequestsPerSecond": {
        "total": "256.41",
        "ok": "11.154",
        "ko": "245.256"
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
        "total": "10000",
        "ok": "0",
        "ko": "10000"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "-",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "8260",
        "ok": "-",
        "ko": "8260"
    },
    "meanResponseTime": {
        "total": "2325",
        "ok": "-",
        "ko": "2325"
    },
    "standardDeviation": {
        "total": "2343",
        "ok": "-",
        "ko": "2343"
    },
    "percentiles1": {
        "total": "1922",
        "ok": "-",
        "ko": "1921"
    },
    "percentiles2": {
        "total": "4396",
        "ok": "-",
        "ko": "4386"
    },
    "percentiles3": {
        "total": "6233",
        "ok": "-",
        "ko": "6234"
    },
    "percentiles4": {
        "total": "7352",
        "ok": "-",
        "ko": "7352"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 0,
    "percentage": 0
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
    "count": 10000,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "256.41",
        "ok": "-",
        "ko": "256.41"
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
