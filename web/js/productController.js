/**
 * 产品信息管理前端控制器
 */

/**
 * 删除产品信息
 */
function doDel(pid) {
    url = $("#url").val();
    if (confirm("确认删除？")) {
        $.ajax({
            type: "post",
            url: url,
            data: {
                pid: pid,
            },
            success: function (data) {
                if (data == "cg") {
                    $("#mes").html("删除成功！！");
                    window.location.href = "/pud?method=query";
                } else {
                    $("#mes").html("删除失败！！");
                }
            }

        });
    }
}

/**
 * 条件查询
 */
function queryProduct() {
    $("#productList").html("");
    var p_name = $("#P_NAME").val();
    var p_code = $("#P_CODE").val();
    //按条件查询
    $.ajax({
        type: "post",
        url: "/pud?method=queryProduct",
        data: {
            p_name: p_name,
            p_code: p_code
        },
        success(data) {
            var res = JSON.parse(data);
            var reslist;
            for (var i = 0; i < res.length; i++) {
                reslist += "<tr>" +
                    "<td>" + (i + 1) + "</td>" +
                    "<td>" + res[i].P_NAME + "</td>" +
                    "<td>" + res[i].P_CODE + "</td>" +
                    "<td>" + res[i].P_TYPE + "</td>" +
                    "<td>" + res[i].P_PRICE + "</td>" +
                    "<td>" + res[i].P_COUNT + "</td>" +
                    "<td>" + res[i].P_UNIT + "</td>" +
                    "<td>" + res[i].P_METERIAL + "</td>" +
                    "<td>" + res[i].P_TIME + "</td>" +
                    "<td>" + res[i].P_DESCRIPTION + "</td>" +
                    "<td>" +
                    "<a  class='btn-sm btn-success' href='/pud?method=toUpdate&pid=" + res[i].ID + "'>修改</a> "+
                    "<a  class='btn-sm btn-danger' onclick= 'doDel(" + res[i].ID + ")'>删除</a>" +
                    "</tr>";
            }
            $("#productList").html(reslist)
        }
    });
}
