function convertStatus(state) {
    var stateStr = state + "";
    if (stateStr.length == 0) {
        return "";
    }
    if (stateStr == "0") {
        return "启用";
    }
    if (stateStr == "1") {
        return "禁用";
    }
    if (stateStr == "2") {
        return "删除";
    }
}