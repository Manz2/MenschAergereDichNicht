var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "60240",
        "ok": "12698",
        "ko": "47542"
    },
    "minResponseTime": {
        "total": "5",
        "ok": "5",
        "ko": "5"
    },
    "maxResponseTime": {
        "total": "42488",
        "ok": "39148",
        "ko": "42488"
    },
    "meanResponseTime": {
        "total": "10348",
        "ok": "2079",
        "ko": "12556"
    },
    "standardDeviation": {
        "total": "9647",
        "ok": "6083",
        "ko": "9215"
    },
    "percentiles1": {
        "total": "8957",
        "ok": "8",
        "ko": "11036"
    },
    "percentiles2": {
        "total": "17199",
        "ok": "10",
        "ko": "19957"
    },
    "percentiles3": {
        "total": "27587",
        "ok": "16417",
        "ko": "27806"
    },
    "percentiles4": {
        "total": "30254",
        "ok": "29621",
        "ko": "30386"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 10769,
    "percentage": 18
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 87,
    "percentage": 0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 1842,
    "percentage": 3
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 47542,
    "percentage": 79
},
    "meanNumberOfRequestsPerSecond": {
        "total": "352.281",
        "ok": "74.257",
        "ko": "278.023"
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
        "total": "30120",
        "ok": "5992",
        "ko": "24128"
    },
    "minResponseTime": {
        "total": "5",
        "ok": "6",
        "ko": "5"
    },
    "maxResponseTime": {
        "total": "42488",
        "ok": "39148",
        "ko": "42488"
    },
    "meanResponseTime": {
        "total": "11040",
        "ok": "1844",
        "ko": "13324"
    },
    "standardDeviation": {
        "total": "10305",
        "ok": "6368",
        "ko": "9812"
    },
    "percentiles1": {
        "total": "8644",
        "ok": "9",
        "ko": "11887"
    },
    "percentiles2": {
        "total": "19902",
        "ok": "10",
        "ko": "22388"
    },
    "percentiles3": {
        "total": "27966",
        "ok": "19085",
        "ko": "28137"
    },
    "percentiles4": {
        "total": "30957",
        "ok": "30684",
        "ko": "30958"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 5444,
    "percentage": 18
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
    "count": 548,
    "percentage": 2
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 24128,
    "percentage": 80
},
    "meanNumberOfRequestsPerSecond": {
        "total": "176.14",
        "ok": "35.041",
        "ko": "141.099"
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
        "total": "30120",
        "ok": "6706",
        "ko": "23414"
    },
    "minResponseTime": {
        "total": "5",
        "ok": "5",
        "ko": "5"
    },
    "maxResponseTime": {
        "total": "42273",
        "ok": "38024",
        "ko": "42273"
    },
    "meanResponseTime": {
        "total": "9655",
        "ok": "2288",
        "ko": "11765"
    },
    "standardDeviation": {
        "total": "8888",
        "ok": "5808",
        "ko": "8483"
    },
    "percentiles1": {
        "total": "9097",
        "ok": "8",
        "ko": "10779"
    },
    "percentiles2": {
        "total": "14894",
        "ok": "11",
        "ko": "17110"
    },
    "percentiles3": {
        "total": "26637",
        "ok": "15438",
        "ko": "27032"
    },
    "percentiles4": {
        "total": "29496",
        "ok": "28021",
        "ko": "29516"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 5325,
    "percentage": 18
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 87,
    "percentage": 0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 1294,
    "percentage": 4
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 23414,
    "percentage": 78
},
    "meanNumberOfRequestsPerSecond": {
        "total": "176.14",
        "ok": "39.216",
        "ko": "136.924"
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
