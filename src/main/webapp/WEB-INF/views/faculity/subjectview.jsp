<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>


<body>
    <div class="content-wrapper" style="min-height: 976px;">
        <!-- Content Header (Page header) -->
        <section class="content-header">
        <h1>
            Subject View <small>과목별 내용을 보는 중 입니다.</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="list"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Subject</li>
        </ol>
        </section>

        <!-- Main content -->
        <section class="content">
        <hr />
        <div class="row">
            <div class="col-md-6">
                <form method="post" id="inputForm">
                    <!-- Text input-->



                    <div class="form-group">
                        <label class=" control-label">번호</label> <input id="pcourse" name="subno" type="text" placeholder="번호"
                            value="${subjectVO.subno}" class="form-control"
                            readonly="readonly">
                    </div>

                    <div class="form-group">
                        <label class=" control-label">과목명</label> <input id="pcourse"
                            name="subname" type="text" placeholder="과목명"
                            value="${subjectVO.subname}" class="form-control" readonly="">
                       
                    </div>

                    <div class="form-group">
                        <label class=" control-label">등급</label> <input
                            id="pcontent" name="subgrade" type="text" placeholder="등급"
                            value="${subjectVO.subgrade}" class="form-control" readonly="">
                       
                    </div>

        

                    <button type="button" class="btn btn-success" id="btnSuccess">success</button>
                    <button type="button" class="btn btn-success" id="btnModify">Modify</button>
                    <button type="button" class="btn btn-danger" id="btnRemove">Remove</button>
                    <button type="button" class="btn btn-warning" id="btnCancel">Cancel</button>
                </form>

            </div>
        </div>
        </section>
    </div>


</body>

<%@include file="footer.jsp"%>



<script>
    $(document).ready(function() {
        $("#btnSuccess").hide();
        
        
        $("#btnModify").on("click", function() {
            console.log("변경잼");
            $("#btnSuccess").show();
            $("#btnModify").hide();
            $("#btnRemove").hide();
            $("#inputForm div input").attr("readonly", false).submit();
            $("#pcourse").attr("readonly", true).submit();
        });

        $("#btnSuccess").on("click", function() {
            $("#inputForm").attr("action", "subjectmodify").submit();
        });

        $("#btnRemove").on("click", function() {
            if (confirm("정말삭제하시겠습니까?") == true) {

                $("#inputForm").attr("action", "subjectremove").submit();
            } else {
                return;
            }
        });

        $("#btnCancel").on("click", function() {
            event.preventDefault();
            history.back(1);
        });

    });
</script>

</html>