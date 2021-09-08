<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>
<html lang="ko">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>DemoWeb Board</title>

    <jsp:include page="/WEB-INF/views/modules/common-css.jsp" />

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

		<jsp:include page="/WEB-INF/views/modules/sidebar.jsp" />
        
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

				<jsp:include page="/WEB-INF/views/modules/topbar.jsp" />

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">게시판</h1>
                    </div>

					<div class="card shadow mb-4">
                         <div class="card-header py-3">
                             <h6 class="m-0 font-weight-bold text-primary">글 쓰기</h6>
                         </div>
                         <div class="card-body">
                             <form>
                             	<div class="form-group">
                             		<label>제목</label>
                             		<input type="text" class="form-control" name="title">
                             	</div>
                             	<div class="form-group">
                             		<label>작성자</label>
                             		<input type="text" class="form-control" name="writer">
                             	</div>
                             	<div class="form-group">
                             		<label>내용</label>
                             		<textarea class="form-control" name="content" rows="5"></textarea>
                             	</div>
                             	<button class="btn btn-primary btn-sm">쓰기</button>
                             	<button class="btn btn-primary btn-sm">목록</button>
                             </form>	
                         </div>
                     </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

			<%@ include file="/WEB-INF/views/modules/footer.jsp" %>

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="/WEB-INF/views/modules/common-js.jsp" />

    <!-- Page level plugins -->
    <script src="/spring-demoweb2/resources/vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="/spring-demoweb2/resources/js/demo/chart-area-demo.js"></script>
    <script src="/spring-demoweb2/resources/js/demo/chart-pie-demo.js"></script>

</body>

</html>