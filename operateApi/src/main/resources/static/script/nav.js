$(function () {
    createNav();
});

var urlList = [{
    "url": "#", "name": "基础配置内容", "child": [
        {"url": "env.html", "name": "环境配置"},
        {"url": "affiliation.html", "name": "归属配置"},
        {"url": "domain.html", "name": "服务器归属区域"},
        {"url": "os.html", "name": "服务器操作系统管理"},
        {"url": "label.html", "name": "标签键值对管理"}]
}, {"url": "host.html", "name": "服务器主机配置", "child": []}];

function createNav() {
    var navList = "";
    navList += "<div class=\"container-fluid\">";
    navList += "  <div class=\"navbar-header\">";
    navList += "    <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-6\" aria-expanded=\"false\">";
    navList += "      <span class=\"sr-only\">Toggle navigation</span>";
    navList += "      <span class=\"icon-bar\"></span>";
    navList += "      <span class=\"icon-bar\"></span>";
    navList += "      <span class=\"icon-bar\"></span>";
    navList += "    </button>";
    navList += "    <a class=\"navbar-brand\" href=\"javascript:void(0);\">连连运维维护系统</a>";
    navList += "  </div>";
    navList += "  <div class=\"collapse navbar-collapse\">";
    navList += "    <ul class=\"nav navbar-nav\">";
    navList += "      <li><a href=\"#\">主页</a></li>";

    var url = window.location.href;
    if (url.indexOf("?") > 0) {
        url = url.substr(0, url.indexOf("?"))
    }
    if (url.indexOf("#") > 0) {
        url = url.substr(0, url.indexOf("#"))
    }
    var pageurl = url.substr(url.lastIndexOf("/") + 1);
    $(urlList).each(function (index, element) {
        var active = "";
        if ($(element)[0].url != "#" && $(element)[0].url == pageurl) {
            active = " class=\"active\"";
        }
        if ($($(element)[0].child).length > 0) {
            var childActive = "";
            var child = "";
            $($(element)[0].child).each(function (index2, element2) {
                var active2 = "";
                if ($(element2)[0].url != "#" && $(element2)[0].url == pageurl) {
                    active2 = " class=\"active\"";
                    childActive = " active";
                }
                child += "    <li" + active2 + "><a href=\"" + $(element2)[0].url + "\">" + $(element2)[0].name + "</a></li>";
            });
            var beforeChild = "<li class=\"dropdown" + childActive + "\">";
            beforeChild += "  <a href=\"" + $(element)[0].url + "\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">" + $(element)[0].name + "<span class=\"caret\"></span></a>";
            beforeChild += "  <ul class=\"dropdown-menu\">";
            child = beforeChild + child;
            child += "  </ul>";
            child += "</li>";
            navList += child;
        } else {
            navList += "      <li" + active + "><a href=\"" + $(element)[0].url + "\">" + $(element)[0].name + "</a></li>";
        }
    });
    navList += "    </ul>";
    navList += "  </div>";
    navList += "</div>";

    $("#nav-link").html(navList);
}